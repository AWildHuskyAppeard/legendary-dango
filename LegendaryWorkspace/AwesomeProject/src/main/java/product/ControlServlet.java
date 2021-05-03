package learningWeb;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds;
	
	@Override
	public void init() throws ServletException{
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/EmployeeDB");
			if (ds == null) {
				throw new ServletException("Unknown DataSource 'jdbc/TestDB");
			}
			
		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		//HttpSession session = request.getSession(true);
		
		try {
			//create connection
			conn = ds.getConnection();
			String sql = "select * from product where P_ID = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(request.getParameter("P_ID")));
			ResultSet rs = stmt.executeQuery();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
