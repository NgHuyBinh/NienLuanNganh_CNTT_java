package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.DBContext;

/**
 * Servlet implementation class ViewStudent
 */
@WebServlet(name = "viewstudent", urlPatterns = { "/viewstudent" })
public class ViewStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		
		String sql = "select mssv,hoten,sdt,email,gioitinh,diachi from registration,register,student where registration.id=registration_id and student.id=student_id and trangthai=1 and registration_id=?";
		
		try {
			 conn = new DBContext().getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, Integer.parseInt(id));
			 rs = ps.executeQuery();
			 int i=0;
			 PrintWriter out = response.getWriter();
			 while(rs.next()) {
				 i++;
				 out.println("					<tr> \r\n"
							+ "						<td>"+i+"</td>\r\n"
							+ "						<td>"+rs.getString("mssv")+"</td>\r\n"
							+ "						<td>"+rs.getString("hoten")+"</td>\r\n"
							+ "						<td>"+rs.getString("sdt")+"</td>\r\n"
							+ "						<td>"+rs.getString("email")+"</td>\r\n"
							+ "						<td>"+rs.getString("gioitinh")+"</td>\r\n"
							+ "						<td>"+rs.getString("diachi")+"</td>\r\n"
							+ "					</tr>\r\n");
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
