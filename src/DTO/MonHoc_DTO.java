package DTO;

public class MonHoc_DTO {
	private String MaMon;
	private String TenMon;
	private String MaHK;
	private int sotinchi;
	private String MaNganh;
	public String getMaMon() {
		return MaMon;
	}
	public void setMaMon(String maMon) {
		MaMon = maMon;
	}
	public String getTenMon() {
		return TenMon;
	}
	public void setTenMon(String tenMon) {
		TenMon = tenMon;
	}
	public String getMaHK() {
		return MaHK;
	}
	public void setMaHK(String maHK) {
		MaHK = maHK;
	}
	public int getSotinchi() {
		return sotinchi;
	}
	public void setSotinchi(int sotinchi) {
		this.sotinchi = sotinchi;
	}
	
	public MonHoc_DTO(){}
	
	public MonHoc_DTO(String Mamon){
		this.MaMon = Mamon;
		
	}
	public MonHoc_DTO(String Mamon,String TenMon,int sotinchi,String MaHK,String MaNganh){
		this.MaMon = Mamon;
		this.TenMon = TenMon;
		this.sotinchi = sotinchi;
		this.MaHK = MaHK;
		this.MaNganh = MaNganh;
	}
	
	public String getMaNganh() {
		return MaNganh;
	}
	public void setMaNganh(String maNganh) {
		MaNganh = maNganh;
	}
	
	
	
}
