package javacore.multithreading.day12;

/**
 * 多线程(线程间通信-生产者消费者)<br>
 * <p>
 * 对于多个生产者和消费者。<br>
 * 为什么要定义while判断标记。<br>
 * 原因：让被唤醒的线程再一次判断标记。<br>
 * <br>
 * 为什么定义notifyAll()?<br>
 * 因为需要唤醒对方线程。<br>
 * 因为只用notify(),容易出现只唤醒奔放线程的情况，导致程序中的所有线程都等待。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day12-05-多线程(线程间通信-生产者消费者)
 */
public class ProducerConsumerDemo {
	public static void main(String[] args) {
		Resource res = new Resource();

		Producer pro = new Producer(res);
		Consumer con = new Consumer(res);

		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Resource {
	private String name;
	private int count = 1;
	private boolean flag = false;

	// t1 t2
	public synchronized void set(String name) {
		while (flag) {
			try {
				// t1放弃资格,t2获取资格
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name + "--" + count++;
		System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
		flag = true;
		this.notifyAll();
	}

	// t3,t4
	public synchronized void out() {
		while (!flag) {
			try {
				// t3放弃资格,t4获取资格
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
		flag = false;
		this.notifyAll();
	}

}

class Producer implements Runnable {
	private Resource res;

	Producer(Resource res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			res.set("+商品+");
		}
	}

}

class Consumer implements Runnable {
	private Resource res;

	Consumer(Resource res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			res.out();
		}
	}
}
