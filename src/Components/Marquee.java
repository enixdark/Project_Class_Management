package Components;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.jidesoft.swing.JideTitledBorder;
import com.jidesoft.swing.MarqueePane;
import com.jidesoft.swing.MultilineLabel;
import com.jidesoft.swing.PartialEtchedBorder;
import com.jidesoft.swing.PartialSide;
import java.awt.Component;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class Marquee extends JPanel {

	/**
	 * Create the panel.
	 */
	private MultilineLabel textArea;
	private MarqueePane Mpanel;
	public Marquee() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
		);
		textArea = new MultilineLabel();
		textArea.setTabSize(8);
		textArea.setBackground(Color.WHITE);
		textArea.setText("CNH-HĐH, hội nhập quốc tế cần phải phát huy tốt những truyền thống tốt đẹp của giáo dục gia đình góp phần hình thành nên nhân cách con người Việt Nam hoàn thiện và đúng chuẩn. Gia đình truyền thống Việt Nam nhất thiết phải hòa nhập vào xu thế hiện đại, hiện đại hóa, nhưng vẫn phải giữ được sắc thái riêng không bị trộn lẫn vào cái chung và kế thừa, tiếp thu có chọn lọc. Tuy nhiên để có thể làm được điều đó, cần phải củng cố thiết chế gia đình, điều kiện khách quan để xã hội hóa cá nhân trong gia đình, thiết lập mạng lưới giữa gia đình, nhà trường, xã hội trong việc hình thành nhân cách cho cá nhân.");
		//textArea.setText("Obama welcomes bill to regulate tobacco Fake Rockefeller found guilty of kidnapping Al Qaeda fighters relocating, officials say Navarrette: Haters looking for scapegoats Avlon: 'Wingnuts' spread hate of Obama, Jews Ticker: Palin knocks 'perverted' Letterman Spokesman: Chastity Bono changing gender iReport.com: Share stories of gender change Robin Meade: Packing for presidential skydive WLUK: Girl gets excuse note from Obama Woman gives up home, car to help kids 9-month-old snatched from home  WPLG: Cat killings becoming more violent Cargo containers become beautiful homes Fortune: Dare you ask for a raise now? Truck loses load of cash, causes car jam  Flying fish smack boater in head   Dog eats bag of pot, gets high");
			        panel.setLayout(null);
			        
		
			        MarqueePane verticalMarqueeUp = new MarqueePane(textArea);
			        verticalMarqueeUp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			        verticalMarqueeUp.setViewportBorder(null);
			        verticalMarqueeUp.setBounds(10, 11, 208, 229);
			        verticalMarqueeUp.setWheelScrollingEnabled(true);
			        
			        verticalMarqueeUp.setScrollDirection(MarqueePane.SCROLL_DIRECTION_UP);
			        panel.add(verticalMarqueeUp);
			        verticalMarqueeUp.setScrollAmount(1);
			        verticalMarqueeUp.setStayPosition(14);
			        panel.add(verticalMarqueeUp);
			        Mpanel = verticalMarqueeUp;
		setLayout(groupLayout);
		
	}
	
	public void Settext(String text){
		//MarqueePane verticalMarqueeUp = new MarqueePane(textArea);
		//textArea = new MultilineLabel();
//		Mpanel.stopAutoScrolling();
//	
//		textArea = new MultilineLabel();
//		textArea.setTabSize(8);
//		textArea.setBackground(Color.WHITE);
		textArea.setText(text);
		//textArea.setText("Obama welcomes bill to regulate tobacco Fake Rockefeller found guilty of kidnapping Al Qaeda fighters relocating, officials say Navarrette: Haters looking for scapegoats Avlon: 'Wingnuts' spread hate of Obama, Jews Ticker: Palin knocks 'perverted' Letterman Spokesman: Chastity Bono changing gender iReport.com: Share stories of gender change Robin Meade: Packing for presidential skydive WLUK: Girl gets excuse note from Obama Woman gives up home, car to help kids 9-month-old snatched from home  WPLG: Cat killings becoming more violent Cargo containers become beautiful homes Fortune: Dare you ask for a raise now? Truck loses load of cash, causes car jam  Flying fish smack boater in head   Dog eats bag of pot, gets high");
		//Mpanel.startAutoScrolling();
      }
}
