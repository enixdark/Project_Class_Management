package BUS;

import java.util.ArrayList;

import DAO.Hocki_DAO;
import DTO.Hocki_DTO;



public class Hocki_BUS {
	static Hocki_DAO DMH ;
	public Hocki_BUS(){
		DMH = new Hocki_DAO();
	}
	
	public ArrayList<Hocki_DTO> getdata(){
		return DMH.getdata();
	}
	public Object insert(Hocki_DTO SV){
		return DMH.insert(SV);
	}
	public Object delete(Hocki_DTO SV){
		return DMH.delete(SV);
	}
	public Object update(Hocki_DTO SV){
		return DMH.update(SV);
	}
}
