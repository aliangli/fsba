package com.ulysses.manager.dao.imp;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.manager.dao.ITntApplicantDAO;
import com.ulysses.manager.pojo.TbTntApplicant;

/**
 * 球队申请参赛
 */
@Repository
public class TbTntApplicantDAO extends BaseHibernateDao implements ITntApplicantDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbTntApplicantDAO.class);
	
	public void save(TbTntApplicant transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbTntApplicant persistentInstance) {
		try {
			getSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(TbTntApplicant persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTntApplicant findById(java.lang.Long id) {
		try {
			TbTntApplicant instance = (TbTntApplicant) getSession().get(
					"com.ulysses.manager.pojo.TbTntApplicant", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTntApplicant instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.manager.pojo.TbTntApplicant").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbTntApplicant as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFromUserId(Object fromUserId) {
		return findByProperty(FROM_USER_ID, fromUserId);
	}

	public List findByFromUserAliasName(Object fromUserAliasName) {
		return findByProperty(FROM_USER_ALIAS_NAME, fromUserAliasName);
	}

	public List findByAltTeamId(Object altTeamId) {
		return findByProperty(ALT_TEAM_ID, altTeamId);
	}

	public List findByAltTeamName(Object altTeamName) {
		return findByProperty(ALT_TEAM_NAME, altTeamName);
	}

	public List findByApplicantPlace(Object applicantPlace) {
		return findByProperty(APPLICANT_PLACE, applicantPlace);
	}

	public List findByApplicantIp(Object applicantIp) {
		return findByProperty(APPLICANT_IP, applicantIp);
	}

	public List findByIsOfficialTeam(Object isOfficialTeam) {
		return findByProperty(IS_OFFICIAL_TEAM, isOfficialTeam);
	}

	public List findByAgreeState(Object agreeState) {
		return findByProperty(AGREE_STATE, agreeState);
	}

	public List findByApproveState(Object approveState) {
		return findByProperty(APPROVE_STATE, approveState);
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
			String queryString = "from TbTntApplicant";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTntApplicant merge(TbTntApplicant detachedInstance) {
		try {
			TbTntApplicant result = (TbTntApplicant) getSession().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTntApplicant instance) {
		try {
			getSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTntApplicant instance) {
		try {
			getSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}