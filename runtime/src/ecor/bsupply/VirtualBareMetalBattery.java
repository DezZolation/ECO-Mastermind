package ecor.bsupply;

import ecor.bsupply.BareMetalBattery;

public class VirtualBareMetalBattery implements BareMetalBattery {
	
	public int getRemainingCapacity()
	{
		return 100;
	};

}
