package spi;

public class WorldImp implements SpiDemoInterface {
	@Override
	public void say() {
		System.out.println("World");
	}
}
