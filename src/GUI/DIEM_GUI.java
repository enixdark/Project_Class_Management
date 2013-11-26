package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.ComponentOrientation;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import org.jdesktop.swingx.JXMultiThumbSlider;
import org.jdesktop.swingx.JXBusyLabel;
import javax.swing.JComboBox;
import org.jdesktop.swingx.JXSearchField;

import BUS.DIEM_BUS;
import BUS.Hocki_BUS;
import BUS.MonHoc_BUS;
import BUS.SinhVien_BUS;
import DTO.DIEM_DTO;
import DTO.DIEM_DTO;
import DTO.Hocki_DTO;
import DTO.MonHoc_DTO;
import DTO.SinhVien_DTO;

import javax.swing.JSpinner;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DIEM_GUI extends JPanel {
	private boolean state;
	private Map<String,String> Data = new HashMap<String,String>();

	private JTable table;
	private JTextField txt_masv;
	private JPanel panel_tool ;

	private JPanel panel_table ;
	private JPanel panel_1;
	private JPanel panel_diem ;

	private JLabel lblNewLabel_1 ;
	private JLabel lblimQuTrnh ;
	private JSpinner spinner_dqt ;
	private JLabel lblimThiLn ;
	private JSpinner spinner_dt1 ;
	private JLabel lblimThiLn_1 ;
	private JSpinner spinner_dt2 ;
	private JList list_ng ;
	private DefaultListModel DFlist_ng;
	private JList list_mon ;
	private DefaultListModel DFlist_mon;
	private JList list_hk;
	private DefaultListModel DFlist_hk;
	private DefaultTableModel dtm ;
	private JComboBox comboBox_nam;
	private JButton bt_them;
	private JButton bt_sua;
	private JButton bt_xoa;
	private JButton bt_luu;
	private JButton bt_search;
	private JButton bt_ref;
	private DIEM_BUS DIEMBUS;
	private DIEM_DTO ĐIEMTO;
	/**
	 * Create the panel.
	 */
	public DIEM_GUI() {
		setBackground(Color.WHITE);

		init();
		loadtable(true);
		lockbutton(true);
	}

	public void init() {
		panel_tool = new JPanel();
		panel_tool.setBackground(Color.WHITE);

		panel_table = new JPanel();
		panel_table.setBackground(Color.WHITE);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel_table, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_tool, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_table, GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_tool, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(1))
				);

		panel_diem = new JPanel();
		panel_diem.setBackground(Color.WHITE);
		panel_diem.setBorder(new TitledBorder(null, "Qu\u1EA3n L\u00ED \u0110i\u1EC3m", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		lblNewLabel_1 = new JLabel("M\u00E3 Sinh Vi\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));

		txt_masv = new JTextField();
		txt_masv.setColumns(10);

		lblimQuTrnh = new JLabel("\u0110i\u1EC3m Qu\u00E1 Tr\u00ECnh");
		lblimQuTrnh.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SpinnerNumberModel num1 = new SpinnerNumberModel(0,0,10,.1);
		spinner_dqt = new JSpinner(num1);
		
		lblimThiLn = new JLabel("\u0110i\u1EC3m Thi L\u1EA7n 1");
		lblimThiLn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SpinnerNumberModel num2 = new SpinnerNumberModel(0,0,10,.1);
		spinner_dt1 = new JSpinner(num2);

		lblimThiLn_1 = new JLabel("\u0110i\u1EC3m Thi L\u1EA7n 2");
		lblimThiLn_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 SpinnerNumberModel num3 = new SpinnerNumberModel(0,0,10,.1);
		spinner_dt2 = new JSpinner(num3) ;
		GroupLayout gl_panel_diem = new GroupLayout(panel_diem);
		gl_panel_diem.setHorizontalGroup(
				gl_panel_diem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_diem.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_diem.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_diem.createSequentialGroup()
										.addComponent(lblimThiLn, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
										.addComponent(spinner_dt1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_diem.createSequentialGroup()
												.addComponent(lblimThiLn_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
												.addComponent(spinner_dt2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel_diem.createSequentialGroup()
														.addGroup(gl_panel_diem.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_panel_diem.createSequentialGroup()
																		.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
																		.addPreferredGap(ComponentPlacement.RELATED))
																		.addGroup(gl_panel_diem.createSequentialGroup()
																				.addComponent(lblimQuTrnh, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
																				.addGap(3)))
																				.addGroup(gl_panel_diem.createParallelGroup(Alignment.LEADING, false)
																						.addComponent(spinner_dqt)
																						.addComponent(txt_masv, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))))
																						.addContainerGap())
				);
		gl_panel_diem.setVerticalGroup(
				gl_panel_diem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_diem.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_diem.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txt_masv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_diem.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblimQuTrnh)
										.addComponent(spinner_dqt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel_diem.createParallelGroup(Alignment.BASELINE)
												.addComponent(spinner_dt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblimThiLn))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panel_diem.createParallelGroup(Alignment.BASELINE)
														.addComponent(spinner_dt2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblimThiLn_1))
														.addGap(72))
				);
		panel_diem.setLayout(gl_panel_diem);

		JPanel panel_group = new JPanel();
		panel_group.setBackground(Color.WHITE);
		panel_group.setBorder(new TitledBorder(null, "Th\u00F4ng Tin", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JLabel lblNewLabel = new JLabel("Ng\u00E0nh");
		//		DefaultListModel<String> list_nganh = new DefaultListModel<String>();
		//		//String[] list ;
		//		ArrayList<MonHoc_DTO> array = new ArrayList<MonHoc_DTO>();
		//		array = (new MonHoc_BUS()).getdata();
		//		list.addElement("ALL");
		//		for(MonHoc_DTO i : array){
		//			//System.out.println("Ping" + i.getTenMon());
		//			list.addElement(i.getTenMon());
		//		}

		list_ng = new JList();

		list_ng.setBorder(UIManager.getBorder("ComboBox.border"));
		list_ng.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(list_ng.getSelectedValue());
			}
		});
		//		list_ng.setModel(new AbstractListModel() {
		//			String[] values = new String[] {};
		//			public int getSize() {
		//				return values.length;
		//			}
		//			public Object getElementAt(int index) {
		//				return values[index];
		//			}
		//		});
		list_ng.setValueIsAdjusting(true);
		list_ng.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblMn = new JLabel("M\u00F4n");
		DefaultListModel<String> dflist_mon = new DefaultListModel<String>();
		//String[] list ;
		ArrayList<MonHoc_DTO> array = new ArrayList<MonHoc_DTO>();
		array = (new MonHoc_BUS()).getdata();
		
		dflist_mon.addElement("ALL");
		for(MonHoc_DTO i : array){
			//System.out.println("Ping" + i.getTenMon());
			dflist_mon.addElement(i.getTenMon());
			Data.put(i.getTenMon(),i.getMaMon());
		}
		
		list_mon = new JList(dflist_mon);
		
		list_mon.setBorder(UIManager.getBorder("ComboBox.border"));
		list_mon.setBackground(Color.WHITE);
		list_mon.setValueIsAdjusting(true);
		list_mon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblNm = new JLabel("N\u0103m");

		comboBox_nam = new JComboBox();

		int time = Calendar.getInstance().get(Calendar.YEAR);
		comboBox_nam.addItem("");
		for(int i = 1992;i <= time;i++)
			comboBox_nam.addItem(i);

		DefaultListModel<String> dflist_hk = new DefaultListModel<String>();
		ArrayList<Hocki_DTO> array1 = new ArrayList<Hocki_DTO>();
		array1 = (new Hocki_BUS()).getdata();

		dflist_hk.addElement("ALL");
		for(Hocki_DTO i : array1){
			//System.out.println("Ping" + i.getTenMon());
			dflist_hk.addElement(i.getTenHK());
			Data.put(i.getTenHK(),i.getMaHK());
		}
		list_hk = new JList(dflist_hk);
		list_hk.setBorder(UIManager.getBorder("ComboBox.border"));
		list_hk.setValueIsAdjusting(true);
		list_hk.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblHcK = new JLabel("H\u1ECDc K\u1EF3");
		GroupLayout gl_panel_group = new GroupLayout(panel_group);
		gl_panel_group.setHorizontalGroup(
				gl_panel_group.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_group.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_group.createParallelGroup(Alignment.LEADING)
								.addComponent(list_ng, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_panel_group.createSequentialGroup()
										.addComponent(lblHcK, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
										.addGap(10)
										.addComponent(list_hk, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, gl_panel_group.createSequentialGroup()
												.addComponent(lblNm)
												.addGap(10)
												.addComponent(comboBox_nam, 0, 136, Short.MAX_VALUE))
												.addComponent(lblMn)
												.addComponent(lblNewLabel)
												.addComponent(list_mon, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
												.addContainerGap())
				);
		gl_panel_group.setVerticalGroup(
				gl_panel_group.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_group.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(list_ng, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblMn)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(list_mon, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_group.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_nam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNm))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_group.createParallelGroup(Alignment.BASELINE)
										.addComponent(list_hk, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHcK))
										.addContainerGap())
				);
		panel_group.setLayout(gl_panel_group);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_group, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
				.addComponent(panel_diem, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
						.addComponent(panel_group, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_diem, GroupLayout.PREFERRED_SIZE, 201, Short.MAX_VALUE))
				);
		panel_1.setLayout(gl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_table = new GroupLayout(panel_table);
		gl_panel_table.setHorizontalGroup(
				gl_panel_table.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
				);
		gl_panel_table.setVerticalGroup(
				gl_panel_table.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_table.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{null, null, null, null, null, null},
				},
				new String[] {
						"Mã Sinh Viên","Mã Môn","Điểm Quá Trình","Điểm Thi Lần 1","Điểm Thi Lần 2","Điểm Trung Bình"
				}
				) {
			Class[] types = {
					String.class, String.class, Double.class, Double.class , Double.class ,Double.class
			};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

		});
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table); 
		
		ListSelectionModel row = table.getSelectionModel();
        row.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //Ignore extra messages.
                if (e.getValueIsAdjusting()) return;

                ListSelectionModel ls = (ListSelectionModel)e.getSource();
                if (!ls.isSelectionEmpty()) {
                    int selectedRow = ls.getMinSelectionIndex();
                    txt_masv.setText((String) table.getValueAt( selectedRow ,0));
                    spinner_dqt.setValue((double)table.getValueAt( selectedRow ,2));
                    spinner_dt1.setValue((double)table.getValueAt( selectedRow ,3));
                    spinner_dt2.setValue((double)table.getValueAt( selectedRow ,4));
                    //comboBox_nam.setSelectedItem((String)table.getValueAt( selectedRow ,6));
                    for (Entry<String, String> entry : Data.entrySet()) {
                        if (entry.getValue().equals((String)table.getValueAt( selectedRow ,1))) {
                            list_mon.setSelectedValue(entry.getKey(), true);
                        }
                    }
                    }
                    
                    
                    
                     
                }
            }
        );
		
		panel_table.setLayout(gl_panel_table);
		GridBagLayout gbl_panel_tool = new GridBagLayout();
		gbl_panel_tool.columnWidths = new int[]{331, 190, 0, 0};
		gbl_panel_tool.rowHeights = new int[]{41, 0};
		gbl_panel_tool.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_tool.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_tool.setLayout(gbl_panel_tool);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.WHITE);
		toolBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		toolBar.setFocusTraversalPolicyProvider(true);
		toolBar.setFocusCycleRoot(true);
		toolBar.setFloatable(false);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 0, 5);
		gbc_toolBar.gridx = 1;
		gbc_toolBar.gridy = 0;
		panel_tool.add(toolBar, gbc_toolBar);
		toolBar.setRollover(true);

		bt_them = new JButton("");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lockbutton(false);
				state = true;
			}
		});
		bt_them.setBackground(Color.WHITE);
		bt_them.setIcon(new ImageIcon(DIEM_GUI.class.getResource("/Image/plus_orange.png")));
		toolBar.add(bt_them);

		bt_xoa = new JButton("");
		bt_xoa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (JOptionPane.showConfirmDialog(null,"Bạn Có Chắc Muốn Xóa Không","Thông Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					DIEMBUS  = new DIEM_BUS();
					String masv = (String) table.getValueAt(table.getSelectedRow(),0);
					DIEM_DTO S = new DIEM_DTO(masv);
					DIEMBUS.delete(S);
					dtm.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null,"Đã Xóa Thành Công");
					
                }
        		
        	}
        });
		bt_xoa.setBackground(Color.WHITE);
		bt_xoa.setIcon(new ImageIcon(DIEM_GUI.class.getResource("/Image/deletered.png")));
		toolBar.add(bt_xoa);

		bt_sua = new JButton("");
		bt_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lockbutton(false);
				state = false;
			}
		});
		bt_sua.setBackground(Color.WHITE);
		bt_sua.setIcon(new ImageIcon(DIEM_GUI.class.getResource("/Image/pencil3.png")));
		toolBar.add(bt_sua);

		bt_luu = new JButton("");
		bt_luu.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		lockbutton(false);
	        		DIEMBUS = new DIEM_BUS();
					String masv = txt_masv.getText();
					String mamon = Data.get((String) list_mon.getSelectedValue()).toString();
					int nam = (int)comboBox_nam.getSelectedItem();
					double diemqt = (double) spinner_dqt.getValue();
					double diemthi1 = (double) spinner_dt1.getValue();
					double diemthi2 = (double) spinner_dt2.getValue();
					String mahk = Data.get((String) list_hk.getSelectedValue()).toString(); 
				   

				    System.out.print(masv + mamon + mahk + diemqt + diemthi1 + diemthi2 + nam);
				    DIEM_DTO S = new DIEM_DTO(masv,mamon,mahk,diemqt,diemthi1,diemthi2,nam);
					if (state){
						DIEMBUS.insert(S);
					}
					else
					{
						DIEMBUS.update(S);
					}
					JOptionPane.showMessageDialog(null,"Cập nhật Thành Công");
					loadtable(true);
	        	}
	        });
		bt_luu.setBackground(Color.WHITE);
		bt_luu.setIcon(new ImageIcon(DIEM_GUI.class.getResource("/Image/save.png")));
		toolBar.add(bt_luu);

		bt_ref = new JButton("");
		bt_ref.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lockbutton(true);
				loadtable(true);
			}
		});
		bt_ref.setBackground(Color.WHITE);
		bt_ref.setIcon(new ImageIcon(DIEM_GUI.class.getResource("/Image/refresh.png")));
		toolBar.add(bt_ref);

		bt_search = new JButton("");
		bt_search.setBackground(Color.WHITE);
		bt_search.setIcon(new ImageIcon(DIEM_GUI.class.getResource("/Image/find.png")));
		toolBar.add(bt_search);
		setLayout(groupLayout);
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
     bt_search.putClientProperty(

			   "Quaqua.Button.style", "bevel"

			);
	}

	//	public DefaultListModel LoadList(String Table,String Column){
	//		DefaultListModel list = new DefaultListModel();
	//		DIEMBUS = new DIEM_BUS();
	//		ArrayList<String> arr = 
	//	}
	public void loadtable(boolean check){
		String[] header = {
				"Mã Sinh Viên","Mã Môn","Điểm Quá Trình","Điểm Thi Lần 1","Điểm Thi Lần 2","Điểm Trung Bình"};

		dtm = new  DefaultTableModel(header,0){

			Class[] types = {
					String.class, String.class, Double.class, Double.class , Double.class ,Double.class
			};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		};

		ArrayList<DIEM_DTO> arr = new ArrayList<DIEM_DTO>();
		DIEMBUS = new DIEM_BUS();
		if(check){
			arr = DIEMBUS.getdata();
		}


		DIEM_DTO DS = new DIEM_DTO();
		//		
		for(int i=0;i<arr.size();i++){
			DS = arr.get(i);
			Object [] data = {DS.getMasv(),DS.getMaMon(),DS.getDiemqt(),DS.getDiemthi1(),DS.getDiemthi2(),DS.getDiemtb()};
			dtm.addRow(data);
		}
		table.setModel(dtm);


	}
	public void lockbutton(boolean check){
		bt_luu.setEnabled(!check);
		bt_sua.setEnabled(check);
		bt_them.setEnabled(check);
		bt_xoa.setEnabled(check);

	}
}
