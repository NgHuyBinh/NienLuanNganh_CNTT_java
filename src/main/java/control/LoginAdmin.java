package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;


@WebServlet(name = "loginadmin", urlPatterns = { "/loginadmin" })
public class LoginAdmin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie arr[] = request.getCookies();
		if(arr!=null) {
			for(Cookie o : arr) {
				if(o.getName().equals("username")) {
					request.setAttribute("username", o.getValue());
				}
			}
		}
		if(arr!=null) {
			for(Cookie o : arr) {
				if(o.getName().equals("password")) {
					request.setAttribute("password", o.getValue());
				}
			}
		}
		request.getRequestDispatcher("/admin/loginadmin.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AdminDAO cs = new AdminDAO();
		if(cs.checkAccount(username, password) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("indexadmin");
			
		}else {
			response.sendRedirect("loginadmin");
		}
	}
}
