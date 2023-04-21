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
import dao.RegisterDAO;
import dao.RoomDAO;

/**
 * Servlet implementation class InsertRoom
 */
@WebServlet(name = "insertroom", urlPatterns = { "/insertroom" })
public class InsertRoom extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Tieng viet jsp
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
			String phong = request.getParameter("phong");
			int soluong = Integer.parseInt(request.getParameter("soluong"));	
			new RoomDAO().insertRoom(phong, soluong);
			// lấy dư liệu vào bảng
			try {
				String sql = "SELECT * FROM room";
				Connection conn = new DBContext().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				int i =0;
				PrintWriter out = response.getWriter();
				while(rs.next()) {
					i++;
					out.println("<tr>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+i+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getInt("id") +"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString("phong") +"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getInt("soluongtoida")+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\" style=\"text-align: center;\">\r\n"
							+ "						      <button class='btn btn-danger xoaphong' data-id='"+rs.getInt("id")+"'>Xóa</button>\r\n"
							+ "						</td>\r\n"
							+ "					</tr>	");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
