package com.ulysses.manager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.bean.UserState;
import com.ulysses.base.constants.CodeConstants;
import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.IConfigItem;
import com.ulysses.manager.bean.ManagerUserState;
import com.ulysses.manager.common.IManagerLogin;
import com.ulysses.manager.pojo.TbManagerUser;
import com.ulysses.manager.view.ManagerUserView;


/**
 * 管理员用户登录
 *
 */
@Controller
@RequestMapping(value = "managerUserCtl")
public class ManagerUserCtl  implements ICommonConstant {

	@Autowired
	IConfigItem config;
	
	@Autowired
	ICommonExec common;
	
	@Autowired
	IManagerLogin managerLogin;
	
	/**
	 * 管理员用户登录
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(ManagerUserView view, HttpServletRequest request) {
		
		if (!"managerLogin".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//获取用户状态对象，包含用户信息及是否通过验证状态
		ManagerUserState state = managerLogin.login(view);
		
		if (state.getLoginState() == false) {
			return common.loginFail();
		}
		
		TbManagerUser user = state.getManagerUser();

		//当前用户信息存放到session
		HttpSession session = request.getSession();
		session.setAttribute(session.getId(), user);

		// 用户信息
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(CodeConstants.SESSION_USER, user);

		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, map);
		
		return this.loadSysConfig(jsonMap);
	
	}
	
	private Map<String, Object> loadSysConfig(Map<String, Object> jsonMap) {

		return jsonMap;
	}
}
