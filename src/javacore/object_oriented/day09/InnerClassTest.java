package javacore.object_oriented.day09;

/**
 * 面向对象(匿名内部类)<br>
 * <p>
 * 匿名内部类测试<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day09-04-面向对象(匿名内部类)
 */
public class InnerClassTest {
	public static void main(String[] args) {
		/**
		 * Test.function():Test类中有一个静态的方法function().<br>
		 * .method():function()这个方法运算后的结果是一个对象，而且是一个Inner类型的对象。<br>
		 * 因为只有是Inner类型的对象，才可以调用method方法。<br>
		 */
		Test.function().method();

		Inter in = Test.function();
		in.method();

		show(new Inter() {
			@Override
			public void method() {
				System.out.println("method show run");
			}
		});

		new Object() {
			public void function() {
				System.out.println("funciton");
			}
		}.function();
	}

	public static void show(Inter in) {
		in.method();
	}
}

interface Inter {
	void method();
}

class Test {
	// 补足代码，通过匿名内部类。

	static class Inner implements Inter {
		@Override
		public void method() {
			System.out.println("Inner.method");
		}
	}

	static Inner function() {
		return new Inner();
	}
}