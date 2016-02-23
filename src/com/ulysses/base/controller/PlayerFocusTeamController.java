package com.ulysses.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IPlayerFocusTeamServices;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.FocusTeamView;

/**
 * 关注球队
 *
 */

@Controller
@RequestMapping(value = "playerFocusTeamController")
public class PlayerFocusTeamController {

	@Autowired
	ICommonLoginExec commonLogin;

	@Autowired
	ICommonExec common;

	@Autowired
	IPlayerFocusTeamServices focusTeamService;
	

	/**
	 * 关注的球队
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "focusTeams", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> focusTeams(FocusTeamView view, HttpServletRequest request) {
		
		if (!"allfocusTeams".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setUserId(user.getId());
			return focusTeamService.findFocusTeams(view);
		}
		
	}
	
	/**
	 * 是否关注球队
	 */
	@RequestMapping(value = "isFocusTeam", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> isFocusTeam(FocusTeamView view, HttpServletRequest request) {
		
		if (!"focusTeam".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			Long id = user.getId();
			view.setNowUserId(id);
			return focusTeamService.isFocusTeam(view);
		}
		
	}
	

	/**
	 * 关注一个球队
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "focusTeam", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> focusTeam(FocusTeamView view, HttpServletRequest request) {
		
		if (!"focusTeam".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return focusTeamService.createFocusTeam(view);
		}
		
	}
	
	
	/**
	 * 取消关注一个球队
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "cancelFocusTeam", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> cancelFocusTeam(FocusTeamView view, HttpServletRequest request) {
		
		if (!"cancelFocusTeam".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return focusTeamService.cancelFocusTeam(view);
		}
		
	}
	
	
	
}
