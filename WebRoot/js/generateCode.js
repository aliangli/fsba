//生成编号

	function code(id){
		
		$.ajax( {
			url : '../../initController/getCode' ,
			data : {},
			method: "post",
			dataType : 'json',
			success : function(data) {
				if (data.success) {
					$("#"+id).val(data.data.code);
				}
			},
			error: function(){
					$.messager.alert( '错误', "操作发生系统错误, 请联系管理员", 'error');
			}
		});
	}

