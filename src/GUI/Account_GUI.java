package GUI;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import org.jdesktop.swingx.JXFindBar;
import org.jdesktop.swingx.JXSearchField;
import org.jdesktop.swingx.JXMultiSplitPane;
import org.jdesktop.swingx.JXRadioGroup;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXLabel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.jdesktop.swingx.JXCollapsiblePane.Direction;
import org.jdesktop.swingx.JXTitledPanel;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.JXTitledSeparator;

import BUS.Account_BUS;
import BUS.DIEM_BUS;
import DTO.Account_DTO;
import DTO.DIEM_DTO;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class Account_GUI extends JPanel {
	
	private JTable table;
	private JTextField txtuser;
	private JTextField txtpass;
	private JCheckBox cboxDiem;
	
	private JCheckBox cboxhknghe;
	private JCheckBox cboxsv;
	private JCheckBox cboxmon;
	private JCheckBox cboxlop;
	private JCheckBox cboxall;
	private JButton bt_search;
	private JButton bt_luu2 ;
	private JButton bt_xoa;
	private JButton bt_sua;
	private JButton bt_them;
	private JButton bt_save ;
	private JButton bt_ref;
	JXSearchField searchField ;
	private DefaultTableModel dtm;
	Account_BUS ACCBUS;
	protected boolean state;
	int select = 0;
	int level = 0;
	int[] number;
	//private JComponent bt_save;
	/**
	 * Create the panel.
	 */
	public Account_GUI() {
		setBackground(Color.WHITE);
		
		init();
		ACCBUS = new Account_BUS();
		loadtable();
	}
	public void init() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		bt_ref = new JButton("");
		bt_ref.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lockbutton(true);
				loadtable();
			}
		});
		bt_ref.setIcon(new ImageIcon(Account_GUI.class.getResource("/Image/refresh.png")));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(522, Short.MAX_VALUE)
					.addComponent(bt_ref, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(bt_ref, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		searchField = new JXSearchField();
		searchField.getCancelButton().setBackground(Color.WHITE);
		searchField.getPopupButton().setBackground(Color.WHITE);
		searchField.getFindButton().setBackground(Color.WHITE);
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					JOptionPane.showMessageDialog(null,"Đã Xóa Thành Công");
			}
		});
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(341, Short.MAX_VALUE)
					.addComponent(searchField, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBackground(Color.WHITE);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
		);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{null, null, null},
				},
				new String[] {
						"Username","Password","Level"
				}
				) {
			Class[] types = {
					String.class, String.class, String.class
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
					txtuser.setText((String) table.getValueAt( selectedRow ,0));
					txtpass.setText((String)table.getValueAt( selectedRow ,1));
					cboxall.setSelected(false);
					level = number[selectedRow];
					if(level == 11111){
						cboxall.setSelected(true);
					}
					else
					{
					while(level > 0){
						if(level - 10000 > 0){
							level -=10000;
							cboxlop.setSelected(true);
							}
						else if(level - 1000 >= 0){
							level -= 1000;
							cboxmon.setSelected(true);
						}
						else if(level - 100 >= 0){
							cboxsv.setSelected(true);
							level -= 100;
						}
						else if(level - 10 >= 0){
							cboxhknghe.setSelected(true);
							level -= 10;
						}
						else if(level - 1 >= 0){
							cboxDiem.setSelected(true);
							level -= 1;
						}
					}
					}



				}
			}
		}
				);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "Ph\u1EA7n Quy\u1EC1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE))
		);
		
		cboxDiem = new JCheckBox("Qu\u1EA3n L\u00ED B\u1EA3ng \u0110i\u1EC3m");
		cboxDiem.setBackground(Color.WHITE);
		cboxDiem.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cboxDiem.isSelected())
					select += 1;
				else
					select -= 1;
				
			}
		});
		
		
		cboxhknghe = new JCheckBox("Qu\u1EA3n L\u00ED B\u1EA3ng H\u1ECDc K\u00EC ,Ng\u00E0nh,H\u1EC7");
		cboxhknghe.setBackground(Color.WHITE);
		cboxhknghe.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cboxhknghe.isSelected())
					select += 10;
				else
					select -= 10;
				
			}
		});
		cboxsv = new JCheckBox("Qu\u1EA3n L\u00ED B\u1EA3ng Sinh Vien");
		cboxsv.setBackground(Color.WHITE);
		cboxsv.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cboxsv.isSelected())
					select += 100;
				else
					select -= 100;
				
			}
		});
		cboxmon = new JCheckBox("Qu\u1EA3n L\u00ED B\u1EA3ng M\u00F4n H\u1ECDc");
		cboxmon.setBackground(Color.WHITE);
		cboxmon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(cboxmon.isSelected())
					select += 1000;
				else
					select -= 1000;
				
			}
		});
		cboxlop = new JCheckBox("Qu\u1EA3n L\u00ED B\u1EA3ng L\u1EDBp");
		cboxlop.setBackground(Color.WHITE);
		cboxlop.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cboxlop.isSelected())
					select += 10000;
				else
					select -= 10000;
				
			}
		});
		
		cboxall = new JCheckBox("L\u1EF1a Ch\u1ECDn T\u1EA5t C\u1EA3");
		cboxall.setBackground(Color.WHITE);
		cboxall.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cboxall.isSelected()){
					setSelectedCheckbox(true);
				}
				else{
					setSelectedCheckbox(false);
				}
			}

			
		});
		bt_search = new JButton("");
		bt_search.setIcon(new ImageIcon(Account_GUI.class.getResource("/Image/find.png")));
		
		bt_luu2 = new JButton("");
		bt_luu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtuser.getText();
				String pass = txtpass.getText();
				int setlevel = select;
			    Account_DTO DTO = new Account_DTO(user,pass,setlevel);
				ACCBUS.update(DTO);
				JOptionPane.showMessageDialog(null,"Cập nhật Thành Công");
				loadtable();
			}
		});
		bt_luu2.setIcon(new ImageIcon(Account_GUI.class.getResource("/Image/save.png")));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(cboxDiem)
						.addComponent(cboxlop)
						.addComponent(cboxsv)
						.addComponent(cboxall)
						.addComponent(cboxhknghe)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(cboxmon)
									.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(bt_search, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addComponent(bt_luu2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(cboxDiem)
					.addGap(12)
					.addComponent(cboxhknghe)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
							.addGap(18)
							.addComponent(cboxsv)
							.addGap(18)
							.addComponent(cboxmon)
							.addGap(18)
							.addComponent(cboxlop)
							.addGap(18)
							.addComponent(cboxall)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(bt_search, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bt_luu2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		bt_xoa = new JButton("");
		bt_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null,"Bạn Có Chắc Muốn Xóa Không","Thông Báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				
					String user = (String) table.getValueAt(table.getSelectedRow(),0);
					Account_DTO DTO = new Account_DTO(user,"");
					ACCBUS.delete(DTO);
					dtm.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null,"Đã Xóa Thành Công");
					
                }
			}
		});
		bt_xoa.setIcon(new ImageIcon(Account_GUI.class.getResource("/Image/remove_user.png")));
		
		bt_sua = new JButton("");
		bt_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = false;
				lockbutton(false);
			}
		});
		bt_sua.setIcon(new ImageIcon(Account_GUI.class.getResource("/Image/edit_user.png")));
		
		bt_save = new JButton("");
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lockbutton(false);
				String user = txtuser.getText();
				String pass = txtpass.getText();
				
			    Account_DTO DTO = new Account_DTO(user,pass,0);
				if (state){
					ACCBUS.insert(DTO);
				}
				else
				{
					ACCBUS.update(DTO);
				}
				JOptionPane.showMessageDialog(null,"Cập nhật Thành Công");
				loadtable();
			}
		});
		bt_save.setIcon(new ImageIcon(Account_GUI.class.getResource("/Image/save.png")));
		
		bt_them = new JButton("");
		bt_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = true;
				lockbutton(false);
				
			}
		});
		bt_them.setIcon(new ImageIcon(Account_GUI.class.getResource("/Image/add_user.png")));
		
		JLabel lblNewLabel = new JLabel("UserName");
		
		JLabel lblPassword = new JLabel("PassWord");
		
		txtuser = new JTextField();
		txtuser.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpass, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(bt_them, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(bt_sua, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
							.addComponent(bt_xoa, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(bt_save, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel)
						.addComponent(lblPassword)
						.addComponent(txtuser, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtuser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(lblPassword)
					.addGap(18)
					.addComponent(txtpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(bt_them, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(bt_save, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(bt_sua, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(bt_xoa, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		bt_luu2.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
		bt_them.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
		bt_xoa.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
		bt_ref.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
		bt_save.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
		bt_search.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
		bt_sua.putClientProperty(

				   "Quaqua.Button.style", "bevel"

				);
	
	}
	public void loadtable(){
	 	String[] header = {"Username","Password","Level"};
	 
        dtm = new DefaultTableModel(header,0){
            Class[] types = {
            		String.class, String.class,String.class
                };
                
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
            };
		ArrayList<Account_DTO> arr = new ArrayList<Account_DTO>();
		
		arr = ACCBUS.getdata();
		Account_DTO L = new Account_DTO();
		System.out.println(arr.size());
		number = new int[arr.size()];
		for(int i=0;i<arr.size();i++){
			L = arr.get(i);
			number[i] = L.getLevel();
			String Level = L.getLevel() == 0 ? "Normal" : (L.getLevel() == 11111 ? "Admin" : "SuperUser");
			Object [] data = {L.getUser(),L.getPass(),Level};
			dtm.addRow(data);
		}
		table.setModel(dtm);
		
 }
     public void lockbutton(boolean check){
	 bt_save.setEnabled(!check);
	 bt_sua.setEnabled(check);
	 bt_them.setEnabled(check);
	 bt_xoa.setEnabled(check);
	 
 }
     public void setSelectedCheckbox(boolean check) {
			cboxDiem.setSelected(check);
			cboxhknghe.setSelected(check);
			cboxlop.setSelected(check);
			cboxmon.setSelected(check);
			cboxsv.setSelected(check);
	}
     }
