

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class EventServletDS
 */
@WebServlet("/EventServletDS")
public class EventServletDS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataSource ds = null;
	    InitialContext ctxt = null;
	    Connection conn = null;

	    
	    try {
	     
	      //建立Context Object,連到JNDI Server
	      ctxt = new InitialContext();

	      //使用JNDI  API找到DataSource
	      ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/DBDB");
	     
	      //向DataSource要Connection
	      conn = ds.getConnection();

	      //建立Database Access Object,負責Table的Access
	      EventDAO EventDAO = new EventDAO(conn);

	      //如果要編碼值為UTF-8
	     request.setCharacterEncoding("UTF-8");

	      if (request.getParameter("QUERY") != null) {
	        processQuery(request,response,EventDAO);
	      } 

	      if (request.getParameter("UPDATE") != null) {
	        processUpdate(request,response,EventDAO);
	      } 

	      if (request.getParameter("delete") != null) {
	    	  processdelete(request,response,EventDAO);
	      } 

	      if (request.getParameter("Add") != null) {
	          processAdd(request,response,EventDAO);
	      } 
	    } catch (NamingException ne) {
	      System.out.println("Naming Service Lookup Exception");  
	    } catch (SQLException e) {
	      System.out.println("Database Connection Error"); 
	    } finally {
	      try {
	        if (conn != null) conn.close();
	      } catch (Exception e) {
	        System.out.println("Connection Pool Error!");
	      }
	    }
	  }
	
	
//新增資料	
	
	private void processAdd(HttpServletRequest request,
            HttpServletResponse response,
            EventDAO EventDAO) throws SQLException, IOException {
		 
		String UID = request.getParameter("deptno");
		String AName = request.getParameter("dname");
		String AID = request.getParameter("aid");
		String ADATE = request.getParameter("adate");
		String ACOIN = request.getParameter("acoin");
		//dsadasd
		EventBean EventBean =new EventBean((Integer.parseInt(UID)), AName, AID, ADATE, ACOIN);
	    if (EventBean == null) showError(response, "找不到這個uidxxx" + UID);
	    else {
//	    	EventBean.setUid(Integer.parseInt(UID));
//	    	EventBean.setAname(AName);
	      if (EventDAO.insertDept(EventBean)) showForm(response,EventBean);
	      else showError(response,"更新錯誤");
	    }
	 }
//刪除資料
	 private void processdelete(HttpServletRequest request,
             HttpServletResponse response,
             EventDAO EventDAO) throws SQLException, IOException {
		 
		 String deptno = request.getParameter("deptno");
//		 String dname = request.getParameter("dname");
		    
		    EventBean EventBean = EventDAO.findDept(Integer.parseInt(deptno));
		    if (EventBean == null) showError(response, "找不到這個uid" + deptno);
		    else {
		    	
		      if (EventDAO.deleteDept(Integer.parseInt(deptno))) showForm(response,EventBean);
		      else showError(response,"更新錯誤");
		    }
		 
	 }
//更新資料
	  private void processUpdate(HttpServletRequest request,
	                             HttpServletResponse response,
	                             EventDAO EventDAO) throws SQLException, IOException {
	    String deptno = request.getParameter("deptno");
	    String dname = request.getParameter("dname");
	    
	    EventBean EventBean = EventDAO.findDept(Integer.parseInt(deptno));
	    if (EventBean == null) showError(response, "找不到這個uid" + deptno);
	    else {
	    	EventBean.setAname(dname);                     
	      if (EventDAO.updateDept(EventBean)) showForm(response,EventBean);
	      else showError(response,"更新錯誤");
	    }
	  }
//查詢資料
	  private void processQuery(HttpServletRequest request, 
	                            HttpServletResponse response,
	                            EventDAO EventDAO) throws SQLException,IOException {
			request.setCharacterEncoding("utf-8");

		  //讀取部門代號
	    String Uid = request.getParameter("deptno");

	    //透過DAO元件Access Dept Table
	    EventBean EventBean = EventDAO.findDept(Integer.parseInt(Uid));
	    if (EventBean == null) showError(response, " 找不到這個UID " + Uid);
	    else              showForm(response, EventBean);

	  }
//錯誤顯示
	  private void showError(HttpServletResponse response, String message)
	                  throws IOException  {
		    response.setContentType("text/html;charset=UTF-8");              
	    PrintWriter out = response.getWriter();
	    out.println("<HTML>");
	    out.println("<HEAD>");
	    out.println("<TITLE>Department Form</TITLE>");
	    out.println("</HEAD>");
	    out.println("<BODY BGCOLOR='#FDF5E6'>");
	    out.println("message:"+ message);                  
	    out.println("</BODY>");
	    out.println("</HTML>");  
	    out.close();
	  }
//秀出畫面
	  private void showForm(HttpServletResponse response, EventBean EventBean)
	                  throws IOException  {
		  
	    response.setContentType("text/html;charset=UTF-8");              
	    PrintWriter out = response.getWriter();
	    out.println("<HTML>");
	    out.println("<HEAD>");
	    out.println("<TITLE>Department Form</TITLE>");
	    out.println("</HEAD>");
	    out.println("<BODY BGCOLOR='#FDF5E6'>");
	    out.println("<H1 ALIGN='CENTER'>Department Form</H1>");                  
	    out.println("<FORM ACTION='./DeptServletDS'>");
	    out.println("Uid No:<INPUT TYPE='TEXT' NAME='Uid' VALUE='" +
	    		EventBean.getUid() + "'><BR>");
	    out.println("Aname Name:  <INPUT TYPE='TEXT' NAME='Aname' VALUE='" +
	    		EventBean.getAname() + "'><BR>");
	    out.println("getAid No:<INPUT TYPE='TEXT' NAME='Aid' VALUE='" +
	    		EventBean.getAid() + "'><BR>");
	    out.println("Adate :  <INPUT TYPE='TEXT' NAME='Adate' VALUE='" +
	    		EventBean.getAdate() + "'><BR>");
	    out.println("Acoin:<INPUT TYPE='TEXT' NAME='Acoin' VALUE='" +
	    		EventBean.getAcoin() + "'><BR>");
	    
	    out.println("  <CENTER>");
	    out.println("<INPUT NAME='QUERY'  TYPE='SUBMIT' VALUE='QUERY'>");
	    out.println("<INPUT NAME='UPDATE' TYPE='SUBMIT' VALUE='UPDATE'>");
	    out.println("</CENTER>");
	    out.println("</FORM>");
	    out.println("</BODY>");
	    out.println("</HTML>");  
	    out.close();
	  }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
