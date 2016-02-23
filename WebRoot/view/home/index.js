

$(function(){
	
	
	//创建球队
	$("#btn_create_team").click(function(){
		/*
		var param = {
			actionType : "createTeam",
			teamName : "洛杉矶湖人队",
			teamOccupant : "吉姆·巴斯（Jim Buss）",
			teamCoach : "拜伦·斯科特",
			teamChineseName : "洛杉矶湖人",
			teamEnglishName : "L.A. Lakers",
			teamNationality : "加利福尼亚州洛杉矶市",
			teamCity : "加利福尼亚州洛杉矶市",
			teamBirthdate : "1948-01-01 01:01:11",
			teamPopulation : 10,
			teamPhotoPath : "",
			championNumber : 55,
			teamHonour : "1951-1954年获得队史第一个三连冠",
			teamRemark : "2008-2010年获得两连冠",
			sportswearColor : ""
		};*/
		
		var param = {
				actionType : "createTeam",
				teamName : "芝加哥公牛队",
				teamOccupant : "杰里·雷恩斯多夫",
				teamCoach : "汤姆·锡伯杜",
				teamChineseName : "芝加哥公牛队",
				teamEnglishName : "Chicago Bulls",
				teamNationality : "美国",
				teamCity : "美国",
				teamBirthdate : "1946-01-01 01:01:11",
				teamPopulation : 20,
				teamPhotoPath : "",
				championNumber : 155,
				teamHonour : "1996-1998连续三个总冠军",
				teamRemark : "95-96赛季常规赛中取得72胜10负",
				sportswearColor : ""
		};
		
		$.ajax( {
			url : '../../ballTeamController/createTeam',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
			},
			error: function(){
				
			}
		});
		
	});
	
	//球队的所有球员
	$("#btn_teamBallPlayer").click(function(){
		
		var param = {actionType:"teamBallPlayer", teamId: "1"  };
		
		$.ajax( {
			url : '../../ballTeamController/allBallPlayer',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
			console.log(data);
		},
		error: function(){
		}
		});
		
	});
	
	//搜索球队
	$("#btn_search_team").click(function(){
		var param = {actionType:"findByTeamName", teamName: "公牛"  };
		
		$.ajax( {
			url : '../../ballTeamController/findByTeamName',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
			console.log(data);
		},
		error: function(){
		}
		});
		
	});
	
	//当前用户的球队
	$("#btn_user_team").click(function(){
		var param = {actionType:"teamByUser", userName:"aaa" , userPassword:"111111" };
		
		$.ajax( {
			url : '../../ballTeamController/teamByUser',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
			console.log(data);
		},
		error: function(){
		}
		});
		
	});
	
	//球队ID获取球队
	$("#btn_team").click(function(){
		var param = {actionType:"findTeam", teamId: 1 };
		
		$.ajax( {
			url : '../../ballTeamController/byTeamID',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
			},
			error: function(){
			}
		});
		
	});
	

    //注册
	$("#btn_regedit").click(function(){
//		var param = {actionType:"regeditUser", userName:"aaa" , userPassword:"111111"};
		var param = {actionType:"regeditUser", userName:"liu" , userPassword:"111111"};
		
		$.ajax( {
			url : '../../fsbaUserController/save',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
			},
			error: function(){
			}
		});
		
	});
	
	//登录
	$("#btn_login").click(function(){
		var param = {actionType:"userLogin", userName:"aaa" , userPassword:"111111"};
		
		$.ajax( {
			url : '../../fsbaUserController/isLogin',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
			},
			error: function(){
			}
		});
		
	});

	//获取关注球员
	$("#btn_focus").click(function(){
		var param = {actionType:"userFocus", userName:"aaa" , userPassword:"111111"};
		
		$.ajax( {
			url : '../../fsbaUserFocusController/getFocus',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
			},
			error: function(){
			}
		});
		
	});

	

	$("#dg").datagrid({
		url:"../../fsbaUserController/findAll",
	    isField:"id",
		pagination: true,//显示分页
		pageSize: 20,
	    rownumbers: true,//显示行数
		//fit: false,//自动补全
		fitColumns: false,
		width: 900,
		height: document.body.clientHeight- 520,
		loadMsg:'数据加载中...',
		iconCls:"icon-save",//图标
		columns : [ [
						{
							field : 'userName',
							title : '姓名',
							width : 80
						}, {
							field : 'userPassword',
							title : '密码',
							width : 130
						} , {
							field : 'userPhoneNumber',
							title : '联系电话',
							width : 120
						}
						]],
		toolbar : [
			{
				text : "刷新",
				iconCls : "icon-reload",
				handler : function() {
					$("#dg").datagrid('reload');
				}
			} ] 
			
	});
	

	$("#allBasketballPlayer").datagrid({
		url:"../../basketballPlayerController/findAll",
		isField:"id",
		pagination: true,//显示分页
		pageSize: 20,
		rownumbers: true,//显示行数
		fitColumns: false,
		width: 1800,
		queryParams: {actionType: "allBasketballPlayer"},
		height: document.body.clientHeight- 120,
		loadMsg:'数据加载中...',
		iconCls:"icon-save",//图标
		columns : [ [
		             {
		            	 field : 'userName',
		            	 title : '登录名',
		            	 width : 80
		             }, {
		            	 field : 'chineseName',
		            	 title : '中文名',
		            	 width : 130
		             } , {
		            	 field : 'englishName',
		            	 title : '英文名',
		            	 width : 130
		             } , {
		            	 field : 'aliasName',
		            	 title : '别名',
		            	 width : 130
		             } , {
		            	 field : 'nationality',
		            	 title : '国籍',
		            	 width : 130
		             } , {
		            	 field : 'nationality',
		            	 title : '出生地',
		            	 width : 80
		             } , {
		            	 field : 'birthdate',
		            	 title : '出生日期',
		            	 width : 80
		             } , {
		            	 field : 'stature',
		            	 title : '身高',
		            	 width : 80
		             } , {
		            	 field : 'weight',
		            	 title : '体重',
		            	 width : 80
		             } , {
		            	 field : 'livelyDegree',
		            	 title : '活力度',
		            	 width : 80
		             } , {
		            	 field : 'passionDegree',
		            	 title : '热情度',
		            	 width : 80
		             } , {
		            	 field : 'attackDegree',
		            	 title : '攻击',
		            	 width : 80
		             } , {
		            	 field : 'defendDegree',
		            	 title : '防守',
		            	 width : 80
		             } , {
		            	 field : 'hitDegree',
		            	 title : '命中率',
		            	 width : 80
		             } , {
		            	 field : 'talentDegree',
		            	 title : '天赋',
		            	 width : 80
		             } , {
		            	 field : 'userPhoneNumber',
		            	 title : '联系电话',
		            	 width : 120
		             }
		             ]],
		             toolbar : [
		                        {
					 				text : "获取所有球员",
									iconCls : "icon-reload",
									handler : function() {
		                        	
					            	 	var param = {actionType:"allBasketballPlayer" };
						            	$.ajax( {
						         			url : '../../basketballPlayerController/allBasketballPlayer',
						         			data : param,
						         			method: "POST",
						         			dataType : 'json', 
						         			success : function(data) {
						         				console.log(data);
						         			},
						         			error: function(){
						         			}
						         		});
						            	
									}
								},
		                        {
		                        	text : "搜索",
		                        	iconCls : "icon-reload",
		                        	handler : function() {
			                        	var param = {actionType:"searchBP", basketballPlayerName:"亮" };
			                        	$.ajax( {
			                        		url : '../../basketballPlayerController/findByBasketballPlayer',
			                        		data : param,
			                        		method: "POST",
			                        		dataType : 'json', 
			                        		success : function(data) {
			                        		console.log(data);
			                        	},
			                        	error: function(){
			                        	}
			                        	});
		                        	}
		                        },
		                        {
		                        	text : "关注一个球员",
		                        	iconCls : "icon-reload",
		                        	handler : function() {
		                        	
			                        	var param = {actionType:"focusBasketballPlayer", userFocusId: 8 , userName:"aaa" , userPassword:"111111" };
			                        	$.ajax( {
			                        		url : '../../fsbaUserFocusController/focus',
			                        		data : param,
			                        		method: "POST",
			                        		dataType : 'json', 
			                        		success : function(data) {
			                        			console.log(data);
			                        	},
			                        	error: function(){
			                        	}
			                        	});
		                        	}
		                        },
		                        {
		                        	text : "取消关注",
		                        	iconCls : "icon-reload",
		                        	handler : function() {
		                        	
			                        	var param = {actionType:"cancelFocusBasketballPlayer", userFocusId: 80 , userName:"aaa" , userPassword:"111111" };
			                        	$.ajax( {
			                        		url : '../../fsbaUserFocusController/cancelFocus',
			                        		data : param,
			                        		method: "POST",
			                        		dataType : 'json', 
			                        		success : function(data) {
			                        			console.log(data);
				                        	},
				                        	error: function(){
				                        	}
			                        	});
		                        	}
		                        }
								
		                        ] 
		                        
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
    
	
});


