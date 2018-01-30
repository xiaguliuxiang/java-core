package javacore.other.day18;

import java.util.Calendar;

/**
 * 其他对象(Calendar)<br>
 * <p>
 * 其他对象(Calendar)-两个练习 <br>
 * <p>
 * 1、获取任意年的二月有多少天。<br>
 * 思路：根据指定年设置一个时间就是。<br>
 * <code>c.set(year, 2, 1);</code> // 某一年的3月1日<br>
 * <code>c.add(Calendar.DAY_OF_MONTH, -1);</code> // 3月1日，往前推一天，就是2月最后一天。<br>
 * 
 * 2、获取昨天的现在这个时刻。<br>
 * <code>c.add(Calendar.DAY_OF_MONTH, -1);</code><br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day18-04-其他对象(Calendar)
 */
public class CalendarDemo2 {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();

		c.set(2017, 7, 20);

		c.add(Calendar.MONTH, 4);

		printCalendar(c);
	}

	public static void printCalendar(Calendar c) {

		String[] mons = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };

		String[] weeks = { "", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

		int index1 = c.get(Calendar.MONTH);

		int index2 = c.get(Calendar.DAY_OF_WEEK);

		sop(c.get(Calendar.YEAR) + "年");
		sop(mons[index1]);
		sop(c.get(Calendar.DAY_OF_MONTH) + "日");
		sop(weeks[index2]);

	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}
