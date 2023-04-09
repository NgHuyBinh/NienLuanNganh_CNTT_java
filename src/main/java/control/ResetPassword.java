package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet(name = "resetpassword", urlPatterns = { "/resetpassword" })
public class ResetPassword extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passcu = request.getParameter("passcu");
		String passmoi1 = request.getParameter("passmoi1");
		String passmoi2 = request.getParameter("passmoi2");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String mssv = session.getAttribute("mssv").toString();
		// ktra pass  cũ đúng
		if(new StudentDAO().checkPassword(passcu,mssv) == true ) {
			// cập nhật
			new StudentDAO().updatePassword(mssv, passmoi1);
			out.println(1);
		}else {
			out.println(0);
			//sai không cho cập nhật
		}
		
		
	}

}
