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

import com.sun.org.apache.bcel.internal.generic.Select;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds;
	Connection conn = null;
	

	@Override
	public void init() throws ServletException {
		//在預設模組建立SQL連線
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/EmployeeDB");
			conn = ds.getConnection();
			if (ds == null) {
				throw new ServletException("Unknown DataSource 'jdbc/EmployeeDB");
			}

		} catch (NamingException ex) {
			ex.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		try {
			ProductDAOImpl pDao = new ProductDAOImpl(conn);
			//判斷使用者想執行CRUD的方法
			
			if (request.getParameter("findByID")!=null) {
				find(request, response, pDao);
			}else if (request.getParameter("findAll")!=null) {
				findAll(request, response, pDao);
			}
			
			
			
			
			
			//String select = request.getParameter("name");
			//String method = "findAll";
//			if (select.equals("findByID")) {
//				find(request, response, pDao);
//			}else if (select.equals("findAll")) {
//				findAll(request, response,pDao);
//			}else if (select.equals("update")) {
//				update(request, response, pDao);
//			}else if (select.equals("delete")) {
//				delete(request, response, pDao);
//			}else if (select.equals("insert")) {
//				insert(request, response, pDao);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void find(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao) throws ServletException, IOException {
		pDao.findProductByProductNo(request.getParameter("P_ID"));
		request.getRequestDispatcher("/product/productList.jsp").forward(request, response);
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao) throws ServletException, IOException {
		//建立一個arraylist裝daoimpl方法找出來的資料
		ArrayList<ProductBean> list = pDao.findAll();
		//把arraylist放進session裡面
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		request.getRequestDispatcher("/product/productList.jsp").forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao)	throws ServletException, IOException {

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao)	throws ServletException, IOException {
		pDao.deleteProduct(request.getParameter("P_ID"));
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao)	throws ServletException, IOException {
		//新增一個bean放參數
		ProductBean pBean = new ProductBean();
		pBean.setP_Class(request.getParameter("P_Class"));
		pBean.setP_DESC(request.getParameter("P_DESC"));
		pBean.setP_ID(request.getParameter("P_ID"));
		pBean.setP_Img(request.getParameter("P_Img"));
		pBean.setP_Name(request.getParameter("P_Name"));
		pBean.setP_Price(Integer.parseInt(request.getParameter("P_Price")));
		pBean.setP_Video(request.getParameter("P_Video"));
		pBean.setU_ID(request.getParameter("U_ID"));
		//把裝好參數的bean使用daoimpl insert方法
		pDao.insertProduct(pBean);
		
		request.getRequestDispatcher("/product/productList.jsp").forward(request, response);
	}

}
