package javacore.object_oriented.day09;

/**
 * 面向对象(异常练习)<br>
 * <p>
 * 老师讲课。<br>
 * 开始思考上课中出现的问题。<br>
 * 比如问题是：<br>
 * 1、电脑蓝屏<br>
 * 2、电脑冒烟<br>
 * 要对问题进行描述，封装成对象。<br>
 * <br>
 * 可是当冒烟发生后，出现讲课进度无法继续。<br>
 * 出现了讲师的问题：课时计划无法完成。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day09-12-面向对象(异常练习)
 */
public class ExceptionTest {
	public static void main(String[] args) throws SmokeException {
		Teacher t = new Teacher("毕老师");
		try {
			t.prelect();
		} catch (NoPlanException e) {
			System.out.println(e.toString());
			System.out.println("换老师或者放假");
		}
	}
}

class Computer {
	private int state = 3;

	public void run() throws BlueScreenException, SmokeException {
		if (state == 2) {
			throw new BlueScreenException("蓝屏了");
		}
		if (state == 3) {
			throw new SmokeException("冒烟了");
		}
		System.out.println("电脑运行");
	}

	public void reset() {
		state = 1;
		System.out.println("电脑重启");
	}

}

@SuppressWarnings("serial")
class BlueScreenException extends Exception {
	BlueScreenException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class SmokeException extends Exception {
	SmokeException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class NoPlanException extends Exception {
	NoPlanException(String message) {
		super(message);
	}
}

class Teacher {
	private String name;
	private Computer computer;

	public Teacher(String name) {
		this.name = name;
		computer = new Computer();
	}

	public void prelect() throws NoPlanException {
		try {
			computer.run();
		} catch (BlueScreenException e) {
			computer.reset();
		} catch (SmokeException e) {
			test();
			throw new NoPlanException("课时无法继续" + e.getMessage());
		}
		System.out.println(name + "讲课");
	}

	public void test() {
		System.out.println("练习");
	}

}