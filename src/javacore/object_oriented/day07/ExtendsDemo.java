package javacore.object_oriented.day07;

/**
 * 面向对象(继承-概述)<br>
 * 面向对象(继承-概述2)<br>
 * 面向对象(聚集关系)<br>
 * <p>
 * 继承：<br>
 * 1、提高了代码的复用性。<br>
 * 2、让类与类之间产生了古纳西，有了这个关系，才有了多态的特性。<br>
 * <br>
 * 注意：千万不要为了获取其他类的功能，简化代码而继承。<br>
 * 必须是类与类之间有所属关系才可以继承，所属关系 is a.<br>
 * <br>
 * Java语言中:Java只支持单继承，不支持多继承。<br>
 * 因为多继承容易带来安全隐患。<br>
 * 当多个父类中定义了相同功能，当功能内容不同，子类对象不确定要运行哪一个。<br>
 * 但是Java保留了这种机制，并用另一种体现形式来完成表示，多实现。<br>
 * <br>
 * Java支持多层继承，也就是一个继承体系。<br>
 * 如何使用一个继承体系中的功能呢？<br>
 * 想要使用体系，先查阅体系父类的描述，因为父类中定义的是该体系中共性功能。<br>
 * 通过了解共性功能，就可以知道该体系的基本功能。<br>
 * 那么这个体系已经可以基本使用了。<br>
 * <br>
 * 那么在具体调用时，要创建最子类的对象，为什么呢？<br>
 * 1、因为有可能父类不能创建对象。<br>
 * 2、创建子类对象可以使用更多的功能，包括基本的也包括特有的。<br>
 * <br>
 * 简单一句话：查阅父类功能，创建子类对象使用功能。<br>
 * <br>
 * 聚集：has a.<br>
 * 聚合<br>
 * 组合<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day07-01-面向对象(继承-概述)
 * @see 传智播客毕向东Java基础视频教程-day07-02-面向对象(继承-概述2)
 * @see 传智播客毕向东Java基础视频教程-day07-03-面向对象(聚集关系)
 */
public class ExtendsDemo {

	public static void main(String[] args) {

	}

}

/**
 * 将学生和工人的共性描述提取出来，单独进行描述。<br>
 * 只要让学生和工人与单独描述的这个类有关系，就可以了。<br>
 */
class Person {
	String name;
	int age;

}

class Student extends Person {
	String name;
	int age;

	void study() {
		System.out.println("good study");
	}
}

class Worker extends Person {
	String name;
	int age;

	void work() {
		System.out.println("good work");
	}
}