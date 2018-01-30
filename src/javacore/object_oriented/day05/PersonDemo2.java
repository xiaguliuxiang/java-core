package javacore.object_oriented.day05;

/**
 * 面向对象(构造函数)<br>
 * 面向对象(构造代码块)<br>
 * <p>
 * 对象一建立就会调用与之对应的构造函数。<br>
 * 构造函数的作用，可以用于给对象进行初始化。<br>
 * <br>
 * 构造函数的小细节：<br>
 * 当一个类中没有定义构造函数时，那么系统会默认给该类加入一个空参数的构造函数。<br>
 * 当在类中自定义了构造函数后，默认的构造函数就没有了。<br>
 * 构造函数和一般函数在写法上有不同。<br>
 * 在运行上也有不同。<br>
 * 构造函数式在对象一建立就运行，给对象初始化。<br>
 * 而一般方法是对象调用才执行，给对象添加对象具备的功能。<br>
 * <br>
 * 一个对象的建立，构造函数只运行一次。<br>
 * 而一般方法可以被该对象调用多次。<br>
 * <br>
 * 什么时候定义构造函数呢？<br>
 * 当分析事物时，该事物存在具备一些特性或者行为，那么将这些内容定义在构造函数中。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day05-08-面向对象(构造函数)
 * @see 传智播客毕向东Java基础视频教程-day05-09-面向对象(构造代码块)
 */
public class PersonDemo2 {

	public static void main(String[] args) {

		Person2 p1 = new Person2();
		p1.cry();
		Person2 p2 = new Person2("zhangsan");
		p2.cry();
		Person2 p3 = new Person2("lisi", 20);
		p3.cry();
	}

}

class Person2 {
	private String name;
	private int age;

	/**
	 * 构造代码块。<br>
	 * 作用：给对象进行初始化。<br>
	 * 对象一建立就运行，而且优先于构造函数执行。<br>
	 * 和构造函数的区别：<br>
	 * 构造代码块是给所有的对象进行统一初始化。<br>
	 * 而构造函数是给对应的对象初始化。<br>
	 * <br>
	 * 构造代码块中定义的是不同对象共性的初始化内容。<br>
	 */
	{
		System.out.println("person code run...");
	}

	public Person2() {
		System.out.println("A:name=" + name + ",age=" + age);
	}

	public Person2(String name) {
		System.out.println("B:name=" + name + ",age=" + age);
	}

	public Person2(String name, int age) {
		System.out.println("C:name=" + name + ",age=" + age);
	}

	public void cry() {
		System.out.println("cry");
	}

}
