package javacore.object_oriented.day07;

/**
 * 面向对象(模版方法模式)<br>
 * <p>
 * 需求：获取一段程序运行的时间。<br>
 * 原理：获取程序开始和结束的时间并相减即可。<br>
 * 获取时间：System.currentTimeMillis();<br>
 * <br>
 * 当代码完成优化后，就可以解决这类问题。<br>
 * 这种方式，模板方法设计模式。<br>
 * 什么是模板方法呢？<br>
 * 在定义功能时，功能的一部分是确定的，但是有一部分是不确定的，而确定的部分在使用不确定的部分。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day07-11-面向对象(模版方法模式)
 */
public class TemplateDemo {

	public static void main(String[] args) {
		SubTime st = new SubTime();
		st.getTime();
	}

}

class GetTime {
	public void getTime() {
		long start = System.currentTimeMillis();

		runCode();

		long end = System.currentTimeMillis();

		System.out.println("毫秒:" + (end - start));
	}

	public void runCode() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(i);
		}
		System.out.println();
	}
}

class SubTime extends GetTime {

	@Override
	public void runCode() {
		for (int i = 0; i < 4000; i++) {
			System.out.println(i);
		}
		System.out.println();
	}
}