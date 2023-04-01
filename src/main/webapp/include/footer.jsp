<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<footer class="spacer">
        <div class="container">
            <div class="row">
                <div class="col-sm-5">
                    <h4>Đăng ký phòng báo cáo luận văn tốt nghiệp</h4>
                    <p>Hệ thống đăng ký phòng báo cáo luận văn tốt nghiệp hổ trợ sinh viên năm cuối đăng ký phòng báo cáo luận văn tốt nghiệp của mình. Đánh dấu thành công của những năm nổ lực học tập. </p>
                </div>              
                 
                 <div class="col-sm-3">
                    <h4>Quick Links</h4>
                    <ul class="list-unstyled">
                        <li><a href="rooms.jsp">Lịch phòng</a></li>        
                        <li><a href="feedback.jsp">Phản hồi</a></li>
                        <li><a href="resetpassword.jsp">Đổi mật khẩu</a></li>
                    </ul>
                </div>
                 <div class="col-sm-4 subscribe">
                    <h4>Contact</h4>
                    <div class="input-group">
                    <input type="text" class="form-control" placeholder="Email">
                    <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Gửi</button>
                    </span>
                    </div>
                    <div class="social">
                    <a href="#"><i class="fa fa-facebook-square" data-toggle="tooltip" data-placement="top" data-original-title="facebook"></i></a>
                    <a href="#"><i class="fa fa-instagram"  data-toggle="tooltip" data-placement="top" data-original-title="instragram"></i></a>
                    <a href="#"><i class="fa fa-twitter-square" data-toggle="tooltip" data-placement="top" data-original-title="twitter"></i></a>
                    <a href="#"><i class="fa fa-pinterest-square" data-toggle="tooltip" data-placement="top" data-original-title="pinterest"></i></a>
                    <a href="#"><i class="fa fa-tumblr-square" data-toggle="tooltip" data-placement="top" data-original-title="tumblr"></i></a>
                    <a href="#"><i class="fa fa-youtube-square" data-toggle="tooltip" data-placement="top" data-original-title="youtube"></i></a>
                    </div>
                </div>
            </div>
            <!--/.row--> 
        </div>
        <!--/.container-->    
    
    <!--/.footer-bottom--> 
</footer>

<div class="text-center copyright">Powered by <a href="http://thebootstrapthemes.com">dangkyphong@gmail.com</a></div>

<a href="#home" class="toTop scroll"><i class="fa fa-angle-up"></i></a>




<!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
<div id="blueimp-gallery" class="blueimp-gallery blueimp-gallery-controls">
    <!-- The container for the modal slides -->
    <div class="slides"></div>
    <!-- Controls for the borderless lightbox -->
    <h3 class="title">title</h3>
    <a class="prev">â¹</a>
    <a class="next">âº</a>
    <a class="close">Ã</a>ư    
</div>

<script src="assets/jquery.js"></script>

<!-- wow script -->
<script src="assets/wow/wow.min.js"></script>

<!-- uniform -->
<script src="assets/uniform/js/jquery.uniform.js"></script>


<!-- boostrap -->
<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript" ></script>

<!-- jquery mobile -->
<script src="assets/mobile/touchSwipe.min.js"></script>

<!-- jquery mobile -->
<script src="assets/respond/respond.js"></script>

<!-- gallery -->
<script src="assets/gallery/jquery.blueimp-gallery.min.js"></script>


<!-- custom script -->
<script src="assets/script.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
<script src="/luanvan/js/register.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
	th, td{
		border: 2px solid black;
	}</style>
	
<script >
$(document).ready(function () {
    $('#submit').on("click",function(e){
		e.preventDefault();
    	var buoi = $("#buoi").val();
    	var phong = $("#phong").val();
    	var ngaydangky = $("#dateregister").val();
    	var ghichu = $("#ghichu").val();
    	
    	var ngaybatdau = '2023-04-24';
    	var ngayketthuc = '2023-04-29';
    	console.log(ngaydangky > ngaybatdau);
    	if(buoi == "" || phong == "" || ngaydangky == ""){
    		alert("Hãy nhập đầy đủ thông tin!");
    	}else {
    		if(ngaydangky < ngaybatdau || ngaydangky > ngayketthuc){
    			alert("Nhập ngày chưa hợp lệ!");
    		}
    	}
    	$.ajax({
    		url: "/luanvan/index",
    		type: "POST",
    		data: {buoi:buoi,phong:phong,ngaydangky:ngaydangky,ghichu:ghichu},
    		success: function(data){
    		}
    	})
    });


});
</script>
	
</body>
</html>





