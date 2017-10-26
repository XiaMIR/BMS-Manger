package cn.leelei.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.leelei.servlet.util.DbUtils;

public class pageDao {
	private int pageSize = 5;// 每页记录数

	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	 public int getPages(){
		 //获取数据库对象
		    Connection connection = DbUtils.getConnection();
			PreparedStatement statement = null;
			ResultSet resultSet = null;
	        /**
	         * SQL语句计算查询的总记录数
	         * @return 查询person的总页数
	         */
	        int totalPages = 0;//总页数totalPages
	        try {
				String sql = "select * from user";
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	        try {
	            while(resultSet.next()){
	                int totalRecords = resultSet.getInt("id");//总记录数totalRecords
	                totalPages=totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return totalPages;
	    }
	

}
