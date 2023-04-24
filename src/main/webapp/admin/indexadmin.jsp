<%@page import="javax.print.DocFlavor.INPUT_STREAM"%>
<%@page import="entity.Room"%>
<%@page import="java.util.List"%>
<%@page import="entity.Admin"%>
<%@ include file="/admin/headeradmin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="context.DBContext" %>
<%@ page import= "entity.Registration" %>
<div class="banner">    	   
    <img src="/luanvan/images/photos/banner.jpg"  class="img-responsive" alt="slide">
    <div class="welcome-message">
        <div class="wrap-info">
            <div class="information">
            	<img alt="" src="/luanvan/images/gooo.png">
                <h1 style="text-align:center;margin-top: 3%;margin-bottom:3%;" class="animated fadeInDown">Hệ thống đăng ký phòng báo cáo luận văn</h1>
                <h3 class="animated fadeInUp">TRƯỜNG CÔNG NGHỆ THÔNG TIN VÀ TRUYỀN THÔNG</h3>                
            </div>
            <a href="#information" class="arrow-nav scroll wowload fadeInDownBig"><i class="fa fa-angle-down"></i></a>
        </div>
    </div>
</div>
<!-- banner-->
<div class="row">
<div class="container">
	<div class="form-group container" style="margin-left: 10%;">
		<%
			Admin cs = (Admin)request.getAttribute("Admin");
			String tenlop = (String)request.getAttribute("tenlop");
			String hoTenGV = (String)request.getAttribute("hoTenGV");
		%>
		<h2><b>Thông tin người quản trị</b></h2>
		<div class="form-group"><h3><b>Họ và tên:</b> <%=cs.getHoten()%></h3></div>
		<div class="form-group"><h3><b>Email:</b> <%=cs.getEmail()%></h3></div>
		<div class="form-group"><h3><b>Địa chỉ:</b> <%=cs.getDiachi()%></h3></div>
		<div class="form-group"><h3><b>Liên hệ:</b> <%=cs.getSdt()%> </h3></div>
	</div>
</div>
</div>
<!-- reservation-information -->
<div class="spacer services wowload fadeInUp">
		<h1 class="text-center" >Quản lý đăng ký sinh viên</h1>
		<div style="text-align:center;margin-top: 1%;margin-bottom:1%;"><h2 class="container" >Tuần báo cáo tập trung</h2></div>
				<div style="text-align:center;">
					<h3 class="container" ><b>Từ ngày 24-04-2023 đến ngày 29-04-2023</b></h3>
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
        	
			<table class="table table-bordered container" style="width : 1500px;">
				<thead class="table-dark">
					<th style="border: 2px solid black;">STT</th>
					<th style="border: 2px solid black;">Phòng</th> 
					<th style="border: 2px solid black;">Ngày</th>
					<th style="border: 2px solid black;">Buổi</th>
					<th style="border: 2px solid black;">MSSV</th>
					<th style="border: 2px solid black;">Họ tên sinh viên</th>
					<th style="border: 2px solid black; width : 230px;">Thao tác</th>
					<th style="border: 2px solid black;">Ghi chú</th>
				</thead>
				<tbody id="tbodyduyet">
				<%
					
					try {
						String sql = "select registration.id,register.id,phong,ngaydangky,buoi,mssv,hoten,trangthai,ghichu from register,registration,room,student where student.id=student_id and room.id=room_id and registration.id= registration_id";
						Connection conn = new DBContext().getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						int i =0;
						while(rs.next()) {i++;
				%>
					<tr >
						<td style="border: 2px solid black;"><%=i %></td>
						<td style="border: 2px solid black;"><%=rs.getString("phong") %></td>
						<td style="border: 2px solid black;"><%=rs.getDate("ngaydangky") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("buoi") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("mssv") %></td>
						<td style="border: 2px solid black;"><%=rs.getString("hoten") %></td>
						<td style="border: 2px solid black; text-align: center">
						<% if(rs.getString("trangthai").equals("0") ){
					        out.println("<button class='btn btn-success xacnhan' data-regis-id='"+rs.getInt(1)+"' data-id='"+rs.getInt(2)+"'>Xác nhận</button>");
					        out.println("<button class='btn btn-danger huybo'  data-toggle='modal' data-id='"+rs.getInt("id")+"' data-target='#myModal'>Hủy</button>");
						}
					        if(rs.getString("trangthai").equals("1")){
						        out.println("<button class='btn btn-success'>Đã xác nhận</button>");
						        
					        }
					        if(rs.getString("trangthai").equals("2")){
						        out.println("<button class='btn btn-danger'>Đã hủy</button>");
						        
					        }
						%>
						</td>
						<td style="border: 2px solid black;"><%=rs.getString("ghichu") %></td>
					</tr>
				<%
				
						}		
					}catch(Exception e){
						System.out.println(e);
					}
					
				%>
				</tbody>
			</table>	
				
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h3 class="modal-title">Lý do hủy</h3>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          <input size="68" type="text" />
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-success guilydo">Xác nhận</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
        </div>
        
      </div>
    </div>
</div>


<%@ include file="/admin/footeradmin.jsp" %>