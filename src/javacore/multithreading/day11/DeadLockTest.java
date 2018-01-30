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
public class DeadLockTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Test(true));
		Thread t2 = new Thread(new Test(false));
		t1.start();
		t2.start();
	}
}

class Test implements Runnable {
	private boolean flag;

	Test(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		if (flag) {
			synchronized (MyLock.locka) {
				System.out.println("if locka");
				synchronized (MyLock.lockb) {
					System.out.println("if lockb");
				}
			}
		} else {
			synchronized (MyLock.lockb) {
				System.out.println("else lockb");
				synchronized (MyLock.locka) {
					System.out.println("else locka");
				}
			}
		}
	}
}

class MyLock {
	static Object locka = new Object();
	static Object lockb = new Object();
}