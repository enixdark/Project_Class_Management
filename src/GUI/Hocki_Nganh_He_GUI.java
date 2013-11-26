package GUI;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import org.jdesktop.swingx.JXTextField;

import BUS.DIEM_BUS;
import BUS.Hedaotao_BUS;
import BUS.Hocki_BUS;
import BUS.Lop_BUS;
import BUS.Nganh_BUS;
import DTO.DIEM_DTO;
import DTO.Hedaotao_DTO;
import DTO.Hocki_DTO;
import DTO.Lop_DTO;
import DTO.Nganh_DTO;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.awt.Color;


public class Hocki_Nganh_He_GUI extends JPanel {
	enum BANG{
		HK,NG,HE,
	}
	public BANG Bang;
	private boolean state;
	private JTable table;
	private JRadioButton rdhe;
	
	private JRadioButton rdng ;
	private JLabel labeltxt1;
	
	private JXTextField txt1 ;
	
	private JLabel labeltxt2;
	
	private JXTextField txt2 ;
	
	private JButton bt_them ;
	
	
	private JButton bt_xoa;
	
	private JButton bt_sua;
	
	
	private JButton bt_ref ;
	private JButton bt_luu;
	
	private JButton bt_clean;
	private JLabel Labeltext ;
	private JRadioButton rdhk;
	private DefaultTableModel dtm;
	private Hocki_BUS HKBUS;
	private Hedaotao_BUS HEBUS;
	private Nganh_BUS NGBUS;

	/**
	 * Create the panel.
	 */
	public Hocki_Nganh_He_GUI() {
		setBackground(Color.WHITE);
		
		init();
		//loadtable();

	}
	public void init() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
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
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
					.addContainerGap())
		);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 219, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 244, Short.MAX_VALUE)
		);
		panel_4.setLayout(gl_panel_4);
		
		labeltxt1 = new JLabel("Label1");
		labeltxt1.setBackground(Color.WHITE);
		 txt1 = new JXTextField();
		labeltxt2 = new JLabel("Label1");
		labeltxt2.setBackground(Color.WHITE);
		 txt2 = new JXTextField();
		
		bt_them = new JButton("");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = true;
				lockbutton(false);
			}
		});
		bt_them.setIcon(new ImageIcon(Hocki_Nganh_He_GUI.class.getResource("/Image/plus_orange.png")));
		 bt_xoa = new JButton("");
		 bt_xoa.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if (JOptionPane.showConfirmDialog(null,"Bạn Có Chắc Muốn Xóa Không","Thông Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					Object DTO = null;
					String ma = (String) table.getValueAt(table.getSelectedRow(),0);
					switch(Bang){
					case HE:
						DTO = new Hedaotao_DTO(ma);
						break;
					case NG:
						DTO = new Nganh_DTO(ma);
					case HK:
						DTO = new Hocki_DTO(ma);
					}
					if(DTO instanceof Hedaotao_DTO)
						HEBUS.delete((Hedaotao_DTO)DTO);
					else if(DTO instanceof Nganh_DTO)
						NGBUS.delete((Nganh_DTO)DTO);
					else if(DTO instanceof Hocki_DTO)
						HKBUS.delete((Hocki_DTO)DTO);
					
					dtm.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null,"Đã Xóa Thành Công");
					
                }
		 	}
		 });
		bt_xoa.setIcon(new ImageIcon(Hocki_Nganh_He_GUI.class.getResource("/Image/deletered.png")));
		 bt_sua = new JButton("");
		 bt_sua.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		state = false;
				lockbutton(false);
		 	}
		 });
		bt_sua.setIcon(new ImageIcon(Hocki_Nganh_He_GUI.class.getResource("/Image/pencil3.png")));
		
		 bt_ref = new JButton("");
		 bt_ref.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		loadtable(Bang);
		 		lockbutton(true);
		 	}
		 });
		bt_ref.setIcon(new ImageIcon(Hocki_Nganh_He_GUI.class.getResource("/Image/refresh.png")));
		bt_clean = new JButton("");
		bt_clean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextClear();
			}
		});
		bt_clean.setIcon(new ImageIcon(Hocki_Nganh_He_GUI.class.getResource("/Image/edit_clear.png")));
		
		bt_luu = new JButton("");
		bt_luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object DTO = null;
				String t1 = txt1.getText();
				String t2 = txt2.getText();
				switch(Bang){
				case HE:
					DTO = new Hedaotao_DTO(t1,t2);
					break;
				case NG:
					DTO = new Nganh_DTO(t1,t2);
				case HK:
					DTO = new Hocki_DTO(t1,t2);
				}
				
				if (state){
					if(DTO instanceof Hedaotao_DTO)
						HEBUS.insert((Hedaotao_DTO)DTO);
					else if(DTO instanceof Nganh_DTO)
						NGBUS.insert((Nganh_DTO)DTO);
					else if(DTO instanceof Hocki_DTO)
						HKBUS.insert((Hocki_DTO)DTO);
				}
				else
				{
					if(DTO instanceof Hedaotao_DTO)
						HEBUS.update((Hedaotao_DTO)DTO);
					else if(DTO instanceof Nganh_DTO)
						NGBUS.update((Nganh_DTO)DTO);
					else if(DTO instanceof Hocki_DTO)
						HKBUS.update((Hocki_DTO)DTO);
				}
				JOptionPane.showMessageDialog(null,"Cập nhật Thành Công");
				loadtable(Bang);
				
			}
		});
		bt_luu.setIcon(new ImageIcon(Hocki_Nganh_He_GUI.class.getResource("/Image/save.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(txt2, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(txt1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(bt_them, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bt_xoa, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bt_sua, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bt_ref, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(bt_clean, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bt_luu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addComponent(labeltxt2, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(labeltxt1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(labeltxt1)
					.addGap(18)
					.addComponent(txt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(labeltxt2)
					.addGap(18)
					.addComponent(txt2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(bt_them, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(bt_xoa, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(bt_sua, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(bt_ref, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(bt_clean, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(bt_luu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{null, null},
				},
				new String[] {
						"Cột 1","Cột 2",
				}
				) {
			Class[] types = {
					String.class, String.class
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
                    txt1.setText((String)table.getValueAt( selectedRow ,0));
                    txt2.setText((String)table.getValueAt( selectedRow ,1));
                    }
                    
                    
                    
                     
                }
            }
        );
		panel_3.setLayout(gl_panel_3);
		
		rdhe = new JRadioButton("B\u1EA3ng H\u1EC7 \u0110\u00E0o T\u1EA1o");
		rdhe.setBackground(Color.WHITE);
		rdhe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bang = BANG.HE;
				labeltxt1.setText("Mã Hệ");
				labeltxt2.setText("Tên Hệ");
				Labeltext.setText("Hệ Đào Tạo");
				loadtable(Bang);
			}
		});
		
		rdng = new JRadioButton("B\u1EA3ng Ng\u00E0nh");
		rdng.setBackground(Color.WHITE);
		rdng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bang = BANG.NG;
				labeltxt1.setText("Mã Ngành");
				labeltxt2.setText("Tên Ngành");
				Labeltext.setText("Ngành Học");
				loadtable(Bang);
			}
		});
		
		Labeltext = new JLabel("H\u1ECDc K\u1EF3");
		Labeltext.setBackground(Color.WHITE);
		Labeltext.setHorizontalTextPosition(SwingConstants.LEFT);
		Labeltext.setOpaque(true);
		Labeltext.setHorizontalAlignment(SwingConstants.LEFT);
		Labeltext.setFont(new Font("Tahoma", Font.PLAIN, 31));
		
		rdhk = new JRadioButton("B\u1EA3ng H\u1ECDc K\u1EF3");
		rdhk.setBackground(Color.WHITE);
		rdhk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bang = BANG.HK;
				labeltxt1.setText("Mã Học Kì");
				labeltxt2.setText("Tên Học Kỳ");
				Labeltext.setText("Học Kì");
				loadtable(Bang);
				//loadtable();
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(rdhk);
		group.add(rdng);
		group.add(rdhe);
		rdhk.setSelected(true);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(Labeltext, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
					.addComponent(rdhk, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdhe, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdng, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(Labeltext, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(rdhk)
									.addComponent(rdhe))
								.addComponent(rdng))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
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
  
	
	}
	
	public void loadtable(BANG bang){
		List<String[]> header = new ArrayList<String[]>();
		if(bang == BANG.HK){
			header.add(new String[]{"Mã Hoc Kì","Tên Hoc Kì"});
		}
		if(bang == BANG.HE){
			header.add(new String[]{"Mã Hệ","Tên Hệ"});
		}
		if(bang == BANG.NG){
			header.add(new String[]{"Mã Ngành","Tên Ngành"});
		}
		String[] s = header.get(0);
//		String[] cot = {"Mã Ngành","Tên Ngành"};
        dtm = new DefaultTableModel(s,0){
        	
            Class[] types = {
            		String.class, String.class
                };
                
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
        };
		setdefaulttable(bang);
		
 }
	public void setdefaulttable(BANG bang) {
		
		switch(bang){
			case HK:
				ArrayList<Hocki_DTO> arr = new ArrayList<Hocki_DTO>();
				HKBUS = new Hocki_BUS();
				arr = HKBUS.getdata();
				Hocki_DTO L = new Hocki_DTO();
				for(int i=0;i<arr.size();i++){
					L = arr.get(i);
					
					Object [] data = {L.getMaHK(),L.getTenHK()};
					dtm.addRow(data);
				}
				
				break;
			case HE:
				ArrayList<Hedaotao_DTO> arr1 = new ArrayList<Hedaotao_DTO>();
				HEBUS = new Hedaotao_BUS();
				arr1 = HEBUS.getdata();
				Hedaotao_DTO L1 = new Hedaotao_DTO();
				for(int i=0;i<arr1.size();i++){
					L1 = arr1.get(i);
					
					Object [] data = {L1.getMahe(),L1.getTenhe()};
					dtm.addRow(data);
				}
				break;
			case NG:
				ArrayList<Nganh_DTO> arr11 = new ArrayList<Nganh_DTO>();
				NGBUS = new Nganh_BUS();
				arr11 = NGBUS.getdata();
				Nganh_DTO N = new Nganh_DTO();
				for(int i=0;i<arr11.size();i++){
					N = arr11.get(i);
					
					Object [] data = {N.getMaNg(),N.getTenNg()};
					dtm.addRow(data);
				}
				break;
			
		}
		table.setModel(dtm);
		
	}
	
	public void TextClear(){
		txt1.setText("");
		txt2.setText("");
	}
	
	public void lockbutton(boolean check){
		bt_luu.setEnabled(!check);
		bt_sua.setEnabled(check);
		bt_them.setEnabled(check);
		bt_xoa.setEnabled(check);

	}
}
