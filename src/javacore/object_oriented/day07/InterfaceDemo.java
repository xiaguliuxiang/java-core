package javacore.object_oriented.day07;

/**
 * 面向对象(接口)<br>
 * 面向对象(接口2)<br>
 * 面向对象(接口的特点)<br>
 * <p>
 * 接口：初期理解，可以认为是一个特殊的抽象类。<br>
 * 当抽象类中的方法都是抽象的，那么该类可以通过接口的形式来表示。<br>
 * class 用于定义类。<br>
 * interface 用于定义接口。<br>
 * <br>
 * 接口定义时，格式特点：<br>
 * 1、接口中常见定义：常量，抽象方法。<br>
 * 2、接口中的成员都有固定修饰符。<br>
 * 常量：public static final.<br>
 * 方法：public abstract.<br>
 * <br>
 * 记住：接口中的成员都是 public 的。<br>
 * <br>
 * 接口：是不可以创建对象的，因为有抽象方法。<br>
 * 需要被子类实现，子类对接口中的抽象方法全部覆盖后，子类才可以实例化。<br>
 * 否则子类是一个抽象类。<br>
 * <br>
 * 接口可以被类多实现，也是对多继承不支持的转换形式。java 支持多实现。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day07-12-面向对象(接口)
 * @see 传智播客毕向东Java基础视频教程-day07-13-面向对象(接口2)
 * @see 传智播客毕向东Java基础视频教程-day07-14-面向对象(接口的特点)
 */
public class InterfaceDemo {

	public static void main(String[] args) {
		Test t = new Test();
		// System.out.println(t.NUM);
		System.out.println(Test.NUM);
		System.out.println(Inter.NUM);
		t.show();
		// t.NUM = 4; // 错误操作,final修饰符
	}

}

interface Inter {
	public static final int NUM = 3;

	public abstract void show();
}

interface InterB {
	public abstract void method();
}

class Demo1 {
	public void function() {

	}
}

class Test extends Demo1 implements Inter, InterB {
	@Override
	public void function() {
		System.out.println("Test...function");
	}

	@Override
	public void show() {
		System.out.println("Test...show");
	}

	@Override
	public void method() {
		System.out.println("Test...method");
	}
}

interface A {
	void methodA();

	// int show();
}

interface B {
	void methodB();

	// boolean show();
}

interface C extends A, B {
	void methodC();
}

class D implements C {
	@Override
	public void methodA() {
	}

	@Override
	public void methodB() {
	}

	@Override
	public void methodC() {
	}

}