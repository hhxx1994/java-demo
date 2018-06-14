package spi;

import org.junit.Test;

import java.util.ServiceLoader;

public class SpiTest {

	@Test
	public void spiTest(){
		ServiceLoader<SpiDemoInterface> load = ServiceLoader.load(SpiDemoInterface.class);
		load.iterator().forEachRemaining(SpiDemoInterface::say);
	}
}
