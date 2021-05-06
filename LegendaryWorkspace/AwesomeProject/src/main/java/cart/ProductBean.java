package cart;
// 暫時。之後換成product夾下的bean
import java.io.Serializable;

public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String P_ID; // PK
	private String P_Name;
	private String P_Class;
	private Integer P_Price; 
	private String P_DESC; 
	private String U_ID; // FK
	private String P_Img; 
	private String P_Video;
	
	public ProductBean() {	} // 
//	public ProductBean(String P_ID,	String P_Name, String P_Class, Integer P_Price,	String P_DESC,	String U_ID,	String P_Img, String P_Video) {
//		this.P_ID = P_ID;
//	}
	
	// getters
	public ProductBean(String p_ID, String p_Name, String p_Class, Integer p_Price, String p_DESC, String u_ID,
		String p_Img, String p_Video) {
		setP_ID       (p_ID   );
		setP_Name  (p_Name );
		setP_Class   (p_Class);
		setP_Price   (p_Price);
		setP_DESC  (p_DESC );
		setU_ID     (u_ID   );
		setP_Img    (p_Img  );
		setP_Video  (p_Video);
}                      
	public String getP_ID() {		return P_ID;	}
	public String getP_Name() {		return P_Name;	}
	public String getP_Class() {		return P_Class;	}
	public Integer getP_Price() {		return P_Price;	}
	public String getP_DESC() {		return P_DESC;	}
	public String getU_ID() {		return U_ID;	}
	public String getP_Img() {		return P_Img;	}
	public String getP_Video() {		return P_Video;	}
	// setters
	public void setP_ID(String p_ID) {		P_ID = p_ID;	}
	public void setP_Name(String p_Name) {		P_Name = p_Name;	}
	public void setP_Class(String p_Class) {		P_Class = p_Class;	}
	public void setP_Price(Integer p_Price) {		P_Price = p_Price;	}
	public void setP_DESC(String p_DESC) {		P_DESC = p_DESC;	}
	public void setU_ID(String u_ID) {		U_ID = u_ID;	}
	public void setP_Img(String p_Img) {		P_Img = p_Img;	}
	public void setP_Video(String p_Video) {		P_Video = p_Video;	}

	/*
	    課程編號	P_ID	nvarchar(20)
		課程名稱	P_Name	nvarchar(20)
		課程分類	P_Class	nvarchar(10)
		課程價錢	P_Pice	int
		課程介紹	P_DESC	nvarchar(MAX)
		課程老師	U_ID	nvarchar(20)
		課程圖片	P_Img	nvarchar(MAX)
		課程影片	P_Video	nvarchar(MAX)
	*/
	
	

}
