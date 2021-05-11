package product;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import com.sun.org.apache.bcel.internal.generic.Select;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/ControlServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*200, // 2MB
maxFileSize=1024*1024*1000,      
maxRequestSize=1024*1024*500) 

public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds;
	Connection conn = null;
	
	

	@Override
	public void init() throws ServletException {
		//在預設模組建立SQL連線
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBDB");
			conn = ds.getConnection();
			if (ds == null) {
				throw new ServletException("Unknown DataSource 'jdbc/DBDB");
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			ProductDAOImpl pDao = new ProductDAOImpl(conn);
			//判斷使用者想執行CRUD的方法
			if (request.getParameter("findByID")!=null) {
				find(request, response, pDao);
			}else if (request.getParameter("findAll")!=null) {
				findAll(request, response, pDao);
			}else if (request.getParameter("updateProduct")!=null) {
				update(request, response, pDao);
			}else if (request.getParameter("deleteProduct")!=null) {
				delete(request, response, pDao);
			}else if (request.getParameter("insertProduct")!=null) {
				insert(request, response, pDao);
			}else if (request.getParameter("findAllToUser")!=null) {
				findAllToUser(request, response, pDao);
			}else if (request.getParameter("findForUser")!=null) {
				findForUser(request, response, pDao);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void find(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao) throws ServletException, IOException {
		pDao.findProductByProductNo(request.getParameter("P_ID"));
		HttpSession session = request.getSession();
		session.setAttribute("find", pDao.findProductByProductNo(request.getParameter("P_ID")));
		request.getRequestDispatcher("/product/productList.jsp").forward(request, response);
		
	}
	protected void findForUser(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao) throws ServletException, IOException {
		pDao.findProductByProductNo(request.getParameter("P_ID"));
		HttpSession session = request.getSession();
		session.setAttribute("find", pDao.findProductByProductNo(request.getParameter("P_ID")));
		request.getRequestDispatcher("/product/productForUser.jsp").forward(request, response);
		
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao) throws ServletException, IOException {
		//建立一個arraylist裝daoimpl方法找出來的資料
		ArrayList<ProductBean> list = pDao.findAll();
		//把arraylist放進session裡面
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		request.getRequestDispatcher("/product/productList.jsp").forward(request, response);
	}
	protected void findAllToUser(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao) throws ServletException, IOException {
		//建立一個arraylist裝daoimpl方法找出來的資料
		ArrayList<ProductBean> list = pDao.findAll();
		//把arraylist放進session裡面
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		request.getRequestDispatcher("/product/productForUser.jsp").forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao)	throws ServletException, IOException {
		//儲存影片
		Part partVideo = request.getPart("P_Video");
		String videoName = request.getParameter("P_ID");
		String fileName = partVideo.getSubmittedFileName();
		String fileType = partVideo.getContentType();
		String type = "." + fileType.split("/")[1];
		String savePath = "D:\\Program\\legendary-repository\\LegendaryWorkspace\\AwesomeProject\\src\\main\\webapp\\product\\File"+ File.separator + videoName+ type;
		File fileSaveDir = new File(savePath);
		if (fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		InputStream in = partVideo.getInputStream();
		OutputStream out = new FileOutputStream(savePath);
		
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = in.read(buffer))!=-1) {
			out.write(buffer,0,length);
		}
		in.close();
		out.close();
		//儲存圖片
		Part partImg = request.getPart("P_Img");
		String imgName = request.getParameter("P_ID")+"Pic";
		String fName = partImg.getSubmittedFileName();
		String fType = partImg.getContentType();
		String ImgType = "." + fType.split("/")[1];
		String saveImgPath = "D:\\Program\\legendary-repository\\LegendaryWorkspace\\AwesomeProject\\src\\main\\webapp\\product\\File"+ File.separator + imgName+ ImgType;
		File imgSaveDir = new File(saveImgPath);
		if (imgSaveDir.exists()) {
			imgSaveDir.mkdir();
		}
		InputStream imgIn = partImg.getInputStream();
		OutputStream imgOut = new FileOutputStream(saveImgPath);
		
		while ((length = imgIn.read(buffer))!=-1) {
			imgOut.write(buffer,0,length);
		}
		imgIn.close();
		imgOut.close();
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
				//把裝好參數的bean使用daoimpl update方法
				pDao.updateProduct(pBean);
				request.getRequestDispatcher("/product/index.jsp").forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao)	throws ServletException, IOException {
		pDao.deleteProduct(request.getParameter("P_ID"));
		request.getRequestDispatcher("/product/index.jsp").forward(request, response);
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response, ProductDAOImpl pDao)	throws ServletException, IOException {
		//儲存影片
		Part partVideo = request.getPart("P_Video");
		String videoName = request.getParameter("P_ID");
		String fileName = partVideo.getSubmittedFileName();
		String fileType = partVideo.getContentType();
		String type = "." + fileType.split("/")[1];
		String savePath = "D:\\Program\\legendary-repository\\LegendaryWorkspace\\AwesomeProject\\src\\main\\webapp\\product\\File"+ File.separator + videoName+ type;
		File fileSaveDir = new File(savePath);
		if (fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		InputStream in = partVideo.getInputStream();
		OutputStream out = new FileOutputStream(savePath);
		
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = in.read(buffer))!=-1) {
			out.write(buffer,0,length);
		}
		in.close();
		out.close();
		//儲存圖片
		Part partImg = request.getPart("P_Img");
		String imgName = request.getParameter("P_ID")+"Pic";
		String fName = partImg.getSubmittedFileName();
		String fType = partImg.getContentType();
		String ImgType = "." + fType.split("/")[1];
		String saveImgPath = "D:\\Program\\legendary-repository\\LegendaryWorkspace\\AwesomeProject\\src\\main\\webapp\\product\\File"+ File.separator + imgName+ ImgType;
		File imgSaveDir = new File(saveImgPath);
		if (imgSaveDir.exists()) {
			imgSaveDir.mkdir();
		}
		InputStream imgIn = partImg.getInputStream();
		OutputStream imgOut = new FileOutputStream(saveImgPath);
		
		while ((length = imgIn.read(buffer))!=-1) {
			imgOut.write(buffer,0,length);
		}
		imgIn.close();
		imgOut.close();

		//新增一個bean放參數
		ProductBean pBean = new ProductBean();
		pBean.setP_Class(request.getParameter("P_Class"));
		pBean.setP_DESC(request.getParameter("P_DESC"));
		pBean.setP_ID(request.getParameter("P_ID"));
		pBean.setP_Img(saveImgPath);
		pBean.setP_Name(request.getParameter("P_Name"));
		pBean.setP_Price(Integer.parseInt(request.getParameter("P_Price")));
		pBean.setP_Video(savePath);
		pBean.setU_ID(request.getParameter("U_ID"));
		//把裝好參數的bean使用daoimpl insert方法
		pDao.insertProduct(pBean);
		
		request.getRequestDispatcher("/product/index.jsp").forward(request, response);
	}

}
