package javacore.multithreading.day11;

/**
 * 多线程(概述)<br>
 * 多线程(创建线程-继承Thread类)<br>
 * 多线程(创建线程-run和start特点)<br>
 * <p>
 * <dt>进程：是一个正在执行的程序。</dt>
 * <dd>每一个进程执行都有一个执行顺序。该顺序是一个执行路径，或者叫一个控制单元。</dd>
 * <dt>线程：就是进程中的一个独立的控制单元。</dt>
 * <dd>线程在控制着进程的执行。</dd>
 * <dd>一个进程中至少有一个线程。</dd>
 * <p>
 * JavaVM 启动的时候会有一个进程 java.exe.<br>
 * 该进程中至少有一个线程负责java程序的执行。<br>
 * 而且这个线程运行的代码存在于main方法中，该线程称之为主线程。<br>
 * <br>
 * 扩展：其实更细节说明jvm,jvm启动不止一个线程，还有负责垃圾回收机制的线程。<br>
 * <br>
 * 1、如何在自定义的代码中，自定义一个线程呢?<br>
 * 通过对api的查找，java已经提供了对线程这类事物的描述，就是Thread类。<br>
 * <br>
 * 创建线程的第一种方法：继承Thread类。<br>
 * 步骤：<br>
 * <ul>
 * <li>(1).定义类继承Thread.</li>
 * <li>(2).复写Thread类中的run方法。</li>
 * <dd>目的：将自定义代码存储子啊run方法，让线程运行。</dd>
 * <li>(3).调用线程的start方法。 |--该方法两个作用：启动线程，调用run方法。</li>
 * </ul>
 * <br>
 * 发现运行结果每一次都不同。<br>
 * 因为多个线程都获取cpu的执行权，cpu执行到谁，谁就运行。<br>
 * 明确一点，在某一个时刻，只能有一个程序在运行(多核除外)。<br>
 * cpu在做着快速的切换，以达到看上去是同时运行的效果。<br>
 * 我们可以形象的把多线程的运行行为理解为在互相争夺cpu的执行权。<br>
 * <br>
 * 这就是多线程的一个特性：随机性。谁抢到谁执行，至于执行多长，cpu说的算。<br>
 * <br>
 * <dt>为什么要覆盖run方法呢？</dt>
 * <dd>Thread类用于描述线程。</dd>
 * <dd>该类就定义了一个功能，用于存储线程要运行的代码。该存储功能就是run方法。</dd>
 * <dd>也就是说Thread类中的run方法，用于存储线程要运行的代码。</dd>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day11-01-多线程(概述)
 * @see 传智播客毕向东Java基础视频教程-day11-02-多线程(创建线程-继承Thread类)
 * @see 传智播客毕向东Java基础视频教程-day11-03-多线程(创建线程-run和start特点)
 */
public class ThreadDemo {

	public static void main(String[] args) {
		ThreadDemo01 td = new ThreadDemo01(); // 创建好一个线程。
		td.start(); // 开启线程并执行该线程的run方法。
		td.run(); // 仅仅是对象调用方法，而线程创建了，并没有运行。
		for (int i = 0; i < 60; i++) {
			System.out.println("main run:" + i);
		}
	}

}

class ThreadDemo01 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 60; i++) {
			System.out.println("thread run:" + i);
		}
	}
}