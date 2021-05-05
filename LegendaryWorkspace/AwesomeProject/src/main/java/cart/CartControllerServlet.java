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
/**
 * @Q1. 重新導向過去的網址有誤(理應是.jsp卻顯示此controller)
 * @Q2. 
 **/

@WebServlet("/CartControllerServlet")
public class CartControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource ds;
	private HttpSession session; 
	private List<ProductBean> cart;
	
	private ProductBean testBean1, testBean2, testBean3;
	
    @Override
    public void init() throws ServletException {
    	super.init();

    	try {

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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("Use POST, sir.");
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// session範圍：會員點選「加入購物車」(#add) ~ 付款完成 or 登出為止 
		this.session = request.getSession();
    	this.cart = (List<ProductBean>) session.getAttribute("cart");
    	this.session.setAttribute("cart", cart);
    	
    	String todo = request.getParameter("todo");
    	
    	// 1. 右上角購物車圖示 (from 任何頁面) 
    	if(todo == null) gotoCartIndexPage(request, response); 
    	// 2. 加入品項 (from 商品頁面)
    	else if("add".equals(todo)) putProductIntoCart(request, response);
    	// 3. 移除品項 (from 購物車頁面)
    	else if("remove".equals(todo)) removeProductFromCart(request, response);
    	// 4. 去結帳 (from 購物車頁面) 
    	else if( "checkout".equals(todo)) checkout(request, response);
    	// 5. debug用
    	else response.getWriter().print("Something went wrong! "
    			+ "todo value = " + todo);
    	
	}
    /**
     * @Method #01 todo == null > 導向購物車
     * @1. 導向購物車頁(CartIndex.jsp)
     * @Database_Connection 不涉及
     **/
    private void gotoCartIndexPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	req.getRequestDispatcher("/cart/cartIndex.jsp").forward(req, res);;
    	
    }
    
    /**
     * @Method #02 add > 購買商品
	 * @1. 將品項加入購物車
	 * @2. 返回該商品頁
	 * @undone 返回原頁的參數
	 * @Database_Connection 不涉及?
	 * @Problem1. 要有剩餘名額嗎？會影響到此方法要不要連DB
	 **/
	private void putProductIntoCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 大概要改。這邊是假設課程頁會傳該product的column值過來。
		// 有沒有辦法抓ProductBean呀？
		ProductBean addedProduct = new ProductBean();
		addedProduct.setP_ID ( req.getParameter("P_ID")); 
		addedProduct.setP_Name ( req.getParameter("P_Name"));
		addedProduct.setP_Class ( req.getParameter("P_Class"));
		addedProduct.setP_Price ( Integer.parseInt(req.getParameter("P_Price"))); 
		addedProduct.setP_DESC ( req.getParameter("P_DESC")); 
		addedProduct.setU_ID ( req.getParameter("U_ID"));
		addedProduct.setP_Img ( req.getParameter("P_Img")); 
		addedProduct.setP_Video ( req.getParameter("P_Video"));
		
		this.session.setAttribute("addedProduct", addedProduct);
		// 這邊不做像老師MVC Demo2的產品數量重疊的判斷和處理迴圈，
		// 因為單項課程沒有超過一件的概念...吧？
		this.cart.add(addedProduct);
		
		req.getRequestDispatcher("/product/xxxxxxxx.jsp").forward(req, res);	// 返回原頁
	}

    /**
     * @Method #03 remove > 移除商品
     * @1. 將指定商品自購物車移除
     * @2. 導回購物車頁(CartIndex.jsp)
     * @Database_Connection 不涉及
     **/
	private void removeProductFromCart(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// 針對一次刪一件寫的，
		// 萬一一次要刪多件(比方說checkbox傳來多值)要重寫。
		String P_ID = req.getParameter("P_ID");
		String[] pms = req.getParameterValues("checkRemove");
		
		if (pms != null) {	for(String element : pms) {System.out.println(element);}	} // debug用
		
		
		req.getRequestDispatcher("/cart/cartIndex.jsp").forward(req, res);	// 返回原頁
	}
	
    /**
     * @Method #04 checkout > 結帳
     * @1. 導向至結帳頁面(checkout.jsp)
     * @undone 「下一頁」要記得把session invalidate()掉
     * @Database_Connection 不涉及
     **/
	private void checkout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getRequestDispatcher("/cart/checkout.jsp").forward(req, res);	// 返回原頁
	}

	/**
     * @SubMethod #01 取得連線
     * @undone 使用此方法的方法要在最後記得關閉
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
