
<%@page import="java.util.List"%>
<%@page import="entity.Admin"%>
<%@ include file="/admin/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="context.DBContext" %>
<%@ page import= "entity.Room" %>
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
<!-- reservation-information -->
<div id="information" class="spacer reserve-info">
<div class="container">
<div class="row">
<div class="col-sm-7 col-md-8">
	<div class="form-group">

		<h2><b>Thông tin nhà quản trị</b></h2>
		<div class="form-group"><h3><b>Họ và tên:</b></h3></div>
		<div class="form-group"><h3><b>Giới tính</b>  </h3></div>
		<div class="form-group"><h3><b>Địa chỉ</b></h3></div>
		<div class="form-group"><h3><b>Email:</b> </h3></div>
		<div class="form-group"><h3><b>Số diện thoại:</b> </h3></div>
	</div>
</div>

</div>  
</div>
</div>
<!-- reservation-information -->

<!-- services -->
<div class="spacer services wowload fadeInUp">


		<h1 class="container">Phê duyệt đăng ký phòng báo cáo</h1>
		<div style="text-align:center;margin-top: 1%;margin-bottom:1%;"><h3 class="container" >Tuần báo cáo tập trung </h3></div>
				<div style="text-align:center;">
					<h3 class="container" ><b>Từ ngày 24-04-2023 đến ngày 29-04-2023 </b></h3>
				</div>
		<div class="container">	
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
					<th style="border: 2px solid black;">MSSV</th>
					<th style="border: 2px solid black;">Họ tên</th>
					<th style="border: 2px solid black;">Phòng</th> 
					<th style="border: 2px solid black;">Ngày</th>
					<th style="border: 2px solid black;">Buổi</th>
					<th style="border: 2px solid black;">Thao tác</th>
					<th style="border: 2px solid black;">Ghi chú</th>
				</thead>
				<tbody id="tbody">

					<tr>
						<td style="border: 2px solid black;"></td>
						<td style="border: 2px solid black;"></td>
						<td style="border: 2px solid black;"></td>
						<td style="border: 2px solid black;"></td>
						<td style="border: 2px solid black;"></td>
						<td style="border: 2px solid black;"></td>
						<td style="border: 2px solid black;"></td>
						<td style="border: 2px solid black;"></td>
					</tr>
				

				</tbody>
			</table>		
		</div>
<!-- services -->

<%@ include file="/admin/footer.jsp" %>