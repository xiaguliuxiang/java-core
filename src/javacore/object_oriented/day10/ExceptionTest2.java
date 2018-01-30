package javacore.object_oriented.day10;

/**
 * 面向对象(异常-总结)<br>
 * <p>
 * 异常。<br>
 * 异常时什么?是对问题的描述，将问题进行对象的封装。<br>
 * 异常体系：<br>
 * Throwable<br>
 * |--Error<br>
 * |--Exception<br>
 * |--|--RuntimeException<br>
 * <br>
 * 异常体系的特点：异常体系中的所有类以及建立的对象都具备可抛性。<br>
 * 也就是说可以被throw和throws关键字所操作。<br>
 * 只有异常体系具体这个特点。<br>
 * <br>
 * throw和throws的用法:<br>
 * throw定义在函数内，用于抛出异常对象。<br>
 * throws定义在函数上，用于抛出异常类，可以抛出多个用逗号隔开。<br>
 * <br>
 * 当函数内容有throw抛出异常对象，并非进行try处理。必须要在函数上声明，否则编译失败。<br>
 * 注意，RuntimeException除外，也就是说，函数内如果抛出的RuntimeException异常，函数上可以声明。<br>
 * <br>
 * 异常有两种:<br>
 * 1、编译时被检测异常。<br>
 * 该异常在编译时，如果没有处理(没有抛也没有try),编译失败。<br>
 * 该异常被标识，代表这个可以被处理。<br>
 * 2、运行时异常(编译时不检测).<br>
 * 在编译时，不需要处理，编译器不检查。<br>
 * 该异常的发生，建议不处理，让程序停止，需要对代码进行修正。<br>
 * <br>
 * 
 * <pre>
 * 异常处理语句：
 * 第一个格式：
 * try {
 * 		// 代码
 * } catch (Exception e) {
 * 		// 异常处理代码
 * }
 * 第二个格式：
 * try {
 * 		// 代码
 * } catch (Exception e) {
 * 		// 异常处理代码
 * } finally {
 * 		// 一定会执行的代码
 * }
 * 第三个格式：
 * try {
 * 		// 代码
 * } finally {
 * 		// 一定会执行的代码
 * }
 * </pre>
 * 
 * <b>注意:</b><br>
 * 1、finally中定义的通常是关闭资源代码，因为资源必须释放。<br>
 * 2、finally只有一种情况不会执行，当执行到System.exit(0);finally不会执行。<br>
 * <br>
 * <b>自定义异常：</b><br>
 * 定义类继承Exception或者RuntimeException.<br>
 * 1、为了让该自定义类具备可抛性。<br>
 * 2、让该类具备操作异常的共性方法。<br>
 * 当要定义自定义异常的信息时，可以使用父类已经定义好的功能。<br>
 * 
 * <pre>
 * 异常信息传递给父类的构造函数。<br>
 * class MyException extends Exception {
 * 		MyException(String message) {
 * 			super(message);
 * 		}
 * }
 * </pre>
 * 
 * 自定义异常：按照java的面向对象思想，将程序中出席那的特有问题进行封装。<br>
 * <br>
 * 异常的好处：<br>
 * 1、将问题进行封装;<br>
 * 2、将正常流程代码和问题处理代码相分离，方便于阅读。<br>
 * 异常的处理原则：<br>
 * 1、处理方式有两种：try 和 throws.<br>
 * 2、调用到抛出异常的功能时，抛出几个，就处理几个。<br>
 * 3、多个catch，父类的catch放到最小面。<br>
 * 4、catch内，需要定义针对性的处理方式。不要简单的定义printStackTrace,输出语句。<br>
 * 当然，也不要不写，当捕获到的异常，本功能处理不了时，可以继续在catch中抛出。<br>
 * 
 * <pre>
 * try {
 * 	throw new AException();
 * } catch (AException e) {
 * 	throw e;
 * }
 * 如果该异常处理不了，但并不属于该功能出现的异常。<br>
 * 可以将异常转换后，在抛出和该功能相关的异常。<br>
 * 或者异常可以处理，当需要将异常产生的和本功能相关的问题提供出去。<br>
 * 让调用者知道并处理，也可以将捕获异常处理后，转换新的异常。<br>
 * try {
 * 	throw new AException();
 * } catch (AException e) {
 * 	// 对AException处理.
 * 	throw new BException();
 * }
 * 比如，汇款的例子。<br>
 * </pre>
 * 
 * 异常的注意事项：<br>
 * |--在子父类覆盖时：<br>
 * |--|--1、子类抛出的异常必须死父类的异常的子类或者子集。<br>
 * |--|--2、如果父类或者接口没有异常抛出时，子类覆盖出现异常，只能try不能抛。<br>
 * <br>
 * 参阅：<br>
 * ExceptionTest.java 老师用电脑上课.<br>
 * ExceptionTest1.java 图形面积。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day10-05-面向对象(异常-总结)
 */
public class ExceptionTest2 {
	public static void main(String[] args) {
	}
}
