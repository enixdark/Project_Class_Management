package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.New_DTO;

public class New_DAO {
	public static dataconnect connect;
	public New_DAO (){
		connect = new dataconnect();
	}

	public static ArrayList<New_DTO> getdata(){
		connect.Connect();
		ArrayList<New_DTO> L = new ArrayList<New_DTO>();
		ResultSet rs = null;
		String sql ="select * from News where manew = 1";
		rs = connect.Exec(sql);
		try {
			if(rs.next()){

				New_DTO l = new New_DTO();
				l.setManew(rs.getInt("manew"));
				l.setNews(rs.getNString("new"));
				L.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return L;
	}


	public Object update(New_DTO l){
		connect.Connect();
		String news = l.getNews();
		
		String sql = String.format("update New set " + 
				"new = '%s' where manew = 1",news);
		//System.out.println(sql);
		return connect.update(sql);
	}
}
