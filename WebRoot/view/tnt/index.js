
$(function(){
	var basePath = "http://192.168.0.110:8080/fsba/";
	var userSuccessDate = null;

	//我的所有球队收到的请求
	$("#btn_my_teams_applicant").click(function(){
		
		var param = {
				actionType : "applicantAllTeam"
		};
		
		
		$.ajax( {
			url : '../../ballTeamController/applicantAllTeam',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				var newsHTML = "球队收到的所有请求： ";
				
				
				$(data.data).each(function(i, ele){
					
					newsHTML += "<li> " + ele.applicantId+ "<a href='javascript:void(0)' style='margin: 10px' onclick='cancelFocusTeam(" +
							ele.applicantId+ ", " +
							ele.applicantTeamId +")'  id='btn_cancel_focus_" +
							ele.applicantId + "' >同意</a>" + ele.applicantFromAliasName + "申请加入[" +
									ele.applicantTeamName+"]</li>";
					
				});
				$("#div_my_teams_applicant").html("<ul>" + newsHTML + "</ul>");
			
			},
			error: function(){
				
			}
		});
	});
	
	//我的关注的所有球队
	$("#btn_my_focus_teams").click(function(){
		
		var param = {
				actionType : "allfocusTeams"
		};
		
		
		$.ajax( {
			url : '../../playerFocusTeamController/focusTeams',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
			console.log(data);
			
			var newsHTML = "关注的所有球队： ";
			
			
			$(data.data).each(function(i, ele){
				
				newsHTML += "<li> " + ele.id+ "<a href='javascript:void(0)' style='margin: 10px' onclick='cancelFocusTeam(" +
				ele.id+ ", " +
				ele.teamId +")'  id='btn_cancel_focus_" +
				ele.id + "' >取消关注</a>" + ele.teamName + "</li>";
				
			});
			$("#div_focus_team").html("<ul>" + newsHTML + "</ul>");
			
		},
		error: function(){
			
		}
		});
	});
	
	
	//显示所有评论
	$("#btn_all_news_comment").click(function(){
		var txt_news_id = $("#txt_news_id").val();
		
		var param = {
				actionType : "newsComment",
				newsId: txt_news_id ,
				pageNumber : 0
		};
		
		
		$.ajax( {
			url : '../../newsCommentController/findByNewsId',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);

				var newsHTML = "评论：";
				
				$(data.data).each(function(i, ele){
					
					if(ele.commentContent == null && ele.likeState == 'Y'){
						ele.commentContent = "赞";
					}
					
					newsHTML += "<li>[" + ele.commentId + "]  " + ele.userId + " 说 ： " + ele.commentContent + 
					"</li><a href='javascript:void(0)' onclick='deleteComment(" +
							ele.commentId +")'>删除</a><input id='txt_dialogue_comment_" +
							ele.commentId +"'><a href='javascript:void(0)' onclick='dialogueComment(" +
							ele.commentId +", " +
							ele.userId +", " +
							ele.newsId + ")'>回复</a>";
					
				});
				
				$("#div_show_news_comments").html("<ul>" + newsHTML + "</ul>");
			},
			error: function(){
				
			}
		});
		
		
	});
	
	//关注一个球队
	$("#btn_focus_team").click(function(){
		var txt_focus_team_id = $("#txt_focus_team_id").val();
		
		var param = {
				actionType : "focusTeam",
				teamId: txt_focus_team_id,
				teamName: "洛杉矶湖人队"
		};
		
		
		$.ajax( {
			url : '../../playerFocusTeamController/focusTeam',
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
	
	
	//动态圈
	$("#btn_focus_users_news").click(function(){
		
		var param = {
				actionType : "focusUsers",
				pageNumber : 0
		};
		
		
		$.ajax( {
			url : '../../playerNewsController/findAllFocusUser',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
			
				console.log(data);
				
				var newsHTML = "关注的人发表的动态：";
				
				$(data.data).each(function(i, ele){
					
					newsHTML += "<li>[ " + ele.id+ " ]  " + ele.aliasName + " ： " + ele.newsContent + "</li><a href='javascript:void(0)' onclick='newsLike(" +
							ele.id +")'>点赞</a><input id='txt_comment_" +
							ele.id +"'><a href='javascript:void(0)' onclick='newsComment(" +
							ele.id +")'>评论</a>" + ele.likeState + "<a href='javascript:void(0)' onclick='relayNews(" +
							ele.id +")'>转发</a>";
					
				});
				$("#div_show_users_news").html("<ul>" + newsHTML + "</ul>");
			
			},
			error: function(){
				
			}
		});
		
		
	});
	
	//我的所有动态
	$("#btn_my_news").click(function(){
		
		var param = {
				actionType : "allNews",
				pageNumber : 0
		};
		
		$.ajax( {
			url : '../../playerNewsController/findAll',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				showDiv("div_show_news", data.data);
				
			},
			error: function(){
				
			}
		});
		
		
	});
	
	//某人的所有动态
	$("#btn_by_user_news").click(function(){
		var nowUserId = $("#by_user_id").val();
		var by_user_page_number = $("#by_user_page_number").val();
		var param = {
				actionType : "userNews",
				nowUserId : nowUserId,
				pageNumber : by_user_page_number
		};
		
		$.ajax( {
			url : '../../playerNewsController/findUserNews',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				showDiv("div_show_news", data.data);
				
			},
			error: function(){
				
			}
		});
		
		
	});
	
	
	function showDiv(divID, arr){
		var newsHTML = "";
		
		$(arr).each(function(i, ele){
			
			newsHTML += "<br>" + ele.id+ "<a href='javascript:void(0)' style='margin: 10px' onclick='deleteMyNews(" +
			ele.id+ ")'  id='btn_delete_news_" +
			ele.id + "' >删除</a><p>" + ele.newsContent + "</p>" + basePath + userSuccessDate.personalNewsPath+ "/" + ele.newsOriginalImage;
			
		});
		$("#"+divID).html(newsHTML);

	}
	
	
	
	//发布一个动态
	$("#btn_create_news").click(function(){
		var news_txt = $("#news_txt").val();
		
		var param = {
				actionType : "createNews",
				newsContent: news_txt,
				machinePlace: "上海"
		};
		
		
		$.ajax( {
			url : '../../playerNewsController/createNews',
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
	
	//同意邀请
	$("#btn_agree_invite").click(function(){
		
		var param = {
				actionType : "agreeInvite",
				inviteId: 8,
				inviteTeamId: 1,
				version: 1
		};
		
		$.ajax( {
			url : '../../ballTeamInviteController/agreeInvite',
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
	
	//忽略邀请
	$("#btn_agree_invite_g").click(function(){
		
		var param = {
				actionType : "ignoreInvite",
				inviteId: 3,
				inviteTeamId: 1,
				version: 5
		};
		
		$.ajax( {
			url : '../../ballTeamInviteController/ignoreInvite',
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
	
	
	//我收到的邀请
	$("#btn_me_invite").click(function(){
		
		var param = {
				actionType : "invite"
		};
		
		$.ajax( {
			url : '../../ballTeamInviteController/myInvite',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				$(data.data).each(function(i,obj){

					$('#me_invite_change').combobox('setValue', obj.inviteTeamId + " " + obj.inviteTeamName);
				});
	
				
			},
			error: function(){
				
			}
		});
		
	});
	
	
	//球队发出邀请
	$("#btn_invite_team").click(function(){
		
		var invite_team_id = $("#invite_team_id").val();
		var invite_user_id = $("#invite_user_id").val();
		
		var param = {
				actionType : "sendInvite",
				inviteTeamId : invite_team_id,
				inviteUserId: invite_user_id
		};
		
		$.ajax( {
			url : '../../ballTeamInviteController/sendInvite',
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
	
	//球队申请记录
	$("#btn_all_applicant").click(function(){
		
		var teamId = $("#all_applicant_team_id").val();
		
		var param = {
				actionType : "allApplicant",
				teamId : teamId 
		};
		
		$.ajax( {
			url : '../../ballTeamApplicantController/allApplicant',
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
	
	//球员发出申请,申请加入球队
	$("#btn_send_applicant").click(function(){
		
		var applicantTeamId = $("#applicant_team_id").val();
		
		var param = {
				actionType : "sendApplicant",
				applicantTeamId : applicantTeamId,
				applicantTeamName : "亚特兰大老鹰队",
				applicantPlace: "ShangHai"
		};
		
		$.ajax( {
			url : '../../ballTeamApplicantController/sendApplicant',
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
	
	//同意申请 - 加入球员
	$("#btn_add_player").click(function(){
		
		var applicantFromUserId = $("#applicantFromUserId").val();
		
		var param = {
				actionType : "applicantAgree",
				applicantId: 7,
				applicantTeamId : 1,
				applicantFromUserId : applicantFromUserId
		};
		
		$.ajax( {
			url : '../../ballTeamApplicantController/applicantAgree',
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
	
	//忽略申请 - 加入球员
	$("#btn_add_player_ignore").click(function(){
		
		var applicantFromUserId = $("#applicantFromUserId").val();
		
		var param = {
				actionType : "agreeIgnore",
				applicantId: 7,
				applicantTeamId : 1,
				applicantFromUserId : applicantFromUserId
		};
		
		$.ajax( {
			url : '../../ballTeamApplicantController/applicantAgreeIgnore',
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
	
	//解散球队
	$("#btn_disband_team").click(function(){
		
		var param = {
				actionType : "disbandTeam",
				teamId : 1
		};
		
		$.ajax( {
			url : '../../ballTeamController/disbandTeam',
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
	
	
	//修改球队
	$("#btn_update_team").click(function(){
		
		var param = {
				teamId : 10,
				actionType : "updateTeam",
				teamName : "亚特兰大老鹰队2",
				teamOccupant : "杰里·雷恩斯多夫1",
				teamCoach : "汤姆·锡伯杜1",
				teamChineseName : "芝加哥公牛队1",
				teamEnglishName : "Chicago Bullsg1",
				teamNationality : "美国1",
				teamCity : "美国1",
				teamBirthdate : "1941-01-01 01:01:11",
				teamPopulation : 291,
				teamPhotoPath : "91",
				championNumber : 1511,
				teamHonour : "1996-1998连续三个总冠军1",
				teamRemark : "95-96赛季常规赛中取得72胜10负1",
				sportswearColor : "91",
				version: 1
		};
		
		$.ajax( {
			url : '../../ballTeamController/updateTeam',
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
	
	//创建球队
	$("#btn_create_team").click(function(){
		var teamName = $("#text_create_team_name").val();
		
		var param = {
				actionType : "createTeam",
				teamName : teamName,
				teamOccupant : "",
				teamCoach : "",
				teamChineseName : "",
				teamEnglishName : "",
				teamNationality : "美国",
				teamCity : "美国",
				teamBirthdate : "1946-01-01 01:01:11",
				//teamPopulation : 20,
				teamPhotoPath : "",
				championNumber : 100,
				teamHonour : "",
				teamRemark : "",
				sportswearColor : ""
		};
		

        $("#createTeamForm").ajaxSubmit({
        	success: function(response, statusText, xhr, $form){
        		console.log(response);
        		$.messager.show({ msg : " 已上传! ", title : '成功'});
        	},
        	error: function(response, statusText, xhr, $form){
        		$.messager.alert( '错误', "操作发生系统错误", 'error');
        	}
        });
		
	});
	
	//球队的所有球员
	$("#btn_teamBallPlayer").click(function(){
		
		var teamID = $("#teamAllPlayerById").val();
		var param = {
				actionType:"teamBallPlayer", 
				teamId: teamID 
			};
		
		$.ajax( {
			url : '../../ballTeamController/allBallPlayer',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);

				var newsHTML = "球队的所有成员: ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li><a href='javascript:void(0)' style='margin: 10px' onclick='removePlayer(" +
					teamID + ", " +
					ele.id +" )' id='btn_remove_player_" +
					ele.id + "' >移除</a> [ " + ele.id+ " ]  " + ele.userPhoneNumber + " , " + ele.aliasName + "</li>";
				});
				$("#div_team_players").html("<ul>" + newsHTML + "</ul>");
				
			},
			error: function(){
			}
		});
		
	});
	
	//搜索球队
	$("#btn_search_team").click(function(){
		
		var teamName = $("#text_search_team_name").val();
		
		var param = {actionType:"findByTeamName", teamName: teamName  };
		
		$.ajax( {
			url : '../../ballTeamController/findByTeamName',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				
				var newsHTML = "搜索结果: ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> [ " + ele.id+ " ]  " + ele.teamName + "</li>";
				});
				$("#div_search_teams").html("<ul>" + newsHTML + "</ul>");
			},
			error: function(){
			}
		});
		
	});
	
	//加入的球队
	$("#btn_user_team").click(function(){
		var userId = $("#team_by_user_id").val();
		var param = {actionType:"teamByUser" , userId: userId};
		
		$.ajax( {
			url : '../../ballTeamController/teamByUser',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				

        		var newsHTML = "加入的球队: ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> [ " + ele.id+ " ]  " + "<a href='javascript:void(0)' style='margin: 10px' onclick='exitTeam(" +
					ele.id+ " )'  id='btn_my_team_" +
					ele.id + "' >退出球队</a>" + ele.teamName + "</li>";
				});
				$("#div_user_teams").html("<ul>" + newsHTML + "</ul>");
        		
			},
			error: function(){
			}
		});
		
	});
	
	//创建的球队
	$("#btn_my_create_teams").click(function(){
		var userID = $("#create_team_user_id").val();
		var param = {actionType:"createTeams", userId: userID};
		
		$.ajax( {
			url : '../../ballTeamController/findCreateTeams',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				
				var newsHTML = "搜索结果: ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> [ " + ele.id+ " ]  " + ele.teamName + "</li>";
				});
				$("#div_user_create_teams").html("<ul>" + newsHTML + "</ul>");
				
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
	
	//修改用户信息  包括头像
	$("#uploadUserPhone").click(function(){
		
        $("#userInfoForm").ajaxSubmit({
        	success: function(response, statusText, xhr, $form){
        		console.log(response);
        		$.messager.show({ msg : " 图片已上传! ", title : '成功'});
        	},
        	error: function(response, statusText, xhr, $form){
        		$.messager.alert( '错误', "操作发生系统错误", 'error');
        	}
        });
	}); 
	
	
	//修改用户信息
	$("#btn_update_user").click(function(){
		
		var param = {
			actionType : "alterUser",
			//userName : "liu",
			userPassword : "DWa4OPACVl8=",
			userPhoneNumber : "13312315555",
			chineseName : "蛋蛋",
			englishName : "sasdf",
			aliasName:"LiuD",
			nationality:"阿拉伯",
			birthpace :"印度",
			birthdate : "1999-12-26 11:11:44",
			graduateSchool:"清华大学",
			stature : 188,
			weight : 90,
			userPhotoPath : "",
			userAddress : "南京那里",
			userCity : "长沙"
		};
		
		$.ajax( {
			url : '../../fsbaUserController/alter',
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
		
		var r_userName = $("#r_userName").val();
		var userPhoneNumber = $("#r_userPhoneNumber").val();
		
		var param = {actionType:"regeditUser", userName:r_userName , userPassword:"DWa4OPACVl8=", userPhoneNumber: userPhoneNumber  };
		
		$.ajax( {
			url : '../../fsbaUserController/regeditUser',
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
		//var pwd = "DWa4OPACVl8=";
		var pwd = $("#pwd").val();
		var param = {actionType:"userLogin", userName: $("#userName").val() , userPassword: pwd};
		
		$.ajax( {
			url : '../../fsbaUserController/isLogin',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				if(data.codeType == 200){
					$("#user_name").html(param.userName + " <br> ID: " + data.data.userInfo.id);
					
					if(data.data.userInfo.userPhotoPath != null){
						$("#userPhoto").attr("src", "../../"+ data.userLoginPhotoPath +"/"+ data.data.userInfo.userPhotoPath);
					}
					
					userSuccessDate = data;
				}
				
				
				console.log(data);
			},
			error: function(){
			}
		});
		
	});
	
	//注销
	$("#btn_logout").click(function(){
		
		var param = {actionType:"logout" };
		
		$.ajax( {
			url : '../../fsbaUserController/logout',
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

	//我关注的人
	$("#btn_focus").click(function(){
		var param = {actionType:"nowUserFocus"  };
		
		$.ajax( {
			url : '../../fsbaUserFocusController/getNowUserFocus',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				

        		var newsHTML = "搜索结果: ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> [ " + ele.userId+ " ]  " + ele.aliasName +"<a href='javascript:void(0)' style='margin: 10px' onclick='cancelFocus(" +
					ele.userId+ " )'  id='btn_my_team_" +
					ele.id + "' >取消关注</a> </li>";
				});
				$("#div_focus_players").html("<ul>" + newsHTML + "</ul>");
			},
			error: function(){
			}
		});
		
	});
	
	//我关注的人
	$("#btn_focus_me").click(function(){
		var param = {actionType:"nowUserFocusPassive" };
		
		$.ajax( {
			url : '../../fsbaUserFocusController/getNowUserFocusPassive',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
			
			
				var newsHTML = "搜索结果: ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> [ " + ele.userId+ " ]  " + ele.aliasName +"<a href='javascript:void(0)' style='margin: 10px' onclick='cancelFocus(" +
					ele.userId+ " )'  id='btn_my_team_" +
					ele.id + "' >取消关注</a> </li>";
				});
				$("#div_focus_players").html("<ul>" + newsHTML + "</ul>");
			},
			error: function(){
			}
		});
		
	});
	
	//某个用户关注的人
	$("#btn_focus_xx").click(function(){
		
		
		var param = {actionType:"userFocus", userId: $("#focus_user_id").val() };
		
		$.ajax( {
			url : '../../fsbaUserFocusController/getFocusByUser',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
			console.log(data);
			
			
			var newsHTML = "搜索结果: ";
			$(data.data).each(function(i, ele){
				newsHTML += "<li> [ " + ele.userId+ " ]  " + ele.aliasName +"<a href='javascript:void(0)' style='margin: 10px' onclick='cancelFocus(" +
				ele.userId+ " )'  id='btn_my_team_" +
				ele.id + "' >取消关注</a> </li>";
			});
			$("#div_focus_players").html("<ul>" + newsHTML + "</ul>");
		},
		error: function(){
		}
		});
		
	});
	
	//关注某个用户的人
	$("#btn_focus_xx_p").click(function(){
		
		
		var param = {actionType:"focusPassive", userId: $("#focus_user_id").val() };
		
		$.ajax( {
			url : '../../fsbaUserFocusController/getFocusByPassive',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
			console.log(data);
			
			
			var newsHTML = "搜索结果: ";
			$(data.data).each(function(i, ele){
				newsHTML += "<li> [ " + ele.userId+ " ]  " + ele.aliasName +"<a href='javascript:void(0)' style='margin: 10px' onclick='cancelFocus(" +
				ele.userId+ " )'  id='btn_my_team_" +
				ele.id + "' >取消关注</a> </li>";
			});
			$("#div_focus_players").html("<ul>" + newsHTML + "</ul>");
		},
		error: function(){
		}
		});
		
	});
	
	//判断是否关注了球员
	$("#btn_is_focus_user").click(function(){

		var userFocusId = $("#txt_focus_user_id").val();

    	var param = {
			actionType : "focusPlayer",
			userFocusId : userFocusId
		};
    	
    	$.ajax( {
    		url : '../../fsbaUserFocusController/isFocusPlayer',
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
	
	//关注一个球员
	$("#btn_focus_user").click(function(){
		
		var userFocusId = $("#txt_focus_user_id").val();
		
		var param = {
				actionType : "focusBasketballPlayer",
				userFocusId : userFocusId
		};
		
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
		
	});
	
	//判断是否已关注球队 
	$("#btn_focus_team_valid").click(function(){
		
		var teamId = $("#text_focus_team_id").val();
		var param = {actionType:"focusTeam", teamId: teamId };
		
		$.ajax( {
			url : '../../playerFocusTeamController/isFocusTeam',
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
	
	//搜索球员
	$("#btn_search_player").click(function(){
		
		var param = {actionType:"searchBP", basketballPlayerName: $("#txt_search_team_name").val() };
    	$.ajax( {
    		url : '../../basketballPlayerController/findByBasketballPlayer',
    		data : param,
    		method: "POST",
    		dataType : 'json', 
    		success : function(data) {
        		console.log(data);
        		
        		var newsHTML = "搜索结果: ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> [ " + ele.userId+ " ]  " + ele.userName + "</li>";
				});
				$("#div_search_players").html("<ul>" + newsHTML + "</ul>");
        		
        	},
        	error: function(){
        	}
    	});
		
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
		height: document.body.clientHeight- 190,
		loadMsg:'数据加载中...',
		iconCls:"icon-save",//图标
		columns : [ [
		             
		             {
		            	 field : 'id',
		            	 title : 'id',
		            	 width : 30
		             }, 
		             {
		            	 field : 'userName',
		            	 title : '登录名',
		            	 width : 80
		             }, {
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
			                        	
		                        	}
		                        } 
								
		                        ] 
		                        
	});
	
	
	
});

	
	
	//取消关注
	function cancelFocus(userFocusId){

    	var param = {
			actionType : "cancelFocusBasketballPlayer",
			userFocusId : userFocusId 
		};
    	
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

	//删除一个动态
	function deleteMyNews(newsID){
	
		var param = {
				actionType : "deleteNews",
				newsId: newsID
		};
		
		
		$.ajax( {
			url : '../../playerNewsController/deleteNews',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				if(data.codeType == 200){
					alert(" OK ");
				}
				
			},
			error: function(){
				
			}
		});
		
	}


	//取消关注一个球队
	function cancelFocusTeam(teamFocusID, teamId){

		var param = {
				actionType : "cancelFocusTeam",
				focusId: teamFocusID ,
				teamId: teamId
		};
		
		
		$.ajax( {
			url : '../../playerFocusTeamController/cancelFocusTeam',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				if(data.codeType == 200){
					alert(" OK ");
				}
				
			},
			error: function(){
				
			}
		});
		
	}
	
	//评论
	function newsComment(newsId){

		var param = {
				actionType : "comment",
				newsId: newsId, 
				commentContent: $("#txt_comment_"+newsId).val()
		};
		
		
		$.ajax( {
			url : '../../newsCommentController/comment',
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
	
	//转发
	function relayNews(newsId){
		var param = {
				actionType : "relayNews",
				fromNewsId: newsId, 
				fromNewsConvey: $("#txt_comment_"+newsId).val()
		};
		
		$.ajax( {
			url : '../../playerNewsController/relayNews',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
			
				console.log(data);
			
			},
			error: function(){ }
		});
		
	}
	
	//点赞
	function newsLike(newsId){
		
		var param = {
				actionType : "like",
				newsId: newsId
				
		};
		
		
		$.ajax( {
			url : '../../newsCommentController/like',
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
	
	//退出球队
	function exitTeam( teamId){
		
		var param = {
				actionType : "exitTeam",
				teamId: teamId
		};
		
		
		$.ajax( {
			url : '../../ballTeamController/exitTeam',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
			
				console.log(data);
				
				if(data.codeType == 200){
					alert(" OK ");
				}
				
			},
			error: function(){
				
			}
		});
		
	}
	
	//回复一条评论
	function dialogueComment( commentId, userID, newsId){
		var commentContent = $("#txt_dialogue_comment_"+commentId).val();
		
		var param = {
				actionType : "dialogueComment",
				commentId: commentId,
				dialogueUserId: userID,
				newsId: newsId,
				commentContent: commentContent
		};
		
		$.ajax( {
			url : '../../newsCommentController/dialogue',
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
	
	
	//删除一条评论
	function deleteComment( commentId){
		
		var param = {
				actionType : "commentDrop",
				commentId: commentId
		};
		
		$.ajax( {
			url : '../../newsCommentController/commentDrop',
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
	
	
	//移除一个球员
	function removePlayer( teamId, ballPlayerId){
		

		var param = {
				actionType : "removerPlayer",
				teamId : teamId,
				ballPlayerId : ballPlayerId
		};
		
		$.ajax( {
			url : '../../ballTeamRefController/removerPlayer',
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
	
	
	
	
	
