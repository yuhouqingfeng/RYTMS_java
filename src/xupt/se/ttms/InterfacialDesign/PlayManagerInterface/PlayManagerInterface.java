package xupt.se.ttms.InterfacialDesign.PlayManagerInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.Blob;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import xupt.se.ttms.InterfacialDesign.Main_Interface;
import xupt.se.ttms.model.Play;
import xupt.se.ttms.model.Studio;
import xupt.se.ttms.service.PlaySrv;
import xupt.se.ttms.service.StudioSrv;


class ColorTableCellRenderer extends DefaultTableCellRenderer {
	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	 public Component getTableCellRendererComponent(JTable table, Object value,  
		        boolean isSelected, boolean hasFocus, int row, int column) {
		 int s = row +1;
		 int w = Integer.parseInt(table.getValueAt(row, 0).toString());
		 if(column == 5) {
			 return new JLabel(new ImageIcon("D:\\littleDom\\JavaLanguageDesign\\TTMS_RYT_picture\\"+w+".png"));
		 }else{
			 return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		 }
	 }
}
class  SetTable {
	private JTable table = null;
	
	public  SetTable (JPanel panel) {
		DefaultTableModel tabModel=new DefaultTableModel(){
			private static final long serialVersionUID = 1L;

			@Override              
			public boolean isCellEditable(int row,int column){
				return false;              
			};
		};
		
		tabModel.addColumn("Play_ID");
		tabModel.addColumn("Play_type_id");
		tabModel.addColumn("Play_lang_id");
		tabModel.addColumn("Play_Name");
		tabModel.addColumn("Play_introduction");
		tabModel.addColumn("Play_image");
		tabModel.addColumn("Play_length");
		tabModel.addColumn("Play_ticket_price");
		tabModel.addColumn("Play_status");
		table = new JTable(tabModel);
		table.setOpaque(false);
		
		//设置各列的宽度
	    TableColumnModel columnModel = table.getColumnModel();
	    
	    //隐藏ID这一列
        TableColumn column = columnModel.getColumn(1);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(1);

        column = columnModel.getColumn(0);
        column.setPreferredWidth(20);
        column = columnModel.getColumn(2);
        column.setPreferredWidth(20);
        column = columnModel.getColumn(3);
        column.setPreferredWidth(100);
        column = columnModel.getColumn(4);
        column.setPreferredWidth(300);      
        column = columnModel.getColumn(5);
        column.setPreferredWidth(200);   
        column = columnModel.getColumn(6);
        column.setPreferredWidth(50);  
        column = columnModel.getColumn(7);
        column.setPreferredWidth(50);  
        column = columnModel.getColumn(8);
        column.setPreferredWidth(50);  

		
		table.setBounds(0,0,1000,800);
		table.setGridColor(Color.black);
		table.setRowHeight(150);
		panel.add(table);
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		TableCellRenderer renderer = new ColorTableCellRenderer();
		table.setDefaultRenderer(Object.class, renderer);
		
	}

	public Play getPlay() {
		int rowSel = table.getSelectedRow();
		if(rowSel >= 0) {
			Play play = new Play();
			play.setPlayID(Integer.parseInt(table.getValueAt(rowSel, 0).toString()));
			play.setPlaytypeid(Integer.parseInt(table.getValueAt(rowSel, 1).toString()));
			play.setPlaylangID(Integer.parseInt(table.getValueAt(rowSel, 2).toString()));
			play.setPlayName(table.getValueAt(rowSel, 3).toString());
			play.setPlayintroduction(table.getValueAt(rowSel, 4).toString());
			
			if (table.getValueAt(rowSel, 5) == null)
				play.setPlayimage(null);
			
			play.setPlaylength(Integer.parseInt(table.getValueAt(rowSel, 6).toString()));
			play.setPlayticketprice(Float.parseFloat(table.getValueAt(rowSel,7).toString()));
			play.setPlaystatus(Integer.parseInt(table.getValueAt(rowSel, 8).toString()));
			
			return play;
		}
		else {
			return null;
		}
	}
	
	// 创建JTable
		public void showPlayList(List<Play> PlayList) {
			try {
				DefaultTableModel tabModel = (DefaultTableModel) table.getModel();
				tabModel.setRowCount(0);
				
				Iterator<Play> itr = PlayList.iterator();
				while (itr.hasNext()) {
					Play play = itr.next();
					Object data[] = new Object[9];
					data[0] = Integer.toString(play.getPlayID());
					data[1] = Integer.toString(play.getPlaytypeID());
					data[2] = Integer.toString(play.getPlaylangID());
					data[3] = play.getPlayName();
					data[4] = play.getPlayintroduction();
//					data[5] = play.getPlayimage().getBinaryStream();
					data[6] = Integer.toString(play.getPlaylength());
					data[7] = Float.toString(play.getPlayticketprice());
					data[8] = Integer.toString(play.getPlaystatus());
					tabModel.addRow(data);;
				}
				table.invalidate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
}

public class PlayManagerInterface  extends Main_Interface{
	private JTable table;
//	private TableModel model;
	private SetTable tableList;
	
	
	@Override
	protected void setMenu() {
		// TODO Auto-generated method stub
		JTabbedPane Menu = getMenu();
		Menu.setBounds(30, 190,1130,500);
		JPanel panel = new JPanel();
		panel.setBounds(30,190,1130,500);
		panel.setLayout(null);
		
        tableList = new SetTable(panel);
        showTable();

		JButton AddBtn = new JButton("Add Repertoire");
		AddBtn.setBounds(1000,20,130,80);
		panel.add(AddBtn);
		
		
		AddBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	 
				 PlayManagementAdd_Revise playManagementAdd_Revise = new PlayManagementAdd_Revise();
	              playManagementAdd_Revise.setVisible(true);
			}
		}); 
		
		JButton DeleteBtn = new JButton("Delete Repertoire");
		DeleteBtn.setBounds(1000,120,130,80);
		panel.add(DeleteBtn);
		DeleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Play play = tableList.getPlay();
				if(play == null) {
					JOptionPane.showMessageDialog(null, "请选择要删除的剧目");
					return;
				}
				PlayManagementDelect playManagementDelect = new PlayManagementDelect();
				playManagementDelect.initdata(play);
			    playManagementDelect.setVisible(true);
				int confirm = JOptionPane.showConfirmDialog(null, "确认删除所选","删除",JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
					PlaySrv playSrv = new PlaySrv();
					playSrv.delete(play.getPlayID());
					showTable();
				}
			}
		}); 
		JButton ReviseBtn = new JButton("Revise Repertoire");
		ReviseBtn.setBounds(1000,220,130,80);
		panel.add(ReviseBtn);
		ReviseBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Play play = tableList.getPlay();
				if(play == null) {
					JOptionPane.showMessageDialog(null, "请选择要修改的剧目");
					return;
				}
				 PlayManagementAdd_Revise playManagementAdd_Revise = new PlayManagementAdd_Revise();
				 playManagementAdd_Revise.initdata(play);
	              playManagementAdd_Revise.setVisible(true);
			}
		}); 
		
		Menu.add("PlayManager", panel);
	
	}
	private void showTable() {
    	 List<Play> playList = new  PlaySrv().FetchAll();
        tableList.showPlayList(playList);
	}
	public static void main(String[] args) {
		PlayManagerInterface interface1 = new PlayManagerInterface();
		interface1.setVisible(true);
	}

}
