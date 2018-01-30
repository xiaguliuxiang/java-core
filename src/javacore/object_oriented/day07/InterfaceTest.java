package javacore.object_oriented.day07;

/**
 * 面向对象(接口举例体现)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day07-15-面向对象(接口举例体现)
 */
public class InterfaceTest {
	public static void main(String[] args) {

	}
}

abstract class Student2 {
	abstract void study();

	void sleep() {
		System.out.println("sleep");
	}
}

interface Smoking {
	void smoke();
}

abstract class Sporter {
	abstract void play();
}

class ZhangSan extends Student2 implements Smoking {
	@Override
	public void study() {

	}

	@Override
	public void smoke() {

	}
}

class LiSi extends Student2 {
	@Override
	void study() {
	}
}