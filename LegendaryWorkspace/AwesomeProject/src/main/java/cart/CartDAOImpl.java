package cart;
// 購物車的連線物件
// 要考慮做DAO Factory嗎？
import java.sql.*;
import java.util.ArrayList;

public class CartDAOImpl implements CartDAO {
	private Connection conn;
	// dataArrays在每次執行selectAllOrder()或selectOrder()時都會先被重製，
	// 其他需要重製的時候需要手動重製。
	public static ArrayList<ArrayList<String>> dataArrays;
	
	public CartDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public static OrderBean odBean01 = new OrderBean("od001", "p001", "EngSpeaking", 300, "elf01", "fl", "b", "w@w", "cancelled", "1999-12-01 00:00:00", 1 );
	public static final String columnNames[] = {"O_ID", "P_ID", "P_Name", "P_Price", "U_ID", "U_FirstName", "U_LastName",
			"U_Email", "O_Status", "O_Date", "O_Amt"};
	
	/************************************************************************************
	*@Insert_data
	*@1. [主要] 由client在(確定付款).jsp後使用此方法把Order寫進資料庫
	*@2. [次要] 由Admins使用
	************************************************************************************/
	@Override
	public int insertOrder(OrderBean orderBean) {
		int insertStatus = 0;
		// ***
		String insertCmd = "INSERT [Order_Info] VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
		PreparedStatement pStmt = null;
		try {
			pStmt = conn.prepareStatement(insertCmd);
			pStmt.setString(1,  orderBean.getO_ID()       );
			pStmt.setString(2,  orderBean.getP_ID()       );
			pStmt.setString(3,  orderBean.getP_Name()     );
			pStmt.setInt   (4,  orderBean.getP_Price()    );
			pStmt.setString(5,  orderBean.getU_ID()       );
			pStmt.setString(6,  orderBean.getU_FirstName());
			pStmt.setString(7,  orderBean.getU_LastName() );
			pStmt.setString(8,  orderBean.getU_Email()    );
			pStmt.setString(9,  orderBean.getO_Status()   );
			pStmt.setString(10, orderBean.getO_Date()     );
			pStmt.setInt   (11, orderBean.getO_Amt()      );
			
			insertStatus = pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pStmt.close();
//				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Inserted " + insertStatus + " rows of data.");
		return insertStatus;
	}
	
	/************************************************************************************
	*@Select_All_Rows
	************************************************************************************/
	@Override
	public boolean selectAllOrder() {
		boolean selectAllStatus = false;
		String selectAllCmd = "SELECT * FROM [Order_Info];";
		Statement cStmt = null;
		ResultSet rs = null;
		ArrayList<String> headersArray = new ArrayList<String>();
		
		this.dataArrays = new ArrayList<ArrayList<String>>();
		try {
			cStmt = conn.createStatement();
			rs = cStmt.executeQuery(selectAllCmd);
			ResultSetMetaData md = rs.getMetaData();
			
			// 1. headers
			for(int i = 1; i <= md.getColumnCount(); i++) {
//				System.out.println(md.getColumnName(i));
				headersArray.add(md.getColumnName(i));
			}
			// 2. data
			while(rs.next()) {
				ArrayList<String> dataArray = new ArrayList<String>();
				for(int i = 1; i <= md.getColumnCount(); i++) {
//					System.out.println(rs.getString(i));
					dataArray.add(rs.getString(i));
				}
				dataArrays.add(dataArray);
				
			}
			
			selectAllStatus = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				cStmt.close();
//				conn.close(); // 留給外頭的控制器關
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return selectAllStatus;
	}
	
	/************************************************************************************
	*@Select_a_Single_Row
	*@1. 以P_ID查一筆Order_Info表格的資料
	*@Q1. 用P_ID還是O_ID比較好？
	************************************************************************************/
	@Override
	public boolean selectOrder(String P_ID) {
		boolean selectStatus = false;
		String selectCmd = "SELECT * FROM [Order_Info] WHERE P_ID = ?;"; // ***
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<String> headersArray = new ArrayList<String>();
		this.dataArrays = new ArrayList<ArrayList<String>>();
		try {
			pStmt = conn.prepareStatement(selectCmd);
			pStmt.setString(1, P_ID);
			rs = pStmt.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			
			// 1. headers
			for(int i = 1; i <= md.getColumnCount(); i++) {
//				System.out.println(md.getColumnName(i));
				headersArray.add(md.getColumnName(i));
			}
			// 2. data
			while(rs.next()) {
				ArrayList<String> dataArray = new ArrayList<String>();
				for(int i = 1; i <= md.getColumnCount(); i++) {
//					System.out.println(rs.getString(i));
					dataArray.add(rs.getString(i));
				}
				this.dataArrays.add(dataArray);
			}
			
			selectStatus = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pStmt.close();
//				conn.close(); // 留給外頭的控制器關
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return selectStatus;
	}

	/************************************************************************************
	*@Update_By_Admins
	*@1. 預設會由前端回傳一個預設bean，這個bean的預設值即是不更動任何值的原bean值(原row值)
	*@2. 預計以P_ID作為WHERE過濾方法 = obj3變數
	*@Q1. 怎麼對付smalldatetime？
	*@Q2. 有辦法用PreparedStatement嗎？
	************************************************************************************/
	@Override
	public boolean updateOrder(OrderBean orderBean, String str3, Object obj4) {
		boolean updateStatus = false;
		Object str1 = null, str2 = null;
		String str4 = String.valueOf(obj4);
		String updateCmdTemplate;
		String finalUpdateCmd = "";
		Statement cStmt = null;
//		obj3 == 管理者想用來下去查的參數，obj4 == 其值
		// 對付obj4(查詢參數值)型態：int以外(String)冠上單引號(')以符合SQL格式
		if(!"P_Price".equals(str3) && !"O_Amt".equals(str3) ) str4 = "'" + str4 + "'";
		try {
			cStmt = conn.createStatement();
			for(int i = 0; i < columnNames.length; i++) {
				str1 = columnNames[i];
				str2 = orderBean.take(i + 1);
				// 對付obj2(修改參數值)型態
				if(!"P_Price".equals(str2) && !"O_Amt".equals(str2)) str2 = "'" + str2 + "'";
				updateCmdTemplate = "UPDATE [Order_Info] SET " + str1 + " = " + str2
						+ " WHERE " + str3 + " = " + str4 + " ;\r\n"; // ***
				finalUpdateCmd = finalUpdateCmd + updateCmdTemplate;
				System.out.println("Updated a row(OrderBean).");
			}
			// 執行超長UPDATE語句
			int indicator = cStmt.executeUpdate(finalUpdateCmd);
			if(indicator != 0) updateStatus = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cStmt.close();
			} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		return updateStatus;
	}
	/************************************************************************************
	*@Delete_By_Admins
	*@1. 用P_ID來刪
	************************************************************************************/
	@Override
	public boolean deleteOrder(String O_ID) {
		boolean deleteStatus = false;
		int deletedRows;
		Statement cStmt = null;
		String deleteCmd = "DELETE FROM [Order_Info] "
				+ "WHERE O_ID = '" + O_ID + "';";
		
		
		
		try {
			cStmt = conn.createStatement();
			deletedRows = cStmt.executeUpdate(deleteCmd);
			
			if(deletedRows != 0) deleteStatus = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				cStmt.close();
//				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return deleteStatus;
	}
	
	public void printSELECT(ArrayList<ArrayList<String>> dataArrays) {
		// (還沒決定這方法要做什麼)
	}

}
