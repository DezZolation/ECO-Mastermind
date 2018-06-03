package ecor.bsupply;

import ecor.bsupply.BareMetalBattery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.net.ConnectException;

public class VirtualBareMetalBattery implements BareMetalBattery {
	
	private int supply;
	private HashMap<String, Integer> virtualResourceSupply;
	private HashMap<String, Integer> peakResourceDemand;
	private HashMap<String, Integer> providedResources;
	private Socket socket;
	private BufferedReader input;
	private PrintWriter output;
	
	public VirtualBareMetalBattery() {

		virtualResourceSupply = new HashMap<>();
		peakResourceDemand = new HashMap<>();
		providedResources = new HashMap<>();

		//TODO: now first initialize peak and provided maps with values from the code

		boolean connected = false;
		while(!connected)
		{
			try{
				socket = new Socket("127.0.0.1", 9042);
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output = new PrintWriter(socket.getOutputStream(), true);
				connected = true;
			}
			catch(ConnectException e){
				System.out.println("No server. Retrying...");
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		try {
			// Loop over all demanded resources and send them to the server
			Iterator i = peakResourceDemand.entrySet().iterator();
			while(i.hasNext())
			{
				Map.Entry pair = (Map.Entry)i.next();
				output.println("peak " + pair.getKey() + " " + pair.getValue().toString());
				i.remove();
			}

			// Loop over all provided resources and send them to the server
			i = providedResources.entrySet().iterator();
			while(i.hasNext())
			{
				Map.Entry pair = (Map.Entry)i.next();
				output.println("provided " + pair.getKey() + " " + pair.getValue().toString());
				i.remove();
			}
		} catch(Exception e){
			System.out.println(e);
		}

		// While we have nothing yet, set power to 100
		setVirtualResourceSupply("power", 100);

		// Signal the server that all the initialization steps have been completed and the process will accept new udpates now
		Runnable runner = new BatteryRunner(input, output, this);
		new Thread(runner).start();

		System.out.println("Initialization done. Starting process");
	}
	public HashMap<String, Integer> getPeakResourceDemand()
	{
		return peakResourceDemand;
	}

	public HashMap<String, Integer> getProvidedResources()
	{
		return providedResources;
	}

	public void setVirtualResourceSupply(String resource, int supply)
	{
		virtualResourceSupply.put(resource, supply);
	}

	/**
	 * @param resource The resource that needs to be provided
	 * @return an integer of the virtual supply of the resource
	 */
	public int getResourceSupply(String resource)
	{
		// Return the stored resource supply
		if(virtualResourceSupply.containsKey(resource))
		{
			return virtualResourceSupply.get(resource);
		}

		// If no supply is stored, we're going to request it from the server.
		// In the meantime we will return 0
		output.println("resource " + resource);

		return 0;
	}
	
	// Now because this is a test and this function is used by eco's compiler, we will just return the first entry of the supplied resources
	public int getRemainingCapacity()
	{
		if(virtualResourceSupply.isEmpty())
		{
			return 0;
		}
		Map.Entry<String,Integer> entry = virtualResourceSupply.entrySet().iterator().next();
		String key = entry.getKey();
		return getResourceSupply(key);
	}

}
