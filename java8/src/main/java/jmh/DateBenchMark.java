package jmh;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Calendar;

public class DateBenchMark {

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@Warmup(iterations = 3,time = 1)
	@Measurement(iterations = 3,time = 1)
	@Threads(8)
	@Fork(2)
	public Calendar runCalendar() {
		return Calendar.getInstance();
	}



	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(DateBenchMark.class.getSimpleName())
				.build();

		new Runner(opt).run();
	}

}