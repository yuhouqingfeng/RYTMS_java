package xupt.se.ttms.InterfacialDesign.InitialInterface;

import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Show user this interface before the RYT theater management system is running,
 * at the meantime should connect to the database and finish every preliminary.
 * 
 * Show the interface just needs call the static method in this class :
 * 
 * showInitialInterface()
 * 
 * @author Aligreat
 *
 */
public class Initial_Interface extends JFrame {
	private static Initial_Interface initial_Interface = null;
	
	private Initial_Interface(){
		Container container = getContentPane();
		container.setLayout(null);
		
		JLabel image = new JLabel();
		ImageIcon icon = new ImageIcon("../TTMS_RYT_PROJECT/resource/image/initial_interface.png");
		image.setIcon(icon);
		image.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		
		JLabel loading = new JLabel("The system is loading...");
		loading.setFont(new Font("", 0, 22));
		loading.setBounds(30, 300, 250,100 );
		
		container.add(loading);
		container.add(image);
		setLocation(300, 160);
		setSize(icon.getIconWidth(), icon.getIconHeight());
		setUndecorated(true);
	}
	
	/**
	 * This method is used to show the initial interface to user.
	 */
	public static void showInitialInterface() {
		initial_Interface = new Initial_Interface();
		initial_Interface.setVisible(true);
	//	show Loading interface
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		initial_Interface.dispose();
	}
	public static void main(String[] args) {
		showInitialInterface();
	}
}