package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import DTO.DIEM_DTO;
import DTO.SinhVien_DTO;

public class DIEM_DAO {
	public static dataconnect connect;
	public DIEM_DAO (){
		connect = new dataconnect();
	}
	
	public static ArrayList<DIEM_DTO> getdata(){
		connect.Connect();
		ArrayList<DIEM_DTO> SV = new ArrayList<DIEM_DTO>();
		ResultSet rs = null;
		String sql ="select * from Diem";
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				DIEM_DTO sv = new DIEM_DTO();
				sv.setMasv(rs.getString(1));
				sv.setMaMon(rs.getString(2));
				sv.setMaHK(rs.getString(3));
				sv.setDiemqt(rs.getDouble(4));
				sv.setDiemthi1(rs.getDouble(5));
				sv.setDiemthi2(rs.getDouble(6));
				int nam = rs.getInt("namhoc");
				sv.setNam(nam);
				SV.add(sv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return SV;
	}
	
	
	public Object insert(DIEM_DTO sv){
		connect.Connect();
		String MaSV = sv.getMasv();
		String Mamon = sv.getMaMon();
		String MaHK = sv.getMaHK();
		double diemqt = sv.getDiemqt();
		double diemthi1 = sv.getDiemthi1();
		double diemthi2 = sv.getDiemthi2();
		double diemtb = sv.getDiemtb();
		int nam = sv.getNam();
		
		
		String value = String.format("values('%s','%s','%s',%f,%f,%f,%f,%d)",MaSV,Mamon,MaHK,diemqt,
				diemthi1,diemthi2,diemtb,nam);
		String sql = "Insert into Diem(masv,mamon,mahk,diemqt,diemlan1,diemlan2,diemtb,namhoc) " + value;
		System.out.print(sql);
		return connect.update(sql);
		
		
}
	
	public Object delete(DIEM_DTO sv){
		connect.Connect();
		String masv = sv.getMasv();
		String sql = "delete from  Diem where Masv = '" + masv +"'";
		return connect.update(sql);
	}
	
	public Object update(DIEM_DTO sv){
		connect.Connect();
		String MaSV = sv.getMasv();
		String Mamon = sv.getMaMon();
		String MaHK = sv.getMaHK();
		double diemqt = sv.getDiemqt();
		double diemthi1 = sv.getDiemthi1();
		double diemthi2 = sv.getDiemthi2();
		double diemtb = sv.getDiemtb();
		int nam = sv.getNam();
		
		String sql = String.format("update SinhVien set " + 
				"mamon = '%s',mahk = '%s' ,diemqt = %f ,diemlan1" +
				" = %f ,diemlan2 = %s, diemtb = %f , namhoc = %d where masv = '%s'",Mamon,MaHK,diemqt,
				diemthi1,diemthi2,diemtb,nam,MaSV);
		return connect.update(sql);
	}
	public ArrayList<DIEM_DTO> Search(DIEM_DTO SV){
		connect.Connect();
		ArrayList<DIEM_DTO> DMD = new ArrayList<DIEM_DTO>();
		ArrayList<String> arr = new ArrayList<String>();
		
		String masv = SV.getMasv();
		String mamon = SV.getMaMon();
		String mahk = SV.getMaHK();
//		double diemqt = SV.getDiemqt();
//		double diemthi1 = SV.getDiemthi1();
//		double diemthi2 = SV.getDiemthi2();
//		double diemthi1 = SV.getDiemthi1();
		if (!masv.equals("")){
			arr.add("MASV = '" + masv +"'");
		}
		if (!mamon.equals("")){
			arr.add("mamon = '" + mamon +"'");
		}
		if (!mahk.equals("")){
			arr.add("mahk = '" + mamon +"'");
		}
		
		
		
		ResultSet rs = null;
		
		String sql ="select * from Diem where ";
		for (int i = 0 ; i<arr.size();i++){
			if ( i == 0 ){
				sql = sql + arr.get(0);
			}
			else{
				sql = sql + " and " + arr.get(i);
			}
			
			
		}
		sql += " order by mahk";
		
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				DIEM_DTO sv = new DIEM_DTO();
				sv.setMasv(rs.getString("masv"));
				sv.setMaMon(rs.getString("mamon"));
				sv.setMaHK(rs.getString("mahk"));
				sv.setDiemqt(rs.getDouble("diemqt"));
				sv.setDiemthi1(rs.getDouble("diemlan1"));
				sv.setDiemthi2(rs.getDouble("diemlan2"));
				//sv.setQue(rs.getString("que"));
				DMD.add(sv);
			} 
		}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return DMD;
		
	}
}
