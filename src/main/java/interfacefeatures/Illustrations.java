package interfacefeatures;
interface MyIf {
	static void doStuff() {
		System.out.println("static method");
	}
}
class MyIfImpl implements MyIf {
	static void doStuff() {
		System.out.println("static method in class");
	}
}

class MyIfImplSub extends MyIfImpl {
	static void doStuff() {
		System.out.println("static method in SUB class");
	}	
}

public class Illustrations {
	public static void main(String [] args) {
		MyIf.doStuff();
		
		// CANNOT do this with interface statics using reference variables (shouldn't anyway!!!)
		MyIfImpl mii = new MyIfImplSub();
		mii.doStuff();
		
	}
}
