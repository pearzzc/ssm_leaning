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
			//1.���������ļ�
			Properties p = new Properties();
			//���ļ����������е� resource �ļ����ļ����ᵽclasses�ļ����£����Բ�����ôд
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
			// 2.��������
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �ر���Դ 
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
