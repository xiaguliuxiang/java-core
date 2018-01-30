package javacore.string.day13;

/**
 * String(常见功能-获取和判断)<br>
 * String(常见功能-转换)<br>
 * String(常见功能-切割和替换)<br>
 * String(常见功能-比较和去除空格)<br>
 * <p>
 * String 类适用于描述字符串事物。<br>
 * 那么它就提供了多个方法对字符串进行操作。<br>
 * <br>
 * 常见的操作有哪些?<br>
 * "abcd"<br>
 * <ul>
 * <li><b>1.获取.</b></li>
 * <dt>1.1.字符串中包含的字符数，也就是字符串的长度。</dt>
 * <dd>int length();获取长度。</dd>
 * <dt>1.2.根据位置获取位置上的某个字符。</dt>
 * <dd>char charAt(int index);</dd>
 * <dt>1.3.根据字符串取该字符在字符串中的位置。</dt>
 * <dd>int indexOf(int ch);返回的是ch在字符串中第一次出现的位置。</dd>
 * <dd>int indexOf(int ch, int formIndex);从formIndex指定位置开始，获取ch在字符串中出现的位置。</dd>
 * <dd>int indexOf(String str);返回的是str在字符串中第一次出现的位置。</dd>
 * <dd>int indexOf(String str, int fromIndex);从formIndex指定位置开始，获取str在字符串中出现的位置。
 * </dd>
 * <li><b>2.判断.</b></li>
 * <dt>2.1.字符串中是否包含某一个子串。</dt>
 * <dd>boolena contains(str);</dd>
 * <dd>特殊之处：indexOf(str);可以索引 str 第一次出现的位置，如果返回-1，表示该str不再字符串中存在。</dd>
 * <dd>所以，也可以用于对指定判断是否包含。</dd>
 * <dd>if (str.indexOf("aa") != -1)</dd>
 * <dd>而且该方法既可以判断，又可以获取出现的位置。</dd>
 * <dt>2.2.字符中是否有内容。</dt>
 * <dd>boolean isEmpty();原理就是判断长度是否为0."",null.</dd>
 * <dt>2.3.字符串是否是以指定内容开头。</dt>
 * <dd>boolean startsWith(str);</dd>
 * <dt>2.4.字符串是否是以指定内容结尾。</dt>
 * <dd>boolean endWith(str);</dd>
 * <dt>2.5.判断字符串内容是否相同，复写了Object类汇总的equals()方法。</dt>
 * <dd>boolean equals();</dd>
 * <dt>2.6.判断内容是否相同，并忽略大小写。</dt>
 * <dd>boolean equalsIgnoreCase();</dd>
 * <li><b>3.转换.</b></li>
 * <dt>3.1.将字符数组转换成字符串。</dt>
 * <dd>构造函数:String(char[]);</dd>
 * <dd>构造函数:String(char[], offset, count);将字符数组中的一部分转成字符串。</dd>
 * <dd>静态方法:static String copyValueOf(char[]);</dd>
 * <dd>静态方法:static String copyValueOf(char[] data, int offset, int count);</dd>
 * <dd>静态方法:static String valueOf(char[]);</dd>
 * <dt>3.2.将字符串转成字符数组。</dt>
 * <dd>char[] toCharArray();</dd>
 * <dt>3.3.将字节数组转成字符串。</dt>
 * <dd>String(byte[]);</dd>
 * <dd>String(byte[], offset, count);将字节数组中的一部分转成字符串。</dd>
 * <dt>3.4.将字符串转成字节数组。</dt>
 * <dd>byte[] getBytes();</dd>
 * <dt>3.5.将基本数据类型转成字符串。</dt>
 * <dd>String valueOf(int);</dd>
 * <dd>String valueOf(double);</dd>
 * <dd>特殊：字符串和字节数组在转换过程中，是可以指定编码表的。</dd>
 * <li><b>4.替换.</b></li>
 * <dd>String replace(oldChar, newChar);</dd>
 * <li><b>5.切割.</b></li>
 * <dd>String[] split(regex);;</dd>
 * <li><b>6.子串,截取字符串中的一部分.</b></li>
 * <dd>String substring(begin);</dd>
 * <dd>String substring(begin, end);</dd>
 * <li><b>7.转换,去除空格,比较.</b></li>
 * <dt>7.1.将字符串转成大写或者小写。</dt>
 * <dd>String toUpperCase();</dd>
 * <dd>String toLowerCase();</dd>
 * <dt>7.2.将字符串两端的多个空格去除。</dt>
 * <dd>String trim();</dd>
 * <dt>7.3.对两个字符串进行自然顺序的比较。</dt>
 * <dd>int compareTo(String);</dd>
 * </ul>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day13-02-String(常见功能-获取和判断)
 * @see 传智播客毕向东Java基础视频教程-day13-03-String(常见功能-转换)
 * @see 传智播客毕向东Java基础视频教程-day13-04-String(常见功能-切割和替换)
 * @see 传智播客毕向东Java基础视频教程-day13-05-String(常见功能-比较和去除空格)
 */
public class StringMethodDemo {

	public static void main(String[] args) {

		method_7();

		// method_sub();

		// method_split();

		// method_replace();

		// method_trans();

		// method_is();

		// method_get();

		// String s1 = "abc";
		// String s2 = new String("abc");
		//
		// String s3 = "abc";
		//
		// System.out.println(s1 == s2);
		// System.out.println(s1 == s3);
	}

	public static void method_7() {
		String s = " Hello Java ";
		sop(s.toLowerCase());
		sop(s.toUpperCase());
		sop(s.trim());

		String s1 = "abc";
		String s2 = "aaa";
		sop(s1.compareTo(s2));
	}

	public static void method_sub() {
		String s = "abcdef";

		// 从指定位置开始到结尾.如果角标不存在，会出现字符串角标越界异常。
		sop(s.substring(2));
		// 包含头，不包含尾。s.substring(0, s.length());
		sop(s.substring(2, 4));
	}

	public static void method_split() {
		String s = "zhangsan,lisi,wangwu,sunliu";
		String[] arr = s.split(",");
		for (int i = 0; i < arr.length; i++) {
			sop(arr[i]);
		}
	}

	public static void method_replace() {
		String s = "hello java";
		String s1 = s.replace('a', 'n');

		sop("s = " + s);
		sop("s1 = " + s1);
		// 如果要替换的字符不存在，返回的还是原串。
		s1 = s.replace('b', 'c');
		sop("s1 = " + s1);

		s1 = s.replace("java", "world");
		sop("s1 = " + s1);
	}

	public static void method_trans() {
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f' };

		String s = new String(arr);
		sop("s = " + s);
		s = new String(arr, 1, 3);
		sop("s = " + s);

		String s1 = "zxcvbnm";
		char[] chs = s1.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			sop("ch = " + chs[i]);
		}
	}

	public static void method_is() {
		String str = "ArrayDemo.java";

		// 判断文件名称是否是Array单词开头。
		sop(str.startsWith("Array"));
		// 判断文件名称是否是.java的文件。
		sop(str.endsWith(".java"));
		// 判断文件中是否包含Demo
		sop(str.contains("Demo"));
	}

	public static void method_get() {
		String str = "abcdefag";

		// 长度
		sop(str.length());

		// 根据索引获取字符
		sop(str.charAt(4));

		// 当访问到字符串中不存在的角标时会发生StringIndexOutOfBoundException.
		try {
			sop(str.charAt(40));
		} catch (Exception e) {
			sop(e.getMessage());
		}

		// 根据字符获取索引
		sop(str.indexOf('a'));
		// 如果没有找到，返回-1.
		sop(str.indexOf('a', 3));

		// 反向索引一个字符出现的位置。
		sop(str.lastIndexOf("a"));
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
