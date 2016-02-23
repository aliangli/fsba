package com.ulysses.manager.service;

import java.util.List;
import java.util.Map;

import com.ulysses.base.bean.PageBean;
import com.ulysses.manager.pojo.TbTournament;
import com.ulysses.manager.view.TournamentView;

/**
 * 比赛Service
 */
public interface ITournamentService {
	
	public abstract Map<String, Object> findAll(TournamentView view);
	
	public abstract List findAllCheck(PageBean page);

	public abstract void save(TbTournament transientInstance);

	public abstract void update(TbTournament persistentInstance);

	public abstract TbTournament findById(java.lang.Long id);

	public abstract List findByExample(TbTournament instance);
	
}
