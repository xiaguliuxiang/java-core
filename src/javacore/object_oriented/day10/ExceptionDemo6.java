package javacore.object_oriented.day10;

/**
 * 面向对象(异常-处理语句其他格式)<br>
 * <p>
 * 异常处理语句的格式。<br>
 * 记住一点：<br>
 * catch是用于处理异常，如果没有catch就代表异常没有被处理过，<br>
 * 如果该异常是检测时异常，那么必须声明。<br>
 * 
 * <pre>
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
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day10-02-面向对象(异常-处理语句其他格式)
 */
public class ExceptionDemo6 {
	public static void main(String[] args) throws Exception {
		new Demo().method();
	}
}

class Demo {
	public void method() throws Exception {
		try {
			throw new Exception();
		} finally {
			// 关闭资源
		}
	}
}