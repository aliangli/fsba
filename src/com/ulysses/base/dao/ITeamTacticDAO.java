package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.pojo.TbTeamTactic;

public interface ITeamTacticDAO {

	// property constants
	public static final String TACTIC_TITLE = "tacticTitle";
	public static final String TACTIC_TITLE_IMG = "tacticTitleImg";
	public static final String TACTIC_BODY = "tacticBody";
	public static final String TACTIC_VIDEO_PATH = "tacticVideoPath";
	public static final String CREATE_USER_ID = "createUserId";
	public static final String UPDATE_USER_ID = "updateUserId";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";
	
	public abstract List findAllCheck();

	public abstract void save(TbTeamTactic tactic);

	public abstract void update(TbTeamTactic tactic);

	public abstract TbTeamTactic findById(java.lang.Long id);

	public abstract List findByExample(TbTeamTactic tactic);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTacticTitle(Object tacticTitle);

	public abstract List findByTacticTitleImg(Object tacticTitleImg);

	public abstract List findByTacticBody(Object tacticBody);

	public abstract List findByTacticVideoPath(Object tacticVideoPath);

	public abstract List findByCreateUserId(Object createUserId);

	public abstract List findByUpdateUserId(Object updateUserId);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);

	public abstract List findAll();

	public abstract TbTeamTactic merge(TbTeamTactic tactic);

	public abstract void attachDirty(TbTeamTactic tactic);

	public abstract void attachClean(TbTeamTactic tactic);

}