package xupt.se.ttms.model;

import com.mysql.jdbc.Blob;

public class Play {
	
	private int Play_ID=0 ; 
	private int Play_type_id=0 ; 
	private int Play_lang_id=0 ; 
	private String Play_Name="";
	private String Play_introduction="";
	private Blob Play_image= null;
	private int Play_length=0 ; 
	private float Play_ticket_price=0 ; 
	private int Play_status=0 ; 
	
	public void setPlayID(int ID){
		this.Play_ID=ID;
	}
	
	public int getPlayID(){
		return Play_ID;
	}
	public void setPlaytypeid(int ID){
		this.Play_type_id=ID;
	}
	
	public int getPlaytypeID(){
		return Play_type_id;
	}
	public void setPlaylangID(int ID){
		this.Play_lang_id=ID;
	}
	
	public int getPlaylangID(){
		return Play_lang_id;
	}
	
	public void setPlayName(String name){
		this.Play_Name=name;
	}
	
	public String getPlayName(){
		return Play_Name;
	}
	
	public void setPlayintroduction(String introduction){
		this.Play_introduction= introduction;
	}
	
	public String getPlayintroduction(){
		return Play_introduction;
	}
	public void setPlayimage(java.sql.Blob blob){
		this.Play_image=(Blob) blob;
	}
	
	public Blob getPlayimage(){
		return Play_image;
	}
	
	public void setPlaylength(int length){
		this.Play_length=length;
	}
	
	public int getPlaylength(){
		return Play_length;
	}
	public void setPlayticketprice(Float i){
		this.Play_ticket_price=i;
	}
	
	public float getPlayticketprice(){
		return Play_ticket_price;
	}
	public void setPlaystatus(int ID){
		this.Play_status=ID;
	}
	
	public int getPlaystatus(){
		return Play_status;
	}

	
}
