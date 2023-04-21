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
import dao.RegistrationDAO;
import dao.RoomDAO;

/**
 * Servlet implementation class InsertRegistration
 */
@WebServlet(name = "insertregistration", urlPatterns = { "/insertregistration" })
public class InsertRegistration extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Tieng viet jsp
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
			int room_id = Integer.parseInt(request.getParameter("room_id"));	
			String ngaydangky = request.getParameter("ngaydangky");
			String buoi = request.getParameter("buoi");
			new RegistrationDAO().insertRegistration(room_id, ngaydangky, buoi, 0);
			// lấy dư liệu vào bảng
			try {
				String sql = "SELECT * FROM registration";
				Connection conn = new DBContext().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				int i =0;
				PrintWriter out = response.getWriter();
				while(rs.next()) {
					i++;
					out.println("	<tr>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+i +"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString("room_id")+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString("ngaydangky+")+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\"><"+rs.getString("buoi")+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getInt("soluonghientai") +"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">\r\n"
							+ "							<button class='btn btn-danger xoalichphong' data-toggle=\"modal\" data-target=\"#xoaregistration\">Xóa</button>\r\n"
							+ "						</td>\r\n"
							+ "					</tr>");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
