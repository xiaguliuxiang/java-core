package javacore.object_oriented.day05;

/**
 * 面向对象(封装概述)<br>
 * 面向对象(封装private)<br>
 * <p>
 * private:私有，权限修饰符，用于修饰类中的成员（成员变量，成员函数）。<br>
 * 私有只在本类中有效。<br>
 * <br>
 * 将 age 私有化以后，类以外即使建立了对象也不能直接访问。<br>
 * 但是人应该有年龄，就需要在Person类中提供对应访问age的方式。<br>
 * <br>
 * 注意：私有仅仅是封装的一种表现形式。<br>
 * <br>
 * 之所以对外提供访问方式，就因为可以在访问方式中加入逻辑判断等语句。<br>
 * 对访问的数据进行操作，提高代码健壮性。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day05-06-面向对象(封装概述)
 * @see 传智播客毕向东Java基础视频教程-day05-07-面向对象(封装private)
 */
public class PersonDemo {

	public static void main(String[] args) {

		Person p = new Person();
		p.setAge(20);
		p.speak();
		p.setAge(220);
	}

}

class Person {
	private int age;

	public void setAge(int age) {
		if (age > 0 && age < 130) {
			this.age = age;
		} else {
			System.out.println("illegal age:" + age);
		}
	}

	void speak() {
		System.out.println("age = " + age);
	}
}
