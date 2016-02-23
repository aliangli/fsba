package com.ulysses.manager.dao;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.manager.pojo.TbTournamentProcess;
import com.ulysses.manager.view.TournamentProcessView;

/**
 * 赛程Dao
 */
public interface ITournamentProcessDAO {

	// property constants
	public static final String TOURNAMENT_ID = "tournamentId";
	public static final String TOURNAMENT_HOST_TEAM_ID = "tournamentHostTeamId";
	public static final String TOURNAMENT_GUEST_TEAM_ID = "tournamentGuestTeamId";
	public static final String HOST_TEAM_SCORE = "hostTeamScore";
	public static final String GUEST_TEAM_SCORE = "guestTeamScore";
	public static final String TOURNAMENT_STATE = "tournamentState";
	public static final String REMARK = "remark";
	public static final String P1 = "p1";
	public static final String P2 = "p2";
	public static final String P3 = "p3";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";

	public abstract void save(TbTournamentProcess transientInstance);

	public abstract void update(TbTournamentProcess persistentInstance);

	public abstract TbTournamentProcess findById(java.lang.Long id);

	public abstract List findByExample(TbTournamentProcess instance);

	public abstract List findAllCheck(TournamentProcessView view, PageBean page);
	
	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTournamentId(Object tournamentId);

	public abstract List findByTournamentHostTeamId(Object tournamentHostTeamId);

	public abstract List findByTournamentGuestTeamId(
			Object tournamentGuestTeamId);

	public abstract List findByHostTeamScore(Object hostTeamScore);

	public abstract List findByGuestTeamScore(Object guestTeamScore);

	public abstract List findByTournamentState(Object tournamentState);

	public abstract List findByRemark(Object remark);

	public abstract List findByP1(Object p1);

	public abstract List findByP2(Object p2);

	public abstract List findByP3(Object p3);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);


	public abstract List findAll();


}