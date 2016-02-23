package com.ulysses.manager.service;

import java.util.List;
import java.util.Map;

import com.ulysses.base.bean.PageBean;
import com.ulysses.manager.pojo.TbTournamentProcess;
import com.ulysses.manager.view.TournamentProcessView;

/**
 * 赛程Service
 */
public interface ITournamentProcessService {

	public abstract Map<String, Object> findAll(TournamentProcessView view);
	
	public abstract void save(TbTournamentProcess transientInstance);

	public abstract void update(TbTournamentProcess persistentInstance);

	public abstract TbTournamentProcess findById(java.lang.Long id);

	public abstract List findByExample(TbTournamentProcess instance);

	public abstract List findAllCheck(TournamentProcessView view, PageBean page);
}
