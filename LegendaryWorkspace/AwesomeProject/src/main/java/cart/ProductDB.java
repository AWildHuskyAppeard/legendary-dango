package cart;

import java.io.Serializable;

public class ProductDB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static String[] P_ID; // PK
	private static String[] P_Name;
	private static String[] P_Class;
	private static Integer[] P_Price; 
	private static String[] P_DESC; 
	private static String[] U_ID; // FK
	private static String[] P_Img; 
	private static String[] P_Video;
	
	public static String[] getP_ID() {		return P_ID;	}
	public static void setP_ID(String[] p_ID) {		P_ID = p_ID;	}
	public static String[] getP_Name() {		return P_Name;	}
	public static void setP_Name(String[] p_Name) {		P_Name = p_Name;	}
	public static String[] getP_Class() {		return P_Class;	}
	public static void setP_Class(String[] p_Class) {		P_Class = p_Class;	}
	public static Integer[] getP_Price() {		return P_Price;	}
	public static void setP_Price(Integer[] p_Price) {		P_Price = p_Price;	}
	public static String[] getP_DESC() {		return P_DESC;	}
	public static void setP_DESC(String[] p_DESC) {		P_DESC = p_DESC;	}
	public static String[] getU_ID() {		return U_ID;	}
	public static void setU_ID(String[] u_ID) {		U_ID = u_ID;	}
	public static String[] getP_Img() {		return P_Img;	}
	public static void setP_Img(String[] p_Img) {		P_Img = p_Img;	}
	public static String[] getP_Video() {		return P_Video;	}
	public static void setP_Video(String[] p_Video) {		P_Video = p_Video;	}

	
	
	

}
