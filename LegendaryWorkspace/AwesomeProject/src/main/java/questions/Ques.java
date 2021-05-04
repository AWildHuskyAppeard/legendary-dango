// Value Object:一個Object代表Dept Table一筆Row

import java.io.*;

public class Ques implements Serializable{

    private int Q_ID;
    private String Q_Ques;
 
    //Constructor
    public Ques(int Q_ID, String Q_Ques) {
      this.Q_ID = Q_ID;
      this.Q_Ques = Q_Ques;
    }

    public int getQ_ID() {
      return this.Q_ID ;
    }

    public String getQ_Ques() {
      return this.Q_Ques ;
    }

    public void setQ_Ques(String Q_Ques) {
      this.Q_Ques = Q_Ques;
    }

}