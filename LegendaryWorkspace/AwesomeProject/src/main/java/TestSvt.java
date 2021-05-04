
/** Servlet檔和這個檔案放在同一目錄下(可以依需求往下建資料夾)*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestSvt")
public class TestSvt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object AL1 = null;
		List L1 = (List) AL1;
		
		System.out.println(L1);
	}
}
