package com.ulysses.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.ITeamTacticServices;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.services.common.IConfigItem;
import com.ulysses.base.view.PlayerNewsView;

/**
 * 战术Controller
 *
 */
@Controller
@RequestMapping(value = "teamTacticController")
public class TeamTacticController {

	@Autowired
	IConfigItem config;
	
	@Autowired
	ICommonLoginExec commonLogin;

	@Autowired
	ICommonExec common;
	
	@Autowired
	ITeamTacticServices tacticService;

	/**
	 * 所有战术
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "findAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findAll(PlayerNewsView view, HttpServletRequest request) {
		
		if (!"teamTactic".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			
			return tacticService.findAllCheck();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
