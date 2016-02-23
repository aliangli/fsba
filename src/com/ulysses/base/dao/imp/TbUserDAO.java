package com.ulysses.base.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.dao.IUserDao;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbUser;

/**
 * 用户Dao
 */

@Repository
public class TbUserDAO extends BaseHibernateDao implements IUserDao {
	private static final Logger log = LoggerFactory.getLogger(TbUserDAO.class);
	
	public void save(TbUser transientInstance) {
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbUser transientInstance) {
		try {
			getSession().update(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/**
	 * 不包含此用户名的集合数据
	 * @param user
	 * @return
	 */
	public List findNotContainUserName(TbUser user) {
		return findByPropertyNotContain(USER_NAME, user.getId(), user.getUserName());
	}

	/**
	 * 不包含此手机号的用户的集合数据
	 * @param user
	 * @return
	 */
	public List findNotContainUserPhoneNumber(TbUser user) {
		return findByPropertyNotContain(USER_PHONE_NUMBER, user.getId(), user.getUserPhoneNumber());
	}
	
	/**
	 * 不包含某个属性的集合
	 */
	public List findByPropertyNotContain(String propertyName, Long id, String value) {
		
		try {
			SimpleExpression eqExp = Restrictions.eq(propertyName, value );
			Criterion notRes = Restrictions.not(Restrictions.eq("id", id ));
			
			LogicalExpression exp = Restrictions.and(notRes, eqExp);
			
			Criteria criteria = getSession().createCriteria("com.ulysses.base.pojo.TbUser").add(exp );
			
			return criteria.list();
		} catch (RuntimeException re) {
			log.error("find by User failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findById(java.lang.Long)
	 */
	public TbUser findById(java.lang.Long id) {
		try {
			TbUser instance = (TbUser) getSession().get("com.ulysses.base.pojo.TbUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbUser instance) {
		try {
			List results = getSession().createCriteria("com.ulysses.base.pojo.TbUser").add(Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find User failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbUser as model where model.deleteState='N' and model.isValid='Y' and model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByPropertyNotMe(String propertyName, Object value, Long id) {
		try {
			String queryString = "from TbUser as model where model.deleteState='N' and model.isValid='Y' and model."
				+ propertyName + "= ? and model.id!=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			queryObject.setParameter(1, id);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByUserName(java.lang.Object)
	 */
	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}
	
	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByChineseName(java.lang.Object)
	 */
	public List findByChineseName(Object chineseName) {
		return findByProperty(CHINESE_NAME, chineseName);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByEnglishName(java.lang.Object)
	 */
	public List findByEnglishName(Object englishName) {
		return findByProperty(ENGLISH_NAME, englishName);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByAliasName(java.lang.Object)
	 */
	public List findByAliasName(Object aliasName) {
		return findByProperty(ALIAS_NAME, aliasName);
	}

	public List findByAliasNameNotMe(Object aliasName, Long id) {
		return findByPropertyNotMe(ALIAS_NAME, aliasName, id);
	}
	
	

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByNationality(java.lang.Object)
	 */
	public List findByNationality(Object nationality) {
		return findByProperty(NATIONALITY, nationality);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByBirthpace(java.lang.Object)
	 */
	public List findByBirthpace(Object birthpace) {
		return findByProperty(BIRTHPACE, birthpace);
	}

	public List findByGraduateSchool(Object graduateSchool) {
		return findByProperty(GRADUATE_SCHOOL, graduateSchool);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByStature(java.lang.Object)
	 */
	public List findByStature(Object stature) {
		return findByProperty(STATURE, stature);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByWeight(java.lang.Object)
	 */
	public List findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List findByUserPassword(Object userPassword) {
		return findByProperty(USER_PASSWORD, userPassword);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByUserPhoneNumber(java.lang.Object)
	 */
	public List findByUserPhoneNumber(Object userPhoneNumber) {
		return findByProperty(USER_PHONE_NUMBER, userPhoneNumber);
	}

	public List findByUserPhotoPath(Object userPhotoPath) {
		return findByProperty(USER_PHOTO_PATH, userPhotoPath);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByUserAddress(java.lang.Object)
	 */
	public List findByUserAddress(Object userAddress) {
		return findByProperty(USER_ADDRESS, userAddress);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByUserCity(java.lang.Object)
	 */
	public List findByUserCity(Object userCity) {
		return findByProperty(USER_CITY, userCity);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByOrderBy(java.lang.Object)
	 */
	public List findByOrderBy(Object orderBy) {
		return findByProperty(ORDER_BY, orderBy);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByDeleteState(java.lang.Object)
	 */
	public List findByDeleteState(Object deleteState) {
		return findByProperty(DELETE_STATE, deleteState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findByIsValid(java.lang.Object)
	 */
	public List findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#findAll()
	 */
	public List findAll() {
		try {
			String queryString = "from TbUser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IUserDao#merge(com.ulysses.base.pojo.TbUser)
	 */
	public TbUser merge(TbUser detachedInstance) {
		try {
			TbUser result = (TbUser) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbUser instance) {
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbUser instance) {
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	

    public int getCount() {
		try {
			String sql = "select COUNT(a.id) as count from TbUser a ";
			Query queryObject = getSession().createQuery(sql);
			Object obj = queryObject.list().get(0);
			return Integer.parseInt(obj.toString());
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
}