package com.ulysses.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IPlayerNewsServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.services.common.ICommonUploadFile;
import com.ulysses.base.services.common.IConfigItem;
import com.ulysses.base.view.PlayerNewsView;

/**
 * 个人动态
 *
 */
@Controller
@RequestMapping(value = "playerNewsController")
public class PlayerNewsController implements ICommonConstant{

	@Autowired
	IConfigItem config;
	
	@Autowired
	ICommonLoginExec commonLogin;

	@Autowired
	ICommonExec common;

	@Autowired
	IPlayerNewsServices playerNewsService;

	@Autowired
	ICommonUploadFile uploadFile;
	
	/**
	 * 关注的所有个人有效动态
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "findAllFocusUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findAllFocusUser(PlayerNewsView view, HttpServletRequest request) {
		
		if (!"focusUsers".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			
			//关注的个人所有有效动态
			Map<String, Object> jsonMap = playerNewsService.findAllFocusNews(view);
			return jsonMap;
		}
		
	}
	

	/**
	 * 当前登录用户发布的所有有效动态
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "findAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findAll(PlayerNewsView view, HttpServletRequest request) {
		
		if (!"allNews".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			
			Map<String, Object> jsonMap = playerNewsService.findUserNews(view);
			return jsonMap;
		}
		
	}
	
	/**
	 * 某个用户发布的所有有效动态
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "findUserNews", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findUserNews(PlayerNewsView view, HttpServletRequest request) {
		
		if (!"userNews".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(view.getNowUserId());
			
			Map<String, Object> jsonMap = playerNewsService.findUserNews(view);
			return jsonMap;
		}
		
	}

	/**
	 * 设置为删除状态
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "deleteNews", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteNews(PlayerNewsView view, HttpServletRequest request) {
		
		if (!"deleteNews".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			Long id = user.getId();
			view.setNowUserId(id);
			view.setMachineIp(commonLogin.terminalIP(request));
			return playerNewsService.delete(view);
		}
		
	}
	
	
	/**
	 * 发布一条动态
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "createNews", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createNews(PlayerNewsView view, HttpServletRequest request) {
		
		if (!"createNews".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			
			Long id = user.getId();
			view.setNowUserId(id);
			view.setMachineIp(commonLogin.terminalIP(request));
			
			//用户发表动态上传图片
			try {
				String pathArr = uploadFile.updateFileMultiple(request, config.getPersonalNewsPath());
				view.setNewsOriginalImage(pathArr);
			} catch (Exception e) {
				e.printStackTrace();
				return common.fail();
			}
			return playerNewsService.save(view);
		}
		
	}
	
	/**
	 * 转发一条动态
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "relayNews", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> relayNews(PlayerNewsView view, HttpServletRequest request) {
		
		if (!"relayNews".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			
			view.setNowUserId(user.getId());
			view.setMachineIp(commonLogin.terminalIP(request));
			
			return playerNewsService.relayNews(view);
		}
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
