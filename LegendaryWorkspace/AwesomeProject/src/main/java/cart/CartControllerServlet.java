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
	
	public static ProductBean testBean1 = new ProductBean("ENG003", "Speaking", "ENG", 900, "nice", "mem005", "www", "sss")  ;
	public static ProductBean testBean2 = new ProductBean("ENG015", "Reading", "ENG", 350, "awesome", "mem905", "ww", "ks")  ;
	public static ProductBean testBean3 = new ProductBean("JPN003", "Speaking", "JPN", 99, "subarashii", "mem001", "aaa", "ww")  ;
	
    @Override
    public void init() throws ServletException {
    	super.init();
    	
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// session範圍：會員點選「加入購物車」(#add) ~ 付款完成 or 登出為止 
    	this.session = request.getSession(true);
    	this.cart = (ArrayList<ProductBean>) session.getAttribute("cart");
    	
    	// 測試用
    	if(this.cart == null || this.cart.size() == 0) 
    	{
    		this.cart = new ArrayList<ProductBean>();
    		this.cart.add(testBean1);
    		this.cart.add(testBean2);
    		this.cart.add(testBean3);
    	}
    	
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
		
//		if (pms != null) {	for(String element : pms) {System.out.println(element);}	} // debug用
		
		// 把btn勾選與否列成ArrayList 1 // 用Vector如何？ // 用checkbox的話要怎麼做啊ˊ<_ˋ
		// 假設cart裡面有5個產品，如此一來下述會生成btn size = 5的ArrayList
		ArrayList btns = new ArrayList(); 
		for(int i = 0; i < cart.size(); i++) {
			btns.add(req.getParameter("btn" + (i + 1)));
		}
		// 再來，用getParameters取得所有P_ID值生成並丟進ArrayList 2：
		// 疑問：會照順序取得嗎？
		String P_IDArray[] = req.getParameterValues("P_ID");
		String P_IDTest = req.getParameter("P_ID");
		String testparam = req.getParameter("www");
		System.out.println(P_IDArray);
		System.out.println(P_IDTest);
		System.out.println(testparam);
		
//		System.out.println("cart = " + cart + ";\nbtns = " + btns); // debug用
		
		// 最後來對照這兩個ArrayList。只取出btn值 == on的 P_ID，亦即那些勾選刪除的選項：
		// 從購物車移除掉有打圈的課程
	    if(cart != null || cart.size() != 0) {
		    for(int i = 0; i < cart.size() ; i++){
		        if("on".equals(btns.get(i))){
		            for(int j = 0; j < cart.size(); j++){
		                if(cart.get(j).getP_ID().equals(P_IDArray[i])){
		                    cart.remove(j); // remove()用法不確定
		                    i--;
		                }
		            }
		        }
		    }
		}
	    // 問題：radio input好像無法取消勾選
		
		System.out.println(cart);
    	this.session.setAttribute("cart", this.cart); // xxxxxxxxx
		
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
		    		this.ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/DBDB");
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
