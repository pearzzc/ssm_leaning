package com.test.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Dbutils {
	public static DataSource ds = null;
	static {
		try {
			//1.加载配置文件
			Properties p = new Properties();
			//在文件发布后，所有的 resource 文件的文件都会到classes文件夹下，所以不能这么写
			String path = Dbutils.class.getClassLoader().getResource("db.properties").getPath();
			System.out.println(path);
			FileInputStream in = new FileInputStream(path);
			p.load(in);
			
			ds = DruidDataSourceFactory.createDataSource(p); 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSourse() {
		return ds;
	}
	public static Connection getConn() {
		try {
			// 2.连接数据
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 关闭资源 
	 */
	public static void close(Connection conn,Statement st,ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
