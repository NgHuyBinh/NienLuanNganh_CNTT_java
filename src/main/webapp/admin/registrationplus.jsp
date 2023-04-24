<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="context.DBContext"%>
<%@page import="java.sql.Connection"%>
<%@ include file="/admin/headeradmin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="spacer services wowload fadeInUp">
		<h1><div class="text-center">Quản lý lịch phòng</div></h1>
		<div style="text-align:center;margin-top: 1%;"><h2 class="container" >Tuần báo cáo tập trung</h2></div>
				<div style="text-align:center;">
					<h3 class="container" ><b>Từ ngày 24-04-2023 đến ngày 29-04-2023 </b></h3>
				</div>
							<div class="table table-bordered container" style="width : 1300px;">
				<button class='btn btn-success  themlichphong' data-toggle="modal" data-target="#themregistration">Thêm lịch phòng</button>
			</div>	
				<table class="table table-bordered container" style="width : 1300px;">
				<thead class="table-dark">
					<th style="border: 2px solid black;">STT</th>
					<th style="border: 2px solid black;">Mã phòng</th> 
					<th style="border: 2px solid black;">Ngày</th>
					<th style="border: 2px solid black;">Buổi</th>
					<th style="border: 2px solid black;">Số lượng hiện tại</th>	
					<th style="border: 2px solid black;">Số lượng toi da</th>	
					<th style="border: 2px solid black; width: 150px">Thao tác</th>				
				</thead>
				<tbody id="tbodythemlich">
			<%
					
					try {
						String sql = "select * from registration,room where room.id = registration.room_id";
						Connection conn = new DBContext().getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						int i =0;
						while(rs.next()) {i++;
				%>
					<tr>
						<td style="border: 2px solid black;"><%=i %></td>
						<td style="border: 2px solid black;"><%=rs.getString("phong") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("ngaydangky") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("buoi") %></td>
						<td style="border: 2px solid black;"><%=rs.getInt("soluonghientai") %></td>
						<td style="border: 2px solid black;"><%=rs.getInt("soluongtoida") %></td>
						<td style="border: 2px solid black;">
							<button class='btn btn-danger xoalichphong' data-toggle="modal" data-id='<%=rs.getString("id") %>'>Xóa</button>
							<img data-id='<%=rs.getString("id") %>' class="viewstudent" data-toggle="modal" data-target="#View"   alt="" src="/luanvan/images/view.png">
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
<!-- thêm lịch phòng -->
	
</div>

<div class="modal fade" id="themregistration">
	    <div class="modal-dialog">
	      <div class="modal-content">
	      
	        <!-- Modal Header -->
	        <div class="modal-header">
	          <h2 class="modal-title">Thêm lịch phòng.</h2>
	          <button type="button" class="close" data-dismiss="modal">X</button>
	        </div>
	        
	        <!-- Modal body -->
	        <div class="modal-body">
	          	<select id="room-id" style="height: 43px; width: 80px;">
	          		<%
	          		try {
						String sql = "select * from room ";
						Connection conn = new DBContext().getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						int i =0;
						while(rs.next()) {
							i++;
						out.println("<option value='"+rs.getInt("id")+"'>"+rs.getString("phong")+"</option>") ; 
						}
				}catch(Exception e){
	          			System.out.print(e);
	          		}
	          		%>
	          		
	          	</select>
				<input type="date" style="height: 43px; width: 200px;margin-left: 1%;" id="ngaydangky" placeholder="Nhập ngày đăng ký" />
				<select id="buoi" style="height: 43px; width: 80px;margin-left: 1%;">
					<option value="">Buổi</option>
					<option value="Sáng">Sáng</option>
					<option value="Chiều">Chiều</option>
				</select>
	        </div>
	        
	        <!-- Modal footer -->
	        <div class="modal-footer">
	          <button type="button" class="btn btn-success themlich">Thêm</button>
	          <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
	        </div>
	        
	      </div>
	    </div>
	</div>
	
	<div class="modal fade" id="View">
	    <div class="modal-dialog">
	      <div class="modal-content">
	      
	        <!-- Modal Header -->
	        <div class="modal-header">
	          <h2 class="modal-title">Danh sách sinh viên</h2>
	          <button type="button" class="close" data-dismiss="modal">X</button>
	        </div>
	        
	        <!-- Modal body -->
	        <div class="modal-body2">
	          	
	        </div>
	        
	        <!-- Modal footer -->
	        <div class="modal-footer">
	          
	          <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
	        </div>
	        
	      </div>
	    </div>
	</div>

<%@ include file="/admin/footeradmin.jsp" %>