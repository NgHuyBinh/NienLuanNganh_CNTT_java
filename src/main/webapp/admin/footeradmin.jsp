<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<footer class="spacer">
        <div class="container">
            <div class="row">
                <div class="col-sm-5">
                    <h4>Đăng ký phòng báo cáo luận văn tốt nghiệp</h4>
                    <p>Hệ thống đăng ký phòng báo cáo luận văn tốt nghiệp đã trở thành một công cụ hữu ích giúp sinh viên dễ dàng đăng ký và quản lý thời gian của mình. Điều này giúp tạo ra sự thuận lợi cho sinh viên trong quá trình hoàn thành khóa học và tạo ra những thành công đáng kể trong hành trình học tập.</p>
                </div>              
                 
                 <div class="col-sm-3">
                    <h4>Quick Links</h4>
                    <ul class="list-unstyled">      
                        <li><a href="indexadmin">Trang chủ</a></li>
                        <li><a href="roomsadmin">Lịch phòng</a></li>  
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
	
	// đăng ký
<script >
	$(document).ready(function(){
		// xử lý phê duyệt
		$(".huybo").on('click',function(){
			var id = $(this).attr("data-id");
			$(".modal-body").html('<input type="hidden" id="id" value="'+id+'" /><input type="text" id="lydo" placeholder="Nhập lý do" />');
		})
		$(".guilydo").on('click',function(e){
			e.preventDefault();
			var id = $("#id").val();
			var lydo = $("#lydo").val();
			if(lydo == ""){
				alert("Hãy nhập vào lý do!");
			}else{
    			$.ajax({
    	    		url: "/luanvan/subadmin",  
    	    		type: "POST",
    	    		data: {id:id,lydo:lydo},
    	    		success: function(data){
						$("#tbodyduyet").html(data);
						$('#myModal').modal('hide');
    	    		}
    	    	})
			}
		})
		// xác nhận duyệt
		$(".xacnhan").on('click',function(e){
			e.preventDefault();
			var id = $(this).attr("data-id");
			$.ajax({
	    		url: "/luanvan/xacnhan1",  
	    		type: "POST",
	    		data: {id:id},
	    		success: function(data){
					$("#tbodyduyet").html(data);
	    		}
	    	})
		})
		
		// thêm phòng
		$(".themphong").on('click',function(){
			$(".modal-body").html('<input type="text;" style="500px" id="phong" placeholder="Nhập phòng" /><input type="text" id="soluong" placeholder="Nhập số lượng" />');
		})
		function themphong(){	
		$(".them").on('click',function(e){
			e.preventDefault();
			var phong = $("#phong").val();
			var soluong = $("#soluong").val();
			if(phong == "" || soluong == ""){
				alert("Hãy nhập đầy đủ nội dung!");
			}else{
    			$.ajax({
    	    		url: "/luanvan/insertroom",  
    	    		type: "POST",
    	    		data: {phong:phong,soluong:soluong},
    	    		success: function(data){
    					$("#tbodythemphong").html(data);
						$('#roomroom').modal('hide');
						xoaphong()
    	    		}
    	    		
    	    	})
			}
		})
		}
		themphong()

		// xóa phòng
		function xoaphong(){
		$(".xoaphong").on('click',function(e){
			e.preventDefault();
			var id = $(this).attr("data-id");
			let text;
			  if (confirm("Bạn chắc chắn muốn xóa") == true) {
				  $.ajax({
			    		url: "/luanvan/deleteroom",  
			    		type: "POST",
			    		data: {id:id},
			    		success: function(data){
							$("#tbodythemphong").html(data);
							$('#deleterooms').modal('hide');
							xoaphong()
			    		}
			    	})
			  } else {
			    
			  }
			
		})		
		}
 		xoaphong()
 		
 		
 		// xem danh sách sinh viên
		$(".viewstudent").on('click',function(){
			alert(33)
)
		
	// thêm lịch phòng
		function themlich(){
		$(".themlich").on('click',function(e){
			e.preventDefault();
			var room_id = $("#room-id").val();
			var ngaydangky = $("#ngaydangky").val();
			var buoi = $("#buoi").val();
			if(room_id =="" || ngaydangky== "" || buoi==""){
				alert("Vui lòng nhập đầy đủ");
			}else{
				$.ajax({
					url: "/luanvan/themlich",
					type: "POST",
					data: {room_id:room_id,ngaydangky:ngaydangky,buoi:buoi},
					success: function(data){
						$("#tbodythemlich").html(data);
						$('#themregistration').modal('hide');
						xoalich();
				 		themlich()
					}
				})	
			}
		}) 	
 			
 		}
 		themlich()

		
		// xóa lịch phòng
		function xoalich(){
			$(".xoalichphong").on('click',function(e){
				e.preventDefault();
				var id = $(this).attr("data-id");
				
				$.ajax({
					url: "/luanvan/xoalichphong",
					type: "POST",
					data: {id: id},
					success:function(data){
						$("#tbodythemlich").html(data);
						xoalich()
					}
				})
			}) 			
 			
 		}
 		xoalich()

//lọc phong
		$("#locphong").on("input",function(){
			var buoi = $("#locbuoi").val();
			//var buoi = $(this).val();
			var ngay = $("#locngay").val();
			var phong = $("#locphong").val();
			console.log(ngay);
			console.log(phong);
			$.ajax({
				url: "/luanvan/filter",
				type: "POST",
				data: {buoi:buoi,phong:phong,ngay:ngay},
				success: function(data){
					$("#tbody").html(data);
				}
			})
		}); 
	})

</script>
	
</body>
</html>





