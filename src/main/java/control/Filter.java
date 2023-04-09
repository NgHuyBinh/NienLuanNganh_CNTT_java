package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.DBContext;

/**
 * Servlet implementation class Filter
 */
@WebServlet(name = "filter", urlPatterns = { "/filter" })
public class Filter extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("buoi")!=null && request.getParameter("phong")!=null && request.getParameter("ngay")!=null) {
			
			String buoi = request.getParameter("buoi");
			String ngay = request.getParameter("ngay");
			String phong = request.getParameter("phong");
			try {
				String sql = "select phong,ngaydangky,buoi,soluonghientai,soluongtoida from registration,room where room.id = registration.room_id and buoi like CONCAT('%',? ,'%') and room_id like CONCAT('%',? ,'%') and ngaydangky like CONCAT('%',? ,'%')";
				Connection conn = new DBContext().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, buoi);

				ps.setString(2, phong);
				ps.setString(3,ngay);
				ResultSet rs = ps.executeQuery();
				PrintWriter out = response.getWriter();
				int i = 0;
				while(rs.next()) {i++;
					out.println("<tr>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+i+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString(1)+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getDate(2)+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString(3)+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString(4)+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString(5)+"</td>\r\n"
							+ "					</tr>");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
						
		}
		
	}

}
