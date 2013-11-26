package BUS;

import java.util.ArrayList;

import DAO.Hedaotao_DAO;
import DTO.Hedaotao_DTO;



public class Hedaotao_BUS {
	static Hedaotao_DAO DMH ;
	public Hedaotao_BUS(){ 
		DMH = new Hedaotao_DAO();
	}
	
	public ArrayList<Hedaotao_DTO> getdata(){
		return DMH.getdata();
	}
	public Object insert(Hedaotao_DTO SV){
		return DMH.insert(SV);
	}
	public Object delete(Hedaotao_DTO SV){
		return DMH.delete(SV);
	}
	public Object update(Hedaotao_DTO SV){
		return DMH.update(SV);
	}
}
