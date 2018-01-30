package javacore.object_oriented.day07;

/**
 * 面向对象(抽象类练习)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day07-10-面向对象(抽象类练习)
 */
public class AbstractTest {

	public static void main(String[] args) {
		Manager m = new Manager("zhangsan", "111", 2000, 1);
		m.work();
		Pro p = new Pro("lisi", "222", 1000);
		p.work();
	}
}

/**
 * 假如我们在开发一个系统时需要对员工进行建模，员工包含三个属性:<br>
 * 姓名、工号一级工资，经理也是员工，除了含有员工的属性外，另外还有一个<br>
 * 奖金属性。请使用继承的思想设计出员工类和经理类。要求类中提供必要的方法<br>
 * 进行属性访问。<br>
 * 员工类:name,id,pay.<br>
 * 经理类:继承了员工，并有自己特有的bonus。<br>
 */
abstract class Employee {
	private String name;
	private String id;
	private double pay;

	public Employee(String name, String id, double pay) {
		super();
		this.name = name;
		this.id = id;
		this.pay = pay;
	}

	public abstract void work();

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", pay=" + pay + "]";
	}

}

class Manager extends Employee {
	private int bonus;

	public Manager(String name, String id, double pay, int bonus) {
		super(name, id, pay);
		this.bonus = bonus;
	}

	@Override
	public void work() {
		System.out.println("manager work: bonus = " + bonus);
	}
}

class Pro extends Employee {

	public Pro(String name, String id, double pay) {
		super(name, id, pay);
	}

	@Override
	public void work() {
		System.out.println("pro work");
	}
}