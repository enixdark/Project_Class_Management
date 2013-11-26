package Components;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Components.TimeClock.ClockListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TimeClock extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextField txttime;  // set by timer listener

	   
    public TimeClock() {
        
        txttime = new JTextField(5);
        txttime.setText("fdf");
        txttime.setEditable(false);
        txttime.setFont(new Font("sansserif", Font.PLAIN, 48));
        
        JPanel content = new JPanel();
        GroupLayout gl_content = new GroupLayout(content);
        gl_content.setHorizontalGroup(
        	gl_content.createParallelGroup(Alignment.LEADING)
        		.addComponent(txttime, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        gl_content.setVerticalGroup(
        	gl_content.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_content.createSequentialGroup()
        			.addComponent(txttime, GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
        			.addContainerGap())
        );
        content.setLayout(gl_content);
//        javax.swing.Timer t = new javax.swing.Timer(1000, new ClockListener());
//        t.start();
    }
    
    
    class ClockListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
            Calendar now = Calendar.getInstance();
            int h = now.get(Calendar.HOUR_OF_DAY);
            int m = now.get(Calendar.MINUTE);
            int s = now.get(Calendar.SECOND);
            txttime.setText("" + h + ":" + m + ":" + s);
            
            //txttime.setText(String.format("%1$tH:%1$tM:%1$tS", now));
    	}
    }
    
   

}
