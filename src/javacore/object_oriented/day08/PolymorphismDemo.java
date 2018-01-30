package javacore.object_oriented.day08;

/**
 * 面向对象(多态-概念)<br>
 * 面向对象(多态-扩展性)<br>
 * <p>
 * 多态：可以理解为事物存在的多种体现形态。<br>
 * 人：男人，女人。<br>
 * 动物：猫，狗。<br>
 * 猫 c = new 猫();<br>
 * 动物 c = new 猫();<br>
 * 
 * <pre>
 * <b>多态</b>
 * 1、多态的体现
 * 		多态的引用指向了自己的子类对象。
 * 		多态的引用页可以接收自己的子类对象。
 * 2、多态的前提
 * 		必须是类与类之间有关系，要么继承，要么实现。
 * 		通常还有一个前提：存在覆盖。
 * 3、多态的好处
 * 		多态的出现大大的提高程序的扩展性。
 * 4、多态的弊端
 * 		提高了扩展性，但是只能使用父类的引用访问父类中的成员。
 * 5、多态的应用
 * 
 * 6、多态的出现代码中的特点(多态使用的注意事项)
 * </pre>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day08-01-面向对象(多态-概念)
 * @see 传智播客毕向东Java基础视频教程-day08-02-面向对象(多态-扩展性)
 */
public class PolymorphismDemo {

	public static void main(String[] args) {
		Cat c = new Cat();
		c.eat();

		Dog d = new Dog();
		d.eat();

		function(c);
		function(d);
		function(new Pig());

	}

	public static void function(Cat c) {
		c.eat();
	}

	public static void function(Dog d) {
		d.eat();
	}

	public static void function(Pig p) {
		p.eat();
	}

	public static void function(Animal a) {
		a.eat();
	}

}

class Animal {
	void eat() {
	}
}

class Cat extends Animal {
	@Override
	public void eat() {
		System.out.println("吃鱼");
	}

	public void catchMouse() {
		System.out.println("抓老鼠");
	}
}

class Dog extends Animal {
	@Override
	public void eat() {
		System.out.println("吃骨头");
	}

	public void guardHouse() {
		System.out.println("看家");
	}
}

class Pig extends Animal {
	@Override
	public void eat() {
		System.out.println("吃饲料");
	}

	public void sleep() {
		System.out.println("睡觉");
	}
}