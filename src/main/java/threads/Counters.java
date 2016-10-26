package threads;

class MyCountJob implements Runnable {
	// happens before relationship is created by
	// exit synchronized block followed by entry to
	// synchronized block on the same object.
	// so, volatile is not needed in this case.
	public /* volatile */ int value = 0;
	
	@Override
	public void run() {
		for (int i = 0; i < 10_000; i++) {
			synchronized(this) {
				value++;
			}
		}
		System.out.println("job completed...");
	}
}

public class Counters {

	public static void main(String[] args) throws Throwable {
		MyCountJob mj = new MyCountJob();
		Thread t1 = new Thread(mj);
		Thread t2 = new Thread(mj);
		t1.start();
		t2.start();

		t1.join();
		t2.join();
		System.out.println("value is " + mj.value);
	}

}
