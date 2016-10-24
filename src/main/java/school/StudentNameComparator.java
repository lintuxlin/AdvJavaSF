package school;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

	public int compare(Student o1, Student o2) {
		System.out.println("external...");
		return o1.getName().compareTo(o2.getName());
	}

}
