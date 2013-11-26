package GUI;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

import BUS.Hedaotao_BUS;
import BUS.Lop_BUS;
import DTO.Hedaotao_DTO;
import DTO.Lop_DTO;



import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;

public class Lop_GUI extends JPanel {

	/**
	 * Create the panel.
	 */
	private Map<String,String> Data = new HashMap<String,String>();
	private JButton bt_luu;
    private JButton bt_ref;
    private JButton bt_sua;
    private JButton bt_them;
    private JButton bt_xoa;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane2;
    private JTable jTable2;
    private JLabel lblMLp;
    private JLabel lblTnLp;
    private JTextField txt_ml;
    private JTextField txt_th;
    private DefaultTableModel dtm;
    private boolean state;
    private JComboBox comboBox;
    private Lop_BUS Lop;
    private JPanel panel;
    
	public Lop_GUI() {
		setBackground(Color.WHITE);
		init();
		loadtable();
		lockbutton(true);
	}
	
	private void init() {
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(Color.WHITE);
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable2.setFillsViewportHeight(true);
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setBackground(Color.WHITE);
        txt_ml = new javax.swing.JTextField();
        txt_th = new javax.swing.JTextField();
        lblMLp = new javax.swing.JLabel();
        lblTnLp = new javax.swing.JLabel();
        bt_luu = new javax.swing.JButton();
        bt_luu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Lop = new Lop_BUS();
				String malop = txt_ml.getText();
				String tenlop = txt_th.getText();
				String mahe = comboBox.getSelectedItem().toString();
				
				System.out.print(malop+tenlop+mahe);
				Lop_DTO S = new Lop_DTO(malop,tenlop,mahe);
				if (state){
					Lop.insert(S);
				}
				else
				{
					Lop.update(S);
				}
				
				loadtable();
        		//lockbutton(true);
        	}
        });
        bt_luu.setIcon(new ImageIcon(Lop_GUI.class.getResource("/Image/save.png")));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
            		"Mã Lớp","Tên Lớp","Mã Hệ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class,String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        jScrollPane2.setViewportView(jTable2);
        ListSelectionModel row = jTable2.getSelectionModel();
        row.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //Ignore extra messages.
                if (e.getValueIsAdjusting()) return;
                
                ListSelectionModel ls = (ListSelectionModel)e.getSource();
                if (!ls.isSelectionEmpty()) {
                    int selectedRow = ls.getMinSelectionIndex();
                    txt_ml.setText((String) jTable2.getValueAt( selectedRow ,0));
                    txt_th.setText((String) jTable2.getValueAt( selectedRow ,1));
                    
                    }
                    
                    
                    
                     
                }
            }
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel2.setLayout(jPanel2Layout);

        lblMLp.setText("M\u00E3 L\u1EDBp");

        lblTnLp.setText("T\u00EAn L\u1EDBp");
        
        JLabel lblMH = new JLabel();
        lblMH.setText("M\u00E3 H\u1EC7");
        
        comboBox = new JComboBox();
        Hedaotao_BUS He = new Hedaotao_BUS();
        ArrayList<Hedaotao_DTO> arr = new ArrayList<Hedaotao_DTO>(); 
        arr = He.getdata();
        for(Hedaotao_DTO i : arr){
        	comboBox.addItem(i.getMahe());
        }
        
        JButton bt_clear = new JButton();
        bt_clear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		txt_ml.setText("");
        		txt_th.setText("");
        	}
        });
        bt_clear.setIcon(new ImageIcon(Lop_GUI.class.getResource("/Image/edit_clear.png")));
        
        JButton bt_out = new JButton();
        bt_out.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lockbutton(true);
        	}
        });
        bt_out.setIcon(new ImageIcon(Lop_GUI.class.getResource("/Image/stop.png")));
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txt_ml, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblMLp))
        			.addGap(41)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txt_th, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTnLp))
        			.addGap(38)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(bt_luu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(bt_clear, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        					.addGap(1))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addComponent(lblMH, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        					.addGap(346)))
        			.addGap(5)
        			.addComponent(bt_out, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(bt_clear, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        				.addComponent(bt_out, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblMLp)
        						.addComponent(lblTnLp)
        						.addComponent(lblMH))
        					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txt_ml, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txt_th, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(bt_luu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        jPanel3.setLayout(jPanel3Layout);
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
        			.addGap(20))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
        				.addComponent(jPanel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(6)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(90))
        );
        bt_them = new javax.swing.JButton();
        bt_them.setBounds(10, 0, 38, 35);
        bt_them.setBackground(Color.WHITE);
        bt_them.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		lockbutton(false);
        		state = true;
        	}
        });
        bt_them.setIcon(new ImageIcon(Lop_GUI.class.getResource("/Image/plus_orange.png")));
        
                bt_them.setFocusable(false);
                bt_them.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                bt_them.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                bt_them.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
        bt_xoa = new javax.swing.JButton();
        bt_xoa.setBounds(54, 0, 38, 35);
        bt_xoa.setBackground(Color.WHITE);
        bt_xoa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (JOptionPane.showConfirmDialog(null,"Bạn Có Chắc Muốn Xóa Không","Thông Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					Lop  = new Lop_BUS  ();
					String malop = (String) jTable2.getValueAt(jTable2.getSelectedRow(),0);
					Lop_DTO S = new Lop_DTO(malop);
					Lop.delete(S);
					dtm.removeRow(jTable2.getSelectedRow());
					JOptionPane.showMessageDialog(null,"Đã Xóa Thành Công");
					                }
        	}
        });
        bt_xoa.setIcon(new ImageIcon(Lop_GUI.class.getResource("/Image/deletered.png")));
        
                bt_xoa.setFocusable(false);
                bt_xoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                bt_xoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                bt_xoa.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
        bt_sua = new javax.swing.JButton();
        bt_sua.setBounds(97, 0, 38, 35);
        bt_sua.setBackground(Color.WHITE);
        bt_sua.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lockbutton(false);
        		state = false;
        	}
        });
        bt_sua.setIcon(new ImageIcon(Lop_GUI.class.getResource("/Image/pencil3.png")));
        
                bt_sua.setFocusable(false);
                bt_sua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                bt_sua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                bt_sua.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
        bt_ref = new javax.swing.JButton();
        bt_ref.setBounds(142, 0, 38, 35);
        bt_ref.setBackground(Color.WHITE);
        bt_ref.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		loadtable();
        		lockbutton(true);
        	}
        });
        bt_ref.setIcon(new ImageIcon(Lop_GUI.class.getResource("/Image/refresh.png")));
        
                bt_ref.setFocusable(false);
                bt_ref.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                bt_ref.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                bt_ref.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
        panel.setLayout(null);
        panel.add(bt_them);
        panel.add(bt_xoa);
        panel.add(bt_sua);
        panel.add(bt_ref);
        this.setLayout(layout);
        
        bt_luu.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);


}
	 public void loadtable(){
		 	String[] header = {"Mã Lớp","Tên Lớp","Mã Hệ"};
		 
	        dtm = new DefaultTableModel(header,0){
	            Class[] types = {
	            		String.class, String.class,String.class
	                };
	                
	                public Class getColumnClass(int columnIndex) {
	                    return types[columnIndex];
	                }
	            };
			ArrayList<Lop_DTO> arr = new ArrayList<Lop_DTO>();
			Lop = new Lop_BUS();
			arr = Lop.getdata();
			Lop_DTO L = new Lop_DTO();
			System.out.println(arr.size());
			for(int i=0;i<arr.size();i++){
				L = arr.get(i);
				
				Object [] data = {L.getMalop(),L.getTenlop(),L.getMahe()};
				dtm.addRow(data);
			}
			jTable2.setModel(dtm);
			
	 }
	     public void lockbutton(boolean check){
		 bt_luu.setEnabled(!check);
		 bt_sua.setEnabled(check);
		 bt_them.setEnabled(check);
		 bt_xoa.setEnabled(check);
		 jPanel3.setVisible(!check);
	 }
}
