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
import com.ulysses.manager.service.IPlayerDetailScoreService;
import com.ulysses.manager.view.PlayerDetailScoreView;

/**
 * 球员得分详情
 */

@Controller
@RequestMapping(value = "playerDetailScoreCtl")
public class PlayerDetailScoreCtl  implements ICommonConstant {

	@Autowired
	ICommonExec common;

	@Autowired
	ICommonLoginExec commonLogin;
	
	@Autowired
	IPlayerDetailScoreService detailScoreService;

	/**
	 * 获取个人得分详情 - 根据赛程
	 */
	@RequestMapping(value = "findAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findAll(PlayerDetailScoreView view, HttpServletRequest request) {
		
		if (!"detailScore".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			
			return detailScoreService.findAll(view);
		}
		
	}







}
