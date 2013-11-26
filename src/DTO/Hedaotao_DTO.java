package DTO;

public class Hedaotao_DTO {
	private String Mahe;
	private String Tenhe;
	public String getMahe() {
		return Mahe;
	}
	public void setMahe(String mahe) {
		Mahe = mahe;
	}
	public String getTenhe() {
		return Tenhe;
	}
	public void setTenhe(String tenhe) {
		Tenhe = tenhe;
	}
	public Hedaotao_DTO(){}
	
	public Hedaotao_DTO(String Mahe){
		this.Mahe = Mahe;
	}
	
	public Hedaotao_DTO(String Mahe,String Tenhe){
		this.Mahe = Mahe;
		this.Tenhe = Tenhe;
	}
}
