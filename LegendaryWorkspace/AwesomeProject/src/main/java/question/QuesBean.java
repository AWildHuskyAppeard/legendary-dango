package question;

// Value Object:一個Object代表Dept Table一筆Row

import java.io.*;

public class QuesBean {

    private int q_ID;
    private String q_Type;
    private String q_Ques;
    private String q_Selection;
    private String q_Ans;
    private String p_Class;
    
    //Constructor
    public QuesBean(int Q_ID, String Q_Type, String Q_Ques, String Q_Selection, String Q_Ans, String P_Class) {
      this.q_ID = Q_ID;
      this.q_Type = Q_Type;
      this.q_Ques = Q_Ques;
      this.q_Selection = Q_Selection;
      this.q_Ans = Q_Ans;
      this.p_Class = P_Class;
    

    }
    public QuesBean() {
    	
    	
    }
	public int getQ_ID() {
		return q_ID;
	}
	public void setQ_ID(int q_ID) {
		this.q_ID = q_ID;
	}
	public String getQ_Type() {
		return q_Type;
	}
	public void setQ_Type(String q_Type) {
		this.q_Type = q_Type;
	}
	public String getQ_Ques() {
		return q_Ques;
	}
	public void setQ_Ques(String q_Ques) {
		this.q_Ques = q_Ques;
	}
	public String getQ_Selection() {
		return q_Selection;
	}
	public void setQ_Selection(String q_Selection) {
		this.q_Selection = q_Selection;
	}
	public String getQ_Ans() {
		return q_Ans;
	}
	public void setQ_Ans(String q_Ans) {
		this.q_Ans = q_Ans;
	}
	public String getP_Class() {
		return p_Class;
	}
	public void setP_Class(String p_Class) {
		this.p_Class = p_Class;
	}
	
    
   
 

//
//    public int getQ_ID() {
//      return this.Q_ID ;
//    }
//
//    public String getQ_Ques() {
//      return this.Q_Ques ;
//    }
//
//    public void setQ_Ques(String Q_Ques) {
//      this.Q_Ques = Q_Ques;
//    }

}