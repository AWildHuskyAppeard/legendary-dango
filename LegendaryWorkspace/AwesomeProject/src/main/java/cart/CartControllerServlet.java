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

	private DataSource ds;

    @Override
    public void init() throws ServletException {
    	super.init();
    	Connection conn;
    	try {
    	conn = getConnection();
//			InitialContext ctx = new InitialContext();
//			// 改資料庫名稱
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ProjectDB");
//			if (ds == null)
//				// 改資料庫名稱
//				throw new ServletException("Unknown DataSource 'jdbc/ProjectDB'");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
//
//		Connection conn = null;
//		Statement stmt = null;
//		
//		List<String> P_IDList = new ArrayList<String>(); // PK
//		List<String> P_NameList = new ArrayList<String>();
//		List<String> P_ClassList = new ArrayList<String>();
//		List<Integer> P_PriceList = new ArrayList<Integer>();
//		List<String> P_DESCList = new ArrayList<String>();
//		List<String> U_IDList = new ArrayList<String>(); // FK
//		List<String> P_ImgList = new ArrayList<String>();
//		List<String> P_VideoList = new ArrayList<String>();
//
//		try {
//			conn = ds.getConnection();
//			stmt = conn.createStatement(); // 可以改動態sql
//			// 修改下述語句(table名之類)
//			String sqlStatement = "SELECT * FROM Product";
//			ResultSet rset = stmt.executeQuery(sqlStatement);
//
//			while (rset.next()) {
//				P_IDList.add(rset.getString("P_ID"));
//				P_NameList.add(rset.getString("P_Name"));
//				P_ClassList.add(rset.getString("P_Class"));
//				P_PriceList.add(rset.getInt("P_Price"));
//				P_DESCList.add(rset.getString("P_DESC"));
//				U_IDList.add(rset.getString("U_ID"));
//				P_ImgList.add(rset.getString("P_Img"));
//				P_VideoList.add(rset.getString("P_Video"));
//			}
//
//			/**
//			 * @toArray() 有兩種return結果
//			 * @1. 若參數之String size >= ArrayList size > 直接把AL內容物移植進去並return
//			 * @2. 若參數之String size < ArrayList size > 產生剛好size的Array裝進來並return
//			 * */
//			ProductDB.setP_ID((String[])P_IDList.toArray(new String[0]));
//			ProductDB.setP_Name((String[])P_NameList.toArray(new String[0]));
//			ProductDB.setP_Class((String[])P_ClassList.toArray(new String[0]));
//			ProductDB.setP_Price((Integer[])P_PriceList.toArray(new Integer[0]));
//			ProductDB.setP_DESC((String[])P_DESCList.toArray(new String[0]));
//			ProductDB.setU_ID((String[])U_IDList.toArray(new String[0]));
//			ProductDB.setP_Img((String[])P_ImgList.toArray(new String[0]));
//			ProductDB.setP_Video((String[])P_VideoList.toArray(new String[0]));
//			
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		} finally {
//
//			// 確定要在這裡關閉連線？
//			try {
//				if (stmt != null)
//					stmt.close();
//				if (conn != null)
//					conn.close(); // return to pool
//			} catch (SQLException ex) {
//				ex.printStackTrace();
//			}
//		}
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // session範圍：會員點選「加入購物車」(#add) ~ 付款完成 or 登出為止 
    	List<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");
    	session.setAttribute("cart", cart);
    	
    	String nextPage = "";
    	String todo = request.getParameter("todo");
    	
    	if(todo == null) 
    	{  // 1. 右上角購物車圖示 (from 任何頁面) 
			gotoCartIndexPage();
			
    	} else if(todo == "add")
    	{	// 2. 加入品項 (from 商品頁面)
    		putProductIntoCart();
    		
    		nextPage = "/來的那一頁(該課程頁)";
    	} else if(todo == "remove")
    	{  // 3. 移除品項 (from 購物車頁面)
    		removeProductFromCart();
    		
    		nextPage = "/購物車頁面";
    	} else if(todo == "checkout")
    	{ // 4. 去結帳 (from 購物車頁面) 
    		
    		nextPage = "/checkout.jsp"; // 此.jsp要invalidate()
    	}
    		
	}
    /**
     * @Method #01 
     * @1. 導向CartIndex.jsp
     * @Database_Connection 不涉及
     **/
    private void gotoCartIndexPage() {
    	
    }
    
    /**
	 * @Method #02 
	 * @1. 將品項加入購物車
	 * @2. 返回該商品頁
	 * @Database_Connection 不涉及
	 **/
	private void putProductIntoCart() {
		
	}

    /**
     * @Method #03 移除商品
     * @1. 將指定商品自購物車移除
     * @2. 導回購物車頁
     * @Database_Connection 不涉及
     **/
	private void removeProductFromCart() {
		
	}

	/**
     * @SubMethod #01 取得連線
     * @1. 使用此方法的方法要在最後記得關閉
     * @Database_Connection 不涉及
     * @Problem1. InitialContext要關嗎？
     **/
    private Connection getConnection() {
    	InitialContext ctx;
    	Connection conn = null;
    	
	    	try 
	    	{
	    		if (this.ds == null) 
	    		{	
		    		ctx = new InitialContext();
		    		// 改資料庫名稱
		    		this.ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ProjectDB");
	    		}
	    		this.ds.getConnection();
			} catch (NamingException e) 
	    	{
				e.printStackTrace();
			} catch (SQLException e) 
	    	{
				e.printStackTrace();
			}
    	
    	return conn;
    }
}
