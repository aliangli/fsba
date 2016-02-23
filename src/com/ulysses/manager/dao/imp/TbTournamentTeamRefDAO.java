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
import com.ulysses.manager.dao.ITournamentTeamRefDAO;
import com.ulysses.manager.pojo.TbTournamentTeamRef;
import com.ulysses.manager.view.TournamentTeamRefView;
import com.ulysses.manager.view.TournamentView;
import com.ulysses.util.UtilParse;

/**
 * 参赛球队关系Dao
 */
@Repository
public class TbTournamentTeamRefDAO extends BaseHibernateDao implements ITournamentTeamRefDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbTournamentTeamRefDAO.class);
	

	/**
	 * 个人参与的赛事
	 */
	public List findByUser(Long userId, PageBean page) {
		try {
			String queryString = "select t from TbTournament t where t.tournamentId IN (select tr.tournamentId from TbTournamentTeamRef tr where tr.isValid='Y' and tr.deleteState='N' and tr.tournamentTeamId in (SELECT t.id FROM TbBallTeamRef tmr,TbBallTeam tm WHERE tmr.teamId=tm.id AND tmr.isValid='Y' AND tmr.deleteState='N' AND tmr.isDisband = 'N' AND tmr.ballPlayerId=? ) ) ";
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, userId);
			super.setPage(queryObject, page);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 球队参与的赛事
	 */
	public List findByUserTeam(String teamIdArr, PageBean page) {
		try {
			String queryString = "select t from TbTournament t where t.tournamentId IN (select tr.tournamentId from TbTournamentTeamRef tr where tr.isValid='Y' and tr.deleteState='N' and tr.tournamentTeamId in (:teamIdArr) ) ";
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameterList("teamIdArr", UtilParse.parseStrArr(teamIdArr.split(",")) );
			super.setPage(queryObject, page);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void save(TbTournamentTeamRef transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbTournamentTeamRef persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTournamentTeamRef findById(java.lang.Long id) {
		try {
			TbTournamentTeamRef instance = (TbTournamentTeamRef) getSession()
					.get("com.ulysses.manager.pojo.TbTournamentTeamRef", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTournamentTeamRef instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.manager.pojo.TbTournamentTeamRef").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbTournamentTeamRef as model where model."
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

	public List findByTournamentTeamId(Object tournamentTeamId) {
		return findByProperty(TOURNAMENT_TEAM_ID, tournamentTeamId);
	}

	public List findByTournamentLinkman(Object tournamentLinkman) {
		return findByProperty(TOURNAMENT_LINKMAN, tournamentLinkman);
	}

	public List findByLinkmanPhoneNumber(Object linkmanPhoneNumber) {
		return findByProperty(LINKMAN_PHONE_NUMBER, linkmanPhoneNumber);
	}

	public List findByLinkmanQqNumber(Object linkmanQqNumber) {
		return findByProperty(LINKMAN_QQ_NUMBER, linkmanQqNumber);
	}

	public List findByLinkmanWeixNumber(Object linkmanWeixNumber) {
		return findByProperty(LINKMAN_WEIX_NUMBER, linkmanWeixNumber);
	}

	public List findByLinkmanWeibNumber(Object linkmanWeibNumber) {
		return findByProperty(LINKMAN_WEIB_NUMBER, linkmanWeibNumber);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByEnrollState(Object enrollState) {
		return findByProperty(ENROLL_STATE, enrollState);
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

	public List findByP4(Object p4) {
		return findByProperty(P4, p4);
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
	
	public List findAllCheck(TournamentTeamRefView view, PageBean page) {
		try {
			String queryString = "select new com.ulysses.manager.dao.db.DBTntTeamRef(r.tmRefId, r.tournamentId, r.tournamentTeamId, t.teamName, t.teamPhotoPath) from TbTournamentTeamRef r , TbBallTeam t where r.tournamentTeamId=t.id and r.isValid='Y' and r.deleteState='N' and r.tournamentId=? ";
			Query queryObject = getSession().createQuery(queryString);
			super.setPage(queryObject, page);
			queryObject.setParameter(0, view.getTournamentId());
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findAll() {
		try {
			String queryString = "from TbTournamentTeamRef";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTournamentTeamRef merge(TbTournamentTeamRef detachedInstance) {
		try {
			TbTournamentTeamRef result = (TbTournamentTeamRef) getSession()
					.merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTournamentTeamRef instance) {
		log.debug("attaching dirty TbTournamentTeamRef instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTournamentTeamRef instance) {
		log.debug("attaching clean TbTournamentTeamRef instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}