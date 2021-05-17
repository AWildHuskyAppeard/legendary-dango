package chat;

import java.io.Serializable;

public class ChatVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5659132712338439027L;
	
	private Integer c_ID;
	private String c_Date, c_Class, c_Title, c_Conts, u_ID;
	
	public Integer getC_ID() {
		return c_ID;
	}


	public void setC_ID(Integer c_ID) {
		this.c_ID = c_ID;
	}


	public String getC_Date() {
		return c_Date;
	}


	public void setC_Date(String c_Date) {
		this.c_Date = c_Date;
	}


	public String getC_Class() {
		return c_Class;
	}


	public void setC_Class(String c_Class) {
		this.c_Class = c_Class;
	}


	public String getC_Title() {
		return c_Title;
	}


	public void setC_Title(String c_Title) {
		this.c_Title = c_Title;
	}


	public String getC_Conts() {
		return c_Conts;
	}


	public void setC_Conts(String c_Conts) {
		this.c_Conts = c_Conts;
	}


	public String getU_ID() {
		return u_ID;
	}


	public void setU_ID(String u_ID) {
		this.u_ID = u_ID;
	}


	@Override
	public String toString() {
		return "<tr><td>"+c_ID+"</td><td id=\"class\">"+c_Class + "</td><td><b>" + c_Title + "</td><td id=\"time\">" + c_Date + "</td></tr>";
	}

}
