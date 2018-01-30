package javacore.collection.day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 集合(Map-keySet)<br>
 * 集合(Map-entrySet)<br>
 * <p>
 * map集合的两种取出方式：<br>
 * 1.keySet:将map中所有的键存入到Set集合，因为Set具备迭代器。<br>
 * 所有可以迭代方式取出所有的键，再根据get()方法，获取每一个键对应的值。<br>
 * Map集合的取出原理：将Map结合转成Set结合，再通过迭代器取出。<br>
 * 2.Set<Map.Entry<k, v>> entrySet();将Map集合中的映射关系存入到了Set集合中
 * 而这个关系的数据类型就是:Map.Entry<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day16-04-集合(Map-keySet)
 * @see 传智播客毕向东Java基础视频教程-day16-05-集合(Map-entrySet)
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("02", "zhangsan2");
		map.put("03", "zhangsan3");
		map.put("01", "zhangsan1");
		map.put("04", "zhangsan4");

		// 先获取map集合的所有键的Set集合,keySet()
		Set<String> keySet = map.keySet();

		// 有了Set集合，就可以获取其迭代器。
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			// 有了键可以通过map集合的get()方法获取器对应的值。
			String value = map.get(key);
			System.out.println("key:" + key + ",value:" + value);
		}

		// 将Map集合中的映射关系取出，存入到Set集合中。
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> itm = entrySet.iterator();
		while (itm.hasNext()) {
			Map.Entry<String, String> me = itm.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println("key:" + key + ",value:" + value);
		}
	}
}

/**
 * Map.Entry 其实Entry也是一个接口，它是Map接口中的一个内部接口。<br>
 */
interface MyMap {
	public static interface Entry {
		public abstract Object getKey();

		public abstract Object getValue();
	}
}

class MyHashMap implements MyMap {
	class MyHash implements MyMap.Entry {

		@Override
		public Object getKey() {
			return null;
		}

		@Override
		public Object getValue() {
			return null;
		}
	}
}
