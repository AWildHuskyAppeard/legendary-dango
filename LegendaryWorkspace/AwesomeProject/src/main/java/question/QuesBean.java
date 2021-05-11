package question;

// Value Object:一個Object代表Dept Table一筆Row

import java.io.*;

public class QuesBean implements Serializable{

    private int Q_ID;
    private String Q_Type;
    private String Q_Ques;
    private String Q_Selection;
    private String Q_Ans;
    private String P_Class;
    
    //Constructor
    public QuesBean(int Q_ID, String Q_Type, String Q_Ques, String Q_Selection, String Q_Ans, String P_Class) {
      this.Q_ID = Q_ID;
      this.Q_Type = Q_Type;
      this.Q_Ques = Q_Ques;
      this.Q_Selection = Q_Selection;
      this.Q_Ans = Q_Ans;
      this.P_Class = P_Class;
    

    }
	
    
    public int getQ_ID() {
		return Q_ID;
	}
	public void setQ_ID(int q_ID) {
		Q_ID = q_ID;
	}
	public String getQ_Type() {
		return Q_Type;
	}
	public void setQ_Type(String q_Type) {
		Q_Type = q_Type;
	}
	public String getQ_Ques() {
		return Q_Ques;
	}
	public void setQ_Ques(String q_Ques) {
		Q_Ques = q_Ques;
	}
	public String getQ_Selection() {
		return Q_Selection;
	}
	public void setQ_Selection(String q_Selection) {
		Q_Selection = q_Selection;
	}
	public String getQ_Ans() {
		return Q_Ans;
	}
	public void setQ_Ans(String q_Ans) {
		Q_Ans = q_Ans;
	}
	public String getP_Class() {
		return P_Class;
	}
	public void setP_Class(String p_Class) {
		P_Class = p_Class;
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