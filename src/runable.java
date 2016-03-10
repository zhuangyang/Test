

public class runable {
	public static void main(String[] args) {
		ThreadTest t = new ThreadTest();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();// 多个线程对象同时调用同一个线程
	}
}

class ThreadTest implements Runnable {
	private int tickets = 2;

	public synchronized  void run() {
		for (; tickets > 0; tickets--) {
			System.out.println(Thread.currentThread().getName()
					+ "is saling ticket " + tickets);
		}
	}
}
