package BUS;

import java.util.ArrayList;

import DAO.ThongKe_DAO;
import DTO.ThongKe_DTO;
;

public class ThongKe_BUS {
	static ThongKe_DAO DML ;
	public ThongKe_BUS(){
		DML = new ThongKe_DAO();
	}
	
	public ArrayList<ThongKe_DTO> getdata(){
		return DML.getdata();
	}
	public ArrayList<ThongKe_DTO> Search(ThongKe_DTO SV,boolean check){
		return DML.Search(SV, check);
	}
}
