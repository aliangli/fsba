package com.ulysses.base.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IBallTeamRefServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.BallTeamRefView;
import com.ulysses.base.view.BallTeamView;

/**
 * 球队与球员关系Controller
 *
 */
@Controller
@RequestMapping(value = "ballTeamRefController")
public class BallTeamRefController   implements ICommonConstant {
	private Map<String, Object> jsonMap;

	@Autowired
	ICommonLoginExec commonLogin;

	@Autowired
	ICommonExec common;
	
	@Autowired
	IBallTeamRefServices ballTeamRefServices;
	
	
	/**
	 * 加入队员
	 
	@RequestMapping(value = "addPlayer", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addPlayer(BallTeamRefView view, HttpServletRequest request) {
		
		if (!"addPlayer".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);

		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return ballTeamRefServices.addPlayer(view);
		}
		
	}*/
	

	/**
	 * 移除队员
	 */
	@RequestMapping(value = "removerPlayer", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> removerPlayer(BallTeamRefView view, HttpServletRequest request) {
		
		if (!"removerPlayer".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);

		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return ballTeamRefServices.removerPlayer(view);
		}
		
		
		
	}
	

	@RequestMapping(value = "ballPlayerByTeam")
	@ResponseBody
	public Map ballPlayerByTeam(BallTeamView view, HttpServletRequest request) {
		
		if (commonLogin.nowUser(request) == null) {
			return common.goLogin();
		}
		
		Long id = view.getTeamId();
		List arr = ballTeamRefServices.findByTeamId(id );
		
		jsonMap = common.success();

		jsonMap.put(DATA, arr);
		
		return jsonMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
