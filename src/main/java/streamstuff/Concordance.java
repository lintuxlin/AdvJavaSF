package streamstuff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {

	public static void main(String[] args) {
		// List l
		// l.parallelStream()..... 
		try (Stream<String> input = Files.lines(Paths.get("PrideAndPrejudice.txt"))){
			input
//			.parallel() // not very helpful in this case
//			.unordered() // usually important for throughput
			.sequential() // last one of parallel and sequential "wins"
			.flatMap(s -> Stream.of(s.split("\\W+")))
			.filter(s -> s.length() > 0)
			.map(s -> s.toLowerCase())
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet().stream()
//			.sorted((a,b) -> b.getValue().compareTo(a.getValue()))
			.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
			.limit(200)
			.forEach(e -> System.out.printf("%20s : %5d\n", e.getKey(), e.getValue()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
