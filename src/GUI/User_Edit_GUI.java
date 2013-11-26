package GUI;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import net.sf.jasperreports.engine.export.draw.ImageDrawer;

import BUS.Account_BUS;
import BUS.SinhVien_BUS;
import DTO.Account_DTO;
import DTO.Hedaotao_DTO;
import DTO.Lop_DTO;
import DTO.SinhVien_DTO;
import GUI_LOGIN.USER_Forms;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class User_Edit_GUI extends JPanel {
	private String user;
	private JTextField txt_browser;
	private JPasswordField txtoldpass;
	private JPasswordField txtnewpass;
	private JPasswordField txtconfirm;
	private JLabel img ;
	private JButton bt_browser;
	private JButton bt_luu;
	private JButton bt_luu2;
	private JButton bt_clear;
	private JLabel lblTn ;
	private JLabel lblMSinhVin;
	private JLabel lblGt;
	private JLabel lblLp;
	private JLabel lblH;
	private JLabel lblNewLabel_2;
	private JLabel lblMtKhuMi;
	private JLabel lblXcNhnMt;
	private JFileChooser choose;
	private Account_BUS ACCBUS;
	private JLabel lblMesconfirm;
	private JLabel lblConfirm;
	private JLabel lblMesoldpasss;
	private JLabel lbten;
	
	private JLabel lbmasv;
	
	private JLabel lbgioitinh ;
	
	private JLabel lblop;
	
	private USER_Forms USER;
	/**
	 * Create the panel.
	 */
	public User_Edit_GUI() {
		
		init();
		ACCBUS = new Account_BUS();
		
	}
	
	public void init() {
		choose = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("image files", "png");
		choose.addChoosableFileFilter(filter);
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
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblChinh = new JLabel("Th\u00F4ng Tin C\u00E1 Nh\u00E2n");
		lblChinh.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChinh, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(378, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChinh)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_3.setBorder(new TitledBorder(null, "\u1EA2nh \u0110\u1EA1i Di\u1EC7n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "T\u00E0i Kho\u1EA3n C\u00E1 Nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblConfirm = new JLabel("");
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
								.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(166)
							.addComponent(lblConfirm, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblConfirm)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		
		lblTn = new JLabel("T\u00EAn");
		
		lblMSinhVin = new JLabel("M\u00E3 Sinh Vi\u00EAn");
		
		lblGt = new JLabel("Gi\u1EDBi T\u00EDnh");
		
		lblLp = new JLabel("L\u1EDBp");
		
		lblH = new JLabel("H\u1EC7");
		
		lblNewLabel_2 = new JLabel("M\u1EADt Kh\u1EA9u C\u0169");
		
		lblMtKhuMi = new JLabel("M\u1EADt Kh\u1EA9u M\u1EDBi");
		
		lblXcNhnMt = new JLabel("X\u00E1c Nh\u1EADn M\u1EADt Kh\u1EA9u");
		
		txtoldpass = new JPasswordField();
		
		txtnewpass = new JPasswordField();
		
		txtconfirm = new JPasswordField();
		
		bt_clear = new JButton("New button");
		bt_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtoldpass.setText("");
				txtnewpass.setText("");
				txtconfirm.setText("");
				lblMesoldpasss.setText("");
				lblMesconfirm.setText("");
				
			}
		});
		
		bt_luu2 = new JButton("New button");
		bt_luu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Account_DTO> arr = new ArrayList<Account_DTO>();
				arr = ACCBUS.Search(new Account_DTO(user));
				if(arr.size()!=0){
					lblMesoldpasss.setText("");
					lblMesconfirm.setText("");
					String pass= arr.get(0).getPass();
					String newpass = txtoldpass.getText();
					String confirmpass = txtconfirm.getText();
					if(!pass.equals(txtoldpass.getText())){
						lblMesoldpasss.setText("(*) Mật Khẩu không đúng");
						txtoldpass.requestFocus();
						lblConfirm.setText("Xin Mời Thử Lại");
						bt_clear.doClick();
					}
					else if(!newpass.equals(confirmpass)){
						lblMesconfirm.setText("(*) Mật Khẩu xác nhận không chính xác");
						bt_clear.doClick();
						lblConfirm.setText("Xin Mời Thử Lại");
					}
					else{
						ACCBUS.update(new Account_DTO(arr.get(0).getUser(),newpass,arr.get(0).getLevel()));
						lblConfirm.setText("Cập Nhập Thành Công");
					}
				}
			}
		});
		
		lblMesoldpasss = new JLabel("");
		
		lblMesconfirm = new JLabel("");
		
		lbten = new JLabel("");
		
		lbmasv = new JLabel("");
		
		lbgioitinh = new JLabel("");
		
		lblop = new JLabel("");
		
		JLabel lbhe = new JLabel("");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblTn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblMSinhVin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblGt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblLp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblMtKhuMi, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXcNhnMt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
						.addComponent(lblH, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lbhe, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblop, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbgioitinh, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbmasv, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(txtconfirm, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblMesconfirm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(txtnewpass, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lbten, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtoldpass, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblMesoldpasss, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(120, Short.MAX_VALUE))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(473, Short.MAX_VALUE)
					.addComponent(bt_clear)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bt_luu2)
					.addGap(88))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTn)
						.addComponent(lbten))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMSinhVin)
						.addComponent(lbmasv))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGt)
						.addComponent(lbgioitinh))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLp)
						.addComponent(lblop))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblH)
						.addComponent(lbhe))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtoldpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMesoldpasss))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMtKhuMi)
						.addComponent(txtnewpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXcNhnMt)
						.addComponent(txtconfirm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMesconfirm))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(bt_clear)
						.addComponent(bt_luu2)))
		);
		panel_4.setLayout(gl_panel_4);
		
		img = new JLabel("");
		img.setSize(new Dimension(96, 128));
		
		txt_browser = new JTextField();
		txt_browser.setEnabled(false);
		txt_browser.setEditable(false);
		txt_browser.setColumns(10);
		
		bt_browser = new JButton("New button");
		bt_browser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int query = choose.showOpenDialog(null);
				
				if(query == JFileChooser.APPROVE_OPTION){
					File file = choose.getSelectedFile();
					txt_browser.setText(file.getPath());
		            BufferedImage image = null;
		            try {
						image = ImageIO.read(file);
//						File NEW = new File(System.getProperty("user.dir")+"\\src\\Image\\"+file.getName());
//						ImageIO.write(image, "jpg",NEW);
						Image IMG = image.getScaledInstance(96,128,Image.SCALE_DEFAULT);
			            img.setIcon(new ImageIcon(IMG));
		            } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		            
	            	
	            	
				}
			}
		});
		
		bt_luu = new JButton("New button");
		bt_luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(txt_browser.getText());
				try {
					InputStream is = new FileInputStream(file);
					byte[] ig = new byte[(int) (file.length()+1)];
					is.read(ig);
					ACCBUS.EditImage(new Account_DTO(user,"",-1,ig));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ArrayList<Account_DTO> arr = new ArrayList<Account_DTO>();
				arr = ACCBUS.SearchImage(new Account_DTO(user));
				System.out.println(user);
				if(arr.size()!=0){
				try {
					System.out.println("true");
					byte[] ig = arr.get(0).getImage();
					System.out.println(ig);
//					OutputStream out = new FileOutputStream("new.png");
//					out.flush();
//					out.write(ig);
					
					InputStream in = new ByteArrayInputStream(ig);
					//File NEW = new File("hello");
					BufferedImage image = null;
					image = ImageIO.read(in);
					//ImageIO.write(image,"jpg",NEW);
					Image IMG = image.getScaledInstance(96,128,Image.SCALE_DEFAULT);
					img.setIcon(new ImageIcon(IMG));
					USER.loadImageFromTable(user);
					//out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(img, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txt_browser, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(bt_browser)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bt_luu)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(txt_browser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(bt_browser)
							.addComponent(bt_luu))
						.addComponent(img, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public void Loaddata(){
		ArrayList<SinhVien_DTO> arrsv = new ArrayList<SinhVien_DTO>();
		ArrayList<Hedaotao_DTO> arrhe = new ArrayList<Hedaotao_DTO>();
		ArrayList<Lop_DTO> arrl = new ArrayList<Lop_DTO>();
		ArrayList<Account_DTO> arracc = new ArrayList<Account_DTO>();
		arrsv = (new SinhVien_BUS()).SearchID(new SinhVien_DTO(user));
		//lbten.setText(arrsv.get(0).getHoten());
		
	}

	public USER_Forms getUSER() {
		return USER;
	}

	public void setUSER(USER_Forms uSER) {
		USER = uSER;
	}
}
