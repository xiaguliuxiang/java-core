package javacore.object_oriented.day10;

/**
 * 面向对象(包package)<br>
 * 面向对象(包与包之间访问)<br>
 * 面向对象(导入import)<br>
 * <p>
 * 包与包之间进行访问，被访问的包中的类以及类中的成员，需要public修饰。<br>
 * 不同包中的子类还可以直接访问父类中被protected权限修饰的成员。<br>
 * 包与包之间可以使用的权限只有两种：public protected.<br>
 * 
 * <pre>
 *          public  protected  default  private
 * 同一个类中	  ok       ok          ok     ok
 * 同一个包中      ok       ok          ok
 * 子类                  ok       ok
 * 不同包中          ok
 * </pre>
 * 
 * 为了简化类名的书写，使用一个关键字，import.<br>
 * 建议：不要写通配符 *, 需要用到包中的哪个类，就导入哪个类。<br>
 * 建议：包名不要重复，可以使用url来完成定义，url是唯一的。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day10-07-面向对象(包package)
 * @see 传智播客毕向东Java基础视频教程-day10-08-面向对象(包与包之间访问)
 * @see 传智播客毕向东Java基础视频教程-day10-09-面向对象(导入import)
 */
public class PackageDemo {
	public static void main(String[] args) {
		System.out.println("hello package");
	}
}
