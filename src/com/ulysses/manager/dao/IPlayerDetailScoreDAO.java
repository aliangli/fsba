package com.ulysses.manager.dao;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.manager.pojo.TbPlayerDetailScore;
import com.ulysses.manager.view.PlayerDetailScoreView;

/**
 * 球员得分详情
 */
public interface IPlayerDetailScoreDAO {

	// property constants
	public static final String PLAYER_ID = "playerId";
	public static final String PLAYER_NAME = "playerName";
	public static final String PLAYER_POSITION = "playerPosition";
	public static final String TOURNAMENT_ID = "tournamentId";
	public static final String PLAYER_TEAM_ID = "playerTeamId";
	public static final String SKILL_ENTER_TIME = "skillEnterTime";
	public static final String SKILL_BACKBOARD = "skillBackboard";
	public static final String SKILL_ASSIST = "skillAssist";
	public static final String SKILL_FOUL = "skillFoul";
	public static final String SKILL_STEAL = "skillSteal";
	public static final String SKILL_FAULT = "skillFault";
	public static final String SKILL_BLOCKING = "skillBlocking";
	public static final String SKILL_SCORE = "skillScore";
	public static final String RATIO_SHOOTING = "ratioShooting";
	public static final String RATIO_THIRD = "ratioThird";
	public static final String RATIO_PENALTY = "ratioPenalty";
	public static final String P1 = "p1";
	public static final String P2 = "p2";
	public static final String P3 = "p3";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";

	public abstract List findAllCheck(PlayerDetailScoreView view );
	
	public abstract void save(TbPlayerDetailScore transientInstance);

	public abstract void update(TbPlayerDetailScore persistentInstance);

	public abstract TbPlayerDetailScore findById(java.lang.Long id);

	public abstract List findByExample(TbPlayerDetailScore instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPlayerId(Object playerId);

	public abstract List findByPlayerName(Object playerName);

	public abstract List findByPlayerPosition(Object playerPosition);

	public abstract List findByTournamentId(Object tournamentId);

	public abstract List findByPlayerTeamId(Object playerTeamId);

	public abstract List findBySkillEnterTime(Object skillEnterTime);

	public abstract List findBySkillBackboard(Object skillBackboard);

	public abstract List findBySkillAssist(Object skillAssist);

	public abstract List findBySkillFoul(Object skillFoul);

	public abstract List findBySkillSteal(Object skillSteal);

	public abstract List findBySkillFault(Object skillFault);

	public abstract List findBySkillBlocking(Object skillBlocking);

	public abstract List findBySkillScore(Object skillScore);

	public abstract List findByRatioShooting(Object ratioShooting);

	public abstract List findByRatioThird(Object ratioThird);

	public abstract List findByRatioPenalty(Object ratioPenalty);

	public abstract List findByP1(Object p1);

	public abstract List findByP2(Object p2);

	public abstract List findByP3(Object p3);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);

	public abstract List findAll();
	

}