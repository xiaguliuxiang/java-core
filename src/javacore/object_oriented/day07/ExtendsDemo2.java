package javacore.object_oriented.day07;

/**
 * 面向对象(子父类中变量的特点)<br>
 * <p>
 * 子父类出现后，类成员的特点：<br>
 * 类中成员：<br>
 * 1、变量。<br>
 * 2、函数。<br>
 * 3、构造函数。<br>
 * <br>
 * 1、变量<br>
 * 如果子类中出现非私有的同名成员变量时，<br>
 * 子类要访问本类中的变量，用this;子类访问父类中的同名变量，用super.<br>
 * <br>
 * super的使用和this的使用几乎一致。<br>
 * this代表的是本类对象的引用。<br>
 * super代表的是父类对象的引用。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day07-04-面向对象(子父类中变量的特点)
 */
public class ExtendsDemo2 {

	public static void main(String[] args) {
		Zi z = new Zi();
		System.out.println(z.num);
		z.show();
	}

}

class Fu {
	int num = 4;
}

class Zi extends Fu {
	int num = 5;

	void show() {
		System.out.println(super.num);
	}
}