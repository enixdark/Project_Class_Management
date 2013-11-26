package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Hedaotao_DTO;

public class Hedaotao_DAO {
	public static dataconnect connect;
	public Hedaotao_DAO (){
		connect = new dataconnect();
	}
	
	public static ArrayList<Hedaotao_DTO> getdata(){
		connect.Connect();
		ArrayList<Hedaotao_DTO> L = new ArrayList<Hedaotao_DTO>();
		ResultSet rs = null;
		String sql ="select * from Hedaotao";
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				
				Hedaotao_DTO l = new Hedaotao_DTO();
				
				l.setMahe(rs.getString(1));
				l.setTenhe(rs.getString(2));
				
				L.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return L;
	}
	
	
	public Object insert(Hedaotao_DTO l){
		connect.Connect();
		String Mahe = l.getMahe();
		String Tenhe = l.getTenhe();
		
		
		
		
		String value = String.format("values('%s','%s')",Mahe,Tenhe);
		String sql = "Insert into HeDaotao(mahe,tenhe) " + value;
		return connect.update(sql);
		
		
}
	
	public Object delete(Hedaotao_DTO l){
		connect.Connect();
		String mahe = l.getMahe();
		String sql = "delete from  Diem where lop = '" + mahe +"'";
		return connect.update(sql);
	}
	
	public Object update(Hedaotao_DTO l){
		connect.Connect();
		String Mahe = l.getMahe();
		String Tenhe = l.getTenhe();
		
		
		
		String sql = String.format("update Hedaotao set " + 
				"tenhe = '%s' where mahe = '%s'",Tenhe,Mahe);
		return connect.update(sql);
	}
}
