package javacore.multithreading.day11;

/**
 * 多线程(售票的例子)<br>
 * 多线程(创建线程-实现Runnable接口)<br>
 * 多线程(多线程的安全问题)<br>
 * 多线程(多线程同步代码块)<br>
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
 * 通过分析，发现，打印出0, -1, -2等错票。<br>
 * 多线程的运行出现了安全问题。<br>
 * <dt>问题的原因：</dt>
 * <dd>当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，还没有执行完，</dd>
 * <dd>另一个线程擦怒进来执行，导致共享数据的错误。</dd> <br>
 * <dt>解决办法：</dt>
 * <dd>对多条操作共享数据的语句，只能让一个线程都执行完。在转型过程中，其他线程不可以参与执行。</dt>
 * <p>
 * Java对于多线程的安全问题提供了专业的解决方式。<br>
 * 就是同步代码块。<br>
 * 
 * <pre>
 * synchronized (对象) {
 * 	// 需要被同步的代码
 * }
 * </pre>
 * <p>
 * 对象如同锁，持有锁的线程可以在同步中执行。<br>
 * 没有持有锁的线程即使获取CPU的执行权，也进不去，因为没有获取锁。<br>
 * <p>
 * 火车上的卫生间---经典。<br>
 * 同步的前提：<br>
 * <ul>
 * <li>1.必须有两个或者两个以上的线程。</li>
 * <li>2.必须是多个线程使用同一个锁。</li>
 * </ul>
 * 必须保证同步中只能有一个线程在运行。<br>
 * <br>
 * 好处：解决了多线程的安全问题。<br>
 * 弊端：多个线程需要判断锁，较为消耗资源。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day11-07-多线程(售票的例子)
 * @see 传智播客毕向东Java基础视频教程-day11-08-多线程(创建线程-实现Runnable接口)
 * @see 传智播客毕向东Java基础视频教程-day11-09-多线程(多线程的安全问题)
 * @see 传智播客毕向东Java基础视频教程-day11-10-多线程(多线程同步代码块)
 */
public class TicketDemo2 {
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
	}
}

class Ticket1 implements Runnable {

	private int tick = 100;
	Object obj = new Object();

	@Override
	public void run() {
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
	}

}
