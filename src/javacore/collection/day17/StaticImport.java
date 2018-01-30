package javacore.collection.day17;

import static java.lang.System.out;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

import java.util.Arrays;

/**
 * 集合(静态导入)<br>
 * <p>
 * StaticImport 静态导入。<br>
 * 当类名重名时，需要指定具体的包名。<br>
 * 当方法重名时，制定具备所属的对象或者类。<br>
 * 
 * <pre>
 * import static java.util.Arrays.*;
 * 导入的是Arrays这个类中的所有静态成员.
 * import static java.lang.System.*;
 * 导入了System类中所有静态成员.
 * </pre>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day17-20-集合(静态导入)
 */
public class StaticImport extends Object {

	public static void main(String[] args) {
		int[] arr = { 7, 6, 8 };

		sort(arr);

		int index = binarySearch(arr, 6);
		out.println(Arrays.toString(arr));
		out.println("index = " + index);

		Arrays.sort(arr);
		index = Arrays.binarySearch(arr, 6);
		System.out.println(Arrays.toString(arr));
		System.out.println("index = " + index);
	}

}
