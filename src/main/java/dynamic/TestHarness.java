package dynamic;

//@RunMe
public class TestHarness {
	//@RunMe private String name;
	
	@RunMe("one")
	private void doStuff() {
		System.out.println("run me!!!");
	}
	
	public void dontDoStuff() {
		System.out.println("not run");
	}
	
	@RunMe(value = "two", name="JIM")
	public void doMoreStuff() {
		System.out.println("this should run too!");
	}
}
