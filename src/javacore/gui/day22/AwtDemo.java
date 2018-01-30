package javacore.gui.day22;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * GUI(概述)<br>
 * GUI(布局)<br>
 * GUI(Frame)<br>
 * GUI(事件监听机制)<br>
 * GUI(窗体事件)<br>
 * <p>
 * GUI(图形用户界面).<br>
 * <p>
 * GUI:Graphical User Interface(图形用户接口)<br>
 * 用图形的方式，来显示计算机操作的界面，这样更方便更直观。<br>
 * <p>
 * CLI:Command Line User Interface(命令行用户接口)<br>
 * 常见的DOS命令行操作。<br>
 * 需要记忆一些常用的命令，操作不直观。<br>
 * <br>
 * Java为GUI提供的对象都存在java.awt和java.swing两个包中。<br>
 * <p>
 * Awt与Swing:<br>
 * java.awt:Abstract Window ToolKit(抽象窗口工具包),<br>
 * 需要调用本地系统方法实现功能。属重量级控件。<br>
 * javax.swing:在awt的基础上，建立的一套图形界面系统，<br>
 * 其中提供了更多的组件，而且完全由Java实现。<br>
 * 增强了移植性，属轻量级控件。<br>
 * <p>
 * 布局管理器<br>
 * 容器中的组件的排放方式，就是布局。<br>
 * 常见的布局管理器：<br>
 * <dt>FlowLayout(流式布局管理器):</dt>
 * <dd>从左到右的顺序排列。</dd>
 * <dd>Panel默认的布局管理器。</dd>
 * <dt>BorderLayout(边界布局管理器)</dt>
 * <dd>东，西，南，北，中。</dd>
 * <dd>Frame默认的布局管理器。</dd>
 * <dt>GridLayout(网格布局管理器)</dt>
 * <dd>规则的矩阵</dd>
 * <dt>CardLayout(卡片布局管理器)</dt>
 * <dd>选项卡</dd>
 * <dt>GridBagLayout(网格包布局管理器)</dt>
 * <dd>非规则的矩阵</dd>
 * <p>
 * 创建图形化界面：<br>
 * 1.创建Frame窗体。<br>
 * 2.对窗体进行基本设置。<br>
 * 比如大小，位置，布局。<br>
 * 3.定义组件。<br>
 * 4.将组件通过窗体的add()方法添加到窗体中。<br>
 * 5.让窗体显示，通过setVisible(true)方法。<br>
 * <p>
 * 事件监听机制的特点：<br>
 * 1.事件源。<br>
 * 2.事件。<br>
 * 3.监听器。<br>
 * 4.事件处理。<br>
 * <p>
 * 事件源：就是awt包或者swing包中的那些图形界面组件。<br>
 * 事件：每一个事件源都有自己特有的对应事件和共性事件。<br>
 * 监听器：将可以出发某一个事件的动作(不只一个动作),都已经封装到了监听器中。<br>
 * 以上三者，在java中都已经定义好了。<br>
 * 直接获取其对象来用就可以了。<br>
 * 我们要做的事情是，就是对产生的动作进行处理。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day22-01-GUI(概述)
 * @see 传智播客毕向东Java基础视频教程-day22-02-GUI(布局)
 * @see 传智播客毕向东Java基础视频教程-day22-03-GUI(Frame)
 * @see 传智播客毕向东Java基础视频教程-day22-04-GUI(事件监听机制)
 * @see 传智播客毕向东Java基础视频教程-day22-05-GUI(窗体事件)
 */
public class AwtDemo {
	public static void main(String[] args) {
		Frame f = new Frame("my awt");
		f.setSize(500, 400);
		f.setLocation(300, 200);
		f.setLayout(new FlowLayout());

		Button b = new Button("i am a button");

		f.add(b);

		// f.addWindowListener(new MyWin());
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("我关");
				System.exit(0);
			}

			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("我活了");
			}

			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("我被打开了，哈哈哈");
			}
		});

		f.setVisible(true);

		System.out.println("hello");
	}
}

/**
 * 因为WindowListener的子类WindowAdapter已经实现了WindowListener接口，<br>
 * 并覆盖了其中的所有方法，那么我只要继承自WindowAdapter，覆盖我需要的方法即可。
 */
class MyWin extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("window closing" + e.toString());
	}
}

/**
 * 覆盖7个方法，可是我只用到了关闭的动作。<br>
 * 其他动作都没有用到，可是却必须复写。<br>
 */
class MyWinLis implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}