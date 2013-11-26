package GUI;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingx.JXSearchField;

import BUS.DIEM_BUS;
import DTO.DIEM_DTO;
import DTO.SinhVien_DTO;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;

public class ViewDiem_GUI extends JPanel {
	private JTable table;
	private DefaultTableModel dtm;
	private DIEM_BUS DIEMBUS;
	private JXSearchField searchField;

	/**
	 * Create the panel.
	 */
	public ViewDiem_GUI() {
		setBackground(Color.WHITE);
		DIEMBUS = new DIEM_BUS();
		
		init();

	}
	public void init() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 806, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 805, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(54)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		
	 searchField = new JXSearchField();
	 searchField.getFindButton().setBackground(Color.WHITE);
	 searchField.getCancelButton().setBackground(Color.WHITE);
	 searchField.getPopupButton().setBackground(Color.WHITE);
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					loadtable();
					
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(324, Short.MAX_VALUE)
					.addComponent(searchField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(306))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
	public void loadtable(){
		String[] header = {
				"Mã Môn","Điểm Quá Trình","Điểm Thi Lần 1","Điểm Thi Lần 2","Điểm Trung Bình"};

		dtm = new  DefaultTableModel(header,0){
			
			Class[] types = {
					String.class, Double.class, Double.class , Double.class ,Double.class
			};

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		};

		String masv = searchField.getText();
		
		ArrayList<DIEM_DTO> arr = new ArrayList<DIEM_DTO>();
		DIEM_DTO S = new DIEM_DTO(masv,"","");
		arr = DIEMBUS.Search(S);


		DIEM_DTO DS = new DIEM_DTO();
			
		for(int i=0;i<arr.size();i++){
			DS = arr.get(i);
			Object [] data = {DS.getMaMon(),DS.getDiemqt(),DS.getDiemthi1(),DS.getDiemthi2(),DS.getDiemtb()};
			dtm.addRow(data);
		}
		table.setModel(dtm);


	}
}
