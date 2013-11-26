package General;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import DAO.dataconnect;
import DTO.ThongKe_DTO;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

//public class Report {
//
//	dataconnect conn = null;
//	public Report(){
//		conn = new dataconnect();
//	}
//	public String PercentExtract(ThongKe_DTO TK){
//		String s = "";
//		if(!TK.getMasv().isEmpty()){
//			s = " diem.masv like '%" + TK.getMasv() +"'";
//		}
//		else if(!TK.getMaHK().isEmpty()){
//			s = " diem.mahk like '%" + TK.getMaHK() +"'";
//		}
//		else if(!TK.getMalop().isEmpty()){
//			s = " sinhvien.malop like '%" + TK.getMalop() +"'";
//		}
//		else if(TK.getDiemtb() >= 0){
//			s = " diemtb >= " + TK.getDiemtb() ;
//		}
//		return " where " + s;
//	}
//	
//	public String Extract(ThongKe_DTO TK){
//		String s = "";
//		if(!TK.getMasv().isEmpty()){
//			s = " diem.masv = '" + TK.getMasv() +"'";
//		}
//		else if(!TK.getMaHK().isEmpty()){
//			s = " diem.mahk = '" + TK.getMaHK() +"'";
//		}
//		else if(!TK.getMalop().isEmpty()){
//			s = " sinhvien.malop = '" + TK.getMalop() +"'";
//		}
//		else if(TK.getDiemtb() >= 0){
//			s = " diemtb = " + TK.getDiemtb() ;
//		}
//		return " where " + s;
//	}
//	
//	public void QueryReport(ThongKe_DTO TK,boolean extract) {
//
//		try {
//			conn.Connect();
////			String s = "";
////			if(extract)
////				s = Extract(TK);
////			else
////				s = PercentExtract(TK);
//			System.out.println("Loading Report Designs");
//			File il = new File("jrxml\\ReportTK.jrxml");
//			System.out.println(il.exists());
//			InputStream input = new FileInputStream(il);
//			
//			JasperDesign jasperDesign = JRXmlLoader.load(input);
////			String sql = "select * from TK";
////			JRDesignQuery query = new JRDesignQuery();
////			query.setText(sql);
////			jasperDesign.setQuery(query);
//			System.out.println("Compiling Report Designs");
//			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//
//			System.out.println("Creating JasperPrint Object");
//			Map<String, String> parameters = new HashMap<String, String>();
//			parameters.put("ReportTitle", "PDF JasperReport");
//
//			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,conn.conn);
//
//			//Exporting the report
//			OutputStream output = new FileOutputStream(new File("report/Leaf_Violet.pdf"));
//
//			JasperExportManager.exportReportToPdfStream(jasperPrint, output);
//			
//			JasperViewer.viewReport(jasperPrint);
//			System.out.println("Report Generation Complete");
//			conn.Disconnect();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (JRException e) {
//			e.printStackTrace();
//		}
//	}
//	public static void main(String[] args){
//		new Report().QueryReport(new ThongKe_DTO(),true);
//	}
//
//	
//}
public class Report {

	dataconnect conn = null;
	public Report(){
		conn = new dataconnect();
	}
	public String PercentExtract(ThongKe_DTO TK){
		String s = "";
		
		if(!TK.getMasv().isEmpty()){
			s = "where diem.masv like '%" + TK.getMasv() +"%'";
		}
		else if(!TK.getMaHK().isEmpty()){
			s = "where diem.mahk like '%" + TK.getMaHK() +"%'";
		}
		else if(!TK.getMalop().isEmpty()){
			s = "where sinhvien.malop like '%" + TK.getMalop() +"%'";
		}
		else if(TK.getDiemtb() >= 0){
			s = " having SUM(diemtb)/COUNT(diemtb) >= " + TK.getDiemtb();
		}
		return s;
	}
	
	public String Extract(ThongKe_DTO TK){
		String s = "";
		if(!TK.getMasv().isEmpty()){
			s = "where diem.masv = '" + TK.getMasv() +"'";
		}
		else if(!TK.getMaHK().isEmpty()){
			s = "where diem.mahk = '" + TK.getMaHK() +"'";
		}
		else if(!TK.getMalop().isEmpty()){
			s = "where sinhvien.malop = '" + TK.getMalop() +"'";
		}
		else if(TK.getDiemtb() >= 0){
			s = " having SUM(diemtb)/COUNT(diemtb) = " + TK.getDiemtb();
		}
		return s;
	}
	
	public void QueryReport(ThongKe_DTO TK,boolean extract) {

		try {
			conn.Connect();
			String s = "";
			if(extract)
				s = Extract(TK);
			else
				s = PercentExtract(TK);
			String where = s.contains("where") ? s : "";
			String having = s.contains("having") ? s : "";
			System.out.println("BEGIN....................");
			File il = new File("jrxml\\TK.jrxml");
			System.out.println(il.exists());
			InputStream input = new FileInputStream(il);
			
			JasperDesign jasperDesign = JRXmlLoader.load(input);
			String sql = "select diem.masv,diem.mahk,sinhvien.malop,SUM(diemtb)/COUNT(diemtb) as diemtb from sinhvien inner join diem  " +
					"on diem.masv = sinhvien.masv " + where + 
					" group by diem.masv,diem.mahk,sinhvien.malop " + having +
				" order by diem.mahk";
//			String sql = "select * from TK ";
			System.out.println(sql);
			JRDesignQuery query = new JRDesignQuery();
			query.setText(sql);
			jasperDesign.setQuery(query);
			System.out.println("Test Compliling");
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

			System.out.println("Creating.................");


			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,conn.conn);

			//Exporting the report
			OutputStream output = new FileOutputStream(new File("report/File.pdf"));

			JasperExportManager.exportReportToPdfStream(jasperPrint, output);
			if(JOptionPane.showConfirmDialog(null,"Bạn Có Muốn Mở File vừa In ra không","THông Báo",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				JasperViewer.viewReport(jasperPrint);
			}
			System.out.println("Complete");
			conn.Disconnect();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
