package GUI;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import org.jdesktop.swingx.JXSearchField;

import BUS.ThongKe_BUS;
import BUS.ThongKe_BUS;
import DTO.ThongKe_DTO;
import General.Report;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import org.jdesktop.swingx.JXTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ThongKe_GUI extends JPanel {
	private ThongKe_BUS TKBUS;
	private DefaultTableModel dtm;
	private JTable table;
	private HashMap<String,String> Mapcombobox ;
	private JComboBox comboBox;
	private JToggleButton tglbtnNewToggleButton;
	private JXSearchField searchField;
	private boolean state;
	private String previous ="";
	/**
	 * Create the panel.
	 */
	public ThongKe_GUI() {

		init();
		TKBUS = new ThongKe_BUS();
		//loadtable();
	}

	public void init() {
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
						.addContainerGap())
				);

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 534, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
				);

		JButton bt_ref = new JButton("New button");
		bt_ref.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadtable();
			}
		});

		JButton bt_print = new JButton("New button");
		bt_print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Mapcombobox.get(comboBox.getSelectedItem()).equals("masv")){
					new Report().QueryReport(new ThongKe_DTO(previous), state);
				}
				else if(Mapcombobox.get(comboBox.getSelectedItem()).equals("mahk"))
				{
					new Report().QueryReport(new ThongKe_DTO("",previous), state);
				}
				else if(Mapcombobox.get(comboBox.getSelectedItem()).equals("malop")){
					new Report().QueryReport(new ThongKe_DTO("","",previous), state);
				}
				else{
					double diem = Double.parseDouble(previous);
					new Report().QueryReport(new ThongKe_DTO("","","",diem), state);
				}
			}
		});

		searchField = new JXSearchField();
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					previous = searchField.getText();
					if(Mapcombobox.get(comboBox.getSelectedItem()).equals("masv")){
						loadtable(new ThongKe_DTO(searchField.getText()),state);
					}
					else if(Mapcombobox.get(comboBox.getSelectedItem()).equals("mahk"))
					{
						
						loadtable(new ThongKe_DTO("",searchField.getText()),state);
					}
					else if(Mapcombobox.get(comboBox.getSelectedItem()).equals("malop")){
						loadtable(new ThongKe_DTO("","",searchField.getText()),state);
					}
					else{
						double diem = Double.parseDouble(searchField.getText());
						loadtable(new ThongKe_DTO("","","",diem),state);
					}
				}
			}
		});
		Mapcombobox = new  HashMap<String,String>();
		Mapcombobox.put("Mã Sinh Viên","masv");
		Mapcombobox.put("Mã Học Kì","mahk");
		Mapcombobox.put("Mã Lớp","malop");
		Mapcombobox.put("Điểm","diemtb");
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã Sinh Viên", "Mã Học Kì", "Mã Lớp", "Điểm"}));

		tglbtnNewToggleButton = new JToggleButton("");
		tglbtnNewToggleButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnNewToggleButton.isSelected()){
					state = true;
				}
				else{
					state = false;
				}
			}
		});

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap()
						.addComponent(bt_ref, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(bt_print, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(searchField, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tglbtnNewToggleButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGap(16))
				);
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addContainerGap(41, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(tglbtnNewToggleButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(bt_print, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(bt_ref, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
										.addContainerGap())
				);
		panel_2.setLayout(gl_panel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setAutoscrolls(true);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
				);

		table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"Mã Sinh Viên","Mã Học Kì","Mã Lớp","Điểm Trung Bình"
				}
				) {
			Class[] types = new Class [] {
					String.class, String.class,String.class,Double.class
			};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}
		});
		scrollPane.setViewportView(table);


		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}

	public void loadtable(){
		String[] header = {"Mã Sinh Viên","Mã Học Kì","Mã Lớp","Điểm Trung Bình"};

		dtm = new DefaultTableModel(header,0){
			Class[] types = {
					String.class, String.class,String.class,Double.class
			};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		};
		ArrayList<ThongKe_DTO> arr = new ArrayList<ThongKe_DTO>();

		arr = TKBUS.getdata();
		ThongKe_DTO L = new ThongKe_DTO();

		for(int i=0;i<arr.size();i++){
			L = arr.get(i);

			Object [] data = {L.getMasv(),L.getMaHK(),L.getMalop(),L.getDiemtb()};
			dtm.addRow(data);
		}
		table.setModel(dtm);

	}
	
	public void loadtable(ThongKe_DTO SV,boolean check){
		String[] header = {"Mã Sinh Viên","Mã Học Kì","Mã Lớp","Điểm Trung Bình"};

		dtm = new DefaultTableModel(header,0){
			Class[] types = {
					String.class, String.class,String.class,Double.class
			};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		};
		ArrayList<ThongKe_DTO> arr = new ArrayList<ThongKe_DTO>();
		arr = TKBUS.Search(SV, check);
		ThongKe_DTO L = new ThongKe_DTO();

		for(int i=0;i<arr.size();i++){
			L = arr.get(i);

			Object [] data = {L.getMasv(),L.getMaHK(),L.getMalop(),L.getDiemtb()};
			dtm.addRow(data);
		}
		table.setModel(dtm);

	}
	
}


