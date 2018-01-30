package javacore.collection.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 集合(Collections-sort)<br>
 * 集合(Collections-max)<br>
 * 集合(Collections-binarySearch)<br>
 * <p>
 * 集合框架的工具类。<br>
 * Collections<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day17-10-集合(Collections-sort)
 * @see 传智播客毕向东Java基础视频教程-day17-11-集合(Collections-max)
 * @see 传智播客毕向东Java基础视频教程-day17-12-集合(Collections-binarySearch)
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		sortDemo();
	}

	public static void sortDemo() {
		List<String> list = new ArrayList<String>();

		list.add("abcd");
		list.add("aaa");
		list.add("z");
		list.add("qq");
		list.add("zz");

		sop(list);

		Collections.sort(list, new StrLenComparator());

		sop(list);

		String max = Collections.max(list, new StrLenComparator());
		sop("max=" + max);

		// binarySearch()返回index=(-插入点-1)
		int index = Collections.binarySearch(list, "aaaa");
		sop("index=" + index);

		index = hashSearch(list, "aaaa");
		sop("index=" + index);

		index = hashSearch2(list, "aaaa", new StrLenComparator());
		sop("index=" + index);

	}

	/**
	 * 折半查找.<br>
	 * 
	 * @param list
	 * @param key
	 * @return
	 */
	public static int hashSearch(List<String> list, String key) {
		int max, min, mid;
		max = list.size() - 1;
		min = 0;
		while (min <= max) {
			mid = (max + min) >> 1; // value/2;
			String str = list.get(mid);
			int num = str.compareTo(key);
			if (num > 0) {
				max = mid - 1;
			} else if (num < 0) {
				min = mid + 1;
			} else {
				return mid;
			}
		}
		// min 即为插入位置,-min-1即为插入(-插入点-1)
		return -min - 1;
	}

	public static int hashSearch2(List<String> list, String key, Comparator<String> cmp) {
		int max, min, mid;
		max = list.size() - 1;
		min = 0;
		while (min <= max) {
			mid = (max + min) >> 1;
			String str = list.get(mid);
			int num = cmp.compare(str, key);
			if (num > 0) {
				max = mid - 1;
			} else if (num < 0) {
				min = mid + 1;
			} else {
				return mid;
			}
		}
		return -min - 1;
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}

class StrLenComparator implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return 1;
		}
		if (s1.length() < s2.length()) {
			return -1;
		}
		return s1.compareTo(s2);
	}
}