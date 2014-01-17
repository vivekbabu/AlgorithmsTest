package in.algorithm.thread;

public class PrinterThread implements Runnable {
	private int threadId;
	public PrinterThread(int threadId) {
		this.threadId = threadId;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i+" th print from thread "+ threadId);
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
