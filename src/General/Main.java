package General;

import java.awt.EventQueue;

import javax.swing.UIManager;

import GUI.AdminMainForm;

public class Main {

	/**
	 * @param args
	 */
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			EventQueue.invokeLater(new Runnable() {
				public void run() {
				
					try {	
					UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
					UIManager.put("Panel.opaque", Boolean.TRUE);
						AdminMainForm GUI = new AdminMainForm();
						GUI.frame.setVisible(true);
//						GUI.setVisible(true);
						//GUI.setLocation(400,300);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	

}
