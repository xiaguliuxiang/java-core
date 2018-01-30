package javacore.collection.day15;

/**
 * 集合框架(泛型接口)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-11-集合框架(泛型接口)
 */
public class GenericDemo5 {
	public static void main(String[] args) {
		InterImpl i = new InterImpl();
		i.show("hello");

		InterImpl1<Integer> i1 = new InterImpl1<Integer>();
		i1.show(4);
	}
}

/**
 * 泛型定义在接口上<br>
 */
interface Inter<T> {
	void show(T t);
}

class InterImpl implements Inter<String> {
	@Override
	public void show(String t) {
		System.out.println("show:" + t);
	}
}

class InterImpl1<T> implements Inter<T> {
	@Override
	public void show(T t) {
		System.out.println("show:" + t);
	}
}