package streamstuff;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import school.Student;

public class StreamExample {
	public static String getAsGrade(float gpa) {
		if (gpa < 2.85) return "D";
		if (gpa < 2.95) return "C";
		if (gpa < 3.75) return "B";
		return "A";
	}
	
	public static void main(String[] args) {
		List<Student> roster = Arrays.asList(Student.ofNameGpaCourses("Fred", 3.8F, "Math", "Physics"),
				Student.ofNameGpaCourses("Shiela", 3.9F, "Math", "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Susan", 2.9F, "Math", "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Jim", 2.8F, "Art"),
				Student.ofNameGpaCourses("William", 2.9F, "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Sally", 2.8F, "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Alice", 3.6F, "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Alison", 3.6F, "Math", "Organic Chemistry"));
		
		Predicate<Student> smart = s -> s.getGpa() > 3.0F;
		Predicate<Student> keen = s-> s.getCourses().size() > 2;
		
		roster.stream()
		.filter(smart.and(keen))
//		.filter(((Predicate<Student>)(s -> s.getGpa() > 3.0F)).and(s-> s.getCourses().size() > 2))
//		.filter(s-> s.getCourses().size() > 2)
		.map(s -> s.getName() + " gpa is " + s.getGpa())
		.forEach(s-> System.out.println("Smart student is: " + s));
		
//		boolean result = 
		roster.stream()
		.peek(s -> System.out.println(s))
		.allMatch(s -> s.getGpa() < 5.0)
//		.forEach(s->System.out.println(">>>" + s))
		;
		
//		System.out.println("result is " + result);
				
		Optional<Student> opt = roster.stream()
	    .findAny();
		
		opt.ifPresent(s -> System.out.println("Found a student " + s));

		System.out.println("-------------");
		
		Optional<Student> opt2 = roster.stream()
				.filter(s -> s.getGpa() > 5.0F)
			    .findAny();
				
		opt2.ifPresent(s -> System.out.println("Found a student " + s));

		System.out.println("-------------");

		// DO NOT DO THIS -- concurrency prohibits access to "shared/external" data!!!!
		Set<String> seen = new HashSet<>();	
		roster.stream()
			.flatMap(s -> s.getCourses().stream())
			.filter(s -> seen.add(s))
			.forEach(s -> System.out.println("> " + s));
		
		System.out.println("-------------");

		roster.stream()
			.flatMap(s -> s.getCourses().stream())
			.distinct()
			.sorted()
			.forEach(s -> System.out.println("> " + s));
		System.out.println("-------------");

		Map<String, List<Student>> table = roster.stream()
			.collect(Collectors.groupingBy(s -> getAsGrade(s.getGpa())));
		
//		Consumer<Map.Entry<String, List<Student>>> process = (e) -> {
//			System.out.println("Students with grade " + e.getKey());
//			e.getValue().forEach(s -> System.out.println(" - " + s.getName()));
//		};
//		table.entrySet().forEach(process);
		table.entrySet().forEach((e) -> {
			System.out.println("Students with grade " + e.getKey());
			e.getValue().forEach(s -> System.out.println(" - " + s.getName()));
		});
		System.out.println("-------------");

		Map<String, Long> table2 = roster.stream()
			.collect(Collectors.groupingBy(s -> getAsGrade(s.getGpa()), 
					Collectors.counting()));
		
		table2.entrySet().forEach(
				(e) -> System.out.printf("There are %d students with grade %s\n", 
						e.getValue(), e.getKey()));

	}
}
