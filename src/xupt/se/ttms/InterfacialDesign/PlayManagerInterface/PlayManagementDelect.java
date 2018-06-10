package xupt.se.ttms.InterfacialDesign.PlayManagerInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import xupt.se.ttms.model.Play;
 public class PlayManagementDelect extends PlayManagement{

	private JButton delectBtn;
	private JButton cancelBtn;
	private Play play_;
	
	@Override
	protected void setpanel() {
		// TODO Auto-generated method stub
		JPanel panel = getPanel();
		
		delectBtn = new JButton("delect information");
		delectBtn.setBounds(0,20,30,30);
		delectBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(delectBtn);
		
		cancelBtn = new JButton("cancel");
		cancelBtn.setBounds(0,40,30,30);
		panel.add(cancelBtn);
		
	}

	public Void PlayresiveUI(Play play) {
		initdata(play);
		return null;
	}
	public void initdata(Play play) {
		if(play == null) 
			return;
		typetextfeild.setText(Integer.toString(play.getPlaytypeID()));
		languagetextfeild.setText(Integer.toString(play.getPlaylangID()));
		nametextfeild.setText(play.getPlayName());
		timetextfeild.setText(Integer.toString(play.getPlaylength()));
		String value = String.valueOf(play.getPlayticketprice());
		pricetextfeild.setText(value);
		statustextfeild.setText(Integer.toString(play.getPlaystatus()));
		textArea.setText(play.getPlayintroduction());
		ImageIcon imageIcon = new ImageIcon("D:\\littleDom\\JavaLanguageDesign\\TTMS_RYT_picture\\"+play.getPlaytypeID()+".png");
		imageBtn.setIcon(imageIcon);
//		imageBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ImageIcon image = new ImageIcon("../TTMS_RYT_PROJECT/resource/image/Main_Background.jpg");
//				imageBtn.setIcon(image);
//			}
//		});
		play_ = play;
		this.invalidate();
	}
	
   public static void main(String[] args) {
		PlayManagementDelect playManagementDelect = new PlayManagementDelect();
	    playManagementDelect.setVisible(true);
	}


}
