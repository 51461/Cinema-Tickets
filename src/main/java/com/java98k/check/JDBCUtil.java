package com.java98k.check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	/**
	 * 获取数据库连接对象并返回
	 * @return Connection对象
	 * @throws Exception 
	 */
	public static Connection getConn() throws Exception{
		//1.注册驱动
		Class.forName( "com.mysql.jdbc.Driver" );
		//2.获取连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql:///dyygp?useUnicode=true&characterEncoding=utf-8",
				"root", 
				"root123");
		return conn;
	}
	
	/**
	 * 释放JDBC程序中的资源
	 * @param conn 连接对象
	 * @param stat 传输器对象
	 * @param rs 结果集对象
	 */
	public static void close(Connection conn, 
			Statement stat, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				rs = null;
			}
		}
		if(stat != null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				stat = null;
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				conn = null;
			}
		}
	}
}
