package DTO;

public class ThongKe_DTO {
	private String masv;
	private String MaHK;
	private String Malop;
	private Double Diemtb;
	public ThongKe_DTO(String masv){
		this(masv,"");
	}
	public ThongKe_DTO(String masv,String MaHK){
		this(masv,MaHK,"");
	}
	public ThongKe_DTO(String masv,String MaHK,String Malop){
		this(masv,MaHK,Malop,-1.0);
	}
	public ThongKe_DTO(String masv,String MaHK,String Malop,Double Diemtb ){
		this.masv = masv;
		this.MaHK = MaHK;
		this.Malop = Malop;
		this.Diemtb = Diemtb;
	}
	public ThongKe_DTO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getMaHK() {
		return MaHK;
	}
	public void setMaHK(String maHK) {
		MaHK = maHK;
	}
	public String getMalop() {
		return Malop;
	}
	public void setMalop(String malop) {
		Malop = malop;
	}
	public Double getDiemtb() {
		return Diemtb;
	}
	public void setDiemtb(Double diemtb) {
		Diemtb = diemtb;
	}
	
}
