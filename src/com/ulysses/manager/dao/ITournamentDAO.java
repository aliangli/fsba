package com.ulysses.manager.dao;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.manager.pojo.TbTournament;
import com.ulysses.manager.support.Param;
import com.ulysses.manager.view.TournamentView;

/**
 * 比赛Dao
 */
public interface ITournamentDAO {

	// property constants
	public static final String TOURNAMENT_CODE = "tournamentCode";
	public static final String TOURNAMENT_NAME = "tournamentName";
	public static final String TOURNAMENT_CHINESE_NAME = "tournamentChineseName";
	public static final String TOURNAMENT_ENGLISH_NAME = "tournamentEnglishName";
	public static final String TOURNAMENT_ALIAS_NAME = "tournamentAliasName";
	public static final String TOURNAMENT_MAJOR_SPONSOR = "tournamentMajorSponsor";
	public static final String TOURNAMENT_SPONSOR = "tournamentSponsor";
	public static final String TOURNAMENT_PACE = "tournamentPace";
	public static final String TOURNAMENT_CITY = "tournamentCity";
	public static final String TOURNAMENT_PHONE_NUMBER = "tournamentPhoneNumber";
	public static final String TOURNAMENT_QQ_NUMBER = "tournamentQqNumber";
	public static final String TOURNAMENT_WEIX_NUMBER = "tournamentWeixNumber";
	public static final String TOURNAMENT_WEIB_NUMBER = "tournamentWeibNumber";
	public static final String TOURNAMENT_PHOTO_PATH = "tournamentPhotoPath";
	public static final String TOURNAMENT_REMARK = "tournamentRemark";
	public static final String P1 = "p1";
	public static final String P2 = "p2";
	public static final String P3 = "p3";
	public static final String TOURNAMENT_STATE = "tournamentState";
	public static final String ENROLL_VALID = "enrollValid";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";

	public abstract void save(TbTournament transientInstance);

	public abstract void update(TbTournament persistentInstance);

	public abstract TbTournament findById(java.lang.Long id);

	public abstract List findByExample(TbTournament instance);
	
	public abstract List findAllCheck(PageBean page);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTournamentCode(Object tournamentCode);

	public abstract List findByTournamentName(Object tournamentName);

	public abstract List findByTournamentChineseName(
			Object tournamentChineseName);

	public abstract List findByTournamentEnglishName(
			Object tournamentEnglishName);

	public abstract List findByTournamentAliasName(Object tournamentAliasName);

	public abstract List findByTournamentMajorSponsor(
			Object tournamentMajorSponsor);

	public abstract List findByTournamentSponsor(Object tournamentSponsor);

	public abstract List findByTournamentPace(Object tournamentPace);

	public abstract List findByTournamentCity(Object tournamentCity);

	public abstract List findByTournamentPhoneNumber(
			Object tournamentPhoneNumber);

	public abstract List findByTournamentQqNumber(Object tournamentQqNumber);

	public abstract List findByTournamentWeixNumber(Object tournamentWeixNumber);

	public abstract List findByTournamentWeibNumber(Object tournamentWeibNumber);

	public abstract List findByTournamentPhotoPath(Object tournamentPhotoPath);

	public abstract List findByTournamentRemark(Object tournamentRemark);

	public abstract List findByP1(Object p1);

	public abstract List findByP2(Object p2);

	public abstract List findByP3(Object p3);

	public abstract List findByTournamentState(Object tournamentState);

	public abstract List findByEnrollValid(Object enrollValid);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);

	public abstract List findAll();



}