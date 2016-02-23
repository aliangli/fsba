package com.ulysses.manager.service;

import java.util.List;
import java.util.Map;

import com.ulysses.base.bean.PageBean;
import com.ulysses.manager.pojo.TbTournamentTeamRef;
import com.ulysses.manager.view.TournamentTeamRefView;

/**
 * 参赛球队关系Service
 */
public interface ITournamentTeamRefService {
	/**
	 * 个人参与的赛事
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> findByUser(TournamentTeamRefView view);
	
	/**
	 * 查询参赛的球队
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> findAll(TournamentTeamRefView view);

	public abstract void save(TbTournamentTeamRef transientInstance);

	public abstract void update(TbTournamentTeamRef persistentInstance);

	public abstract TbTournamentTeamRef findById(java.lang.Long id);

	public abstract List findByExample(TbTournamentTeamRef instance);

	public abstract List findAllCheck(TournamentTeamRefView view, PageBean page);
}
