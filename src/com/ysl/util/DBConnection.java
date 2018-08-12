/**
 * 
 */
package com.ysl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 余少林
 *
 */
public class DBConnection {
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/db_affairmanage?characterEncoding=utf-8";
	private static final String user="root";
	private static final String password="admin";
	public static Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName(Driver);
			connection=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return connection;
	}
	public static void close(Connection connection){
		if (connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement preparedStatement){
		if (preparedStatement!=null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet resultSet){
		if (resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
