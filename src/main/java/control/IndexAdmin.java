package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;
import entity.Admin;

@WebServlet(name = "indexadmin", urlPatterns = { "/indexadmin" })
public class IndexAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("username") !=null) {
			HttpSession session = request.getSession();
			String username = (String)session.getAttribute("username");
			Admin s = new AdminDAO().getAdminByUsername("username");			
			request.setAttribute("admin", s);
			request.getRequestDispatcher("indexadmin.jsp").forward(request, response);
		}else {
			response.sendRedirect("loginadmin");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
