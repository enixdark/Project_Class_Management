package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Nganh_DTO;

public class Nganh_DAO {
	public static dataconnect connect;
	public Nganh_DAO (){
		connect = new dataconnect();
	}

	public ArrayList<Nganh_DTO> getdata(){
		connect.Connect();
		ArrayList<Nganh_DTO> L = new ArrayList<Nganh_DTO>();
		ResultSet rs = null;
		String sql ="select * from Nganh";
		rs = connect.Exec(sql);
		try {
			while(rs.next()){

				Nganh_DTO l = new Nganh_DTO();
				l.setMaNg(rs.getString(1));
				l.setTenNg(rs.getString(2));
				L.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return L;
	}


	public Object insert(Nganh_DTO l){
		connect.Connect();
		String MaNg = l.getMaNg();
		String TenNg = l.getTenNg();
		String value = String.format("values('%s','%s')",MaNg,TenNg);
		String sql = "Insert into Nganh(MaNg,TenNg) " + value;
		return connect.update(sql);


	}

	public Object delete(Nganh_DTO l){
		connect.Connect();
		String mahk = l.getMaNg();
		String sql = "delete from  Nganh where mang = '" + mahk +"'";
		return connect.update(sql);
	}

	public Object update(Nganh_DTO l){
		connect.Connect();
		String MaNg = l.getMaNg();
		String TenNg = l.getTenNg();
		String sql = String.format("update Nganh set " + 
				"TenNg = '%s' where MaNg = '%s'",TenNg,MaNg);
		return connect.update(sql);
	}
}
