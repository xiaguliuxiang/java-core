package javacore.gui.day22;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GUI(鼠标事件)<br>
 * GUI(键盘事件)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day22-07-GUI(鼠标事件)
 * @see 传智播客毕向东Java基础视频教程-day22-08-GUI(键盘事件)
 */
public class MouseAndKeyEvent {
	// 定义该图形中所需的组件的引用。
	private Frame f;
	private Button but;
	private TextField tf;

	MouseAndKeyEvent() {
		init();
	}

	public void init() {
		f = new Frame("my frame");

		f.setBounds(300, 100, 500, 400);
		f.setLayout(new FlowLayout());

		tf = new TextField(20);

		but = new Button("my button");

		f.add(tf);
		f.add(but);

		myEvent();

		f.setVisible(true);
	}

	private void myEvent() {
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9) {
					System.out.println(code + "...是非法的");
					e.consume();
				}
			}
		});

		// 给Button添加一个键盘监听
		but.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyChar() + "..." + e.getKeyCode());
				System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("ctrl+enter is run");
				}
			}
		});

		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("action ok");
			}
		});

		but.addMouseListener(new MouseAdapter() {
			private int count = 1;
			private int clickCount = 1;

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("鼠标进入到该组件:" + count++);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					System.out.println("双击动作:" + clickCount++);
				} else {
					System.out.println("单击动作:" + clickCount++);
				}
			}
		});
	}

	public static void main(String[] args) {
		new MouseAndKeyEvent();
	}
}
