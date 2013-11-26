package BUS;

import java.util.ArrayList;

import DAO.MonHoc_DAO;
import DTO.MonHoc_DTO;



public class MonHoc_BUS {
	static MonHoc_DAO DMMH ;
	public MonHoc_BUS(){
		DMMH = new MonHoc_DAO();
	}
	
	public static ArrayList<MonHoc_DTO> getdata(){
		return DMMH.getdata();
	}
	public Object insert(MonHoc_DTO SV){
		return DMMH.insert(SV);
	}
	public Object delete(MonHoc_DTO SV){
		return DMMH.delete(SV);
	}
	public Object update(MonHoc_DTO SV){
		return DMMH.update(SV);
	}
}
