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

import com.ulysses.base.dao.IBallTeamInviteDAO;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbBallTeamInvite;

/**
 * 邀请信息DAO
 * 
 * 球队发出信息邀请球员
 */
@Repository
public class TbBallTeamInviteDAO extends BaseHibernateDao implements IBallTeamInviteDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbBallTeamInviteDAO.class);
	
	/**
	 * 根据用户查已经收到的邀请
	 */
	public List inviteByUser(TbBallTeamInvite invite) {
		try {
			String queryString = "from TbBallTeamInvite as model where model.deleteState='N' and model.agreeState='N' and model.isValid='Y' and model.isDisband='N' and model.inviteTeamId = ? and model.inviteUserId = ?  ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, invite.getInviteTeamId());
			queryObject.setParameter(1, invite.getInviteUserId());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find inviteByUser failed", re);
			throw re;
		}
	}
	
	/**
	 * 个人收到的所有邀请
	 */
	public List myAllInvite(TbBallTeamInvite invite){
		
		Criterion criUserID = Restrictions.eq(INVITE_USER_ID, invite.getInviteUserId()); //被邀请的用户ID
		
		Criterion criDeleteState = Restrictions.eq(DELETE_STATE, invite.getDeleteState());//删除状态
		Criterion criAgreeState = Restrictions.eq(AGREE_STATE, invite.getAgreeState());//同意状态
		Criterion criDisband = Restrictions.eq(IS_DISBAND, invite.getIsDisband());//解散状态
		Criterion criValid = Restrictions.eq(IS_VALID, invite.getIsValid());//有效状态
		
		
		LogicalExpression logical = Restrictions.and(criDisband, Restrictions.and(criUserID, 
				Restrictions.and(criDeleteState, 
						Restrictions.and(criAgreeState, criValid))));
		
		return this.criteria(logical);
	}

	/**
	 * 一个球队发出的所有邀请
	 */
	public List allInvite(TbBallTeamInvite invite){
		
		Criterion criTeamID = Restrictions.eq(INVITE_TEAM_ID, invite.getInviteTeamId());
		//Criterion criAgreeState = Restrictions.eq(AGREE_STATE, invite.getAgreeState());//同意状态
		Criterion criDisband = Restrictions.eq(IS_DISBAND, invite.getIsDisband());//解散状态
		
		Criterion criDeleteState = Restrictions.eq(DELETE_STATE, invite.getDeleteState());//删除状态
		Criterion criValid = Restrictions.eq(IS_VALID, invite.getIsValid());//有效状态
		
		LogicalExpression logical = Restrictions.and(criTeamID, Restrictions.and(criDisband, 
				Restrictions.and(criValid, criDeleteState ) ) );
		return this.criteria(logical);
	}
	
	
	
	/**
	 * 查询方法， 传入参数
	 * @param logical
	 * @return
	 */
	private List criteria(LogicalExpression logical){
		try {
			List results = getSession().createCriteria("com.ulysses.base.pojo.TbBallTeamInvite").add(logical ).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public void save(TbBallTeamInvite transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbBallTeamInvite transientInstance) {
		try {
			getSession().update(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#delete(com.ulysses.base.pojo.TbBallTeamInvite)
	 */
	public void delete(TbBallTeamInvite persistentInstance) {
		try {
			getSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findById(java.lang.Long)
	 */
	public TbBallTeamInvite findById(java.lang.Long id) {
		try {
			TbBallTeamInvite instance = (TbBallTeamInvite) getSession().get(
					"com.ulysses.base.pojo.TbBallTeamInvite", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByExample(com.ulysses.base.pojo.TbBallTeamInvite)
	 */
	public List findByExample(TbBallTeamInvite instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.base.pojo.TbBallTeamInvite").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbBallTeamInvite as model where model."
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
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByInviteFromUserId(java.lang.Object)
	 */
	public List findByInviteFromUserId(Object inviteFromUserId) {
		return findByProperty(INVITE_FROM_USER_ID, inviteFromUserId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByInviteUserId(java.lang.Object)
	 */
	public List findByInviteUserId(Object inviteUserId) {
		return findByProperty(INVITE_USER_ID, inviteUserId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByInviteTeamId(java.lang.Object)
	 */
	public List findByInviteTeamId(Object inviteTeamId) {
		return findByProperty(INVITE_TEAM_ID, inviteTeamId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByInviteTeamName(java.lang.Object)
	 */
	public List findByInviteTeamName(Object inviteTeamName) {
		return findByProperty(INVITE_TEAM_NAME, inviteTeamName);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByInvitePlace(java.lang.Object)
	 */
	public List findByInvitePlace(Object invitePlace) {
		return findByProperty(INVITE_PLACE, invitePlace);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByInviteIp(java.lang.Object)
	 */
	public List findByInviteIp(Object inviteIp) {
		return findByProperty(INVITE_IP, inviteIp);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByIsOfficialTeam(java.lang.Object)
	 */
	public List findByIsOfficialTeam(Object isOfficialTeam) {
		return findByProperty(IS_OFFICIAL_TEAM, isOfficialTeam);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByApproveState(java.lang.Object)
	 */
	public List findByApproveState(Object approveState) {
		return findByProperty(APPROVE_STATE, approveState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByIsDisband(java.lang.Object)
	 */
	public List findByIsDisband(Object isDisband) {
		return findByProperty(IS_DISBAND, isDisband);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByCreateUserId(java.lang.Object)
	 */
	public List findByCreateUserId(Object createUserId) {
		return findByProperty(CREATE_USER_ID, createUserId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByUpdateUserId(java.lang.Object)
	 */
	public List findByUpdateUserId(Object updateUserId) {
		return findByProperty(UPDATE_USER_ID, updateUserId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByOrderBy(java.lang.Object)
	 */
	public List findByOrderBy(Object orderBy) {
		return findByProperty(ORDER_BY, orderBy);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByDeleteState(java.lang.Object)
	 */
	public List findByDeleteState(Object deleteState) {
		return findByProperty(DELETE_STATE, deleteState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByIsValid(java.lang.Object)
	 */
	public List findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findByVersion(java.lang.Object)
	 */
	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#findAll()
	 */
	public List findAll() {
		try {
			String queryString = "from TbBallTeamInvite";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#merge(com.ulysses.base.pojo.TbBallTeamInvite)
	 */
	public TbBallTeamInvite merge(TbBallTeamInvite detachedInstance) {
		try {
			TbBallTeamInvite result = (TbBallTeamInvite) getSession().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#attachDirty(com.ulysses.base.pojo.TbBallTeamInvite)
	 */
	public void attachDirty(TbBallTeamInvite instance) {
		try {
			getSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.pojo.IBallTeamInviteDAO#attachClean(com.ulysses.base.pojo.TbBallTeamInvite)
	 */
	public void attachClean(TbBallTeamInvite instance) {
		try {
			getSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}