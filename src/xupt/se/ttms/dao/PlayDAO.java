package xupt.se.ttms.dao;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Blob;

import xupt.se.ttms.idao.iPlayDAO;
import xupt.se.ttms.model.Play;
import xupt.se.util.DBUtil;

public class PlayDAO implements iPlayDAO{

	
	@Override
	public int insert(Play play) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Play play) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int ID) {
		int rtn=0;		
		try{
			String sql = "delete from  Play ";
			sql += " where play_id = " + ID;
			DBUtil db = new DBUtil();
			db.openConnection();
			rtn=db.execCommand(sql);
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;		
	}

	@Override
	public List<Play> select(String condt) {
		List<Play> playList = null;
		 playList = new LinkedList<Play>();
		 try {
			 String sql = "select play_id, play_type_id, play_lang_id,play_name, play_introduction, play_image,play_length,play_ticket_price,play_status from play ";
			 condt.trim();
			 if(!condt.isEmpty())
				 sql += " where " + condt;
			 DBUtil dbUtil = new DBUtil();
			 if(!dbUtil.openConnection()) {
				 System.out.print("fail to connect database");
				 return null;
			 }
			 
			 ResultSet rst = dbUtil.execQuery(sql);
			 if(rst != null) {
				 while(rst.next()) {
					 Play play = new Play();
					 play.setPlayID(rst.getInt("play_id"));
					 play.setPlaylangID(rst.getInt("play_lang_id"));
					 play.setPlaytypeid(rst.getInt("play_type_id"));
					 play.setPlayName(rst.getString("play_name"));
					 play.setPlayintroduction(rst.getString("play_introduction"));
					 Blob image_blob = (Blob) rst.getBlob("play_image");
					 play.setPlayimage(image_blob);
					 play.setPlaylength(rst.getInt("play_length"));
					 play.setPlayticketprice(rst.getFloat("play_ticket_price"));
					 play.setPlaystatus(rst.getInt("play_status"));
					 playList.add(play);
					 String string = "D:\\littleDom\\JavaLanguageDesign\\TTMS_RYT_picture\\"+rst.getInt("play_id")+".png";
					 InputStream iStream = image_blob.getBinaryStream();
					 DataOutputStream doStream = new DataOutputStream(new FileOutputStream(string));
					 byte[] outbyte = new byte[100];
					 while(iStream.read(outbyte) != -1){
						 doStream.write(outbyte);
					 }
 					 
//					 byte[] b = null;
//					 byte[] a = new byte[iStream.read(b, 0, b.length)];
//					 System.out.println(iStream.toString());
//					 play.setPlayimage("");
				 }
			 }
			 dbUtil.close(rst);
			 dbUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playList;
	}

}
