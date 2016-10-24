package school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//interface Criterion<E> {
//	boolean test(E s);
//}

public class School {
	public static <E> List<E> getSubList(Iterable<E> ls, Predicate<E> criterion) {
		List<E> rv = new ArrayList<>();
		for (E s : ls) {
			if (criterion.test(s)) {
				rv.add(s);
			}
		}
		return rv;
	}
	

//	public static <E> List<E> getSubList(Iterable<E> ls, Criterion<E> criterion) {
//		List<E> rv = new ArrayList<>();
//		for (E s : ls) {
//			if (criterion.test(s)) {
//				rv.add(s);
//			}
//		}
//		return rv;
//	}
//	
//	public static List<Student> getSmartStudents(List<Student> ls, float threshold) {
//		List<Student> rv = new ArrayList<>();
//		for (Student s : ls) {
//			if (s.getGpa() > threshold) {
//				rv.add(s);
//			}
//		}
//		return rv;
//	}

	public static void main(String[] args) {
		List<Student> roster = Arrays.asList(
				Student.ofNameGpaCourses("Fred", 3.8F, "Math", "Physics"),
				Student.ofNameGpaCourses("Shiela", 3.9F, "Math", "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Jim", 2.8F, "Art"),
				Student.ofNameGpaCourses("William", 2.9F, "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Alison", 3.6F, "Math", "Organic Chemistry")
				);
		
		System.out.println("> " + roster);
		roster.sort(Student.getNameComparator());	
		System.out.println("By name> " + roster);
		roster.sort(Student.getGpaComparator());	
		System.out.println("By gpa> " + roster);
		roster.sort(Student.getEnthusiamComparator());	
		System.out.println("By enthusiasm> " + roster);
		
//		System.out.println("Smart students: " + getSmartStudents(roster, 2.8F));
//		System.out.println("Enthusiastic students: " + getEnthusiasticStudents(roster, 2));
		System.out.println("Smart students: " 
				+ getSubList(roster, s -> s.getGpa() > 3.0F));
		System.out.println("Enthusiastic students: " 
				+ getSubList(roster, (Student s) -> s.getCourses().size() > 2));

		
		List<String> texts = Arrays.asList("Banana", "Orange", "Pea", "Melon", "Aardvark");
		System.out.println("Long strings: " + getSubList(texts, s -> s.length() > 5));
	}
}
