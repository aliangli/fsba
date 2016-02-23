package com.ulysses.base.services;

import java.util.List;
import java.util.Map;

import com.ulysses.base.pojo.TbBallTeamApplicant;
import com.ulysses.base.view.BallTeamApplicantView;
import com.ulysses.base.view.BallTeamView;

/**
 * 申请信息Service
 * 
 * 球员申请加入球队
 */
public interface IBallTeamApplicantServices {

	
	/**
	 * 一个球队 所有的申请记录
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> applicantByTeam(BallTeamView view);

	
	/**
	 * 查询球队收到的申请记录
	 * 未同意状态的申请记录
	 * @param applicant
	 * @return
	 */
	public abstract List findTeamApplicant(TbBallTeamApplicant applicant);

	/**
	 * 设置球队所有申请信息的解散状态
	 */
	public abstract void editTeamDisband(TbBallTeamApplicant applicant);

	
	/**
	 * 球员发出申请
	 */
	public abstract Map<String, Object> send(BallTeamApplicantView view);

	/**
	 * 设置申请加入球队为忽略状态
	 */
	public abstract Map<String, Object> editAgreeIgnore(BallTeamApplicantView view);
	
	/**
	 * 设置申请加入球队为同意状态
	 */
	public abstract Map<String, Object> editAgreeYes(BallTeamApplicantView view);
	

	public abstract TbBallTeamApplicant findById(java.lang.Long id);

	public abstract List findByExample(TbBallTeamApplicant instance);

	public abstract void save(TbBallTeamApplicant transientInstance);
	
	public abstract void update(TbBallTeamApplicant transientInstance);

	public abstract List findAll();

	
}
