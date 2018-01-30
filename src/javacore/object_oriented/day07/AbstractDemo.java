package javacore.object_oriented.day07;

/**
 * 面向对象(抽象类)<br>
 * 面向对象(抽象类2)<br>
 * <p>
 * 当多个类中出现相同功能，但是功能主体不同。<br>
 * 这时可以进行向上抽取，这时，只抽取功能定义而不抽取功能主体。<br>
 * <p>
 * 抽象：看不懂。<br>
 * 抽象类的特点：<br>
 * 1、抽象方法一定在抽象类中。<br>
 * 2、抽象方法和抽象类都必须被abstract关键字修饰。<br>
 * 3、抽象类不可以用new创建对象。因为调用抽象方法没意义。<br>
 * 4、抽象类中的方法要被使用，必须由子类复写其所有的抽象方法后，建立子类对象调用。<br>
 * 如果子类中只覆盖了部分抽象方法，那么该子类还是一个抽象类。<br>
 * <br>
 * 抽象类和一般类没有太大的不同。<br>
 * 该如何描述事物，就如何描述事物。只不过，该事物出现了一些看不懂东西。<br>
 * 这些不确定的部分，也是该事物的功能，需要明确出现，但是无法定义主体。<br>
 * 通过抽象方法来表示。<br>
 * <br>
 * 抽象类比一般类多了个抽象函数。就是在类中可以定义抽象方法。<br>
 * 抽象类不可以实例化。<br>
 * <br>
 * 特殊：抽象类中可以不定义抽象方法，这样做仅仅是不让该类建立对象。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day07-08-面向对象(抽象类)
 * @see 传智播客毕向东Java基础视频教程-day07-09-面向对象(抽象类2)
 */
public class AbstractDemo {

	public static void main(String[] args) {
		new AdvStudent1();
	}

}

abstract class Student1 {
	abstract void study();

	abstract void speak();

}

abstract class BaseStudent1 extends Student1 {
	@Override
	void study() {
		System.out.println("study");
	}

	@Override
	abstract void speak();
}

class AdvStudent1 extends BaseStudent1 {
	@Override
	void study() {
		System.out.println("study");
	}

	@Override
	void speak() {
		System.out.println("speak");
	}
}
