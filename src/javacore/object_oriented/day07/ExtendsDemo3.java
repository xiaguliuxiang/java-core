package javacore.object_oriented.day07;

/**
 * 面向对象(子父类中函数的特点-覆盖)<br>
 * <p>
 * 子父类出现后，类成员的特点：<br>
 * 类中成员：<br>
 * 1、变量。<br>
 * 2、函数。<br>
 * 3、构造函数。<br>
 * <br>
 * 2、子父类中的函数。<br>
 * 当子类出现和父类一模一样的函数时。<br>
 * 当子类对象调用该函数时，会运行子类函数的内容。<br>
 * 如同父类的函数被覆盖一样。<br>
 * 这种情况是函数的另一个特性：重写(覆盖)<br>
 * 当子类继承父类，沿袭了父类的功能，到子类中。<br>
 * 但是子类虽具备该功能，但是功能的内容却和父类不一致。<br>
 * 这时，没有必要定义新功能，而是使用覆盖特殊，保留父类的功能定义，并重写功能内容。<br>
 * <br>
 * 覆盖：<br>
 * 1、子类覆盖父类，必须保证子类权限大于等于父类权限，才可以覆盖，否则编译失败。<br>
 * 2、静态只能覆盖静态。<br>
 * <br>
 * 记住：<br>
 * 重载：只看同名函数的参数列表。<br>
 * 重写：子父类方法要一模一样。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day07-05-面向对象(子父类中函数的特点-覆盖)
 */
public class ExtendsDemo3 {

	public static void main(String[] args) {
		Zi3 z = new Zi3();
		System.out.println(z.num);
		z.show();

		NewTel nt = new NewTel();
		nt.show();
	}

}

class Fu3 {
	int num = 4;
}

class Zi3 extends Fu3 {
	int num = 5;

	void show() {
		System.out.println(super.num);
	}
}

class Tel {
	void show() {
		System.out.println("number");
	}
}

class NewTel extends Tel {
	@Override
	void show() {
		// System.out.println("number");
		super.show();
		System.out.println("name");
		System.out.println("pic");
	}
}