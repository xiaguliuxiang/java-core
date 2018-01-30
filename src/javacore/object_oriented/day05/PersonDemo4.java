package javacore.object_oriented.day05;

/**
 * 面向对象(this关键字在构造函数间调用)<br>
 * <p>
 * this语句:用于构造函数之间进行互相调用。<br>
 * this语句只能定义在构造函数的第一行，因为初始化要先执行。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day05-12-面向对象(this关键字在构造函数间调用)
 */
public class PersonDemo4 {

	public static void main(String[] args) {
		Person4 p = new Person4("zhangsan", 20);
		p.show();
	}

}

class Person4 {
	private String name;
	private int age;

	public Person4(String name) {
		this.name = name;
	}

	public Person4(String name, int age) {
		this(name); // this语句
		this.name = name;
		this.age = age;
	}

	public void show() {
		System.out.println(this.name + ", " + this.age);
	}

}
