package com.ulysses.base.services.query;

import java.util.List;

public interface IBallTeamQuery {

	/**
	 * By球队名查询
	 * @param teamName
	 * @return
	 */
	public abstract List findByTeamName(String teamName);
	
	/**
	 * Find Team By User
	 */
	public abstract List findByUser(Long userId);
}
