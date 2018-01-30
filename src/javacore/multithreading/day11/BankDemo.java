package javacore.multithreading.day11;

/**
 * 多线程(多线程-同步函数)<br>
 * <p>
 * 需求：<br>
 * 银行有一个金库，有两个出乎分别存300元，每次存100，存3次。<br>
 * <br>
 * 目的：该程序是否有安全问题，如果有，如何解决？<br>
 * <br>
 * 如何找问题： <br>
 * 1.明确哪些代码是多线程运行代码。<br>
 * 2.明确共享数据。<br>
 * 3.明确多线程运行代码中哪些语句是操作共享数据的。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day11-11-多线程(多线程-同步函数)
 */
public class BankDemo {

	public static void main(String[] args) {
		Customer customer = new Customer();
		Thread t1 = new Thread(customer);
		Thread t2 = new Thread(customer);
		t1.start();
		t2.start();
	}

}

class Bank {
	private int sum;

	public synchronized void add(int n) {
		sum = sum + n;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("sum = " + sum);
	}
}

class Customer implements Runnable {
	private Bank bank = new Bank();

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			bank.add(100);
		}

	}
}
