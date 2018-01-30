package javacore.collection.day15;

/**
 * 集合框架(泛型类)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day15-08-集合框架(泛型类)
 */
public class GenericDemo3 {

	public static void main(String[] args) {
		Tool t = new Tool();
		t.setObject(new Worker());
		Worker w = (Worker) t.getObject();
		System.out.println(w);

		Utils<Worker> u = new Utils<Worker>();
		u.setObject(new Worker());
		Worker uw = (Worker) u.getObject();
		System.out.println(uw);
	}

}

class Worker {

}

/**
 * 泛型前的做法。<br>
 */
class Tool {
	private Object obj;

	public Object getObject() {
		return obj;
	}

	public void setObject(Object obj) {
		this.obj = obj;
	}
}

/**
 * 泛型类.<br>
 * 什么时候定义泛型类?<br>
 * 早起定义Object来完成扩展。<br>
 * 现在定义泛型来完成扩展。<br>
 */
@SuppressWarnings("hiding")
class Utils<Object> {
	private Object obj;

	public Object getObject() {
		return obj;
	}

	public void setObject(Object obj) {
		this.obj = obj;
	}
}