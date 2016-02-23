package com.ulysses.manager.dao;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.manager.pojo.TbTournamentTeamRef;
import com.ulysses.manager.view.TournamentTeamRefView;
import com.ulysses.manager.view.TournamentView;

/**
 * 参赛球队关系Dao
 */
public interface ITournamentTeamRefDAO {

	// property constants
	public static final String TOURNAMENT_ID = "tournamentId";
	public static final String TOURNAMENT_TEAM_ID = "tournamentTeamId";
	public static final String TOURNAMENT_LINKMAN = "tournamentLinkman";
	public static final String LINKMAN_PHONE_NUMBER = "linkmanPhoneNumber";
	public static final String LINKMAN_QQ_NUMBER = "linkmanQqNumber";
	public static final String LINKMAN_WEIX_NUMBER = "linkmanWeixNumber";
	public static final String LINKMAN_WEIB_NUMBER = "linkmanWeibNumber";
	public static final String REMARK = "remark";
	public static final String ENROLL_STATE = "enrollState";
	public static final String P1 = "p1";
	public static final String P2 = "p2";
	public static final String P3 = "p3";
	public static final String P4 = "p4";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";
	

	/**
	 * 球队参与的赛事
	 * @param view
	 * @param page
	 * @return
	 */
	public abstract List findByUserTeam(String teamIdArr, PageBean page);
	
	/**
	 * 个人参与的赛事
	 * @param userId
	 * @param page
	 * @return
	 */
	public abstract List findByUser(Long userId, PageBean page);


	public abstract void save(TbTournamentTeamRef transientInstance);

	public abstract void update(TbTournamentTeamRef persistentInstance);

	public abstract TbTournamentTeamRef findById(java.lang.Long id);

	public abstract List findByExample(TbTournamentTeamRef instance);

	public abstract List findAllCheck(TournamentTeamRefView view, PageBean page);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTournamentId(Object tournamentId);

	public abstract List findByTournamentTeamId(Object tournamentTeamId);

	public abstract List findByTournamentLinkman(Object tournamentLinkman);

	public abstract List findByLinkmanPhoneNumber(Object linkmanPhoneNumber);

	public abstract List findByLinkmanQqNumber(Object linkmanQqNumber);

	public abstract List findByLinkmanWeixNumber(Object linkmanWeixNumber);

	public abstract List findByLinkmanWeibNumber(Object linkmanWeibNumber);

	public abstract List findByRemark(Object remark);

	public abstract List findByEnrollState(Object enrollState);

	public abstract List findByP1(Object p1);

	public abstract List findByP2(Object p2);

	public abstract List findByP3(Object p3);

	public abstract List findByP4(Object p4);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);

	public abstract List findAll();


}