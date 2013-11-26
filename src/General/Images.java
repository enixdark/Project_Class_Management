package General;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DAO.dataconnect;

public class Images {
	dataconnect conn;
	public Images(){
		conn = new dataconnect();
	}
	

	        public byte[] Encode(String img)
	        {
	                int len;
	                byte[] images = null;
	                try
	                {
	                        File file = new File(img);
	                        FileInputStream fis = new FileInputStream(file);
	                        len = (int)file.length();
	                        images = new byte[len+1];
	                        fis.read(images);
	                        

	                }
	                catch (Exception e)
	                {
	                        e.printStackTrace();
	                }
	                return images;
	        }

//	        public void Decode()
//	        {
//	                
//	                 byte[] fileBytes;
//	                 String query;
//	                 try
//	                 {
//	                         query = "select encode from tblimages";
//	                         Statement state = conn.createStatement();
//	                         ResultSet rs = state.executeQuery(query);
//	                         if (rs.next())
//	                        {
//	                                  fileBytes = rs.getBytes(1);
//	                                  System.out.println(System.getProperty("user.dir")+"\\Image");
//	                                  OutputStream targetFile=  
//	                                  new FileOutputStream(System.getProperty("user.dir")+"\\src\\Image\\n.JPG");
//	                                  
//	                                  
//	                                  targetFile.write(fileBytes);
//	                                  targetFile.close();
//	                        }        
//	                        
//	                 }
//	                 catch (Exception e)
//	                 {
//	                         e.printStackTrace();
//	                 }
//	        }
}
