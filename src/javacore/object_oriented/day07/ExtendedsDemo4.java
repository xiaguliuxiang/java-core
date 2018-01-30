package javacore.object_oriented.day07;

/**
 * 面向对象(子父类中构造函数的特点-子类实例化过程)<br>
 * <p>
 * 子父类出现后，类成员的特点：<br>
 * 类中成员：<br>
 * 1、变量。<br>
 * 2、函数。<br>
 * 3、构造函数。<br>
 * <br>
 * 3、子父类中的构造函数。<br>
 * 在对子类对象进行初始化时，父类的构造函数也会运行。<br>
 * 那是因为子类的构造函数默认第一行有一条隐式的语句 super();<br>
 * super(); 会访问父类中空参数的构造函数，而且子类中所有的构造函数默认第一行都是super();<br>
 * <br>
 * 为什么子类一定要访问父类中的构造函数。<br>
 * 因为父类中的数据子类可以直接获取，所以子类对象在建立时，需要先查看父类是如何对这些数据进行初始化的。<br>
 * 所以子类在对象初始化时，要先访问以下父类中的构造函数。<br>
 * 如果要访问父类中指定的构造函数，可以通过手动定义super语句的方式来指定。<br>
 * <br>
 * 注意：super语句一定定义在子类构造函数的第一行。<br>
 * <br>
 * 结论：<br>
 * 子类的所有的构造函数，默认都会访问父类中空参数的构造函数。<br>
 * 因为每一个构造函数内的第一行都有一句隐式super();<br>
 * 当父类中没有空参数的构造函数时，子类必须手动通过super或者this语句形式来指定要访问的父类中的构造函数。<br>
 * 当然，子类的构造函数第一行也可以手动指定this语句来访问本类中的构造函数。<br>
 * 子类中至少会有一个构造函数会访问父类中的构造函数。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day07-06-面向对象(子父类中构造函数的特点-子类实例化过程)
 */
public class ExtendedsDemo4 extends Object {

	public static void main(String[] args) {
		new Zi4();
		new Zi4(4);

	}
}

class Fu4 {
	int num = 2;

	Fu4() {
		num = 60;
		System.out.println("fu run");
	}

	Fu4(int i) {
		System.out.println("fu..." + i);
	}
}

class Zi4 extends Fu4 {
	Zi4() {
		// super();
		// super(4);
		System.out.println("zi run");
	}

	Zi4(int i) {
		// super();
		// super(3);
		System.out.println("zi..." + i);
	}
}

class Person4 {
	private String name;

	Person4(String name) {
		this.name = name;
	}

	void show() {
		System.out.println("Person4..." + this.name);
	}
}

class Student4 extends Person4 {

	Student4(String name) {
		super(name);
	}

	void method() {
		super.show();
	}

}
