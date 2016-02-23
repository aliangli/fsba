
$(function(){
	var basePath = "http://192.168.0.110:8080/fsba/";

	//场地
	$("#btn_arean").click(function(){
		
		var param = {
				actionType : "arean",
				pageNumber : 0  // 0表示第一页
		};
		
		
		$.ajax( {
			url : '../../areanController/findAll',
			data : param,
			method: "POST",
			dataType : 'json', 
			success : function(data) {
				console.log(data);
				
				var newsHTML = "所有场地： ";
				$(data.data).each(function(i, ele){
					newsHTML += "<li> " + ele.id + ": "+ ele.areanTitle + ": "+ ele.areanAddress + "  , [" +
									ele.areanUrl +"]</li>";
					
				});
				$("#div_arean").html("<ul>" + newsHTML + "</ul>");
			
			},
			error: function(){
				
			}
		});
	});
	
	
});

	
	
	
	
	
	
