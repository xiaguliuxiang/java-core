package javacore.object_oriented.day09;

/**
 * 面向对象(自定义异常)<br>
 * 面向对象(throw和throws的区别)<br>
 * <p>
 * 因为项目中会出现特有的问题，而这些问题并未被java所描述并封装对象，<br>
 * 所以对于这些特有的问题可以按照java的对问题封装的思想。<br>
 * 将特有的问题，进行自定义的异常封装。<br>
 * <br>
 * 自定义异常。<br>
 * 需求：在本程序中，对于除数是-1，也是为是错误的，无法进行运算。<br>
 * 那么就需要对这个问题进行自定义的描述。<br>
 * <br>
 * 挡在函数内部出现了throw跑出异常对象，那么就必须要给对应的处理动作。<br>
 * 要么在内部try catch 处理。<br>
 * 要么在函数上声明让调用者处理。<br>
 * <br>
 * 一般情况下，函数内出现异常，函数上需要声明。<br>
 * 发现打印的结果中只有异常的名称，却没有异常的信息。<br>
 * 因为自定义的异常并未定义信息。<br>
 * <br>
 * 如何定义异常信息呢?<br>
 * 因为父类中已经把异常信息的操作都完成了。<br>
 * 所以子类只要在构造时，将异常信息传递给父类通过super语句。<br>
 * 那么就可以直接通过getMessage()方法获取自定义的异常信息。<br>
 * <br>
 * 自定义异常：必须是自定义类继承Exception.<br>
 * 继承Exception的原因:<br>
 * 异常体系有一个特点，因为异常类和异常对象都被抛出，他们都具备可抛性。<br>
 * 这个可抛性是Throwable这个体系中独有特点。<br>
 * 只有这个体系中的类和对象才可以被throws和throw操作。<br>
 * <br>
 * throws和throw的区别。<br>
 * throws使用在函数上，throw使用在函数内。<br>
 * throws后面跟的是异常类，可以跟多个，用逗号隔开。throw后跟的是异常对象。<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day09-09-面向对象(自定义异常)
 * @see 传智播客毕向东Java基础视频教程-day09-10-面向对象(throw和throws的区别)
 */
public class ExceptionDemo3 {
	public static void main(String[] args) {
		Demo3 d = new Demo3();
		try {
			int x = d.div(4, -1);
			System.out.println("x = " + x);
		} catch (NegativeException e) {
			System.out.println(e.getMessage() + "..." + e.getValue());
		}
	}
}

@SuppressWarnings("serial")
class NegativeException extends Exception {
	private String msg;
	private int value;

	public NegativeException(String msg) {
		this.msg = msg;
	}

	public NegativeException(String msg, int value) {
		this.msg = msg;
		this.value = value;
	}

	@Override
	public String getMessage() {
		return msg;
	}

	public int getValue() {
		return value;
	}
}

class Demo3 {
	int div(int a, int b) throws NegativeException {
		if (b < 0) {
			throw new NegativeException("出现了除数是负数的情况 / by negative number");
		}
		return a / b;
	}
}

class Throwable1 {
	private String message;

	public Throwable1(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

class Exception1 extends Throwable1 {

	Exception1(String message) {
		super(message);
	}

}

class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Student extends Person {
	Student(String name) {
		super(name);
	}
}