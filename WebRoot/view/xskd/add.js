
$(function(){
	var meController = "xskd";
	var datagrid = null;
	var rowEditor=undefined;
	var addDataWin = null;
	
	$('#xskdCount').attr('disabled','disabled'); //库存
	$('#xskdTitle').attr('disabled','disabled'); //货品名称
	
	function getNowDate(){
		var myDate = new Date();
		var y = myDate.getFullYear();    //获取完整的年份(4位,1970-????)
		var m = myDate.getMonth();       //获取当前月份(0-11,0代表1月)
		var d = myDate.getDate();        //获取当前日(1-31)
		var h = myDate.getHours();       //获取当前小时数(0-23)
		var mins = myDate.getMinutes();     //获取当前分钟数(0-59)
		var s = myDate.getSeconds();     //获取当前秒数(0-59)
		
		var nowDate = y+"-"+ (m+1) +"-"+d+ " " + (h) +":"+(mins);
		$("#xskdDate").html(nowDate);
	}
	getNowDate();
	setInterval(getNowDate, 1000*60);

	//分店
	$('#xskdFd').combobox({
		url:'../../baseConstant/getFengDian', 
		editable:false, //不可编辑状态
		cache: false,
		panelHeight: '150',//自动高度适合
		valueField:'id',   
		textField:'constantTitle'
	});

	//支付方式
	$('#xskdClearingForm').combobox({
		url:'../../baseConstant/getZFFS', 
		editable:false, //不可编辑状态
		cache: false,
		panelHeight: '150',//自动高度适合
		valueField:'id',   
		textField:'constantTitle'
	});

});

