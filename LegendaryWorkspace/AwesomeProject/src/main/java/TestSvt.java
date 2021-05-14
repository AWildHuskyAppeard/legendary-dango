
/** Servlet檔和這個檔案放在同一目錄下(可以依需求往下建資料夾)*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/TestSvt")
public class TestSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Vector<String> vectorTest = new Vector<String>();
		vectorTest.clone();
		
		Collection<Part> parts = request.getParts();
		parts.forEach(new Consumer<Part>() {
			@Override
			public void accept(Part t) {
				System.out.println(t);
				
			}
		});
		parts.forEach(e -> System.out.println(e));
		parts.forEach(System.out::println);
		
		
//		Cookie[] cookies = request.getCookies();
//		Enumeration<String> headerNames = request.getHeaderNames();
//		int counter = 0;
//		while(headerNames.hasMoreElements()) {
//			counter++;
//			String headerName = headerNames.nextElement();
//			String headerContents = request.getHeader(headerName);
//			System.out.println(counter + "：" +  headerName + " = " + headerContents);
//		}
		

		
		
//		Object AL1 = null;
//		List L1 = (List) AL1;
//		System.out.println(L1);
	}
}
