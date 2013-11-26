package BUS;

import java.util.ArrayList;

import DAO.Lop_DAO;
import DTO.Lop_DTO;


public class Lop_BUS {
	static Lop_DAO DML ;
	public Lop_BUS(){
		DML = new Lop_DAO();
	}
	
	public static ArrayList<Lop_DTO> getdata(){
		return DML.getdata();
	}
	public Object insert(Lop_DTO SV){
		return DML.insert(SV);
	}
	public Object delete(Lop_DTO SV){
		return DML.delete(SV);
	}
	public Object update(Lop_DTO SV){
		return DML.update(SV);
	}
}
