<%@page import="entity.Room"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="context.DBContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="entity.Student"%>
<%@ include file="/admin/headeradmin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="spacer services wowload fadeInUp">
		<h1 class="container">Danh sách phòng báo cáo luận văn</h1>
		<div style="text-align:center;margin-top: 1%;"><h2 class="container" >Tuần báo cáo tập trung</h2></div>
				<div style="text-align:center;">
					<h3 class="container" ><b>Từ ngày 24-04-2023 đến ngày 29-04-2023 </b></h3>
				</div>

        <div class="container">
        	<button class='btn btn-success' style="text-align:center;margin-top: 1%; margin-left: 1%;margin-bottom:1%;border-radius: 5%;" id="insertroom">
        		<a href="roomroom" style="color: black;">Quản lý phòng báo cáo</a>
        	</button>
        	<button class='btn btn-success' style="text-align:center;margin-top: 1%; margin-bottom:1%; border-radius: 5%;" id="insertregistration">
        		<a href="registrationplus"  style="color: black;">Quản lý lịch phòng</a>
        	</button>
			<table class="table table-bordered" style="width : 1600px;font-size: 20px;">
				<thead class="table-dark">
					<th style="border: 2px solid black;">STT</th>
					<th style="border: 2px solid black;">Phòng</th> 
					<th style="border: 2px solid black;">Ngày</th>
					<th style="border: 2px solid black;">Buổi</th>
					<th style="border: 2px solid black;">Số lượng hiện tại</th>
					<th style="border: 2px solid black;">Số lượng tối đa</th>	
					<th style="border: 2px solid black;width: 190px;">Danh sách sinh viên</th>		
				</thead>
				<tbody id="tbody">
				<%
					
					try {
						String sql = "select registration.id,phong,ngaydangky,buoi,soluongtoida,soluonghientai from registration, room where room.id = registration.room_id";
						Connection conn = new DBContext().getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						int i =0;
						while(rs.next()) {i++;
				%>
					<tr>
						<td style="border: 2px solid black;"><%=i %></td>
						<td style="border: 2px solid black;"><%=rs.getString("phong") %></td>
						<td style="border: 2px solid black;"><%=rs.getDate("ngaydangky") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("buoi") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("soluonghientai") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("soluongtoida") %></td>
						<td style="border: 2px solid black;" class="xemxem" data-id=<%=rs.getInt("id") %> data-toggle="modal" data-target="#xemdanhsach">
						<a>Xem danh sách</a>
						
						</td>
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



<!--xem danh sách sinh viên từng phần  -->
 <!-- The Modal -->
<div class="modal fade" id="xemdanhsach">
  <div class="modal-dialog modal-lg modal-dialog-scrollable">
    <div class="modal-content">
      <div class="modal-header">
        <h3 class="modal-title"><b>Danh sách sinh viên</b></h3>
      </div> 
      <div class="modal-body" style="font-size: 13px;">
        <table class="table table-bordered table-hover">
          <thead class="thead-light">
            <tr>
              <th class="text-center">STT</th>
              <th class="text-center">MSSV</th>
              <th class="text-center">Họ tên</th>
              <th class="text-center">Số điện thoại</th>
              <th class="text-center">Email</th>
              <th class="text-center">Giới tính</th>
              <th class="text-center">Địa chỉ</th>
            </tr>
          </thead>
          <tbody id="xemne">
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger btn-lg" data-dismiss="modal">Đóng</button>
      </div>
    </div>
  </div>
</div>


  
<%@ include file="/admin/footeradmin.jsp" %>