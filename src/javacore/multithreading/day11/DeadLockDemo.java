package javacore.multithreading.day11;

/**
 * 多线程(多线程-死锁)<br>
 * <p>
 * 死锁。<br>
 * 同步中嵌套同步。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day11-15-多线程(多线程-死锁)
 */
public class DeadLockDemo {

	public static void main(String[] args) {
		Ticket4 t = new Ticket4();

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);

		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.flag = false;
		t2.start();
	}

}

class Ticket4 implements Runnable {
	private int tick = 1000;
	Object obj = new Object();
	boolean flag = true;

	@Override
	public void run() {
		if (flag) {
			while (true) {
				synchronized (obj) {
					show();
				}
			}
		} else {
			while (true) {
				show();
			}
		}
	}

	public synchronized void show() {
		synchronized (obj) {
			if (tick > 0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread() + "...sale : " + tick--);
			} else {
				System.exit(0);
			}
		}
	}
}
