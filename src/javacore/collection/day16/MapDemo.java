package javacore.collection.day16;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 集合(Map概述)<br>
 * 集合(Map子类对象特点)<br>
 * 集合(Map共性方法)<br>
 * <p>
 * Map集合：该集合存储键值对。一对一对往里存，而且要保证键的唯一性。<br>
 * <ul>
 * <li>1.添加。</li>
 * <dt>put(K key, V value);</dt>
 * <dt>putAll(Map<> extends K, ? extends V> m);</dt>
 * <li>2.删除。</li>
 * <dt>clear();</dt>
 * <dt>remove(Object key);</dt>
 * <li>3.判断。</li>
 * <dt>containsValue(Object value);</dt>
 * <dt>containsKey(Object key);</dt>
 * <dt>isEmpty();</dt>
 * <li>4.获取。</li>
 * <dt>get(Object key);</dt>
 * <dt>size();</dt>
 * <dt>values();</dt>
 * <dt>entrySet();</dt>
 * <dt>keySet();</dt>
 * </ul>
 * <p>
 * Map<br>
 * <ul>
 * <li>Hashtable:底层是哈希表数据结构。不可以存入null键null值，该集合时线程同步的。jdk1.0出现，效率低。</li>
 * <li>HashMap:底层是哈希表数据结构。允许使用null键和null值，该集合时不同步的。jdk1.2出现，效率高。</li>
 * <li>TreeMap:底层是二叉树数据结构。线程不同步，可以用于给map集合中的键进行排序。</li>
 * <li></li>
 * <dt></dt>
 * </ul>
 * 和Set很像。<br>
 * 其实，Set底层就是使用了Map集合。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day16-01-集合(Map概述)
 * @see 传智播客毕向东Java基础视频教程-day16-02-集合(Map子类对象特点)
 * @see 传智播客毕向东Java基础视频教程-day16-03-集合(Map共性方法)
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();

		// 添加元素
		// 如果出现添加时，相同的键，那么后添加的值会覆盖原有键对应值，并put()方法会返回被覆盖的值。
		map.put("01", "zhangsan1");
		map.put("02", "zhangsan2");
		map.put("03", "zhangsan3");

		System.out.println("containsKey:" + map.containsKey("022"));
		System.out.println("remove:" + map.remove("023"));
		System.out.println("get:" + map.get("023"));

		// 可以通过get方法的返回值来判断一个键是否存在，通过返回null来判断。

		map.put(null, "haha");

		System.out.println("get:" + map.get(null));

		// 获取map集合中所有的值。
		Collection<String> coll = map.values();
		System.out.println(coll);

		System.out.println(map);

	}
}
