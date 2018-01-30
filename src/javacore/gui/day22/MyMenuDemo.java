package javacore.gui.day22;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GUI(菜单)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day22-11-GUI(菜单)
 */
public class MyMenuDemo {

	private Frame f;
	private MenuBar mb;
	private Menu m, subMenu;
	private MenuItem subItem, closeItem;

	MyMenuDemo() {
		init();
	}

	public void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 500, 600);
		f.setLayout(new FlowLayout());

		mb = new MenuBar();

		m = new Menu("File");

		subMenu = new Menu("Sub Menu");

		subItem = new MenuItem("Sub Item");
		closeItem = new MenuItem("Exit");

		subMenu.add(subItem);

		m.add(subMenu);
		m.add(closeItem);
		mb.add(m);

		f.setMenuBar(mb);

		myEvent();

		f.setVisible(true);
	}

	private void myEvent() {
		closeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new MyMenuDemo();
	}

}
