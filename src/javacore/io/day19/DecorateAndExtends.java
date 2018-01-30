package javacore.io.day19;

/**
 * 装饰和继承<br>
 * <p>
 * MyReader // 专门用于读取数据的类。<br>
 * 
 * <pre>
 * MyTextReader
 *     MyBufferedTextReader
 * MyMediaReader
 *     MyBufferedMediaRader
 * MyDataReader
 *     MyBufferedDataReader
 * </pre>
 * 
 * <code>
 * class MyBufferedReader {
 * 		MyBufferedReader(MyTextReader text) {}
 * 		MyBufferedReader(MyMediaReader media) {}
 * }
 * </code>
 * <p>
 * 上面这个类的扩展性很差。<br>
 * 找到七参数的共同类型，通过多态的形式，可以提高扩展性。<br>
 * <code>
 * class MyBufferedReader extends MyReader {
 * 		MyBufferedReader(MyReder r) {}
 * }
 * </code>
 * <p>
 * MyReader // 专门用于读取数据的类。<br>
 * |--MyTextReader<br>
 * |--MyMediaReader<br>
 * |--MyDataReader<br>
 * |--MyBufferedReader<br>
 * 
 * 装饰模式比继承要灵活，避免了继承体系臃肿。<br>
 * 而且降低了类与类之间的关系。<br>
 * 
 * 装饰类因为增强已有对象，具备的功能和已有的都是相同的，只不过提供了更强功能。<br>
 * 所以装饰类和被装饰类通常是都属于一个体系中的。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day19-07-IO流(装饰和继承的区别)
 */
public class DecorateAndExtends {

	public static void main(String[] args) {

	}

}
