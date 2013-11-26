package Components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class ClockTime2 extends JPanel {
	private JTextField txtTime;

	/**
	 * Create the panel.
	 */
	public ClockTime2() {
		
		txtTime = new JTextField();
		txtTime.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtTime.setBackground(Color.WHITE);
		txtTime.setEnabled(false);
		txtTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtTime.setText("TIME");
		txtTime.setEditable(false);
		txtTime.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(txtTime, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txtTime, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		Timer t = new javax.swing.Timer(1000, new ClockListener());
		t.start();
	}
	
	class ClockListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
            Calendar now = Calendar.getInstance();
            int h = now.get(Calendar.HOUR_OF_DAY);
            int m = now.get(Calendar.MINUTE);
            int s = now.get(Calendar.SECOND);
            txtTime.setText("" + h + ":" + m + ":" + s);
            
            //txttime.setText(String.format("%1$tH:%1$tM:%1$tS", now));
    	}
    }
}
