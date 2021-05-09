package cart;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/teeest")
public class teeest extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//    	List<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");
//    	response.getWriter().print(cart);
		
//		String test22 = "www00033kkk";
//		String noAlphabets =  CartControllerServlet.stripNonDigits(test22); // 00033
//		int pureInt = Integer.parseInt(noAlphabets);
//		System.out.println(pureInt);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		System.out.println(sdf.format(calendar.getTime()));
//		try {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(System.currentTimeMillis());
//		System.out.println(sdf.format(calendar.getTime()));
//		String now = sdf.toString();
//		System.out.println(sdf);
//		
////		利用 DateFormat 來parse 日期的字串
//		DateFormat df = DateFormat.getDateInstance();
//			
//		Date date = df.parse("2009/1/1");
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(System.currentTimeMillis());
//		System.out.println(sdf.format(calendar.getTime()));
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		

		
	}

}
