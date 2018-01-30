package javacore.object_oriented.day06;

/**
 * 面向对象(帮助文档的制作javadoc)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day06-05-面向对象(帮助文档的制作javadoc)
 */
public class ArrayToolDemo {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 87, 32, 8 };

		// 建立ArrayTool对象调用方法。
		// ArrayTool tool = new ArrayTool();
		// int max = tool.getMax(arr);
		// System.out.println("max:" + max);
		// tool.printArray(arr);
		// tool.selectSort(arr);
		// tool.printArray(arr);

		int max = ArrayTool.getMax(arr);
		System.out.println("max:" + max);
		ArrayTool.printArray(arr);
		ArrayTool.selectSort(arr);
		ArrayTool.printArray(arr);

	}

}
