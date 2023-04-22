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
 * Servlet implementation class ThemLich
 */
@WebServlet(name = "themlich", urlPatterns = { "/themlich" })
public class ThemLich extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String ngaydangky = request.getParameter("ngaydangky");
		String room_id = request.getParameter("room_id");
		String buoi = request.getParameter("buoi");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	
		String sql = "insert into registration(room_id,ngaydangky,buoi,soluonghientai) values (?,?,?,0)";
		try {
			 conn = new DBContext().getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, Integer.parseInt(room_id));
			 ps.setString(2, ngaydangky);
			 ps.setString(3, buoi);
			 ps.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		sql = "select * from registration,room where room.id = registration.room_id";
		try {
			 conn = new DBContext().getConnection();
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 int i=0;
			 PrintWriter out = response.getWriter();
			 while(rs.next()) {
				 i++;
				 out.println("<tr>\r\n"
				 		+ "						<td style=\"border: 2px solid black;\">"+i +"</td>\r\n"
				 		+ "						<td style=\"border: 2px solid black;\">"+rs.getString("phong") +"</td>\r\n"
				 		+ "						<td style=\"border: 2px solid black;\">"+rs.getString("ngaydangky") +"</td>\r\n"
				 		+ "						<td style=\"border: 2px solid black;\">"+rs.getString("buoi") +"</td>\r\n"
				 		+ "						<td style=\"border: 2px solid black;\">"+rs.getInt("soluonghientai") +"</td>\r\n"
				 		+ "						<td style=\"border: 2px solid black;\">"+rs.getInt("soluongtoida") +"</td>\r\n"
				 		+ "						<td style=\"border: 2px solid black;\">\r\n"
				 		+ "							<button class='btn btn-danger xoalichphong' data-toggle=\"modal\" data-id="+rs.getString("id") +">Xóa</button>\r\n"
				 		+ "						</td>\r\n"
				 		+ "					</tr>	");
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
