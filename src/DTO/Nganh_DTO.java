package DTO;

public class Nganh_DTO {
	private String MaNg;
	private String TenNg;
	public Nganh_DTO(){}
	public Nganh_DTO(String MaNg){
		this(MaNg,"");
	}
	public Nganh_DTO(String MaNg,String TenNg){
		this.MaNg = MaNg;
		this.TenNg = TenNg;
	}
	
	public String getMaNg() {
		return MaNg;
	}
	public void setMaNg(String maHK) {
		MaNg = maHK;
	}
	public String getTenNg() {
		return TenNg;
	}
	public void setTenNg(String tenHK) {
		TenNg = tenHK;
	}
}
