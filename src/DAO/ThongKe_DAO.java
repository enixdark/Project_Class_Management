package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.ThongKe_DTO;
import DTO.ThongKe_DTO;



public class ThongKe_DAO {
	public static dataconnect connect;
	public ThongKe_DAO (){
		connect = new dataconnect();
	}
	
	public static ArrayList<ThongKe_DTO> getdata(){
		connect.Connect();
		ArrayList<ThongKe_DTO> SV = new ArrayList<ThongKe_DTO>();
		ResultSet rs = null;
		String sql ="select diem.masv,diem.mahk,sinhvien.malop,SUM(diemtb)/COUNT(diemtb) as tb from sinhvien inner join diem " +
				"on diem.masv = sinhvien.masv " +
				"group by diem.masv,diem.mahk,sinhvien.malop order by diem.mahk";
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				ThongKe_DTO sv = new ThongKe_DTO();
				sv.setMasv(rs.getString("masv"));
				sv.setMalop(rs.getString("malop"));
				sv.setMaHK(rs.getString("mahk"));
				sv.setDiemtb(rs.getDouble("tb"));
				SV.add(sv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect.Disconnect();
		return SV;
	}
	
	public ArrayList<ThongKe_DTO> Search(ThongKe_DTO SV,boolean check){
		connect.Connect();
		ArrayList<ThongKe_DTO> DMD = new ArrayList<ThongKe_DTO>();
		ArrayList<String> arr = new ArrayList<String>();
		
		String masv = SV.getMasv();
		String malop = SV.getMalop();
		String mahk = SV.getMaHK();
		double diemtb = SV.getDiemtb();
		String diem = "";
		String dk = " where ";
		if(check){
		if (!masv.equals("")){
			arr.add("diem.MASV = '" + masv +"'");
		}
		if (!malop.equals("")){
			arr.add("sinhvien.malop = '" + malop +"'");
		}
		if (!mahk.equals("")){
			arr.add("diem.mahk = '" + mahk +"'");
		}
		if(diemtb>=0){
			diem = "having SUM(diemtb)/COUNT(diemtb) = " + diemtb;
			dk = "";
		}
		}
		else
		{
			if (!masv.equals("")){
				arr.add("diem.MASV like '%" + masv +"%'");
			}
			if (!malop.equals("")){
				arr.add("sinhvien.malop like '%" + malop +"%'");
			}
			if (!mahk.equals("")){
				arr.add("diem.mahk like '%" + mahk +"%'");
			}
			if(diemtb>=0){
				diem = "having SUM(diemtb)/COUNT(diemtb) >= " + diemtb;
				dk = "";
			}
		}
		
		
		ResultSet rs = null;
		
		String sql ="select diem.masv,diem.mahk,sinhvien.malop,SUM(diemtb)/COUNT(diemtb) as tb " +
				"from sinhvien inner join diem on diem.masv = sinhvien.masv " + dk;
		for (int i = 0 ; i<arr.size();i++){
			if ( i == 0 ){
				sql = sql + arr.get(0);
			}
			else{
				sql = sql + " and " + arr.get(i);
			}
			
			
		}
		sql += " group by diem.masv,diem.mahk,sinhvien.malop " + diem + " order by diem.mahk";
		System.out.println(sql);
		rs = connect.Exec(sql);
		try {
			while(rs.next()){
				ThongKe_DTO sv = new ThongKe_DTO();
				sv.setMasv(rs.getString("masv"));
				sv.setMalop(rs.getString("malop"));
				sv.setMaHK(rs.getString("mahk"));
				sv.setDiemtb(rs.getDouble("tb"));
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
