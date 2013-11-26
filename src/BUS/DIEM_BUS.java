package BUS;

import java.util.ArrayList;

import DAO.DIEM_DAO;
import DTO.DIEM_DTO;
import DTO.SinhVien_DTO;

public class DIEM_BUS {
	static DIEM_DAO DML ;
	public DIEM_BUS(){
		DML = new DIEM_DAO();
	}
	
	public static ArrayList<DIEM_DTO> getdata(){
		return DML.getdata();
	}
	public Object insert(DIEM_DTO D){
		return DML.insert(D);
	}
	public Object delete(DIEM_DTO D){
		return DML.delete(D);
	}
	public Object update(DIEM_DTO D){
		return DML.update(D);
	}
	public ArrayList<DIEM_DTO> Search(DIEM_DTO D){
		return DML.Search(D);
	}
}
