package com.ulysses.base.services;

import java.util.Map;

import com.ulysses.base.view.BallTeamInviteView;

/**
 * 
 * 邀请信息DAO
 * 
 * 球队发出信息邀请球员
 *
 */
public interface IBallTeamInviteServices {


	/**
	 * 球队创建人发出邀请 , 邀请球员加入球队
	 */
	public abstract Map<String, Object> send(BallTeamInviteView view);

	/**
	 * 设置邀请为同意状态
	 */
	public abstract Map<String, Object> editAgreeYes(BallTeamInviteView view);
	
	/**
	 * 设置邀请为忽略状态
	 */
	public abstract Map<String, Object> editAgreeIgnore(BallTeamInviteView view);
	

	/**
	 * 一个球队发出的所有邀请
	 */
	public abstract Map<String, Object> inviteByTeam(BallTeamInviteView view);

	/**
	 * 个人收到的所有邀请
	 */
	public abstract Map<String, Object> getInviteMe(BallTeamInviteView view);
}
