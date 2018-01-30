package javacore.regexp.day25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式(网页爬虫)<br>
 * <p>
 * 网页爬虫(蜘蛛)<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day25-08-正则表达式(网页爬虫)
 */
public class RegexTest2 {

	public static void main(String[] args) throws Exception {
		// getMails();
		getMails_1();
	}

	/**
	 * 获取指定文档中的邮件地址。<br>
	 * 使用获取功能。<code>Pattern</code>,<code>Matcher</code><br>
	 * 
	 * @throws IOException
	 */
	public static void getMails() throws IOException {
		BufferedReader bufr = new BufferedReader(new FileReader("file" + File.separator + "src.txt"));

		String line = null;

		String mailReg = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile(mailReg);

		while ((line = bufr.readLine()) != null) {
			Matcher m = p.matcher(line);
			while (m.find()) {
				System.out.println(m.group());
			}
		}

		bufr.close();
	}

	public static void getMails_1() throws Exception {
		URL url = new URL("https://github.com/xiaguliuxiang/IntelliJ-IDEA-Tutorial");

		URLConnection conn = url.openConnection();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line = null;

		String mailReg = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile(mailReg);

		while ((line = bufr.readLine()) != null) {
			Matcher m = p.matcher(line);
			while (m.find()) {
				System.out.println(m.group());
			}
		}

		bufr.close();
	}

}
