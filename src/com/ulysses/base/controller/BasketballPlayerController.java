package com.ulysses.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.services.IBasketballPlayerServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.BasketballPlayerView;

/**
 * 球员
 *
 */
@Controller
@RequestMapping(value = "basketballPlayerController")
public class BasketballPlayerController  implements ICommonConstant{
	private Map<String, Object> jsonMap;

	@Autowired
	ICommonLoginExec commonLogin;

	@Autowired
	ICommonExec common;
	
	@Autowired
	IBasketballPlayerServices basketballPlayerServices;
	

	/**
	 * 所有球员
	 * @param view
	 * @return
	 
	@RequestMapping(value = "findAll")
	@ResponseBody*/
	public Map findAll(BasketballPlayerView view, HttpServletRequest request) {
		//未登录或者超时失效则返回NULL
		if (commonLogin.nowUser(request) == null) {
			return common.goLogin();
		}
		
		List playerArr = basketballPlayerServices.findAllBasketballPlayer(view);
		
		jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", playerArr.size());
		jsonMap.put("rows", playerArr);
		return jsonMap;
	}
	
	/**
	 * 搜索球员 By 昵称
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "findByBasketballPlayer")
	@ResponseBody
	public Map findByBasketballPlayer(BasketballPlayerView view, HttpServletRequest request) {
		jsonMap = new HashMap<String, Object>();
		
		if (!"searchBP".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		if (commonLogin.nowUser(request) == null) {
			return common.goLogin();
		}
		
		List playerArr = basketballPlayerServices.findByBasketballPlayer(view);
		
		jsonMap = common.success();
		jsonMap.put(DATA, playerArr);
		
		return jsonMap;
	}
	

	/**
	 * 获取所有球员信息
	 * @param view
	 * @return
	 
	@RequestMapping(value = "allBasketballPlayer", method = RequestMethod.POST)
	@ResponseBody*/
	public Map<String, Object> allBasketballPlayer(BasketballPlayerView view, HttpServletRequest request) {
		if (!"allBasketballPlayer".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		if (commonLogin.nowUser(request) == null) {
			return common.goLogin();
		}

		//获取所有球员信息
		List playerArr = basketballPlayerServices.findAllBasketballPlayer(view);


		jsonMap = common.success();
		jsonMap.put(DATA, playerArr);
		
		return jsonMap;

	}


}
