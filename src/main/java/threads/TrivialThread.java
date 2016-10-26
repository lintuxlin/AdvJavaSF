package threads;

class MyWork implements Runnable {
	private int i = 0;
	@Override
	public void run() {
		for (; i < 10_000; i++) {
			System.out.println(Thread.currentThread().getName() + " i is " + i);
		}
	}
}

public class TrivialThread {

	public static void main(String[] args) {
		Runnable r = new MyWork();
		Thread t1 = new Thread(r); // non-daemon thread
		Thread t2 = new Thread(r);
		//t1.setDaemon(true);
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName() + " exiting");
	}
}
