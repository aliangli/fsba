package com.ulysses.base.dao.imp;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.dao.IAreanDao;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbArean;

/**
 * 篮球馆场地
 */
@Repository
public class TbAreanDAO extends BaseHibernateDao implements IAreanDao {
	private static final Logger log = LoggerFactory.getLogger(TbAreanDAO.class);
	
	public List findAllCheck(PageBean page) {
		try {
			String queryString = "from TbArean model where model.isValid='Y' and model.deleteState='N' ";
			Query queryObject = getSession().createQuery(queryString);
			super.setPage(queryObject, page);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 篮球场名称查询
	 * @param areanTitle
	 * @return
	 */
	public List findCheckByAreanTitle(String areanTitle) {
		try {
			String queryString = "from TbArean model where model.isValid='Y' and model.deleteState='N' and model.areanTitle like ? ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, "%" + areanTitle + "%");
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		try {
			String queryString = "from TbArean ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void save(TbArean transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbArean persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbArean findById(java.lang.Long id) {
		try {
			TbArean instance = (TbArean) getSession().get(
					"com.ulysses.base.pojo.TbArean", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbArean instance) {
		try {
			List results = getSession().createCriteria("com.ulysses.base.pojo.TbArean").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbArean as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAreanTitle(Object areanTitle) {
		return findByProperty(AREAN_TITLE, areanTitle);
	}

	public List findByAreanTitleImg(Object areanTitleImg) {
		return findByProperty(AREAN_TITLE_IMG, areanTitleImg);
	}

	public List findByAreanIntroduce(Object areanIntroduce) {
		return findByProperty(AREAN_INTRODUCE, areanIntroduce);
	}

	public List findByAreanLinkman(Object areanLinkman) {
		return findByProperty(AREAN_LINKMAN, areanLinkman);
	}

	public List findByAreanPhoneNumber(Object areanPhoneNumber) {
		return findByProperty(AREAN_PHONE_NUMBER, areanPhoneNumber);
	}

	public List findByAreanUrl(Object areanUrl) {
		return findByProperty(AREAN_URL, areanUrl);
	}

	public List findByAreanAddress(Object areanAddress) {
		return findByProperty(AREAN_ADDRESS, areanAddress);
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


	public TbArean merge(TbArean detachedInstance) {
		log.debug("merging TbArean instance");
		try {
			TbArean result = (TbArean) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbArean instance) {
		log.debug("attaching dirty TbArean instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbArean instance) {
		log.debug("attaching clean TbArean instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}