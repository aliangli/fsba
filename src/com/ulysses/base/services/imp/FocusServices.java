package com.ulysses.base.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.dao.IFocusDao;
import com.ulysses.base.pojo.TbFocus;
import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IBasketballPlayerServices;
import com.ulysses.base.services.IFSBAUserServices;
import com.ulysses.base.services.IFocusServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.UserView;
import com.ulysses.base.view.FocusUserView;

/**
 * 关注个人
 *
 */
@Transactional
@Service
public class FocusServices implements IFocusServices, ICommonConstant {

	@Autowired
	ICommonLoginExec loginExec;

	@Autowired
	ICommonExec common;
	

	@Autowired
	IFSBAUserServices fsbaUserServices;

	@Autowired
	IBasketballPlayerServices playerServices;
	
	@Autowired
	IFocusDao focusDao;
	

	/**
	 * 用户ID 和 被关注用户ID 查询
	 */
	public Map<String, Object> findFocusUser(FocusUserView view) {
		
		TbFocus focus = new TbFocus();
		focus.setUserId(view.getNowUserId());
		focus.setUserFocusId(view.getUserFocusId());
		
		List arr = focusDao.findFocusByUser(focus);
		if(arr.size() > 0){
			Map<String, Object> jsonMap = common.success();
			jsonMap.put(DATA, arr.get(0));
			return jsonMap;
		}else {
			return common.forbid();
		}
		
		
	}

	/**
	 * 当前用户 关注的人
	 */
	public Map<String, Object> getNowUserFocus(UserView view) {
		if(null == view.getNowUserId()){
			return common.forbid();
		}
		List focusArr = playerServices.getFocus(view.getNowUserId(), view.getPage(50));

		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, focusArr);
		return jsonMap;
	}
	
	/**
	 * 关注当前用户的人
	 */
	public Map<String, Object> getNowUserFocusMe(UserView view) {
		if(null == view.getNowUserId()){
			return common.forbid();
		}
		
		List focusArr = playerServices.getFocusMe(view.getNowUserId(), view.getPage(50));
		
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, focusArr);
		return jsonMap;
	}
	
	/**
	 * 某个用户关注的人
	 */
	public Map<String, Object> getFocusByUser(UserView view) {
		if(null == view.getUserId()){
			return common.forbid();
		}
		List focusArr = playerServices.getFocus(view.getUserId(), view.getPage(50));
		
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, focusArr);
		return jsonMap;
	}
	
	/**
	 * 关注某个用户的人
	 */
	public Map<String, Object> getFocusByPassive(UserView view) {
		if(null == view.getUserId()){
			return common.forbid();
		}
		
		List focusArr = playerServices.getFocusMe(view.getUserId(), view.getPage(50));
		
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, focusArr);
		return jsonMap;
	}


	/**
	 * 取消关注一个球员
	 */
	public Map<String, Object> cancelFocus(FocusUserView view) {
		if(view.getUserFocusId() == null){
			return common.forbid();
		}
		
		// 1. 判断球员是否存在
		TbUser fcUser = fsbaUserServices.findById(view.getUserFocusId());
		
		if(fcUser != null){
			TbFocus focus = new TbFocus();
			focus.setUserId(view.getNowUserId());
			focus.setUserFocusId(view.getUserFocusId());
			
			// 2. 判断是否已被关注
			List focusArrs = focusDao.findFocusCheck(focus);
			if(focusArrs.size() > 0){
				TbFocus resultFocus = (TbFocus)focusArrs.get(0);
				
				if(resultFocus == null){
					return common.cleanFocusFail();
				}
				
				//resultFocus.setIsValid(STATE_N);
				//直接删除关注数据
				this.delete(resultFocus);
				
				//关注数-1
				playerServices.focusCountCut(view.getNowUserId());
				//被关注数-1
				playerServices.goalFocusCountCut(view.getUserFocusId());
				
				return common.cleanFocusSuccess();
			}
			return common.cleanFocusFail();

		}

		return common.invalidBallPlayer();
	}
	
	/**
	 * 关注一个球员的状态
	 */
	public Map<String, Object> focusPlayer(FocusUserView view) {
		if(view.getUserFocusId() == null || view.getUserFocusId() == 0){
			return common.forbid();
		}
		
		// 1. 判断球员是否存在
		TbUser fcUser = fsbaUserServices.findById(view.getUserFocusId());
		
		if(fcUser != null){
			TbFocus focus = new TbFocus();
			focus.setUserId(view.getNowUserId());
			focus.setUserFocusId(view.getUserFocusId());
			
			// 2. 查询已关注的数据
			List focusArrs = focusDao.findFocusCheck(focus);
			if(focusArrs.size() > 0){
				
				return common.focusBallPlayer();
			}else {
				return common.focusPlayerNot();
			}
			
		}else {
			
			return common.invalidBallPlayer();
		}
		
		
	}

	/**
	 * 关注一个球员
	 */
	public Map<String, Object> focus(FocusUserView view) {
		if(view.getUserFocusId() == null){
			return common.forbid();
		}
		
		TbUser fcUser = fsbaUserServices.findById(view.getUserFocusId());
		// 1.判断球员是否存在
		if(fcUser == null){
			return common.invalidBallPlayer();
		}
		
		TbFocus focus = new TbFocus();
		focus.setUserId(view.getNowUserId());
		focus.setUserFocusId(view.getUserFocusId());
		
		// 2.用户ID 和 关注用户ID 查询, 判断是否已被关注
		List focusArrs = focusDao.findFocusCheck(focus);
		if(focusArrs.size() > 0){
			TbFocus temp = (TbFocus)focusArrs.get(0);

			//未关注状态
			if(temp.getIsValid().equals(STATE_N)){
				return executeFocus(temp, view);
			}
			return common.focusBallPlayer();
		}

		return executeFocus(focus, view);
	}

	private Map<String, Object> executeFocus(TbFocus focus, FocusUserView view) {
		focus.setIsValid(STATE_Y);
		this.save(focus);
		
		//关注数+1
		playerServices.focusCountAdd(view.getNowUserId());
		//被关注数+1
		playerServices.goalFocusCountAdd(view.getUserFocusId());

		return common.focusSuccess();
	}

	public void save(TbFocus transientInstance) {
		transientInstance.setFocusDate(new Date());
		focusDao.save(transientInstance);
	}


	public void update(TbFocus transientInstance) {
		focusDao.update(transientInstance);
	}
	
	public void delete(TbFocus focus) {
		focusDao.delete(focus);
	}


	public List findAll() {
		return focusDao.findAll();
	}

	public TbFocus findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByUserFocusId(Object userFocusId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByUserId(Object userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public TbFocus merge(TbFocus detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}





}
