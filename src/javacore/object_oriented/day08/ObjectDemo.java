package javacore.object_oriented.day08;

/**
 * 面向对象(Object类-equals())<br>
 * 面向对象(Object类toString())<br>
 * <p>
 * Object:是所有对象的直接或者间接父类，传说中的上帝。<br>
 * 该类中定义的是肯定是所有对象都具备的功能。<br>
 * <br>
 * Object类中已经提供了对对象是否相同的比较方法。<br>
 * <br>
 * 如果自定义类中也有比较相同的功能，没有必要重新定义。<br>
 * 只要沿袭父类中的功能，建立自己特有比较内容即可。这就是覆盖。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day08-08-面向对象(Object类-equals())
 * @see 传智播客毕向东Java基础视频教程-day08-09-面向对象(Object类toString())
 */
public class ObjectDemo {
	public static void main(String[] args) {
		Demo d1 = new Demo(4);
		Demo d2 = new Demo(4);

		System.out.println(d1.compare(d2));

		System.out.println(d1.toString());
		System.out.println(Integer.toHexString(d1.hashCode()));

		System.out.println(d1.getClass().getName() + "@@" + Integer.toHexString(d1.hashCode()));
	}
}

class Demo /* extends Object */ {
	private int num;

	Demo(int num) {
		this.num = num;
	}

	public boolean compare(Demo d) {
		return this.num == d.num;
	}

	@Override
	public boolean equals(Object obj) { // Object obj = new Demo();
		if (obj instanceof Demo) {
			Demo d = (Demo) obj;
			return this.num == d.num;
		}
		return false;
	}
}