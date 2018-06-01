package ecor.bsupply;

import ecor.bsupply.BareMetalBattery;

public class VirtualBareMetalBattery implements BareMetalBattery {
	
	private int supply;
	
	public VirtualBareMetalBattery {
		// socket stuff
		while(true)
		{
			// keep watching the socket
			// server may update supply
			
			
			// Server may request RUM
			
			// Returns:
			
			// Provided Resources:
			// String Resource Name || int amount
			// Water 				|| 2
			
			// Required Resources:
			// String Resource Name || int amount
			// Power				|| 42 (Watts per hour)
			
			// Provided resources
			// Stirng 
			
		}
		
	}
	
	
	public int getRemainingCapacity()
	{
		return supply;
	};

}
