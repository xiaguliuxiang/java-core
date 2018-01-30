package javacore.object_oriented.day10;

/**
 * 面向对象(异常-练习)<br>
 * <p>
 * 练习。<br>
 * 有一个圆形和长方形，都可以获取面积。<br>
 * 对于面积如果出现非法的数值，视为是获取面积出现问题。<br>
 * 问题通过异常来表示，现在对这个程序进行基本设计。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day10-04-面向对象(异常-练习)
 */
public class ExceptionTest1 {
	public static void main(String[] args) {
		Rectangle r;
		Circle c;
		try {
			r = new Rectangle(-3, 4);
			r.getArea();
		} catch (InvalidValueException e) {
			System.out.println(e.toString());
		}
		try {
			c = new Circle(3);
			c.getArea();
		} catch (InvalidValueException e) {
			System.out.println(e.toString());
		}
	}
}

interface Shape {
	void getArea();
}

@SuppressWarnings("serial")
class InvalidValueException extends Exception {
	InvalidValueException(String message) {
		super();
	}
}

class Rectangle implements Shape {
	private int length, width;

	public Rectangle(int length, int width) throws InvalidValueException {
		if (length <= 0 || width <= 0) {
			throw new InvalidValueException("出错了");
		}
		this.length = length;
		this.width = width;
	}

	@Override
	public void getArea() {
		System.out.println(length * width);
	}
}

class Circle implements Shape {
	private int radius;

	public Circle(int radius) throws InvalidValueException {
		if (radius <= 0) {
			throw new InvalidValueException("出错了");
		}
		this.radius = radius;
	}

	@Override
	public void getArea() {
		System.out.println(Math.PI * radius * radius);
	}
}
