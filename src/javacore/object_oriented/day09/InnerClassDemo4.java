package javacore.object_oriented.day09;

/**
 * 面向对象(匿名内部类)<br>
 * <p>
 * 匿名内部类：<br>
 * 1、匿名内部类其实就是内部类的简写格式。<br>
 * 2、定义匿名内部类的前提：<br>
 * 内部类必须是继承一个类或者实现接口。<br>
 * 3、匿名内部类的格式： new 父类或者接口(){定义子类的内容}<br>
 * 4、其实匿名内部类就是一个匿名子类对象。<br>
 * 而且这个对象有点胖，可以理解为带内容的对象。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day09-04-面向对象(匿名内部类)
 */
public class InnerClassDemo4 {
	public static void main(String[] args) {
		new Outer4().function();
	}
}

abstract class AbsDemo {
	abstract void show();
}

class Outer4 {
	int x = 3;

	class Inner {
		void method() {
			System.out.println("method: x = " + x);
		}
	}

	class Inner1 extends AbsDemo {
		@Override
		void show() {
			System.out.println("show: x = " + x);
		}
	}

	public void function() {
		new Inner().method();

		new Inner1().show();

		new AbsDemo() {
			@Override
			void show() {
				System.out.println("x === " + x);
			}
		}.show();

		new AbsDemo() {
			int num = 9;

			@Override
			void show() {
				System.out.println("num === " + num);
			}

			void speak() {
				System.out.println("speak: num = " + num);
			}
		}.speak();
	}
}
