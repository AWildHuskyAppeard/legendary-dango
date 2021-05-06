package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public void init() throws ServletException {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/EmployeeDB");
			if (ds == null) {
				throw new ServletException("Unknown DataSource 'jdbc/EmployeeDB");
			}

		} catch (NamingException ex) {
			ex.printStackTrace();
		}
	}

	public ControlServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		String method = request.getParameter("method");
		String method = "findAll";
		if (method.equals("find")) {
			find(request, response);
		}else if (method.equals("findAll")) {
			findAll(request, response);
		}else if (method.equals("update")) {
			update(request, response);
		}else if (method.equals("delete")) {
			delete(request, response);
		}else if (method.equals("insert")) {
			insert(request, response);
		}

	}

	protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAOImpl dao = new ProductDAOImpl();
		ArrayList<ProductBean> list = dao.findAll();
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		request.getRequestDispatcher("/product/productList.jsp").forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

	}

}
