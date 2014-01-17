package in.algorithm.thread;

import java.util.ArrayList;
import java.util.List;

public class PrinterThreadRunner {
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<Thread>();
		for(int i=1;i<=10;i++) {
			threads.add(new Thread(new PrinterThread(i)));
		}
		
		for(Thread thread : threads) {
			thread.start();
		}
	}
}
