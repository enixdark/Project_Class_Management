package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.AbstractButton;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;


import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

import BUS.SinhVien_BUS;

import DTO.SinhVien_DTO;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class SinhVien_GUI extends JPanel {
	//private JPanel contentPane;
	private javax.swing.JLabel lblMLp;
    private javax.swing.JLabel Label_Masv;
    private javax.swing.JLabel Label_Ten;
    private javax.swing.JLabel Label_gt;
    private javax.swing.JLabel Label_ns;
    private javax.swing.JLabel lblQu;
    private javax.swing.JButton bt_luu;
    private javax.swing.JButton bt_ref;
    private javax.swing.JButton bt_ref1;
    private javax.swing.JButton bt_sua;
    private javax.swing.JButton bt_them;
    private javax.swing.JButton bt_xoa;
    private javax.swing.JToggleButton btn_gt;
    private javax.swing.JComboBox combobox_ML;
    private org.jdesktop.swingx.JXDatePicker date_ns;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_ht;
    private javax.swing.JTextField txt_masv;
    private javax.swing.JTextField txt_que;
    private DefaultTableModel dtm;
	private boolean check = true;
	private boolean state ;
	private JComboBox exp;
	private SinhVien_BUS SVBUS;
	private JLabel lblH;
	private  JCheckBox checkBox_masv ;
    
	private  JCheckBox checkBox_tensv ;
    
	private JCheckBox checkBox_gt ;
    
	private JCheckBox checkBox_l ;
    
	private JCheckBox checkBox_ns ;
    
	private JCheckBox checkBox_q ;
    
	private JCheckBox checkBox_he ;
    
	private JCheckBox checkBox_hk ;
	private JComboBox comboBox_MHK;
    
    
    private JComboBox comboBox_he;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
				try {	UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
				UIManager.put("Panel.opaque", Boolean.TRUE);
					SinhVien_GUI frame = new SinhVien_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SinhVien_GUI() {
		setBackground(Color.WHITE);
		//setAlwaysOnTop(true);
		init();
		loadcombobox();
		loadtable(true);
		Jcheckbox_setvisible(false);
		
	}
	 private void init() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 821, 638);
			//contentPane = new JPanel();
			//contentPane.setBackground(Color.WHITE);
			//contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			//setContentPane(contentPane);
		 jPanel3 = new javax.swing.JPanel();
	        jPanel2 = new javax.swing.JPanel();
	        jPanel2.setAlignmentY(Component.TOP_ALIGNMENT);
	        jPanel2.setAutoscrolls(true);
	        jPanel2.setBackground(Color.WHITE);
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jScrollPane1.setAlignmentY(Component.TOP_ALIGNMENT);
	        table = new javax.swing.JTable();
	        table.setForeground(Color.BLACK);
	        table.setBackground(Color.WHITE);
	        jPanel4 = new javax.swing.JPanel();
	        jPanel4.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	        jPanel4.setBackground(Color.WHITE);
	        bt_them = new javax.swing.JButton();
	        bt_them.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        bt_them.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		 lockbutton(false);
	        		 state = true;
	        		 
	        	}
	        });
	        bt_them.setIcon(new ImageIcon(SinhVien_GUI.class.getResource("/Image/add_user.png")));
	        bt_sua = new javax.swing.JButton();
	        bt_sua.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		lockbutton(false);
	        		state = false;
	        	}
	        });
	        bt_sua.setIcon(new ImageIcon(SinhVien_GUI.class.getResource("/Image/edit_user.png")));
	        bt_xoa = new javax.swing.JButton();
	        bt_xoa.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		if (JOptionPane.showConfirmDialog(null,"Bạn Có Chắc Muốn Xóa Không","Thông Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
						SVBUS  = new SinhVien_BUS();
						String masv = (String) table.getValueAt(table.getSelectedRow(),0);
						SinhVien_DTO S = new SinhVien_DTO(masv);
						SVBUS.delete(S);
						dtm.removeRow(table.getSelectedRow());
						JOptionPane.showMessageDialog(null,"Đã Xóa Thành Công");
						
	                }
	        		
	        	}
	        });
	        bt_xoa.setIcon(new ImageIcon(SinhVien_GUI.class.getResource("/Image/remove_user.png")));
	        bt_luu = new javax.swing.JButton();
	        bt_luu.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		lockbutton(false);
	        		SVBUS = new SinhVien_BUS();
					String masv = txt_masv.getText();
					String hoten = txt_ht.getText();
					boolean gioitinh = btn_gt.isSelected();
					Date ngaysinh = date_ns.getDate();
					String que = txt_que.getText();
					
				    String malop = SVBUS.getdata_from_Relationship("Lop","malop","tenlop",(String)combobox_ML.getSelectedItem());
				    String mahe = SVBUS.getdata_from_Relationship("HeDaotao","mahe","tenhe",(String)comboBox_he.getSelectedItem());
				    String mahk = SVBUS.getdata_from_Relationship("hocki","mahk","tenhk",(String)comboBox_MHK.getSelectedItem());

				    System.out.println(malop + " " + mahe + " " + mahk);
				    SinhVien_DTO S = new SinhVien_DTO(masv,malop,mahe,mahk,hoten,gioitinh,ngaysinh,que);
					if (state){
						SVBUS.insert(S);
					}
					else
					{
						SVBUS.update(S);
					}
					JOptionPane.showMessageDialog(null,"Cập nhật Thành Công");
					loadtable(true);
	        	}
	        });
	        bt_luu.setIcon(new ImageIcon(SinhVien_GUI.class.getResource("/Image/save.png")));
	        bt_ref = new javax.swing.JButton();
	        bt_ref.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		lockbutton(true);
	        		loadtable(true);
	        	}
	        });
	        bt_ref.setIcon(new ImageIcon(SinhVien_GUI.class.getResource("/Image/refresh.png")));
	       
	        
	        jPanel1 = new javax.swing.JPanel();
	        jPanel1.setBackground(Color.WHITE);
	        Label_Masv = new javax.swing.JLabel();
	        Label_Ten = new javax.swing.JLabel();
	        Label_gt = new javax.swing.JLabel();
	        Label_ns = new javax.swing.JLabel();
	        lblQu = new javax.swing.JLabel();
	        lblMLp = new javax.swing.JLabel();
	        txt_masv = new javax.swing.JTextField();
	        txt_masv.setFont(new Font("Segoe UI", Font.PLAIN, 11));
	        txt_ht = new javax.swing.JTextField();
	        txt_ht.setFont(new Font("Segoe UI", Font.PLAIN, 11));
	        txt_que = new javax.swing.JTextField();
	        txt_que.setFont(new Font("Segoe UI", Font.PLAIN, 11));
	        date_ns = new org.jdesktop.swingx.JXDatePicker();
	        date_ns.getEditor().setFont(new Font("Segoe UI", Font.PLAIN, 11));
	        date_ns.setFont(new Font("Segoe UI", Font.PLAIN, 11));
	        date_ns.getEditor().setBorder(UIManager.getBorder("TextField.border"));
	        date_ns.getEditor().setBackground(Color.WHITE);
	        date_ns.getEditor().setAlignmentY(Component.BOTTOM_ALIGNMENT);
	        date_ns.getEditor().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	        combobox_ML = new javax.swing.JComboBox();
	        btn_gt = new javax.swing.JToggleButton();
	        btn_gt.setIcon(new ImageIcon(SinhVien_GUI.class.getResource("/Image/user_female_white_rb.png")));
//	        btn_gt.addChangeListener(new ChangeListener() {
//	        	public void stateChanged(ChangeEvent e) {
//	        		System.out.print("Hello");
//	        	}
//	        });
	        
	        btn_gt.addItemListener(new ItemListener() {
	        	public void itemStateChanged(ItemEvent e) {
	        		if ( e.getStateChange()== e.SELECTED){
	        			btn_gt.setIcon(new ImageIcon(SinhVien_GUI.class.getResource("/Image/user_male_olive_blue_black.png")));
	        		}
	        		if (e.getStateChange() == e.DESELECTED){
	        			btn_gt.setIcon(new ImageIcon(SinhVien_GUI.class.getResource("/Image/user_female_white_rb.png")));
	        			
	        		
	        			
	        		}
	        			
	        			
	        	}
	        });
	        bt_ref1 = new javax.swing.JButton();
	        bt_ref1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		loadtable(false);
//	        		 txt_masv.setText((String) table.getValueAt( selectedRow ,0));
//                     txt_ht.setText((String) table.getValueAt( selectedRow ,1));
//                     btn_gt.setSelected((boolean) table.getValueAt( selectedRow ,2));
//                     date_ns.setDate((Date) table.getValueAt( selectedRow ,3));
//                     txt_ns.setText((String) table.getValueAt( selectedRow ,4));
//                     combobox_MH.setSelectedItem((String) table.getValueAt( selectedRow ,5));
	        	}
	        });
	        
	        bt_ref1.setIcon(new ImageIcon(SinhVien_GUI.class.getResource("/Image/find.png")));

	        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
	        jPanel3.setLayout(jPanel3Layout);
	        jPanel3Layout.setHorizontalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );
	        jPanel3Layout.setVerticalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );

	        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

	        table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{null, null, null, null, null, null, null},
	        	},
	        	new String[] {
	        			"Mã Sinh Viên","Mã Lớp","Mã Học Kỳ","Mã Hệ","Họ Tên","Ngày Sinh","Quê","Giới Tính"
	        	}
	        ) {
	        	Class[] types = {
	            		String.class, String.class, String.class, String.class , String.class ,String.class,String.class,Boolean.class
	                };
	                
	                public Class getColumnClass(int columnIndex) {
	                    return types[columnIndex];
	                }
	            
	        });
	        table.setColumnSelectionAllowed(true);
	        jScrollPane1.setViewportView(table);
	        
	       
	        
	        ListSelectionModel row = table.getSelectionModel();
            row.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;
 
                    ListSelectionModel ls = (ListSelectionModel)e.getSource();
                    if (!ls.isSelectionEmpty()) {
                        int selectedRow = ls.getMinSelectionIndex();
                        txt_masv.setText((String) table.getValueAt( selectedRow ,0));
                        txt_ht.setText((String) table.getValueAt( selectedRow ,4));
                        btn_gt.setSelected((boolean) table.getValueAt( selectedRow ,7));
                        date_ns.setDate((Date) table.getValueAt( selectedRow ,5));
                        txt_que.setText((String) table.getValueAt( selectedRow ,6));
                        String malop = SVBUS.getdata_from_Relationship("Lop","tenlop","malop",(String) table.getValueAt( selectedRow ,1));
    				    String mahe = SVBUS.getdata_from_Relationship("HeDaotao","tenhe","mahe",(String) table.getValueAt( selectedRow ,3));
    				    String mahk = SVBUS.getdata_from_Relationship("hocki","tenhk","mahk",(String) table.getValueAt( selectedRow ,2));
                        System.out.println("Hello " + malop);
                        System.out.println("Hello " + mahe);
                        System.out.println("Hello " + mahk);
    				    
                        combobox_ML.setSelectedItem(malop);
                        comboBox_he.setSelectedItem(mahe);
                        comboBox_MHK.setSelectedItem(mahk);
                        
                        }
                        
                        
                        
                         
                    }
                }
            );

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2Layout.setHorizontalGroup(
	        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
	        			.addContainerGap())
	        );
	        jPanel2Layout.setVerticalGroup(
	        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jPanel2Layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
	        			.addContainerGap())
	        );
	        jPanel2.setLayout(jPanel2Layout);

	        jPanel4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

	        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
	        jPanel4Layout.setHorizontalGroup(
	        	jPanel4Layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(jPanel4Layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(bt_them, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(bt_sua, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(bt_luu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(bt_xoa, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(bt_ref, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(bt_ref1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        jPanel4Layout.setVerticalGroup(
	        	jPanel4Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jPanel4Layout.createSequentialGroup()
	        			.addComponent(bt_them, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(bt_xoa, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(bt_sua, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(bt_luu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(bt_ref, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
	        			.addGap(18)
	        			.addComponent(bt_ref1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(224, Short.MAX_VALUE))
	        );
	        jPanel4.setLayout(jPanel4Layout);

	        jPanel1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), " Th\u00F4ng Tin Sinh Vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, null));

	        Label_Masv.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
	        Label_Masv.setText("Mã Sinh Viên");

	        Label_Ten.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
	        Label_Ten.setText("Tên Sinh Viên");

	        Label_gt.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
	        Label_gt.setText("Giới Tính");

	        Label_ns.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
	        Label_ns.setText("Ngày Sinh");

	        lblQu.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
	        lblQu.setText("Quê");

	        lblMLp.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
	        lblMLp.setText("Lớp");
	        
	        comboBox_MHK = new JComboBox();
	        
	        JLabel lblMHcK = new JLabel();
	        lblMHcK.setText("Học Kỳ");
	        lblMHcK.setFont(new Font("Segoe UI", Font.PLAIN, 11));
	        
	        comboBox_he = new JComboBox();
	        
	        lblH = new JLabel();
	        lblH.setText("Hệ");
	        lblH.setFont(new Font("Segoe UI", Font.PLAIN, 11));
	        
	        checkBox_masv = new JCheckBox("");
	        
	         checkBox_tensv = new JCheckBox("");
	        
	        checkBox_gt = new JCheckBox("");
	        
	       checkBox_l = new JCheckBox("");
	        
	         checkBox_ns = new JCheckBox("");
	        
	        checkBox_q = new JCheckBox("");
	        
	        checkBox_he = new JCheckBox("");
	        
	        checkBox_hk = new JCheckBox("");

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1Layout.setHorizontalGroup(
	        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jPanel1Layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(Label_Ten)
	        				.addComponent(Label_Masv)
	        				.addComponent(Label_gt)
	        				.addComponent(lblMLp))
	        			.addGap(40)
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
	        				.addComponent(combobox_ML, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        				.addComponent(txt_masv, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
	        				.addComponent(txt_ht)
	        				.addComponent(btn_gt, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(checkBox_masv)
	        				.addComponent(checkBox_gt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(checkBox_l, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(checkBox_tensv, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
	        			.addGap(12)
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(lblMHcK, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(Label_ns)
	        				.addComponent(lblH)
	        				.addComponent(lblQu))
	        			.addGap(18)
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
	        						.addComponent(txt_que)
	        						.addComponent(date_ns, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
	        					.addPreferredGap(ComponentPlacement.UNRELATED)
	        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        						.addComponent(checkBox_ns, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(checkBox_q, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addComponent(comboBox_MHK, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
	        					.addPreferredGap(ComponentPlacement.UNRELATED)
	        					.addComponent(checkBox_hk, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addComponent(comboBox_he, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
	        					.addPreferredGap(ComponentPlacement.UNRELATED)
	        					.addComponent(checkBox_he, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
	        			.addGap(117))
	        );
	        jPanel1Layout.setVerticalGroup(
	        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jPanel1Layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
	        							.addComponent(Label_Masv)
	        							.addComponent(Label_ns)
	        							.addComponent(txt_masv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        							.addComponent(date_ns, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        						.addComponent(checkBox_ns, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
	        					.addGap(30)
	        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
	        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
	        							.addComponent(Label_Ten, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
	        							.addComponent(txt_ht, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        							.addComponent(txt_que, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        							.addComponent(lblQu, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
	        						.addComponent(checkBox_q, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addComponent(checkBox_masv)
	        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        					.addComponent(checkBox_tensv, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addGap(24)
	        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
	        						.addComponent(Label_gt)
	        						.addComponent(btn_gt))
	        					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addGap(32)
	        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
	        						.addComponent(comboBox_he, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(lblH, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
	        						.addComponent(checkBox_gt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(checkBox_he, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
	        					.addGap(18)))
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblMLp)
	        				.addComponent(combobox_ML, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(comboBox_MHK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(lblMHcK, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(checkBox_l, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(checkBox_hk, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
	        			.addContainerGap())
	        );
	        jPanel1.setLayout(jPanel1Layout);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(jPanel2, 0, 0, Short.MAX_VALUE)
	        				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        			.addGap(13))
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
	        					.addGap(16)
	        					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
	        				.addGroup(layout.createSequentialGroup()
	        					.addGap(19)
	        					.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)))
	        			.addContainerGap())
	        );
	        this.setLayout(layout);
	        bt_luu.putClientProperty(

					   "Quaqua.Button.style", "bevel"

					);
	        bt_them.putClientProperty(

					   "Quaqua.Button.style", "bevel"

					);
	        bt_sua.putClientProperty(

					   "Quaqua.Button.style", "bevel"

					);
	        bt_xoa.putClientProperty(

					   "Quaqua.Button.style", "bevel"

					);
	        bt_ref.putClientProperty(

					   "Quaqua.Button.style", "bevel"

					);
	        bt_ref1.putClientProperty(

					   "Quaqua.Button.style", "bevel"

					);
	        date_ns.putClientProperty(

	        		"terminateEditOnFocusLost", Boolean.TRUE

					);
	        
	    }
	 
	 public void loadtable(boolean check){
		 	String[] header = {"Mã Sinh Viên","Mã Lớp","Mã Học Kỳ","Mã Hệ","Họ Tên","Ngày Sinh","Quê","Giới Tính"};
		 
	        dtm = new DefaultTableModel(header,0){
	            Class[] types = {
	            		String.class, String.class, String.class, String.class , String.class ,String.class,String.class,Boolean.class
	                };
	                
	                public Class getColumnClass(int columnIndex) {
	                    return types[columnIndex];
	                }
	            };
	            
			ArrayList<SinhVien_DTO> arr = new ArrayList<SinhVien_DTO>();
			SVBUS = new SinhVien_BUS();
			if(check){
				arr = SVBUS.getdata();
			}
			else{
				String masv = txt_masv.getText();
				String hoten = txt_ht.getText();
				boolean gioitinh = btn_gt.isSelected();
				Date ngaysinh = date_ns.getDate();
				String que = txt_que.getText();
				String malop = SVBUS.getdata_from_Relationship("Lop","malop","tenlop",(String)combobox_ML.getSelectedItem());
				String mahe = SVBUS.getdata_from_Relationship("HeDaotao","mahe","tenhe",(String)comboBox_he.getSelectedItem());
				String mahk = SVBUS.getdata_from_Relationship("hocki","mahk","tenhk",(String)comboBox_MHK.getSelectedItem());

				SinhVien_DTO S = new SinhVien_DTO(masv,malop,mahe,mahk,hoten,gioitinh,ngaysinh,que);
				arr = SVBUS.Search(S);
				System.out.println("search =" + hoten);
			}
			
			SinhVien_DTO DMSVDTO = new SinhVien_DTO();
//			
			for(int i=0;i<arr.size();i++){
				DMSVDTO = arr.get(i);
				Object [] data = {DMSVDTO.getMasv(),DMSVDTO.getMalop(),
						DMSVDTO.getMaHK(),DMSVDTO.getMahe(),DMSVDTO.getHoten(),DMSVDTO.getNgaySinh(),DMSVDTO.getQue(),DMSVDTO.isGioitinh()};
				dtm.addRow(data);
			}
			table.setModel(dtm);
			
			
//			TableColumn C = table.getColumnModel().getColumn(4);
//			C.setCellEditor(new DefaultCellEditor(exp));
            
            
	 }
	 
	 public void loadcombobox(){
		 ArrayList<String> arr = new ArrayList<String>();
			exp = new JComboBox();
			SVBUS = new SinhVien_BUS();
			arr = SVBUS.getcombobox("Lop","tenlop");
			
			for(int i= 0 ;i < arr.size();i++){
				combobox_ML.addItem(arr.get(i));
				exp.addItem(arr.get(i));
			}
			combobox_ML.addItem("");
			
			arr = SVBUS.getcombobox("Hedaotao","tenhe");
			
			for(int i= 0 ;i < arr.size();i++){
				comboBox_he.addItem(arr.get(i));
				//exp.addItem(arr.get(i));
			}
			comboBox_he.addItem("");
			
			arr = SVBUS.getcombobox("Hocki","tenhk");
			
			for(int i= 0 ;i < arr.size();i++){
				comboBox_MHK.addItem(arr.get(i));
				//exp.addItem(arr.get(i));
			}
			comboBox_MHK.addItem("");
	 }
	 
	 public void lockbutton(boolean check){
		 bt_luu.setEnabled(!check);
		 bt_sua.setEnabled(check);
		 bt_them.setEnabled(check);
		 bt_xoa.setEnabled(check);
		
	 }
	 
	 public void Jcheckbox_setvisible(boolean state){
		 checkBox_masv.setVisible(state) ;
		 checkBox_tensv.setVisible(state) ;
		 checkBox_gt.setVisible(state) ;
		 checkBox_l.setVisible(state) ;
		 checkBox_ns.setVisible(state) ;
		 checkBox_q.setVisible(state) ;
		 checkBox_he.setVisible(state) ;
		 checkBox_hk.setVisible(state) ;
	 }
}
