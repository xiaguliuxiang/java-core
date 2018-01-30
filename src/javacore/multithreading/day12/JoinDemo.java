package javacore.multithreading.day12;

/**
 * 多线程(Join方法)<br>
 * <p>
 * join:<br>
 * 当A线程执行到了B线程的join()方法时，A就会等待。等B线程都执行完，A才会执行。<br>
 * join()可以用来临时加入线程执行。<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day12-09-多线程(Join方法)
 */
public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		t1.start();

		t1.join();

		t2.start();

		for (int i = 0; i < 80; i++) {
			System.out.println("main..." + i);
		}

		System.out.println("over");
	}

}

class Demo implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 70; i++) {
			System.out.println(Thread.currentThread().getName() + "..." + i);
		}
	}

}