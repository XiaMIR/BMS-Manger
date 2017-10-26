package cn.leelei.servlet.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.leelei.servlet.util.DbUtils;

public class DButilsTest {
	@Test
	public void getConnection() throws SQLException {
		Connection connection = DbUtils.getConnection();
		System.err.println(connection);
		
		
		
	}

}
