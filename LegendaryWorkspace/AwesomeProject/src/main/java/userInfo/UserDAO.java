package userInfo;

import java.sql.*;

public class UserDAO {
	
	private Connection conn;
	
	//建構子
	public UserDAO(Connection conn) {
		this.conn = conn;
	}
	
	//建立新的User(新增)
	public boolean createUser(UserBean userData) {
		try {
			String sqlString = "INSERT INTO User_Info_v1 (U_ID, U_Psw, U_Birthday, U_LastName, U_FirstName, U_Email, U_Tel, U_Sex, U_Address)"
							 + " VALUES ('"+userData.getU_ID()+"','"
							 + userData.getU_Psw()+"','"
							 + userData.getU_BirthDay()+"','"
							 + userData.getU_LastName()+"','"
							 + userData.getU_FirstName()+"','"
							 + userData.getU_Email()+"','"
							 + userData.getU_Tel()+"','"
							 + userData.getU_Sex()+"','"
							 + userData.getU_Address()+ "')";
			Statement cstmt = conn.createStatement();
//			PreparedStatement stmt = conn.prepareStatement(sqlString);
			
			System.out.println(sqlString); //print out sql語句
			
			int updatecount = cstmt.executeUpdate(sqlString);
			cstmt.close();

			if(updatecount>0) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			System.err.println("We have problems in creatUser method" + e);
			return false;
		}
		
		
	}
	
	// 修改會員資料
	public boolean updateUser(UserBean updateData) {
		boolean isUpdate = false;
		
		String updateColSqlString = "";
		String sqlString = "UPDATE [User_Info_v1]\r\n"
						 + "   SET " + updateColSqlString + " = ?\r\n"
						 + " WHERE [U_ID] = 1";
		/*   //之後用preparedstatement拿user id的參數 & session 取user id
		 * 		String sqlString = "UPDATE [User_Info_v1]\r\n"
								 + "   SET " + updateColSqlString + " = ?\r\n"
								 + " WHERE [U_ID] = ?";
		 * */
				
		
		try {
			String u_BirthDay = updateData.getU_BirthDay();
			String u_LastName = updateData.getU_LastName();
			String u_FirstName = updateData.getU_FirstName();
			String u_Email = updateData.getU_Email();
			String u_Tel = updateData.getU_Tel();
			String u_Sex = updateData.getU_Sex();
			String u_Address = updateData.getU_Address();
			PreparedStatement pstmt = conn.prepareStatement(sqlString);
//			pstmt.setString(1, /*之後用輸入user id來取值*/);
			
			if (u_BirthDay != null) {
				updateColSqlString = "[U_Birthday]";
				pstmt.setString(1, u_BirthDay);
			}
			if (u_LastName != null) {
				updateColSqlString = "[U_LastName]";
				pstmt.setString(1, u_LastName);
			}
			if (u_FirstName != null) {
				updateColSqlString = "[U_FirstName]";
				pstmt.setString(1, u_FirstName);
			}
			if (u_Email != null) {
				updateColSqlString = "[U_Email]";
				pstmt.setString(1, u_Email);
			}
			if (u_Tel != null) {
				updateColSqlString = "[U_Tel]";
				pstmt.setString(1, u_Tel);
			}
			if (u_Sex != null) {
				updateColSqlString = "[U_Sex]";
				pstmt.setString(1, u_Sex);
			}
			if (u_Address != null) {
				updateColSqlString = "[U_Address]";
				pstmt.setString(1, u_Address);
			}
			
			System.out.println(sqlString);
			
			int updateCount = pstmt.executeUpdate();
			if (updateCount > 0) {
				isUpdate = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isUpdate;
	}
	
}
