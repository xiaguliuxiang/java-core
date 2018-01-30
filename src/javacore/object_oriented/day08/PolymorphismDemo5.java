package javacore.object_oriented.day08;

/**
 * 面向对象(多态的主板示例)<br>
 * <p>
 * 需求：电脑运行实例，电脑运行基于主板。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day08-06-面向对象(多态的主板示例)
 */
public class PolymorphismDemo5 {
	public static void main(String[] args) {
		MainBoard mb = new MainBoard();
		mb.run();

		mb.useNetCard(new NetCard());
		mb.usePCI(new SoundCard());
	}
}

interface PCI {
	public void open();

	public void close();
}

class MainBoard {
	public void run() {
		System.out.println("mainboard run");
	}

	public void usePCI(PCI p) { // PCI p = new NetCard(); // 接口型引用指向自己的子类对象。
		if (p != null) {
			p.open();
			p.close();
		}
	}

	public void useNetCard(NetCard nc) {
		nc.open();
		nc.close();
	}
}

class NetCard {
	public void open() {
		System.out.println("netcard open");
	}

	public void close() {
		System.out.println("netcard close");
	}
}

class SoundCard implements PCI {
	@Override
	public void open() {
		System.out.println("soundcard open");
	}

	@Override
	public void close() {
		System.out.println("soundcard close");
	}
}