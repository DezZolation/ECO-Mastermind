package ecor.bsupply;

public interface BareMetalBattery {
	
	int getRemainingCapacity();

	void provide(String resource, int amount);

	void peak(String resource, int amount);

}
