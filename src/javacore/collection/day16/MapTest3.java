package javacore.collection.day16;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 集合(TreeMap练习-字母出现的次数)<br>
 * <p>
 * 练习：<br>
 * "sdfgzxcvasdfxcvdf"获取该字符串中的字母出现的次数。<br>
 * 希望打印结果：a(1)c(2)...<br>
 * 通过结果发现，每一次字母都有对应的次数。<br>
 * 说明字母和次数之间都有映射关系。<br>
 * <br>
 * 注意了，当发现有映射关系时，可以选择map集合。<br>
 * 因为map集合中存放就是映射关系。<br>
 * <br>
 * 什么时候使用map集合呢?<br>
 * 当数据之间存在这种映射关系时，就要先想map集合。<br>
 * <br>
 * 思路：<br>
 * 1.将字符串转换侧很难过字符数组。因为要对每一个字母进行操作。<br>
 * 2.定义一个map集合，因为打印结果的字母有顺序。<br>
 * 3.遍历字符数组。<br>
 * 将每一个字母作为键去查map集合。<br>
 * 如果返回null,将该字母和1存入到map集合中。<br>
 * 如果返回不是null,说明该字母在map集合已经存在并有对应次数。<br>
 * 那么就获取该次数并进行自增，然后将该字母和自增后的次数存入到map集合中，覆盖调用原有键所对应的值。<br>
 * 4.将map集合中的数据变成指定的字符串形式返回。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day16-08-集合(TreeMap练习-字母出现的次数)
 */
public class MapTest3 {
	public static void main(String[] args) {
		String s = charCount("sdfgzxcvasdfxcvdf");
		System.out.println(s);
	}

	public static String charCount(String str) {
		char[] chs = str.toCharArray();
		TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
		for (int x = 0; x < chs.length; x++) {
			if (!((chs[x] >= 'a' && chs[x] <= 'z') || (chs[x] >= 'A' && chs[x] <= 'Z'))) {
				continue;
			}

			Integer value = tm.get(chs[x]);
			if (value == null) {
				tm.put(chs[x], 1);
			} else {
				value = value + 1;
				tm.put(chs[x], value);
			}
		}
		System.out.println(tm);

		StringBuilder sb = new StringBuilder();
		Set<Map.Entry<Character, Integer>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Character, Integer>> it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<Character, Integer> me = it.next();
			Character ch = me.getKey();
			Integer value = me.getValue();
			sb.append(ch + "(" + value + ")");
		}

		return sb.toString();
	}
}
