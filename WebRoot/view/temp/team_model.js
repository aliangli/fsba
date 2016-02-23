
$(function(){
	var basePath = "http://192.168.0.110:8080/fsba/";

	//所有战术
	$("#btn_team_tactic").click(function(){
		
		var param = {
				actionType : "teamTactic"
		};
		
		
		$.ajax( {
			url : '../../teamTacticController/findAll',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				var newsHTML = "所有战术： ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> " + ele.id + ": "+ ele.tacticTitle + ": "+ ele.tacticBody + "  ,图片[" +
									ele.tacticTitleImg +"]</li>";
					
				});
				$("#div_team_tactic").html("<ul>" + newsHTML + "</ul>");
			
			},
			error: function(){
				
			}
		});
	});
	
	//Ta的比赛
	$("#btn_tnt_by_user").click(function(){
		
		var param = {
				actionType : "tntByUser",
				userId: $("#tnt_user_id").val(),
				pageNumber : 0  // 0表示第一页
		};
		
		
		$.ajax( {
			url : '../../tournamentTeamRefCtl/findByUser',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				var newsHTML = "比赛： ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> " + ele.tournamentId + ": "+ ele.tournamentName + " </li>";
					
				});
				$("#div_tnt_by_user").html("<ul>" + newsHTML + "</ul>");
			
			},
			error: function(){
				
			}
		});
	});
	
	//所有比赛
	$("#btn_tnt").click(function(){
		
		var param = {
				actionType : "tournamentArr",
				pageNumber : 0  // 0表示第一页
		};
		
		
		$.ajax( {
			url : '../../tournamentCtl/findAll',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
			console.log(data);
			
			var newsHTML = "比赛： ";
			$(data.data).each(function(i, ele){
				newsHTML += "<li> " + ele.tournamentId + ": "+ ele.tournamentName + ": "+ ele.tournamentCity + 
				"<a href='javascript:void(0)' style='margin: 10px' onclick='tntApplicant(" +
				ele.tournamentId + ")'   >参赛</a>  </li>";
				
			});
			$("#div_tnt").html("<ul>" + newsHTML + "</ul>");
			
		},
		error: function(){
			
		}
		});
	});

	//参赛球队
	$("#btn_tnt_team").click(function(){
		
		var param = {
				actionType : "tournamentTeamRefArr",
				tournamentId : $("#tnt_id").val(),
				pageNumber : 0  // 0表示第一页
		};
		
		
		$.ajax( {
			url : '../../tournamentTeamRefCtl/findAll',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				var newsHTML = "比赛： ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> " + ele.tmRefId + ": "+ ele.tournamentTeamId + ": "+ ele.teamName + " </li>";
					
				});
				$("#div_tnt").html("<ul>" + newsHTML + "</ul>");
			
			},
			error: function(){
				
			}
		});
	});
	
	//赛程
	$("#btn_tnt_process").click(function(){
		
		var param = {
				actionType : "tournamentProcess",
				tournamentId : $("#tnt_id").val(),
				pageNumber : 0  // 0表示第一页
		};
		
		
		$.ajax( {
			url : '../../tournamentProcessCtl/findAll',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
			
				var newsHTML = "赛程：";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> "+
					"<a href='javascript:void(0)' onclick='detailScore(" + ele.processId + ")' >统计数据</a>  "+ ele.tournamentHostTeamId + ":"+ ele.tournamentHostTeamName 
						+ "  =  "+ ele.tournamentGuestTeamId + ":"+ ele.tournamentGuestTeamName + " .  比赛状态:"+ele.tournamentState+"  </li>";
					
				});
				$("#div_tnt").html("<ul>" + newsHTML + "</ul>");
				
			},
			error: function(){
				
			}
		});
		
	});
	
	
	
	
	
});

	//个人得分详情 - 赛程 
	function detailScore(tntProcessId){
		
		var param = {
				actionType : "detailScore",
				tntProcessId : tntProcessId 
		};
		
		
		$.ajax( {
			url : '../../playerDetailScoreCtl/findAll',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				var newsHTML = "球员比分： ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> " + ele.playerId + ":   "+ ele.playerName + ":"+ ele.playerPosition+ ","+ ele.ratioPenalty + " </li>";
					
				});
				$("#div_detail_score").html("<ul>" + newsHTML + "</ul>");
				
			},
			error: function(){
				
			}
		});
	}
	
	
	//球队申请参赛
	function tntApplicant(tntId){
		
		var param = {
				actionType : "tntApplicant",
				tntId : tntId, 
				altTeamId : $("#tnt_alt_team_id").val(), 
				applicantPlace : "上海" 
		};
		
		
		$.ajax( {
			url : '../../tntApplicantCtl/send',
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
	
