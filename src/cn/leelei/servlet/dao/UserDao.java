package cn.leelei.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.leelei.servlet.entity.User;
import cn.leelei.servlet.util.DbUtils;

public class UserDao {
	
	/**
	 * 得到所用用户信息
	 * @return
	 */
	public List<User> findall() {
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			List<User> users = new ArrayList<User>();
			User us = null;
			
			if(connection !=null ){
				String sql = "SELECT * FROM `user`";
				statement=connection.prepareStatement(sql);
				resultSet =statement.executeQuery();
				while(resultSet.next()){
					us =new User();
					us.setId(resultSet.getInt("id"));
					us.setUserName(resultSet.getString("userName"));
					us.setPassword(resultSet.getString("password"));
					us.setRealName(resultSet.getString("realName"));
					users.add(us);
					
				}
		}
			return users.isEmpty()? null :users;
			} catch (Exception e) {
				e.printStackTrace();
		}finally {
			DbUtils.closeResource(connection, statement, resultSet);
		}
		return null;
		
	}
	/**
	 * 保存用户
	 * @param user
	 */
	
	public void save(User user) {
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		try {
			if(connection !=null ){
				String sql = "INSERT INTO user(userName,password,realName) VALUES (?,?,?)";
				statement=connection.prepareStatement(sql);
				//绑定数据
				statement.setString(1, user.getUserName());
				statement.setString(2, user.getPassword());
				statement.setString(3, user.getRealName());
				//执行语句
				statement.execute();
				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
		}finally {
			DbUtils.closeResource(connection, statement, null);
		}
		
	}
	/**
	 * 删除用户根据id
	 * @param user
	 */
	public void delUserById(User user) {
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		try {
			if(connection !=null ){
				String sql = "DELETE FROM user WHERE id=?";
				statement=connection.prepareStatement(sql);
				//绑定数据
				statement.setInt(1, user.getId());
				//执行语句
				statement.execute();
				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
		}finally {
			DbUtils.closeResource(connection, statement, null);
		}
		
	}
	/**
	 * 更新用户 
	 * @param user
	 */
	public void updatUser(User user) {
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		try {
			if(connection !=null ){
				String sql = "UPDATE `user`SET `realName`=?,`password`=? WHERE id=?";
				statement=connection.prepareStatement(sql);
				//绑定数据
				statement.setString(1,user.getRealName());
				statement.setString(2, user.getPassword());
				statement.setInt(3, user.getId());
				//执行语句
				statement.execute();
				
				}
				
			} catch (Exception e) {
				e.printStackTrace();
		}finally {
			DbUtils.closeResource(connection, statement, null);
		}
		
	}
	//登录教验证
	//返回是数据库中的信息
	public User validataUser(User user) {
		Connection connection = DbUtils.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			User us = null;
			
			if(connection !=null ){
				String sql = "SELECT * FROM `user` WHERE userName=? AND password=?";
				statement=connection.prepareStatement(sql);
				statement.setString(1,user.getUserName());
				statement.setString(2,user.getPassword());
				resultSet=statement.executeQuery();
				//处理结果集
				if(resultSet.first()){
					us =new User();
					us.setId(resultSet.getInt("id"));
					us.setUserName(resultSet.getString("userName"));
					us.setPassword(resultSet.getString("password"));
					us.setRealName(resultSet.getString("realName"));
				}
				
		}
			return us;
			} catch (Exception e) {
				e.printStackTrace();
		}finally {
			DbUtils.closeResource(connection, statement, resultSet);
		}
		return null;
		
	}
	
}
