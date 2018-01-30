package javacore.object_oriented.day10;

/**
 * 面向对象(异常-覆盖时的异常特点)<br>
 * <p>
 * 异常在子父类覆盖中的体现。<br>
 * 1、子类在覆盖父类时，如果父类的方法抛出异常，那么子类的覆盖方法，<br>
 * 只能抛出父类的异常或者该异常的子类。<br>
 * 2、如果父类方法抛出多个异常，那么子类在覆盖方法时，<br>
 * 只能抛出父类异常的子集。<br>
 * 3、如果父类或者接口的方法中没有异常抛出，那么子类在覆盖方法时，<br>
 * 也不可以抛出异常。<br>
 * 如果子类方法发生了异常，就必须要进行try处理，绝对不能抛。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day10-03-面向对象(异常-覆盖时的异常特点)
 */
public class ExceptionDemo7 {
	public static void main(String[] args) {

	}
}

@SuppressWarnings("serial")
class AException extends Exception {
}

@SuppressWarnings("serial")
class BException extends AException {

}

class Fu {
	void show() throws AException {

	}
}

class Zi extends Fu {
	@Override
	void show() throws BException {

	}
}

class Test {
	void function(Fu f) {
		try {
			f.show();
		} catch (AException e) {
			System.out.println(e.toString());
		}
	}
}