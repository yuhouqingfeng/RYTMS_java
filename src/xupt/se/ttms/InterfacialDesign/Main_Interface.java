package xupt.se.ttms.InterfacialDesign;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.Panel;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.RootPaneContainer;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

/**
 * A Main_Interface is an object having a menu bar show user what they can do,
 * every Main_Interface class and its subclass can only have one object, every
 * subclass should overwrite the method "setMenu()" to define all function user
 * can use, each different department has different menu bar of interface.
 * 
 * Call the method "showMainInterface()" in each subclass can show user interface.
 * 
 * @author Aligreat
 *
 */
abstract public class Main_Interface extends JFrame {
	
	/**
	 * It used to define function list to users.
	 */
	private JTabbedPane Menu = new JTabbedPane();
	
	/**
	 * Call this method to get the Menu object of the main_Interface object.
	 * @return
	 */
	protected JTabbedPane getMenu() {
		return Menu;
	}
	
	protected Main_Interface() {
		setAtribute();
	}

	protected void setAtribute() {
		this.getContentPane().setBackground(Color.yellow);
		setTitle("RYT Theater System Management Studio");
		setLayout(null);//自动布局 ，可以自适应大小
		setBounds(80, 30, 1200, 600);//setBounds(80, 30, 1200, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("../TTMS_RYT_PROJECT/resource/image/Main_Initerface_Logo.jpg").getImage());//标题图标
		setResizable(false);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++==
		
	    JPanel panel = new JPanel(); 
	    panel.setLayout(null);
//	    panel.setBounds(0, 0, 1200, 400);
//	    panel.setBackground(Color.blue);
	    panel.setPreferredSize(new Dimension(400, 1000));
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(0, 0, 1195, 575);
		getContentPane().add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(panel);
		
		
		JLabel imageLabel = new JLabel();
		ImageIcon image = new ImageIcon("../TTMS_RYT_PROJECT/resource/image/Main_Background.jpg");
		imageLabel.setBounds(0,0,image.getIconWidth(),  image.getIconHeight());
		imageLabel.setIcon(image);
		panel.add(imageLabel);
		
		Menu.setBounds(30, 190,1130,500);//430
		setMenu();
		panel.add(Menu);
		
		JLabel goodLuck = new JLabel("GOOD LOCK TO YOU!!! ");
		goodLuck.setFont(new Font("", Font.CENTER_BASELINE, 17));
		goodLuck.setBounds(980, 690, 220, 40);
//		goodLuck.setBackground(Color.RED);
//		goodLuck.setOpaque(true);
		panel.add(goodLuck);
	}
	
	/**
	 * Overwrite this method to define total function that users in different
	 * department can use.
	 */
	abstract protected void setMenu();
}
