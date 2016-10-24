package school;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class School {

	public static void main(String[] args) {
		List<Student> roster = Arrays.asList(
				Student.ofNameGpaCourses("Fred", 3.8F, "Math", "Physics"),
				Student.ofNameGpaCourses("Shiela", 3.9F, "Math", "Physics", "Chemistry"),
				Student.ofNameGpaCourses("Jim", 2.8F, "Art")
				);
		
		System.out.println("> " + roster);
		roster.sort(Student.getNameComparator());	
		System.out.println("> " + roster);
	}

}
