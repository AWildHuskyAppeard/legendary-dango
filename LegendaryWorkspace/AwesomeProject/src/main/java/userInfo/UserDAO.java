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
			String sqlString = "INSERT INTO [User_Info] (U_ID, U_Psw, U_Birthday, U_LastName, U_FirstName, U_Email, U_Tel, U_Sex, U_Address)"
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
		String updateColSqlString="";
		/*
		String sqlString = "UPDATE [User_Info_v1]\r\n" //測試
						 + "   SET [U_Birthday] = ?"
						 + " WHERE [U_ID] = 1";*/
		String sqlString = "UPDATE [User_Info]\r\n"
				+ "   SET "+updateColSqlString +" = ?"
				+ " WHERE [U_ID] = 1";
//		String d = "2011-12-12";
//		String d = updateData.getU_BirthDay();
		
		/*
		PreparedStatement prestmt;
		try {
			prestmt = conn.prepareStatement(sqlString);
			prestmt.setString(1, d);
			int upNum = prestmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*   //之後用preparedstatement拿user id的參數 & session 取user id
		 * 		String sqlString = "UPDATE [User_Info_v1]\r\n"
								 + "   SET " + updateColSqlString + " = ?\r\n"
								 + " WHERE [U_ID] = ?";
		 * */
			
		PreparedStatement pstmt;
		
			String u_BirthDay = updateData.getU_BirthDay();
			String u_LastName = updateData.getU_LastName();
			String u_FirstName = updateData.getU_FirstName();
			String u_Email = updateData.getU_Email();
			String u_Tel = updateData.getU_Tel();
			String u_Sex = updateData.getU_Sex();
			String u_Address = updateData.getU_Address();
//			pstmt.setString(1, /*之後用輸入user id來取值*/);
//			int updateCount = pstmt.executeUpdate();
			int updateCount = 0;
			
			if (u_BirthDay != null) {
				System.out.println(u_BirthDay);
				updateColSqlString = "[U_Birthday]";
				sqlString = "UPDATE [User_Info]\r\n"
						+ "   SET "+updateColSqlString +" = ?"
						+ " WHERE [U_ID] = 1";
				System.out.println(updateColSqlString);
				try {
					pstmt = conn.prepareStatement(sqlString);
					System.out.println(sqlString);
					pstmt.setString(1,u_BirthDay);
					int ct = pstmt.executeUpdate();
					if (ct>0) {
						updateCount++;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (u_LastName != null) {
				System.out.println(u_LastName);
				updateColSqlString = "[U_LastName]";
				sqlString = "UPDATE [User_Info]\r\n"
						+ "   SET "+updateColSqlString +" = ?"
						+ " WHERE [U_ID] = 1";
				System.out.println(updateColSqlString);
				try {
					pstmt = conn.prepareStatement(sqlString);
					System.out.println(sqlString);
					pstmt.setString(1,u_LastName);
					int ct = pstmt.executeUpdate();
					if (ct>0) {
						updateCount++;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (u_FirstName != null) {
				System.out.println(u_FirstName);
				updateColSqlString = "[U_FirstName]";
				sqlString = "UPDATE [User_Info]\r\n"
						+ "   SET "+updateColSqlString +" = ?"
						+ " WHERE [U_ID] = 1";
				System.out.println(updateColSqlString);
				try {
					pstmt = conn.prepareStatement(sqlString);
					System.out.println(sqlString);
					pstmt.setString(1,u_FirstName);
					int ct = pstmt.executeUpdate();
					if (ct>0) {
						updateCount++;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (u_Email != null) {
				System.out.println(u_Email);
				updateColSqlString = "[U_Email]";
				sqlString = "UPDATE [User_Info]\r\n"
						+ "   SET "+updateColSqlString +" = ?"
						+ " WHERE [U_ID] = 1";
				System.out.println(updateColSqlString);
				try {
					pstmt = conn.prepareStatement(sqlString);
					System.out.println(sqlString);
					pstmt.setString(1,u_Email);
					int ct = pstmt.executeUpdate();
					if (ct>0) {
						updateCount++;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (u_Tel != null) {
				System.out.println(u_Tel);
				updateColSqlString = "[U_Tel]";
				sqlString = "UPDATE [User_Info]\r\n"
						+ "   SET "+updateColSqlString +" = ?"
						+ " WHERE [U_ID] = 1";
				System.out.println(updateColSqlString);
				try {
					pstmt = conn.prepareStatement(sqlString);
					System.out.println(sqlString);
					pstmt.setString(1,u_Tel);
					int ct = pstmt.executeUpdate();
					if (ct>0) {
						updateCount++;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (u_Sex != null) {
				System.out.println(u_Sex);
				updateColSqlString = "[U_Sex]";
				sqlString = "UPDATE [User_Info]\r\n"
						+ "   SET "+updateColSqlString +" = ?"
						+ " WHERE [U_ID] = 1";
				System.out.println(updateColSqlString);
				try {
					pstmt = conn.prepareStatement(sqlString);
					System.out.println(sqlString);
					pstmt.setString(1,u_Sex);
					int ct = pstmt.executeUpdate();
					if (ct>0) {
						updateCount++;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (u_Address != null) {
				System.out.println(u_Address);
				updateColSqlString = "[U_Address]";
				sqlString = "UPDATE [User_Info]\r\n"
						+ "   SET "+updateColSqlString +" = ?"
						+ " WHERE [U_ID] = 1";
				System.out.println(updateColSqlString);
				try {
					pstmt = conn.prepareStatement(sqlString);
					System.out.println(sqlString);
					pstmt.setString(1,u_Address);
					int ct = pstmt.executeUpdate();
					if (ct>0) {
						updateCount++;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}

			if (updateCount > 0) {
				isUpdate = true;
			}
			System.out.println(updateCount);
		return isUpdate;
	}
	
}
