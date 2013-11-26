package GUI;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import BUS.DIEM_BUS;
import BUS.MonHoc_BUS;
import DTO.DIEM_DTO;
import DTO.MonHoc_DTO;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
public class MonHoc_GUI extends JPanel {

	/**
	 * Create the panel.
	 */
	private javax.swing.JButton bt_ref;
	private javax.swing.JButton bt_xoa;
	private JButton bt_luu;
	private JButton bt_sua;
	private JSpinner spinner;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JToolBar jToolBar1;
	private DefaultTableModel dtm;
	private JButton bt_them;
	private MonHoc_BUS DMMH;
	private String t1,t2;
	private int t3;
	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private boolean state;
	private JLabel lblMNgnh;
	private JComboBox comboBox;
	public MonHoc_GUI() {
		setBackground(Color.WHITE);
		init();
		loadtable();
		lockbutton(true);
	}
	public void init(){
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jTable1.setFillsViewportHeight(true);
		jTable1.setBackground(Color.WHITE);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"Mã Môn Học", "Tên Môn Học", "Số Tín Chỉ","Học Kì"
				}
				) {
			Class[] types = new Class [] {
					String.class, String.class, Integer.class,String.class
			};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}
		});
		jScrollPane1.setViewportView(jTable1);
		ListSelectionModel row = jTable1.getSelectionModel();
		row.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//Ignore extra messages.
				if (e.getValueIsAdjusting()) return;

				ListSelectionModel ls = (ListSelectionModel)e.getSource();
				if (!ls.isSelectionEmpty()) {
					int selectedRow = ls.getMinSelectionIndex();
					textField.setText((String) jTable1.getValueAt( selectedRow ,0));
					textField_1.setText((String) jTable1.getValueAt( selectedRow ,1));
					textField_2.setText((String)jTable1.getValueAt( selectedRow ,3));
					spinner.setValue((int)jTable1.getValueAt( selectedRow ,2));
					//comboBox.setSelectedItem((String)jTable1.getValueAt( selectedRow ,4));
				}




			}
		}
				);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(12)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 711, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 797, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		jToolBar1 = new javax.swing.JToolBar();
		jToolBar1.setBounds(10, 11, 43, 363);
		jToolBar1.setAlignmentY(Component.CENTER_ALIGNMENT);
		jToolBar1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		jToolBar1.setBackground(Color.WHITE);
		jToolBar1.setBorder(new CompoundBorder());
		jToolBar1.setFloatable(false);
		bt_them = new javax.swing.JButton();
		bt_them.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bt_them.setBackground(Color.WHITE);
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = true;
				lockbutton(false);
			}
		});
		bt_them.setIcon(new ImageIcon(GUI.MonHoc_GUI.class.getResource("/Image/plus_orange.png")));
		bt_xoa = new javax.swing.JButton();
		bt_xoa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bt_xoa.setBackground(Color.WHITE);
		bt_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Bạn Có Chắc Muốn Xóa Không","Thông Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					DMMH  = new MonHoc_BUS  ();
					String mamm = (String) jTable1.getValueAt(jTable1.getSelectedRow(),0);
					MonHoc_DTO S = new MonHoc_DTO();
					S.setMaMon(mamm);
					//System.out.println(S.getMaMon() + " " + mamm);
					DMMH.delete(S);
					dtm.removeRow(jTable1.getSelectedRow());
					JOptionPane.showMessageDialog(null,"Da Xoa thanh Cong");

				}
			}
		});
		bt_xoa.setIcon(new ImageIcon(GUI.MonHoc_GUI.class.getResource("/Image/deletered.png")));
		bt_sua = new javax.swing.JButton();
		bt_sua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bt_sua.setBackground(Color.WHITE);
		bt_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state = false;
				lockbutton(false);

			}
		});

		bt_sua.setIcon(new ImageIcon(GUI.MonHoc_GUI.class.getResource("/Image/pencil3.png")));
		bt_ref = new javax.swing.JButton();
		bt_ref.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bt_ref.setBackground(Color.WHITE);
		bt_ref.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lockbutton(true);
				loadtable();
			}
		});
		bt_ref.setIcon(new ImageIcon(GUI.MonHoc_GUI.class.getResource("/Image/refresh.png")));

		jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
		jToolBar1.setRollover(true);

		bt_them.setFocusable(false);
		bt_them.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		bt_them.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(bt_them);

		bt_xoa.setFocusable(false);
		bt_xoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		bt_xoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(bt_xoa);

		bt_sua.setFocusable(false);
		bt_sua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		bt_sua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(bt_sua);

		bt_luu = new JButton();
		bt_luu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bt_luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DMMH = new MonHoc_BUS();

				String mamon = textField.getText();
				String tenmon = textField_1.getText();
				int tc = (int) spinner.getValue();
				String HK = textField_2.getText();
				String mang = "CNTT";



				MonHoc_DTO S = new MonHoc_DTO(mamon,tenmon,tc,HK,mang);
				if (state){
					DMMH.insert(S);
				}
				else
				{
					DMMH.update(S);
				}
				JOptionPane.showMessageDialog(null,"Cập nhật Thành Công");
				loadtable();
			}
		});
		bt_luu.setIcon(new ImageIcon(GUI.MonHoc_GUI.class.getResource("/Image/save.png")));
		bt_luu.setVerticalTextPosition(SwingConstants.BOTTOM);
		bt_luu.setHorizontalTextPosition(SwingConstants.CENTER);
		bt_luu.setFocusable(false);
		bt_luu.setBackground(Color.WHITE);
		jToolBar1.add(bt_luu);

		bt_ref.setFocusable(false);
		bt_ref.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		bt_ref.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(bt_ref);


		panel_2.setLayout(null);
		panel_2.add(jToolBar1);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(82, Short.MAX_VALUE))
				);

		JLabel lblNewLabel = new JLabel("M\u00E3 M\u00F4n H\u1ECDc ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblNewLabel_1 = new JLabel("T\u00EAn M\u00F4n H\u1ECDc");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblSTnCh = new JLabel("S\u00F3 T\u00EDn Ch\u1EC9");
		lblSTnCh.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblNewLabel_2 = new JLabel("M\u00E3 H\u1ECDc K\u00EC");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));

		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_2.setColumns(10);

		lblMNgnh = new JLabel("M\u00E3 Ng\u00E0nh");
		lblMNgnh.setFont(new Font("Tahoma", Font.PLAIN, 11));

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblSTnCh, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
														.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_2))
														.addGap(55)
														.addComponent(lblMNgnh, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
														.addContainerGap(21, Short.MAX_VALUE))
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(20)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblSTnCh)
												.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblMNgnh)
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(38)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblNewLabel_2)
														.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
														.addGroup(gl_panel_1.createSequentialGroup()
																.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblNewLabel)
																		.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																		.addGap(38)
																		.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
																				.addComponent(lblNewLabel_1)
																				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
																				.addContainerGap(48, Short.MAX_VALUE))
				);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
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
		jToolBar1.putClientProperty("Quaqua.ToolBar.style","plain");

	}
	public void loadtable(){
		String[] header = {"Mã Môn","Tên Môn","Số Tín Chỉ","Mã Học Kì"};

		dtm = new DefaultTableModel(header,0){
			Class[] types = {
					String.class, String.class,Integer.class,String.class
			};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		};
		ArrayList<MonHoc_DTO> arr = new ArrayList<MonHoc_DTO>();
		DMMH = new MonHoc_BUS();
		arr = DMMH.getdata();
		MonHoc_DTO DM = new MonHoc_DTO();
		System.out.println(arr.size());
		for(int i=0;i<arr.size();i++){

			DM = arr.get(i);
			Object [] data = {DM.getMaMon(),DM.getTenMon(),DM.getSotinchi(),DM.getMaHK()};
			dtm.addRow(data);
		}
		jTable1.setModel(dtm);

	}
	public void lockbutton(boolean check){
		bt_luu.setEnabled(!check);
		bt_sua.setEnabled(check);
		bt_them.setEnabled(check);
		bt_xoa.setEnabled(check);

	}
}
