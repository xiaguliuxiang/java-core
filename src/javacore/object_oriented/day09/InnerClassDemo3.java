package javacore.object_oriented.day09;

/**
 * 面向对象(匿名内部类)<br>
 * <p>
 * 内部类定义在局部时：<br>
 * 1、不可以被成员修饰符修饰。<br>
 * 2、可以直接访问外部类中的成员，因为还持有外部类中的引用。<br>
 * 但是不可以访问它所在的局部中的变量，只能访问被final修饰的局部变量。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day09-04-面向对象(匿名内部类)
 */
public class InnerClassDemo3 {
	public static void main(String[] args) {
		new Outer3().method();

		Outer3 out = new Outer3();
		out.method(7);
		out.method(8);
	}
}

class Outer3 {
	int x = 3;

	void method() {
		final int y = 4;
		class Inner {
			void function() {
				System.out.println("x = " + Outer3.this.x);
				System.out.println("y = " + y);
			}
		}
		new Inner().function();
	}

	void method(final int a) {
		final int y = 4;
		class Inner {
			void function() {
				System.out.println("x = " + Outer3.this.x);
				System.out.println("y = " + y);
				System.out.println(a);
			}
		}
		new Inner().function();
	}
}