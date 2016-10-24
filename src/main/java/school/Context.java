package school;

import java.util.Comparator;

// DOESN'T DO ANYTHING!!
// Just illustrations of the importance of context for lambda expressions
interface MaxOfCourses {
	int getMaxCourseCount(Student s1, Student s2);
}

public class Context {
	public static void doStuff(Comparator<Student> cs) {
	}
	
	public static void doStuff(MaxOfCourses moc) {
	}
	
	public void doStuff() {
		Student s1 = null;
		Student s2 = null;
		
		Comparator<Student> c1 = (o1, o2) -> o1.getName().compareTo(o2.getName());
		c1 = (o1, o2) -> o1.getName().compareTo(o2.getName());
		doStuff((Comparator<Student>) (o1, o2) -> o1.getName().compareTo(o2.getName()) );
		int x = ((Comparator<Student>)((o1, o2) -> o1.getName().compareTo(o2.getName())))
				.compare(s1, s2);
		
// Insufficient context!!!!
//		(Student o1, Student o2) -> o1.getName().compareTo(o2.getName());
		
		MaxOfCourses moc = (o1, o2) -> o1.getName().compareTo(o2.getName());
	}
}
