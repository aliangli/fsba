package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.pojo.TbBallTeamRef;
import com.ulysses.base.view.UserView;

/**
 * 球队 Dao
 * 
 */
public interface IBallTeamDAO {

	// property constants
	public static final String TEAM_NAME = "teamName";
	public static final String TEAM_OCCUPANT = "teamOccupant";
	public static final String TEAM_COACH = "teamCoach";
	public static final String TEAM_CHINESE_NAME = "teamChineseName";
	public static final String TEAM_ENGLISH_NAME = "teamEnglishName";
	public static final String TEAM_NATIONALITY = "teamNationality";
	public static final String TEAM_CITY = "teamCity";
	public static final String TEAM_POPULATION = "teamPopulation";
	public static final String CHAMPION_NUMBER = "championNumber";
	public static final String TEAM_HONOUR = "teamHonour";
	public static final String TEAM_REMARK = "teamRemark";
	
	public static final String SPORTSWEAR_COLOR = "sportswearColor";
	
	public static final String CREATE_USER_ID = "createUserId";
	public static final String IS_OFFICIAL_TEAM = "isOfficialTeam";
	public static final String APPROVE_STATE = "approveState";
	public static final String IS_DISBAND = "isDisband";
	public static final String UPDATE_USER_ID = "updateUserId";
	
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";

	/**
	 * 搜索球队 By 球队名称
	 */
	public abstract List findByTeamNameLike(TbBallTeam team, PageBean page);
	
	/**
	 * By球队名查询
	 */
	public abstract List findByTeamNameCheck(Object teamName);

	/**
	 * 用户创建的球队收到的所有申请记录
	 */
	public abstract List applicantAllTeam(TbBallTeam team);
	
	/**
	 * 参与的球队 By 用户
	 * @param id
	 * @return
	 */
	public abstract List findByUserId(UserView view, PageBean page);

	/**
	 * 创建的球队By userId
	 * @param userId
	 * @return
	 */
	public abstract List findByUserId(Long userId);

	/**
	 * 创建的球队 By 用户
	 * @param userID
	 * @return
	 */
	public abstract List findByTeamCreateUserId(UserView view, PageBean page);

	/**
	 * 某用户创建的球队 By 用户ID and 球队ID
	 * 
	 * @param 用户ID
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
	 * 未包含此球队名字的集合
	 * @param teamName
	 * @return
	 */
	public abstract List findByTeamNotContain(TbBallTeam team);
	
	/**
	 * 获取所有有效的球队
	 * @return
	 */
	public abstract List findAllCheck();
	
	

	public abstract void save(TbBallTeam transientInstance);

	public abstract void update(TbBallTeam transientInstance);

	public abstract void delete(TbBallTeam persistentInstance);

	public abstract TbBallTeam findById(java.lang.Long id);

	public abstract List findByExample(TbBallTeam instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTeamName(Object teamName);
	

	public abstract List findByTeamOccupant(Object teamOccupant);

	public abstract List findByTeamCoach(Object teamCoach);

	public abstract List findByTeamChineseName(Object teamChineseName);

	public abstract List findByTeamEnglishName(Object teamEnglishName);

	public abstract List findByTeamNationality(Object teamNationality);

	public abstract List findByIsValid(Object isValid);

	public abstract List findAll();
	

	public abstract TbBallTeam merge(TbBallTeam detachedInstance);



}