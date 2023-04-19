package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import context.DBContext;
import dao.RegisterDAO;
import dao.RegistrationDAO;
import dao.StudentDAO;

/**
 * Servlet implementation class SubAdmin
 */
@WebServlet(name = "subadmin", urlPatterns = { "/subadmin" })
public class SubAdmin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Tieng viet jsp
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//Lay du lieu hung gia tri
			int id = Integer.parseInt(request.getParameter("id"));
			String lydo = request.getParameter("lydo");
			
		//Cap nhat thong qua ham update viet trong reigstedao
			new RegisterDAO().updateHuy(lydo, "2", id);
		//do ra du lieu
			try {
				String sql = "select register.id,phong,ngaydangky,buoi,mssv,hoten,trangthai,ghichu from register,registration,room,student where student.id=student_id and room.id=room_id and registration.id= registration_id";
				Connection conn = new DBContext().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				int i =0;
				PrintWriter out = response.getWriter();

				while(rs.next()) {
				// xử lý if
					String trangthai = "";
					if(rs.getString("trangthai").equals("0") ){
						trangthai = "<button class='btn btn-success' id='xacnhan'>Xác nhận</button><button class='btn btn-danger'  data-toggle='modal' data-id='\\\"+rs.getInt(\\\"id\\\")+\\\"' data-target='#myModal' id='huybo'>Hủy</button>";
					}
					if(rs.getString("trangthai").equals("1") ){
						trangthai = "<button class='btn btn-success'>Đã xác nhận</button>";		        
					}
					if(rs.getString("trangthai").equals("2") ){
					    trangthai = "<button class='btn btn-danger'>Đã hủy</button>";
					}
					i++;
					out.println("<tr>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+i+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString("phong")+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getDate("ngaydangky")+"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString("buoi") +"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString("mssv") +"</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString("hoten") +"</td>\r\n"
							+ "						<td style=\"border: 2px solid black; text-align: center\">\r\n"
							+ trangthai
							+ "						</td>\r\n"
							+ "						<td style=\"border: 2px solid black;\">"+rs.getString("ghichu") +"</td>\r\n"
							+ "					</tr>");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
	}

}
