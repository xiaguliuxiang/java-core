package javacore.multithreading.day12;

/**
 * 多线程(线程间通信-示例代码)<br>
 * 多线程(线程间通信-解决安全问题)<br>
 * <p>
 * 线程间通讯：<br>
 * 其实就是多个线程在操作同一个资源，但是操作的动作不同。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day12-01-多线程(线程间通信-示例代码)
 * @see 传智播客毕向东Java基础视频教程-day12-02-多线程(线程间通信-解决安全问题)
 */
public class InputOutputDemo {
	public static void main(String[] args) {
		Res r = new Res();

		Input in = new Input(r);
		Output out = new Output(r);

		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);

		t1.start();
		t2.start();
	}
}

class Res {
	String name;
	String sex;
}

class Input implements Runnable {
	private Res r;

	Input(Res r) {
		this.r = r;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			synchronized (Input.class) {
				if (i == 0) {
					r.name = "mike";
					r.sex = "man";
				} else {
					r.name = "丽丽";
					r.sex = "女";
				}
				i = (i + 1) % 2;
			}
		}
	}

}

class Output implements Runnable {
	private Res r;

	Output(Res r) {
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (Input.class) {
				System.out.println(r.name + "..." + r.sex);
			}
		}
	}

}