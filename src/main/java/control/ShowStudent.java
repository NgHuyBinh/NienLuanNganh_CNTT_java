package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import entity.Student;
import entity.Student;

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet(name = "showstudent", urlPatterns = { "/showstudent" })
public class ShowStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);

		Student cs = new StudentDAO().getStudentById(id);
		request.setAttribute("student", cs);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		String mssv = request.getParameter("mssv");
		String password = request.getParameter("password");
		String hoten = request.getParameter("hoten");
		String ngaysinh = request.getParameter("ngaysinh");
		String gioitinh = request.getParameter("gioitinh");
		String diachi = request.getParameter("diachi");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		
		response.sendRedirect("customer");
	}

}
