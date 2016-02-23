package com.ulysses.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IBallTeamInviteServices;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.BallTeamInviteView;


/**
 * 邀请信息Controller
 * 
 * 球队邀请球员
 *
 */
@Controller
@RequestMapping(value = "ballTeamInviteController")
public class BallTeamInviteController {
	
	@Autowired
	ICommonLoginExec commonLogin;

	@Autowired
	ICommonExec common;
	
	@Autowired
	IBallTeamInviteServices inviteService;
	
	
	/**
	 * 忽略邀请
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "ignoreInvite", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ignoreInvite(BallTeamInviteView view, HttpServletRequest request) {
		
		if (!"ignoreInvite".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		
		return inviteService.editAgreeIgnore(view);
	}
	
	
	/**
	 * 同意邀请
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "agreeInvite", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> agreeInvite(BallTeamInviteView view, HttpServletRequest request) {
		
		if (!"agreeInvite".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		view.setInviteIp(commonLogin.terminalIP(request));
		
		return inviteService.editAgreeYes(view);
	}

	/**
	 * 用户所有被邀请记录
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "myInvite", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> myInvite(BallTeamInviteView view, HttpServletRequest request) {
		
		if (!"invite".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		
		return inviteService.getInviteMe(view);
	}
	

	/**
	 * 球队发出邀请
	 */
	@RequestMapping(value = "sendInvite", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sendInvite(BallTeamInviteView view, HttpServletRequest request) {
		
		if (!"sendInvite".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);

		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			view.setInviteIp(commonLogin.terminalIP(request));
			return inviteService.send(view);
		}
		
	}
	
	
}
