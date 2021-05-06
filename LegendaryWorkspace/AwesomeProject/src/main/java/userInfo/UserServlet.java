package userInfo;



import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
       

    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
		
		//新增註冊資料
		if(request.getParameter("login")!=null) {
			gotoIndexPage(request, response);
		} /*else if(request.getParameter("signUp")!=null) {
			gotoSignUpPage(request, response);
		}*/ else if (request.getParameter("signUpButton")!=null) {
			//註冊頁面確認，去確認頁面(同時拿參數進來放入Bean)
			gotoConfirmPage(request,response);
		}/* else if (request.getParameter("signUpGotoIndex")!=null) {
			//註冊頁面按:回首頁
			//gotoIndexPage
		}*/ else if (request.getParameter("confirmButton")!=null) {
			//確認註冊資料，去ThanksPage，資料匯入DB
			gotoThankPage(request, response);
		}/* else if (request.getParameter("thankPageButton")!=null) {
			//感謝頁面，導回登入頁面
			gotoLoginPage(request, response);
		}*/ else if (request.getParameter("updateButton")!=null) {
			// 更新會員資料
			userUpdateProcess(request, response);
		}
		
	}
	
	
	//登入
	public void gotoIndexPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//待補充
	}
	
	
	/*
	//註冊
	public void gotoSignUpPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/userInfo/UserSignUp.jsp").forward(request, response);
	}
	*/
	
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
			ds = (DataSource)ctxt.lookup("java:comp/env/jdbc/ProjectDB");
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
	
	/*
	//回登入頁面
	public void gotoLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/userInfo/UserLogin.jsp").forward(request, response);
	}*/
	
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
		request.getSession().setAttribute("updateUser", updateUser);
		
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		
		// call function
		try {
			ctxt = new InitialContext();
			ds = (DataSource)ctxt.lookup("java:comp/env/jdbc/ProjectDB");
			conn = ds.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			boolean updateResult = userDAO.updateUser(updateUser);
			System.out.println("IN servlet, after update 測試字串");
			if(updateResult) {
				// 看dao裡的updateUser回傳什麼
				System.out.println("資料修改成功!");
//				request.getRequestDispatcher("/userInfo/index_test.html").forward(request, response);
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
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
