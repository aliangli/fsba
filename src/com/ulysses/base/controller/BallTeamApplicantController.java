package com.ulysses.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IBallTeamApplicantServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.BallTeamApplicantView;
import com.ulysses.base.view.BallTeamView;

/**
 * 申请信息Controller
 * 
 * 球员申请加入球队
 *
 */
@Controller
@RequestMapping(value = "ballTeamApplicantController")
public class BallTeamApplicantController implements ICommonConstant {
	
	@Autowired
	ICommonLoginExec commonLogin;

	@Autowired
	ICommonExec common;
	
	@Autowired
	IBallTeamApplicantServices applicantService;
	
	/**
	 * 一个球队 所有的申请记录
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "allApplicant", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> allApplicant(BallTeamView view, HttpServletRequest request) {
		
		if (!"allApplicant".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		
		return applicantService.applicantByTeam(view);
	}
	

	/**
	 * 球员发出申请
	 */
	@RequestMapping(value = "sendApplicant", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sendApplicant(BallTeamApplicantView view, HttpServletRequest request) {
		if (!"sendApplicant".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);

		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			view.setApplicantIp(request.getRemoteAddr());//客户端IP
			view.setAliasName(user.getAliasName());
			return applicantService.send(view);
		}
		
	}

	/**
	 *  同意加入球队的申请
	 */
	@RequestMapping(value = "applicantAgree", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> applicantAgree(BallTeamApplicantView view, HttpServletRequest request) {
		if (!"applicantAgree".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return applicantService.editAgreeYes(view);
		}
		
	}
	
	/**
	 * 忽略加入球队的申请
	 */
	@RequestMapping(value = "applicantAgreeIgnore", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> applicantAgreeIgnore(BallTeamApplicantView view, HttpServletRequest request) {
		if (!"agreeIgnore".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return applicantService.editAgreeIgnore(view);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
