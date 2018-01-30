package javacore.object_oriented.day09;

/**
 * 面向对象(内部类访问规则)<br>
 * <p>
 * 内部类的访问规则：<br>
 * 1、内部类可以直接访问外部类中的成员，包括私有。<br>
 * 之所以可以直接访问外部类中的成员，是因为内部类中持有了一个外部类的引用，格式 外部类名.this<br>
 * 2 、外部类要访问内部类，必须建立内部类对象。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day09-01-面向对象(内部类访问规则)
 */
public class InnerClassDemo {
	public static void main(String[] args) {
		Outer out = new Outer();
		out.method();

		// 直接访问内部类中的成员
		// Outer.Inner in = out.new Inner();
		// in.function();
	}
}

class Outer {
	int x = 3;

	private class Inner { // 内部类
		void function() {
			System.out.println("inner:" + Outer.this.x);
		}
	}

	void method() {
		Inner in = new Inner();
		in.function();
		System.out.println("x = " + x);
	}
}