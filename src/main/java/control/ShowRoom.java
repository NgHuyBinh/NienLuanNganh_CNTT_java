package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClassDAO;
import dao.RegistrationDAO;
import dao.RoomDAO;
import dao.StudentDAO;
import dao.TeacherDAO;
import entity.Class;
import entity.Room;
import entity.Student;
import entity.Teacher;

/**
 * Servlet implementation class ShowRoom
 */
@WebServlet(name = "showroom", urlPatterns = { "/showroom" })
public class ShowRoom extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("mssv") !=null) {
			HttpSession session = request.getSession();
			String mssv = (String)session.getAttribute("mssv");
			Student s = new StudentDAO().getStudentByMssv(mssv);
			int class_id = Integer.parseInt(s.getClass_id());
			int teacher_id = Integer.parseInt(s.getTeacher_id());
			Class c = new ClassDAO().getClassById(class_id);
			String tenlop = c.getTenlop();
			List<Room> list = new RoomDAO().getAllRoom();
			request.setAttribute("room", list);
			List<String> list1 = new RegistrationDAO().getAllBuoi();
			request.setAttribute("buoi", list1);
			Teacher t = new TeacherDAO().getTeacherById(teacher_id);
			String hoTenGV = t.getHoten();
			request.getRequestDispatcher("rooms.jsp").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
		
	}
}
