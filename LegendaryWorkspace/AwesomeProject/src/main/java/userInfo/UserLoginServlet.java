package userInfo;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType(CONTENT_TYPE);
		String userID = request.getParameter("u_ID");
		String userPsw = request.getParameter("u_Psw");
//		response.getWriter().println("哈囉, "+userID);
		
		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;
		try {
			ctxt = new InitialContext();
			ds = (DataSource)ctxt.lookup("java:comp/env/jdbc/DBDB");
			conn = ds.getConnection();
			UserDAO userDAO = new UserDAO(conn);
			UserBean userData = userDAO.userLogin(userID);
			System.out.println(userData.getU_ID());
			request.getSession(true).setAttribute("userData", userData);
			System.out.println("id: "+ userData.getU_ID());
			System.out.println("psw: "+ userData.getU_Psw());
			if(userData.getU_ID().equals(userID) && userData.getU_Psw().equals(userPsw)) {
				request.getRequestDispatcher("/userInfo/userLoginTransPage.jsp").forward(request, response);
				
			}
		} catch (Exception e) {
			response.getWriter().println("<h2 style=\"color: red;\">帳號不存在! 請先註冊!</h2><br><br>");
			response.getWriter().println("正在導向註冊頁面.....<br><br>");
			response.setHeader("refresh", "3; /AwesomeProject/userInfo/UserSignUp.jsp");
			response.getWriter().println("<a href=\"/AwesomeProject/userInfo/UserSignUp.jsp\"><b>點擊前往註冊</b></a>");
		}
	}

}
