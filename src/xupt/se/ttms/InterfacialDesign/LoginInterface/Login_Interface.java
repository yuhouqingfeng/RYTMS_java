package xupt.se.ttms.InterfacialDesign.LoginInterface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import xupt.se.ttms.InterfacialDesign.Error_Dialog;
import xupt.se.ttms.service.LoginDataAffirm;
/**
 * This interface used to provide a way to login the RYT theater management system
 * for users, users need to input account and password to enter the system. 
 * 
 * Account should consist of letters like 'A'~'Z' and 'a'~'z',and cannot use any 
 * numbers or signs.
 * 
 * Password can use any characters in keyboard besides space sign like the blank 
 * character or the enter character, at least use 6 characters.
 * 
 * @author Aligreat
 *
 */
public class Login_Interface extends JFrame{
	private static Login_Interface login_Interface = null;
	private String Account = null;	
	private String Password = null;
	private Map<String, String> userData = null;

	private Login_Interface(LoginDataAffirm affirmer) {
		userData = new HashMap<String , String>();
		setBounds(300, 160, 650, 500);
		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 1));
		c.setBackground(Color.white);
		
		
		//contentPene: first row
		JLabel logo = new JLabel();
		Icon image = new ImageIcon("../TTMS_RYT_PROJECT/resource/image/Login_logo.jpg");
		logo.setIcon(image);
		c.add(logo);
		
		
		//contentPene: second row
		JPanel secondRow = new JPanel();
		secondRow.setLayout(null);
		
		//account and password label
		JLabel accountLabel = new JLabel("Account: ");
		JLabel passwordLabel = new JLabel("Password: ");
		accountLabel.setFont(new Font("", Font.BOLD, 18));
		accountLabel.setBounds(190, 40, 100, 22);
		secondRow.add(accountLabel);
		passwordLabel.setFont(new Font("", Font.BOLD, 18));
		passwordLabel.setBounds(190, 100, 100, 22);
		secondRow.add(passwordLabel);
		
		//account and password field
		JTextField accountField = new JTextField(1);
		accountField.setBounds(290, 40, 150, 25);
		accountField.setFont(new Font("", Font.BOLD, 17));
		secondRow.add(accountField);
		JPasswordField passwordField = new JPasswordField(1);
		passwordField.setEchoChar('*');
		passwordField.setBounds(290, 100, 150, 25);
		passwordField.setFont(new Font("", Font.BOLD, 17));
		secondRow.add(passwordField);
		c.add(secondRow);
		
		
		//contentPene: third row
		JPanel thirdRow = new JPanel();
		thirdRow.setLayout(null);
		JButton login = new JButton("Login");
		JButton exit = new JButton("Exit");
		login.setBounds(150, 40, 100, 50);
		login.setFont(new Font("", Font.BOLD, 21));
		login.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Account = accountField.getText();
				Password = String.valueOf(passwordField.getPassword());
				try {
					uploadData(Account,Password,affirmer);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		exit.setBounds(400, 40, 100, 50);
		exit.setFont(new Font("", Font.BOLD, 21));
		exit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		thirdRow.add(login);
		thirdRow.add(exit);
		c.add(thirdRow);
		
		setUndecorated(true);
		setVisible(true);
	}
	
	/**
	 * To compare the account and the password with data in databases,
	 * if alike login system, else pop-up a dialog to hint login failed.
	 * @throws Exception 
	 */
	private void uploadData(String account , String password,LoginDataAffirm affirmer) throws Exception{
		boolean flag = false;
		userData.put("account", account);
		userData.put("password", password);
		//link to database and affirm
		flag = affirmer.dataAffirm(userData);
		if (true == flag) {	//Login successfully.
			dispose();
		}else{	//Login failed.
			new Error_Dialog(this,Error_Dialog.LOGIN_ERROR);
		}
	}
	/**
	 * Calling this method to show the user's login interface.
	 * 
	 * @param affirmer
	 * Introduction this object is used to affirm the validly and of user's 
	 * account and password.
	 * 
	 * @return
	 * Return a map, it contains two variables, one of the variables' key is
	 * "account" and its value is user's account, another's key is "password"
	 * and its value is user's password.
	 * 
	 */
	public static Map<String, String> showLoginInterface(LoginDataAffirm affirmer){
		if(login_Interface == null){
			login_Interface = new Login_Interface(affirmer);
		}
		return login_Interface.userData;
	}
}
