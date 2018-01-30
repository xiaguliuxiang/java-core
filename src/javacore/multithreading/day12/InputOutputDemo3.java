package javacore.multithreading.day12;

/**
 * 多线程(线程间通信-代码优化)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day12-04-多线程(线程间通信-代码优化)
 */
public class InputOutputDemo3 {
	public static void main(String[] args) {
		Res3 r = new Res3();

		new Thread(new Input3(r)).start();
		new Thread(new Output3(r)).start();

	}
}

class Res3 {
	String name;
	String sex;
	boolean flag = false;

	public synchronized void set(String name, String sex) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();
	}

	public synchronized void out() {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "..." + sex);
		flag = false;
		this.notify();
	}

}

class Input3 implements Runnable {
	private Res3 r;

	Input3(Res3 r) {
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
					r.set("mike", "man");
				} else {
					r.set("丽丽", "女女女");
				}
				i = (i + 1) % 2;
			}
		}
	}

}

class Output3 implements Runnable {
	private Res3 r;

	Output3(Res3 r) {
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (r) {
				r.out();
			}
		}
	}

}