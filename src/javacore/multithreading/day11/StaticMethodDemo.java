package javacore.multithreading.day11;

/**
 * 多线程(多线程-静态同步函数的锁是Class对象)<br>
 * <p>
 * 如果同步函数被静态修饰后，使用的锁是什么呢？<br>
 * 通过验证，发现不再是this, 因为静态方法中也不可以定义this.<br>
 * <br>
 * 静态进内存时，内存中没有本类对象，但是一定有该类对应的字节码文件对象。<br>
 * 类名.class,该对象的类型是Class.<br>
 * <br>
 * 静态的同步方法，使用的锁时该方法所在类的字节码文件对象，类名.class.<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day11-13-多线程(多线程-静态同步函数的锁是Class对象)
 */
public class StaticMethodDemo {

	public static void main(String[] args) {
		Ticket3 t = new Ticket3();

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);

		t1.start();
		t.flag = false;
		t2.start();
	}

}

class Ticket3 implements Runnable {
	private static int tick = 100;
	boolean flag = true;

	@Override
	public void run() {
		if (flag) {
			while (true) {
				synchronized (Ticket3.class) {
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

	public static synchronized void show() {
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
