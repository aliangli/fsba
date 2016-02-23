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
import com.ulysses.manager.service.ITournamentTeamRefService;
import com.ulysses.manager.view.TournamentTeamRefView;
import com.ulysses.manager.view.TournamentView;

/**
 * 参赛球队关系
 */
@Controller
@RequestMapping(value = "tournamentTeamRefCtl")
public class TournamentTeamRefCtl implements ICommonConstant  {

	@Autowired
	ICommonExec common;

	@Autowired
	ICommonLoginExec commonLogin;
	
	@Autowired
	ITournamentTeamRefService tntTeamRefService;
	
	/**
	 * 查询参赛的球队
	 */
	@RequestMapping(value = "findAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findAll(TournamentTeamRefView view, HttpServletRequest request) {
		
		if (!"tournamentTeamRefArr".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		return tntTeamRefService.findAll(view);
	}
	
	/**
	 * 个人参与的赛事
	 */
	@RequestMapping(value = "findByUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findByUser(TournamentTeamRefView view, HttpServletRequest request) {
		
		if (!"tntByUser".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		return tntTeamRefService.findByUser(view);
	}
	
	
	
	
	
	
}
