package com.ulysses.base.dao.imp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.dao.IPlayerNewsDAO;
import com.ulysses.base.dao.db.DBPlayerNewsFocusUsers;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbPlayerNews;

/**
 * 个人发布动态Dao
 */
@Repository
public class TbPlayerNewsDAO extends BaseHibernateDao implements IPlayerNewsDAO {
	private static final Logger log = LoggerFactory.getLogger(TbPlayerNewsDAO.class);
	
	
	/**
	 * 关注的个人所有有效动态
	 */
	public List findAllFocusNews(TbPlayerNews news, PageBean page) {
		try {
			String sql = "SELECT p.id, p.player_id , p.news_content , p.news_bmiddle_Image , p.news_original_Image , p.news_thumbnail_Image , p.transpond_count , p.comments_count , p.browse_count , p.praise_count , p.create_date , u.alias_name , u.user_photo_path , p.from_news_id, p.from_news_convey FROM tb_focus f LEFT JOIN tb_player_news p ON f.user_focus_id = p.player_id LEFT JOIN tb_user u ON p.player_id = u.id WHERE p.is_valid = 'Y' AND p.delete_state = 'N' AND f.user_id = ? ORDER BY p.create_date DESC ";
			
			Query queryObject = getSession().createSQLQuery(sql);
			queryObject.setParameter(0, news.getPlayerId());
			
			super.setPage(queryObject, page);
			
			List arr = queryObject.list();
			return this.convertResult(arr);
		} catch (RuntimeException re) {
			log.error("find findAllFocusNews fail ", re);
			throw re;
		}
	}

	
	/**
	 * 个人发布的所有有效动态
	 */
	public List findByUserAll(TbPlayerNews news, PageBean page) {
		try {
			//String hql = "from TbPlayerNews as model where model.deleteState='N' and model.isValid='Y' and model.publicState='Y' and model.playerId = ? order by model.createDate desc ";
			String sql = "SELECT p.id, p.player_id , p.news_content , p.news_bmiddle_Image , p.news_original_Image , p.news_thumbnail_Image , p.transpond_count , p.comments_count , p.browse_count , p.praise_count , p.create_date , u.alias_name , u.user_photo_path , p.from_news_id, p.from_news_convey FROM tb_player_news p LEFT JOIN tb_user u ON p.player_id = u.id WHERE p.is_valid = 'Y' AND p.delete_state = 'N' AND p.player_id=? ORDER BY p.create_date DESC ";
			
			Query queryObject = getSession().createSQLQuery(sql);
			queryObject.setParameter(0, news.getPlayerId());
			
			this.setPage(queryObject, page);

			List arr = queryObject.list();
			return this.convertResult(arr);
		} catch (RuntimeException re) {
			log.error("find TbPlayerNews news ", re);
			throw re;
		}
	}
	
	/**
	 * 查询指定的动态
	 */
	public List findRelayNews(String idArr) {
		try {
			String sql = "SELECT p.id, p.player_id , p.news_content , p.news_bmiddle_Image , p.news_original_Image , p.news_thumbnail_Image , p.transpond_count , p.comments_count , p.browse_count , p.praise_count , p.create_date , u.alias_name , u.user_photo_path , p.from_news_id, p.from_news_convey FROM tb_player_news p LEFT JOIN tb_user u ON p.player_id = u.id WHERE p.is_valid = 'Y' AND p.delete_state = 'N' AND p.id in (:idArr) ORDER BY p.create_date DESC ";
			
			Query queryObject = getSession().createSQLQuery(sql);
			queryObject.setParameterList("idArr", idArr.split(","));
			
			List arr = queryObject.list();
			return this.convertResult(arr);
		} catch (RuntimeException re) {
			log.error("find findAllFocusNews fail ", re);
			throw re;
		}
	}
	


	private List convertResult(List arr) {

		List<DBPlayerNewsFocusUsers> resultArr = new ArrayList<DBPlayerNewsFocusUsers>();
		
		DBPlayerNewsFocusUsers newsBean = null;
		for(Object obj : arr){
			Object[] param = (Object[]) obj;
			
			newsBean = new DBPlayerNewsFocusUsers();
			newsBean.setId(Long.parseLong(param[0].toString()));
			newsBean.setPlayerId(Long.parseLong(param[1].toString()));
			newsBean.setNewsContent((String) param[2]);
			newsBean.setNewsBmiddleImage((String) param[3]);
			newsBean.setNewsOriginalImage((String) param[4]);
			newsBean.setNewsThumbnailImage((String) param[5]);
			
			newsBean.setTranspondCount(Long.parseLong(param[6].toString()));
			newsBean.setCommentsCount(Long.parseLong(param[7].toString()));
			newsBean.setBrowseCount(Long.parseLong(param[8].toString()));
			newsBean.setPraiseCount(Long.parseLong(param[9].toString()));
			
			newsBean.setCreateDate((Date)param[10]);
			
			newsBean.setAliasName((String) param[11]);
			newsBean.setUserPhotoPath((String) param[12]);

			newsBean.setFromNewsId(param[13]==null?null:Long.parseLong(param[13].toString()));
			newsBean.setFromNewsConvey((String) param[14]);
			
			resultArr.add(newsBean);
		}
		
		return resultArr;
	}

	/**
	 * 设置为删除状态
	 */
	public void delete(TbPlayerNews persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete TbPlayerNews failed", re);
			throw re;
		}
	}
	
	/**
	 * 发布一条动态
	 */
	public void save(TbPlayerNews transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save TbPlayerNews failed", re);
			throw re;
		}
	}
	
	public void update(TbPlayerNews transientInstance) {
		try {
			getSession().update(transientInstance);
		} catch (RuntimeException re) {
			log.error("save TbPlayerNews failed", re);
			throw re;
		}
	}



	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findById(java.lang.Long)
	 */
	public TbPlayerNews findById(java.lang.Long id) {
		try {
			TbPlayerNews instance = (TbPlayerNews) getSession().get("com.ulysses.base.pojo.TbPlayerNews", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get TbPlayerNews failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByExample(com.ulysses.base.pojo.TbPlayerNews)
	 */
	public List findByExample(TbPlayerNews instance) {
		try {
			List results = getSession().createCriteria("com.ulysses.base.pojo.TbPlayerNews").add(Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbPlayerNews instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbPlayerNews as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByPlayerId(java.lang.Object)
	 */
	public List findByPlayerId(Object playerId) {
		return findByProperty(PLAYER_ID, playerId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByNewsSource(java.lang.Object)
	 */
	public List findByNewsSource(Object newsSource) {
		return findByProperty(NEWS_SOURCE, newsSource);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByMachinePlace(java.lang.Object)
	 */
	public List findByMachinePlace(Object machinePlace) {
		return findByProperty(MACHINE_PLACE, machinePlace);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByMachineIp(java.lang.Object)
	 */
	public List findByMachineIp(Object machineIp) {
		return findByProperty(MACHINE_IP, machineIp);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByNewsContent(java.lang.Object)
	 */
	public List findByNewsContent(Object newsContent) {
		return findByProperty(NEWS_CONTENT, newsContent);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByNewsBmiddleImage(java.lang.Object)
	 */
	public List findByNewsBmiddleImage(Object newsBmiddleImage) {
		return findByProperty(NEWS_BMIDDLE_IMAGE, newsBmiddleImage);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByNewsOriginalImage(java.lang.Object)
	 */
	public List findByNewsOriginalImage(Object newsOriginalImage) {
		return findByProperty(NEWS_ORIGINAL_IMAGE, newsOriginalImage);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByNewsThumbnailImage(java.lang.Object)
	 */
	public List findByNewsThumbnailImage(Object newsThumbnailImage) {
		return findByProperty(NEWS_THUMBNAIL_IMAGE, newsThumbnailImage);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByTranspondCount(java.lang.Object)
	 */
	public List findByTranspondCount(Object transpondCount) {
		return findByProperty(TRANSPOND_COUNT, transpondCount);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByCommentsCount(java.lang.Object)
	 */
	public List findByCommentsCount(Object commentsCount) {
		return findByProperty(COMMENTS_COUNT, commentsCount);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByBrowseCount(java.lang.Object)
	 */
	public List findByBrowseCount(Object browseCount) {
		return findByProperty(BROWSE_COUNT, browseCount);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByPraiseCount(java.lang.Object)
	 */
	public List findByPraiseCount(Object praiseCount) {
		return findByProperty(PRAISE_COUNT, praiseCount);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByPublicState(java.lang.Object)
	 */
	public List findByPublicState(Object publicState) {
		return findByProperty(PUBLIC_STATE, publicState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByAssignState(java.lang.Object)
	 */
	public List findByAssignState(Object assignState) {
		return findByProperty(ASSIGN_STATE, assignState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByCreateUserId(java.lang.Object)
	 */
	public List findByCreateUserId(Object createUserId) {
		return findByProperty(CREATE_USER_ID, createUserId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByUpdateUserId(java.lang.Object)
	 */
	public List findByUpdateUserId(Object updateUserId) {
		return findByProperty(UPDATE_USER_ID, updateUserId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByOrderBy(java.lang.Object)
	 */
	public List findByOrderBy(Object orderBy) {
		return findByProperty(ORDER_BY, orderBy);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByDeleteState(java.lang.Object)
	 */
	public List findByDeleteState(Object deleteState) {
		return findByProperty(DELETE_STATE, deleteState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByApproveState(java.lang.Object)
	 */
	public List findByApproveState(Object approveState) {
		return findByProperty(APPROVE_STATE, approveState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByIsValid(java.lang.Object)
	 */
	public List findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findByVersion(java.lang.Object)
	 */
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#findAll()
	 */
	public List findAll() {
		try {
			String queryString = "from TbPlayerNews";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#merge(com.ulysses.base.pojo.TbPlayerNews)
	 */
	public TbPlayerNews merge(TbPlayerNews detachedInstance) {
		try {
			TbPlayerNews result = (TbPlayerNews) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#attachDirty(com.ulysses.base.pojo.TbPlayerNews)
	 */
	public void attachDirty(TbPlayerNews instance) {
		log.debug("attaching dirty TbPlayerNews instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerNewsDAO#attachClean(com.ulysses.base.pojo.TbPlayerNews)
	 */
	public void attachClean(TbPlayerNews instance) {
		log.debug("attaching clean TbPlayerNews instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}