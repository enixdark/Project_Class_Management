package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import DTO.SinhVien_DTO;



public class SinhVien_DAO {
	public static dataconnect connect;
	public SinhVien_DAO(){
		connect = new dataconnect();
	}
	
	public static ArrayList<SinhVien_DTO> getdata(){
		connect.Connect();
		ArrayList<SinhVien_DTO> SV = new ArrayList<SinhVien_DTO>();
		ResultSet rs = null;
		String sql ="select * from SinhVien";
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				SinhVien_DTO sv = new SinhVien_DTO();
				sv.setMasv(rs.getString("masv"));
				sv.setMahe(rs.getString("mahe"));
				sv.setMaHK(rs.getString("mahk"));
				sv.setMalop(rs.getString("malop"));
				sv.setHoten(rs.getString("hoten"));
				sv.setGioitinh(rs.getBoolean("gioitinh"));
				sv.setNgaySinh(rs.getDate("ngaysinh"));
				sv.setQue(rs.getString("que"));
				SV.add(sv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return SV;
	}
	
	public static ArrayList<String> getcombobox(String Table,String Column){
		connect.Connect();
		ArrayList<String> SV = new ArrayList<String>();
		ResultSet rs = null;
		String sql ="select " + Column + " from " + Table;
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				SV.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return SV;
	}
	
	public String getdata_from_Relationship(String Table1,String Column1,String Column2,String value){
		
		ResultSet rs = null;
		
		String sql = String.format("select %s from %s where %s.%s = '%s'",Column1,Table1,
				Table1,Column2,value);
		//String sql = "select * from Lop ";
		String data = "";
		connect.Connect();
		rs = connect.Exec(sql);
		System.out.println(sql);
		try {
			while(rs.next())
				data = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return data;
	}
	public Object insert(SinhVien_DTO sv){
		connect.Connect();
		String MaSV = sv.getMasv();
		String Hoten = sv.getHoten();
		String MaHK = sv.getMaHK();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String Ngaysinh = formatter.format(sv.getNgaySinh());
		int gioitinh = sv.isGioitinh() ? 1 : 0;
		String Que = sv.getQue();
		String Mahe = sv.getMahe();
		String Malop = sv.getMalop();
		String value = String.format("values('%s','%s','%s','%s','%s',%d,'%s','%s')",MaSV,Malop,Mahe,MaHK,Hoten,
				gioitinh,Ngaysinh,Que);
		String sql = "Insert into SinhVien(masv,malop,mahe,mahk,hoten,gioitinh,ngaysinh,que) " + value;
		System.out.println(sql);
		return connect.update(sql);
		
		
}
	
	public Object delete(SinhVien_DTO sv){
		connect.Connect();
		String masv = sv.getMasv();
		String sql = "delete from  SinhVien where Masv = '" + masv +"'";
		return connect.update(sql);
	}
	
	public Object update(SinhVien_DTO sv){
		connect.Connect();
		String MaSV = sv.getMasv();
		String Hoten = sv.getHoten();
		String MaHK = sv.getMaHK();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String Ngaysinh = formatter.format(sv.getNgaySinh());
		int gioitinh = sv.isGioitinh() ? 1 : 0;
		String Que = sv.getQue();
		String Mahe = sv.getMahe();
		String Malop = sv.getMalop();
		
		String sql = String.format("update SinhVien set " + 
				"malop = '%s',mahe = '%s' ,mahk = '%s' ,hoten = '%s' ,gioitinh = %d,ngaysinh" +
				" = '%s' ,que = '%s' where masv = '%s'",Malop,Mahe,MaHK,
				Hoten,gioitinh,Ngaysinh,Que,MaSV);
		System.out.println(sql);
		return connect.update(sql);
	}
	
	public ArrayList<SinhVien_DTO> Search(SinhVien_DTO SV){
		connect.Connect();
		ArrayList<SinhVien_DTO> DMSV = new ArrayList<SinhVien_DTO>();
		ArrayList<String> arr = new ArrayList<String>();
		
		String masv = SV.getMasv();
		String hoten = SV.getHoten();
		int gioitinh = ( SV.isGioitinh() ? 1 : 0 );
		String Ngaysinh ="";
				try{
					Format formatter = new SimpleDateFormat("yyyy-MM-dd");
					Ngaysinh = formatter.format(SV.getNgaySinh());
				}
		catch(Exception e){
			
		}
		
		String que = SV.getQue();
		String Mahk = SV.getMaHK();
		String Mahe = SV.getMahe();
		String Malop = SV.getMalop();
		arr.add("gioitinh = " + gioitinh);
		if (!masv.equals("")){
			arr.add("MASV = '" + masv +"'");
		}
		if (!hoten.equals("")){
			arr.add("HOTEN = '" + hoten +"'");
		}
		if (!Mahe.equals("")){
			arr.add("MAHE = '" + Mahe +"'");
		}
		if (!Mahk.equals("")){
			arr.add("MAHK = '" + Mahk +"'");
		}
		if (!Malop.equals("")){
			arr.add("MALOP = '" + Malop +"'");
		}
		if (!que.equals("")){
			arr.add("que = '" + que +"'");
		}
		if (!Ngaysinh.equals("")){
			arr.add("NgaySinh = '" + Ngaysinh +"'");
		}
		
		
		ResultSet rs = null;
		
		String sql ="select * from SinhVien where ";
		for (int i = 0 ; i<arr.size();i++){
			if ( i == 0 ){
				sql = sql + arr.get(0);
			}
			else{
				sql = sql + " and " + arr.get(i);
			}
			
			
		}
		System.out.println(sql);
		
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				SinhVien_DTO sv = new SinhVien_DTO();
				sv.setMasv(rs.getString("masv"));
				sv.setMahe(rs.getString("mahe"));
				sv.setMaHK(rs.getString("mahk"));
				sv.setMalop(rs.getString("malop"));
				sv.setHoten(rs.getString("hoten"));
				sv.setGioitinh(rs.getBoolean("gioitinh"));
				sv.setNgaySinh(rs.getDate("ngaysinh"));
				sv.setQue(rs.getString("que"));
				DMSV.add(sv);
			} 
		}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return DMSV;
		
	}
	
	public ArrayList<SinhVien_DTO> SearchID(SinhVien_DTO SV){
		connect.Connect();
		ArrayList<SinhVien_DTO> DMSV = new ArrayList<SinhVien_DTO>();
		
		String masv = SV.getMasv();
		
		ResultSet rs = null;
		
		String sql ="select * from SinhVien where masv ='" + masv + "'";
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				SinhVien_DTO sv = new SinhVien_DTO();
				sv.setMasv(rs.getString("masv"));
				sv.setMahe(rs.getString("mahe"));
				sv.setMaHK(rs.getString("mahk"));
				sv.setMalop(rs.getString("malop"));
				sv.setHoten(rs.getString("hoten"));
				sv.setGioitinh(rs.getBoolean("gioitinh"));
				sv.setNgaySinh(rs.getDate("ngaysinh"));
				sv.setQue(rs.getString("que"));
				DMSV.add(sv);
			} 
		}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return DMSV;
		
	}
}
