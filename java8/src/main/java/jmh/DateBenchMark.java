package jmh;

import org.joda.time.DateTime;
import org.openjdk.jmh.annotations.*;

import java.util.Calendar;

public class DateBenchMark {

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@Warmup(iterations = 3,time = 1)
	@Measurement(iterations = 3,time = 1)
	public Calendar runCalendar() {
		return Calendar.getInstance();
	}


	@Benchmark
	public DateTime runJoda() {
		return new DateTime();
	}


	@Benchmark
	public long runSystem() {
		return System.currentTimeMillis();
	}

}