package javacore.gui.day22;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

/**
 * GUI(练习-列出指定目录内容)<br>
 * GUI(对话框Dialog)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day22-09-GUI(练习-列出指定目录内容)
 * @see 传智播客毕向东Java基础视频教程-day22-10-GUI(对话框Dialog)
 */
public class MyWindowDemo extends Frame {
	private static final long serialVersionUID = 1L;
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;

	private Dialog d;
	private Label lab;
	private Button okBut;

	MyWindowDemo() {
		init();
	}

	public void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());

		tf = new TextField(30);

		but = new Button("goto");

		ta = new TextArea(25, 70);

		d = new Dialog(f, "info-self", true);
		d.setBounds(400, 200, 240, 150);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okBut = new Button("ok");

		d.add(lab);
		d.add(okBut);

		f.add(tf);
		f.add(but);
		f.add(ta);

		myEvent();

		f.setVisible(true);
	}

	private void myEvent() {
		okBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});

		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				d.setVisible(false);
			}
		});

		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					showDir();
				}
			}
		});

		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showDir();
			}
		});

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void showDir() {
		String dirPath = tf.getText();

		File dir = new File(dirPath);

		if (dir.exists() && dir.isDirectory()) {
			String[] names = dir.list();
			for (String name : names) {
				ta.append(name + "\r\n");
			}
		} else {
			// ta.setText("error");
			String info = "error：" + dirPath;
			lab.setText(info);
			d.setVisible(true);
		}
	}

	public static void main(String[] args) {
		new MyWindowDemo();
	}

}
