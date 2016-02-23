package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.pojo.TbBallTeamApplicant;
import com.ulysses.base.view.BallTeamView;

/**
 * 
 * 申请信息Dao 
 * 
 * 球员申请加入球队
 *
 */
public interface IBallTeamApplicantDAO {

	// property constants
	public static final String APPLICANT_FROM_USER_ID = "applicantFromUserId";
	public static final String APPLICANT_TEAM_ID = "applicantTeamId";
	public static final String APPLICANT_TEAM_NAME = "applicantTeamName";
	public static final String APPLICANT_PLACE = "applicantPlace";
	public static final String APPLICANT_IP = "applicantIp";
	public static final String IS_OFFICIAL_TEAM = "isOfficialTeam";
	public static final String AGREE_STATE = "agreeState";
	public static final String APPROVE_STATE = "approveState";
	public static final String IS_DISBAND = "isDisband";
	public static final String CREATE_USER_ID = "createUserId";
	public static final String UPDATE_USER_ID = "updateUserId";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";
	

	/**
	 * 一个球队 所有的申请记录
	 * @param view
	 * @return
	 */
	public abstract List applicantByTeam(TbBallTeamApplicant view);

	/**
	 * 设置球队所有申请信息的解散状态
	 */
	public abstract void editTeamDisband(TbBallTeamApplicant applicant);

	/**
	 * 根据申请的用户ID 来查询球队收到的申请记录
	 * 未同意状态的申请记录
	 * @param applicant
	 * @return
	 */
	public abstract List findTeamApplicant(TbBallTeamApplicant applicant);


	public abstract void save(TbBallTeamApplicant transientInstance);
	
	public abstract void update(TbBallTeamApplicant transientInstance);

	public abstract TbBallTeamApplicant findById(java.lang.Long id);

	public abstract List findByExample(TbBallTeamApplicant instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByApplicantFromUserId(Object applicantFromUserId);

	public abstract List findByApplicantTeamId(Object applicantTeamId);

	public abstract List findByApplicantTeamName(Object applicantTeamName);

	public abstract List findByApplicantPlace(Object applicantPlace);

	public abstract List findByApplicantIp(Object applicantIp);

	public abstract List findByIsOfficialTeam(Object isOfficialTeam);

	public abstract List findByApproveState(Object approveState);

	public abstract List findByIsDisband(Object isDisband);

	public abstract List findByCreateUserId(Object createUserId);

	public abstract List findByUpdateUserId(Object updateUserId);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);

	public abstract List findAll();

	public abstract TbBallTeamApplicant merge(
			TbBallTeamApplicant detachedInstance);

	public abstract void attachDirty(TbBallTeamApplicant instance);

	public abstract void attachClean(TbBallTeamApplicant instance);

}