package com.ulysses.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IAreanServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.AreanView;

/**
 * 篮球馆场地Controller
 */
@Controller
@RequestMapping(value = "areanController")
public class AreanController  implements ICommonConstant  {

	@Autowired
	ICommonExec common;

	@Autowired
	ICommonLoginExec commonLogin;
	
	@Autowired
	IAreanServices areanService;

	/**
	 * 所有篮球馆场地
	 */
	@RequestMapping(value = "findAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findAll(AreanView view, HttpServletRequest request) {
		
		if (!"arean".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			
			return areanService.findAllArean(view);
		}
		
	}
	
	
	
	
}
