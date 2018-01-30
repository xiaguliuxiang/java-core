package javacore.regexp.day25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式(获取)<br>
 * <p>
 * 正则表达式的第四个功能。<br>
 * 4、获取：将字符串中的符合规则的子串取出。<br>
 * 
 * 操作步骤：<br>
 * 1、将正则表达式封装成对象。<br>
 * 2、让正则对象和要操作的字符串相关联。<br>
 * 3、关联后，获取正则匹配引擎。<br>
 * 4、通过引擎对符合规则的子串进行操作，比如取出。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day25-05-正则表达式(获取)
 */
public class RegexDemo2 {

	public static void main(String[] args) {
		getDemo();
	}

	public static void getDemo() {
		String str = "ming tian jiu yao fang jia le, da jia yi ding hen kai xin!";

		String reg = "[a-z]{3}";

		// 将规则封装成对象。
		Pattern p = Pattern.compile(reg);

		// 让正则对象和要作用的字符串相关联，获取匹配器对象。
		Matcher m = p.matcher(str);

		System.out.println(m.matches());
		// 其实 String 类中的 matches() 方法，用的就是 Pattern 和 Matcher 对象来完成的。
		// 只不过被 String 的方法封装后，用起来较为简单，但是功能缺单一。

		// boolean b = m.find(); // 将规则作用到字符串上，并进行复核规则的子串查找。
		// System.out.println(b);
		// System.out.println(m.group()); // 用于获取匹配后的结果

		while (m.find()) {
			System.out.println(m.group());
			System.out.println(m.start() + "..." + m.end());
		}

	}

}
