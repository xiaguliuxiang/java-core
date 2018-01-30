package javacore.object_oriented.day10;

/**
 * 面向对象(异常-finally)<br>
 * <p>
 * finally代码块：定义一定执行的代码。<br>
 * 通常用于关闭资源。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day10-01-面向对象(异常-finally)
 */
public class ExceptionDemo5 {
	public static void main(String[] args) {
		Demo5 d = new Demo5();
		try {
			int x = d.div(4, -1);
			System.out.println("x = " + x);
		} catch (NegativeException e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("finally"); // finally中存放的是一定会执行的代码
		}
		System.out.println("over");
	}

	public void method() {
		try {
			// 连接数据库;
			// 数据操作; throw new SQLException();
		} catch (Exception e) {
			// 会对数据库进行异常处理
			// throw new SQLException("执行SQL失败");
		} finally {
			// 关闭数据库; 该动作，无论数据操作是否成功，一定要关闭资源。
		}
	}
}

@SuppressWarnings("serial")
class NegativeException extends Exception {
	public NegativeException(String msg) {
		super(msg);
	}
}

class Demo5 {
	int div(int a, int b) throws NegativeException {
		if (b < 0) {
			throw new NegativeException("除数为负数");
		}
		return a / b;
	}
}
