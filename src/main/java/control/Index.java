package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClassDAO;
import dao.RegisterDAO;
import dao.RegistrationDAO;
import dao.RoomDAO;
import dao.StudentDAO;
import dao.TeacherDAO;
import entity.Student;
import entity.Teacher;
import entity.Class;
import entity.Registration;
import entity.Room;

/**
 * Servlet implementation class Index
 */
@WebServlet(name = "index", urlPatterns = { "/index" })
public class Index extends HttpServlet {

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
			List<String> list2 = new RegistrationDAO().getAllNgay();
			request.setAttribute("ngay", list2);			
			Teacher t = new TeacherDAO().getTeacherById(teacher_id);
			String hoTenGV = t.getHoten();
			request.setAttribute("Student", s);
			request.setAttribute("tenlop", tenlop);
			request.setAttribute("hoTenGV", hoTenGV);
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
			int student_id = new StudentDAO().getIdByMSSV(session.getAttribute("mssv").toString());
			String trangthai = "0";
			//kIEM TRA student_id => viet ham kiem tra student_id co ton tai trong register (registerDAO) ;
				if(new RegisterDAO().checkStudentId(student_id) != 0) {
					// neu ton tai trong bang register => update
					//update
					new RegisterDAO().updateRegister(student_id, registration_id, trangthai, ghichu);
				}else {
					// ko ton tai thi => insert
					new RegisterDAO().getInsertRegister(student_id, registration_id, trangthai, ghichu);
				}
				
				
			
		}
		
	}
	

}
