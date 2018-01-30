package javacore.object_oriented.day06;

/**
 * 面向对象(静态代码块)<br>
 * <p>
 * 静态代码块<br>
 * 格式：<br>
 * 
 * <pre>
 * static
 * {
 * 		静态代码块中的执行语句;
 * }
 * </pre>
 * 
 * 特点：随着类的加载而执行，只执行一次。<br>
 * 用于给类进行初始化的。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day06-06-面向对象(静态代码块)
 */
public class StaticCodeDemo {

	static {
		System.out.println("x");
	}

	public static void main(String[] args) {
		new StaticCode();
		new StaticCode(4);
		System.out.println("over");
		StaticCode.show();
	}

	static {
		System.out.println("y");
	}

}

class StaticCode {

	static int num = 9;

	StaticCode() {
		System.out.println("b");
	}

	static {
		System.out.println("a");
	}
	{
		System.out.println("c" + num);
	}

	StaticCode(int i) {
		System.out.println("d");
	}

	public static void show() {
		System.out.println("show");
	}
}
