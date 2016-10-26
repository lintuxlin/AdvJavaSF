package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	private BlockingQueue<Integer> queue;
	public Producer(BlockingQueue<Integer> q) {
		this.queue = q;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10_000; i++) {
			try {
				queue.put(1);
				Thread.sleep(Math.random() > 0.2 ? 1 : 0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			queue.put(new Integer(Integer.MIN_VALUE));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Producer finishing ");
	}
}

class Consumer implements Runnable {
	private BlockingQueue<Integer> queue;
	public Consumer(BlockingQueue<Integer> q) {
		this.queue = q;
	}
	
	@Override
	public void run() {
		int liveProducers = 2;
		long count = 0;
		
		while(true) {
			try {
				Thread.sleep(Math.random() > 0.2 ? 1 : 0);
				int val = queue.take();
				if (val == Integer.MIN_VALUE) {
					if (--liveProducers == 0) break;
				} else {
					count += val;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumer finishing, sum is " + count);
	}
}

public class ProdCons {
	public static void main(String [] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);
		new Thread(p).start();
		new Thread(p).start();
		new Thread(c).start();
		System.out.println("main exiting...");
	}
}
