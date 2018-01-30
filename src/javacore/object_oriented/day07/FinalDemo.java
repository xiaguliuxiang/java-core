package javacore.object_oriented.day07;

/**
 * 面向对象(final关键字)<br>
 * <p>
 * Final:最终，作为一个修饰符。<br>
 * 1、可以修饰类，函数，变量。<br>
 * 2、被final修饰的类不可以被继承。为了避免被继承，被子类复写功能。<br>
 * 3、被final修饰的方法不可以被复写。<br>
 * 4、被final修饰的变量时一个常量只能赋值一次，既可以修饰成员变量，又可以修饰局部变量。<br>
 * 当在描述事物时，一些数据的出现值是固定的，那么这时为了增强阅读性，都给这些值起个名字，方便于阅读。<br>
 * 而这个值不需要改变，所以加上final修饰。<br>
 * 作为常量：常量的书写规范，所有的字母都大写，如果由多个单词组成，单词间通过_连接。<br>
 * 5、内部类定义在类中的局部位置上时，稚嫩给访问该局部被final修饰的局部变量。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day07-07-面向对象(final关键字)
 */
public class FinalDemo {

	public static void main(String[] args) {

	}

}

class Demo {
	final int x = 3;
	public static final double PI = 3.14;

	final void show1() {

	}

	void show2() {
		final int y = 4;
		// y = 5; // The final local variable y cannot be assigned.
		System.out.println(y);
		System.out.println(PI);
	}
}
