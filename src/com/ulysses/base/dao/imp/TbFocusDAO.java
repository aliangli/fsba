package com.ulysses.base.dao.imp;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.dao.IFocusDao;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbFocus;

/**
 * 关注个人Dao
 */
@Repository
public class TbFocusDAO extends BaseHibernateDao implements IFocusDao {
	private static final Logger log = LoggerFactory.getLogger(TbFocusDAO.class);
	
	/**
	 * 用户ID 和 被关注用户ID 查询
	 */
	public List findFocusByUser(TbFocus instance) {
		try {
			String hql = "from TbFocus as model where model.userFocusId = ? and model.userId = ?  ";
			
			Query queryObject = getSession().createQuery(hql);
			queryObject.setParameter(0, instance.getUserFocusId());
			queryObject.setParameter(1, instance.getUserId());
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error(" my find queryObject TbFocus failed", re);
			throw re;
		}
		
	}
	
	/**
	 * 用户ID 和 关注用户ID 查询
	 */
	public List findFocusCheck(TbFocus instance) {
		
		try {
			String hql = "from TbFocus as model where model.isValid='Y' and model.userFocusId=? and model.userId=?  ";
			
			Query queryObject = getSession().createQuery(hql);
			queryObject.setParameter(0, instance.getUserFocusId());
			queryObject.setParameter(1, instance.getUserId());
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find findFocusCheck failed", re);
			throw re;
		}
		
	}

	
	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IFocusDao#save(com.ulysses.base.pojo.TbFocus)
	 */
	public void save(TbFocus transientInstance) {
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbFocus persistentInstance) {
		try {
			getSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IFocusDao#findById(java.lang.Long)
	 */
	public TbFocus findById(java.lang.Long id) {
		try {
			TbFocus instance = (TbFocus) getSession().get(
					"com.ulysses.base.pojo.TbFocus", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IFocusDao#findByExample(com.ulysses.base.pojo.TbFocus)
	 */
	public List findByExample(TbFocus instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.base.pojo.TbFocus").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IFocusDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbFocus as model where model."
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
	 * @see com.ulysses.base.dao.imp.IFocusDao#findByUserId(java.lang.Object)
	 */
	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IFocusDao#findByUserFocusId(java.lang.Object)
	 */
	public List findByUserFocusId(Object userFocusId) {
		return findByProperty(USER_FOCUS_ID, userFocusId);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IFocusDao#findAll()
	 */
	public List findAll() {
		try {
			String queryString = "from TbFocus";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IFocusDao#merge(com.ulysses.base.pojo.TbFocus)
	 */
	public TbFocus merge(TbFocus detachedInstance) {
		try {
			TbFocus result = (TbFocus) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbFocus instance) {
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void update(TbFocus instance) {
		try {
			getSession().update(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void attachClean(TbFocus instance) {
		log.debug("attaching clean TbFocus instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
}