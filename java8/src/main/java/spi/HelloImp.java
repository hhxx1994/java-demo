package spi;

public class HelloImp implements SpiDemoInterface {
	@Override
	public void say() {
		System.out.println("Hello");
	}
}
