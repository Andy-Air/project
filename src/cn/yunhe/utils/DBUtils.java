package cn.yunhe.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

/**
 * 数据库连接工具类
 * 
 * @author Administrator
 *
 */
public class DBUtils {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bbc?serverTimezone=UTC";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "123456";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取数据库链接对象
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	/**
	 * 通用数据库增删改
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int cud(String sql) {
		Connection conn = null;
		Statement statement = null;
		int result = 0;

		try {
			// 获取数据库链接对象
			conn = getConnection();
			// 获取执行sql
			statement = conn.createStatement();
			// 执行sql
			result = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库链接对象
			close(conn, statement, null);
		}
		return 0;

	}

	/**
	 * 关闭数据库链接
	 * 
	 * @param conn
	 * @param statement
	 * @param rs
	 */
	public static void close(Connection conn, Statement statement, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 预编译形式增删改功能封装
	 * 
	 * @param sql
	 * @param objects
	 * @return
	 */
	public static int cudPre(String sql, Object... objects) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			// 获取数据连接对象
			conn = getConnection();
			// 获取执行sql的对象
			ps = conn.prepareStatement(sql);
			// 设置传递过来的参数
			for (int i = 0; i < objects.length; i++) {
				// 数组的下标是从零开始，目的是为了取数组中的数据
				// 占位符（？）从1开始，标识的是占位符的位置
				ps.setObject(i + 1, objects[i]);

			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库
			close(conn, ps, null);
		}
		return result;

	}
	/**
	 * 查询版块
	 * 
	 * @param sql
	 * @return
	 *//*
		 * 
		 * public static ResultSet select(String sql) { Connection conn = null;
		 * PreparedStatement ps = null; ResultSet result = null; try { //获取数据连接对象 conn =
		 * getConnection(); //获取执行sql的对象 ps= conn.prepareStatement(sql); //设置传递过来的参数
		 * 
		 * for (int i = 0; i < objects.length; i++) { //数组的下标是从零开始，目的是为了取数组中的数据
		 * //占位符（？）从1开始，标识的是占位符的位置 ps.setObject(i+1, objects[i]);
		 * 
		 * }
		 * 
		 * result = ps.executeQuery(); while (result.next()) {
		 * 
		 * System.out.println(result.getString(1) +"."+ result.getString(2)); }
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); }finally { //关闭数据库
		 * close(conn, ps, null); } return result;
		 * 
		 * 
		 * }
		 */
	
}
