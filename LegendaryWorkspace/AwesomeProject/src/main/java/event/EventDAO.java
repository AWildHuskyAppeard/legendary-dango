import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class EventDAO {
	private Connection conn;

	// 建構子
	public EventDAO(Connection conn) {
		this.conn = conn;
	}

	public boolean insertDept(EventBean EventBean) {
		boolean isInsert=false;
		try {
		

//			int deptno = 1;
//			String sqlString = "SELECT dept_id.nextval FROM DUAL";
//			Statement stmt = conn.createStatement();
//			// 自取號機取得新部門的部門代號
//			ResultSet rs = stmt.executeQuery(sqlString);
//
//			if (rs.next())
//				deptno = rs.getInt(1);
//
//			rs.close();

			// 新增部門到Dept Table
			String sqlString = "INSERT INTO Event_1(UID,AID,ANAME,ADATE,ACOIN) " + "VALUES(" + EventBean.getUid() + ",'" + EventBean.getAid()+ "','" + EventBean.getAname()+ "','" + EventBean.getAdate()+ "','" + EventBean.getAcoin() + "')";
			Statement stmt = conn.createStatement();
			System.out.println(sqlString);
//			stmt.executeUpdate(sqlString);
			
			int i=stmt.executeUpdate(sqlString);
			if (i>0) {
				isInsert=true;
			}
			stmt.close();
		} catch (Exception e) {
			System.err.println("建立部門時發生錯誤:" + e);
			isInsert=false;
		}
		return isInsert;
	}

	// 刪除部門
	public boolean deleteDept(int Uid) {
		try {
			String sqlString = "DELETE FROM Event_1 " + "WHERE UID = " + Uid;
			Statement stmt = conn.createStatement();
			int deletecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (deletecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.err.println("刪除部門時發生錯誤: " + e);
			return false;
		}
	}

	// 更新部門資料
	public boolean updateDept(EventBean EventBean) {
		try {
			String sqlString = "UPDATE Event_1 " + "SET ANAME = '" + EventBean.getAname() + "' " + "WHERE UID = "
					+ EventBean.getUid();
            System.out.println(sqlString);
			Statement stmt = conn.createStatement();
			int updatecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (updatecount >= 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.err.println("更新部門資料時發生錯誤:" + e);
			return false;
		}
	}

	// 尋找部門資料
	public EventBean findDept(int Uid) {
		try {
			EventBean dep = null;
			 
			String Aname;
			String Aid;
			String Adate ;
			String Acoin;
			
			Statement stmt = conn.createStatement();
			String sqlString = "SELECT * " + "FROM Event_1 WHERE UID = " + Uid;
			System.out.println(sqlString);
			ResultSet rs = stmt.executeQuery(sqlString);

			if (rs.next()) {
				Aname = rs.getString("Aname");
				Aid   = rs.getString("Aid");
				Adate = rs.getString("Adate");
				Acoin = rs.getString("Acoin");
				
				dep = new EventBean(Uid,Aname,Aid,Acoin,Adate);
			}
			rs.close();
			stmt.close();
			return dep;

		} catch (Exception e) {
			System.err.println("尋找部門資料時發生錯誤:" + e);
			return null;
		}
	}

}
