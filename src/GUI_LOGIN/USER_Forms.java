package GUI_LOGIN;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import org.jdesktop.swingx.JXImageView;

import ch.randelshofer.quaqua.ext.base64.Base64.InputStream;

import BUS.Account_BUS;
import DTO.Account_DTO;
import GUI.AdminMainForm;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class USER_Forms extends JPanel {

	/**
	 * Create the panel.
	 */
	private LOGIN_Forms LOGIN;
	private String user;
	private JXImageView imageView;
	private GUI_Base_Image IMAGE;
	private JPanel Previous;
	public USER_Forms() {

		init();

	}
	public USER_Forms(LOGIN_Forms LOGIN) {
		this.setLOGIN(LOGIN);
		init();
		

	}
	public void init() {
		JLabel lblNewLabel = new JLabel("");

		
		imageView = new JXImageView();
		JLabel label = new JLabel("");

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
				Logout();
			}
		});
		label_2.setIcon(new ImageIcon(USER_Forms.class.getResource("/Image/Lg.png")));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(imageView, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(lblNewLabel))
					.addContainerGap(136, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(120, Short.MAX_VALUE)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(28)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(25))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(0, 0, Short.MAX_VALUE)
							.addComponent(imageView, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(65))))
		);
		setLayout(groupLayout);
	}
	public void Logout(){
		if(JOptionPane.showConfirmDialog(null,"Ban Co Chac Chan Muon Thoat","Thong Bao",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		{
			this.setVisible(false);
			this.LOGIN.setVisible(true);
			AdminMainForm.setquyen(0);
			AdminMainForm.Logout();
		}
	}
	public LOGIN_Forms getLOGIN() {
		return LOGIN;
	}
	public void setLOGIN(LOGIN_Forms lOGIN) {
		LOGIN = lOGIN;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public void Setimage(Image image){
		imageView.setImage(image);
	}
	public void loadImageFromTable(String user) {
		System.out.println(user);
		ArrayList<Account_DTO> arr = (new Account_BUS()).SearchImage(new Account_DTO(user));
		if(arr.size()!=0){
			byte[] img = arr.get(0).getImage();
			ByteArrayInputStream in = new ByteArrayInputStream(img);
			BufferedImage image = null;
			try {
				image = ImageIO.read(in);
				Image IMG = image.getScaledInstance(60,80,Image.SCALE_DEFAULT);
				imageView.setImage(IMG);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//ImageIO.write(image,"jpg",NEW);
			
		}
	}
	public JPanel getPrevious() {
		return Previous;
	}
	public void setPrevious(JPanel previous) {
		Previous = previous;
	}
}


