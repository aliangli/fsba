package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.pojo.TbPlayerFocusTeam;
import com.ulysses.base.view.FocusTeamView;

/**
 * 关注球队Dao
 */
public interface IPlayerFocusTeamDao {

	// property constants
	public static final String USER_ID = "userId";
	public static final String TEAM_ID = "teamId";
	public static final String IS_VALID = "isValid";
	public static final String REMARK = "remark";

	public abstract void save(TbPlayerFocusTeam transientInstance);

	public abstract void update(TbPlayerFocusTeam instance);
	
	public abstract TbPlayerFocusTeam findById(java.lang.Long id);

	/**
	 * 根据 球队ID获取一条关注球队的信息
	 */
	public abstract List findFocusTeam(TbPlayerFocusTeam instance);
	
	/**
	 * 根据 球队ID和用户ID查询集合
	 */
	public abstract List findByCheckUser(TbPlayerFocusTeam instance);

	/**
	 * 关注的球队 By userID
	 * @param view
	 * @param page
	 * @return
	 */
	public abstract List findAll(FocusTeamView view, PageBean page);

	
	public abstract List findAll();
	
	public abstract List findByExample(TbPlayerFocusTeam instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserId(Object userId);

	public abstract List findByTeamId(Object teamId);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByRemark(Object remark);


	public abstract TbPlayerFocusTeam merge(TbPlayerFocusTeam detachedInstance);


	public abstract void attachClean(TbPlayerFocusTeam instance);

}