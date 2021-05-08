package cart;
// 購物車的連線物件
import java.sql.*;
import java.util.ArrayList;

public class CartDAOImpl implements CartDAO {
	private Connection conn;
	
	public CartDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public static OrderBean odBean01 = new OrderBean("od001", "p001", "EngSpeaking", 300, "elf01", "fl", "b", "w@w", "cancelled", "1999-12-01 00:00:00", 1 );
	private Object columnNames[] = {"O_ID, P_ID, P_Name, P_Price, U_ID, U_FirstName, U_LastName",
			"U_Email", "O_Status", "O_Date", "O_Amt"};
	
	
	@Override
	public int insertOrder(OrderBean orderBean) {
		int insertStatus = 0;
		// ***
		String insertCmd = "INSERT [Order_Info] VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
		PreparedStatement pStmt = null;
		ResultSet rs = null;
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
				rs.close();
				pStmt.close();
//				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Updated " + insertStatus + " rows of data.");
		return insertStatus;
	}

	// 以P_ID查一筆Order_Info表格的資料
	// 用P_ID還是O_ID比較好？
	@Override
	public boolean selectOrder(OrderBean orderBean) {
		boolean selectStatus = false;
		String selectCmd = "SELECT * FROM [Order_Info] WHERE P_ID = ?;"; // ***
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		ArrayList<String> headersArray = new ArrayList<String>();
		ArrayList<String> dataArray    = new ArrayList<String>();
		try {
			pStmt = conn.prepareStatement(selectCmd);
			pStmt.setString(1, orderBean.getP_ID());
			rs = pStmt.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			
			// 1. headers
			for(int i = 1; i <= md.getColumnCount(); i++) {
//				System.out.println(md.getColumnName(i));
				headersArray.add(md.getColumnName(i));
			}
			// 2. data
			while(rs.next()) {
				for(int i = 1; i <= md.getColumnCount(); i++) {
//					System.out.println(rs.getString(i));
					dataArray.add(rs.getString(i));
				}
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

	/**
	*@Update_By_Admins
	*@1. 預設會由前端回傳一個預設bean，這個bean的預設值即是不更動任何值的原bean值(原row值)
	*@2. 預計以P_ID作為WHERE過濾方法 = obj3變數
	**/
	@Override
	public int updateOrder(OrderBean orderBean, Object obj3, Object obj4) {
		int updateStatus = 0;
		Object obj1 = null, obj2 = null; obj3 = null; obj4 = null;
		String updateCmd = "UPDATE [Order_Info] SET " + obj1 + " = " + obj2
				+ " WHERE " + obj3 + " = " + obj4; // ***
		Statement cStmt = null;
		ResultSet rs = null;
//		obj3 == 管理者想用來下去查的參數，obj4 == 其值
		try {
			cStmt = conn.createStatement();
			cStmt.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateStatus;
		
		
	}

}
