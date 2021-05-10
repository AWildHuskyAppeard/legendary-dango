package event;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import event.EventBeanpag.EventBean;

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
			String sqlString = "INSERT INTO Event(UID,AID,ANAME,ADATE,ACOIN) " + "VALUES(" + EventBean.getUid() + ",'" + EventBean.getAid()+ "','" + EventBean.getAname()+ "','" + EventBean.getAdate()+ "','" + EventBean.getAcoin() + "')";
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
			String sqlString = "DELETE FROM Event " + "WHERE UID = " + Uid;
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
			String sqlString = "UPDATE Event " + 
		"SET ANAME = '" + EventBean.getAname() + "' " 
		  +","  + "UID = '" + EventBean.getUid() + "'"
		  +","  + "AID = '" + EventBean.getAid() + "'"
		  +","  + "ADATE = '" + EventBean.getAdate() + "'"
		  +","  + "ACOIN = '" + EventBean.getAcoin() + "'"
		+ "WHERE UID = "
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
			int uid;
			String aname;
			String aid;
			String adate ;
			String acoin;
			
			Statement stmt = conn.createStatement();
			String sqlString = "SELECT * " + "FROM Event WHERE UID = " + Uid;
			System.out.println(sqlString);
			ResultSet rs = stmt.executeQuery(sqlString);

			if (rs.next()) {
				uid = rs.getInt("Uid");
				aname = rs.getString("Aname");
				aid   = rs.getString("Aid");
				adate = rs.getString("Adate");
				acoin = rs.getString("Acoin");
				
				dep = new EventBean(uid,aname,aid,adate,acoin);
			}
			rs.close();
			stmt.close();
			return dep;

		} catch (Exception e) {
			System.err.println("尋找部門資料時發生錯誤:" + e);
			return null;
		}
	}
	public ArrayList<EventBean> findAllEventBean() {
		// 取出結果集資料
		ArrayList<EventBean> allEventBean = new ArrayList<>();
		// 準備儲存輸出對象的容器
		
		try {
			Statement stmt = conn.createStatement();
			String sqlString = " select * from Event";
			System.out.println(sqlString);
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				EventBean EventBean = new EventBean();
				EventBean.setUid(rs.getInt(1));
				EventBean.setAid(rs.getString(2));
				EventBean.setAname(rs.getString(3));
				EventBean.setAdate(rs.getString(4));
				EventBean.setAcoin(rs.getString(5));
				allEventBean.add(EventBean);

			}
			conn.close();// 歸還資源//非釋放
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allEventBean;
	}

}
