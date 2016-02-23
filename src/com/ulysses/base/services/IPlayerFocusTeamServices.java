package com.ulysses.base.services;

import java.util.Map;

import com.ulysses.base.view.FocusTeamView;

/**
 * 关注球队
 *
 */
public interface IPlayerFocusTeamServices {

	/**
	 * 关注的球队
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> findFocusTeams(FocusTeamView view);
	
	/**
	 * 关注一个球队
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> createFocusTeam(FocusTeamView view);
	
	/**
	 * 取消关注一个球队
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> cancelFocusTeam(FocusTeamView view);
	
	
	/**
	 * 判断是否已关注球队
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> isFocusTeam(FocusTeamView view);
	
	
	
}
