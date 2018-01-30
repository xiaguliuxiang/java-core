package javacore.other.day18;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 其他对象(Calendar)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-04-其他对象(Calendar)
 */
public class CalendarDemo {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();

		String[] mons = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };

		String[] weeks = { "", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

		int index1 = c.get(Calendar.MONTH);

		int index2 = c.get(Calendar.DAY_OF_WEEK);

		sop(c.get(Calendar.YEAR) + "年");
		sop(mons[index1]);
		sop(c.get(Calendar.DAY_OF_MONTH) + "日");
		sop(weeks[index2]);

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(d);
		System.out.println("year = " + year);

	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
