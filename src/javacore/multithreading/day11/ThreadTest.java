package javacore.multithreading.day11;

/**
 * 多线程(线程练习)<br>
 * 多线程(线程运行状态)<br>
 * 多线程(获取线程对象以及名称)<br>
 * <p>
 * 练习：<br>
 * 创建两个线程，和主线程交替运行。<br>
 * 线程的四种状态：<br>
 * 
 * <pre>
 *         start()           sleep()   wait()
 * 被创建-----------> 运行 <----------------------> 冻结
 *   |                |      sleep()   notify()    |
 *   |                | run()结束                                             |
 *   |                | stop()                     |
 *   |      stop()    ↓                                                                    |
 *   |-------------> 消亡 <-------------------------|
 * </pre>
 * 
 * sleep()方法需要指定睡眠时间，单位是毫秒。<br>
 * 一个特殊的状态：就绪。具备了执行状态，但是还没有获取资源。<br>
 * <br>
 * 线程都有自己默认的名称。<br>
 * Thread-编号，该编号从0开始。<br>
 * <br>
 * static Thread currentThread():获取当前线程对象。<br>
 * getName():获取线程名称。<br>
 * <br>
 * 设置线程名称：setName()或者构造函数。<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day11-04-多线程(线程练习)
 * @see 传智播客毕向东Java基础视频教程-day11-05-多线程(线程运行状态)
 * @see 传智播客毕向东Java基础视频教程-day11-06-多线程(获取线程对象以及名称)
 */
public class ThreadTest {

	public static void main(String[] args) {
		ThreadTest01 t1 = new ThreadTest01("one");
		ThreadTest01 t2 = new ThreadTest01("two");
		t1.start();
		t2.start();
		t1.run();
		t2.run();

		for (int i = 0; i < 60; i++) {
			System.out.println("main run:" + i);
		}
	}

}

class ThreadTest01 extends Thread {
	private String name;

	ThreadTest01(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 60; i++) {
			System.out.println(name + " thread run:" + i);
		}
	}
}
