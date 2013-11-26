package BUS;

import java.util.ArrayList;

import DAO.Nganh_DAO;
import DTO.Nganh_DTO;



public class Nganh_BUS {
	static Nganh_DAO DMNG ;
	public Nganh_BUS(){
		DMNG = new Nganh_DAO();
	}
	
	public ArrayList<Nganh_DTO> getdata(){
		return DMNG.getdata();
	}
	public Object insert(Nganh_DTO SV){
		return DMNG.insert(SV);
	}
	public Object delete(Nganh_DTO SV){
		return DMNG.delete(SV);
	}
	public Object update(Nganh_DTO SV){
		return DMNG.update(SV);
	}
}
