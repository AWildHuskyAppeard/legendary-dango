package question;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.*;

/**
 * Servlet implementation class QuesServletDS
 */
@WebServlet("/QuesServletDS")
public class QuesServletDS extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		DataSource ds = null;
		InitialContext ctxt = null;
		Connection conn = null;

		try {

			// 建立Context Object,連到JNDI Server
			ctxt = new InitialContext();

			// 使用JNDI API找到DataSource
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/DBDB");

			// 向DataSource要Connection
			conn = ds.getConnection();

			// 建立Database Access Object,負責Table的Access
			QuesDAO quesDAO = new QuesDAO(conn);

			// 如果要編碼值為UTF-8
			request.setCharacterEncoding("UTF-8");

			if (request.getParameter("QUERY") != null) {
				processQuery(request, response, quesDAO);
			}

			if (request.getParameter("UPDATE") != null) {
				processUpdate(request, response, quesDAO);
			}

			if (request.getParameter("DELETE") != null) {
				processDelete(request, response, quesDAO);
			}

			if (request.getParameter("CREATE") != null) {
				processCreate(request, response, quesDAO);
			}
			
			if (request.getParameter("AllQUERY") != null) {
			    findAllQuesBean(request, response, quesDAO);
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

//修改
	private void processUpdate(HttpServletRequest request, HttpServletResponse response, QuesDAO quesDAO)
			throws SQLException, IOException {
		String Q_ID = request.getParameter("Q_ID");
		String Q_Type = request.getParameter("Q_Type");
		String Q_Ques = request.getParameter("Q_Ques");
		String Q_Selection = request.getParameter("Q_Selection");
		String Q_Ans = request.getParameter("Q_Ans");
		String P_Class = request.getParameter("P_Class");


		QuesBean ques = quesDAO.findQues(Integer.parseInt(Q_ID));
		if (ques == null)
			showError(response, " can not find this no" + Q_ID);
		else {
			ques.setQ_ID(Integer.parseInt(Q_ID));
			ques.setQ_Type(Q_Type);
			ques.setQ_Ques(Q_Ques);
			ques.setQ_Selection(Q_Selection);
			ques.setQ_Ans(Q_Ans);
			ques.setP_Class(P_Class);

			if (quesDAO.updateQues(ques))
				showForm(response, ques);
			else
				showError(response, " update failure");
		}
	}

//查詢
	private void processQuery(HttpServletRequest request, HttpServletResponse response, QuesDAO quesDAO)
			throws SQLException, IOException {
		// 讀取部門代號
		String Q_ID = request.getParameter("Q_ID");

		// 透過DAO元件Access Dept Table
		// 前端送過來都為字串,需進行轉型
		QuesBean ques = quesDAO.findQues(Integer.parseInt(Q_ID));
		if (ques == null)
			showError(response, " can not find this department no" + Q_ID);
		else
			showForm(response, ques);

	}

	// 新增
	private void processCreate(HttpServletRequest request, HttpServletResponse response, QuesDAO quesDAO)
			throws SQLException, IOException {

		String Q_ID = request.getParameter("Q_ID");
		String Q_Type = request.getParameter("Q_Type");
		String Q_Ques = request.getParameter("Q_Ques");
		String Q_Selection = request.getParameter("Q_Selection");
		String Q_Ans = request.getParameter("Q_Ans");
		String P_Class = request.getParameter("P_Class");

		QuesBean QuesData = new QuesBean(Integer.parseInt(Q_ID), Q_Type, Q_Ques, Q_Selection, Q_Ans, P_Class);
	
		if (QuesData == null)
			showError(response, " can not find this ID" + Q_ID);
		else {
			QuesData.setQ_ID(Integer.parseInt(Q_ID));
			QuesData.setQ_Type(Q_Type);
			QuesData.setQ_Ques(Q_Ques);
			QuesData.setQ_Selection(Q_Selection);
			QuesData.setQ_Ans(Q_Ans);
			QuesData.setP_Class(P_Class);
			
			if (quesDAO.insertQues(QuesData)) 
				showForm(response,QuesData);
			else 
				showError(response," insert failure");

/*			if (quesDAO.insertQues(Integer.parseInt(Q_ID), Q_Type, Q_Ques, Q_Selection, Q_Ans, P_Class) != -1)
				showForm(response, QuesData);
			else
				showError(response, " insert failure"); */
		}
	}

	// 刪除資料
	private void processDelete(HttpServletRequest request, HttpServletResponse response, QuesDAO quesDAO)
			throws SQLException, IOException {

		String Q_ID = request.getParameter("Q_ID");

		QuesBean Quesdata = quesDAO.findQues(Integer.parseInt(Q_ID));
		if (Quesdata == null)
			showError(response, "can't not find ID:" + Q_ID);
		else {
			System.out.println("ID:"+ Q_ID +" 刪除成功!");

			if (quesDAO.deleteQues(Integer.parseInt(Q_ID)))
				showForm(response, Quesdata);
			else
				showError(response, "更新錯誤");
		}

	}
	
	//搜尋全部
	private void findAllQuesBean(HttpServletRequest request, HttpServletResponse response, QuesDAO quesDAO)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		ArrayList<QuesBean> list = quesDAO.findAllQuesBean();
		request.setAttribute("all", list);
		request.getRequestDispatcher("/question/findAllQuesBean.jsp").forward(request, response);
	}
	
	
	
	//錯誤顯示
	private void showError(HttpServletResponse response, String message) 
			throws IOException {
	    response.setContentType("text/html;charset=UTF-8");              
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>題庫</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY BGCOLOR='#FDF5E6'>");
		out.println("message:" + message);
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

	//秀出畫面
	private void showForm(HttpServletResponse response, QuesBean ques) 
			throws IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>題庫</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY BGCOLOR='#FDF5E6'>");
		out.println("<H1 ALIGN='CENTER'>題庫</H1>");
		out.println("<FORM ACTION='./QuesServletDS'>");
		out.println("題目編號: " + ques.getQ_ID() + "<BR>");
		out.println("題目種類: " + ques.getQ_Type() + "<BR>");
		out.println("題　目　: " + ques.getQ_Ques() + "<BR>");
		out.println("選　項　: " + ques.getQ_Selection() + "<BR>");
		out.println("正　解　: " + ques.getQ_Ans() + "<BR>");
		out.println("題目類型: " + ques.getP_Class() + "<BR>");
	
		out.println("<CENTER>");
//		out.println("<INPUT NAME='QUERY'  TYPE='SUBMIT' VALUE='QUERY'>");
//		out.println("<INPUT NAME='UPDATE' TYPE='SUBMIT' VALUE='UPDATE'>");
//		out.println("<INPUT NAME='DELETE' TYPE='SUBMIT' VALUE='DELETE'>");
//		out.println("<INPUT NAME='CREATE' TYPE='SUBMIT' VALUE='CREATE'>");
		out.println("</CENTER>");
		out.println("</FORM>");
		out.println("<a href=\"/AwesomeProject/question/QuesFormDS.jsp\">題庫首頁</a>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

}