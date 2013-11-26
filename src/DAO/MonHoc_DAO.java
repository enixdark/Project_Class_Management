package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.MonHoc_DTO;

public class MonHoc_DAO {
	public static dataconnect connect;
	public MonHoc_DAO (){
		connect = new dataconnect();
	}
	
	public static ArrayList<MonHoc_DTO> getdata(){
		connect.Connect();
		ArrayList<MonHoc_DTO> M = new ArrayList<MonHoc_DTO>();
		ResultSet rs = null;
		String sql ="select * from MonHoc";
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				
				MonHoc_DTO m = new MonHoc_DTO();
				
				m.setMaMon(rs.getString(1));
				m.setTenMon(rs.getString(2));
				m.setSotinchi(rs.getInt(3));
				m.setMaHK(rs.getString(4));
				m.setMaNganh(rs.getString(5));
				M.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return M;
	}
	
	
	public Object insert(MonHoc_DTO m){
		connect.Connect();
		String MaMon = m.getMaMon();
		String TenMon = m.getTenMon();
		int sotinchi = m.getSotinchi();
		String MaHK = m.getMaHK();
		String MaNganh = m.getMaNganh();
		
		
		String value = String.format("values('%s','%s',%d,'%s','%s')",MaMon,TenMon,sotinchi,MaHK,MaNganh);
		String sql = "Insert into Monhoc(mamon,tenmon,sotinchi,mahk,manganh) " + value;
		return connect.update(sql);
		
		
}
	
	public Object delete(MonHoc_DTO m){
		connect.Connect();
		String mamon = m.getMaMon();
		String sql = "delete from  Monhoc where mamon = '" + mamon +"'";
		System.out.println(sql);
		return connect.update(sql);
	}
	
	public Object update(MonHoc_DTO m){
		connect.Connect();
		String MaMon = m.getMaMon();
		String TenMon = m.getTenMon();
		int sotinchi = m.getSotinchi();
		String MaHK = m.getMaHK();
		String MaNganh = m.getMaNganh();
		
		String sql = String.format("update Monhoc set " + 
				"tenmon = '%s',sotinchi = %d , MaHK = '%s',Manganh = '%s'  where mamon = '%s'",TenMon,sotinchi,MaHK,MaNganh,MaMon);
		return connect.update(sql);
	}
}
