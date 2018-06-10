package xupt.se.ttms.InterfacialDesign.EmployeeInterface;

import java.awt.TextField;

import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import xupt.se.ttms.InterfacialDesign.Main_Interface;

public class Employee_Interface extends Main_Interface {
	@Override
	protected void setMenu() {
		JTabbedPane Menu = getMenu();
		
		JTextField textField = new JTextField("123qweasd");
		textField.setBounds(0, 0, 100, 100);
		
		Menu.addTab("sell",textField);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(0, 0, 100, 20);
		Menu.addTab("password",passwordField);
		
	}
	public static void main(String[] args) {
		Employee_Interface interface1 = new Employee_Interface();
		interface1.setVisible(true);
		
	}
	
}