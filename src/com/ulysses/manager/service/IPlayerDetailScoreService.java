package com.ulysses.manager.service;

import java.util.List;
import java.util.Map;

import com.ulysses.base.bean.PageBean;
import com.ulysses.manager.pojo.TbPlayerDetailScore;
import com.ulysses.manager.view.PlayerDetailScoreView;

/**
 * 球员得分详情Service
 */
public interface IPlayerDetailScoreService {

	public abstract Map<String, Object> findAll(PlayerDetailScoreView view);
	
	public abstract List findAllCheck(PlayerDetailScoreView view);
	
	public abstract void save(TbPlayerDetailScore transientInstance);

	public abstract void update(TbPlayerDetailScore persistentInstance);

	public abstract TbPlayerDetailScore findById(java.lang.Long id);

	public abstract List findByExample(TbPlayerDetailScore instance);

}
