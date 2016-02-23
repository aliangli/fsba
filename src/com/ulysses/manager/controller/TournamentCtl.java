package com.ulysses.manager.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.manager.service.ITournamentService;
import com.ulysses.manager.view.TournamentView;

/**
 * 比赛
 */
@Controller
@RequestMapping(value = "tournamentCtl")
public class TournamentCtl  implements ICommonConstant{

	@Autowired
	ICommonExec common;

	@Autowired
	ICommonLoginExec commonLogin;
	
	@Autowired
	ITournamentService tntService;


	/**
	 * 获取所有比赛
	 */
	@RequestMapping(value = "findAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findAll(TournamentView view, HttpServletRequest request) {
		
		if (!"tournamentArr".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		return tntService.findAll(view);
	}
	
}
