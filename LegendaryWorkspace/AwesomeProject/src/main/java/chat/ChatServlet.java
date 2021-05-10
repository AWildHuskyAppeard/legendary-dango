package chat;



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

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataSource ds = null;
	    InitialContext ctxt = null;
	    Connection conn = null;
	    
	    try {
	    	ctxt = new InitialContext();
	    	ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/DBDB");
	    	conn = ds.getConnection();
	    	
	    	ChatDAOImpl chatDAOImpl = new ChatDAOImpl(conn);
	    	
	    	request.setCharacterEncoding("UTF-8");
	    	
	    	if (request.getParameter("insert") != null) {
	            processInsert(request,response,chatDAOImpl);
	    	}
	    	if (request.getParameter("find") != null) {
	    		processFind(request,response,chatDAOImpl);
	    	}
	    	
	    }catch (NamingException e) {
	        System.out.println("Naming Service Lookup Exception");  
	    }catch (SQLException e) {
	    	System.out.println("Database Connection Error"); 
	    }finally {
	        try {
	            if (conn != null) conn.close();
	            } catch (Exception e) {
	            System.out.println("Connection Pool Error!");
	            }
	    }
	}
	private void processInsert(HttpServletRequest request, HttpServletResponse response, ChatDAOImpl chatDAOImpl) throws SQLException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		ChatVO newchatvo = new ChatVO();
		newchatvo.setC_ID(request.getParameter("文章編號"));
		newchatvo.setU_ID(request.getParameter("帳號"));
		newchatvo.setC_Date(request.getParameter("日期"));
		newchatvo.setC_Class(request.getParameter("類別"));
		newchatvo.setC_Title(request.getParameter("標題"));
		newchatvo.setC_Conts(request.getParameter("內容"));
		PrintWriter out = response.getWriter();
		out.println("<html>");
	    out.println("<head><title>Chat</title></head>");
	    out.println("<style>");
	    out.println("body{\r\n"
	    		+ "        text-align: center;\r\n"
	    		+ "    }");
	    out.println("</style>");
	    out.println("<body bgcolor=\"lightblue\">");
	    if(chatDAOImpl.insertChat(newchatvo)==true) {
	    	out.println("<h3>文章新增完畢</h3>");
	    }
		out.println("</body></html>");
	    out.close();
	}
	private void processFind(HttpServletRequest request, HttpServletResponse response, ChatDAOImpl chatDAOImpl) throws SQLException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		ArrayList<ChatVO> chat = chatDAOImpl.findAllChat();
		PrintWriter out = response.getWriter();
		out.println("<html>");
	    out.println("<head><title>Chat</title>");
	    out.println("<style>");
	    out.println("body{\r\n"
	    		+ "        text-align: center;\r\n"
	    		+ "    }");
	    out.println("table{\r\n"
	    		+ "        width: 60%;\r\n"
	    		+ "        border: 2px solid black;\r\n"
	    		+ "        margin: auto;\r\n"
	    		+ "        background-color: white;\r\n"
	    		+ "    }");
	    out.println("td{\r\n"
	    		+ "    border-bottom: 1px solid blue;\r\n"
	    		+ "    }");
	    out.println("td#class{\r\n"
	    		+ "        width: 15%;\r\n"
	    		+ "        text-align: center;\r\n"
	    		+ "    }");
	    out.println("td#time{\r\n"
	    		+ "        width: 15%;\r\n"
	    		+ "        text-align: center;\r\n"
	    		+ "    }");
	    out.println("</style>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"lightblue\">");
	    out.println("<header><h1>StudieHub 討論區</h1></header>");
	    out.println("<table>");
	    String chat1 = chat.toString();
		out.print(chat1.replaceAll(",", "").replace("[","").replace("]", ""));
		out.println("</table>");
		out.println("</body></html>");
	    out.close();
	}

}
