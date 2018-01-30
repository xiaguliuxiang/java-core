package javacore.gui.day22;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GUI(Action事件)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day22-06-GUI(Action事件)
 */
public class FrameDemo {
	// 定义该图形中所需的组件的引用。
	private Frame f;
	private Button but;

	FrameDemo() {
		init();
	}

	public void init() {
		f = new Frame("my frame");
		// 对Frame进行基本设置。
		f.setBounds(300, 100, 500, 400);
		f.setLayout(new FlowLayout());

		but = new Button("my button");

		// 将组件添加到Frame中
		f.add(but);

		// 加载一下窗体上事件
		myEvent();

		// 显示窗体
		f.setVisible(true);
	}

	private void myEvent() {
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		/**
		 * 让按钮具备退出程序的功能。<br>
		 * 按钮就是事件源。<br>
		 * 那么选择哪个监听器呢?<br>
		 * 通过关闭窗体示例了解到，想要知道哪个组件具备什么样的特有监听器。<br>
		 * 需要查看该组件对象的功能。<br>
		 * 通过查阅button的描述，发现按钮支持一个特有监听 addActionListener().<br>
		 */
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("退出，按钮干的");
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new FrameDemo();
	}
}
