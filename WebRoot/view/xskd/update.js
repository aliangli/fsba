//修改片料入库
$(function(){
	var meController = "mpController";
	var datagrid = null;
	var rowEditor=undefined;
	var addDataWin = null;
	
	var nowDate = new Date().toLocaleString();
//	var nowtime = new Date().toLocaleTimeString();
	
	function getNowDate(){
		nowDate = new Date().toLocaleString();
		$("#entranceDate").html(nowDate);
		return nowDate;
	}
	
	
	
	$("#entranceDate").html(nowDate);
	
	$('#entranceSubcompany').combobox({
		url:'http://localhost:8080/item/baseConstant/getFengDian', 
		editable:false, //不可编辑状态
		cache: false,
		panelHeight: '150',//自动高度适合
		valueField:'id',   
		textField:'constantTitle'
	});

	
	$('#addMP_btn').click(function(){
		//取值
		var entranceNumber = $("#entranceNumber").val();
		var entranceSubcompany = $("#entranceSubcompany").combobox("getValue");
		var entranceDate = $("#entranceDate").html();
		var price = $("#price").val();
		var amount = $("#amount").val();
		var panhao = $("#panhao").val();
		var createUser = $("#createUser").val();
		var remark = $("#remark").val();
		
		var param = {
				entranceNumber : entranceNumber,
				entranceSubcompany : entranceSubcompany,
				entranceDate : entranceDate,
				panhao : panhao,
				createUser : createUser,
				remark : remark,
				price : price,
				amount : amount
			};
		
		if(entranceNumber == null || entranceNumber == "" || entranceNumber.trim() == ""){
			alert("入库单号不能为空!");
			return false;
		}else if(entranceSubcompany == null || entranceSubcompany == "" || entranceSubcompany.trim() == ""){
			alert("请选择分店!");
			return false;
		}else if(panhao == null || panhao == "" || panhao.trim() == ""){
			alert("盘号不能为空!");
			return false;
		}else if(isNaN(amount)){
			alert("数量只能是数字!");
			return false;
		}else if(amount == "" || amount == 0){
			alert("数量请输入大于零且不能为空!");
			return false;
		}else if(isNaN(price)){
			alert("价格只能是数字!");
			return false;
		}else if(price == "" || price == 0){
			alert("价格请输入大于零且不能为空!");
			return false;
		} else if(createUser == null || createUser == "" || createUser.trim() == ""){
			alert("经手人不能为空!");
			return false;
		}
		
		
		//发起添加请求
		$.ajax( {
			url : '../../mpController/save',
			data : param,
			method: "post",
			dataType : 'json',
			success : function(data) {
				if (data.success) {
					$.messager.show({ msg : "操作成功", title : '成功'});
				} else {
					
				}
			},
			error: function(){
					$.messager.alert( '错误', "操作发生系统错误", 'error');
			}
		});
		
	}); 
	
	$('#clearMP_btn').click(function(){
		alert(44);
	}); 
	
});

