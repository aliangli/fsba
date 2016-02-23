
var datagrid = null;
var rowEditor=undefined;
	
$(function(){
	var meController = "xskd";
	var service = "销售开单";
	
	$('#orderGrid').datagrid({data: [] });
	$('#saleOrderWindow').window('close');
	$('#changeSaleOrderWindow').window('close');
	
	var dictArr = null;
	//常量
	$.ajax( {
		url : '../../baseConstant/findAll',
		data : {},
		method: "POST",
		dataType : 'json', 
		success : function(data) {
			dictArr = data;
		},
		error: function(){
				$.messager.alert( '错误', "自动获取初始化数据发生系统错误, 请联系管理员 !", 'error');
		}
	});
	
	/*
	$(window).resize(function(){
		$('#dg').datagrid('resize', {
			width:function(){return document.body.clientWidth;},
			height:function(){return document.body.clientHeight;},
		});
	});*/
	
	function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
		return 21;
    }
	
	//销售开单显示所有
	$("#dg").datagrid({
		url:"../../xskd/findAll",
	    isField:"id",
		pagination: true,//显示分页
		pageSize: 20,
	    rownumbers: true,//显示行数
		//fit: false,//自动补全
		fitColumns: false,
		height: document.body.clientHeight-70,
		loadMsg:'数据加载中...',
		iconCls:"icon-save",//图标
		columns : [ [
						{
							field : 'xskdCustomerName',
							title : '客户名称',
							width : 80
						}, {
							field : 'xskdIphone',
							title : '联系电话',
							width : 120
						}, {
							field : 'xskdDate',
							title : '开单日期',
							width : 130
						}, {
							field : 'xskdNumber',
							title : '销售单号',
							width : 150
						}, {
							field : 'productCode',
							title : '货品编号',
							width : 150 
						}, {
							field : 'productTitle',
							title : '货品名称',
							width : 130 
						}, {
							field : 'productType',
							title : '货品类别',
							width : 80 
						}, {
							field : 'productLength',
							title : '尺寸',
							width : 60
						}, {
							field : 'productCount',
							title : '销售数量',
							width : 60
						}, {
							field : 'productRealPrice',
							title : '实际付款金额',
							width : 100
						}, {
							field : 'xskdClearingForm',
							title : '结账方式',
							width : 80,
							formatter: function(value,row,index){
								if(dictArr != null){
									return showText(row.xskdClearingForm);
								}
								return "";
							}
						}, {
							field : 'xskdFd',
							title : '销售分店',
							width : 100,
							formatter: function(value,row,index){
								if(dictArr != null){
									return showText(row.xskdFd);
								}
								return "";
							}
						}, {
							field : 'xskdModel',
							title : '销售模式',
							width : 100
						}, {
							field : 'xskdCabinet',
							title : '柜台',
							width : 100
						}, {
							field : 'jsr',
							title : '经手人',
							width : 100
						}, {
							field : 'remark',
							title : '备注',
							width : 200
						} ]],
		toolbar : [
			{
				text : "销售开单",
				iconCls : "icon-add",
				handler : function() {
					$('#saleOrderWindow').window('open');
					
					//自动生成编号
					$.ajax( {
						url : '../../initController/getCode',
						data : {},
						method: "POST",
						dataType : 'json', 
						success : function(data) {
							if (data.success) {
								$('#xskdNumber').val(data.data.code);
							} 
						},
						error: function(){
								$.messager.alert( '错误', "自动获取销售单号发生系统错误, 请联系管理员 !", 'error');
						}
					});
					
					
					
				}
			},
			{
				text : "删除",
				iconCls : "icon-remove",
				handler : function() {
					var rows = $("#dg").datagrid('getSelections');

					if (rows.length <= 0) {
						$.messager.alert('警告', '您没有选择数据 ! ', 'error');
					} else if (rows.length > 1) {
						$.messager.alert('警告', '系统暂时不支持批量删除, 抱歉请等待升级 ! ', 'error');
					} else {
						$.messager.confirm('确定','确定删除吗',
								function(isConf) {
									if(isConf){
										$.ajax( {
											url : '../../' + meController +'/delete',
											data : rows[0],
											dataType : 'json',
											success : function( data) {
												if (data.success) {
													$("#dg").datagrid('acceptChanges');
													$.messager.show( { msg : "操作成功 ! ", title : '成功' });
													$("#dg").datagrid('reload');
												} else {
													$.messager.alert( '错误', "操作失败 ! ", 'error');
												}
												$("#dg").datagrid('unselectAll');
											}
										});
									}
								});
					}

				}
			},
			{
				text : "刷新",
				iconCls : "icon-reload",
				handler : function() {
					$("#dg").datagrid('reload');
				}
			} ],
		onAfterEdit : function(rowIndex, rowData, changes){
			var inserted = $("#dg").datagrid('getChanges', 'inserted');
			var updated = $("#dg").datagrid('getChanges', 'updated');
			if (inserted.length < 1 && updated.length < 1) {
				editRow = undefined;
				$("#dg").datagrid('unselectAll');
				return;
			}

			var url = '';
			if (inserted.length > 0) {
				url = '../../' + meController+'/constantAdd';
			}
			if (updated.length > 0) {
				url = '../../' + meController + '/constantUpdate';
			}
			rowData.groupBy = getUrlParam("id");

			$.ajax({
				url : url,
				data : rowData,
				dataType : 'json',
				contentType : "application/json; charset=utf-8",
				success : function(r) {
					if (r.success) {
						$("#dg").datagrid('acceptChanges');
						$.messager.show({
							msg : r.msg,
							title : '成功'
						});
						editRow = undefined;
						$("#dg").datagrid('reload');
					} else {
						/*$("#dg").datagrid('rejectChanges');*/
						$("#dg").datagrid('beginEdit', editRow);
						$.messager.alert('错误', r.msg, 'error');
					}
					$("#dg").datagrid('unselectAll');
				}
			});
			
		},
		onDblClickCell:function(rowIndex, field, value){
			if(rowEditor==undefined)
			{
	        	$("#dg").datagrid('beginEdit',rowIndex);
	        	rowEditor=rowIndex;
			}
			
		}
	});
	
	//设置分页控件 
    var dgPage = $('#dg').datagrid('getPager'); 
    $(dgPage).pagination({
        pageSize: 20,//每页显示的记录条数，默认为10 
		pageList:[10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100,150,200], 
        beforePageText: '第',//页数文本框前显示的汉字 
        afterPageText: '页  ,  共 {pages} 页', 
        displayMsg: '当前显示 {from} - {to} 条 ,   共 {total} 条' 
    }); 
	
	function showText(rowId){
		var retStr = "";
		$.each(dictArr,function(){
			//console.log(this.id + " , "+ this.constantTitle);
			if(this.id == rowId){
				retStr = this.constantTitle;
				return false;
			}
		});
		return retStr;
	}
	
	function btnOnSave(id,t,rowData) {
        
    }
	
	//用户购买的商品Grid
	$("#orderGrid").datagrid({
		url:"",
	    isField:"id",
		pagination: false,//显示分页
	    rownumbers: true,//显示行数
		fit: false,//自动补全
		fitColumns:false,
		height: 300,
		width: "100%",
		loadMsg:'数据加载中',
		iconCls:"icon-save",//图标
		columns : [ [
						{
							field : 'productCode',
							title : '商品编号',
							width : 120 
						}, {
							field : 'productTitle',
							title : '商品名称',
							width : 180 
						}, {
							field : 'productType',
							title : '商品类别',
							width : 120 
						}, {
							field : 'productLength',
							title : '尺寸',
							width : 60 
						}, {
							field : 'productPrice',
							title : '单价',
							width : 60,
							editor : {
								type : 'numberbox' 
							}
						}, {
							field : 'productCount',
							title : '销售数量',
							width : 60,
							editor : {
								type : 'numberbox',
								options : {
									required : true
								}
							}
						}, {
							field : 'productRealPrice',
							title : '实际金额',
							width : 80,
							editor : {
								type : 'numberbox',
								options : {
									//required : true,
									precision:2
								}
							}
						}, {
							field : 'remark',
							title : '备注',
							width : 200,
							editor : {
								type : 'text' 
							}
						} ]],
		toolbar : [
			{
				text : "增加",
				iconCls : "icon-add",
				handler : function() {
					$('#changeSaleOrderWindow').window('open');
				}
			},
			{
				text : "删除",
				iconCls : "icon-remove",
				handler : function() {
					var rows = $("#orderGrid").datagrid('getSelections');

					if (rows.length <= 0) {
						$.messager.alert('警告', '您没有选择数据!', 'error');
					} else {
						$.messager.confirm('确定','确定删除选中的 '+(rows.length)+' 条数据吗? ',
								function(isConf) {
									if(isConf){
										
										$.each(rows, function(i, obj){
											console.log(obj);
											var index = $('#orderGrid').datagrid('getRowIndex',obj);//获取某行的行号
											$('#orderGrid').datagrid('deleteRow',index);	//通过行号移除该行
										});
										

									}
								}
						);
					}

				}
			}  ,
			{
				text : "保存",
				iconCls : "icon-save",
				handler : function() {
					var orderGridRows = $('#orderGrid').datagrid("getData").rows;
					$.each(orderGridRows,function(i, obj){
						$('#orderGrid').datagrid('endEdit', i);
					});
						
					rowEditor = undefined;
				}
			}
		],
		onDblClickCell:function(rowIndex, field, value){
	        	$("#orderGrid").datagrid('beginEdit',rowIndex);
	        	rowEditor=rowIndex;
			
		}
	});
	
	//查询库存	
	$("#changeSaleOrderGrid").datagrid({
		url:"../../" + meController+"/queryKC",
	    isField: "id",
	    rownumbers: true,//显示行数
		fit: false,//自动补全
		fitColumns: false,
		queryParams:{productCode:"", productTitle:""},
		checkbox: true,
		height: 350,
		width: "100%",
		loadMsg:'数据加载中',
		columns : [ [
						{	field:'ck',
							checkbox:true 
						},
						{
							field : 'productCode',
							title : '货品编号',
							width : 150 
						}, {
							field : 'productType',
							title : '货品类别',
							width : 120 
						}, {
							field : 'productTitle',
							title : '货品名称',
							width : 180 
						}, {
							field : 'productCount',
							title : '库存',
							width : 60
						}, {
							field : 'ccLength',
							title : '尺寸',
							width : 60
						}, {
							field : 'productPrice',
							title : '单价',
							width : 60
						}, {
							field : 'productPrice',
							title : '零售价',
							width : 60
						}, {
							field : 'productPrice',
							title : '金额',
							width : 80
						}, {
							field : 'remark',
							title : '备注',
							width : 200
						} ]],
		toolbar : [
			{
				text : "刷新库存",
				iconCls : "icon-reload",
				handler : function() {
					$("#changeSaleOrderGrid").datagrid('reload');
				}
			},
			{
				text : "清除勾选",
				iconCls : "icon-cancel",
				handler : function() {
					
					$('#changeSaleOrderGrid').datagrid('clearChecked');//清除所有选择的行。
					$('#changeSaleOrderGrid').datagrid('clearSelections');//清除所有勾选的行。
				}
			}
			]
	});
	
	//库存搜索事件
	$('#searchBtn').click(function(){
		$("#changeSaleOrderGrid").datagrid({queryParams:{productCode:$("#productCode").val(), productTitle:$("#productTitle").val()}});
	});
	
	//销售开单搜索事件
	$('#searchXSKDBtn').click(function(){
		$("#dg").datagrid({
			queryParams:{
				startData: $("#startData").datebox('getValue'), 
				endData: $("#endData").datebox('getValue'),
				queryXskdCode: $("#queryXskdCode").val(),
				customerName: $("#customerName").val(),
				phoneNumber: $("#phoneNumber").val(),
			}
		});
		
		$('#dg').datagrid({pageNumber: 1}) ;
	}); 
	
	//勾选库存  确认事件
	$('#changeSaleOrderWindowBtn').click(function(){
		//获取勾选的数据
		var checkArr = $('#changeSaleOrderGrid').datagrid('getChecked');
		
		//用户订单所有的商品
		var orderGrid = $('#orderGrid').datagrid("getData").rows;
		
		if(containProduct(orderGrid, checkArr)){
			$.messager.alert('错误', "您已勾选了重复的库存数据, 修改销售数量即可 ! ", 'error');
			return false;
		}
		
		var catArr = [];
		$.each(checkArr,function(i, obj){
//			console.log(obj);
			var carEle = {};
			carEle.productCode = obj.productCode;
			carEle.productTitle = obj.productTitle;
			carEle.productType = obj.productType;
			carEle.productPrice = obj.productPrice;
			carEle.productRealPrice = obj.productRealPrice;
			carEle.productLength = obj.ccLength;
			carEle.remark = obj.remark;
			carEle.productCount = 1;
			
			catArr.push(carEle);
		});
		
		if(orderGrid.length > 0){
			orderGrid = orderGrid.concat(catArr);//合并
		}else {
			orderGrid = catArr;
		}
		
		if(orderGrid.length > 20){
			$.messager.alert('错误', "销售开单限制最多一次开20个商品 ! 如需系统升级请联系管理员", 'error');
			return false;
		}
		
		$('#orderGrid').datagrid({
			data: orderGrid
		});
		
		$('#changeSaleOrderGrid').datagrid('clearChecked');//清除所有选择的行。
		$('#changeSaleOrderGrid').datagrid('clearSelections');//清除所有勾选的行。
		$('#changeSaleOrderWindow').window('close'); 
	}); 
	
	//判断是否勾选了重复的库存数据
	function containProduct(orderGrid, checkArr){
		if(orderGrid.length == 0) return false;
		var flg = true;
		
		$.each(orderGrid,function(i, orderEle){
			var orderCode = orderEle.productCode;
			
			for(var k = 0 ; k<checkArr.length;k++){
				if(checkArr[k].productCode == orderCode){
					flg = false;
					break;
				}
			}
			return flg;
			
		});
		
		return !flg;
		
	}
	
	$('#changeSaleOrderCloseWindowBtn').click(function(){
		$('#changeSaleOrderGrid').datagrid('clearChecked');//清除所有选择的行。
		$('#changeSaleOrderGrid').datagrid('clearSelections');//清除所有勾选的行。
		$('#changeSaleOrderWindow').window('close');
	}); 
	
	//form重置
	$('#resetBtn').click(function(){
		$('#queryForm').form("reset");
	});
	
	//销售开单取消按钮
	$('#addOrderCloseBtn').click(function(){
		$('#orderGrid').datagrid({ data: [] });
		$('#saleOrderWindow').window('close');
	}); 
	
	
	//销售开单事件
	$('#xskdAddOrderBtn').click(function(){
		//获取OrderGrid 中的数据
		var orderGridRows = $('#orderGrid').datagrid("getData").rows;
		var flg = false;
		$.each(orderGridRows,function(i, obj){
			$('#orderGrid').datagrid('endEdit', i);//保存OrderGrid 中的数据
		});
		
		$.each(orderGridRows,function(i, obj){
			if(obj.productRealPrice == "" || obj.productRealPrice <= 0 || isNaN(obj.productRealPrice)){
				flg = true;
				$.messager.alert( '错误', " 请双击编辑商品中的实际金额 !  且大于零为数字不能为空! ", 'error');
				return false;
			}
		});
		
		if(flg){return true;}
		
//		var isContinue = $("#isContinueExec")[0].checked; //是否继续保存数据不关闭此窗口
		
		
		//取值验证
		var xskdCustomerName = $("#xskdCustomerName").val();
		if(xskdCustomerName == null || xskdCustomerName == "" || xskdCustomerName.trim() == ""){
			$.messager.alert( '提示', "请填写客户名称 !", 'warning');
			return false;
		}
		
		var xskdIphone = $("#xskdIphone").val();
		if(xskdIphone == null || xskdIphone == "" || xskdIphone.trim() == ""){
			$.messager.alert( '提示', "请填写客户联系电话 !", 'warning');
			return false;
		}
		
		var xskdNowOrderJf = $("#xskdNowOrderJf").val();
		if(xskdNowOrderJf){
			if(isNaN(xskdNowOrderJf)){
				$.messager.alert( '提示', "积分只能输入数字 !", 'warning');
				return false;
			}
		}
		
		
		var xskdClearingForm = $("#xskdClearingForm").combobox("getValue");
		if(xskdClearingForm == null || xskdClearingForm == "" || xskdClearingForm.trim() == ""){
			$.messager.alert( '提示', "请选择结账方式 !", 'warning');
			return false;
		}
		
		var xskdFd = $("#xskdFd").combobox("getValue");
		if(xskdFd == null || xskdFd == "" || xskdFd.trim() == ""){
			$.messager.alert( '提示', "请选择销售分店 !", 'warning');
			return false;
		}
		
		var jsr = $("#jsr").val();
		if(jsr == null || jsr == "" || jsr.trim() == ""){
			$.messager.alert( '提示', "请填写经手人姓名 !", 'warning');
			return false;
		}
		
		var xskdUser = $("#xskdUser").val();
		if(xskdUser == null || xskdUser == "" || xskdUser.trim() == ""){
			$.messager.alert( '提示', "请填写销售员姓名 !", 'warning');
			return false;
		}
		
		
		var xskdNumber = $("#xskdNumber").val();
		var remark = $("#remark").val();
		var xskdModel = $("#xskdModel").val();
		var xskdCabinet = $("#xskdCabinet").val();
		var xskdAllPrice = $("#xskdAllPrice").val();
		
		
		var param = {
				xskdNumber : xskdNumber,
				xskdCustomerName : xskdCustomerName,
				xskdIphone : xskdIphone,
				xskdNowOrderJf : xskdNowOrderJf,
				xskdClearingForm : xskdClearingForm,
				xskdFd : xskdFd,
				xskdModel : xskdModel,
				xskdCabinet : xskdCabinet,
				xskdPrice : xskdAllPrice,
				jsr : jsr,
				xskdUser : xskdUser,
				remark : remark ,
				carList : orderGridRows
			};
		
		
		
		//发起添加请求
		$.ajax( {
			url : '../../' + meController +'/save',
			data : JSON.stringify(param),
			method: "POST",
			dataType : 'json',
			contentType: "application/json",
			success : function(data) {
				if (data.success) {
					$.messager.show({ msg : "操作成功", title : '成功'});
					clearValue();
					$('#orderGrid').datagrid({ data: [] });
					$('#dg').datagrid('reload');
					
					$('#saleOrderWindow').window('close');
//					isContinueExec(isContinue);
				} else {
					
				}
			},
			error: function(){
					$.messager.alert( '错误', "发生系统错误", 'error');
			}
		});
		
	}); 
	
	function clearValue(){
		$("#xskdCustomerName").val("");
		$("#xskdIphone").val("");
		$("#xskdNowOrderJf").val(""); 
		$("#jsr").val(""); 
		$("#xskdUser").val(""); 
		$("#xskdAllPrice").val(""); 
	}
	
	function isContinueExec(isContinue){
		$("#dg").datagrid('reload');
		if(!isContinue){
			$('#addDataWindow').window('close');
		}
	}
	
	
});

