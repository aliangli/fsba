package com.ulysses.base.services;

import java.util.Map;

import com.ulysses.base.pojo.TbTeamTactic;

/**
 * 战术service
 *
 */
public interface ITeamTacticServices {

	public abstract Map<String, Object> findAllCheck();

	public abstract void save(TbTeamTactic tactic);

	public abstract void update(TbTeamTactic tactic);
	
	public abstract TbTeamTactic findById(java.lang.Long id);
	
	
	
	
	
	
}
