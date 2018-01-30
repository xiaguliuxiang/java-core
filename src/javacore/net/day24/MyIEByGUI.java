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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 网络编程(自定义图形界面浏览器-Tomcat服务端)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day24-07-网络编程(自定义图形界面浏览器-Tomcat服务端)
 */
public class MyIEByGUI {

	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;

	private Dialog d;
	private Label lab;
	private Button okBut;

	MyIEByGUI() {
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

		String url = tf.getText(); // http://127.0.0.1:8080/index.jsp

		int index1 = url.indexOf("//") + 2;

		int index2 = url.indexOf("/", index1);

		String str = url.substring(index1, index2);
		String[] arr = str.split(":");
		String host = arr[0];
		int port = Integer.parseInt(arr[1]);

		String path = url.substring(index2);

		// ta.setText(str + "..." + path);
		Socket s = new Socket(host, port);

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);

		out.println("GET " + path + " HTTP/1.1");
		out.println("Accept: */*");
		out.println("Accept-Language: zh-CN");
		out.println("Host: 192.168.159.1:8080");
		out.println("Connection: Keep-Alive");

		out.println();
		out.println();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));

		String line = null;

		while ((line = bufr.readLine()) != null) {
			ta.append(line + "\r\n");
		}

		bufr.close();
		out.close();
		s.close();

	}

	public static void main(String[] args) {
		new MyIEByGUI();
	}
}
