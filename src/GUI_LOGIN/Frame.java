package GUI_LOGIN;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import BUS.New_BUS;
import Components.ClockTime2;
import Components.TimeClock;
import DTO.New_DTO;

import java.awt.FlowLayout;
import javax.swing.JTextPane;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JLabel lblNewLabel ;
	JLabel lb;
	File clone = new File("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
					frame.load();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JFileChooser fc = new JFileChooser();
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//In response to a button click:
		//int returnVal = fc.showOpenDialog(this);
		//ImageFilter filter = new ImageFilter();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("image files", "png");
		fc.addChoosableFileFilter(filter);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JButton b = (JButton) e.getSource();
//				File file = new File("3.png");
//				System.out.println(file.exists());
				int returnVal = fc.showOpenDialog(null);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            BufferedImage image = null;
		            try {
		            	
//						OutputStream output = new FileOutputStream(file);
		            	
		            	System.out.println("Cone path " + clone.getAbsolutePath() + clone.exists());
		            	if(clone.exists()){
		            		clone.delete();
		            	}
		            	image = ImageIO.read(file);
		            	File NEW = new File(file.getName());
		            	
		            	ImageIO.write(image, "jpg",NEW);
		            	Image img = image.getScaledInstance(32,32,Image.SCALE_DEFAULT);
			            lblNewLabel.setIcon(new ImageIcon(img));
			            System.out.println(NEW.getAbsolutePath());
			            clone = new File(NEW.getName());
			           
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            //This is where a real application would open the file.
		            
		            System.out.println("Opening: " + file.getPath() + " Name :" + file.getName() );
		            textField.setText(file.getPath());
		            
		        } else {
		        	System.out.println("Open command cancelled by user.");
		        }
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Frame.class.getResource("/Image/1362692940_elementary_school.png")));
		
		JButton btnOk = new JButton("OK");
		
		lb = new JLabel("New label");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnOk)
							.addGap(77)
							.addComponent(lb, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton)))
							.addGap(69))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(lb, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(48))
		);
		
		contentPane.setLayout(gl_contentPane);
		
		//contentPane.setLayout(gl_contentPane);
	}
	
	public void load(){
		ArrayList<New_DTO> arr = new ArrayList<New_DTO>();
		arr = (new New_BUS()).getdata();
		if(arr.size()!=0){
			lb.setText("<html><marquee behavior='alternate'>Some..Scrolling..Text</marquee></html>" );
		}
	}
}
