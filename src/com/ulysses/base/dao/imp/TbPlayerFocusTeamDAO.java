package com.ulysses.base.dao.imp;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.dao.IPlayerFocusTeamDao;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbPlayerFocusTeam;
import com.ulysses.base.view.FocusTeamView;

/**
 * 关注球队Dao
 */
@Repository
public class TbPlayerFocusTeamDAO extends BaseHibernateDao implements IPlayerFocusTeamDao {
	private static final Logger log = LoggerFactory.getLogger(TbPlayerFocusTeamDAO.class);
	

	/**
	 * 根据 球队ID获取一条关注球队的信息
	 */
	public List findFocusTeam(TbPlayerFocusTeam transientInstance) {
		try {
			String queryString = "from TbPlayerFocusTeam as model where model.userId = ? and model.teamId = ? ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, transientInstance.getUserId());
			queryObject.setParameter(1, transientInstance.getTeamId());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 根据 球队ID和用户ID查询集合
	 */
	public List findByCheckUser(TbPlayerFocusTeam transientInstance) {
		try {
			String queryString = "from TbPlayerFocusTeam as model where model.userId = ? and model.teamId = ? ";
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, transientInstance.getUserId());
			queryObject.setParameter(1, transientInstance.getTeamId());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 关注的所有球队
	 */
	public List findAll(FocusTeamView view, PageBean page) {
		try {
			String queryString = "from TbPlayerFocusTeam as model where model.isValid='Y' and model.userId = ? ";
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, view.getUserId());
			super.setPage(queryObject, page);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 关注一个球队
	 */
	public void save(TbPlayerFocusTeam transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("create focus team", re);
			throw re;
		}
	}

	/**
	 * 修改
	 */
	public void update(TbPlayerFocusTeam persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#delete(com.ulysses.base.pojo.TbPlayerFocusTeam)
	 */
	public void delete(TbPlayerFocusTeam persistentInstance) {
		log.debug("deleting TbPlayerFocusTeam instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#findById(java.lang.Long)
	 */
	public TbPlayerFocusTeam findById(java.lang.Long id) {
		try {
			TbPlayerFocusTeam instance = (TbPlayerFocusTeam) getSession().get("com.ulysses.base.pojo.TbPlayerFocusTeam", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#findByExample(com.ulysses.base.pojo.TbPlayerFocusTeam)
	 */
	public List findByExample(TbPlayerFocusTeam instance) {
		log.debug("finding TbPlayerFocusTeam instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ulysses.base.pojo.TbPlayerFocusTeam").add(
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
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbPlayerFocusTeam instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbPlayerFocusTeam as model where model."
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
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#findByUserId(java.lang.Object)
	 */
	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#findByTeamId(java.lang.Object)
	 */
	public List findByTeamId(Object teamId) {
		return findByProperty(TEAM_ID, teamId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#findByIsValid(java.lang.Object)
	 */
	public List findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#findByRemark(java.lang.Object)
	 */
	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		try {
			String queryString = "from TbPlayerFocusTeam";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#merge(com.ulysses.base.pojo.TbPlayerFocusTeam)
	 */
	public TbPlayerFocusTeam merge(TbPlayerFocusTeam detachedInstance) {
		log.debug("merging TbPlayerFocusTeam instance");
		try {
			TbPlayerFocusTeam result = (TbPlayerFocusTeam) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#attachDirty(com.ulysses.base.pojo.TbPlayerFocusTeam)
	 */
	public void attachDirty(TbPlayerFocusTeam instance) {
		log.debug("attaching dirty TbPlayerFocusTeam instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IPlayerFocusTeamDao#attachClean(com.ulysses.base.pojo.TbPlayerFocusTeam)
	 */
	public void attachClean(TbPlayerFocusTeam instance) {
		log.debug("attaching clean TbPlayerFocusTeam instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}