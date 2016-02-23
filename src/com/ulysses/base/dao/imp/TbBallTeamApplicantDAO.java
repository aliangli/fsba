package com.ulysses.base.dao.imp;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.dao.IBallTeamApplicantDAO;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.pojo.TbBallTeamApplicant;

/**
 * 申请信息Dao 
 * 
 * 球员申请加入球队
 */
@Repository
public class TbBallTeamApplicantDAO extends BaseHibernateDao implements IBallTeamApplicantDAO {
	
	private static final Logger log = LoggerFactory.getLogger(TbBallTeamApplicantDAO.class);
	

	/**
	 * 一个球队 所有的申请记录
	 * @param view
	 * @return
	 */
	public List applicantByTeam(TbBallTeamApplicant applicant) {
		try {
			Criterion criTeamID = Restrictions.eq(APPLICANT_TEAM_ID, applicant.getApplicantTeamId());
			Criterion criAgreeState = Restrictions.eq(AGREE_STATE, applicant.getAgreeState());//同意状态
			Criterion criDisband = Restrictions.eq(IS_DISBAND, applicant.getIsDisband());//解散状态
			
			LogicalExpression logical = Restrictions.and(criTeamID, Restrictions.and(criDisband, criAgreeState));
			
			List results = getSession().createCriteria("com.ulysses.base.pojo.TbBallTeamApplicant").add(logical ).list();
			
			return results;
		} catch (RuntimeException re) {
			log.error("find applicantByTeam failed", re);
			throw re;
		}
	}
	
	/**
	 * 设置球队所有申请信息的解散状态
	 */
	public void editTeamDisband(TbBallTeamApplicant applicant) {
		try {
			String hql = "update TbBallTeamApplicant ap set ap.isDisband = ? where ap.applicantTeamId = ? ";
			
			
			Query queryObject = getSession().createQuery(hql).setString(0, applicant.getIsDisband()).setLong(1, applicant.getApplicantTeamId());
			int count = queryObject.executeUpdate();
			log.debug(" editTeamDisband size :" + count);
		} catch (RuntimeException re) {
			log.error("editTeamDisband failed", re);
			throw re;
		}
		
	}
	
	/**
	 * 根据申请的用户ID 来查询球队收到的申请记录
	 * 未同意状态的申请记录
	 */
	public List findTeamApplicant(TbBallTeamApplicant applicant) {
		try {
			Criterion criTeamID = Restrictions.eq(APPLICANT_TEAM_ID, applicant.getApplicantTeamId());
			Criterion criAgreeState = Restrictions.eq(AGREE_STATE, applicant.getAgreeState());//同意状态
			Criterion criFromUserID = Restrictions.eq(APPLICANT_FROM_USER_ID, applicant.getApplicantFromUserId());
			Criterion criDisband = Restrictions.eq(IS_DISBAND, applicant.getIsDisband());//解散状态
			
			
			LogicalExpression logical = Restrictions.and(criTeamID, Restrictions.and(criFromUserID, Restrictions.and(criDisband, criAgreeState)));
			
			List results = getSession().createCriteria("com.ulysses.base.pojo.TbBallTeamApplicant").add(logical ).list();
			
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public void save(TbBallTeamApplicant transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbBallTeamApplicant transientInstance) {
		try {
			getSession().update(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findById(java.lang.Long)
	 */
	public TbBallTeamApplicant findById(java.lang.Long id) {
		log.debug("getting TbBallTeamApplicant instance with id: " + id);
		try {
			TbBallTeamApplicant instance = (TbBallTeamApplicant) getSession()
					.get("com.ulysses.base.pojo.TbBallTeamApplicant", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByExample(com.ulysses.base.pojo.TbBallTeamApplicant)
	 */
	public List findByExample(TbBallTeamApplicant instance) {
		log.debug("finding TbBallTeamApplicant instance by example");
		try {
			List results = getSession().createCriteria(
					"com.ulysses.base.pojo.TbBallTeamApplicant").add(
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
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbBallTeamApplicant as model where model."
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
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByApplicantFromUserId(java.lang.Object)
	 */
	public List findByApplicantFromUserId(Object applicantFromUserId) {
		return findByProperty(APPLICANT_FROM_USER_ID, applicantFromUserId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByApplicantTeamId(java.lang.Object)
	 */
	public List findByApplicantTeamId(Object applicantTeamId) {
		return findByProperty(APPLICANT_TEAM_ID, applicantTeamId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByApplicantTeamName(java.lang.Object)
	 */
	public List findByApplicantTeamName(Object applicantTeamName) {
		return findByProperty(APPLICANT_TEAM_NAME, applicantTeamName);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByApplicantPlace(java.lang.Object)
	 */
	public List findByApplicantPlace(Object applicantPlace) {
		return findByProperty(APPLICANT_PLACE, applicantPlace);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByApplicantIp(java.lang.Object)
	 */
	public List findByApplicantIp(Object applicantIp) {
		return findByProperty(APPLICANT_IP, applicantIp);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByIsOfficialTeam(java.lang.Object)
	 */
	public List findByIsOfficialTeam(Object isOfficialTeam) {
		return findByProperty(IS_OFFICIAL_TEAM, isOfficialTeam);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByApproveState(java.lang.Object)
	 */
	public List findByApproveState(Object approveState) {
		return findByProperty(APPROVE_STATE, approveState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByIsDisband(java.lang.Object)
	 */
	public List findByIsDisband(Object isDisband) {
		return findByProperty(IS_DISBAND, isDisband);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByCreateUserId(java.lang.Object)
	 */
	public List findByCreateUserId(Object createUserId) {
		return findByProperty(CREATE_USER_ID, createUserId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByUpdateUserId(java.lang.Object)
	 */
	public List findByUpdateUserId(Object updateUserId) {
		return findByProperty(UPDATE_USER_ID, updateUserId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByOrderBy(java.lang.Object)
	 */
	public List findByOrderBy(Object orderBy) {
		return findByProperty(ORDER_BY, orderBy);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByDeleteState(java.lang.Object)
	 */
	public List findByDeleteState(Object deleteState) {
		return findByProperty(DELETE_STATE, deleteState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByIsValid(java.lang.Object)
	 */
	public List findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findByVersion(java.lang.Object)
	 */
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#findAll()
	 */
	public List findAll() {
		try {
			String queryString = "from TbBallTeamApplicant";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#merge(com.ulysses.base.pojo.TbBallTeamApplicant)
	 */
	public TbBallTeamApplicant merge(TbBallTeamApplicant detachedInstance) {
		log.debug("merging TbBallTeamApplicant instance");
		try {
			TbBallTeamApplicant result = (TbBallTeamApplicant) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#attachDirty(com.ulysses.base.pojo.TbBallTeamApplicant)
	 */
	public void attachDirty(TbBallTeamApplicant instance) {
		log.debug("attaching dirty TbBallTeamApplicant instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamApplicantDAO#attachClean(com.ulysses.base.pojo.TbBallTeamApplicant)
	 */
	public void attachClean(TbBallTeamApplicant instance) {
		log.debug("attaching clean TbBallTeamApplicant instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}