package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Hocki_DTO;

public class Hocki_DAO {

	public static dataconnect connect;
	public Hocki_DAO (){
		connect = new dataconnect();
	}

	public static ArrayList<Hocki_DTO> getdata(){
		connect.Connect();
		ArrayList<Hocki_DTO> L = new ArrayList<Hocki_DTO>();
		ResultSet rs = null;
		String sql ="select * from hocki";
		rs = connect.Exec(sql);
		try {
			while(rs.next()){

				Hocki_DTO l = new Hocki_DTO();
				l.setMaHK(rs.getString(1));
				l.setTenHK(rs.getString(2));
				L.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return L;
	}


	public Object insert(Hocki_DTO l){
		connect.Connect();
		String MaHK = l.getMaHK();
		String TenHK = l.getTenHK();
		String value = String.format("values('%s','%s')",MaHK,TenHK);
		String sql = "Insert into Hocki(MaHK,Tenhk) " + value;
		return connect.update(sql);


	}

	public Object delete(Hocki_DTO l){
		connect.Connect();
		String mahk = l.getMaHK();
		String sql = "delete from  Hocki where mahk = '" + mahk +"'";
		return connect.update(sql);
	}

	public Object update(Hocki_DTO l){
		connect.Connect();
		String MaHK = l.getMaHK();
		String TenHK = l.getTenHK();
		
		String sql = String.format("update Hocki set " + 
				"tenhk = '%s' where mahk = '%s'",TenHK,MaHK);
		System.out.println(sql);
		return connect.update(sql);
	}

}
