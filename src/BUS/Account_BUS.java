package BUS;

import java.util.ArrayList;

import DAO.Account_DAO;
import DTO.Account_DTO;
import DTO.DIEM_DTO;



public class Account_BUS {
	static Account_DAO ACC ;
	public Account_BUS(){
		ACC = new Account_DAO();
	}
	
	public static ArrayList<Account_DTO> getdata(){
		return ACC.getdata();
	}
	public Object insert(Account_DTO A){
		return ACC.insert(A);
	}
	public Object delete(Account_DTO A){
		return ACC.delete(A);
	}
	public Object update(Account_DTO A){
		return ACC.update(A);
	}
	public ArrayList<Account_DTO> Search(Account_DTO A){
		return ACC.Search(A);
	}
	public ArrayList<Account_DTO> SearchImage(Account_DTO A){
		return ACC.SearchImage(A);
	}
	public void EditImage(Account_DTO SV){
		ACC.EditImage(SV);
	}
}
