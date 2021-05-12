package chat;

import java.io.Serializable;

public class ChatVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5659132712338439027L;
	
	private Integer C_ID;
	private String C_Date, C_Class, C_Title, C_Conts, U_ID;
	
	public Integer getC_ID() {
		return C_ID;
	}
	public void setC_ID(Integer c_ID) {
		C_ID = c_ID;
	}
	public String getC_Date() {
		return C_Date;
	}
	public void setC_Date(String c_Date) {
		C_Date = c_Date;
	}
	public String getC_Class() {
		return C_Class;
	}
	public void setC_Class(String c_Class) {
		C_Class = c_Class;
	}
	public String getC_Title() {
		return C_Title;
	}
	public void setC_Title(String c_Title) {
		C_Title = c_Title;
	}
	public String getC_Conts() {
		return C_Conts;
	}
	public void setC_Conts(String c_Conts) {
		C_Conts = c_Conts;
	}
	public String getU_ID() {
		return U_ID;
	}
	public void setU_ID(String u_ID) {
		U_ID = u_ID;
	}
	
	@Override
	public String toString() {
		return "<tr><td>"+C_ID+"</td><td id=\"class\">"+C_Class + "</td><td><b>" + C_Title + "</td><td id=\"time\">" + C_Date + "</td></tr>";
	}

}
