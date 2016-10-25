package streamstuff;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import school.Student;

public class StreamExample {
	public static void main(String[] args) {
		List<Student> roster = Arrays.asList(Student.ofNameGpaCourses("Fred", 3.8F, "Math", "Physics"),
				Student.ofNameGpaCourses("Shiela", 3.9F, "Math", "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Susan", 2.9F, "Math", "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Jim", 2.8F, "Art"),
				Student.ofNameGpaCourses("William", 2.9F, "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Alison", 3.6F, "Math", "Organic Chemistry"));
		
		Predicate<Student> smart = s -> s.getGpa() > 3.0F;
		Predicate<Student> keen = s-> s.getCourses().size() > 2;
		
		roster.stream()
		.filter(smart.and(keen))
//		.filter(((Predicate<Student>)(s -> s.getGpa() > 3.0F)).and(s-> s.getCourses().size() > 2))
//		.filter(s-> s.getCourses().size() > 2)
		.map(s -> s.getName() + " gpa is " + s.getGpa())
		.forEach(s-> System.out.println("Smart student is: " + s));
	}
}
