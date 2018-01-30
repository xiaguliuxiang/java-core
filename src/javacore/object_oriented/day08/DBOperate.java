package javacore.object_oriented.day08;

/**
 * 面向对象(多态的扩展示例)<br>
 * <p>
 * 需求：数据库的操作。<br>
 * 1、连接数据库。<br>
 * 2、操作数据库。<br>
 * c:create; r:read; u:update; d:delete.<br>
 * 3、关闭数据库连接。<br>
 * 
 * @author xiaguliuxiang@gmail.com
 * @see 传智播客毕向东Java基础视频教程-day08-07-面向对象(多态的扩展示例)
 */
public class DBOperate {
	public static void main(String[] args) {
		User user = new User();
		UserInfoByJDBC ui = new UserInfoByJDBC();
		ui.add(user);
		ui.delete(user);

		UserInfoByHibernate uih = new UserInfoByHibernate();
		uih.add(user);
		uih.delete(user);
	}
}

class User {

}

class UserInfoByJDBC {
	public void add(User user) {
		/**
		 * 1、连接数据库<br>
		 * 2、使用sql添加语句添加数据<br>
		 * 3、关闭连接<br>
		 */
		System.out.println("add user by jdbc");
	}

	public void delete(User user) {
		/**
		 * 1、连接数据库<br>
		 * 2、使用sql删除语句删除数据<br>
		 * 3、关闭连接<br>
		 */
		System.out.println("delete user by jdbc");
	}
}

class UserInfoByHibernate {
	public void add(User user) {
		/**
		 * 1、连接数据库<br>
		 * 2、使用sql添加语句添加数据<br>
		 * 3、关闭连接<br>
		 */
		System.out.println("add user by hibernate");
	}

	public void delete(User user) {
		/**
		 * 1、连接数据库<br>
		 * 2、使用sql删除语句删除数据<br>
		 * 3、关闭连接<br>
		 */
		System.out.println("delete user by hibernate");
	}
}