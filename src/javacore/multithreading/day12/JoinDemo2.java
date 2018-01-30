package javacore.multithreading.day12;

/**
 * 多线程(Join方法)<br>
 * 多线程(优先级&yield方法)<br>
 * <p>
 * join:<br>
 * 当A线程执行到了B线程的join()方法时，A就会等待。等B线程都执行完，A才会执行。<br>
 * join()可以用来临时加入线程执行。<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day12-09-多线程(Join方法)
 * @see 传智播客毕向东Java基础视频教程-day12-10-多线程(优先级&yield方法)
 */
public class JoinDemo2 {

	public static void main(String[] args) throws InterruptedException {
		Demo2 d = new Demo2();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();

		// t1.setPriority(Thread.MAX_PRIORITY);

		t2.start();

		// t1.join();

		for (int i = 0; i < 80; i++) {
			// System.out.println("main..." + i);
		}

		System.out.println("over");
	}

}

class Demo2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 70; i++) {
			System.out.println(Thread.currentThread().toString() + "..." + i);
			Thread.yield();
		}
	}

}