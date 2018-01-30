package javacore.other.day18;

/**
 * 其他对象(Runtime)<br>
 * <p>
 * 该类并没有提供构造函数。<br>
 * 说明不可以new对象，那么会直接想到该类中的方法都是静态的。<br>
 * 发现该类中还有非静态方法。<br>
 * 说明该类会提供了方法获取本类对象，而且该方法是静态的，并且返回值类型是本类类型。<br>
 * 
 * 由这个特点可以看出该类使用了单例设计模式完成。<br>
 * 
 * 该方式是 static Runtime getRuntime();<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-02-其他对象(Runtime)
 */
public class RuntimeDemo {

	public static void main(String[] args) throws Exception {
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("notepad.exe");

		Thread.sleep(4000);
		p.destroy();
	}

}
