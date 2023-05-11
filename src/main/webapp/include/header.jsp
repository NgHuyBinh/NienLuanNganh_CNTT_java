<%@page import="entity.Student"%>
<%
	if(session.getAttribute("mssv") == null){
		response.sendRedirect("login");
	}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="context.DBContext" %>
<%@ page import= "entity.Room" %>
<%@ page import= "entity.Register" %>
<%@ page import= "entity.Registration" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Đăng ký phòng báo cáo luận văn</title>

<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Raleway:300,500,800|Old+Standard+TT' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:300,500,800' rel='stylesheet' type='text/css'>

<!-- font awesome -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">


<!-- bootstrap -->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />

<!-- uniform -->
<link type="text/css" rel="stylesheet" href="assets/uniform/css/uniform.default.min.css" />

<!-- animate.css -->
<link rel="stylesheet" href="assets/wow/animate.css" />


<!-- gallery -->
<link rel="stylesheet" href="assets/gallery/blueimp-gallery.min.css">


<!-- favicon -->
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
<link rel="icon" href="images/favicon.png" type="image/x-icon">

<link rel="stylesheet" href="assets/style.css">
<style>
	#searchtext {
		text-align:center;
		height: 4rem;
	}
	#searchtext input {
		width: 50.6%;
		height: 100%;
		
	}
	#filter{
		text-align: center;
	}
	#filter select{
		display: inline-block;
		width: 16.66%;
	}
</style>
</head>

<body id="home">


<!-- top 
  <form class="navbar-form navbar-left newsletter" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Enter Your Email Id Here">
        </div>
        <button type="submit" class="btn btn-inverse">Subscribe</button>
    </form>
 top -->

<!-- header -->
<nav class="navbar  navbar-default" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
     <!-- <a class="navbar-brand" href="index.php"><img src="images/loggo.png"  alt="holiday crown"></a> --> 
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">

      <ul class="nav navbar-nav" >
    	     	        
        <li><a href="index">Trang chủ</a></li>
        <%
        String sql = "select * from register,student where student.id = register.student_id and trangthai=1 and student.mssv=?";
		int check = 0;
      	try {
      		Connection conn = new DBContext().getConnection();
      		PreparedStatement ps = conn.prepareStatement(sql);
      		ps.setString(1,session.getAttribute("mssv").toString());
      		ResultSet rs = ps.executeQuery();
      		while(rs.next()){
      			check = 1;
      		}
      	}catch(Exception e){
      		
      	}
        
        %>     
        <li>
        <%
        	if(check==1){
        		out.println("<a class='phanhoi'  data-toggle='modal' data-target='#guifeedback'>Phản hồi</a>");
        	}else{
        		out.println("<a class='mophong'>DK thêm phòng</a>");
        	}
        %>
        </li>
        <li><a href="resetpassword">Đổi mật khẩu</a></li>   
        <li style="font-weight:bold;width:373.75px"><a >Hello,
        <%
				if(request.getAttribute("Student")!=null){
					Student cs = (Student)request.getAttribute("Student");
					out.println(cs.getHoten());
				}
				
			%>  </a></li>
        <li style="padding-left:150px"><a href="exitstudent">Thoát</a></li>
      </ul>
      
    </div>
    <!-- Wnavbar-collapse -->
  </div><!-- container-fluid -->
</nav>
<div class="modal fade" id="guifeedback">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h3 class="modal-title"><b>Nhập nội dung phản hồi</b></h3>
          <button type="button" class="close" data-dismiss="modal">X</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          <input  size="68" type="text" style="width: 400px; height: 30px;" id="noidung"/>
          <%
          	 sql = "select * from student,register,registration,room where student.id = register.student_id and register.registration_id = registration.id and registration.room_id = room.id and trangthai = 1 and student.mssv = ?";

          	try {
          		Connection conn = new DBContext().getConnection();
          		PreparedStatement ps = conn.prepareStatement(sql);
          		ps.setString(1,session.getAttribute("mssv").toString());
          		ResultSet rs = ps.executeQuery();
          		while(rs.next()){
          %>
          <input  size="68" type="hidden" value="<%=rs.getInt(1)%>" id="student_id" style="width: 400px; height: 30px;" />
          <input  size="68" type="hidden" value="<%=rs.getInt("room_id") %>" style="width:  400px; height: 30px;" id="room_id" />
          <%			
          		}
          	}catch(Exception e){
          		System.out.println(e);
          	}
          %>
         
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="buton" class="btn btn-success guiyeucau" >Gửi yêu cầu</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</buttotn>
        </div>
      </div>
    </div>
</div>


<div class="modal fade" id="mothemphong">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h3 class="modal-title"><b>Nhập yêu cầu mở thêm phòng báo cáo</b></h3>
          <button type="button" class="close" data-dismiss="modal">X</button>
        </div>
        <!-- Modal body -->
        <div class="modal-body">
          <input  size="68" type="text"  />
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-success guiyeucau" data-dismiss="modal">Gửi yêu cầu</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Hủy</buttotn>
        </div>
        
      </div>
    </div>
</div>

<!-- header -->

