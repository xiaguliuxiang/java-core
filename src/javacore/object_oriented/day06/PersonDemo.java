package javacore.object_oriented.day06;

/**
 * 面向对象(对象的初始化过程)<br>
 * 面向对象(对象调用成员过程)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day06-07-面向对象(对象的初始化过程)
 * @see 传智播客毕向东Java基础视频教程-day06-08-面向对象(对象调用成员过程)
 */
public class PersonDemo {

	public static void main(String[] args) {
		Person1 p1 = new Person1();
		p1.speak();

		Person1 p2 = new Person1("lisi", 20);
		p2.speak();

		Person1.showCountry();
		/**
		 * <code>Person1 p2 = new Person1("lisi", 20);</code><br>
		 * 这句话都做了什么事情?<br>
		 * 1、因为new用到了Person1.class,所以会先扎到Person1.class文件并加载到内存中。<br>
		 * 2、执行该类中的static代码块，如果有的话，给Person1.class类进行初始化。<br>
		 * 3、在堆内存中开辟空间，分配内存地址。<br>
		 * 4、在堆内存中建立对象的特有属性，并进行默认初始化。<br>
		 * 5、对属性进行显式初始化。<br>
		 * 6、对对象进行构造代码块初始化。<br>
		 * 7、对对象进行对应的构造函数初始化。<br>
		 * 8、将内存地址赋给栈内存中的p2变量。<br>
		 */
	}
}

class Person1 {
	private String name = "zhangsan";
	private int age;
	private static String country = "cn";

	public Person1() {
	}

	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	{
		System.out.println(this.name + "..." + this.age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void speak() {
		System.out.println("speak:" + this.name);
	}

	public static void showCountry() {
		System.out.println("country:" + country);
		method();
	}

	public static void method() {
		System.out.println("method run");
	}

}