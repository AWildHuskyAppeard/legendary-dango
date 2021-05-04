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
			PreparedStatement stmt = conn.prepareStatement(sqlString);
			
			System.out.println(sqlString); //print out sql語句
			
			int updatecount = stmt.executeUpdate();
			stmt.close();

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
	
}
