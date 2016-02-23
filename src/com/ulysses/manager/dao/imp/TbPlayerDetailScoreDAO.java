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
import com.ulysses.manager.dao.IPlayerDetailScoreDAO;
import com.ulysses.manager.pojo.TbPlayerDetailScore;
import com.ulysses.manager.view.PlayerDetailScoreView;

/**
 * 球员得分详情
 */
@Repository
public class TbPlayerDetailScoreDAO extends BaseHibernateDao implements IPlayerDetailScoreDAO {
	private static final Logger log = LoggerFactory.getLogger(TbPlayerDetailScoreDAO.class);
	

	public List findAllCheck(PlayerDetailScoreView view) {
		try {
			String queryString = "from TbPlayerDetailScore model where model.isValid='Y' and model.deleteState='N' and model.tntProcessId=? ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, view.getTntProcessId());
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void save(TbPlayerDetailScore transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbPlayerDetailScore persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbPlayerDetailScore findById(java.lang.Long id) {
		try {
			TbPlayerDetailScore instance = (TbPlayerDetailScore) getSession()
					.get("com.ulysses.manager.pojo.TbPlayerDetailScore", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbPlayerDetailScore instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.manager.pojo.TbPlayerDetailScore").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbPlayerDetailScore as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPlayerId(Object playerId) {
		return findByProperty(PLAYER_ID, playerId);
	}

	public List findByPlayerName(Object playerName) {
		return findByProperty(PLAYER_NAME, playerName);
	}

	public List findByPlayerPosition(Object playerPosition) {
		return findByProperty(PLAYER_POSITION, playerPosition);
	}

	public List findByTournamentId(Object tournamentId) {
		return findByProperty(TOURNAMENT_ID, tournamentId);
	}

	public List findByPlayerTeamId(Object playerTeamId) {
		return findByProperty(PLAYER_TEAM_ID, playerTeamId);
	}

	public List findBySkillEnterTime(Object skillEnterTime) {
		return findByProperty(SKILL_ENTER_TIME, skillEnterTime);
	}

	public List findBySkillBackboard(Object skillBackboard) {
		return findByProperty(SKILL_BACKBOARD, skillBackboard);
	}

	public List findBySkillAssist(Object skillAssist) {
		return findByProperty(SKILL_ASSIST, skillAssist);
	}

	public List findBySkillFoul(Object skillFoul) {
		return findByProperty(SKILL_FOUL, skillFoul);
	}

	public List findBySkillSteal(Object skillSteal) {
		return findByProperty(SKILL_STEAL, skillSteal);
	}

	public List findBySkillFault(Object skillFault) {
		return findByProperty(SKILL_FAULT, skillFault);
	}

	public List findBySkillBlocking(Object skillBlocking) {
		return findByProperty(SKILL_BLOCKING, skillBlocking);
	}

	public List findBySkillScore(Object skillScore) {
		return findByProperty(SKILL_SCORE, skillScore);
	}

	public List findByRatioShooting(Object ratioShooting) {
		return findByProperty(RATIO_SHOOTING, ratioShooting);
	}

	public List findByRatioThird(Object ratioThird) {
		return findByProperty(RATIO_THIRD, ratioThird);
	}

	public List findByRatioPenalty(Object ratioPenalty) {
		return findByProperty(RATIO_PENALTY, ratioPenalty);
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
			String queryString = "from TbPlayerDetailScore";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbPlayerDetailScore merge(TbPlayerDetailScore detachedInstance) {
		try {
			TbPlayerDetailScore result = (TbPlayerDetailScore) getSession()
					.merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbPlayerDetailScore instance) {
		try {
			getSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbPlayerDetailScore instance) {
		try {
			getSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}