package com.ulysses.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IFSBAUserServices;
import com.ulysses.base.services.IFocusServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.UserView;
import com.ulysses.base.view.FocusUserView;

/**
 * 关注球员
 *
 */
@Controller
@RequestMapping(value = "userFocusController")
public class UserFocusController implements ICommonConstant {

	@Autowired
	ICommonExec common;

	@Autowired
	ICommonLoginExec commonLogin;
	

	@Autowired
	IFSBAUserServices fsbaUserServices;
	
	@Autowired
	IFocusServices focusServices;
	

	/**
	 * 判断是否关注了球员
	 * @param userView
	 * @return
	 */
	@RequestMapping(value = "isFocusPlayer", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> isFocusPlayer(FocusUserView view, HttpServletRequest request) {
		if (!"focusPlayer".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		return focusServices.focusPlayer(view);
	}
	
	/**
	 * 关注一个球员
	 * @param userView
	 * @return
	 */
	@RequestMapping(value = "focus", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> focus(FocusUserView view, HttpServletRequest request) {
		if (!"focusBasketballPlayer".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}

		view.setNowUserId(user.getId());
		return focusServices.focus(view);
	}

	/**
	 * 取消关注一个球员
	 * @param userView
	 * @return
	 */
	@RequestMapping(value = "cancelFocus", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> cancelFocus(FocusUserView view, HttpServletRequest request) {
		if (!"cancelFocusBasketballPlayer".equals(view.getActionType())) {
			return common.noRational();
		}

		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}

		view.setNowUserId(user.getId());
		return focusServices.cancelFocus(view);
	}

	/**
	 * 当前用户关注的所有人
	 * @param view
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getNowUserFocus", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNowUserFocus(UserView view, HttpServletRequest request) {

		if (!"nowUserFocus".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}

		view.setNowUserId(user.getId());
		
		//我关注的所有人
		return focusServices.getNowUserFocus(view);

	}
	
	
	/**
	 * 关注当前用户的所有人
	 * @param view
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getNowUserFocusPassive", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNowUserFocusPassive(UserView view, HttpServletRequest request) {
		
		if (!"nowUserFocusPassive".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		return focusServices.getNowUserFocusMe(view);
		
	}
	
	/**
	 * 某个用户 关注的所有人
	 * @param view
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getFocusByUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getFocusByUser(UserView view, HttpServletRequest request) {
		
		if (!"userFocus".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		
		return focusServices.getFocusByUser(view);
	}
	
	
	/**
	 * 关注某个用户的所有人
	 * @param view
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "getFocusByPassive", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getFocusByPassive(UserView view, HttpServletRequest request) {
		
		if (!"focusPassive".equals(view.getActionType())|| view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		return focusServices.getFocusByPassive(view);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	

	
}
