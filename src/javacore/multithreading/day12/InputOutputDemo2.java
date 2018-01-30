package javacore.multithreading.day12;

/**
 * 多线程(线程间通信-示例代码)<br>
 * 多线程(线程间通信-解决安全问题)<br>
 * 多线程(线程间通信-等待唤醒机制)<br>
 * <p>
 * 线程间通讯：<br>
 * 其实就是多个线程在操作同一个资源，但是操作的动作不同。<br>
 * <br>
 * wait();<br>
 * notify();<br>
 * notifyAll();<br>
 * 都使用在同步中，因为要对持有监视器(锁)的线程操作。<br>
 * 所以要使用在同步中，因为只有同步才具有锁。<br>
 * <br>
 * 为什么这些操作线程的方法要定义在Object类中呢？<br>
 * 因为这些方法在操作同步中线程时，都必须要标识他们所操作线程具有的锁。<br>
 * 只有同一个锁删的被等待线程，可以被同一个锁上notify()唤醒。<br>
 * 不可以对不同锁中的线程进行唤醒。<br>
 * 也就是说，等待和唤醒必须是同一个锁。<br>
 * 而锁可以是任意对象，所以可以被任意对象调用的方法定义Object类中。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day12-01-多线程(线程间通信-示例代码)
 * @see 传智播客毕向东Java基础视频教程-day12-02-多线程(线程间通信-解决安全问题)
 * @see 传智播客毕向东Java基础视频教程-day12-03-多线程(线程间通信-等待唤醒机制)
 */
public class InputOutputDemo2 {
	public static void main(String[] args) {
		Res2 r = new Res2();

		Input2 in = new Input2(r);
		Output2 out = new Output2(r);

		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);

		t1.start();
		t2.start();
	}
}

class Res2 {
	String name;
	String sex;
	boolean flag = false;
}

class Input2 implements Runnable {
	private Res2 r;

	Input2(Res2 r) {
		this.r = r;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			synchronized (r) {
				if (r.flag) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (i == 0) {
					r.name = "mike";
					r.sex = "man";
				} else {
					r.name = "丽丽";
					r.sex = "女";
				}
				i = (i + 1) % 2;
				r.flag = true;
				r.notify();
			}
		}
	}

}

class Output2 implements Runnable {
	private Res2 r;

	Output2(Res2 r) {
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (r) {
				if (!r.flag) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(r.name + "..." + r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}

}