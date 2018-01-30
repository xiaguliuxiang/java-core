package javacore.multithreading.day11;

/**
 * 多线程(多线程-单例设计模式-懒汉式)<br>
 * <p>
 * 单例设计模式。<br>
 * 1.饿汉式。<br>
 * 2.懒汉式。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day11-14-多线程(多线程-单例设计模式-懒汉式)
 */
public class SingleDemo {
	public static void main(String[] args) {

	}
}

/**
 * 懒汉式单例设计模式。<br>
 */
class Single2 {
	private static Single2 s = null;

	private Single2() {

	}

	public static Single2 getInstance() {
		if (s == null) {
			synchronized (Single2.class) {
				if (s == null) {
					s = new Single2();
				}
			}
		}
		return s;
	}

}

/**
 * 饿汉式单例设计模式。<br>
 */
class Single1 {
	private static final Single1 s = new Single1();

	private Single1() {
	}

	public static Single1 getInstance() {
		return s;
	}
}