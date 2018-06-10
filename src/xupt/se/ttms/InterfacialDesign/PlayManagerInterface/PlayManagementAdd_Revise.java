package xupt.se.ttms.InterfacialDesign.PlayManagerInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import xupt.se.ttms.model.Play;
import xupt.se.ttms.service.PlaySrv;

public class PlayManagementAdd_Revise extends PlayManagement implements ActionListener {
	protected boolean rst=false; 
	private JButton saveBtn, cancelBtn;
	private Play play_;
	
	
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
		ImageIcon imageIcon = new ImageIcon("D:\\littleDom\\JavaLanguageDesign\\TTMS_RYT_picture\\"+play.getPlayID()+".png");
		imageBtn.setIcon(imageIcon);
		play_ = play;
		this.invalidate();
	}
	
	
	@Override
	protected void setpanel() {
		// TODO Auto-generated method stub
		
		JPanel panel = getPanel();
		
	    saveBtn = new JButton("save information");
		saveBtn.setBounds(0,20,30,30);
		panel.add(saveBtn);
		
	    cancelBtn = new JButton("cancel");
		cancelBtn.setBounds(0,40,30,30);
		panel.add(cancelBtn);
	}
	
	public boolean getReturnStatus(){
		   return rst;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == saveBtn){
			
		}
		else if(e.getSource() == cancelBtn){
			rst = false;
		}
	}
	
//	protected void saveBtnClicked() {
//		PlaySrv playSrv = new PlaySrv();
//		Play play = new Play();
//		
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == btnCancel) {
//			rst=false;
//			this.setVisible(false);
//		} else if (e.getSource() == btnSave) {
//			btnSaveClicked();
//		}
//	}
//	
//	protected void btnSaveClicked(){
//		if (txtName.getText() != null && txtRow.getText() != null
//				&& txtColumn.getText() != null) {
//			StudioSrv stuSrv = new StudioSrv();
//			Studio stu=new Studio();
//			stu.setName(txtName.getText());
//			stu.setRowCount(Integer.parseInt(txtRow.getText()));
//			stu.setColCount(Integer.parseInt(txtColumn.getText()));
//			stu.setIntroduction(txtIntro.getText());
//
//			stuSrv.add(stu);
//			this.setVisible(false);
//			rst=true;
//		} else {
//			JOptionPane.showMessageDialog(null, "数据不完整");
//		}		
//	}

}
