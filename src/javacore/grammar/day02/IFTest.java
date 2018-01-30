package javacore.grammar.day02;

/**
 * 语句(if练习)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day02-18-语句(if练习)
 */
public class IFTest {

	public static void main(String[] args) {
		// 需求1:根据用户定义的数值不同，打印对应的星期英文。<br>

		int num = 2;
		if (num == 1) {
			System.out.println("Monday");
		} else if (num == 2) {
			System.out.println("Tuesday");
		} else if (num == 3) {
			System.out.println("Wednesday");
		} else if (num == 4) {
			System.out.println("Thursday");
		} else if (num == 5) {
			System.out.println("Friday");
		} else if (num == 6) {
			System.out.println("Saturday");
		} else {
			System.out.println("Sunday");
		}

		// 需求2:根据用户指定月份，打印该月份所属的季节。
		// 3,4,5 春季;6,7,8 夏季;9,10,11 秋季;12,1,2:冬季.
		int month = 2;

		if (month == 3 || month == 4 || month == 5) {
			System.out.println("春季");
		} else if (month == 6 || month == 7 || month == 8) {
			System.out.println("夏季");
		} else if (month == 9 || month == 10 || month == 11) {
			System.out.println("秋季");
		} else if (month == 12 || month == 1 || month == 2) {
			System.out.println("冬季");
		} else {
			System.out.println(month + "月份不存在");
		}

	}

}
