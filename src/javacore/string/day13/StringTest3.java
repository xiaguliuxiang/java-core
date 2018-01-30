package javacore.string.day13;

/**
 * String(字符串练习4)<br>
 * <p>
 * 
 * <ul>
 * <li><b>1.模拟一个trim()方法，去除字符串两端的空格。思路如下：</b></li>
 * <dt>1.1.判断字符串第一个位置是否是空格，如果是继续向下判断，知道不是空格为止。</dt>
 * <dd>结尾处判断空格也是如此。</dd>
 * <dd>1.2.当开始和结尾都判断到不是空格时，就是要获取的字符串。</dd>
 * <li><b>2.将一个字符串进行反转，将字符串中指定部分进行反转。思路如下：</b></li>
 * <dt>2.1.曾经学习过对数组的元素进行反转。</dt>
 * <dt>2.2.将字符串编程数组，对数组反转。</dt>
 * <dt>2.3.将反转后的数组编程字符串。</dt>
 * <dt>2.4.只要将要反转的部分的开始和结束为止作为参数传递即可。</dt>
 * <li><b>3.获取一个字符串在另一个字符串中出现的次数。思路如下：</b></li>
 * <dt>3.1.定义一个计数器。</dt>
 * <dt>3.2.获取kk第一次出现的位置。</dt>
 * <dt>3.3.从第一次出现位置后剩余的字符串中继续获取kk出现的位置。</dt>
 * <dd>每获取一次就计数一次。</dd>
 * <dt>当获取不到时，计数完成。</dt>
 * <li><b>4.获取两个字符串中最大相同子串，第一个动作：将短的那个串进行长度依次递减的子串打印。</b></li>
 * <dt>4.1.将短的那个子串按照长度递减的方式获取到。</dt>
 * <dt>4.2.将没获取到的子串去长串中判断是否包含。</dt>
 * <dd>如果包含，已经找到。</dd>
 * </ul>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day13-09-String(字符串练习4)
 */
public class StringTest3 {

	public static void main(String[] args) {
		String s1 = "abcdefghijklmnklmn";
		String s2 = "klmnopqrstuvwxyz";
		sop(getMaxSubString(s1, s2));
	}

	/**
	 * 练习四
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String getMaxSubString(String s1, String s2) {
		String max = "", min = "";

		max = (s1.length() > s2.length()) ? s1 : s2;

		min = (max == s1) ? s2 : s1;

		sop("max = " + max + ", min = " + min);

		for (int i = 0; i < min.length(); i++) {
			for (int j = 0, k = min.length() - i; k != min.length() + 1; j++, k++) {
				String temp = min.substring(j, k);
				// sop(temp);
				if (max.contains(temp)) {
					return temp;
				}
			}
		}
		return "";
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
