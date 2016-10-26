package streamstuff;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

class AverageInProgress {
	private double total;
	private long count;
	
	public void include(double d) {
		total += d;
		count++;
	}
	
	public void merge(AverageInProgress other) {
		total += other.total;
		count += other.count;
	}
	
	public double getAverage() {
		return total / count;
	}

	@Override
	public String toString() {
		return "AverageInProgress [total=" + total + ", count=" + count + ", average)=" + getAverage() + "]";
	}
}

public class AverageingCollect {

	public static void main(String[] args) {
		long start = System.nanoTime();
		AverageInProgress av = Stream.generate(() -> ThreadLocalRandom.current().nextDouble())
				.parallel()
				.unordered()
				.limit(500_000_000L)
//		.collect(()->new AverageInProgress(), (a, i) -> a.include(i), (a1, a2) -> a1.merge(a2));
		.collect(AverageInProgress::new, AverageInProgress::include, AverageInProgress::merge);
		long end = System.nanoTime();
		System.out.println(av + "\nTime was: " + (end - start)/1_000_000);
	}

}
