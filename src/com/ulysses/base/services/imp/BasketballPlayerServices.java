package com.ulysses.base.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.dao.IBasketballPlayerDao;
import com.ulysses.base.pojo.TbBasketballPlayer;
import com.ulysses.base.services.IBasketballPlayerServices;
import com.ulysses.base.view.BasketballPlayerView;

@Transactional
@Service
public class BasketballPlayerServices implements IBasketballPlayerServices {
	
	@Autowired
	IBasketballPlayerDao basketballPlayerDao;

	/**
	 * 搜索球员
	 */
	public List findByBasketballPlayer(BasketballPlayerView view) {
		String aliasName = view.getBasketballPlayerName();
		return basketballPlayerDao.findByName(aliasName, view.getPage(50));
	}

	/**
	 * 根据球队ID 获取球队的所有队员信息
	 */
	public List allBallPlayerByTeam(Long teamId) {
		return basketballPlayerDao.allBallPlayerByTeam(teamId);
	}

	/**
	 * 获取我关注的人
	 */
	public List getFocus(Long userId, PageBean page) {
		return basketballPlayerDao.getFocus(userId, page);
	}
	
	/**
	 * 获取所有关注我的人
	 */
	public List getFocusMe(Long focusUserId, PageBean page) {
		return basketballPlayerDao.getFocusMe(focusUserId, page);
	}
	
	public List findAll() {
		return basketballPlayerDao.findAll();
	}

	public List findByExample(TbBasketballPlayer instance) {
		return basketballPlayerDao.findByExample(instance);
	}

	public TbBasketballPlayer findById(Long id) {
		return basketballPlayerDao.findById(id);
	}

	public List findByUserId(Object userId) {
		return basketballPlayerDao.findByUserId(userId);
	}
	
	/**
	 * By userId 获取一条数据
	 * @param userId
	 * @return
	 */
	public TbBasketballPlayer findByUserIdOnly(Long userId) {
		List arr = this.findByUserId(userId);
		if(arr.size() > 0){
			return (TbBasketballPlayer) arr.get(0);
		}
		return null;
	}

	public TbBasketballPlayer merge(TbBasketballPlayer detachedInstance) {
		return basketballPlayerDao.merge(detachedInstance);
	}

	public void save(TbBasketballPlayer transientInstance) {
		basketballPlayerDao.save(transientInstance);
	}

	public void update(TbBasketballPlayer transientInstance) {
		basketballPlayerDao.update(transientInstance);
	}

	public List findAllBasketballPlayer(BasketballPlayerView view) {
		return basketballPlayerDao.findAllBasketballPlayer();
	}
	
	public List findByUserPhoneNumber(BasketballPlayerView view) {
		return basketballPlayerDao.findByUserPhoneNumber(view);
	}
	public List findUserNameAndPhoneNumber(BasketballPlayerView view) {
		return basketballPlayerDao.findUserNameAndPhoneNumber(view);
	}

	public void dynamicCountAdd(Long userID) {
		TbBasketballPlayer temp = this.findByUserIdOnly(userID);
		temp.setDynamicCount(temp.getDynamicCount()+1);
		this.update(temp);
	}

	public void dynamicCountCut(Long userID) {
		TbBasketballPlayer temp = this.findByUserIdOnly(userID);
		if(temp.getDynamicCount() > 0){
			temp.setDynamicCount(temp.getDynamicCount()-1);
			this.update(temp);
		}
	}

	public void focusCountAdd(Long userID) {
		TbBasketballPlayer temp = this.findByUserIdOnly(userID);
		temp.setFocusCount(temp.getFocusCount()+1);
		this.update(temp);
	}

	public void focusCountCut(Long userID) {
		TbBasketballPlayer temp = this.findByUserIdOnly(userID);
		if(temp.getFocusCount() > 0){
			temp.setFocusCount(temp.getFocusCount()-1);
			this.update(temp);
		}
	}
	
	public void focusTeamCountAdd(Long userID) {
		TbBasketballPlayer temp = this.findByUserIdOnly(userID);
		temp.setFocusTeamCount(temp.getFocusTeamCount()+1);
		this.update(temp);
	}
	
	public void focusTeamCountCut(Long userID) {
		TbBasketballPlayer temp = this.findByUserIdOnly(userID);
		if(temp.getFocusTeamCount() > 0){
			temp.setFocusTeamCount(temp.getFocusTeamCount()-1);
			this.update(temp);
		}
	}

	public void goalFocusCountAdd(Long userID) {
		TbBasketballPlayer temp = this.findByUserIdOnly(userID);
		temp.setGoalFocusCount(temp.getGoalFocusCount()+1);
		this.update(temp);
	}

	public void goalFocusCountCut(Long userID) {
		TbBasketballPlayer temp = this.findByUserIdOnly(userID);
		if(temp.getGoalFocusCount() > 0){
			temp.setGoalFocusCount(temp.getGoalFocusCount()-1);
			this.update(temp);
		}
	}


}
