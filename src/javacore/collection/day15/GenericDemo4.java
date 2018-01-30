package javacore.collection.day15;

/**
 * 集合框架(泛型方法)<br>
 * 集合框架(静态方法泛型)<br>
 * <p>
 * 泛型类定义的泛型，在整个类中有效。<br>
 * 如果被方法使用，那么泛型类的对象明确要擦做的具体类型后，所有要操作的类型就已经固定了。<br>
 * 为了让不同方法可以操作不同类型，而且类型还不确定。<br>
 * 那么可以将泛型定义在方法上。<br>
 * <br>
 * 特殊之处：<br>
 * 静态方法不可以访问类上定义的泛型。<br>
 * 如果静态方法操作的应用数据类型不确定，可以将泛型定义在方法上。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-09-集合框架(泛型方法)
 * @see 传智播客毕向东Java基础视频教程-day15-10-集合框架(静态方法泛型)
 */
public class GenericDemo4 {
	public static void main(String[] args) {
		Demo<Integer> d = new Demo<Integer>();
		d.show(new Integer(4));
		d.print(9);

		Demo.method(10);
	}
}

class Demo<T> {
	public void show(T t) {
		System.out.println("show:" + t);
	}

	public void print(T t) {
		System.out.println("print:" + t);
	}

	public static <T> void method(T t) {
		System.out.println("method:" + t);
	}

}
