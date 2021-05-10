package event.EventBeanpag;
import java.io.Serializable;
import java.sql.Date;

public class EventBean  {

	private int uid;
	private String aid;
	private String aname;
	private String adate;
	private String acoin;
	
	
	
	 public EventBean()
	  {
	  }
	
	
	public EventBean( int uid, String aname,String aid , String adate,String acoin) {
	      this.aname = aname;
	      this.uid = uid;
	      this.aid = aid ;
	      this.adate = adate ; 
	      this.acoin = acoin ;
	    }

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public String getAcoin() {
		return acoin;
	}

	public void setAcoin(String acoin) {
		this.acoin = acoin;
	}
	
	
}