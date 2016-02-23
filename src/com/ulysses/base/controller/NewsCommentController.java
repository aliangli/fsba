package com.ulysses.base.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.INewsCommentServices;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.news.NewsCommentView;

/**
 * 评论Controller
 */
@Controller
@RequestMapping(value = "newsCommentController")
public class NewsCommentController {
	

	@Autowired
	ICommonLoginExec commonLogin;

	@Autowired
	ICommonExec common;
	
	@Autowired
	INewsCommentServices commentService;
	
	
	/**
	 * 动态的所有评论
	 */
	@RequestMapping(value = "findByNewsId", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findByNewsId(NewsCommentView view, HttpServletRequest request) {
		
		if (!"newsComment".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return commentService.findByNewsIdCheck(view);
		}
		
	}
	
	
	/**
	 * 删除一条评论
	 */
	@RequestMapping(value = "commentDrop", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> commentDrop(NewsCommentView view, HttpServletRequest request) {
		
		if (!"commentDrop".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return commentService.commentDelete(view);
		}
		
	}
	

	/**
	 * 发出一条评论
	 */
	@RequestMapping(value = "comment", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> comment(NewsCommentView view, HttpServletRequest request) {
		
		if (!"comment".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return commentService.comment(view);
		}
		
	}
	
	
	/**
	 * 回复一条评论
	 */
	@RequestMapping(value = "dialogue", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dialogue(NewsCommentView view, HttpServletRequest request) {
		
		if (!"dialogueComment".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return commentService.comment(view);
		}
		
	}
	
	
	/**
	 * 点赞
	 */
	@RequestMapping(value = "like", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> like(NewsCommentView view, HttpServletRequest request) {
		
		if (!"like".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return commentService.like(view);
		}
		
	}
	
	
	
	
	

}
