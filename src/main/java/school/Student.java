package school;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Student {
	private String name;
	private float gpa;
	private List<String> courses;

	public static Student ofNameGpaCourses(String name, float gpa, String... courses) {
		Student self = new Student();
		self.name = name;
		self.gpa = gpa;
		self.courses = Arrays.asList(courses);
		return self;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public List<String> getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + ", courses=" + courses + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public static Comparator<Student> getGpaComparator() {
		// Note this isn't a singleton!! (it probably should be)
		return (s1, s2) -> Float.compare(s1.gpa, s2.gpa); 
	}

	private static Comparator<Student> enthusiamComparator = 
			(s1, s2) -> s1.courses.size() - s2.courses.size();
			
	public static Comparator<Student> getEnthusiamComparator() {
		return enthusiamComparator;
	}
	
 	private static Comparator<Student> nameComparator = 
 			(o1, o2) -> o1.getName().compareTo(o2.getName());
		
	public static Comparator<Student> getNameComparator() {
		return nameComparator;
	}

//	private static Comparator<Student> nameComparator = 
//	(/*Student*/ o1, /*Student*/ o2) -> /*{*/
//		/*System.out.println("lambda...");*/
//		/*return*/ o1.getName().compareTo(o2.getName())/*;*/
//	/*}*/;
//
//  public static Comparator<Student> getNameComparator() {
//	  return nameComparator;
//  }
	
//	private static Comparator<Student> nameComparator = /*new Comparator<Student>() {*/
//		/*public int compare*/(Student o1, Student o2) -> {
//			System.out.println("lambda...");
//			return o1.getName().compareTo(o2.getName());
//		}
//	/*}*/;
//	
//	public static Comparator<Student> getNameComparator() {
//		return nameComparator;
//	}
		
//	private static Comparator<Student> nameComparator = new /*NameComparator();
//	private static class NameComparator implements */Comparator<Student>() {
//		public int compare(Student o1, Student o2) {
//			System.out.println("anonymous...");
//			return o1.getName().compareTo(o2.getName());
//		}
//	};
//	
//	public static Comparator<Student> getNameComparator() {
//		return nameComparator;
//	}
//	
//	private static Comparator<Student> nameComparator = new NameComparator();
//	
//	public static Comparator<Student> getNameComparator() {
//		return nameComparator;
//	}
//	
//	private static class NameComparator implements Comparator<Student> {
//		public int compare(Student o1, Student o2) {
//			System.out.println("internal...");
//			return o1.getName().compareTo(o2.getName());
//		}
//	}
}
