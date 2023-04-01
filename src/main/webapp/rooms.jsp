<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="context.DBContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="entity.Student"%>
<%@ include file="include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="spacer services wowload fadeInUp">


		<h1 class="container">Danh sách phòng báo cáo luận văn</h1>
		<div style="text-align:center;margin-top: 1%;margin-bottom:1%;"><h3 class="container" >Tuần báo cáo tập trung </h3></div>
				<div style="text-align:center;">
					<h3 class="container" ><b>Từ ngày 24-04-2023 đến ngày 29-04-2023 </b></h3>
				</div>
		<div class="container">
		    	<div id="searchtext">
            		<input type="text" placeholder="Tìm kiếm" name = "searchroom">
	            </div>		
	            <div id="filter" style="text-align:center;margin-top: 1%;margin-bottom:1%;">
		            <select class="form-control" id="locphong">
				        <option  value="">Phòng</option>
		            </select>
		            <select class="form-control" id="locbuoi" >
		              <option value="">Buổi</option>
		            </select>
		            <select class="form-control" id="locngay" >
		              <option value="">Ngày</option>
		            </select>
            
	           	</div>        

        </div>
        	
			<table class="table table-bordered" >
				<thead class="table-dark">
					<th style="border: 2px solid black;">STT</th>
					<th style="border: 2px solid black;">Phòng</th> 
					<th style="border: 2px solid black;">Ngày</th>
					<th style="border: 2px solid black;">Buổi</th>
					<th style="border: 2px solid black;">Số lượng hiện tại</th>
					<th style="border: 2px solid black;">Số lượng tối đa</th>
				</thead>
				<tbody>
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
<%@ include file="include/footer.jsp" %>