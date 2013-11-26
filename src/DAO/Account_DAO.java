package DAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Account_DTO;
import DTO.Account_DTO;

public class Account_DAO {
	public static dataconnect connect;
	public Account_DAO (){
		connect = new dataconnect();
	}
	
	public static ArrayList<Account_DTO> getdata(){
		connect.Connect();
		ArrayList<Account_DTO> L = new ArrayList<Account_DTO>();
		ResultSet rs = null;
		String sql ="select * from Account";
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				
				Account_DTO l = new Account_DTO();
				
				l.setUser(rs.getString("username"));
				l.setPass(rs.getString("pass"));
				l.setLevel(rs.getInt("advance"));
				L.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return L;
	}
	
	
	public Object insert(Account_DTO l){
		connect.Connect();
		String User = l.getUser();
		String Pass = l.getPass();
		int Level = l.getLevel();
		
		
		
		String value = String.format("values('%s','%s',%d)",User,Pass,Level);
		String sql = "Insert into Account(username,pass,advance) " + value;
		return connect.update(sql);
		
		
}
	
	public Object delete(Account_DTO l){
		connect.Connect();
		String user = l.getUser();
		String sql = "delete from Account where username = '" + user +"'";
		return connect.update(sql);
	}
	
	public Object update(Account_DTO l){
		connect.Connect();
		String User = l.getUser();
		String Pass = l.getPass();
		int Level = l.getLevel();
		
		
		String sql = String.format("update Account set " + 
				"pass = '%s',advance = %d  where username = '%s'",Pass,Level,User);
		return connect.update(sql);
	}
	public ArrayList<Account_DTO> Search(Account_DTO SV){
		connect.Connect();
		ArrayList<Account_DTO> DMD = new ArrayList<Account_DTO>();
		ArrayList<String> arr = new ArrayList<String>();
		
		String user = SV.getUser();
		String pass = SV.getPass();
		
		if (!user.equals("")){
			arr.add("username = '" + user +"'");
		}
		if (!pass.equals("")){
			arr.add("pass = '" + pass +"'");
		}
//		if (!mahk.equals("")){
//			arr.add("mahk = '" + pass +"'");
//		}
		
		
		
		ResultSet rs = null;
		
		String sql ="select * from Account where ";
		for (int i = 0 ; i<arr.size();i++){
			if ( i == 0 ){
				sql = sql + arr.get(0);
			}
			else{
				sql = sql + " and " + arr.get(i);
			}
			
			
		}
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				Account_DTO sv = new Account_DTO();
				sv.setUser(rs.getString("username"));
				sv.setPass(rs.getString("pass"));
				sv.setLevel(rs.getInt("advance"));
				
				DMD.add(sv);
			} 
		}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		connect.Disconnect();
		return DMD;
		
	}
	public ArrayList<Account_DTO> SearchImage(Account_DTO SV){
		connect.Connect();
		ArrayList<Account_DTO> L = new ArrayList<Account_DTO>();
		ResultSet rs = null;
		String user = SV.getUser();
		String sql =" select encode from Account where username ='" + user +"'";
		rs = connect.Exec(sql);
		try {
			if(rs.next()){
				byte[] a = rs.getBytes(1);
				//System.out.println(a);
//				OutputStream out = new FileOutputStream("new.jpg");
//				try {
//					out.write(a);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				Account_DTO l = new Account_DTO();
				l.setImage(a);
				L.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return L;
	}
	
	public void EditImage(Account_DTO SV){
		connect.Connect();
		
		String user = SV.getUser();
		byte[] images = SV.getImage();
		
		//String sql = "update Account set encode = CONVERT(varbinary(max),'[B@31dbd4') where username = 'admin'";
		String sql = "update Account set encode = ? where username = ?";
		try {
			PreparedStatement stat = connect.Prepare(sql);
			stat.setBytes(1,images);
			stat.setString(2,user);
			connect.PrepareUpdate(stat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connect.Disconnect();
	}
}


//connect.Connect();
//String user = SV.getUser();
//byte[] images = SV.getImage();
//String sql = "update Account set encode = ? where username = ?";
//try {
//	PreparedStatement rs = connect.conn.prepareStatement(sql);
//	rs.setBytes(1,images);
//	rs.setString(2,user);
//	rs.executeUpdate();
//} catch (SQLException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
////String sql = "update Account set encode = CONVERT(varbinary(max),'[B@31dbd4') where username = 'admin'";
//System.out.println(sql);
////connect.update(sql);
//connect.Disconnect();