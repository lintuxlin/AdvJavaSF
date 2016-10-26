package streamstuff;

import java.util.stream.IntStream;

public class SimpleReduce {

	public static void main(String[] args) {
		int sum = IntStream.iterate(1, x -> x + 1)
		.limit(10)
		.reduce(0, (a,b) -> a + b);
		System.out.println("sum is " + sum);
	}

}
