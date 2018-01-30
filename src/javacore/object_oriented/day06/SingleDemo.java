package javacore.object_oriented.day06;

/**
 * 面向对象(单例设计模式)<br>
 * <p>
 * 设计模式：解决某一类问题最行之有效的方法。<br>
 * java中23中设计模式：<br>
 * 单例设计模式：解决一个类在内存中只存在一个对象。<br>
 * <br>
 * 想要保证对象唯一。<br>
 * 1、为了避免其他程序过多建立该类对象，先禁止其他程序建立该类对象。<br>
 * 2、还为了让其他程序可以访问到该类对象，只好在本类中，自定义一个对象。<br>
 * 3、为了方便其他程序对自定义对象的访问，可以对外提供一些访问方式。<br>
 * <br>
 * 这三步怎么用代码体现呢?<br>
 * 1、将构造函数私有化。<br>
 * 2、在类中创建一个本类对象。<br>
 * 3、提供一个方法可以获取到该对象。<br>
 * <br>
 * 对于事物该怎么描述，还是怎么描述。<br>
 * 当需要将该事物的对象保证在内存中唯一时，就将以上的三步加上即可。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day06-09-面向对象(单例设计模式)
 */
public class SingleDemo {

	public static void main(String[] args) {
		// new Single(); 构造函数私有，无法创建实例
		Single s = Single.getInstance();
		s.method();
	}

}

// 这个是先初始化对象，称为：饿汉式。
class Single {

	private Single() {
	}

	static Single s = new Single();

	public static Single getInstance() {
		return s;
	}

	public void method() {
		System.out.println("method");
	}

}
