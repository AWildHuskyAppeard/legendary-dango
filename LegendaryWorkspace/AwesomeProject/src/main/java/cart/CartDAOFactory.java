package cart;

// 目前沒什麼用處。提醒自己太閒的話有優化的空間而已。

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartDAOFactory")
public class CartDAOFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CartDAOFactory() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


}
