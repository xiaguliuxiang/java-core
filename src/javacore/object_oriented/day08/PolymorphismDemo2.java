package javacore.object_oriented.day08;

/**
 * 面向对象(多态-概念)<br>
 * 面向对象(多态-扩展性)<br>
 * 面向对象(多态-转型)<br>
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
 * @see 传智播客毕向东Java基础视频教程-day08-03-面向对象(多态-转型)
 */
public class PolymorphismDemo2 {

	public static void main(String[] args) {
		Animal2 a = new Cat2(); // 类型提升，向上转型。
		a.eat();

		// 如果想还要调用猫的特有方法时，如何操作？
		Cat2 c = (Cat2) a; // 强制将父类的引用，转成子类类型，向下转型。
		c.catchMouse();

		function(a);

		Animal2 a1 = new Dog2(); // 类型提升，向上转型。
		function(a1);

		/**
		 * 千万不要出现这样的操作，就是讲父类对象转成子类类型。<br>
		 * 我们能转换的是父类应用指向了自己的子类对象时，该应用可以被提升，也可以被强制转换。<br>
		 * 多态自始至终都是子类对象在做着变化。<br>
		 * <code>
		 * Animal2 a1 = new Animal2();
		 * Cat2 c1 = (Cat2) a1;
		 * </code>
		 */

	}

	public static void function(Animal2 a) {
		if (a instanceof Cat2) {
			Cat2 c = (Cat2) a;
			c.catchMouse();
		} else if (a instanceof Dog2) {
			Dog2 d = (Dog2) a;
			d.guardHouse();
		}
	}

}

class Animal2 {
	void eat() {
	}
}

class Cat2 extends Animal2 {
	@Override
	public void eat() {
		System.out.println("吃鱼");
	}

	public void catchMouse() {
		System.out.println("抓老鼠");
	}
}

class Dog2 extends Animal2 {
	@Override
	public void eat() {
		System.out.println("吃骨头");
	}

	public void guardHouse() {
		System.out.println("看家");
	}
}
