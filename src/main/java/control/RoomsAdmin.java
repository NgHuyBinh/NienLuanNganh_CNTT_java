package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;
import dao.ClassDAO;
import dao.RegisterDAO;
import dao.RegistrationDAO;
import dao.RoomDAO;
import dao.StudentDAO;
import dao.TeacherDAO;
import entity.Admin;
import entity.Class;
import entity.Room;
import entity.Student;
import entity.Teacher;

/**
 * Servlet implementation class RoomsAdmin
 */
@WebServlet(name = "roomsadmin", urlPatterns = { "/roomsadmin" })
public class RoomsAdmin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("username") !=null) {
			HttpSession session = request.getSession();
			String username = (String)session.getAttribute("username");
			Admin s = new AdminDAO().getAdminByUsername(username);
			List<Room> list = new RoomDAO().getAllRoom();
			request.setAttribute("room", list);
			List<String> list1 = new RegistrationDAO().getAllBuoi();
			request.setAttribute("buoi", list1);
			List<String> list2 = new RegistrationDAO().getAllNgay();
			request.setAttribute("ngay", list2);	
			request.setAttribute("Admin", s);
			request.getRequestDispatcher("/admin/rooms.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("buoi") != null && request.getParameter("phong")!=null && request.getParameter("ngaydangky")!=null && request.getParameter("ghichu")!=null) {
			String buoi = request.getParameter("buoi");
			String phong = request.getParameter("phong");
			String ngaydangky = request.getParameter("ngaydangky");
			String ghichu= request.getParameter("ghichu");
			int registration_id = new RegistrationDAO().getIdByRoomIdBuoiNgay(phong, buoi, ngaydangky);
			HttpSession session = request.getSession();
		}
	}

}
