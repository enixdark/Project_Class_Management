package GUI_LOGIN;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import BUS.Account_BUS;
import Components.TextPrompt;
import DTO.Account_DTO;
import GUI.AdminMainForm;
import GUI.User_Edit_GUI;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Components.TextPrompt.Show;
import javax.swing.SwingConstants;

public class LOGIN_Forms extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private Account_BUS ACCBUS;
	private USER_Forms USER;
	private User_Edit_GUI EDIT;
	private GUI_Base_Image IMAGE;
	private JPanel Previous;
	/**
	 * Create the panel.
	 */
	public LOGIN_Forms() {
		setOpaque(false);
		ACCBUS = new Account_BUS();
		init();

	}
	public LOGIN_Forms(USER_Forms USER) {
		this.setUSER(USER);
		setOpaque(false);
		ACCBUS = new Account_BUS();

		init();

	}
	public void init() {

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setDragEnabled(true);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		TextPrompt tpuser = new TextPrompt("Username",textField);
		tpuser.setShow(Show.FOCUS_LOST);
		tpuser.setLabelFor(textField);
		try {
			BufferedImage iconuser = ImageIO.read(LOGIN_Forms.class.getResource("/Image/1362692940_elementary_school.png"));
			Image img = iconuser.getScaledInstance(16,16,Image.SCALE_DEFAULT);
			tpuser.setIcon(new ImageIcon(img));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tpuser.setForeground( Color.darkGray );
		tpuser.changeAlpha(0.5f);
		tpuser.changeStyle(Font.ITALIC);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		TextPrompt tppass = new TextPrompt("Password",passwordField);
		tppass.setLabelFor(passwordField);
		try {
			BufferedImage iconpass = ImageIO.read(LOGIN_Forms.class.getResource("/Image/1362739975_lock.png"));
			Image img = iconpass.getScaledInstance(16,16,Image.SCALE_DEFAULT);
			tppass.setIcon(new ImageIcon(img));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tppass.setShow(Show.FOCUS_LOST);
		tppass.setForeground( Color.darkGray );
		tppass.changeAlpha(0.5f);
		tppass.changeStyle(Font.ITALIC);
		

		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel source = (JLabel) e.getSource();
				source.setIcon(new ImageIcon(AdminMainForm.class.getResource("/Image/Lg1.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				JLabel source = (JLabel) e.getSource();
				source.setIcon(new ImageIcon(AdminMainForm.class.getResource("/Image/Lg.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel source = (JLabel) e.getSource();
				source.setIcon(new ImageIcon(AdminMainForm.class.getResource("/Image/Lg.png")));
				Login();
			}
		});
		label_2.setIcon(new ImageIcon(LOGIN_Forms.class.getResource("/Image/Lg.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
										.addComponent(label_2))
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
										.addGap(14))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(28)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGap(25))
				);
		setLayout(groupLayout);
	}

	public void Login(/*Account_DTO acc*/){
		//System.out.print(passwordField.getText());
		if(textField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Phần User Để Trống","Thông Báo",1,null);
			Clear();
			textField.requestFocus();
		}
		else if(passwordField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Phần Password Để Trống","Thông Báo",1,null);
			Clear();
			passwordField.requestFocus();

		}
		else{
			ArrayList<Account_DTO> arr = new ArrayList<Account_DTO>();
			String user = textField.getText();
			String pass = passwordField.getText();
			Account_DTO A = new Account_DTO(user,pass);
			arr = ACCBUS.Search(A);
			if(arr.size() == 0 ){
				JOptionPane.showMessageDialog(null,"Đăng nhập Thất Bại,Xin Mời Thử Lại","Thông Báo",1,null);
				return;
			}
			int level = arr.get(0).getLevel();
			AdminMainForm.setquyen(level);
			JOptionPane.showMessageDialog(null,"Đăng nhập Thành Công","Thông Báo",1,null);
			
			Clear();
			this.setVisible(false);
			this.USER.setVisible(true);
			this.USER.setUser(arr.get(0).getUser());
			this.USER.loadImageFromTable(arr.get(0).getUser());
			this.EDIT.setUser(arr.get(0).getUser());
			this.EDIT.Loaddata();
			AdminMainForm.Logout();
			//AdminMainForm.SetLog(true);
		}

	}

	public void Clear(){
		textField.setText("");
		passwordField.setText("");
	}
	public USER_Forms getUSER() {
		return USER;
	}
	public void setUSER(USER_Forms uSER) {
		USER = uSER;
	}
	
	public User_Edit_GUI getEDIT() {
		return EDIT;
	}
	public void setEDIT(User_Edit_GUI eDIT) {
		EDIT = eDIT;
	}
	public GUI_Base_Image getIMAGE() {
		return IMAGE;
	}
	public void setIMAGE(GUI_Base_Image iMAGE) {
		IMAGE = iMAGE;
	}
	public JPanel getPrevious() {
		return Previous;
	}
	public void setPrevious(JPanel previous) {
		Previous = previous;
	}

}

