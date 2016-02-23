package com.ulysses.base.services;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.pojo.TbBasketballPlayer;
import com.ulysses.base.view.BasketballPlayerView;

public interface IBasketballPlayerServices {

	/**
	 * 搜索球员
	 * @param view
	 * @return
	 */
	public abstract List findByBasketballPlayer(BasketballPlayerView view);

	/**
	 * 获取关注的人
	 * @param pageBean 
	 */
	public abstract List getFocus(Long id, PageBean pageBean);
	
	/**
	 * 获取所有关注我的人
	 */
	public abstract List getFocusMe(Long id, PageBean page);
	
	/**
	 * 根据球队ID 获取球队的所有队员信息
	 */
	public abstract List allBallPlayerByTeam(Long teamId);

	/**
	 * 动态数+1
	 * @param player
	 */
	public abstract void dynamicCountAdd(Long userID);
	/**
	 * 动态数-1
	 * @param player
	 */
	public abstract void dynamicCountCut(Long userID);
	
	/**
	 * 关注数+1
	 * @param player
	 */
	public abstract void focusCountAdd(Long userID);
	/**
	 * 关注数-1
	 * @param player
	 */
	public abstract void focusCountCut(Long userID);
	
	/**
	 * 关注球队数+1
	 * @param player
	 */
	public abstract void focusTeamCountAdd(Long userID);
	/**
	 * 关注球队数-1
	 * @param player
	 */
	public abstract void focusTeamCountCut(Long userID);
	
	/**
	 * 被关注数+1
	 * @param player
	 */
	public abstract void goalFocusCountAdd(Long userID);
	/**
	 * 被关注数-1
	 * @param player
	 */
	public abstract void goalFocusCountCut(Long userID);

	public abstract void save(TbBasketballPlayer transientInstance);

	public abstract void update(TbBasketballPlayer instance);

	public abstract TbBasketballPlayer findById(java.lang.Long id);

	public abstract List findByExample(TbBasketballPlayer instance);

	public abstract List findByUserId(Object userId);

	public abstract List findAll();

	public abstract TbBasketballPlayer merge(TbBasketballPlayer detachedInstance);

	public abstract List findAllBasketballPlayer(BasketballPlayerView view);
	

	public abstract List findByUserPhoneNumber(BasketballPlayerView view);
	public abstract List findUserNameAndPhoneNumber(BasketballPlayerView view);
	
}
