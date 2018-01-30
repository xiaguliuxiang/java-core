package javacore.string.day13;

/**
 * 基本数据类型对象包装类新特性<br>
 * <p>
 * JDK1.5版本以后出现的新特性。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day13-14-基本数据类型对象包装类新特性
 */
public class IntegerDemo1 {

	public static void main(String[] args) {
		method();

		Integer x = 4; // 自动装箱
		// x = 2 : x 进行自动装箱,变成了int类型,和2进行加法运算,再将和进行装箱赋给x.
		x = x + 2;
		x = x.intValue() + 2;
		sop("x = " + x);

		Integer m = 128;
		Integer n = 128;
		sop("m==n : " + (m == n));

		Integer a = 127;
		Integer b = 127;
		// 结果为true,因为a和b指向了同一个Integer对象。
		// 因为当数值在byte范围内时，对于新特性，如果该数值已经存在，则不会再开辟新的空间。
		sop("a==b : " + (a == b));
	}

	public static void method() {
		Integer x = new Integer("123");
		Integer y = new Integer(123);

		sop("x==y : " + (x == y));
		sop("x.equals(y) : " + x.equals(y));
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
