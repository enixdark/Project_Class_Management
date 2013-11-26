package DTO;

public class Hocki_DTO {
	private String MaHK;
	private String TenHK;
	public Hocki_DTO(){}
	public Hocki_DTO(String MaHK){
		this(MaHK,"");
	}
	public Hocki_DTO(String MaHK,String TenHK){
		this.MaHK = MaHK;
		this.TenHK = TenHK;
	}
	
	public String getMaHK() {
		return MaHK;
	}
	public void setMaHK(String maHK) {
		MaHK = maHK;
	}
	public String getTenHK() {
		return TenHK;
	}
	public void setTenHK(String tenHK) {
		TenHK = tenHK;
	}
	
	
	
	
}
