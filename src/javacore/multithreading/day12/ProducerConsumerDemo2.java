package javacore.multithreading.day12;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程(线程间通信-生产者消费者)<br>
 * 多线程(线程间通信-生产者消费者JDK5.0升级版)<br>
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
 * @see 传智播客毕向东Java基础视频教程-day12-06-多线程(线程间通信-生产者消费者JDK5.0升级版)
 */
public class ProducerConsumerDemo2 {
	public static void main(String[] args) {
		Resource2 res = new Resource2();

		Producer2 pro = new Producer2(res);
		Consumer2 con = new Consumer2(res);

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

/**
 * JDK1.5 中提供了多线程升级解决方案.<br>
 * 将同步 synchronized 替换成显示的 lock 操作.<br>
 * 将 Object 中的 wait(),notify(),notifyAll()替换成Condition对象.<br>
 * 该对象可以通过 Lock 锁进行获取.<br>
 * 该示例中,实现了本方只唤醒对方的操作.<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @since jdk1.5
 */
class Resource2 {
	private String name;
	private int count = 1;
	private boolean flag = false;

	private Lock lock = new ReentrantLock();

	private Condition condition_pro = lock.newCondition();
	private Condition condition_con = lock.newCondition();

	public void set(String name) {
		lock.lock();
		try {
			while (flag) {
				condition_pro.await();
			}

			this.name = name + "--" + count++;
			System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
			flag = true;

			condition_con.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 释放锁的动作一定要执行
			lock.unlock();
		}
	}

	public void out() {
		lock.lock();
		try {
			while (!flag) {
				condition_con.await();
			}

			this.name = name + "--" + count++;
			System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
			flag = false;

			condition_pro.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}

class Producer2 implements Runnable {
	private Resource2 res;

	Producer2(Resource2 res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			res.set("+商品+");
		}
	}

}

class Consumer2 implements Runnable {
	private Resource2 res;

	Consumer2(Resource2 res) {
		this.res = res;
	}

	@Override
	public void run() {
		while (true) {
			res.out();
		}
	}
}
