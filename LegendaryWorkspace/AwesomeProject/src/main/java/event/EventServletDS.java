package event;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import event.EventBeanpag.EventBean;

/**
 * Servlet implementation class EventServletDS
 */
@WebServlet("/EventServletDS")
public class EventServletDS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;

		try {

			// 建立Context Object,連到JNDI Server
			ctxt = new InitialContext();

			// 使用JNDI API找到DataSource
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/DBDB");
			// jdbc/EmployeeDB

			// 向DataSource要Connection
			conn = ds.getConnection();

			// 建立Database Access Object,負責Table的Access
			EventDAO EventDAO = new EventDAO(conn);

			// 如果要編碼值為UTF-8
			request.setCharacterEncoding("UTF-8");

			if (request.getParameter("QUERY") != null) {
				processQuery(request, response, EventDAO);
			}

			if (request.getParameter("UPDATE") != null) {
            //request.getRequestDispatcher("/enterUPDATE.jsp").forward(request, response);
			//從findAllEventBean.jsp送來的資料 
				processUpdate(request, response, EventDAO);
			}

			if (request.getParameter("UPDATE_home") != null) {
				request.getRequestDispatcher("/event/enterUPDATE_HOME.jsp").forward(request, response);
			//從首頁更新按鈕送來的資料
            //processUpdate(request, response, EventDAO);
			}
			if (request.getParameter("updhomesubmit") != null) {
				processUpdateForm(request, response, EventDAO);
			//從首頁更新按鈕到enterUPDATE_HOME.jsp 後送過來的資料
            //processUpdate(request, response, EventDAO);
			}
			
			
			if (request.getParameter("delete") != null) {
				processdelete(request, response, EventDAO);
			}

			if (request.getParameter("Add") != null) {
				request.getRequestDispatcher("/event/enterAdd.jsp").forward(request, response);

			}

			if (request.getParameter("Home") != null) {
				request.getRequestDispatcher("/event/NewFile.jsp").forward(request, response);
			}

			
			if (request.getParameter("AllQUERY") != null) {

				findAllEventBean(request, response, EventDAO);

			}
			if (request.getParameter("updsubmit") != null) {
//				processUpdate(request, response, EventDAO);
				processUpdateForm(request, response, EventDAO);
				
			}
			
			if (request.getParameter("addsubmit") != null) {
				processAdd(request, response, EventDAO);
				
			}
		} catch (NamingException ne) {
			System.out.println("Naming Service Lookup Exception");
		} catch (SQLException e) {
			System.out.println("Database Connection Error");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Connection Pool Error!");
			}
		}
	}

//新增資料	

	private void processAdd(HttpServletRequest request, HttpServletResponse response, EventDAO EventDAO)
			throws SQLException, IOException, ServletException {

		String UID = request.getParameter("uid");
		String AName = request.getParameter("aname");
		String AID = request.getParameter("aid");
		String ADATE = request.getParameter("adate");
		String ACOIN = request.getParameter("acoin");

		EventBean EventBean = new EventBean((Integer.parseInt(UID)), AName, AID, ADATE, ACOIN);
		if (EventBean == null)
			showError(response, "找不到這個uidxxx" + UID);
		else {
//	    	EventBean.setUid(Integer.parseInt(UID));
//	    	EventBean.setAname(AName);
			if (EventDAO.insertDept(EventBean))
				findAllEventBean(request, response, EventDAO);
			else
				showError(response, "更新錯誤");
		}
	}

//刪除資料
	private void processdelete(HttpServletRequest request, HttpServletResponse response, EventDAO EventDAO)
			throws SQLException, IOException, ServletException {

		String uidno = request.getParameter("uid");
//		 String dname = request.getParameter("dname");

		EventBean EventBean = EventDAO.findDept(Integer.parseInt(uidno));
		if (EventBean == null)
			showError(response, "找不到這個uid" + uidno);
		else {

			if (EventDAO.deleteDept(Integer.parseInt(uidno)))
				findAllEventBean(request, response, EventDAO);
			else
				showError(response, "更新錯誤");
		}

	}

//更新資料
	private void processUpdate(HttpServletRequest request, HttpServletResponse response, EventDAO EventDAO)
			throws SQLException, IOException, ServletException {
		String uidno = request.getParameter("uid");
		String aname = request.getParameter("aname");
		String aid = request.getParameter("aid");
		String adate = request.getParameter("adate");
		String acoin = request.getParameter("acoin");

		EventBean EventBean = EventDAO.findDept(Integer.parseInt(uidno));
		if (EventBean == null)
			showError(response, "找不到這個uid" + uidno);
		else {
			EventBean.setAname(aname);
			EventBean.setUid(Integer.parseInt(uidno));
			EventBean.setAid(aid);
			EventBean.setAdate(adate);
			EventBean.setAcoin(acoin);
			if (EventDAO.updateDept(EventBean)) {
//				findAllEventBean(request, response, EventDAO);
			request.getSession(true).setAttribute("UPDATE_EventBean", EventBean);
			request.getRequestDispatcher("/event/enterUPDATE.jsp").forward(request, response);
			}
				
			else
				showError(response, "更新錯誤");
		}
	}
	private void processUpdateForm
(HttpServletRequest request, HttpServletResponse response, EventDAO EventDAO)
			throws SQLException, IOException, ServletException {
		String uidno = request.getParameter("uid");
		String aname = request.getParameter("aname");
		String aid = request.getParameter("aid");
		String adate = request.getParameter("adate");
		String acoin = request.getParameter("acoin");

		EventBean EventBean = EventDAO.findDept(Integer.parseInt(uidno));
		if (EventBean == null)
			showError(response, "找不到這個uid" + uidno);
		else {
			EventBean.setAname(aname);
			EventBean.setUid(Integer.parseInt(uidno));
			EventBean.setAid(aid);
			EventBean.setAdate(adate);
			EventBean.setAcoin(acoin);
			if (EventDAO.updateDept(EventBean)) {
			findAllEventBean(request, response, EventDAO);
//			request.getSession(true).setAttribute("UPDATE_EventBean", EventBean);
//			request.getRequestDispatcher("/enterUPDATE.jsp").forward(request, response);
			}
				
			else
				showError(response, "更新錯誤");
		}
	}

//查詢資料
	private void processQuery(HttpServletRequest request, HttpServletResponse response, EventDAO EventDAO)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		// 讀取部門代號
		String Uid = request.getParameter("uid");

		// 透過DAO元件Access Dept Table
		EventBean EventBean = EventDAO.findDept(Integer.parseInt(Uid));
		if (EventBean == null)
			showError(response, " 找不到這個UID " + Uid);
		else {
			request.getSession(true).setAttribute("reg_EventBean", EventBean);
			request.getRequestDispatcher("/event/Confirmationform.jsp").forward(request, response);
//	                showForm(response, EventBean);
		}

	}

	private void findAllEventBean(HttpServletRequest request, HttpServletResponse response, EventDAO EventDAO)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		ArrayList<EventBean> list = EventDAO.findAllEventBean();
		request.setAttribute("all", list);
		request.getRequestDispatcher("/event/findAllEventBean.jsp").forward(request, response);
	}

//錯誤顯示
	private void showError(HttpServletResponse response, String message) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Department Form</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY BGCOLOR='#FDF5E6'>");
		out.println("message:" + message);
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

//秀出畫面
	private void showForm(HttpServletResponse response, EventBean EventBean) throws IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Department Form</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY BGCOLOR='#FDF5E6'>");
		out.println("<H1 ALIGN='CENTER'>Department Form</H1>");
		out.println("<FORM ACTION=./EventServletDS>");
		out.println("Uid No:<INPUT TYPE='TEXT' NAME='Uid' VALUE='" + EventBean.getUid() + "'><BR>");
		out.println("Aname Name:  <INPUT TYPE='TEXT' NAME='Aname' VALUE='" + EventBean.getAname() + "'><BR>");
		out.println("getAid No:<INPUT TYPE='TEXT' NAME='Aid' VALUE='" + EventBean.getAid() + "'><BR>");
		out.println("Adate :  <INPUT TYPE='TEXT' NAME='Adate' VALUE='" + EventBean.getAdate() + "'><BR>");
		out.println("Acoin:<INPUT TYPE='TEXT' NAME='Acoin' VALUE='" + EventBean.getAcoin() + "'><BR>");

		out.println("  <CENTER>");
		out.println("<INPUT NAME='QUERY'  TYPE='SUBMIT' VALUE='QUERY'>");
		out.println("<INPUT NAME='UPDATE' TYPE='SUBMIT' VALUE='UPDATE'>");
		out.println("</CENTER>");
		out.println("</FORM>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
