package xupt.se.ttms.InterfacialDesign;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
/**
 * The main class for create a dialog window to user, in order to hint user
 * some error informations they commit, create the hint dialog needs call 
 * the constructor of class, it needs arguments which defined in class.
 * @author Aligreat
 *
 */
public class Error_Dialog extends JDialog{
	
	/**
	 * Use this parameter when the user enters a wrong account or password 
	 * when login.
	 */
	public static final int LOGIN_ERROR = 1;

	/**
	 * Use this parameter when the user enters a message error.
	 */
	public static final int INPUT_ERROR = 2;
	
	
	String Hint = "";
	
	public Error_Dialog(Frame base,int msg) throws Exception{
		super(base);
		switch (msg) {
			case LOGIN_ERROR:
				Hint = "Login failed, please try again.";
				break;
	
			case INPUT_ERROR:
				Hint = "Input error, please try again.";
				break;
				
			default:
				throw new Exception("Wrong arguments of construct methord of class Error_Dialog()");
		}
		
		setTitle("ERROR!");
		setIconImage(new ImageIcon("../TTMS_RYT_PROJECT/resource/image/errorIcon.jpg").getImage());
		setLayout(null);
		setBounds(700, 400, 350, 200);
		JLabel errMessage = new JLabel(Hint);
		errMessage.setBounds(50, 25, 1000, 25);
		errMessage.setFont(new Font("", Font.BOLD, 17));
		add(errMessage);
		JButton OK = new JButton("OK");
		OK.setBounds(110, 80, 100, 40);
		OK.addMouseListener(new MouseListener() {
			
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
				dispose();
			}
		});
		add(OK);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
