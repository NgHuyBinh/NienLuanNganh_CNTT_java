package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDAO;
import entity.Student;

/**
 * Servlet implementation class ViewStudents
 */
@WebServlet(name = "viewstudents", urlPatterns = { "/viewstudents" })
public class ViewStudents extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		List<Student> list = new RegistrationDAO().viewStudent(id);
		PrintWriter out =response.getWriter();
		int i=0;
		for(Student o : list) {i++;
			out.println("<table class='table table-bordered container' style='width : 1300px;'>\r\n"
					+ "				<thead class=\"table-dark\">\r\n"
					+ "					<th style=\"border: 2px solid black;\">STT</th>\r\n"
					+ "					<th style=\"border: 2px solid black;\">MSSV</th>\r\n"
					+ "					<th style=\"border: 2px solid black;\">Họ tên</th>\r\n"
					+ "					<th style=\"border: 2px solid black;\">SĐT</th>	\r\n"
					+ "					<th style=\"border: 2px solid black;\">Email</th>			\r\n"
					+ "				</thead>\r\n"
					+ "				<tbody id=\"tbodythemphong\">\r\n"
					+ "					<tr>\r\n"
					+ "						<td>"+i+"</td>\r\n"
					+ "						<td>"+o.getMssv()+"</td>\r\n"
					+ "						<td>"+o.getHoten()+"</td>\r\n"
					+ "						<td>"+o.getSdt()+"</td>\r\n"
					+ "						<td>"+o.getEmail()+"</td>\r\n"
					+ "					</tr>\r\n"
					+ "				\r\n"
					+ "				\r\n"
					+ "					\r\n"
					+ "				</tbody>\r\n"
					+ "			</table>	\r\n");
		}
	}

}
