package javacore.object_oriented.day08;

/**
 * 面向对象(多态-示例)<br>
 * <p>
 * 
 * <pre>
 * 基础班学生：
 * 		学习，睡觉。
 * 高级班学生：
 * 		学习，睡觉。
 * 可以将这两类事物进行抽取。
 * </pre>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day08-04-面向对象(多态-示例)
 */
public class PolymorphismDemo3 {

	public static void main(String[] args) {
		BaseStudent bs = new BaseStudent();
		// bs.study();
		// bs.sleep();
		AdvStudent as = new AdvStudent();
		// as.study();
		// as.sleep();

		new DoStudent().doSome(bs);
		new DoStudent().doSome(as);
	}

}

abstract class Student {
	public abstract void study();

	public void sleep() {
		System.out.println("躺着睡");
	}
}

class DoStudent {
	public void doSome(Student stu) {
		stu.study();
		stu.sleep();
	}
}

class BaseStudent extends Student {
	@Override
	public void study() {
		System.out.println("base study");
	}

	@Override
	public void sleep() {
		System.out.println("base sleep");
	}
}

class AdvStudent extends Student {
	@Override
	public void study() {
		System.out.println("adv study");
	}

	@Override
	public void sleep() {
		System.out.println("adv sleep");
	}
}