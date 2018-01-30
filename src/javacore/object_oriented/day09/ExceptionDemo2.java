package javacore.object_oriented.day09;

/**
 * 面向对象(异常概述)<br>
 * 面向对象(异常try-catch)<br>
 * 面向对象(异常声明throws)<br>
 * 面向对象(多异常处理)<br>
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
 * <br>
 * <b>对多异常的处理。</b><br>
 * 1、声明异常时，建议声明更为具体的异常，这样处理的可以更具体。<br>
 * 2、对方声明几个异常，就对应有几个catch块，不要定义多余的catch块。<br>
 * 如果多个catch块中的异常出现继承关系，父类异常catch块放在最下面。<br>
 * 建议在进行catch处理时，catch中一定要定义具体处理方式。<br>
 * 不要简单定义一句：e.printStackTrace();也不要简单的就书写一条输出语句。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day09-05-面向对象(异常概述)
 * @see 传智播客毕向东Java基础视频教程-day09-06-面向对象(异常try-catch)
 * @see 传智播客毕向东Java基础视频教程-day09-07-面向对象(异常声明throws)
 * @see 传智播客毕向东Java基础视频教程-day09-08-面向对象(多异常处理)
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		Demo2 d = new Demo2();
		try {
			int x = d.div(4, 0);
			System.out.println("x = " + x);
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
			System.out.println("被零除了！！！");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
			System.out.println("角标越界了！！！");
		}
	}
}

class Demo2 {
	int div(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException {
		int[] arr = new int[a];
		System.out.println(arr[4]);
		return a / b;
	}
}
