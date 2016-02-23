package com.ulysses.base.dao.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.dao.INewsCommentDao;
import com.ulysses.base.dao.db.DBComment;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbNewsComment;
import com.ulysses.util.UtilParse;

/**
 * 评论Dao
 */
@Repository
public class TbNewsCommentDAO extends BaseHibernateDao implements INewsCommentDao  {
	

	private static final Logger log = LoggerFactory
			.getLogger(TbNewsCommentDAO.class);
	

	/**
	 * 动态的所有评论-分页
	 * @param comment
	 * @return
	 */
	public List findByNewsIdCheck(TbNewsComment comment,  PageBean page) {
		try {
			String queryString = "SELECT cm.*, us.alias_name as ccc FROM (SELECT c.comment_id, c.news_id, c.user_id, u.alias_name as aaa_name, c.comment_content, c.like_state, c.dialogue_user_id, c.create_date, u.user_photo_path  FROM tb_news_comment c LEFT JOIN tb_user u ON c.user_id = u.id WHERE c.is_valid='Y' AND c.delete_state='N' AND c.news_id=? ) cm LEFT JOIN tb_user us ON cm.dialogue_user_id = us.id ";
			Query queryObject = getSession().createSQLQuery(queryString).setParameter(0, comment.getNewsId());
			
			super.setPage(queryObject, page);
			
			return this.convertResult(queryObject.list());
		} catch (RuntimeException re) {
			log.error("find TbNewsComment failed", re);
			throw re;
		}
	}
	
	/**
	 * 动态的所有评论
	 * @param comment
	 * @return
	 */
	public List findByNewsIdCheck(TbNewsComment comment) {
		try {
			String queryString = "from TbNewsComment as model where model.isValid='Y' and model.deleteState='N' and model.newsId=? ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, comment.getNewsId());
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbNewsComment failed", re);
			throw re;
		}
	}
	
	/**
	 * 某个用户对于某个动态已点赞
	 * @param comment
	 * @return
	 */
	public List findByUserLike(TbNewsComment comment) {
		try {
			String queryString = "from TbNewsComment as model where model.isValid='Y' and model.deleteState='N' and model.likeState='Y' and model.userId=? and model.newsId=? ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, comment.getUserId());
			queryObject.setParameter(1, comment.getNewsId());
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbNewsComment failed", re);
			throw re;
		}
	}
	
	/**
	 * 某个用户点赞的动态
	 * @param newIdArray  ,分割
	 * @return
	 */
	public List findByUserLike(Long userId, String newIdArr) {
		try {
			String queryString = "from TbNewsComment as model where model.isValid='Y' and model.deleteState='N' and model.likeState='Y' and model.userId = ? and model.newsId in (:newIdArr) ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, userId);
			
			String[] idArr = newIdArr.split(",");
			Long[] intIdArr = UtilParse.parseStrArr(idArr);
			queryObject.setParameterList("newIdArr", intIdArr);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbNewsComment failed", re);
			throw re;
		}
	}
	


	private List convertResult(List arr) {

		List<DBComment> resultArr = new ArrayList<DBComment>();
		
		DBComment newsBean = null;
		for(Object obj : arr){
			Object[] param = (Object[]) obj;
			
			newsBean = new DBComment();
			newsBean.setCommentId(Long.parseLong(param[0].toString()));
			newsBean.setNewsId(Long.parseLong(param[1].toString()));
			newsBean.setUserId(Long.parseLong(param[2].toString()));
			newsBean.setAliseName((String) param[3]);
			newsBean.setCommentContent((String) param[4]);
			newsBean.setLikeState(param[5]==null?"":param[5].toString());

			newsBean.setDialogueUserId(param[6]==null? null : Long.parseLong(param[6].toString()));
			
			newsBean.setCreateDate((Date)param[7]);
			
			newsBean.setUserPhotoPath((String) param[8]);
			newsBean.setDialogueAliasName((String) param[9]);
			
			resultArr.add(newsBean);
		}
		
		return resultArr;
	}
	
	/**
	 * 用户对一个动态的所有评论
	 * @param comment
	 * @return
	 */
	public List findByUserCheck(TbNewsComment comment) {
		try {
			String queryString = "from TbNewsComment as model where model.isValid='Y' and model.deleteState='N' and model.newsId=?  and model.userId=? ";
			Query queryObject = getSession().createQuery(queryString).setParameter(0, comment.getNewsId()).setParameter(1, comment.getUserId());
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbNewsComment failed", re);
			throw re;
		}
	}


	public void save(TbNewsComment transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save TbNewsComment failed", re);
			throw re;
		}
	}

	public void update(TbNewsComment persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete TbNewsComment failed", re);
			throw re;
		}
	}

	public TbNewsComment findById(java.lang.Long id) {
		try {
			TbNewsComment instance = (TbNewsComment) getSession().get("com.ulysses.base.pojo.TbNewsComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get TbNewsComment failed", re);
			throw re;
		}
	}

	public List findByExample(TbNewsComment instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.base.pojo.TbNewsComment").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by TbNewsComment failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbNewsComment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by TbNewsComment failed", re);
			throw re;
		}
	}

	public List findByNewsId(Object newsId) {
		return findByProperty(NEWS_ID, newsId);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByCommentContent(Object commentContent) {
		return findByProperty(COMMENT_CONTENT, commentContent);
	}

	public List findByLikeState(Object likeState) {
		return findByProperty(LIKE_STATE, likeState);
	}

	public List findByDeleteState(Object deleteState) {
		return findByProperty(DELETE_STATE, deleteState);
	}

	public List findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	public List findAll() {
		try {
			String queryString = "from TbNewsComment";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbNewsComment merge(TbNewsComment detachedInstance) {
		log.debug("merging TbNewsComment instance");
		try {
			TbNewsComment result = (TbNewsComment) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbNewsComment instance) {
		log.debug("attaching dirty TbNewsComment instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbNewsComment instance) {
		log.debug("attaching clean TbNewsComment instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	

	
}