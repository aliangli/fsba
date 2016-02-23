package com.ulysses.manager.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.manager.service.ITntApplicantService;
import com.ulysses.manager.view.TntApplicantView;

/**
 * 球队申请参赛Controller
 */
@Controller
@RequestMapping(value = "tntApplicantCtl")
public class TntApplicantController {

	@Autowired
	ICommonExec common;

	@Autowired
	ICommonLoginExec commonLogin;
	
	@Autowired
	ITntApplicantService tntApplicantService;
	
	/**
	 * 球队申请参赛
	 */
	@RequestMapping(value = "send", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> send(TntApplicantView view, HttpServletRequest request) {
		
		if (!"tntApplicant".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		view.setApplicantIp(request.getRemoteAddr());//客户端IP
		view.setAliasName(user.getAliasName());
		return tntApplicantService.save(view);
	}
	
	
	
	
}
