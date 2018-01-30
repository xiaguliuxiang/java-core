package javacore.object_oriented.day09;

/**
 * 面向对象(静态内部类)<br>
 * 面向对象(内部类定义原则)<br>
 * <p>
 * 内部类的访问规则：<br>
 * 1、内部类可以直接访问外部类中的成员，包括私有。<br>
 * 之所以可以直接访问外部类中的成员，是因为内部类中持有了一个外部类的引用，格式 外部类名.this<br>
 * 2 、外部类要访问内部类，必须建立内部类对象。<br>
 * <br>
 * 访问格式：<br>
 * 1、当内部类定义在外部类的成员位置上，而且非私有，可以在外部其他类中。<br>
 * 可以直接建立内部类对象。<br>
 * <code>
 * 格式：<br>
 * 		外部类名.内部类名	变量名	=	外部类对象.内部类对象;
 * 		Outer.Inner		in	  	=	new Outer().new Inner();
 * </code><br>
 * 2、当内部类在成员位置上，就可以被成员修饰符所修饰。<br>
 * 比如，private:将内部类在外部类中进行封装。<br>
 * static:内部类就具备static的特性。<br>
 * 当内部类被static修饰后，只能直接访问外部类中的static成员，出现了访问局限。<br>
 * <br>
 * 在外部其他类中，如何直接访问static内部类的非静态成员呢?<br>
 * <code>new Outer.Inner().function();</code><br>
 * 在外部其他类中，如何直接访问static内部类的静态成员呢?<br>
 * <code>Outer.Inner.function();</code><br>
 * 注意：当内部类中定义了静态成员，该内部类必须是static的。<br>
 * <br>
 * 当描述事物时，事物的内部还有事物，该事物用内部类来描述。<br>
 * 因为内部事物在使用外部事物的内容。<br>
 * 
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day09-02-面向对象(静态内部类)
 * @see 传智播客毕向东Java基础视频教程-day09-03-面向对象(内部类定义原则)
 */
public class InnerClassDemo2 {
	public static void main(String[] args) {
		Outer2.method();
	}
}

class Outer2 {
	private static int x = 3;

	static class Inner { // 静态内部类
		static void function() {
			System.out.println("inner:" + x);
		}
	}

	static class Inner2 {
		void show() {
			System.out.println("inner2 show");
		}
	}

	public static void method() {
		Inner.function();
		new Inner2().show();
	}
}