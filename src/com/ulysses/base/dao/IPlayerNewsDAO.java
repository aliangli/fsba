package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.pojo.TbPlayerNews;

/**
 * 个人发布动态Dao
 *
 */
public interface IPlayerNewsDAO {

	// property constants
	public static final String PLAYER_ID = "playerId";
	public static final String NEWS_SOURCE = "newsSource";
	public static final String MACHINE_PLACE = "machinePlace";
	public static final String MACHINE_IP = "machineIp";
	public static final String NEWS_CONTENT = "newsContent";
	public static final String NEWS_BMIDDLE_IMAGE = "newsBmiddleImage";
	public static final String NEWS_ORIGINAL_IMAGE = "newsOriginalImage";
	public static final String NEWS_THUMBNAIL_IMAGE = "newsThumbnailImage";
	public static final String TRANSPOND_COUNT = "transpondCount";
	public static final String COMMENTS_COUNT = "commentsCount";
	public static final String BROWSE_COUNT = "browseCount";
	public static final String PRAISE_COUNT = "praiseCount";
	public static final String PUBLIC_STATE = "publicState";
	public static final String ASSIGN_STATE = "assignState";
	public static final String CREATE_USER_ID = "createUserId";
	public static final String UPDATE_USER_ID = "updateUserId";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String APPROVE_STATE = "approveState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";

	/**
	 * 通过发布动态的数据ID查询
	 * @param idArr
	 * @return
	 */
	public abstract List findRelayNews(String idArr);
	
	public abstract List findAllFocusNews(TbPlayerNews news, PageBean page);
	
	/**
	 * 个人发布的所有有效动态
	 */
	public abstract List findByUserAll(TbPlayerNews instance, PageBean page);
	
	/**
	 * 发布一条动态
	 */
	public abstract void save(TbPlayerNews transientInstance);
	
	/**
	 * 设置为删除状态
	 */
	public abstract void delete(TbPlayerNews persistentInstance);

	public abstract void update(TbPlayerNews persistentInstance);

	public abstract TbPlayerNews findById(java.lang.Long id);

	public abstract List findByExample(TbPlayerNews instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPlayerId(Object playerId);

	public abstract List findByNewsSource(Object newsSource);

	public abstract List findByMachinePlace(Object machinePlace);

	public abstract List findByMachineIp(Object machineIp);

	public abstract List findByNewsContent(Object newsContent);

	public abstract List findByNewsBmiddleImage(Object newsBmiddleImage);

	public abstract List findByNewsOriginalImage(Object newsOriginalImage);

	public abstract List findByNewsThumbnailImage(Object newsThumbnailImage);

	public abstract List findByTranspondCount(Object transpondCount);

	public abstract List findByCommentsCount(Object commentsCount);

	public abstract List findByBrowseCount(Object browseCount);

	public abstract List findByPraiseCount(Object praiseCount);

	public abstract List findByPublicState(Object publicState);

	public abstract List findByAssignState(Object assignState);

	public abstract List findByCreateUserId(Object createUserId);

	public abstract List findByUpdateUserId(Object updateUserId);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByApproveState(Object approveState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);

	public abstract List findAll();

	public abstract TbPlayerNews merge(TbPlayerNews detachedInstance);

	public abstract void attachDirty(TbPlayerNews instance);

	public abstract void attachClean(TbPlayerNews instance);


}