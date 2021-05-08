package userInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(
		urlPatterns = { "/UserServlet" }, 
		initParams = { 
				@WebInitParam(name = "adminID", value = "admin"), 
				@WebInitParam(name = "adminPSW", value = "samanager")
		})

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
       

    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
		
		
		if(request.getParameter("userLogin")!=null) {
			// user登入後導向首頁
			// 用u_ID去資料庫撈使用者資訊
			gotoIndexPage(request, response);
		} else if (request.getParameter("signUpButton")!=null) {
			//註冊頁面確認，去確認頁面(同時拿參數進來放入Bean)
			gotoConfirmPage(request,response);
		}/* else if (request.getParameter("signUpGotoIndex")!=null) {
			//註冊頁面按:回首頁
			//gotoIndexPage
		}*/ else if (request.getParameter("confirmButton")!=null) {
			//確認註冊資料，去ThanksPage，資料匯入DB
			gotoThankPage(request, response);
		} else if (request.getParameter("updateButton")!=null) {
			// 更新會員資料
			userUpdateProcess(request, response);
		} else if (request.getParameter("adminLogin")!=null) {
			// GM登入後導向GM首頁
			gotoGMIndex(request, response);
		} else if (request.getParameter("findByU_ID")!=null) {
			// GM輸入查詢單筆會員資料(ByU_ID)
			findByU_ID(request,response);
		} else if (request.getParameter("deleteUser")!=null) {
			deleteUser(request, response);
		} 
		
	}
	
	
	//登入
	// user登入後導向首頁，把user id用session存起來
	public void gotoIndexPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//待補充判斷帳號密碼(從資料庫撈出來比對)，再導向首頁
		String inputID = request.getParameter("u_ID");
		String inputPsw = request.getParameter("u_Psw");
		
//		UserBean ub = new UserBean();
//		ub.setU_ID(inputID);
//		ub.setU_Psw(inputPsw);
		
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		// 去dao連資料庫拿使用者資訊，要拿密碼比對
		try {
			ctxt = new InitialContext();
			ds = (DataSource)ctxt.lookup("java:comp/env/jdbc/DBDB");
			conn = ds.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			UserBean userLoginBean = userDAO.userLogin(inputID);
			System.out.println("id: "+userLoginBean.getU_ID());  //print出id
			System.out.println("psw: "+userLoginBean.getU_Psw()); //print出psw
			// 判斷帳號密碼
			if ( (userLoginBean.getU_ID()).equals(inputID) && (userLoginBean.getU_Psw()).equals(inputPsw) ) {
				// 密碼正確，導回首頁
				System.out.println("Hello, "+inputID);
				response.getWriter().println("<h2>Hello, <span  style=\"color: blue;\">"+ inputID +" </span>登入成功!</h2><br><br>");
				response.getWriter().println("正在導回首頁.....<br><br>");
				response.setHeader("refresh", "3; /AwesomeProject/userInfo/index_test.html");
				response.getWriter().println("<a href=\"/AwesomeProject/userInfo/index_test.html\"><b>點擊返回首頁</b></a>");
				//
			} else if ( (userLoginBean.getU_ID()).equals(inputID) && !(userLoginBean.getU_Psw()).equals(inputPsw) ) {
				System.out.println("密碼錯誤");
				response.getWriter().println("<h2 style=\"color: red;\">密碼輸入錯誤，請再試一次!</h2><br><br>");
				response.getWriter().println("正在導回登入畫面.....<br><br>");
				response.setHeader("refresh", "3; /AwesomeProject/userInfo/UserLogin.jsp");
				response.getWriter().println("<a href=\"/AwesomeProject/userInfo/UserLogin.jsp\"><b>點擊重新登入</b></a>");
			}
			
		} catch (Exception e) {
			response.getWriter().println("<h2 style=\"color: red;\">帳號不存在! 請先註冊!</h2><br><br>");
			response.getWriter().println("正在導向註冊頁面.....<br><br>");
			response.setHeader("refresh", "3; /AwesomeProject/userInfo/UserSignUp.jsp");
//			e.printStackTrace();
		} finally {
			try {
				if (conn!=null) { conn.close(); }
			} catch (Exception e2) {
				System.out.println("Connection Pool Error!!!");
			}
		}
		
	}
		
	//註冊確認頁面
	public void gotoConfirmPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String u_ID = request.getParameter("u_ID").trim();
		String u_Psw = request.getParameter("u_Psw").trim();
		String u_BirthDay = request.getParameter("u_BirthDay");
		String u_LastName= request.getParameter("u_LastName").trim();
		String u_FirstName = request.getParameter("u_FirstName").trim();
		String u_Email = request.getParameter("u_Email").trim();
		String u_Tel = request.getParameter("u_Tel").trim();
		String u_Sex = request.getParameter("u_Sex");
		String u_Address = request.getParameter("u_Address").trim(); 
		
		UserBean create_user = new UserBean(u_ID, u_Psw, u_BirthDay, u_LastName, u_FirstName, u_Email, u_Tel, u_Sex, u_Address);
		request.getSession(true).setAttribute("create_user", create_user);
		request.getRequestDispatcher("/userInfo/UserConfirm.jsp").forward(request, response); //去confirm的jsp頁面
	}
	
	//感謝註冊頁面
	public void gotoThankPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		
		try {
			ctxt = new InitialContext();
			ds = (DataSource)ctxt.lookup("java:comp/env/jdbc/DBDB");
			conn = ds.getConnection();
			
			UserDAO userDAO = new UserDAO(conn); //這邊
			UserBean userData = (UserBean)request.getSession(true).getAttribute("create_user");
			if (userDAO.createUser(userData)) {
				System.out.println("註冊資料匯入成功!");
				request.getSession(true).invalidate();
				//去感謝頁面
				request.getRequestDispatcher("/userInfo/ThankPage.jsp").forward(request, response);
			}
			
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
		} catch (SQLException sqle) {
			System.out.println("Database Connection Error");
		} catch (Exception e) {
			System.out.println("Other Exception catched");
		} finally {
			try {
				if (conn!=null) { conn.close(); }
			} catch (Exception e2) {
				System.out.println("Connection Pool Error!!!");
			}
		}
		
	}
	

	
	// 修改會員資料
	public void userUpdateProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String u_BirthDay = request.getParameter("u_BirthDay");
		String u_LastName = request.getParameter("u_LastName");
		String u_FirstName = request.getParameter("u_FirstName");
		String u_Email = request.getParameter("u_Email");
		String u_Tel = request.getParameter("u_Tel");
		String u_Sex = request.getParameter("u_Sex");
		String u_Address = request.getParameter("u_Address");
		
		// 把取到的參數放入Bean
		UserBean updateUser = new UserBean();
		updateUser.setU_BirthDay(u_BirthDay);
		updateUser.setU_LastName(u_LastName);
		updateUser.setU_FirstName(u_FirstName);
		updateUser.setU_Email(u_Email);
		updateUser.setU_Tel(u_Tel);
		updateUser.setU_Sex(u_Sex);
		updateUser.setU_Address(u_Address);
		
		// 設Attribute
		request.getSession(true).setAttribute("updateUser", updateUser);
		
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		
		// call function
		try {
			ctxt = new InitialContext();
			ds = (DataSource)ctxt.lookup("java:comp/env/jdbc/DBDB");
			conn = ds.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			boolean updateResult = userDAO.updateUser(updateUser);
			System.out.println("IN servlet, after update 測試字串");
			if(updateResult) {
				// 看dao裡的updateUser回傳什麼
				System.out.println("資料修改成功!");
				request.getSession().invalidate();
				request.getRequestDispatcher("/userInfo/test_UpdateWaitPage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			new ServletException(e);
		} finally {
			try {
				if (conn!=null) { conn.close(); }
			} catch (Exception e2) {
				System.out.println("Connection Pool Error!!!");
			}
		}
	}

	
	// 導向GM首頁
	public void gotoGMIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 比對GM帳號密碼(從init-param)撈資料，再導向GM首頁
		String adminID = getInitParameter("adminID");
		String adminPSW = getInitParameter("adminPSW");
		
		String inputAcc = request.getParameter("admin_ID");
		String inputPsw = request.getParameter("admin_Psw");
		
		// 比對admin帳號密碼
		if(inputAcc.equals(adminID) && inputPsw.equals(adminPSW)) {
			// 待辦: 把adminID用session存起來
			response.sendRedirect("/AwesomeProject/userInfo/test_GM_index.html");
		} else {
			response.getWriter().println("帳號或密碼錯誤，請重新輸入<br><br>");
			response.getWriter().println("正在導回登入頁面.....<br><br>");
			response.setHeader("refresh", "3; /AwesomeProject/userInfo/AdminLogin.jsp");
			response.getWriter().println("<a href=\"/AwesomeProject/userInfo/AdminLogin.jsp\"><b>點此返回登入畫面</b></a>");
		}

	}
	
	// GM查詢單筆會員資料(ByU_ID)
	public void findByU_ID( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 導去jsp show結果
		String u_ID = request.getParameter("u_ID");
		
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		
		try {
			ctxt = new InitialContext();
			ds = (DataSource)ctxt.lookup("java:comp/env/jdbc/DBDB");
			conn = ds.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			UserBean findResult = userDAO.findUserByU_ID(u_ID);
			
			if(findResult==null) {
				System.out.println("沒有這筆會員資料");
				response.getWriter().println("沒有這筆會員資料，請重新查詢<br><br>");
				response.getWriter().println("正在導回上一頁.....<br><br>");
				response.setHeader("refresh", "3; /AwesomeProject/userInfo/test_GM_UserFunction.jsp");
				response.getWriter().println("<a href=\"/AwesomeProject/userInfo/test_GM_UserFunction.jsp\"><b>點擊返回上一頁</b></a>");
			}else {
				// 有資料show資料
				request.getSession(true).setAttribute("findResult", findResult);
				System.out.println(findResult.getU_ID());
				request.getRequestDispatcher("/userInfo/AdminFindByU_ID.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn!=null) { conn.close(); }
			} catch (Exception e2) {
				System.out.println("Connection Pool Error!!!");
			}
		}
		
	}
	
	
	// 刪除使用者
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_ID = request.getParameter("u_ID");
		
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		
		try {
			ctxt = new InitialContext();
			ds = (DataSource)ctxt.lookup("java:comp/env/jdbc/DBDB");
			conn = ds.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			boolean deleteResult = userDAO.deleteUser(u_ID);
			if(deleteResult) {
				response.getWriter().println("刪除使用者成功!<br><br>");
				response.getWriter().println("正在導回上一頁.....<br><br>");
				response.setHeader("refresh", "3; /AwesomeProject/userInfo/test_GM_UserFunction.jsp");
				response.getWriter().println("<a href=\"/AwesomeProject/userInfo/test_GM_UserFunction.jsp\"><b>點擊返回上一頁</b></a>");
			} else {
				System.out.println("GG斯咪搭，沒有刪除到資料");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn!=null) { conn.close(); }
			} catch (Exception e2) {
				System.out.println("Connection Pool Error!!!");
			}
		}
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}