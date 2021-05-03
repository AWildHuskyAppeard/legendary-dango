package cart;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

@WebServlet("/CartControllerServlet")
public class CartControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DataSource ds;

       
    @Override
    public void init() throws ServletException {
    	super.init();
    	
    	try {
			InitialContext ctx = new InitialContext();
			// 改資料庫名稱
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OurDB");
			if (ds == null)
				// 改資料庫名稱
				throw new ServletException("Unknown DataSource 'jdbc/OurDB'");
		} catch (NamingException ex) {
			ex.printStackTrace();
		}

		Connection conn = null;
		Statement stmt = null;
		
		List<String> P_IDList = new ArrayList<String>(); // PK
		List<String> P_NameList = new ArrayList<String>();
		List<String> P_ClassList = new ArrayList<String>();
		List<Integer> P_PriceList = new ArrayList<Integer>();
		List<String> P_DESCList = new ArrayList<String>();
		List<String> U_IDList = new ArrayList<String>(); // FK
		List<String> P_ImgList = new ArrayList<String>();
		List<String> P_VideoList = new ArrayList<String>();

		try {
			conn = ds.getConnection();
			stmt = conn.createStatement(); // 可以改動態sql
			// 修改下述語句(table名之類)
			String sqlStatement = "SELECT * FROM Product";
			ResultSet rset = stmt.executeQuery(sqlStatement);

			while (rset.next()) {
				P_IDList.add(rset.getString("P_ID"));
				P_NameList.add(rset.getString("P_Name"));
				P_ClassList.add(rset.getString("P_Class"));
				P_PriceList.add(rset.getInt("P_Price"));
				P_DESCList.add(rset.getString("P_DESC"));
				U_IDList.add(rset.getString("U_ID"));
				P_ImgList.add(rset.getString("P_Img"));
				P_VideoList.add(rset.getString("P_Video"));
			}

			// toArray()有兩種return結果
			// 1. 若參數之String size >= ArrayList size > 直接把AL內容物移植進去並return
			// 2. 若參數之String size < ArrayList size > 產生剛好size的Array裝進來並return
			ProductDB.setP_ID((String[])P_IDList.toArray(new String[0]));
			ProductDB.setP_Name((String[])P_NameList.toArray(new String[0]));
			ProductDB.setP_Class((String[])P_ClassList.toArray(new String[0]));
			ProductDB.setP_Price((Integer[])P_PriceList.toArray(new Integer[0]));
			ProductDB.setP_DESC((String[])P_DESCList.toArray(new String[0]));
			ProductDB.setU_ID((String[])U_IDList.toArray(new String[0]));
			ProductDB.setP_Img((String[])P_ImgList.toArray(new String[0]));
			ProductDB.setP_Video((String[])P_VideoList.toArray(new String[0]));
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close(); // return to pool
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
