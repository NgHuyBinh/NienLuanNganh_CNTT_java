<%@page import="entity.Student"%>
<%@ include file="include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="spacer services wowload fadeInUp" style="height:800px">
        <div class="wrap-info">
            <div class="information">
				<h1 style="text-align:center;margin-top: 2%;margin-bottom:2%;" class="container">Đổi mật khẩu</h1>
		<div class="container text-center">
		    <form role="form" class="wowload fadeInRight" id="formresetpass">  
					<label style="width:200px;text-align:left"  for="passcu">Mật khẩu cũ:</label>
					<input style="color: black" type="password" id="passcu" name="passcu"><br><br>
					<label  style="width:200px;text-align:left"  for="passmoi1">Mật khẩu mới:</label>
					<input style="color: black" type="password" id="passmoi1" name="passmoi1"><br><br>
					<label  style="width:200px;text-align:left"  for="passmoi2">Nhập lại mật khẩu:</label>
					<input style="color: black" type="password" id="passmoi2" name="passmoi2"><br><br>
				    
				</form>   
				<input style="margin-right: 25%;color: black text-align:center" type="submit" id="updatepassword" value="Đổi mật khẩu">
            </div>
        </div>
    </div>
</div>
<%@ include file="include/footer.jsp" %>