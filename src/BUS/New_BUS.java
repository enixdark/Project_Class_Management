package BUS;

import java.util.ArrayList;

import DAO.New_DAO;
import DTO.New_DTO;

public class New_BUS {
	static New_DAO DML ;
	public New_BUS(){
		DML = new New_DAO();
	}
	
	public static ArrayList<New_DTO> getdata(){
		return DML.getdata();
	}
	
	public Object update(New_DTO SV){
		return DML.update(SV);
	}
}
