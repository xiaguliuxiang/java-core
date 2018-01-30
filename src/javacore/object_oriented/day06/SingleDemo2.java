package javacore.object_oriented.day06;

/**
 * 面向对象(单例设计模式方式二)<br>
 * <p>
 * 饿汉式,懒汉式.<br>
 * 饿汉式：Single类一进内存，就已经创建好了对象。<br>
 * 懒汉式：Single类进入内存，对象还没有存在，只有调用了getInstance()方式时，才建立对象。<br>
 * <br>
 * 记住原则：定义单例，建议使用饿汉式。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day06-10-面向对象(单例设计模式方式二)
 */
public class SingleDemo2 {

	public static void main(String[] args) {

	}

}

// 对象是方法被调用时才初始化，也叫做对象的延时加载，称为：懒汉式。
// Single2类进入内存，对象还没有存在，只有调用了getInstance()方法时，才建立对象。
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
