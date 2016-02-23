package com.ulysses.base.services.common;

import javax.servlet.http.HttpServletRequest;

import com.ulysses.base.bean.UserState;
import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.view.UserView;

/**
 * 验证用户登录接口
 *
 */
public interface ICommonLoginExec {

	/**
	 * 验证登陆
	 * @return true 登录成功     包含用户信息返回
	 */
	public UserState login(UserView param);
	

	/**
	 * 获取当前登录的用户, 未登录或者失效则返回NULL
	 * @param request
	 * @return
	 */
	public TbUser nowUser(HttpServletRequest request);
	
	
	/**
	 * 获取终端IP
	 * @param request
	 * @return
	 */
	public String terminalIP(HttpServletRequest request);
	
	
}
