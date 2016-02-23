package com.ulysses.base.dao.imp;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.dao.IBallTeamRefDAO;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbBallTeamRef;
import com.ulysses.base.services.common.ICommonConstant;

/**
 * 球队与球员关系Dao
 */
@Repository
public class TbBallTeamRefDAO extends BaseHibernateDao implements IBallTeamRefDAO, ICommonConstant {
	
	private static final Logger log = LoggerFactory.getLogger(TbBallTeamRefDAO.class);

	/**
	 * By TeanID and playerID
	 */
	public List findTeamRef(TbBallTeamRef teamRef) {
		try {
			String queryString = "from TbBallTeamRef as model where model.isValid='Y' and model.deleteState='N' and model.isDisband = 'N' and model.teamId=? and  model.ballPlayerId=? ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, teamRef.getTeamId());
			queryObject.setParameter(1, teamRef.getBallPlayerId() );
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbBallTeamRef failed", re);
			throw re;
		}
	}
	
	/**
	 * 获取用户创建和参与的所有球队
	 */
	public List findTeamByUser(Long playerId) {
		try {
			String queryString = "select t from TbBallTeamRef tr,TbBallTeam t where tr.teamId=t.id and tr.isValid='Y' and tr.deleteState='N' and tr.isDisband = 'N' and tr.ballPlayerId=? ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, playerId);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbBallTeamRef failed", re);
			throw re;
		}
	}
	
	/**
	 * 设置队员关系的删除状态
	 */
	public void editTeamRefDelete(TbBallTeamRef teamRef) {
		
		try {
			String queryString = "update TbBallTeamRef tm set deleteState = ? where id = ? ";
			Query queryObject = getSession().createQuery(queryString).setString(0, teamRef.getDeleteState()).setLong(1, teamRef.getId());
			
			int count = queryObject.executeUpdate();
		} catch (RuntimeException re) {
			log.error("editTeamRefDelete failed", re);
			throw re;
		}
		
	}

	/**
	 * 设置队员关系的解散状态
	 */
	public void editTeamRefDisband(TbBallTeamRef teamRef) {

		try {
			String queryString = "update TbBallTeamRef tm set tm.isDisband = ? where tm.teamId = ? ";
			Query queryObject = getSession().createQuery(queryString).setString(0, teamRef.getIsDisband()).setLong(1, teamRef.getTeamId());
			
			int count = queryObject.executeUpdate();
		} catch (RuntimeException re) {
			log.error("editTeamRefDisband failed", re);
			throw re;
		}
	
	}

	public List findByTeamRef(TbBallTeamRef instance) {
		try {
			
			Criterion criterion = Restrictions.and(Restrictions.eq(TEAM_ID, instance.getTeamId()), Restrictions.eq(BALL_PLAYER_ID, instance.getBallPlayerId()));
			
			List results = getSession().createCriteria("com.ulysses.base.pojo.TbBallTeamRef").add(criterion).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public void save(TbBallTeamRef transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public TbBallTeamRef findById(java.lang.Long id) {
		try {
			TbBallTeamRef instance = (TbBallTeamRef) getSession().get(
					"com.ulysses.base.pojo.TbBallTeamRef", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbBallTeamRef instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.base.pojo.TbBallTeamRef").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByExampleCheck(TbBallTeamRef instance) {
		try {
			
			Criterion notRes = Restrictions.eq(IS_DETACH, STATE_N );
			
			List results = getSession().createCriteria("com.ulysses.base.pojo.TbBallTeamRef").add(notRes).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbBallTeamRef as model where model."
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
	 * @see com.ulysses.base.dao.imp.IBallTeamRefDAO#findByTeamId(java.lang.Object)
	 */
	public List findByTeamId(Object teamId) {
		return findByProperty(TEAM_ID, teamId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamRefDAO#findByBallPlayerId(java.lang.Object)
	 */
	public List findByBallPlayerId(Object ballPlayerId) {
		return findByProperty(BALL_PLAYER_ID, ballPlayerId);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByOrderBy(Object orderBy) {
		return findByProperty(ORDER_BY, orderBy);
	}

	public List findByDeleteState(Object deleteState) {
		return findByProperty(DELETE_STATE, deleteState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamRefDAO#findByIsValid(java.lang.Object)
	 */
	public List findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findAll() {
		try {
			String queryString = "from TbBallTeamRef";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamRefDAO#merge(com.ulysses.base.pojo.TbBallTeamRef)
	 */
	public TbBallTeamRef merge(TbBallTeamRef detachedInstance) {
		try {
			TbBallTeamRef result = (TbBallTeamRef) getSession().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbBallTeamRef instance) {
		try {
			getSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void update(TbBallTeamRef instance) {
		try {
			getSession().update(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbBallTeamRef instance) {
		try {
			getSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


}