package com.ulysses.base.services;

import java.util.List;
import java.util.Map;

import com.ulysses.base.pojo.TbBallTeamRef;
import com.ulysses.base.view.BallTeamApplicantView;
import com.ulysses.base.view.BallTeamRefView;

/**
 * 球队与球员关系Services
 */
public interface IBallTeamRefServices {

	/**
	 * 移除队员
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> removerPlayer(BallTeamRefView view);
	
	/**
	 * 加入队员
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> addPlayer(BallTeamRefView view);

	/**
	 * 设置队员关系的解散状态
	 */
	public abstract void editTeamRefDisband(TbBallTeamRef teamRef);
	

	/**
	 * 设置队员关系的删除状态
	 */
	public abstract void editTeamRefDelete(TbBallTeamRef teamRef);
	
	/**
	 * 获取球队关系
	 */
	public abstract List findTeamRef(TbBallTeamRef teamRef);

	public abstract TbBallTeamRef findById(java.lang.Long id);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTeamId(Object teamId);

	public abstract List findByBallPlayerId(Object ballPlayerId);

	public abstract List findByIsValid(Object isValid);

	public abstract List findAll();

	public abstract TbBallTeamRef merge(TbBallTeamRef detachedInstance);


	
}
