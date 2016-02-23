package com.ulysses.base.dao.imp;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.dao.IBasketballPlayerDao;
import com.ulysses.base.dao.support.BaseHibernateDao;
import com.ulysses.base.pojo.TbBasketballPlayer;
import com.ulysses.base.view.BasketballPlayerView;
import com.ulysses.util.UtilString;

/**
 *   球员属性
 */

@Repository
public class TbBasketballPlayerDAO extends BaseHibernateDao implements IBasketballPlayerDao {
	private static final Logger log = LoggerFactory.getLogger(TbBasketballPlayerDAO.class);
	
	private static final String querySQL = "select new com.ulysses.base.dao.db.DBUserFocus(u.id, u.userName, u.chineseName, u.englishName, u.aliasName, u.nationality, u.birthpace, u.birthdate,u.graduateSchool, u.stature,u.weight, u.userPhoneNumber,u.userPhotoPath, u.userAddress, u.userCity, u.regeditDate,  b.position, b.userId,b.livelyDegree, b.passionDegree, b.attackDegree, b.defendDegree, b.hitDegree, b.talentDegree, b.playerPhotoPath, b.grade, b.dynamicCount, b.focusCount, b.focusTeamCount, b.goalFocusCount, b.medalConfig) ";
	

	/**
	 * 获取我关注的人
	 */
	public List getFocus(Long userId, PageBean page) {
		
		try {
			String hql = querySQL + " from TbUser u , TbFocus f,TbBasketballPlayer b where u.id = f.userFocusId and f.userFocusId = b.userId and f.isValid = 'Y' and f.userId = ? ";
			
			Query queryObject = getSession().createQuery(hql);
			queryObject.setParameter(0, userId);
			
			super.setPage(queryObject, page);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find getFocus failed", re);
			throw re;
		}
	}
	
	/**
	 * 获取所有关注我的人
	 */
	public List getFocusMe(Long userFocusId, PageBean page) {
		
		try {
			String hql = querySQL + " from TbFocus f, TbUser u , TbBasketballPlayer b where u.id = f.userId and f.userId = b.userId and f.isValid = 'Y' and f.userFocusId = ? ";
			
			Query queryObject = getSession().createQuery(hql);
			queryObject.setParameter(0, userFocusId);
			super.setPage(queryObject, page);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find getFocus failed", re);
			throw re;
		}
	}

	/**
	 * 根据球队ID 获取球队的所有队员信息
	 */
	public List allBallPlayerByTeam(Long teamId) {
		
		try {
			String queryString = querySQL + " from TbUser u , TbBallTeamRef t,TbBasketballPlayer b where t.isDetach='N' and t.isDisband='N' and u.id = t.ballPlayerId and t.ballPlayerId = b.userId and t.teamId = ? ";
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, teamId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbBallTeam failed", re);
			throw re;
		}
	}
	
	/**
	 * All 球员
	 */
	public List findAllBasketballPlayer() {
		try {
			String queryString = querySQL + " from TbUser u , TbBasketballPlayer b where u.id = b.userId ";
			Query queryObject = getSession().createQuery(queryString);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find findAllBasketballPlayer failed", re);
			throw re;
		}
	}
	
	/**
	 * By 昵称 搜索球员
	 */
	public List findByName(String aliasName, PageBean page) {
		try {
			String queryString = querySQL + "from TbUser u , TbBasketballPlayer b where u.id = b.userId and (u.aliasName like ? ) ";
			
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, "%" + aliasName + "%");
			super.setPage(queryObject, page);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find findByName failed", re);
			throw re;
		}
	}
	
	/**
	 * 根据  登录名、手机号  
	 *  搜索球员
	 */
	public List findUserNameAndPhoneNumber(BasketballPlayerView view) {
		try {
			String queryString = querySQL + " from TbUser u , TbBasketballPlayer b where u.id = b.userId  ";
			
			if(UtilString.notEmpty(view.getBasketballPlayerName())){
				queryString += " and ( u.userName like ?  or u.userPhoneNumber like ?  ) ";
			}
			
			Query queryObject = getSession().createQuery(queryString);
			
			if(UtilString.notEmpty(view.getBasketballPlayerName())){
				queryObject.setParameter(0, "%" + view.getBasketballPlayerName() + "%");
				queryObject.setParameter(1, "%" + view.getBasketballPlayerName() + "%");
			}
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 根据姓名查询球员
	 */
	public List findByUserName(String name) {
		try {
			String queryString = querySQL + " from TbUser u , TbBasketballPlayer b where u.id = b.userId  ";
			
			if(UtilString.notEmpty(name)){
				queryString += " and ( u.chineseName like ? or   u.englishName like ? or u.aliasName like ?  or u.userName like ?  or u.userPhoneNumber like ?  ) ";
			}
			
			Query queryObject = getSession().createQuery(queryString);
			
			if(UtilString.notEmpty(name)){
				queryObject.setParameter(0, "%" + name + "%");
				queryObject.setParameter(1, "%" + name + "%");
				queryObject.setParameter(2, "%" + name + "%");
				queryObject.setParameter(3, "%" + name + "%");
				queryObject.setParameter(4, "%" + name + "%");
			}
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 根据手机号查询球员
	 */
	public List findByUserPhoneNumber(BasketballPlayerView view) {
		try {
			String queryString = querySQL + " from TbUser u , TbBasketballPlayer b where u.id = b.userId  ";
			
			if(UtilString.notEmpty(view.getBasketballPlayerName())){
				queryString += " and ( u.userPhoneNumber like ?  ) ";
			}
			
			Query queryObject = getSession().createQuery(queryString);
			
			if(UtilString.notEmpty(view.getBasketballPlayerName())){
				queryObject.setParameter(0, "%" + view.getBasketballPlayerName() + "%");
			}
			
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	
	
	
	public void save(TbBasketballPlayer transientInstance) {
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public TbBasketballPlayer findById(java.lang.Long id) {
		try {
			TbBasketballPlayer instance = (TbBasketballPlayer) getSession().get("com.ulysses.base.pojo.TbBasketballPlayer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get TbBasketballPlayer failed", re);
			throw re;
		}
	}

	public List findByExample(TbBasketballPlayer instance) {
		try {
			List results = getSession().createCriteria(
					"com.ulysses.base.pojo.TbBasketballPlayer").add(
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
			String queryString = "from TbBasketballPlayer as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find TbBasketballPlayer failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByPosition(Object position) {
		return findByProperty(POSITION, position);
	}

	public List findByLivelyDegree(Object livelyDegree) {
		return findByProperty(LIVELY_DEGREE, livelyDegree);
	}

	public List findByPassionDegree(Object passionDegree) {
		return findByProperty(PASSION_DEGREE, passionDegree);
	}

	public List findByAttackDegree(Object attackDegree) {
		return findByProperty(ATTACK_DEGREE, attackDegree);
	}

	public List findByDefendDegree(Object defendDegree) {
		return findByProperty(DEFEND_DEGREE, defendDegree);
	}

	public List findByHitDegree(Object hitDegree) {
		return findByProperty(HIT_DEGREE, hitDegree);
	}

	public List findByTalentDegree(Object talentDegree) {
		return findByProperty(TALENT_DEGREE, talentDegree);
	}

	public List findByPlayerPhotoPath(Object playerPhotoPath) {
		return findByProperty(PLAYER_PHOTO_PATH, playerPhotoPath);
	}

	public List findAll() {
		try {
			String queryString = "from TbBasketballPlayer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbBasketballPlayer merge(TbBasketballPlayer detachedInstance) {
		try {
			TbBasketballPlayer result = (TbBasketballPlayer) getSession().merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void update(TbBasketballPlayer instance) {
		try {
			getSession().update(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbBasketballPlayer instance) {
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}