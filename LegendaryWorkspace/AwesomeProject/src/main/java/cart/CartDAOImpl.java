package cart;
// 購物車的連線物件
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class CartDAOImpl implements CartDAO {
	private Connection conn;
	
	public CartDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean insertOrder(OrderBean orderBean) {
		boolean insertStatus = false;
		return insertStatus;
	}

	@Override
	public boolean selectOrder(OrderBean orderBean) {
		boolean selectStatus = false;
		String selectCmd = "SELECT * FROM [ORDER]"; // ***
		PreparedStatement pStmt;
		ResultSet rs;
		try {
			pStmt = conn.prepareStatement(selectCmd);
			rs = pStmt.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return selectStatus;
	}

	@Override
	public int updateOrder(OrderBean orderBean) {
		int updateStatus = 0;
		return updateStatus;
	}
/*  

   //�غc�l
  public StudentDAO(Connection conn) {
		this.conn = conn;
  }

 
  //�s�W�ǥ͸��
  public boolean insertStudent(StudentBean studentData) {
    try {
      String sqlString = "insert into jwstudent "
      						+ "values('"
	                  	   	+studentData.getId()+"','"
		                    +studentData.getName()+"','"
                            + studentData.getBirthyear()+"','"
                            + studentData.getBirthmonth()+"','"
                            + studentData.getBirthday()+"','" 
                            + studentData.getZipcode()+"','"
                            + studentData.getAddress()+"','"
                            + studentData.getPhone()+"','"
                            + studentData.getMailaddress()+ "')";
                           
      Statement stmt = conn.createStatement();
      System.out.println(sqlString); // 順便剛好檢查SQL語句本身有沒有錯
	  int updatecount = stmt.executeUpdate(sqlString);
      stmt.close();
      if (updatecount >= 1) return true;
      else                  return false;
	  } catch (Exception e) {
	    System.err.println("Oops? \n" + e);
		  return false;
    }
  }
 
 */
}
