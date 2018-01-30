package javacore.io.day19;

/**
 * IO流(装饰设计模式)<br>
 * IO流(装饰和继承的区别)<br>
 * <p>
 * 装饰设计模式：<br>
 * 当想要对已有的对象进行功能增强时，<br>
 * 可以定义类，将已有对象传入，基于已有的功能，并提供加强功能。<br>
 * 那么自定义的该类成为装饰类。<br>
 * <br>
 * 装饰类通常会通过构造方法接受被装饰的对象。<br>
 * 并基于被装饰的对象的功能，提供更强的功能。<br>
 * <br>
 * 装饰和继承的区别：<br>
 * 装饰模式比继承要灵活，避免了继承体系臃肿。<br>
 * 而且降低了类与类之间的关系。<br>
 * 装饰类因为增强已有对象，具备的功能和已有的是相同的，只不过提供了更强功能。<br>
 * 所以装饰类和被装饰类通常是都属于一个体系中的。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-06-IO流(装饰设计模式)
 * @see 传智播客毕向东Java基础视频教程-day19-07-IO流(装饰和继承的区别)
 */
public class PersonDemo {

	public static void main(String[] args) {
		Person p = new Person();
		p.eat();

		SuperPerson sp = new SuperPerson(p);
		sp.superEat();

	}

}

class Person {
	public void eat() {
		System.out.println("吃饭");
	}
}

class SuperPerson {
	private Person p;

	public SuperPerson(Person p) {
		super();
		this.p = p;
	}

	public void superEat() {
		System.out.println("开胃酒");
		p.eat();
		System.out.println("甜点");
		System.out.println("茶水");
	}
}
