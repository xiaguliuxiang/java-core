package javacore.grammar.day02;

/**
 * 语句(Switch)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day02-19-语句(Switch)
 */
public class SwitchDemo {

	public static void main(String[] args) {
		int x = 2;

		// byte short int char
		switch (x) {
		case 1:
			System.out.println("a");
			break;
		case 2:
			System.out.println("b");
			break;
		case 3:
			System.out.println("c");
			break;
		default:
			System.out.println();
		}
	}

}
