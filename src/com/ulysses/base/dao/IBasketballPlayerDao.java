package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.pojo.TbBasketballPlayer;
import com.ulysses.base.view.BasketballPlayerView;

public interface IBasketballPlayerDao {

	// property constants
	public static final String USER_ID = "userId";
	public static final String POSITION = "position";
	public static final String LIVELY_DEGREE = "livelyDegree";
	public static final String PASSION_DEGREE = "passionDegree";
	public static final String ATTACK_DEGREE = "attackDegree";
	public static final String DEFEND_DEGREE = "defendDegree";
	public static final String HIT_DEGREE = "hitDegree";
	public static final String TALENT_DEGREE = "talentDegree";
	public static final String PLAYER_PHOTO_PATH = "playerPhotoPath";

	/**
	 * 搜索球员  By aliasName
	 * @param page 
	 */
	public abstract List findByName(String aliasName, PageBean page);
	
	/**
	 * 获取我关注的人
	 */
	public abstract List getFocus(Long userId, PageBean pageBean);
	
	/**
	 * 获取所有关注我的人
	 */
	public abstract List getFocusMe(Long focusUserId, PageBean pageBean);
	
	/**
	 * 根据球队ID 获取球队的所有队员信息
	 */
	public abstract List allBallPlayerByTeam(Long teamId);

	public abstract void save(TbBasketballPlayer instance);

	public abstract TbBasketballPlayer findById(java.lang.Long id);

	public abstract List findByExample(TbBasketballPlayer instance);

	public abstract List findByUserId(Object userId);

	public abstract List findAll();

	public abstract TbBasketballPlayer merge(TbBasketballPlayer instance);
	
	public abstract void update(TbBasketballPlayer instance);

	public abstract List findAllBasketballPlayer();


	public abstract List findByUserPhoneNumber(BasketballPlayerView view);
	public abstract List findUserNameAndPhoneNumber(BasketballPlayerView view);
	
}