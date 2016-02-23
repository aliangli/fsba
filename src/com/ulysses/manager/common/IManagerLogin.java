package com.ulysses.manager.common;

import javax.servlet.http.HttpServletRequest;

import com.ulysses.manager.bean.ManagerUserState;
import com.ulysses.manager.pojo.TbManagerUser;
import com.ulysses.manager.view.ManagerUserView;

public interface IManagerLogin {

	/**
	 * 验证登陆
	 * @return true 登录成功     包含用户信息返回
	 */
	public ManagerUserState login(ManagerUserView view);
	

	/**
	 * 获取当前登录的用户, 未登录或者失效则返回NULL
	 * @param request
	 * @return
	 */
	public TbManagerUser nowUser(HttpServletRequest request);
	
	
	/**
	 * 获取终端IP
	 * @param request
	 * @return
	 */
	public String terminalIP(HttpServletRequest request);
}
