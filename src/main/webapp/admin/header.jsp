<%@page import="entity.Admin"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="/luanvan/assets/bootstrap/css/bootstrap.min.css" />

<!-- uniform -->
<link type="text/css" rel="stylesheet" href="/luanvan/assets/uniform/css/uniform.default.min.css" />

<!-- animate.css -->
<link rel="stylesheet" href="/luanvan/assets/wow/animate.css" />


<!-- gallery -->
<link rel="stylesheet" href="/luanvan/assets/gallery/blueimp-gallery.min.css">


<!-- favicon -->
<link rel="shortcut icon" href="/luanvan/images/favicon.png" type="image/x-icon">
<link rel="icon" href="/luanvan/images/favicon.png" type="image/x-icon">

<link rel="stylesheet" href="/luanvan/assets/style.css">
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
			    	     	        
        <li><a href="index.jsp">Phê duyệt đăng ký</a></li>     
        <li><a href="feedback.jsp">Phản hồi</a></li>
      	<li><a href="">Lịch phòng</a></li>   
        <li style="font-weight:bold;width:373.75px"><a >Hello, Admin
   
     </a></li>
        <li style="padding-left:300px"><a href="exitstudent">Thoát</a></li>
      </ul>
      
    </div>
    <!-- Wnavbar-collapse -->
  </div><!-- container-fluid -->
</nav>
<!-- header -->

