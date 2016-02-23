$(function(){
		
	$.liClickEvent = function(id, title, href){
		
		var tt = $('#home_tabs');
		if (tt.tabs('exists', title)){//如果tab已经存在,则选中并刷新该tab    	
	        tt.tabs('select', title);
	        
	        href = href + "?id="+ id;
	        refreshTab({tabTitle:title,url:href});
		} else {
			if(tt.tabs("tabs").length > 10 ){
				alert("请您关闭一些选项卡页可提高系统性能!");
			}
			
			var content = null;
	    	if (href&&href!="null"&&href!=null){
	    		href = href + "?id="+ id;
		    	content = '<iframe scrolling="no" frameborder="0"  src="'+href+'" style="width:100%;height:100%;"></iframe>';
	    	} else {
		    	content = '<div><p style="font-size:18px;padding:40px">此功能有待系统升级后才能正常使用!</p></div>';
	    	}
	    	tt.tabs('add',{
		    	title:title,
		    	closable:true,
		    	content:content,
		    	iconCls:'icon-default'
	    	});
		}
		
	}
	
	
	$.ajax({
		url:"../menuController/menu",
		data:{},
		dataType:"json",
		async:false, 
		contentType : "application/json",
		success: function(data){
			var parent = getParentMenu(data, 0);
			
			var selected = false;
			$.each(parent,function(i, n){
				/*if(n.menuCode == 4){
					selected = true;
				}*/
				 
				//onload data
                $('#accordionSysMenu').accordion('add',{
                    title: n.menuName,
                    selected: 0,
                    content:'<div style="padding:2px"><div>' + getParentMenuHTML(data, n.menuCode) +
                    '</div></div>' 
                });
            });
			
		}
	});
	
	

	/**    
	 * 刷新tab
	 * @cfg 
	 *example: {tabTitle:'tabTitle',url:'refreshUrl'}
	 *如果tabTitle为空，则默认刷新当前选中的tab
	 *如果url为空，则默认以原来的url进行reload
	 */
	function refreshTab(cfg){
		var refresh_tab = cfg.tabTitle?$('#home_tabs').tabs('getTab',cfg.tabTitle):$('#home_tabs').tabs('getSelected');
		if(refresh_tab && refresh_tab.find('iframe').length > 0){
		var _refresh_ifram = refresh_tab.find('iframe')[0];
		var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;
		//_refresh_ifram.src = refresh_url;
		_refresh_ifram.contentWindow.location.href=refresh_url;
		}
	}
	
	
	//by parentID filter menu HTML
	function getParentMenuHTML(menuData, parentID){
		var flg = false;
		var menuArr = getParentMenu(menuData, parentID);
		var html = "<ul>";
		$.each(menuArr,function(i, n){
			html += "<li class='menu_li_" + n.id 
				+ "' style='padding:8px;' onclick='$.liClickEvent(" + n.id +",\"" + n.menuName +"\",\"" + n.menuUrl +"\");'>";
			html += n.menuName;
			html += "</li>";
			flg = true;
        });
		html += "</ul>";
		if(!flg)return "";
		
		return html;
	}
	
	//by parentID filter menu data
	function getParentMenu(menuData, parentID){
		var menuArr = [];
		$.each(menuData,function(i, menuObj){
			if(menuObj.parentId == parentID){
				menuArr.push(menuObj);
			}
				 
        });
		menuArr.sort(function(a,b){return a.menuOrderBy>b.menuOrderBy?1:-1});
		return menuArr;
	}
		
});