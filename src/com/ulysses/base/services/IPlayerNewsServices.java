package com.ulysses.base.services;

import java.util.List;
import java.util.Map;

import com.ulysses.base.pojo.TbPlayerNews;
import com.ulysses.base.view.PlayerNewsView;

/**
 * 发布动态Service
 *
 */
public interface IPlayerNewsServices {

	/**
	 * 关注的个人所有有效动态
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> findAllFocusNews(PlayerNewsView view);
	

	/**
	 * 通过发布动态的数据ID查询
	 * @param idArr
	 * @return
	 */
	public abstract List findRelayNews(String idArr);
	
	
	/**
	 * 个人发布的所有有效动态
	 */
	public abstract Map<String, Object> findUserNews(PlayerNewsView view);
	
	/**
	 * 查询一条动态
	 */
	public abstract TbPlayerNews findById(java.lang.Long id);
	
	/**
	 * 发布一条动态
	 */
	public abstract Map<String, Object> save(PlayerNewsView view);
	
	/**
	 * 设置为删除状态
	 */
	public abstract Map<String, Object> delete(PlayerNewsView view);

	
	/**
	 * 点赞数+1
	 */
	public abstract void likeCountAdd(PlayerNewsView view);
	
	/**
	 * 点赞数-1
	 */
	public abstract void likeCountCut(PlayerNewsView view);
	
	/**
	 * 评论数+1
	 */
	public abstract void commendCountAdd(PlayerNewsView view);
	
	/**
	 * 评论数-1
	 */
	public abstract void commendCountCut(PlayerNewsView view);

	/**
	 * 转发一条动态
	 */
	public abstract Map<String, Object> relayNews(PlayerNewsView view);
	
	
	
}
