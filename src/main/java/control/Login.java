package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie arr[] = request.getCookies();
		if(arr!=null) {
			for(Cookie o : arr) {
				if(o.getName().equals("mssv")) {
					request.setAttribute("mssv", o.getValue());
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
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mssv = request.getParameter("mssv");
		String password = request.getParameter("password");
		StudentDAO cs = new StudentDAO();
		
		if(cs.checkAccount(mssv, password) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("mssv", mssv);
			response.sendRedirect("index");
		}else {
			response.sendRedirect("login");
		}
	}

}
