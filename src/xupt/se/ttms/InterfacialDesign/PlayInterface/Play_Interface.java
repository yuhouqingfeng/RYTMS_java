package xupt.se.ttms.InterfacialDesign.PlayInterface;

import java.awt.Panel;

import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import xupt.se.ttms.InterfacialDesign.Main_Interface;
import xupt.se.ttms.InterfacialDesign.EmployeeInterface.Employee_Interface;

public class Play_Interface extends Main_Interface {
	@Override
	protected void setMenu() {
		JTabbedPane Menu = getMenu();
		
		JTextField textField = new JTextField("aesrydtyyuuklkjytrewQWQERTY");
		textField.setBounds(0, 0, 100, 20);
		
		Menu.addTab("adsfdghjk",textField);
//		
//		JPasswordField passwordField = new JPasswordField();
//		passwordField.setBounds(0, 0, 100, 20);
//		Menu.addTab("password",passwordField);
		
	}
//	public static void main(String[] args) {
//		Play_Interface interface1 = new Play_Interface();
//		interface1.setVisible(true);
//		
//	}

}
