package javacore.string.day13;

/**
 * 基本数据类型对象包装类<br>
 * <p>
 * byte Byte<br>
 * short short<br>
 * int Integer<br>
 * long Long<br>
 * boolean Boolean<br>
 * float Float<br>
 * double Double<br>
 * char Character<br>
 * <br>
 * 基本数据类型对象包装类的最常见应用:<br>
 * 就是用于基本数据类型和字符串类型之间做转换。<br>
 * <p>
 * <dt>基本数据类型转成字符串。</dt>
 * <dd>基本数据类型 + ""</dd>
 * <dd>基本数据类型.toString(基本数据类型值);</dd>
 * <dt>字符串转成基本数据类型。</dt>
 * <dd>xxx a = Xxx.parseXxx(String);</dd>
 * <dd>int a = Integer.parseInt("123");</dd>
 * <dd>double d = Double.parseDouble("12.34");</dd>
 * <dd>boolean b = Boolean.parseBoolean("true");</dd>
 * <dd>Integer i = new Integer("123");</dd>
 * <dd>int num = i.intValue();</dd>
 * <dt>十进制转成其他进制。</dt>
 * <dd>toBinaryString();</dd>
 * <dd>toHexString();</dd>
 * <dd>toOctalString();</dd>
 * <dt>其他进制转成十进制。</dt>
 * <dd>parseInt(String, radix);</dd>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day13-13-基本数据类型对象包装类
 */
public class IntegerDemo {

	public static void main(String[] args) {
		// 整数类型的最大值
		sop("int max = " + Integer.MAX_VALUE);

		// 将一个字符串转成整数
		int num = Integer.parseInt("123"); // 必须传入数字格式的字符串
		sop("num = " + num);

		long x = Long.parseLong("123");
		sop("x = " + x);

		sop(Integer.toBinaryString(-6));
		sop(Integer.toHexString(60));
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
