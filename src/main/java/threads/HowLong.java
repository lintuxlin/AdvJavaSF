package threads;

class MyJob implements Runnable {
	// MUST do something explicit to ensure
	// changes to data made by one thread
	// are visible in another thread.
	// volatile is the most basic mechanism
	// it's also hard to use well in more
	// complex situations
	volatile boolean stop; 
	
	public void run() {
		while (!stop)
			;
		System.out.println("Thread stopping");
	}
}

public class HowLong {

	
	public static void main(String[] args) throws Throwable {
		MyJob mj = new MyJob();
		new Thread(mj).start();
		
		Thread.sleep(1000);
		mj.stop = true;
		System.out.println("main attempted to stop the job");
	}
}
