package xupt.se.ttms.InterfacialDesign.PlayManagerInterface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import java.util.HashMap;
//import java.util.Map;
import java.util.zip.ZipEntry;

import javax.swing.Icon;
import javax.swing.ImageIcon;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

import xupt.se.ttms.model.Studio;
import xupt.se.ttms.service.LoginDataAffirm;

abstract  public  class PlayManagement extends JFrame {
	
	private static PlayManagement PlayManagement = null;
	private JPanel panel =  new JPanel();
 //	private String Account = null;	
//	private String Password = null;
	protected JTextField typetextfeild,languagetextfeild ,nametextfeild,timetextfeild,pricetextfeild,statustextfeild;
    protected JTextArea textArea;
    protected JButton imageBtn;
	
	protected JPanel getPanel() {
		return panel;
	}
	
	protected  PlayManagement() {
		setUI();
	}
	protected void setUI() {
		setBounds(300, 160, 800, 500);
		setTitle("PlayManagement");
		setLayout(null);
		setIconImage(new ImageIcon("../TTMS_RYT_PROJECT/resource/image/Main_Initerface_Logo.jpg").getImage());//标题图标
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		JLabel typeLabel = new JLabel("TypeNmae:");
		typeLabel.setBounds(30,20,100,30);
		add(typeLabel);
		
		JLabel languageLabel = new JLabel("LanguageLabel:");
		languageLabel.setBounds(30,70,100,30);
		add(languageLabel);
		
		JLabel nameLabel = new JLabel("PlayNmae:");
		nameLabel.setBounds(30,120,100,30);
		add(nameLabel);
	
		JLabel abstractLabel = new JLabel("AbstractLabel:");
		abstractLabel.setBounds(30,170,100,30);
		add(abstractLabel);
		
		imageBtn = new JButton("asdfghytrerw");
		imageBtn.setBounds(500,20,250, 300);//image.getIconWidth(),  image.getIconHeight()
		add(imageBtn);
		
		JLabel timeLabel = new JLabel("TimeLabel:");
		timeLabel.setBounds(30,300,100,30);
		add(timeLabel);
		
		JLabel priceLabel = new JLabel("PriceLabel:");
		priceLabel.setBounds(30,350,100,30);
		add(priceLabel);
		
		JLabel statusLabel = new JLabel("StatusLabel:");
		statusLabel.setBounds(30,400,100,30);
		add(statusLabel);
		
		 typetextfeild = new JTextField();
		typetextfeild.setBounds(140, 20, 300, 30);
		add(typetextfeild);
		
		languagetextfeild = new JTextField();
		languagetextfeild.setBounds(140, 70, 300, 30);
		add(languagetextfeild);
		
		nametextfeild = new JTextField();
		nametextfeild.setBounds(140, 120, 300, 30);
		add(nametextfeild);
		
		textArea = new JTextArea();
		textArea.setBounds(140,170,300,110);
		add(textArea);
		
		timetextfeild = new JTextField();
		timetextfeild.setBounds(140, 300, 300, 30);
		add(timetextfeild);
		
		pricetextfeild = new JTextField();
		pricetextfeild.setBounds(140, 350, 300, 30);
		add(pricetextfeild);
		
		statustextfeild = new JTextField();
		statustextfeild.setBounds(140, 400, 300, 30);
		add(statustextfeild);
		
		panel.setBounds(500,350,250, 100);
		setpanel();
		add(panel);
		
	}
    abstract protected void setpanel() ;
	
	
//	
//	private void uploadData(String account , String password,LoginDataAffirm affirmer) throws Exception{
//		boolean flag = false;
//		userData.put("account", account);
//		userData.put("password", password);
//		//link to database and affirm
//		flag = affirmer.dataAffirm(userData);
//		if (true == flag) {	//Login successfully.
//			dispose();
//		}else{	//Login failed.
//			new Error_Dialog(this,Error_Dialog.LOGIN_ERROR);
//		}
//	}
	/**
	 * Calling this method to show the user's login interface.
	 * 
	 * @param affirmer
	 * Introduction this object is used to affirm the validly and of user's 
	 * account and password.
	 * @return 
	 * 
	 * @return
	 * Return a map, it contains two variables, one of the variables' key is
	 * "account" and its value is user's account, another's key is "password"
	 * and its value is user's password.
	 * 
	 */
//	public static  Object showLoginInterface(){
//		if(PlayManagement == null){
//			PlayManagement = new PlayManagement();
//		}
//		return "34565";
//	}
//@Override
//public void actionPerformed(ActionEvent e) {
//	// TODO Auto-generated method stub
////	if (e.getSource() == btnCancel) {
////		rst=false;
////		this.setVisible(false);
////	} else if (e.getSource() == btnSave) {
////		btnSaveClicked();
////	}
//}

}
