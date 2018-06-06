package ecor.bsupply;

public class BatterySupply {
	private static BatterySupply sharedSupply = null;
	
	public static BatterySupply sharedSupply() {
		if (sharedSupply == null) {
			sharedSupply = new BatterySupply();
		}
		return sharedSupply;
	}
	
	private BareMetalBattery bareMetalBattery;
	
	protected BatterySupply() {
		bareMetalBattery = new VirtualBareMetalBattery();
	}
	
	public int getRemainingCapacity() {
		return bareMetalBattery.getRemainingCapacity();
	}

	public void provide(String resource, int amount)
	{
		bareMetalBattery.provide(resource, amount);
	}

	public void peak(String resource, int amount)
	{
		bareMetalBattery.peak(resource, amount);
	}
}
