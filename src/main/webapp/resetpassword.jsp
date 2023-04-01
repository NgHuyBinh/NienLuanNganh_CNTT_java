<%@page import="entity.Student"%>
<%@ include file="include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="banner">    	   
    <img src="images/photos/banner.jpg"  class="img-responsive" alt="slide">
    <div class="welcome-message">
        <div class="wrap-info">
            <div class="information">
				<h1 style="text-align:center;margin-top: 2%;margin-bottom:3%;" class="container">Đổi mật khẩu</h1>
				<div class="col-sm-7 col-md-8">
				<form role="form" class="wowload fadeInRight" id="registration" style="text-align:left;margin-top: 2%;margin-bottom:3%;">
					<label style="margin-left: 30%" for="studentId">Mã số sinh viên:</label>
					<input style="color: black" type="text" id="studentId" name="studentId"><br><br>
					<label style="margin-left: 30%" for="password">Mật khẩu cũ:</label>
					<input style="color: black" type="password" id="newPassword" name="newPassword"><br><br>
					<label style="margin-left: 30%" for="newpassword">Mật khẩu mới:</label>
					<input style="color: black" type="password" id="newPassword" name="newPassword"><br><br>
					<input style="margin-left: 35%;color: black" type="submit" value="Đổi mật khẩu">
				</form>             
            	</div>
            	<div class="col-sm-5 col-md-4">
				<h2> </h2>
				    <label style="margin-right: 25%" for="newpassword">Cập nhật ảnh hồ sơ:</label>
					<input style="color: black" type="file" name="img" id="img"><br><br>   
				</div>
            </div>
            <!-- <a href="#information" class="arrow-nav scroll wowload fadeInDownBig"><i class="fa fa-angle-down"></i></a> -->
        </div>
    </div>


</div>

<%@ include file="include/footer.jsp" %>