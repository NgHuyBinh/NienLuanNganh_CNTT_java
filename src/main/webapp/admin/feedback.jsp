<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="context.DBContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="entity.Student"%>
<%@ include file="/admin/headeradmin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<div class="spacer services wowload fadeInUp" >
		<h1 class="container">Danh sách phản hồi cơ sở vật chất</h1>
		<div style="text-align:center; margin-top: 1%;"><h2 class="container" >Tuần báo cáo tập trung </h2></div>
		<div>
			<table class="table table-bordered container" style="width : 1300px;">
				<thead class="table-dark">
					<th style="border: 2px solid black;">STT</th>
					<th style="border: 2px solid black;">Ngày</th> 
					<th style="border: 2px solid black;">Phòng</th>
					<th style="border: 2px solid black;">MSSV</th>
					<th style="border: 2px solid black;">Họ tên sinh viên</th>
					<th style="border: 2px solid black;">Email</th>
					<th style="border: 2px solid black;">Ngày gửi phản hồi</th>
					<th style="border: 2px solid black;">Nội dung phản hồi</th>
				</thead>
				<tbody> 
					<%
					
					try {
						String sql = "select  feedback.id,ngaydangky,phong,mssv,hoten,email,ngayphanhoi,noidung from feedback,student,registration,room ,register where room.id=feedback.room_id and register.registration_id = registration.id and room.id=registration.room_id and student.id=register.student_id";
						Connection conn = new DBContext().getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						int i =0;
						while(rs.next()) {i++;
				%>
					<tr>
						<td style="border: 2px solid black;"><%=i%></td>
						<td style="border: 2px solid black;"><%=rs.getString("ngaydangky") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("phong") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("mssv") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("hoten") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("email") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("ngayphanhoi") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("noidung") %></td>
					</tr>
				<%
				
						}		
					}catch(Exception e){
						System.out.println(e);
					}
					
				%>

				</tbody>
			</table>		
		</div>

</div>

<div class="spacer services wowload fadeInUp" >
		<h1 class="container">Danh sách đăng ký mở thêm phòng</h1>
		<div style="text-align:center;margin-top: 1%;margin-bottom:0%;"><h2 class="container" >Tuần báo cáo tập trung </h2></div>
		<div>
			<table class="table table-bordered container" style="width : 1300px;">
				<thead class="table-dark">
					<th style="border: 2px solid black;">STT</th>
					<th style="border: 2px solid black;">MSSV</th> 
					<th style="border: 2px solid black;">Họ tên</th>
					<th style="border: 2px solid black;">Lớp</th>
					<th style="border: 2px solid black;">Email</th>
					<th style="border: 2px solid black;">Ngày phản hồi</th>
				</thead>
				<tbody> 
					<%
					
					try {
						String sql = "select mssv,hoten,tenlop,email,ngaydangky from registerroom,student,class where student_id=student.id and class_id=class.id";
						Connection conn = new DBContext().getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet cs = ps.executeQuery();
						int i =0;
						while(cs.next()) {i++;
				%>
					<tr>
						<td style="border: 2px solid black;"><%=i%></td>
						<td style="border: 2px solid black;"><%=cs.getString("mssv") %></td>
						<td style="border: 2px solid black;"><%=cs.getString("hoten") %></td>
						<td style="border: 2px solid black;"><%=cs.getString("tenlop") %></td>
						<td style="border: 2px solid black;"><%=cs.getString("email") %></td>
						<td style="border: 2px solid black;"><%=cs.getString("ngaydangky") %></td>
					</tr>
				<%
				
						}		
					}catch(Exception e){
						System.out.println(e);
					}
					
				%>
				</tbody>
			</table>		
		</div>
</div>
<%@ include file="/admin/footeradmin.jsp" %>