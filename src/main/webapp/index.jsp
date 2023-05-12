<%@page import="java.util.List"%>
<%@page import="entity.Student"%>
<%@ include file="include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="context.DBContext" %>
<%@ page import= "entity.Room" %>
<%@ page import= "entity.Register" %>
<%@ page import= "entity.Registration" %>
<div class="banner">    	   
    <img src="images/photos/banner.jpg"  class="img-responsive" alt="slide">
    <div class="welcome-message">
        <div class="wrap-info">
            <div class="information">
            	<img alt="" src="../luanvan/images/gooo.png">
                <h1 style="text-align:center;margin-top: 3%;margin-bottom:3%;" class="animated fadeInDown">Hệ thống đăng ký phòng báo cáo luận văn</h1>
                <h3 class="animated fadeInUp">TRƯỜNG CÔNG NGHỆ THÔNG TIN VÀ TRUYỀN THÔNG</h3>                
            </div>
            <a href="#information" class="arrow-nav scroll wowload fadeInDownBig"><i class="fa fa-angle-down"></i></a>
        </div>
    </div>
</div>
<!-- banner-->
<!-- reservation-information -->
<div id="information" class="spacer reserve-info">
<div class="container">
<div class="row">
<div class="col-sm-7 col-md-8">
	<div class="form-group">
		<%
			Student cs = (Student)request.getAttribute("Student");
			String tenlop = (String)request.getAttribute("tenlop");
			String hoTenGV = (String)request.getAttribute("hoTenGV");
		%>
		<h2><b>Thông tin sinh viên</b></h2>
		<div class="form-group"><h3><b>Họ và tên:</b> <%=cs.getHoten()%></h3></div>
		<div class="form-group"><h3><b>Mã số:</b> <%=cs.getMssv()%></h3></div>
		<div class="form-group"><h3><b>Email:</b> <%=cs.getEmail()%></h3></div>
		<div class="form-group"><h3><b>Lớp:</b> <%=tenlop%></h3></div>
		<div class="form-group"><h3><b>Cố vấn:</b> <%=hoTenGV%> </h3></div>
		<%
			if(request.getAttribute("list3")!=null){
				List<Register> list3 = (List<Register>)request.getAttribute("list3");
				for(Register o : list3){
					if(o.getTrangthai().equals("1")){
						out.println("<div class='form-group text-success'><h3><b>Đã xác nhận</b>  </h3></div>");
					}
		%>
		<%
			if(o.getTrangthai().equals("2")){
				out.println("<div class='form-group text-danger'><h3><b>Đã hủy bỏ:</b> "+list3.get(0).getGhichu()+" </h3></div>");
			}}}
		%>
	</div>
</div>
<div class="col-sm-5 col-md-4">
<h2><b>Đăng ký</b></h2>
<h4>Từ ngày 24/04/2023 đến 29/04/2023</h4>
    <form role="form" class="wowload fadeInRight" id="registration">
      
        <div class="form-group">
            <div class="row">
            <div class="col-xs-6">
            <select class="form-control" id="phong">
		        <option value="">Phòng</option>
            	<% 
            	if(request.getAttribute("room") != null){
    				List<Room> list = (List<Room>)request.getAttribute("room");
    				for(Room o: list){
    			%>
		              <option value="<%= o.getId() %>"><%=o.getPhong()%></option>						
    			<% }}%>	

            </select>
            </div>        
            <div class="col-xs-6">
            <select class="form-control" id="buoi">
              <option value="">Buổi</option>
                <% 
            	if(request.getAttribute("buoi") != null){
    				List<String> list1 = (List<String>)request.getAttribute("buoi");
    				for(String o: list1){
    			%>
		              <option value="<%=o %>"><% out.println(o); %></option>						
    			<% }}%>	
            </select>
            </div></div>
        </div>
        <div class="form-group">
            <div class="row">      
            <div class="col-xs-6" style="width:100%">
				<input class="form-control" placeholder="Ngày" type="date" id="dateregister" name="dateregister">
            </div>
          </div>
        </div>
        <div class="form-group">
            <textarea class="form-control" placeholder="Ghi chú" rows="4" id="ghichu"></textarea>
        </div>
        <button class="btn btn-default" id="submit" 
        <%
        if(request.getAttribute("list3")!=null){
        	List<Register> list3 = (List<Register>)request.getAttribute("list3");
        	for(Register o : list3){
        		if(o.getTrangthai().equals("1")){
        			out.println("disabled");
        		}
        	}
        	
        }
        
        %>
		>Đăng ký</button>
    </form>    
</div>
</div>  
</div>
</div>
<!-- reservation-information -->

<!-- services -->
<div class="spacer services wowload fadeInUp">


		<h1 class="container">Danh sách phòng báo cáo luận văn</h1>
		<div style="text-align:center;margin-top: 1%;margin-bottom:1%;"><h3 class="container" >Tuần báo cáo tập trung </h3></div>
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
        	
			<table class="table table-bordered container" style="width : 1600px;font-size: 20px;">
				<thead class="table-dark">
					<th style="border: 2px solid black;">STT</th>
					<th style="border: 2px solid black;">Phòng</th> 
					<th style="border: 2px solid black;">Ngày</th>
					<th style="border: 2px solid black;">Buổi</th>
					<th style="border: 2px solid black;">Số lượng hiện tại</th>
					<th style="border: 2px solid black;">Số lượng tối đa</th>
				</thead>
				<tbody id="tbody">
				<%
					
					try {
						 sql = "select phong,ngaydangky,buoi,soluongtoida,soluonghientai from registration, room where room.id = registration.room_id";
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
<!-- services -->

<%@ include file="include/footer.jsp" %>