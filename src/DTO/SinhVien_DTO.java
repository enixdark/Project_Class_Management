package DTO;

import java.util.Calendar;
import java.util.Date;

public class SinhVien_DTO {
	private String Masv;
	private String Malop;
	private String Mahe;
	private String MaHK;
	private String Hoten;
	private boolean gioitinh;
	private Date NgaySinh;
	private String Que;
	public String getMasv() {
		return Masv;
	}
	public void setMasv(String masv) {
		Masv = masv;
	}
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
	public String getMaHK() {
		return MaHK;
	}
	public void setMaHK(String maHK) {
		MaHK = maHK;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getQue() {
		return Que;
	}
	public void setQue(String que) {
		Que = que;
	}
	
	public SinhVien_DTO(){
		
	}
	public SinhVien_DTO(String Masv){
		this.Masv = Masv;
		
	}
	public SinhVien_DTO(String Masv,String Malop,String Mahe,String MaHK, String Hoten,boolean gioitinh,Date NgaySinh,String Que){
		this.Masv = Masv;
		this.Malop = Malop;
		this.Mahe = Mahe;
		this.MaHK = MaHK;
		this.Hoten = Hoten;
		this.gioitinh = gioitinh;
		this.NgaySinh = NgaySinh;
		this.Que = Que;
	}
	public boolean isGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
}
