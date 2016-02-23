package com.ulysses.manager.dao;

import java.util.List;

import com.ulysses.manager.pojo.TbTntApplicant;

/**
 * 球队申请参赛Dao
 */
public interface ITntApplicantDAO {

	// property constants
	public static final String FROM_USER_ID = "fromUserId";
	public static final String FROM_USER_ALIAS_NAME = "fromUserAliasName";
	public static final String ALT_TEAM_ID = "altTeamId";
	public static final String ALT_TEAM_NAME = "altTeamName";
	public static final String APPLICANT_PLACE = "applicantPlace";
	public static final String APPLICANT_IP = "applicantIp";
	public static final String IS_OFFICIAL_TEAM = "isOfficialTeam";
	public static final String AGREE_STATE = "agreeState";
	public static final String APPROVE_STATE = "approveState";
	public static final String CREATE_USER_ID = "createUserId";
	public static final String UPDATE_USER_ID = "updateUserId";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";

	public abstract void save(TbTntApplicant transientInstance);

	public abstract void delete(TbTntApplicant persistentInstance);

	public abstract void update(TbTntApplicant persistentInstance);

	public abstract TbTntApplicant findById(java.lang.Long id);

	public abstract List findByExample(TbTntApplicant instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByFromUserId(Object fromUserId);

	public abstract List findByFromUserAliasName(Object fromUserAliasName);

	public abstract List findByAltTeamId(Object altTeamId);

	public abstract List findByAltTeamName(Object altTeamName);

	public abstract List findByApplicantPlace(Object applicantPlace);

	public abstract List findByApplicantIp(Object applicantIp);

	public abstract List findByIsOfficialTeam(Object isOfficialTeam);

	public abstract List findByAgreeState(Object agreeState);

	public abstract List findByApproveState(Object approveState);

	public abstract List findByCreateUserId(Object createUserId);

	public abstract List findByUpdateUserId(Object updateUserId);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);

	public abstract List findAll();

	public abstract TbTntApplicant merge(TbTntApplicant detachedInstance);

	public abstract void attachDirty(TbTntApplicant instance);

	public abstract void attachClean(TbTntApplicant instance);

}