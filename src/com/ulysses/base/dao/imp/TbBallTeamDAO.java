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

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.dao.IBallTeamDAO;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.view.UserView;

/**
 * 球队 Dao
 * 
 * @see com.ulysses.base.pojo.TbBallTeam
 * @author MyEclipse Persistence Tools
 */
@Repository
public class TbBallTeamDAO extends BaseHibernateDao implements IBallTeamDAO, ICommonConstant {
	
	private static final Logger log = LoggerFactory.getLogger(TbBallTeamDAO.class);
	

	
	/**
	 * 用户创建的球队收到的所有申请记录
	 * @param view
	 * @return
	 */
	public List applicantAllTeam(TbBallTeam team) {
		try {
			String queryString = "select new com.ulysses.base.dao.db.DBApplicant(ta.applicantId, ta.applicantFromUserId, ta.applicantFromAliasName, ta.applicantTeamId, ta.applicantTeamName, ta.version)  from TbBallTeam as t,TbBallTeamApplicant as ta where ta.deleteState='N' and ta.agreeState='N' and ta.isValid='Y' and ta.isDisband='N'  and t.id=ta.applicantTeamId and t.createUserId=? order by ta.createDate desc ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, team.getCreateUserId());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find applicantAllTeam failed", re);
			throw re;
		}
	}

	/**
	 * 创建的球队 By 用户
	 */
	public List findByTeamCreateUserId(UserView view, PageBean page) {
		try {
			String queryString = "from TbBallTeam as model where model.isValid='Y' and model.deleteState='N' and model.isDisband='N' and model.createUserId=? ";
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, view.getUserId());
			super.setPage(queryObject, page);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbBallTeam failed", re);
			throw re;
		}
	}
	
	/**
	 * 创建的球队 By 用户ID
	 */
	public List findByUserId(Long userId) {
		try {
			String queryString = "from TbBallTeam as model where model.isValid='Y' and model.deleteState='N' and model.isDisband='N' and model.createUserId=? ";
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, userId);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbBallTeam failed", re);
			throw re;
		}
	}


	/**
	 * 加入的球队 By 用户
	 */
	public List findByUserId(UserView view, PageBean page) {
		
		try {
			String queryString = "select t from TbBallTeam t , TbBallTeamRef tf  where t.isValid='Y' and t.deleteState='N' and t.isDisband = 'N' and tf.isDisband = 'N' and tf.deleteState = 'N' and t.id = tf.teamId and t.createUserId != ? and tf.ballPlayerId = ? ";
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, view.getUserId());
			queryObject.setParameter(1, view.getUserId());
			super.setPage(queryObject, page);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbBallTeam failed", re);
			throw re;
		}
	}
	
	

	/**
	 * By球队名查询
	 */
	public List findByTeamNameCheck(Object teamName) {
		return findByPropertyCheck(TEAM_NAME, teamName);
	}
	
	/**
	 * 数据有效查询
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List findByPropertyCheck(String propertyName, Object value) {
		try {
			String queryString = "from TbBallTeam as model where model.isDisband != 'Y' and model.deleteState != 'Y' and model.isValid != 'N' and model."
				+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find findByPropertyCheck failed", re);
			throw re;
		}
	}


	
	/**
	 *   球队ID 和 解散状态  来查询球队信息
	 */
	public List findTeamDisband(TbBallTeam team) {
		
		try {
			LogicalExpression express = Restrictions.and(Restrictions.eq("id", team.getId()), 
					 Restrictions.eq(IS_DISBAND, team.getIsDisband())
			);
			
			List results = getSession().createCriteria( "com.ulysses.base.pojo.TbBallTeam").add(express).list();
			
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/**
	 * 某用户创建的球队 By 用户ID and 球队ID
	 * @param userId
	 * @param teamId
	 * @return
	 */
	public List isMyTeam(TbBallTeam team) {
		try {
			String queryString = "from TbBallTeam t where t.isDisband='N' and t.isValid='Y' and t.deleteState='N' and t.createUserId=? and t.id=? ";
			Query queryObject = getSession().createQuery(queryString);
			
			queryObject.setParameter(0, team.getCreateUserId());
			queryObject.setParameter(1, team.getId());
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbBallTeam failed", re);
			throw re;
		}
	}

	
	/**
	 * 未包含球队名字的集合
	 * @param teamName
	 * @return
	 */
	public List findByTeamNotContain(TbBallTeam team) {
		return findByPropertyNotContain(TEAM_NAME, team.getId(), team.getTeamName());
	}
	
	public List findByTeamName(Object teamName) {
		return findByProperty(TEAM_NAME, teamName);
	}
	
	
	/**
	 * 根据球队名称 搜索球队
	
	public List findByTeamName(Object teamName) {
		
		
		log.debug("finding TbBallTeam instance by example");
		try {
			
			String queryString = "from TbBallTeam model ";
			
			if(UtilString.notEmpty(teamName)){
				queryString += " where model.teamName like ? or  model.teamChineseName like ? or model.teamEnglishName like ?  ";
			}
			

			Query queryObject = getSession().createQuery(queryString);
			
			if(UtilString.notEmpty(teamName)){
				queryObject.setParameter(0, "%" + teamName + "%");
				queryObject.setParameter(1, "%" + teamName + "%");
				queryObject.setParameter(2, "%" + teamName + "%"); 
			}
			
			
			List results = queryObject.list();
			
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	} */
	

	/**
	 * 搜索球队 By 球队名称 
	 */
	public List findByTeamNameLike(TbBallTeam team, PageBean page) {
		try {
			
			String queryString = "from TbBallTeam as model where model.isDisband='N' and model.isValid='Y' and model.deleteState='N' and model.teamName like ? ";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, "%" + team.getTeamName()+ "%");
			
			super.setPage(queryObject, page);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by findByTeamNameLike failed", re);
			throw re;
		}
	}


	/**
	 * 不包含某个属性的集合
	 */
	public List findByPropertyNotContain(String propertyName, Long teamId, String value) {
		try {
			SimpleExpression eqExp = Restrictions.like(propertyName, value );
			Criterion notRes = Restrictions.not(Restrictions.eq("id", teamId ));
			
			LogicalExpression exp = Restrictions.and(notRes, eqExp);
			
			Criteria criteria = getSession().createCriteria("com.ulysses.base.pojo.TbBallTeam").add(exp );
			
			return criteria.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#save(com.ulysses.base.pojo.TbBallTeam)
	 */
	public void save(TbBallTeam transientInstance) {
		log.debug("saving TbBallTeam instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#delete(com.ulysses.base.pojo.TbBallTeam)
	 */
	public void delete(TbBallTeam persistentInstance) {
		log.debug("deleting TbBallTeam instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#findById(java.lang.Long)
	 */
	public TbBallTeam findById(java.lang.Long id) {
		try {
			TbBallTeam instance = (TbBallTeam) getSession().get("com.ulysses.base.pojo.TbBallTeam", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#findByExample(com.ulysses.base.pojo.TbBallTeam)
	 */
	public List findByExample(TbBallTeam instance) {
		try {
			List results = getSession().createCriteria("com.ulysses.base.pojo.TbBallTeam").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByProperty(String propertyName, Object value) {
		try {
			String queryString = "from TbBallTeam as model where model."+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	


	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#findByTeamOccupant(java.lang.Object)
	 */
	public List findByTeamOccupant(Object teamOccupant) {
		return findByProperty(TEAM_OCCUPANT, teamOccupant);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#findByTeamCoach(java.lang.Object)
	 */
	public List findByTeamCoach(Object teamCoach) {
		return findByProperty(TEAM_COACH, teamCoach);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#findByTeamChineseName(java.lang.Object)
	 */
	public List findByTeamChineseName(Object teamChineseName) {
		return findByProperty(TEAM_CHINESE_NAME, teamChineseName);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#findByTeamEnglishName(java.lang.Object)
	 */
	public List findByTeamEnglishName(Object teamEnglishName) {
		return findByProperty(TEAM_ENGLISH_NAME, teamEnglishName);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#findByTeamNationality(java.lang.Object)
	 */
	public List findByTeamNationality(Object teamNationality) {
		return findByProperty(TEAM_NATIONALITY, teamNationality);
	}

	public List findByTeamCity(Object teamCity) {
		return findByProperty(TEAM_CITY, teamCity);
	}

	public List findByTeamPopulation(Object teamPopulation) {
		return findByProperty(TEAM_POPULATION, teamPopulation);
	}

	public List findByChampionNumber(Object championNumber) {
		return findByProperty(CHAMPION_NUMBER, championNumber);
	}

	public List findByTeamHonour(Object teamHonour) {
		return findByProperty(TEAM_HONOUR, teamHonour);
	}

	public List findByTeamRemark(Object teamRemark) {
		return findByProperty(TEAM_REMARK, teamRemark);
	}

	public List findBySportswearColor(Object sportswearColor) {
		return findByProperty(SPORTSWEAR_COLOR, sportswearColor);
	}

	public List findByOrderBy(Object orderBy) {
		return findByProperty(ORDER_BY, orderBy);
	}

	public List findByDeleteState(Object deleteState) {
		return findByProperty(DELETE_STATE, deleteState);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#findByIsValid(java.lang.Object)
	 */
	public List findByIsValid(Object isValid) {
		return findByProperty(IS_VALID, isValid);
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findAll() {
		try {
			String queryString = "from TbBallTeam ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbBallTeam failed", re);
			throw re;
		}
	}

	public List findAllCheck() {
		try {
			String queryString = "from TbBallTeam as model where model.isValid='Y' and model.deleteState='N' and model.isDisband='N' ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbBallTeam failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.dao.imp.IBallTeamDAO#merge(com.ulysses.base.pojo.TbBallTeam)
	 */
	public TbBallTeam merge(TbBallTeam detachedInstance) {
		log.debug("merging TbBallTeam instance");
		try {
			TbBallTeam result = (TbBallTeam) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbBallTeam instance) {
		log.debug("attaching dirty TbBallTeam instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void update(TbBallTeam instance) {
		log.debug("attaching dirty TbBallTeam instance");
		try {
			getSession().update(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbBallTeam instance) {
		log.debug("attaching clean TbBallTeam instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}