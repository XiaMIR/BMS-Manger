package cn.leelei.servlet.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.leelei.servlet.entity.User;
import cn.leelei.servlet.util.DbUtils;

public class StoredProcedure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	 * @param user
	 * @return
	 */
	
	public User storedProcedure(User user) {
		Connection connection = DbUtils.getConnection();
		CallableStatement statement = null;
		ResultSet resultSet = null;
		
		
			try {
				
				if(connection !=null ){
					String sql = " ";
					CallableStatement prepareCall = connection.prepareCall(sql);
					prepareCall.setString(1,user.getUserName());
					prepareCall.setString(2,user.getPassword());
					prepareCall.setString(3, user.getRealName());
					prepareCall.setInt(4, user.getId());
					// 执行语句
					int executeUpdate = statement.executeUpdate(sql);
					
					//处理结果集
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DbUtils.closeResource(connection, statement, resultSet);
			}
			return user;			
		}
}
