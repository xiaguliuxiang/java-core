package javacore.multithreading.day12;

/**
 * 多线程(优先级&yield方法)<br>
 * <p>
 * 实际项目中多线程的写法<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day12-10-多线程(优先级&yield方法)
 */
public class ThreadTest {

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + "..." + i);
				}
			}
		}.start();

		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "..." + i);
		}

		Runnable r = new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + "..." + i);
				}
			}
		};
		new Thread(r).start();

		new Test1().run();
	}

}

class Test1 extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "..." + i);
		}
	}
}
