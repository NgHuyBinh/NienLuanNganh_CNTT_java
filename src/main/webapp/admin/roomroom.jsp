<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="context.DBContext"%>
<%@page import="java.sql.Connection"%>
<%@ include file="/admin/headeradmin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="spacer services wowload fadeInUp">
		<h1 class="text-center">Quản lý phòng báo cáo</h1>
		<div style="text-align:center;margin-top: 1%;"><h2 class="container" >Tuần báo cáo tập trung</h2></div>
				<div style="text-align:center;">
					<h3 class="container" ><b>Từ ngày 24-04-2023 đến ngày 29-04-2023 </b></h3>
				</div>

			<table class="table table-bordered container" style="width : 1300px;font-size: 20px;">
				<thead class="table-dark">
					<th style="border: 2px solid black;">STT</th>
					<th style="border: 2px solid black;">Phòng</th>
					<th style="border: 2px solid black;">Số lượng tối đa</th>		
					<th style="border: 2px solid black; width : 100px;">Thao tác</th>			
				</thead>
				<tbody id="tbodythemphong">
			<%
					
					try {
						String sql = "select * from room";
						Connection conn = new DBContext().getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						int i =0;
						while(rs.next()) {i++;
				%>
					<tr>
						<td style="border: 2px solid black;"><%=i %></td>
						<td style="border: 2px solid black;"><%=rs.getString("phong") %></td>
						<td style="border: 2px solid black;"><%=rs.getInt("soluongtoida") %></td>
						<td style="border: 2px solid black;" style="text-align: center;">
						     <button class='btn btn-danger xoaphong' data-toggle="modal" data-id=<%=rs.getInt("id") %> data-target="#deleterooms">Xóa</button>
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
			<div class="table table-bordered container" style="width : 1300px;">
				<button class='btn btn-success  themphong' data-toggle="modal" data-target="#roomroom">Thêm phòng</button>
			</div>	

</div>
<!-- thêm phòng -->
<div class="modal fade" id="roomroom">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h3 class="modal-title">Nhập phòng</h3>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          <input size="65" type="text" />
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-success them">Thêm</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
        </div>
        
      </div>
    </div>
</div>

<%@ include file="/admin/footeradmin.jsp" %>