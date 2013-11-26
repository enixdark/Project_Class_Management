package DTO;

public class Lop_DTO {
	private String Malop;
	private String Mahe;
	private String Tenlop;
	public String getMalop() {
		return Malop;
	}
	public void setMalop(String malop) {
		Malop = malop;
	}
	public String getMahe() {
		return Mahe;
	}
	public void setMahe(String mahe) {
		Mahe = mahe;
	}
	public String getTenlop() {
		return Tenlop;
	}
	public void setTenlop(String tenlop) {
		Tenlop = tenlop;
	}
	
	public Lop_DTO(){}
	public Lop_DTO(String Malop){
		this.Malop = Malop;
		
	}
	public Lop_DTO(String Malop,String Tenlop,String Mahe){
		this.Malop = Malop;
		this.Tenlop = Tenlop;
		this.Mahe = Mahe;
	}
	
}
