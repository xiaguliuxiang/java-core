package javacore.string.day13;

/**
 * StringBuffer(常见功能-添加)<br>
 * StringBuffer(常见功能-删除和修改)<br>
 * StringBuilder<br>
 * <p>
 * StringBuffer是字符串缓冲区，是一个容器。<br>
 * 1.且长度是可变化的。<br>
 * 2.可以直接操作多个数据类型。<br>
 * 3.最终会通过toString()方法编程字符串。<br>
 * <br>
 * CURD:create update read delete.<br>
 * <ul>
 * <li><b>1.存储.</b></li>
 * <dt>StringBuffer append();</dt>
 * <dd>将制定数据作为参数添加到已有数据结尾处。</dd>
 * <dt>StringBuffer insert(index, 数据);</dt>
 * <dd>可以将数据插入到指定index位置。</dd>
 * <li><b>2.删除.</b></li>
 * <dt>StringBuffer delete(start, end);</dt>
 * <dd>删除缓冲区中的数据，包含start,不含好end.</dd>
 * <dt>StringBuffer deleteCharAt(index);</dt>
 * <dd>删除指定位置的字符。</dd>
 * <li><b>3.获取.</b></li>
 * <dt>char charAr(int index);</dt>
 * <dt>int indexOf(String str);</dt>
 * <dt>int lastIndexOf(String str);</dt>
 * <dt>int length();</dt>
 * <dt>String substring(int start, int end);</dt>
 * <li><b>4.修改.</b></li>
 * <dt>StringBuffer replace(start, end, string);</dt>
 * <dt>void setCharAt(int index, char ch);</dt>
 * <li><b>5.反转.</b></li>
 * <dt>StringBuffer reverse();</dt>
 * <li><b>6.其他.</b></li>
 * <dt>void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin);</dt>
 * <dd>将缓冲区中指定数据存储到指定字符数组中。</dd>
 * </ul>
 * <br>
 * JDK1.5版本之后出现了StringBuilder.<br>
 * StringBuffer 是线程同步的，StringBuilder 是非线程同步的。<br>
 * 以后开发，建议使用StringBuilder.<br>
 * <br>
 * 升级三个因素：<br>
 * 1.提高效率。<br>
 * 2.简化书写。<br>
 * 3.提高安全性。<br>
 * <br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day13-10-StringBuffer(常见功能-添加)
 * @see 传智播客毕向东Java基础视频教程-day13-11-StringBuffer(常见功能-删除和修改)
 * @see 传智播客毕向东Java基础视频教程-day13-12-StringBuilder
 */
public class StringBufferDemo {

	public static void main(String[] args) {
		// method_add();
		// method_del();
		// method_update();
		method_getChars();
	}

	public static void method_add() {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = sb.append(34);
		sb.append("abc").append(true).append(34);

		sop("sb==sb1:" + (sb == sb1));
		sop(sb.toString());
		sop(sb1.toString());

		sb.insert(10, "qq");
		sop(sb.toString());
	}

	public static void method_del() {
		StringBuffer sb = new StringBuffer("abcde");

		sb.delete(1, 3);
		// 清空缓冲区
		// sb.delete(0, sb.length());

		sb.delete(2, 2);

		sop(sb.toString());
	}

	public static void method_update() {
		StringBuffer sb = new StringBuffer("abcde");
		sb.replace(1, 3, "java");
		sb.setCharAt(3, 'h');

		sop(sb.toString());
	}

	public static void method_getChars() {
		StringBuffer sb = new StringBuffer("abcdef");
		char[] chs = new char[4];

		sb.getChars(1, 3, chs, 1);

		for (int i = 0; i < chs.length; i++) {
			sop("chs[" + i + "] = " + chs[i]);
		}
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
