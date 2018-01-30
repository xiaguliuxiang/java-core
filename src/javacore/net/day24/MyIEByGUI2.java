package javacore.net.day24;

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
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 网络编程(URL-URLConnection)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day24-08-网络编程(URL-URLConnection)
 */
public class MyIEByGUI2 {

	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;

	private Dialog d;
	private Label lab;
	private Button okBut;

	MyIEByGUI2() {
		init();
	}

	public void init() {
		f = new Frame("my ie");
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());

		tf = new TextField(60);
		but = new Button("goto");

		ta = new TextArea(25, 70);

		d = new Dialog(f, "info", true);
		d.setBounds(400, 200, 240, 150);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okBut = new Button("ok");

		d.add(lab);
		d.add(but);

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
					try {
						showDir();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					showDir();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void showDir() throws IOException {
		ta.setText("");

		String urlPath = tf.getText(); // http://127.0.0.1:8080/index.jsp

		URL url = new URL(urlPath);

		URLConnection conn = url.openConnection();

		InputStream in = conn.getInputStream();

		byte[] buf = new byte[1024];

		int len = in.read(buf);

		ta.setText(new String(buf, 0, len));

	}

	public static void main(String[] args) {
		new MyIEByGUI2();
	}
}
