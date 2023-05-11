package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FeekbackStudentDAO;
import dao.RegisterroomDAO;
import dao.StudentDAO;

/**
 * Servlet implementation class GuiYeuCau
 */
@WebServlet("/GuiYeuCau")
public class GuiYeuCau extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String datetime = request.getParameter("datetime");
		HttpSession session = request.getSession();
		int id = new StudentDAO().getIdByMSSV(session.getAttribute("mssv").toString());
		PrintWriter out = response.getWriter();
		if(new RegisterroomDAO().checkSV(id) == true) {
			out.println(1);
			return;
		}
		new RegisterroomDAO().insertRegisterRoom(id, datetime);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  id_student = Integer.parseInt(request.getParameter("id_student"));
		int id_room = Integer.parseInt(request.getParameter("id_room"));
		String noidung = request.getParameter("noidung");
		String datetime = request.getParameter("datetime");
		new FeekbackStudentDAO().insertFeekback(noidung, datetime, id_student, id_room, "0", "");
	}

}
