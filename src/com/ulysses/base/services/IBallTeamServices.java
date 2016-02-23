package com.ulysses.base.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.view.BallTeamView;
import com.ulysses.base.view.UserView;

/**
 * 球队Service
 *
 */
public interface IBallTeamServices {


	
	/**
	 * 用户创建的球队收到的所有申请记录
	 */
	public abstract Map<String, Object> applicantAllTeam(BallTeamView view);

	/**
	 * 退出球队
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> exitTeam(BallTeamView view);
	
	/**
	 * 解散球队
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> disbandTeam(BallTeamView view);

	/**
	 * 加入的球队
	 * @param id
	 * @return
	 */
	public abstract Map<String, Object> findByUserId(UserView view);
	
	/**
	 * 创建的球队
	 * @param id
	 * @return
	 */
	public abstract Map<String, Object> findByTeamCreateUserId(UserView view);
	

	/**
	 * 未包含此球队名字的集合
	 * @param teamName
	 * @return
	 */
	public abstract List findByTeamNotContain(TbBallTeam team);
	
	
	/**
	 * 用户ID 和 球队ID 和 解散状态  来查询球队信息
	 * 
	 * @param 创建球队用户ID
	 * @param 球队ID
	 * 
	 */
	public abstract List isMyTeam(TbBallTeam team);
	
	/**
	 *   球队ID 和 解散状态  来查询球队信息
	 * 
	 */
	public abstract List findTeamDisband(TbBallTeam team);
	
	
	/**
	 * 创建球队
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> save(BallTeamView view, HttpServletRequest request);
	

	/**
	 * 根据球队ID 获取球队的所有队员信息
	 */
	public abstract List allBallPlayerByTeam(Long teamId);

	/**
	 * By球队名查询
	 * @param teamName
	 * @return
	 */
	public abstract List findByTeamName(String teamName);

	/**
	 * 修改球队
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> update(BallTeamView view, HttpServletRequest request);

	public abstract void delete(TbBallTeam persistentInstance);

	public abstract TbBallTeam findById(java.lang.Long id);

	public abstract List findByExample(TbBallTeam instance);

	public abstract List findByProperty(String propertyName, Object value);

	
	public abstract List findByTeamNameLike(BallTeamView view);

	public abstract List findByTeamOccupant(Object teamOccupant);

	public abstract List findByTeamCoach(Object teamCoach);

	public abstract List findByTeamChineseName(Object teamChineseName);

	public abstract List findByTeamEnglishName(Object teamEnglishName);

	public abstract List findByTeamNationality(Object teamNationality);

	public abstract List findByIsValid(Object isValid);

	public abstract List findAll();

	public abstract TbBallTeam merge(TbBallTeam detachedInstance);

	
}
