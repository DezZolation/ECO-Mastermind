package ecor.tsupply;

public class TemperatureSupply {
	private static TemperatureSupply sharedSupply = null;
	
	public static TemperatureSupply sharedSupply() {
		if (sharedSupply == null) {
			sharedSupply = new TemperatureSupply();
		}
		return sharedSupply;
	}
	
	private BareMetalTemperature bareMetalTemperature;
	
	protected TemperatureSupply() {
		bareMetalTemperature = new VEMBareMetalTemperature();
	}
	
	public int getCurrentTemperature() {
		return bareMetalTemperature.getCurrentTemperature();
	}
	
}
