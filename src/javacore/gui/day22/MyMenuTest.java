package javacore.gui.day22;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * GUI(练习-打开文件)<br>
 * GUI(练习-保存文件)<br>
 * GUI(jar包双击执行)<br>
 * <p>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day22-12-GUI(练习-打开文件)
 * @see 传智播客毕向东Java基础视频教程-day22-13-GUI(练习-保存文件)
 * @see 传智播客毕向东Java基础视频教程-day22-14-GUI(jar包双击执行)
 */
public class MyMenuTest {

	private Frame f;
	private MenuBar bar;
	private TextArea ta;
	private Menu fileMenu;
	private MenuItem openItem, saveItem, closeItem;
	private FileDialog openDia, saveDia;

	private File file;

	MyMenuTest() {
		init();
	}

	public void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 650, 600);

		bar = new MenuBar();

		ta = new TextArea();

		fileMenu = new Menu("File");

		openItem = new MenuItem("Open");
		saveItem = new MenuItem("Save");
		closeItem = new MenuItem("Exit");

		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(closeItem);

		bar.add(fileMenu);

		f.setMenuBar(bar);

		openDia = new FileDialog(f, "my open", FileDialog.LOAD);
		saveDia = new FileDialog(f, "my save", FileDialog.LOAD);

		f.add(ta);
		myEvent();

		f.setVisible(true);
	}

	private void myEvent() {
		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openDia.setVisible(true);
				String dirPath = openDia.getDirectory();
				String fileName = openDia.getFile();
				System.out.println(dirPath + "..." + fileName);
				if (dirPath == null || fileName == null) {
					return;
				}
				File file = new File(dirPath, fileName);

				try {
					BufferedReader bufr = new BufferedReader(new FileReader(file));
					String line = null;
					while ((line = bufr.readLine()) != null) {
						ta.append(line + "\r\n");
					}
					bufr.close();
				} catch (IOException ex) {
					throw new RuntimeException("读取失败");
				}
			}
		});

		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (file == null) {
					saveDia.setVisible(true);

					String dirPath = saveDia.getDirectory();
					String fileName = saveDia.getFile();
					if (dirPath == null || fileName == null) {
						return;
					}
					file = new File(dirPath, fileName);
				}
				try {
					BufferedWriter bufw = new BufferedWriter(new FileWriter(file));
					String text = ta.getText();
					bufw.write(text);
					bufw.flush();
					bufw.close();
				} catch (IOException ex) {
					throw new RuntimeException();
				}
			}
		});

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
		new MyMenuTest();
	}

}
