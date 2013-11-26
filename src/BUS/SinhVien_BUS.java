package BUS;

import java.util.ArrayList;

import DAO.SinhVien_DAO;
import DTO.SinhVien_DTO;



public class SinhVien_BUS {
	static SinhVien_DAO DMSV ;
	public SinhVien_BUS(){
		DMSV = new SinhVien_DAO();
	}
	
	public ArrayList<SinhVien_DTO> getdata(){
		return DMSV.getdata();
	}
	public ArrayList<String> getcombobox(String Table,String Column){
		return DMSV.getcombobox(Table,Column);
	}
	public String getdata_from_Relationship(String Table1,String Table2,String Column1,String Column2){
		return DMSV.getdata_from_Relationship(Table1, Table2, Column1, Column2);
	}
	public Object insert(SinhVien_DTO SV){
		return DMSV.insert(SV);
	}
	public Object delete(SinhVien_DTO SV){
		return DMSV.delete(SV);
	}
	public Object update(SinhVien_DTO SV){
		return DMSV.update(SV);
	}
	
	public ArrayList<SinhVien_DTO> Search(SinhVien_DTO SV){
		return DMSV.Search(SV);
	}
	
	public ArrayList<SinhVien_DTO> SearchID(SinhVien_DTO SV){
		return DMSV.SearchID(SV);
	}
	
}
