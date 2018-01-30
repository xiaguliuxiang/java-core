package javacore.grammar.day02;

/**
 * 语句(Switch练习)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day02-20-语句(Switch练习)
 */
public class SwitchTest {

	public static void main(String[] args) {
		// 需求:根据用户指定月份，打印该月份所属的季节。
		// 3,4,5 春季;6,7,8 夏季;9,10,11 秋季;12,1,2:冬季.
		int month = 4;

		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println(month + ":春季");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println(month + ":夏季");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println(month + ":秋季");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println(month + ":冬季");
			break;
		default:
			System.out.println("月份有误");
		}

		/**
		 * if和swicth语句很像。<br>
		 * 具体什么场景下，应用哪个语句呢?<br>
		 * 如果判断的具体数量不多，而且符合 byte short int char 这四种类型。<br>
		 * 虽然两个语句都可以使用，简易使用switch语句，因为效率稍高。<br>
		 * 
		 * 其他情况，对区间判断，对结果为boolean类型判断，使用if，if的使用范围更广。<br>
		 */
	}

}
