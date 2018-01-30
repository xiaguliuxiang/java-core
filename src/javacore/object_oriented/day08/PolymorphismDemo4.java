package javacore.object_oriented.day08;

/**
 * 面向对象(多态中成员的特点)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day08-05-面向对象(多态中成员的特点)
 */
public class PolymorphismDemo4 {
	public static void main(String[] args) {
		Fu f = new Zi();
		f.method_1();
		f.method_2();
		((Zi) f).method_3();

		/**
		 * 在多态中成员函数的特点：<br>
		 * 在编译时期：残月引用型变量所属的类中是否有调用的方法。<br>
		 * 如果有，编译通过，如果没有，编译失败。<br>
		 * 在运行时期：残月对象所属的类中是否有调用的方法。<br>
		 * <br>
		 * 简单总结就是：成员函数在多态调用时，编译看左边，运行看右边。<br>
		 * <br>
		 * 在多态中，成员变量的特点：<br>
		 * 无论编译和运行，都参考左边(引用型变量所属的类)。 <br>
		 * 在多态中，静态成员
		 */

		// Zi z = new Zi();
		// z.method_1();
		// z.method_2();
		// z.method_3();
	}
}

class Fu {
	void method_1() {
		System.out.println("fu method_1");
	}

	void method_2() {
		System.out.println("fu method_2");
	}
}

class Zi extends Fu {
	@Override
	void method_1() {
		System.out.println("zi method_1");
	}

	void method_3() {
		System.out.println("zi method_3");
	}
}