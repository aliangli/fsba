package com.ulysses.manager.dao.imp;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.manager.dao.ITournamentProcessDAO;
import com.ulysses.manager.pojo.TbTournamentProcess;
import com.ulysses.manager.view.TournamentProcessView;

/**
 * 赛程Dao
 */
@Repository
public class TbTournamentProcessDAO extends BaseHibernateDao implements ITournamentProcessDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbTournamentProcessDAO.class);
	

	public List findAllCheck(TournamentProcessView view, PageBean page) {
		try {
			String queryString = "from TbTournamentProcess p where p.isValid='Y' and p.deleteState='N' and p.tournamentId=? ";
			Query queryObject = getSession().createQuery(queryString);
			super.setPage(queryObject, page);
			queryObject.setParameter(0, view.getTournamentId());
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	public void save(TbTournamentProcess transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbTournamentProcess persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTournamentProcess findById(java.lang.Long id) {
		try {
			TbTournamentProcess instance = (TbTournamentProcess) getSession()
					.get("com.ulysses.manager.pojo.TbTournamentProcess", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTournamentProcess instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.manager.pojo.TbTournamentProcess").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbTournamentProcess as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTournamentId(Object tournamentId) {
		return findByProperty(TOURNAMENT_ID, tournamentId);
	}

	public List findByTournamentHostTeamId(Object tournamentHostTeamId) {
		return findByProperty(TOURNAMENT_HOST_TEAM_ID, tournamentHostTeamId);
	}

	public List findByTournamentGuestTeamId(Object tournamentGuestTeamId) {
		return findByProperty(TOURNAMENT_GUEST_TEAM_ID, tournamentGuestTeamId);
	}

	public List findByHostTeamScore(Object hostTeamScore) {
		return findByProperty(HOST_TEAM_SCORE, hostTeamScore);
	}

	public List findByGuestTeamScore(Object guestTeamScore) {
		return findByProperty(GUEST_TEAM_SCORE, guestTeamScore);
	}

	public List findByTournamentState(Object tournamentState) {
		return findByProperty(TOURNAMENT_STATE, tournamentState);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByP1(Object p1) {
		return findByProperty(P1, p1);
	}

	public List findByP2(Object p2) {
		return findByProperty(P2, p2);
	}

	public List findByP3(Object p3) {
		return findByProperty(P3, p3);
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
			String queryString = "from TbTournamentProcess ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTournamentProcess merge(TbTournamentProcess detachedInstance) {
		log.debug("merging TbTournamentProcess instance");
		try {
			TbTournamentProcess result = (TbTournamentProcess) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTournamentProcess instance) {
		log.debug("attaching dirty TbTournamentProcess instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTournamentProcess instance) {
		log.debug("attaching clean TbTournamentProcess instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}