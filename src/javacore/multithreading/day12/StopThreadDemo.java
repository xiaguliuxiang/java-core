package javacore.multithreading.day12;

/**
 * 多线程(停止线程)<br>
 * <p>
 * stop()方法已经过时.<br>
 * 如何停止线程?<br>
 * 只有一种,run()方法结束.<br>
 * 开启多线程运行，运行代码通常是循环结构。<br>
 * <br>
 * 只要控制住循环，就可以让run()方法结束，也就是线程结束。<br>
 * <br>
 * 特殊情况：<br>
 * 当线程处于了冻结状态。<br>
 * 就不会读取到标记，那么线程就不会结束。<br>
 * <br>
 * 当没有指定的方式让冻结的线程恢复到运行状态时，这时，需要对冻结进行清除。<br>
 * 强制让线程恢复到运行状态中来，这样就可以操作标记让线程结束。<br>
 * <br>
 * Thread 类中提供了该方法 interrupt();<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day12-07-多线程(停止线程)
 */
public class StopThreadDemo {

	public static void main(String[] args) {
		StropThread st = new StropThread();

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);

		t1.start();
		t2.start();

		int num = 0;

		while (true) {
			if (num++ == 60) {
				// st.changeFlag();
				t1.interrupt();
				t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName() + "..." + num);
		}
		System.out.println("over");
	}

}

class StropThread implements Runnable {
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + "...exception");
				flag = false;
			}
			System.out.println(Thread.currentThread().getName() + "...run");
		}
	}

	public void changeFlag() {
		flag = false;
	}

}
