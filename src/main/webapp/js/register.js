jQuery.validator.addMethod("noSpace", function(value, element) { 
    return value == '' || value.trim().length != 0;  
}, "No space please and don't leave it empty");
jQuery.validator.addMethod("customEmail", function(value, element) { 
  return this.optional( element ) || /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test( value ); 
}, "Please enter valid email address!");
//	$.validator.addMethod( "alphanumeric", function( value, element ) {
//	return this.optional( element ) || /^\w+$/i.test( value );
//	}, "Hãy nhập đúng thông tin" );

var $registrationForm = $('#registration');
if($registrationForm.length){
  $registrationForm.validate({
	  
      rules:{

          buoi: {
              required: true
          },
          phong: {
              required: true
          },
          ghichu: {
              required: true
          },
          dateregister: {
              required: true
          }
      },
      messages:{
          phong: {
              required: 'Hãy chọn phòng!'
          },
          buoi: {
              required: 'Hãy chọn buổi!'
          },
          dateregister: {
              required: 'Hãy nhập đúng ngày!'
          },
          ghichu: {
              required: 'Hãy thêm ghi chú!'
          }
      },
      errorPlacement: function(error, element) 
      {
        if (element.is(":radio")) 
        {
            error.appendTo(element.parents('.gender'));
        }
        else if(element.is(":checkbox")){
            error.appendTo(element.parents('.hobbies'));
        }
        else 
        { 

            error.insertAfter( element );
        }
        
       }
  });
}