package DTO;

public class DIEM_DTO {
	private String Masv;
	private String MaMon;
	private String MaHK;
	private double Diemqt;
	private double diemthi1;
	private double diemthi2;
	//private double diemtb;
	private int nam;
	public String getMasv() {
		return Masv;
	}
	public void setMasv(String masv) {
		Masv = masv;
	}
	public String getMaMon() {
		return MaMon;
	}
	public void setMaMon(String maMon) {
		MaMon = maMon;
	}
	public String getMaHK() {
		return MaHK;
	}
	public void setMaHK(String maHK) {
		MaHK = maHK;
	}
	public double getDiemqt() {
		return Diemqt;
	}
	public void setDiemqt(double diemqt) {
		Diemqt = diemqt;
	}
	public double getDiemthi1() {
		return diemthi1;
	}
	public void setDiemthi1(double diemthi1) {
		this.diemthi1 = diemthi1;
	}
	public double getDiemthi2() {
		return diemthi2;
	}
	public void setDiemthi2(double diemthi2) {
		this.diemthi2 = diemthi2;
	}
	
	public double getDiemtb() {
		if((Diemqt+diemthi1)/2 > 4.0)
			return (Diemqt+diemthi1)/2;
		else if((Diemqt+diemthi2)/2 > 4.0)
			return (Diemqt+diemthi2)/2 ;
		else
			return diemthi1 > diemthi2 ? (Diemqt+diemthi1)/2 : (Diemqt+diemthi2)/2;
	}
	
	public DIEM_DTO(){}
	public DIEM_DTO(String Masv){
		this.Masv = Masv;
		
		
	}
	public DIEM_DTO(String Masv,String MaMon,String MaHK){
		this.Masv = Masv;
		this.MaMon = MaMon;
		this.MaHK = MaHK;
		
	}
	public DIEM_DTO(String Masv,String MaMon,String MaHK,double Diemqt,double diemthi1,double diemthi2,int nam){
		this.Masv = Masv;
		this.MaMon = MaMon;
		this.MaHK = MaHK;
		this.Diemqt = Diemqt;
		this.diemthi1 = diemthi1;
		this.diemthi2 = diemthi2;
//		if((Diemqt+diemthi1)/2 > 4.0)
//			diemtb = (Diemqt+diemthi1)/2;
//		else if((Diemqt+diemthi2)/2 > 4.0)
//			diemtb = (Diemqt+diemthi2)/2 ;
//		else
//			diemtb = diemthi1 > diemthi2 ? (Diemqt+diemthi1)/2 : (Diemqt+diemthi2)/2;
		this.setNam(nam);
	}
	public int getNam() {
		return nam;
	}
	
	public void setNam(int nam) {
		this.nam = nam;
	}
	
	
}
