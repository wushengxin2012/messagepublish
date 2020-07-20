package com.shengxinwu.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/db_discuz";
	private static String user = "root";
	private static String password = "";
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("--------------------------");
			System.out.println("找不到数据库驱动类");
			System.out.println("--------------------------");
			System.out.println();
		}
		
		try{
			conn = DriverManager.getConnection(url,user,password);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("--------------------------");
			System.out.println("取Connection失败");
			System.out.println("--------------------------");
			System.out.println();
		}
		
		return conn;
	}
	
	public static void close(Connection conn){
		if( conn != null ){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("--------------------------");
				System.out.println("关闭Connection异常");
				System.out.println("--------------------------");
				System.out.println();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt){
		if( pstmt != null ){
			try{
				pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("--------------------------");
				System.out.println("关闭PreparedStatement异常");
				System.out.println("--------------------------");
				System.out.println();
			}
		}
	}
	
	public static void close(ResultSet rs){
		if( rs != null ){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("--------------------------");
				System.out.println("关闭ResultSet异常");
				System.out.println("--------------------------");
				System.out.println();
			}
		}
	}
}