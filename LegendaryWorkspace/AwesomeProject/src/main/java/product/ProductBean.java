package learningWeb;

import java.io.Serializable;

public class ProductBean implements Serializable {
	
	private String P_ID;
	private String P_Name;
	private String P_Class;
	private int P_Price;
	private String P_DESC;
	private String P_Img;
	private String P_Video;
	private String U_ID;
	
	
	public String getP_ID() {
		return P_ID;
	}
	public void setP_ID(String p_ID) {
		P_ID = p_ID;
	}
	public String getP_Name() {
		return P_Name;
	}
	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}
	public String getP_Class() {
		return P_Class;
	}
	public void setP_Class(String p_Class) {
		P_Class = p_Class;
	}
	public int getP_Price() {
		return P_Price;
	}
	public void setP_Price(int p_Price) {
		P_Price = p_Price;
	}
	public String getP_DESC() {
		return P_DESC;
	}
	public void setP_DESC(String p_DESC) {
		P_DESC = p_DESC;
	}
	public String getP_Img() {
		return P_Img;
	}
	public void setP_Img(String p_Img) {
		P_Img = p_Img;
	}
	public String getP_Video() {
		return P_Video;
	}
	public void setP_Video(String p_Video) {
		P_Video = p_Video;
	}
	public String getU_ID() {
		return U_ID;
	}
	public void setU_ID(String u_ID) {
		U_ID = u_ID;
	}
	
	@Override
	public String toString() {
		return "/n課程名稱:"+ P_ID + "/t課程名稱:"+P_Name+"/t課程分類:"+P_Class+"/t課程價錢:"+P_Price+"/t課程敘述:"+P_DESC+"/t課程圖片"+P_Img+"/t課程影片"+P_Video+"/t使用者:"+U_ID;
	}
		
	

}
