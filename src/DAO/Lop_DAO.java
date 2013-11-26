package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Lop_DTO;

public class Lop_DAO {
	public static dataconnect connect;
	public Lop_DAO (){
		connect = new dataconnect();
	}
	
	public static ArrayList<Lop_DTO> getdata(){
		connect.Connect();
		ArrayList<Lop_DTO> L = new ArrayList<Lop_DTO>();
		ResultSet rs = null;
		String sql ="select * from lop";
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				
				Lop_DTO l = new Lop_DTO();
				
				l.setMalop(rs.getString("malop"));
				l.setTenlop(rs.getString("tenlop"));
				l.setMahe(rs.getString("mahe"));
				L.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return L;
	}
	
	
	public Object insert(Lop_DTO l){
		connect.Connect();
		String MaLop = l.getMalop();
		String Tenlop = l.getTenlop();
		String MaHe = l.getMahe();
		
		
		
		String value = String.format("values('%s','%s','%s')",MaLop,Tenlop,MaHe);
		String sql = "Insert into Lop(malop,tenlop,mahe) " + value;
		return connect.update(sql);
		
		
}
	
	public Object delete(Lop_DTO l){
		connect.Connect();
		String malop = l.getMalop();
		String sql = "delete from  lop where malop = '" + malop +"'";
		return connect.update(sql);
	}
	
	public Object update(Lop_DTO l){
		connect.Connect();
		String MaLop = l.getMalop();
		String Tenlop = l.getTenlop();
		String MaHe = l.getMahe();
		
		
		String sql = String.format("update Lop set " + 
				"tenlop = '%s',mahe = '%s'  where malop = '%s'",Tenlop,MaHe,MaLop);
		return connect.update(sql);
	}
}
