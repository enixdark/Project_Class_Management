package DAO;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
public class dataconnect {
	
	
	public Connection conn = null;
	
	public ResultSet rs = null;
	public String url = "jdbc:sqlserver://localhost:1433;databaseName=QLD";
	public void Connect(){
		
		
		String user = "sa";
    	String Pass = "123456";
    	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//    	System.out.println("Hello" + user + Pass);
		try {
			conn = DriverManager.getConnection(url,user,Pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Disconnect(){
		try {
			if (!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet Exec(String sql){
		try {
			Statement stat = conn.createStatement();
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public Object update(String sql){
		try {
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return rs;
		return true;
	}
	
	public PreparedStatement Prepare(String sql) throws SQLException{
		 
		return conn.prepareStatement(sql);
	}
	public void PrepareUpdate(PreparedStatement stat) throws SQLException{
		 stat.executeUpdate();
	}
}
	
	


