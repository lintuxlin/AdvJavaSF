package dynamic;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Dynamic {

	public static void main(String[] args) throws Throwable {
		Properties prop = new Properties();
		prop.load(new FileReader("testable.properties"));
		String classname = prop.getProperty("totest");
		System.out.println("class to test is " + classname);
		
		Class cl = Class.forName(classname);
		Object target = cl.newInstance();
	
		// security manager can prohibit disabling access checks...
//		System.setSecurityManager(new SecurityManager());

		// getDECLAREDxxx finds private, but only methods declared in this class
		// getxxxx finds accessible, but includes parent stuff...
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println("method: " + m);
			m.setAccessible(true);
			RunMe annot = m.getAnnotation(RunMe.class);
			if (annot != null) {
				System.out.println("Method is annotated RunMe(value = " + annot.value() + ")");
				m.invoke(target);
			}
		}
	}
}
