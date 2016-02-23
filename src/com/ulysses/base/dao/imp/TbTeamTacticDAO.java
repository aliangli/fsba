package com.ulysses.base.dao.imp;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.dao.ITeamTacticDAO;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbTeamTactic;

/**
 * 战术Dao
 */
@Repository
public class TbTeamTacticDAO extends BaseHibernateDao implements ITeamTacticDAO {
	private static final Logger log = LoggerFactory.getLogger(TbTeamTacticDAO.class);
	

	/**
	 * 所有战术
	 * @return
	 */
	public List findAllCheck() {
		try {
			String queryString = "from TbTeamTactic model where model.isValid='Y' and model.deleteState='N' ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void save(TbTeamTactic transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbTeamTactic persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTeamTactic findById(java.lang.Long id) {
		try {
			TbTeamTactic instance = (TbTeamTactic) getSession().get("com.ulysses.base.pojo.TbTeamTactic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTeamTactic instance) {
		try {
			List results = getSession().createCriteria("com.ulysses.base.pojo.TbTeamTactic").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbTeamTactic as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTacticTitle(Object tacticTitle) {
		return findByProperty(TACTIC_TITLE, tacticTitle);
	}

	public List findByTacticTitleImg(Object tacticTitleImg) {
		return findByProperty(TACTIC_TITLE_IMG, tacticTitleImg);
	}

	public List findByTacticBody(Object tacticBody) {
		return findByProperty(TACTIC_BODY, tacticBody);
	}

	public List findByTacticVideoPath(Object tacticVideoPath) {
		return findByProperty(TACTIC_VIDEO_PATH, tacticVideoPath);
	}

	public List findByCreateUserId(Object createUserId) {
		return findByProperty(CREATE_USER_ID, createUserId);
	}

	public List findByUpdateUserId(Object updateUserId) {
		return findByProperty(UPDATE_USER_ID, updateUserId);
	}

	public List findByOrderBy(Object orderBy) {
		return findByProperty(ORDER_BY, orderBy);
	}

	public List findByDeleteState(Object deleteState) {
		return findByProperty(DELETE_STATE, deleteState);
	}

	public List findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findAll() {
		try {
			String queryString = "from TbTeamTactic ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTeamTactic merge(TbTeamTactic detachedInstance) {
		try {
			TbTeamTactic result = (TbTeamTactic) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTeamTactic instance) {
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTeamTactic instance) {
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}