package com.ulysses.manager.dao.imp;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.manager.dao.IManagerUserDAO;
import com.ulysses.manager.pojo.TbManagerUser;

/**
 * 管理员用户Dao
 */
@Repository
public class TbManagerUserDAO extends BaseHibernateDao implements IManagerUserDAO {
	private static final Logger log = LoggerFactory.getLogger(TbManagerUserDAO.class);
	

	public List findAllCheck() {
		try {
			String queryString = "from TbManagerUser model where model.isValid='Y' and model.deleteState='N' ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void save(TbManagerUser transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbManagerUser persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbManagerUser findById(java.lang.Long id) {
		try {
			TbManagerUser instance = (TbManagerUser) getSession().get(
					"com.ulysses.manager.pojo.TbManagerUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbManagerUser instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.manager.pojo.TbManagerUser").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbManagerUser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByChineseName(Object chineseName) {
		return findByProperty(CHINESE_NAME, chineseName);
	}

	public List findByEnglishName(Object englishName) {
		return findByProperty(ENGLISH_NAME, englishName);
	}

	public List findByAliasName(Object aliasName) {
		return findByProperty(ALIAS_NAME, aliasName);
	}

	public List findByUserSex(Object userSex) {
		return findByProperty(USER_SEX, userSex);
	}

	public List findByNationality(Object nationality) {
		return findByProperty(NATIONALITY, nationality);
	}

	public List findByBirthpace(Object birthpace) {
		return findByProperty(BIRTHPACE, birthpace);
	}

	public List findByGraduateSchool(Object graduateSchool) {
		return findByProperty(GRADUATE_SCHOOL, graduateSchool);
	}

	public List findByStature(Object stature) {
		return findByProperty(STATURE, stature);
	}

	public List findByWeight(Object weight) {
		return findByProperty(WEIGHT, weight);
	}

	public List findByUserPassword(Object userPassword) {
		return findByProperty(USER_PASSWORD, userPassword);
	}

	public List findByUserPhoneNumber(Object userPhoneNumber) {
		return findByProperty(USER_PHONE_NUMBER, userPhoneNumber);
	}

	public List findByUserIdentityCard(Object userIdentityCard) {
		return findByProperty(USER_IDENTITY_CARD, userIdentityCard);
	}

	public List findByUserIdentityCardImg(Object userIdentityCardImg) {
		return findByProperty(USER_IDENTITY_CARD_IMG, userIdentityCardImg);
	}

	public List findByUserIcPhoto(Object userIcPhoto) {
		return findByProperty(USER_IC_PHOTO, userIcPhoto);
	}

	public List findByUserEmail(Object userEmail) {
		return findByProperty(USER_EMAIL, userEmail);
	}

	public List findByUserPhotoPath(Object userPhotoPath) {
		return findByProperty(USER_PHOTO_PATH, userPhotoPath);
	}

	public List findByUserAddress(Object userAddress) {
		return findByProperty(USER_ADDRESS, userAddress);
	}

	public List findByUserCity(Object userCity) {
		return findByProperty(USER_CITY, userCity);
	}

	public List findByDeptId(Object deptId) {
		return findByProperty(DEPT_ID, deptId);
	}

	public List findByPostId(Object postId) {
		return findByProperty(POST_ID, postId);
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
			String queryString = "from TbManagerUser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbManagerUser merge(TbManagerUser detachedInstance) {
		log.debug("merging TbManagerUser instance");
		try {
			TbManagerUser result = (TbManagerUser) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbManagerUser instance) {
		log.debug("attaching dirty TbManagerUser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbManagerUser instance) {
		log.debug("attaching clean TbManagerUser instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}