package javacore.collection.day14;

import java.util.LinkedList;

/**
 * 集合框架(LinkedList练习)<br>
 * <p>
 * 使用LinkedList模拟一个堆栈或者队列数据结构。<br>
 * <br>
 * 堆栈：先进后出，如同一个杯子。<br>
 * 队列：先进先出，First in First out, FIFO, 如同一个水管。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day14-09-集合框架(LinkedList练习)
 */
public class LinkedListTest {

	public static void main(String[] args) {
		MyQueue mq = new MyQueue();

		mq.myAdd("java01");
		mq.myAdd("java02");
		mq.myAdd("java03");
		mq.myAdd("java04");

		while (!mq.isNull()) {
			System.out.println(mq.myGet());
		}
	}

}

class MyQueue {
	private LinkedList<Object> link;

	MyQueue() {
		link = new LinkedList<Object>();
	}

	public void myAdd(Object obj) {
		link.addFirst(obj);
	}

	public Object myGet() {
		return link.removeLast();
	}

	public boolean isNull() {
		return link.isEmpty();
	}
}
