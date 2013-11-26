package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXEditorPane;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXRootPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXStatusBar;
import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.JXFindBar;
import org.jdesktop.swingx.JXList;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import org.jdesktop.swingx.JXMultiThumbSlider;
import org.jdesktop.swingx.JXFindPanel;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.JXDialog;
import javax.swing.JComponent;
import org.jdesktop.swingx.JXHeader;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.JXTitledSeparator;
import java.awt.event.KeyEvent;

import GUI_LOGIN.GUI_Base_Image;
import GUI_LOGIN.LOGIN_Forms;
import GUI_LOGIN.USER_Forms;
import BUS.New_BUS;
import Components.ClockTime2;
import Components.Marquee;
import Components.TimeClock;
import DTO.New_DTO;
//import com.jgoodies.forms.debug.FormDebugUtils;
import java.awt.Cursor;
import org.jdesktop.swingx.JXTitledPanel;
import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Window;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.ScrollableSizeHint;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import java.awt.SystemColor;
import org.jdesktop.swingx.JXImageView;
import java.awt.Toolkit;
import java.awt.Canvas;
import net.miginfocom.swing.MigLayout;
import java.awt.Panel;
import java.awt.GridBagLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import org.jdesktop.swingx.JXLoginPane;
import java.awt.Dimension;
import org.jdesktop.swingx.JXHeader.IconPosition;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextPane;

public class AdminMainForm {

	public JFrame frame;
	private JXPanel panel_right ;
	private JXPanel panel_left ;
	SinhVien_GUI SV = new SinhVien_GUI();
	DIEM_GUI DIEM = new DIEM_GUI();
	MonHoc_GUI MH = new MonHoc_GUI();
	Lop_GUI LOP = new Lop_GUI();
	Hocki_Nganh_He_GUI HE = new Hocki_Nganh_He_GUI();
	Account_GUI ACC = new Account_GUI();
	ViewDiem_GUI View = new ViewDiem_GUI();
	GUI_Base_Image IMAGE = new GUI_Base_Image();
	ThongKe_GUI TK = new ThongKe_GUI();
	User_Edit_GUI EDIT = new User_Edit_GUI();
	LOGIN_Forms LOGIN = new LOGIN_Forms();
	USER_Forms USER = new USER_Forms();
	ClockTime2 TIME = new ClockTime2();
	Marquee TextScroll = new Marquee();
	JPanel PreviousPanel;
	private JMenuItem mntmQunLSinh;
	private JPanel Panel_Title;
	public static Object Reftk = null;
	public static Object Refacc = null;
	public static Object Refdiem = null;
	public static Object Refhe = null;
	public static Object Reflop = null;
	public static Object Refmh = null;
	public static Object Refsv = null;
	public static Object IMAGEGUICLONE = null;
	public static JPanel GUI_Previous = null;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminMainForm window = new AdminMainForm();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public AdminMainForm() {
		initialize();
		AddGUI();
//		panel_right.list();
		SetGUI(IMAGE);
		LOGIN.setVisible(true);
		setquyen(0);
		loadthongbao();
		
	}

	public void AddGUI() {
		panel_right.add(ACC);
		panel_right.add(HE);
		panel_right.add(View);
		panel_right.add(LOP);
		panel_right.add(DIEM);
		panel_right.add(SV);
		panel_right.add(MH);
		panel_right.add(IMAGE);
		panel_right.add(TK);
		panel_right.add(EDIT);
		LOGIN.setUSER(USER);
		USER.setLOGIN(LOGIN);
		LOGIN.setEDIT(EDIT);
		EDIT.setUSER(USER);
		
		GroupLayout gl_Panel_Title = new GroupLayout(Panel_Title);
		gl_Panel_Title.setHorizontalGroup(
			gl_Panel_Title.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Title.createSequentialGroup()
					.addComponent(LOGIN, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(USER, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addGap(249))
		);
		gl_Panel_Title.setVerticalGroup(
			gl_Panel_Title.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel_Title.createSequentialGroup()
					.addGroup(gl_Panel_Title.createParallelGroup(Alignment.LEADING)
						.addComponent(USER, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addComponent(LOGIN, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addGap(170))
		);
		USER.setVisible(false);
		Panel_Title.setLayout(gl_Panel_Title);
		ACC.setVisible(false);
		HE.setVisible(false);
		LOP.setVisible(false);
		DIEM.setVisible(false);
		SV.setVisible(false);
		MH.setVisible(false);
		View.setVisible(false);
		TK.setVisible(false);
		EDIT.setVisible(false);
		IMAGEGUICLONE = IMAGE;
		
	}
	public void SetGUI(Object obj){
		PreviousPanel = (JPanel) obj;
		GUI_Previous = PreviousPanel;
		JPanel panel = (JPanel) obj;
		panel.setForeground(Color.WHITE);;
		panel.setBackground(Color.WHITE);
		//((JComponent) obj).setBorder(UIManager.getBorder("FileChooser.listViewBorder"));
		panel.setSize(821, 638);
		panel.setLocation(0, 0);
		panel.setVisible(true);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setBounds(100, 100, 1121, 719);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel_left = new JXPanel();
		panel_left.setAlignmentY(0.0f);
		panel_left.setAlignmentX(0.0f);
		panel_left.setMaximumSize(new Dimension(300, 600));
		panel_left.setOpaque(false);
		panel_left.setScrollableWidthHint(ScrollableSizeHint.NONE);
		panel_left.setScrollableHeightHint(ScrollableSizeHint.NONE);
		panel_left.setScrollableTracksViewportWidth(false);
		panel_left.setScrollableTracksViewportHeight(false);
		
		panel_right = new JXPanel();
		panel_right.setBackground(Color.WHITE);
		panel_right.setBorder(UIManager.getBorder("ComboBox.border"));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_right, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_left, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_left, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_right, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_right.setLayout(null);
		GUI_Base_Image i_Base_Image = new GUI_Base_Image();
		i_Base_Image.setForeground(Color.WHITE);
		i_Base_Image.setBackground(Color.WHITE);
		panel_right.add(i_Base_Image);
		
		JXTaskPane taskPane_1 = new JXTaskPane();
		taskPane_1.setForeground(Color.BLUE);
		taskPane_1.setInheritsPopupMenu(true);
		taskPane_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		taskPane_1.setScrollOnExpand(true);
		taskPane_1.setTitle("Th\u00F4ng B\u00E1o");
		taskPane_1.setBackground(Color.BLUE);
		taskPane_1.getContentPane().setBackground(Color.CYAN);
		taskPane_1.getContentPane().setLayout(null);
		
		JPanel panel_tb = new JPanel();
		panel_tb.setBackground(Color.WHITE);
		panel_tb.setBounds(0, 0, 248, 81);
		taskPane_1.getContentPane().add(panel_tb);
		TextScroll.setBackground(Color.WHITE);
		panel_tb.add(TextScroll);
		JXTitledPanel titledPanel = new JXTitledPanel();
		titledPanel.setPaintBorderInsets(false);
		titledPanel.setTitleFont(new Font("Tahoma", Font.BOLD, 11));
		titledPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		titledPanel.setAutoscrolls(true);
		titledPanel.setForeground(UIManager.getColor("Hyperlink.visitedColor"));
		titledPanel.setTitleForeground(Color.BLUE);
		titledPanel.setBackground(UIManager.getColor("Hyperlink.visitedColor"));
		titledPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, UIManager.getColor("Hyperlink.visitedColor")));
		titledPanel.setScrollableHeightHint(ScrollableSizeHint.NONE);
		titledPanel.setTitle("Th\u00F4ng Tin");
		JXMonthView monthView = new JXMonthView();
		monthView.setComponentInputMapEnabled(true);
		monthView.setMonthStringBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		monthView.setOpaque(false);
		monthView.setShowingLeadingDays(true);
		monthView.setTraversable(true);
		monthView.setZoomable(true);
		JXTaskPane taskPane = new JXTaskPane();
		taskPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		taskPane.setBackground(Color.WHITE);
		taskPane.getContentPane().setBackground(Color.WHITE);
		taskPane.getContentPane().setForeground(UIManager.getColor("Button.background"));
		taskPane.getContentPane().setLayout(null);
		
		JXHeader header = new JXHeader();
		header.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		header.setBackground(Color.WHITE);
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PreviousPanel.setVisible(false);
				SetGUI(View);
			}
		});
		header.setIconPosition(IconPosition.LEFT);
		header.setTitle("Tra \u0110i\u1EC3m Nhanh");
		header.setBounds(0, 0, 248, 35);
		taskPane.getContentPane().add(header);
		
		JXHeader header_1 = new JXHeader();
		header_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		header_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PreviousPanel.setVisible(false);
				SetGUI(EDIT);
			}
		});
		header_1.setIconPosition(IconPosition.LEFT);
		header_1.setTitle("Ch\u00EDnh S\u1EEDa");
		GridBagLayout gridBagLayout = (GridBagLayout) header_1.getLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.columnWidths = new int[]{0, 0};
		header_1.setBounds(0, 33, 248, 35);
		taskPane.getContentPane().add(header_1);
		
		JXHeader header_2 = new JXHeader();
		header_2.setTitle("");
		GridBagLayout gridBagLayout_1 = (GridBagLayout) header_2.getLayout();
		gridBagLayout_1.rowWeights = new double[]{0.0, 0.0};
		gridBagLayout_1.rowHeights = new int[]{0, 0};
		gridBagLayout_1.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout_1.columnWidths = new int[]{0, 0};
		header_2.setBounds(0, 65, 248, 35);
		taskPane.getContentPane().add(header_2);
		taskPane.setTitle("Ch\u1EE9c N\u0103ng C\u01A1 B\u1EA3n");
		taskPane.setAutoscrolls(true);
		taskPane.setAnimated(false);
		taskPane.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		taskPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		taskPane.setVerifyInputWhenFocusTarget(false);
		taskPane.setScrollOnExpand(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		TIME.setBackground(Color.WHITE);
		TIME.setForeground(Color.LIGHT_GRAY);
		TIME.setBounds(0, 0, 248, 26);
		TIME.setVisible(true);
		GroupLayout gl_panel_left = new GroupLayout(panel_left);
		gl_panel_left.setHorizontalGroup(
			gl_panel_left.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_left.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_left.createParallelGroup(Alignment.LEADING)
						.addComponent(monthView, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
						.addComponent(titledPanel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
						.addComponent(taskPane_1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
						.addComponent(taskPane, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_left.setVerticalGroup(
			gl_panel_left.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_left.createSequentialGroup()
					.addComponent(titledPanel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(taskPane, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(taskPane_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(monthView, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		panel.add(TIME);
		
		Panel_Title = new JPanel();
		GroupLayout groupLayout_1 = new GroupLayout(titledPanel.getContentContainer());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addComponent(Panel_Title, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addComponent(Panel_Title, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
		);
		titledPanel.getContentContainer().setLayout(groupLayout_1);
		
		panel_left.setLayout(gl_panel_left);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenu mnChcNng = new JMenu("Ch\u1EE9c N\u0103ng");
		menuBar.add(mnChcNng);
		
		JMenuItem mntmQunLTi = new JMenuItem("Qu\u1EA3n L\u00ED T\u00E0i Kho\u1EA3n");
		mntmQunLTi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreviousPanel.setVisible(false);
				SetGUI(ACC);
			}
		});
		mnChcNng.add(mntmQunLTi);
		Refacc = mntmQunLTi;
	    mntmQunLSinh = new JMenuItem("Qu\u1EA3n L\u00ED Sinh Vi\u00EAn");
		mntmQunLSinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreviousPanel.setVisible(false);
				SetGUI(SV);
			}
		});
		mnChcNng.add(mntmQunLSinh);
		Refsv = mntmQunLSinh;
		JMenuItem mntmQunLim = new JMenuItem("Qu\u1EA3n L\u00ED \u0110i\u1EC3m");
		mntmQunLim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreviousPanel.setVisible(false);
				SetGUI(DIEM);
			}
		});
		mnChcNng.add(mntmQunLim);
		Refdiem = mntmQunLim;
		JMenuItem mntmQunLMn = new JMenuItem("Qu\u1EA3n L\u00ED M\u00F4n H\u1ECDc");
		mntmQunLMn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreviousPanel.setVisible(false);
				SetGUI(MH);
			}
		});
		mnChcNng.add(mntmQunLMn);
		Refmh = mntmQunLMn;
		JMenuItem mntmQunLHngnhhk = new JMenuItem("Qu\u1EA3n L\u00ED H\u1EC7,Ng\u00E0nh,HK");
		mntmQunLHngnhhk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreviousPanel.setVisible(false);
				SetGUI(HE);
			}
		});
		mnChcNng.add(mntmQunLHngnhhk);
		Refhe = mntmQunLHngnhhk;
		JMenuItem mntmQunLLp = new JMenuItem("Qu\u1EA3n L\u00ED L\u1EDBp H\u1ECDc");
		mntmQunLLp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreviousPanel.setVisible(false);
				SetGUI(LOP);
			}
		});
		mnChcNng.add(mntmQunLLp);
		Reflop = mntmQunLLp;
		
		JMenu mnThngK = new JMenu("Th\u1ED1ng K\u00EA");
		menuBar.add(mnThngK);
		
		JMenuItem mntmBngThngK = new JMenuItem("B\u1EA3ng Th\u00F4ng K\u00EA \u0110i\u1EC3m");
		mntmBngThngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreviousPanel.setVisible(false);
				SetGUI(TK);
			}
		});
		Reftk = mntmBngThngK;
		mnThngK.add(mntmBngThngK);
		
		JMenu mnThngTin = new JMenu("Th\u00F4ng Tin");
		menuBar.add(mnThngTin);
	}
	
	public void loadthongbao(){
		ArrayList<New_DTO> arr = new ArrayList<New_DTO>();
		arr = (new New_BUS()).getdata();
		if(arr.size()!=0){
			TextScroll.Settext(arr.get(0).getNews());
		}
	}
	
	public static void setquyen(int level){
		((Component) Refacc).setEnabled(false);
		((Component) Reflop).setEnabled(false);
		((Component) Refsv).setEnabled(false);
		((Component) Refmh).setEnabled(false);
		((Component) Refhe).setEnabled(false);
		((Component) Refdiem).setEnabled(false);
		if(level == 11111){
			((Component) Refacc).setEnabled(true);
			((Component) Reflop).setEnabled(true);
			((Component) Refsv).setEnabled(true);
			((Component) Refmh).setEnabled(true);
			((Component) Refhe).setEnabled(true);
			((Component) Refdiem).setEnabled(true);
		}
		else
		{
			while(level > 0){
				if(level - 10000 > 0){
					((Component) Reflop).setEnabled(true);
					level -= 10000;
				}
				else if(level - 1000 >= 0){
					((Component) Refmh).setEnabled(true);
					level -= 1000;
				}
				else if(level - 100 >= 0){
					level -= 100;
					((Component) Refsv).setEnabled(true);
				}
				else if(level - 10 >= 0){
					((Component) Refhe).setEnabled(true);
					level -= 10;
				}
				else if(level - 1 >= 0){
					((Component) Refdiem).setEnabled(true);
					level -= 1;
				}
			}

		}
		
		
	}
	
	public static void Logout(){
		
		GUI_Previous.setVisible(false);
		((JComponent) IMAGEGUICLONE).setVisible(true);
	}
}
