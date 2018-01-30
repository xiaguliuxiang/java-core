package javacore.object_oriented.day05;

/**
 * 面向对象(概述)<br>
 * 面向对象(类与对象的关系)<br>
 * 面向对象(成员变量和局部变量)<br>
 * 面向对象(匿名对象的应用)<br>
 * <p>
 * 面向对象，三个特征：封装，继承，多态。<br>
 * 以后开发：其实就是找对象使用，没有对象，就创建一个对象。<br>
 * 找对象，建立对象，使用对象，维护对象的关系。<br>
 * <br>
 * 类和对象的关系。<br>
 * 现实生活中的对象：张三 李四。<br>
 * 想要描述：提取对象中共性内容，对具体的抽象。<br>
 * 描述时：这些对象的共性有：姓名，性别，年龄，学习java功能。<br>
 * <br>
 * 映射到java中，描述就是class定义的类。<br>
 * 具体对象就是对应java在堆内存中用new建立实体。<br>
 * <br>
 * 类就是：对现实生活中事物的描述。<br>
 * 对象：就是这类事物，实实在在存在个体。<br>
 * <br>
 * 成员变量和局部变量。<br>
 * 1、作用范围：<br>
 * 成员变量作用于整个类中，局部变量作用于函数中，或者语句中。<br>
 * 2、在内存中的位置：<br>
 * 成员变量：在堆内存中，因为对象的存在，才在内存中存在。<br>
 * 局部变量：在栈内存中。 <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day05-01-面向对象(概述)
 * @see 传智播客毕向东Java基础视频教程-day05-03-面向对象(类与对象的关系)
 * @see 传智播客毕向东Java基础视频教程-day05-04-面向对象(成员变量和局部变量)
 * @see 传智播客毕向东Java基础视频教程-day05-05-面向对象(匿名对象的应用)
 */
public class CarDemo {

	public static void main(String[] args) {
		// 生产汽车，在java中通过new操作符来完成。
		// 其实就是在堆内存产生一个实体。
		Car c = new Car();

		// 需求：将已有车的颜色改成蓝色。只会该对象做使用。在java指挥方式是：对象.对象成员。
		c.color = "blue";

		c.run();

		Car c1 = new Car();
		c1.run();

		new Car().run();
		/**
		 * <pre>
		 * 匿名对象使用方式一：
		 * 当对对象的方法只调用一次时，可以用匿名对象来完成，这样写比较简化。
		 * 如果对一个对象进行多个成员调用，必须给这个对象起个名字。
		 * 匿名对象使用方式二：
		 * 可以将匿名对象作为实际参数进行传递。
		 * </pre>
		 */
		show(new Car());
	}

	// 需求：汽车修配厂。对汽车进行改装，将来的车改成黑车，三个轮胎。
	public static void show(Car c) {
		c.num = 3;
		c.color = "black";
		c.run();
	}
}

class Car {
	// 描述颜色
	String color = "red";
	// 描述轮胎数
	int num = 4;

	// 运行行为
	void run() {
		System.out.println(color + "..." + num);
	}
}
