package cn.leelei.servlet.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import cn.leelei.servlet.entity.User;

public class BeanUtilsTest {
	@Test
	public void copyProperties(){
	Map<String ,Object> map = new HashMap<>();
	map.put("userName", "admin");
	map.put("password", "admin");
	map.put("id", 1);
	User dest = new User();
	try {
		BeanUtils.copyProperties(dest, map);
		System.err.println(dest);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
}
