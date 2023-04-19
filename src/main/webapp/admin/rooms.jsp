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
		<%
			Student cs = (Student)request.getAttribute("Student");
		%>
		<h1 class="container">Danh sách phòng báo cáo luận văn</h1>
		<div style="text-align:center;margin-top: 1%;"><h2 class="container" >Tuần báo cáo tập trung</h2></div>
				<div style="text-align:center;">
					<h3 class="container" ><b>Từ ngày 24-04-2023 đến ngày 29-04-2023 </b></h3>
				</div>
		<div class="container">	
	            <div id="filter" style="text-align:center;margin-top: 1%;margin-bottom:1%;">
		            <select class="form-control" id="locphong">
				        <option  value="">Phòng</option>
				            <% 
			            	if(request.getAttribute("room") != null){
			    				List<Room> list = (List<Room>)request.getAttribute("room");
			    				for(Room o: list){
			    			%>
					              <option value="<%= o.getId() %>"><%=o.getPhong()%></option>						
			    			<% }}%>	
		            </select>
		            <select class="form-control" id="locbuoi" >
		              <option value="">Buổi</option>
		               <% 
		            	if(request.getAttribute("buoi") != null){
		    				List<String> list1 = (List<String>)request.getAttribute("buoi");
		    				for(String o: list1){
		    			%>
				              <option value="<%=o %>"><% out.println(o); %></option>						
		    			<% }}%>	
		            </select>
		            <select class="form-control" id="locngay" >
		              <option value="">Ngày</option>
		                <% 
		            	if(request.getAttribute("ngay") != null){
		    				List<String> list2 = (List<String>)request.getAttribute("ngay");
		    				for(String o: list2){
		    			%>
				              <option value="<%=o %>"><% out.println(o); %></option>						
		    			<% }}%>	
		            </select>
            
	           	</div>        

        </div>
        	<button class='btn btn-success' style="text-align:center;margin-top: 1%; margin-left: 2%;margin-bottom:1%;" id="insertroom">Thêm phòng báo cáo</button>
			<table class="table table-bordered" >
				<thead class="table-dark">
					<th style="border: 2px solid black;">STT</th>
					<th style="border: 2px solid black;">Phòng</th> 
					<th style="border: 2px solid black;">Ngày</th>
					<th style="border: 2px solid black;">Buổi</th>
					<th style="border: 2px solid black;">Số lượng hiện tại</th>
					<th style="border: 2px solid black;">Số lượng tối đa</th>
					<th style="border: 2px solid black;">Danh sách sinh viên</th>
					<th style="border: 2px solid black; width : 250px;">Thao tác</th>					
				</thead>
				<tbody id="tbody">
				<%
					
					try {
						String sql = "select phong,ngaydangky,buoi,soluongtoida,soluonghientai from registration, room where room.id = registration.room_id";
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
						<td style="border: 2px solid black;"> VIEW </td>
						<td style="border: 2px solid black;  text-align: center">
							<%
						        out.println("<button class='btn btn-success' id='chinhsua'>Chỉnh sửa</button>");
						        out.println("<button class='btn btn-danger' id='xoaphong'>Xóa</button>");
							%>
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
<%@ include file="/admin/footeradmin.jsp" %>