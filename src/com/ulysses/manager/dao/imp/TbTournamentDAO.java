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
import com.ulysses.manager.dao.ITournamentDAO;
import com.ulysses.manager.pojo.TbTournament;
import com.ulysses.manager.support.Param;
import com.ulysses.manager.view.TournamentView;

/**
 * 比赛Dao
 */
@Repository
public class TbTournamentDAO extends BaseHibernateDao implements ITournamentDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TbTournamentDAO.class);
	

	public List findAllCheck(PageBean page) {
		try {
			String queryString = "from TbTournament model where model.isValid='Y' and model.deleteState='N' ";
			Query queryObject = getSession().createQuery(queryString);
			
			super.setPage(queryObject, page);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	public void save(TbTournament transientInstance) {
		try {
			getSession().save(transientInstance);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(TbTournament persistentInstance) {
		try {
			getSession().update(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTournament findById(java.lang.Long id) {
		try {
			TbTournament instance = (TbTournament) getSession().get(
					"com.ulysses.manager.pojo.TbTournament", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTournament instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.manager.pojo.TbTournament").add(
					Example.create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbTournament as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTournamentCode(Object tournamentCode) {
		return findByProperty(TOURNAMENT_CODE, tournamentCode);
	}

	public List findByTournamentName(Object tournamentName) {
		return findByProperty(TOURNAMENT_NAME, tournamentName);
	}

	public List findByTournamentChineseName(Object tournamentChineseName) {
		return findByProperty(TOURNAMENT_CHINESE_NAME, tournamentChineseName);
	}

	public List findByTournamentEnglishName(Object tournamentEnglishName) {
		return findByProperty(TOURNAMENT_ENGLISH_NAME, tournamentEnglishName);
	}

	public List findByTournamentAliasName(Object tournamentAliasName) {
		return findByProperty(TOURNAMENT_ALIAS_NAME, tournamentAliasName);
	}

	public List findByTournamentMajorSponsor(Object tournamentMajorSponsor) {
		return findByProperty(TOURNAMENT_MAJOR_SPONSOR, tournamentMajorSponsor);
	}

	public List findByTournamentSponsor(Object tournamentSponsor) {
		return findByProperty(TOURNAMENT_SPONSOR, tournamentSponsor);
	}

	public List findByTournamentPace(Object tournamentPace) {
		return findByProperty(TOURNAMENT_PACE, tournamentPace);
	}

	public List findByTournamentCity(Object tournamentCity) {
		return findByProperty(TOURNAMENT_CITY, tournamentCity);
	}

	public List findByTournamentPhoneNumber(Object tournamentPhoneNumber) {
		return findByProperty(TOURNAMENT_PHONE_NUMBER, tournamentPhoneNumber);
	}

	public List findByTournamentQqNumber(Object tournamentQqNumber) {
		return findByProperty(TOURNAMENT_QQ_NUMBER, tournamentQqNumber);
	}

	public List findByTournamentWeixNumber(Object tournamentWeixNumber) {
		return findByProperty(TOURNAMENT_WEIX_NUMBER, tournamentWeixNumber);
	}

	public List findByTournamentWeibNumber(Object tournamentWeibNumber) {
		return findByProperty(TOURNAMENT_WEIB_NUMBER, tournamentWeibNumber);
	}

	public List findByTournamentPhotoPath(Object tournamentPhotoPath) {
		return findByProperty(TOURNAMENT_PHOTO_PATH, tournamentPhotoPath);
	}

	public List findByTournamentRemark(Object tournamentRemark) {
		return findByProperty(TOURNAMENT_REMARK, tournamentRemark);
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

	public List findByTournamentState(Object tournamentState) {
		return findByProperty(TOURNAMENT_STATE, tournamentState);
	}

	public List findByEnrollValid(Object enrollValid) {
		return findByProperty(ENROLL_VALID, enrollValid);
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
			String queryString = "from TbTournament";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTournament merge(TbTournament detachedInstance) {
		try {
			TbTournament result = (TbTournament) getSession().merge(
					detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTournament instance) {
		try {
			getSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTournament instance) {
		try {
			getSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}