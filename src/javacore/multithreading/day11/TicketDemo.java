package javacore.multithreading.day11;

/**
 * 多线程(售票的例子)<br>
 * 多线程(创建线程-实现Runnable接口)<br>
 * 多线程(多线程的安全问题)<br>
 * <p>
 * 需求：简单的卖票程序。<br>
 * 多个窗口同时卖票。<br>
 * <br>
 * 创建线程的第二种方式：实现Runnable接口。<br>
 * 步骤：<br>
 * <ul>
 * <li>1.定义类实现Runnable接口.</li>
 * <li>2.覆盖Runnable接口中的run()方法.</li>
 * <dd>将线程要运行的代码存放在该run()方法中.</dd>
 * <li>3.通过Thread类建立线程对象.</li>
 * <li>4.将Runnable接口的子类对象作为实际参数传递给Thread类的构造函数.</li>
 * <dt>为什么要将Runnable接口的子类对象传递给Thread的构造函数?</b></dt>
 * <dd>因为,自定义的run()方法所属的对象是Runnable接口的子类对象。</dd>
 * <dd>所以,要让线程去指定指定对象的run()方法,就必须明确该run()方法的所属对象.</dd>
 * <li>5.调用Thread类的start()方法开启线程并调用Runnable接口子类的run()方法.</li>
 * </ul>
 * <p>
 * <dt>实现方式和继承方式有什么区别吗?</dt>
 * <dd>实现方式好处：避免了单继承的局限性。</dd>
 * <dd>在定义线程时，建议使用实现方式。</dd>
 * <p>
 * <dt>两种方式的区别：</dt>
 * <dd>继承Thread:线程代码存放Thread子类方法中.</dd>
 * <dd>实现Runnable:线程代码存放在接口的子类的run()方法中.</dd>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day11-07-多线程(售票的例子)
 * @see 传智播客毕向东Java基础视频教程-day11-08-多线程(创建线程-实现Runnable接口)
 * @see 传智播客毕向东Java基础视频教程-day11-09-多线程(多线程的安全问题)
 */
public class TicketDemo {
	public static void main(String[] args) {

		// 实现 Runnable 接口
		Ticket1 t = new Ticket1();

		Thread t1 = new Thread(t); // 创建了一个线程
		Thread t2 = new Thread(t); // 创建了一个线程
		Thread t3 = new Thread(t); // 创建了一个线程
		Thread t4 = new Thread(t); // 创建了一个线程

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		// 继承 Thread 类实现
		// Ticket t1 = new Ticket();
		// Ticket t2 = new Ticket();
		// Ticket t3 = new Ticket();
		// Ticket t4 = new Ticket();
		//
		// t1.start();
		// t2.start();
		// t3.start();
		// t4.start();
	}
}

class Ticket implements Runnable /* extends Thread */ {

	private int tick = 100;

	@Override
	public void run() {
		while (true) {
			if (tick > 0) {
				System.out.println(Thread.currentThread() + "...sale : " + tick--);
			} else {
				break;
			}
		}
	}

}
