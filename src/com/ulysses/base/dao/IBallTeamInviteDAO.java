package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.pojo.TbBallTeamInvite;

/**
 * 
 * 邀请信息DAO
 * 
 * 球队发出信息邀请球员
 *
 */
public interface IBallTeamInviteDAO {

	// property constants
	public static final String INVITE_FROM_USER_ID = "inviteFromUserId";
	public static final String INVITE_USER_ID = "inviteUserId";
	public static final String INVITE_TEAM_ID = "inviteTeamId";
	public static final String INVITE_TEAM_NAME = "inviteTeamName";
	public static final String INVITE_PLACE = "invitePlace";
	public static final String INVITE_IP = "inviteIp";
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
	 * 一个球队发出的所有邀请
	 */
	public abstract List allInvite(TbBallTeamInvite invite);

	/**
	 * 个人收到的所有邀请
	 */
	public abstract List myAllInvite(TbBallTeamInvite invite);

	/**
	 * 个人收到的所有邀请
	 */
	public abstract List inviteByUser(TbBallTeamInvite invite);

	public abstract void save(TbBallTeamInvite transientInstance);

	public abstract void update(TbBallTeamInvite transientInstance);

	public abstract void delete(TbBallTeamInvite persistentInstance);

	public abstract TbBallTeamInvite findById(java.lang.Long id);

	public abstract List findByExample(TbBallTeamInvite instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByInviteFromUserId(Object inviteFromUserId);

	public abstract List findByInviteUserId(Object inviteUserId);

	public abstract List findByInviteTeamId(Object inviteTeamId);

	public abstract List findByInviteTeamName(Object inviteTeamName);

	public abstract List findByInvitePlace(Object invitePlace);

	public abstract List findByInviteIp(Object inviteIp);

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

	public abstract TbBallTeamInvite merge(TbBallTeamInvite detachedInstance);

	public abstract void attachClean(TbBallTeamInvite instance);

}