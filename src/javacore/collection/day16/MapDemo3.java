package javacore.collection.day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * 集合(Map扩展)<br>
 * <p>
 * Map扩展知识。<br>
 * Map集合被使用是因为具备映射关系。<br>
 * "yureban" "01" "zhangsan";<br>
 * "yureban" "02" "lisi";<br>
 * "jiuyeban" "01" "wangwu";<br>
 * "jiuyeban" "02" "zhaoliu";<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day16-09-集合(Map扩展)
 */
public class MapDemo3 {
	public static void main(String[] args) {
		HashMap<String, HashMap<String, String>> czbk = new HashMap<String, HashMap<String, String>>();

		HashMap<String, String> yure = new HashMap<String, String>();

		yure.put("01", "zhangsan");
		yure.put("02", "lisi");

		HashMap<String, String> jiuye = new HashMap<String, String>();

		jiuye.put("01", "wangwu");
		jiuye.put("02", "zhaoliu");

		czbk.put("yureban", yure);
		czbk.put("jiuyeban", jiuye);

		getStudentInfo(yure);
		getStudentInfo(jiuye);

		// 遍历czbk集合，获取所有的教室。
		Iterator<String> it = czbk.keySet().iterator();
		while (it.hasNext()) {
			String roomName = it.next();
			HashMap<String, String> room = czbk.get(roomName);
			System.out.println(roomName + ":" + room);
		}

		System.out.println("------");

		demo();
	}

	public static void getStudentInfo(HashMap<String, String> rootMap) {
		Iterator<String> it = rootMap.keySet().iterator();
		while (it.hasNext()) {
			String id = it.next();
			String name = rootMap.get(id);
			System.out.println(id + ":" + name);
		}
	}

	public static void demo() {
		HashMap<String, List<Student3>> czbk = new HashMap<String, List<Student3>>();

		List<Student3> yure = new ArrayList<Student3>();
		List<Student3> jiuye = new ArrayList<Student3>();

		czbk.put("yureban", yure);
		czbk.put("jiuyeban", jiuye);

		yure.add(new Student3("01", "zhaoyi"));
		yure.add(new Student3("04", "lisi"));
		jiuye.add(new Student3("01", "zhaoyiyi"));
		jiuye.add(new Student3("02", "qianer"));

		Iterator<String> it = czbk.keySet().iterator();
		while (it.hasNext()) {
			String roomName = it.next();
			List<Student3> room = czbk.get(roomName);
			System.out.println(roomName);
			getInfos(room);
		}
	}

	private static void getInfos(List<Student3> list) {
		Iterator<Student3> it = list.iterator();
		while (it.hasNext()) {
			Student3 s = it.next();
			System.out.println(s);
		}
	}

}

class Student3 {
	private String id;
	private String name;

	Student3(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + ":::" + name;
	}
}