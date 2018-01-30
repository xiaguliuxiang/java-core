package javacore.object_oriented.day06;

/**
 * 面向对象(main函数)<br>
 * <p>
 * 主函数：是一个特殊的函数，作为程序的入口，可以被jvm调用。<br>
 * 
 * 主函数的定义：<br>
 * public：代表着该函数访问权限是最大的。<br>
 * static：代表主函数随着类的加载就已经存在了。<br>
 * void：主函数没有具体点呃返回值。<br>
 * main：不是关键字，但是是一个特殊的单词，可以被jvm识别。<br>
 * (String[] args)：函数的参数，参数类型是一个数组，该数组中的元素师字符串，字符串类型的是数组。<br>
 * 
 * 主函数是固定格式的：jvm识别。<br>
 * 
 * jvm在调用主函数时，传入的是 new String[0];<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day06-02-面向对象(main函数)
 */
public class MainDemo {

	public static void main(String[] args) {
		String[] arr = { "aaa", "bbb", "ccc" };

		MainTest.main(arr);
	}

}

class MainTest {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}