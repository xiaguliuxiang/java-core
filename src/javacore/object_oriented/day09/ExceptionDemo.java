package javacore.object_oriented.day09;

/**
 * 面向对象(异常概述)<br>
 * 面向对象(异常try-catch)<br>
 * 面向对象(异常声明throws)<br>
 * <p>
 * <b>1、异常概述</b><br>
 * 异常：就是程序在运行时出现不正常情况。<br>
 * 异常由来：问题也是现实生活中一个具体的事物，也可以通过java的类的形式进行描述，并封装成对象。 其实就是java对不正常情况进行描述后的对象体现。
 * <br>
 * <br>
 * 对于问题的划分:两种：一种是严重的问题，一种是非严重的问题。<br>
 * 对于严重的：java通过Error类进行描述。<br>
 * 对于Error一般不编写针对性的代码对其进行处理。<br>
 * 对于非严重的：java通过Exception类进行描述。<br>
 * 对于Exception可以使用针对性的处理方式进行处理。<br>
 * <br>
 * 无论Error或者Exception都具有一些共性内容。<br>
 * 比如：不正常情况的信息，引发原因等。<br>
 * <code>
 * Throwable
 * 		| --Error
 * 		| --Exception
 * </code> <br>
 * <p>
 * <b>2、异常的处理</b><br>
 * java提供了特有的语句进行处理。<br>
 * <code>
 * try {
 * 		需要被检测的代码;
 * } catch (异常类 变量) {
 * 		处理异常的代码;(处理方式)
 * } finally {
 * 		一定会执行的语句;
 * }
 * </code><br>
 * <p>
 * <b>3、对捕获到的异常对象进行常见方法操作。</b><br>
 * String getMessage();获取异常信息。<br>
 * <br>
 * 在函数上声明异常。<br>
 * 便于提高安全性，让调用处进行处理，不处理就编译失败。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day09-05-面向对象(异常概述)
 * @see 传智播客毕向东Java基础视频教程-day09-06-面向对象(异常try-catch)
 * @see 传智播客毕向东Java基础视频教程-day09-07-面向对象(异常声明throws)
 */
public class ExceptionDemo {
	public static void main(String[] args) {
		Demo d = new Demo();
		try {
			int x = d.div(4, 0); // java.lang.ArithmeticException: / by zero
			System.out.println("x = " + x);
			x = d.div1(5, 0);
		} catch (Exception e) {
			System.out.println("除零啦");
			System.out.println(e.getMessage()); // / by zero
			System.out.println(e.toString()); // 异常名称:异常信息。

			e.printStackTrace(); // 异常名称,异常信息,异常出现的位置.
			// 其实jvm默认的异常处理机制，就是在调用printStackTrace()方法，打印异常的堆栈的跟踪信息。
		}
		// byte[] arr = new byte[1024 * 1024 * 600];
	}
}

class Demo {
	int div(int a, int b) {
		return a / b;
	}

	/**
	 * 在功能上通过throws的关键字声明了该功能有可能会出现问题。<br>
	 * 
	 * @throws Exception
	 */
	int div1(int a, int b) throws Exception {
		return a / b;
	}
}
