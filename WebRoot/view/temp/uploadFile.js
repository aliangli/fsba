
$(function(){
	
	$(':file').change(function(){
	    var file = this.files[0];
	    name = file.name;
	
		if(!name){
			return false;
		}
	
	    size = file.size;
	    type = file.type;
		console.log("file : "+name);
		console.log(size);
		console.log(type);
		
		if(size > 10485760+(1024*1024) ){
			$("#upload").hide();
			alert(" 图片大小不能超过10M ");
			return false;
		}
		
		if( type.indexOf("image/") == -1){
			$("#upload").hide();
			alert(" 只能上传图片 ");
			return false;
		}
		$("#upload").show();
	
	});
	
	$("#upload").click(function(){
		
        $("#newsForm").ajaxSubmit({
        	success: function(response, statusText, xhr, $form){
        		console.log(response);
        		$.messager.show({ msg : " 图片已上传! ", title : '成功'});
        	},
        	error: function(response, statusText, xhr, $form){
        		$.messager.alert( '错误', "操作发生系统错误", 'error');
        	}
        });
	}); 
	
});

