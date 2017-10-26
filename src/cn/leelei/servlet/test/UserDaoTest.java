package cn.leelei.servlet.test;


import java.util.List;

import org.junit.Test;

import cn.leelei.servlet.dao.UserDao;
import cn.leelei.servlet.entity.User;

public class UserDaoTest {
	@Test
	public void seve() {
		UserDao userDao= new UserDao();
		User user = new User();
//		user.setUserName("ss");
//		user.setPassword(DigestUtils.md5Hex("222222"));
		user.setUserName("admin");
		user.setPassword("admin");
		user.setRealName("李江");
		userDao.save(user);
		
	}
	@Test
	public void findall() {
		UserDao  Dao= new UserDao();
		List<User> users= Dao.findall();
		for (User user : users) {
			System.err.println(user);
			
		}
		
	}
}
