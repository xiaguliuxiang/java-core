package javacore.multithreading.day11;

/**
 * 多线程(多线程-同步函数的锁是this)<br>
 * <p>
 * 同步函数用的是哪一个锁呢？<br>
 * 函数需要被对象调用，那么函数都有一个所属对象引用，就是this.<br>
 * 所以tongue函数使用的锁就是this.<br>
 * <br>
 * 通过改程序进行验证。<br>
 * <br>
 * 使用两个线程来卖票。<br>
 * 一个线程在同步代码块中，一个线程在同步函数中，都在执行卖票动作。<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day11-12-多线程(多线程-同步函数的锁是this)
 */
public class ThisLockDemo {

	public static void main(String[] args) {
		Ticket2 t = new Ticket2();

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);

		t1.start();
		t.flag = false;
		t2.start();
	}

}

class Ticket2 implements Runnable {
	private int tick = 1000;
	Object obj = new Object();
	boolean flag = true;

	@Override
	public void run() {
		if (flag) {
			while (true) {
				synchronized (obj) {
					if (tick > 0) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread() + "...sale : " + tick--);
					} else {
						break;
					}
				}
			}
		} else {
			while (true) {
				show();
			}
		}
	}

	public synchronized void show() {
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