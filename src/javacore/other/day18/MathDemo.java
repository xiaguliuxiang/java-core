package javacore.other.day18;

import java.util.Random;

/**
 * 其他对象(Math-Random)<br>
 * <p>
 * 其他对象(Math-Random)-练习<br>
 * 给定一个小数，保留该小数的后两位。<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-05-其他对象(Math-Random)
 */
public class MathDemo {

	public static void main(String[] args) {

		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			// int d = (int) (Math.random() * 10 + 1);
			int d = r.nextInt(10) + 1;
			sop("d = " + d);
		}

		show();
	}

	public static void show() {
		// ceil 返回大于指定数据的最小整数。
		double d = Math.ceil(12.34);
		sop("d = " + d);
		d = Math.ceil(-12.34);
		sop("d = " + d);

		// floor 返回小于指定数据的最大整数。
		d = Math.floor(12.34);
		sop("d = " + d);

		// round 四舍五入
		long l = Math.round(12.34);
		sop("l = " + l);

		// pow 返回第一个参数的第二个参数次幂的值。
		d = Math.pow(2, 3);
		sop("d = " + d);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
