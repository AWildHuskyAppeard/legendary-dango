package question;

// DAO: Database Access Object
// 專責與Dept Table之新增,修改,刪除與查詢

import java.sql.*;
import java.util.ArrayList;

public class QuesDAO {

	private Connection conn;

	// 建構子
	public QuesDAO(Connection conn) {
		this.conn = conn;
	}

	//新增
	public boolean insertQues(QuesBean QuesData) {
		boolean isInsert = false;

//	public int insertQues(int Q_ID, String Q_Type, String Q_Ques, String Q_Selection, String Q_Ans, String P_Class) {
		try {
//			int Q_ID = 1;
			/*
			 * String sqlString
			 * ="INSERT INTO Questions(Q_ID,Q_Type,Q_Ques,Q_Selection,Q_Ans,P_Class) " +
			 * "VALUES(" + Q_ID + ",'" + Q_Type+ "', N'" + Q_Ques+ "',N'" + Q_Selection+
			 * "','" + Q_Ans+ "','" + P_Class+ "')";
			 */
			String sqlString = "INSERT INTO Questions(Q_ID,Q_Type,Q_Ques,Q_Selection,Q_Ans,P_Class) " + "VALUES("
					+ QuesData.getQ_ID() + ",'" + QuesData.getQ_Type() + "', N'" + QuesData.getQ_Ques() + "',N'"
					+ QuesData.getQ_Selection() + "',N'" + QuesData.getQ_Ans() + "','" + QuesData.getP_Class() + "')";

			Statement stmt = conn.createStatement();
			System.out.println(sqlString);
//			stmt.executeUpdate(sqlString);

			int i = stmt.executeUpdate(sqlString);
			if (i > 0) {
				isInsert = true;
			}
			stmt.close();
		} catch (Exception e) {
			System.err.println("建立資料時發生錯誤:" + e);
			isInsert = false;
		}
			return isInsert;
	}

//   	    "SELECT dept_id.nextval FROM DUAL"; ??
//			Statement stmt = conn.createStatement();
//			// 自取號機取得新部門的部門代號
//			ResultSet rs = stmt.executeQuery(sqlString);
//			
//
//			if (rs.next())
//				deptno = rs.getInt(1);
//
//			rs.close();
//
//			// 新增部門到Dept Table
//			sqlString = "INSERT INTO dept(deptno,dname) " + "VALUES(" + deptno + ",'" + dname + "')";
//			stmt.executeUpdate(sqlString);
//			stmt.close();
//			return deptno;
//		} catch (Exception e) {
//			System.err.println("建立部門時發生錯誤:" + e);
//			return -1;
//		}
//	}

	
	// 刪除
	public boolean deleteQues(int Q_ID) {
		try {
			String sqlString = "DELETE FROM Questions " + "WHERE Q_ID = " + Q_ID;
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

	// 更改
	public boolean updateQues(QuesBean QuesData) {
		try {
			String sqlString = "UPDATE Questions " + "SET Q_ID =" + QuesData.getQ_ID() + ", Q_Type= '"
					+ QuesData.getQ_Type() + "' , Q_Ques=N'" + QuesData.getQ_Ques() + "', Q_Selection =N'"
					+ QuesData.getQ_Selection() + "', Q_Ans=N'" + QuesData.getQ_Ans() + "', P_Class='"
					+ QuesData.getP_Class() + "' WHERE Q_ID=" + QuesData.getQ_ID();
			System.out.println(sqlString);

			Statement stmt = conn.createStatement();
			int updatecount = stmt.executeUpdate(sqlString);
			stmt.close();
			if (updatecount >= 1) {
				return true;
			}

			else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("更新資料時發生錯誤:" + e);
			return false;
		}
	}

	// 搜尋
	public QuesBean findQues(int Q_ID) {
		try {
			QuesBean que = null;

			String Q_Type;
			String Q_Ques;
			String Q_Selection;
			String Q_Ans;
			String P_Class;

			Statement stmt = conn.createStatement();
			String sqlString = "SELECT * " + "FROM Questions WHERE Q_ID = " + Q_ID;

			ResultSet rs = stmt.executeQuery(sqlString);

			if (rs.next()) {
				Q_Type = rs.getString("Q_Type");
				Q_Ques = rs.getString("Q_Ques");
				Q_Selection = rs.getString("Q_Selection");
				Q_Ans = rs.getString("Q_Ans");
				P_Class = rs.getString("P_Class");

				que = new QuesBean(Q_ID, Q_Type, Q_Ques, Q_Selection, Q_Ans, P_Class);
			}
			rs.close();
			stmt.close();
			return que;

		} catch (Exception e) {
			System.err.println("尋找資料時發生錯誤:" + e);
			return null;
		}
	}
	
	public ArrayList<QuesBean> findAllQuesBean() {
		// 取出結果集資料
		ArrayList<QuesBean> allQuesBean = new ArrayList<>();
		// 準備儲存輸出對象的容器
		
		try {
			Statement stmt = conn.createStatement();
			String sqlString = " select * from Questions";
			System.out.println(sqlString);
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				QuesBean quesBean = new QuesBean();
				quesBean.setQ_ID(rs.getInt(1));
				quesBean.setQ_Type(rs.getString(2));
				quesBean.setQ_Ques(rs.getString(3));
				quesBean.setQ_Selection(rs.getString(4));
				quesBean.setQ_Ans(rs.getString(5));
				quesBean.setP_Class(rs.getString(6));

				allQuesBean.add(quesBean);

			}
			conn.close();// 歸還資源//非釋放
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allQuesBean;
	}

}