package javacore.regexp.day25;

/**
 * 正则表达式(特点)<br>
 * 正则表达式(匹配)<br>
 * 正则表达式(切割)<br>
 * 正则表达式(替换)<br>
 * <p>
 * 正则表达式：符合一定规范的表达式。<br>
 * 作用：用于专门操作字符串。<br>
 * 特点：用于一些特定的符号来表示一些代码操作，这样就简化书写。<br>
 * 所以要学习正则表达式，就是在学习一些特殊符号的使用。<br>
 * <br>
 * 好处：可以简化对字符串的复杂操作。<br>
 * 弊端：符号定义越多，正则越长，阅读性越差。<br>
 * <br>
 * 具体操作功能：<br>
 * 1、匹配：String matchs()方法。<br>
 * 用规则匹配整个字符串，只要有一处不符合规则，就匹配结束，返回false。<br>
 * 2、切割：String split() 方法。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day25-01-正则表达式(特点)
 * @see 传智播客毕向东Java基础视频教程-day25-02-正则表达式(匹配)
 * @see 传智播客毕向东Java基础视频教程-day25-03-正则表达式(切割)
 * @see 传智播客毕向东Java基础视频教程-day25-04-正则表达式(替换)
 */
public class RegexDemo {

	public static void main(String[] args) {
		// checkQQ();
		// checkQQ_1();

		// demo();
		// checkTel();

		// splitDemo("zhangsan lisi wangwu", " +"); // 按照多个空格来进行切割
		// splitDemo("zhangsan.lisi.wangwu", "\\."); // 按照.来进行切割
		// splitDemo("c:\\abc\\a.txt", "\\\\"); // 按照 \\ 来进行切割
		// splitDemo("erkktyqquizzo", "(.)\\1"); // 按照叠词完成切割
		// 为了可以让规则的结果被重用，可以将规则封装成一个组，用()完成。
		// 组的出现都有编号，从1开始，想要使用已有的组可以通过 \n(n就是组的编号) 的形式来获取。

		// 将字符串中的数据替换成#
		replaceAllDemo("wer12345678ty356784uiod23457f", "\\d{5,}", "#");
		// 将重叠的字符替换成单个字母
		replaceAllDemo("erkktyqqquizzzzzo", "(.)\\1+", "$1");
	}

	/**
	 * 将字符串中的数据替换成其他字符
	 * 
	 * @param str
	 * @param reg
	 * @param newStr
	 */
	public static void replaceAllDemo(String str, String reg, String newStr) {
		str = str.replaceAll(reg, newStr);
		System.out.println(str);
	}

	public static void splitDemo(String str, String reg) {
		String[] arr = str.split(reg);
		System.out.println("arr.length:" + arr.length);
		for (String s : arr) {
			System.out.println(s);
		}
	}

	/**
	 * 匹配手机号<br>
	 * 手机号段只有：13xxx, 15xxx, 18xxx
	 */
	public static void checkTel() {
		String tel = "13900001111";
		String telReg = "1[358]\\d{9}";
		System.out.println(tel.matches(telReg));
	}

	public static void demo() {
		String str = "ba";
		String reg = "[bcd][a-z]";
		boolean b = str.matches(reg);
		System.out.println(b);
	}

	/**
	 * 对QQ号码进行校验。<br>
	 * 要求：5-15,0不能开头，只能是数字。<br>
	 * 
	 * 这种方式，使用了 String 类中的方法，记性组合完成了需求，但是代码过于复杂。<br>
	 */
	public static void checkQQ() {
		String qq = "1867830";

		int len = qq.length();

		if (len >= 5 && len <= 15) {
			if (!qq.startsWith("0")) {
				try {
					long l = Long.parseLong(qq);
					System.out.println("qq:" + l);
				} catch (NumberFormatException e) {
					System.out.println("出现非法字符……");
				}

				// char[] arr = qq.toCharArray();
				// boolean flag = true;
				// for (int i = 0; i < arr.length; i++) {
				// if (!(arr[i] >= '0' && arr[i] <= '9')) {
				// flag = false;
				// break;
				// }
				// }
				// if (flag) {
				// System.out.println("qq:" + qq);
				// } else {
				// System.out.println("出现非法字符");
				// }
			} else {
				System.out.println("不可以以0开始");
			}
		}
	}

	public static void checkQQ_1() {
		String qq = "12345678";

		// String regex = "[1-9][0-9]{4,14}";
		String regex = "[1-9]\\d{4,14}";

		boolean flag = qq.matches(regex);
		if (flag) {
			System.out.println(qq + " …… is ok");
		} else {
			System.out.println(qq + " …… is illegal");
		}
	}

}
