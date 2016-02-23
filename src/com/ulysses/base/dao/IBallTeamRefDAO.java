package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.pojo.TbBallTeamRef;

/**
 * 球队与球员关系Dao
 */
public interface IBallTeamRefDAO {

	// property constants
	public static final String TEAM_ID = "teamId";
	public static final String BALL_PLAYER_ID = "ballPlayerId";
	public static final String REMARK = "remark";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_DETACH = "isDetach";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";
	

	/**
	 * 获取球队关系
	 */
	public abstract List findTeamRef(TbBallTeamRef teamRef);
	
	/**
	 * 获取用户创建和参与的所有球队
	 */
	public abstract List findTeamByUser(Long playerId);

	/**
	 * 设置队员关系的解散状态
	 */
	public abstract void editTeamRefDisband(TbBallTeamRef teamRef);

	/**
	 * 设置队员关系的删除状态
	 */
	public abstract void editTeamRefDelete(TbBallTeamRef teamRef);

	public abstract void save(TbBallTeamRef transientInstance);
	
	public abstract void update(TbBallTeamRef transientInstance);

	public abstract TbBallTeamRef findById(java.lang.Long id);

	public abstract List findByTeamRef(TbBallTeamRef instance);
	
	/**
	 * 有约束的查询， 如有效状态
	 * @param instance
	 * @return
	 */
	public abstract List findByExampleCheck(TbBallTeamRef instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTeamId(Object teamId);

	public abstract List findByBallPlayerId(Object ballPlayerId);

	public abstract List findByIsValid(Object isValid);

	public abstract List findAll();

	public abstract TbBallTeamRef merge(TbBallTeamRef detachedInstance);

}