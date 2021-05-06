import java.io.Serializable;
import java.sql.Date;

public class EventBean implements Serializable {

	private int Uid;
	private String Aid;
	private String Aname;
	private String Adate;
	private String Acoin;
	
	public EventBean( int Uid, String Aname,String Aid , String Adate,String Acoin) {
	      this.Aname = Aname;
	      this.Uid = Uid;
	      this.Aid = Aid ;
	      this.Adate = Adate ; 
	      this.Acoin = Acoin ;
	    }
	
	
	
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	public String getAid() {
		return Aid;
	}
	public void setAid(String aid) {
		Aid = aid;
	}
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public String getAdate() {
		return Adate;
	}
	public void setAdate(String adat) {
		Adate = adat;
	}
	public String getAcoin() {
		return Acoin;
	}
	public void setAcoin(String acoin) {
		Acoin = acoin;
	}

}
