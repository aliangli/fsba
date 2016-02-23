package com.ulysses.base.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.dao.IPlayerFocusTeamDao;
import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.pojo.TbPlayerFocusTeam;
import com.ulysses.base.services.IBallTeamServices;
import com.ulysses.base.services.IBasketballPlayerServices;
import com.ulysses.base.services.IPlayerFocusTeamServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.FocusTeamView;
import com.ulysses.util.UtilString;

/**
 * 关注球队
 *
 */
@Transactional
@Service
public class PlayerFocusTeamServices implements IPlayerFocusTeamServices, ICommonConstant  {

	@Autowired
	ICommonExec common;

	@Autowired
	ICommonLoginExec loginExec;
	
	@Autowired
	IPlayerFocusTeamDao focusTeamDao;
	
	@Autowired
	IBallTeamServices teamServices;
	
	@Autowired
	IBasketballPlayerServices playerServices;	
	
	/**
	 * 取消关注一个球队
	 * @param view
	 * @return
	 */
	public Map<String, Object> cancelFocusTeam(FocusTeamView view) {
		
		TbPlayerFocusTeam focusTeamTemp = focusTeamDao.findById(view.getFocusId());
		if(focusTeamTemp.getIsValid().equals(STATE_Y) && focusTeamTemp.getTeamId().equals(view.getTeamId())){

			focusTeamTemp.setIsValid(STATE_N);
			
			focusTeamDao.update(focusTeamTemp);
			
			//关注球队数-1
			playerServices.focusTeamCountCut(view.getNowUserId());
			
			return common.success();
		}else {
			return common.forbid();
		}
		

	}

	/**
	 * 关注一个球队
	 * @param view
	 * @return
	 */
	public Map<String, Object> createFocusTeam(FocusTeamView view) {
		
		//判断球队ID为空
		if(UtilString.isEmptyR(view.getTeamId())){
			return common.forbid();
		}
		
		TbBallTeam team = teamServices.findById(view.getTeamId());
		//判断球队是否存在
		if(team == null){
			return common.teamNotExist();
		}
		//判断球队是否解散
		if(STATE_Y.equals(team.getIsDisband())){
			return common.teamDisband();
		}
		
		TbPlayerFocusTeam focusTeam = new TbPlayerFocusTeam();

		focusTeam.setUserId(view.getNowUserId());
		focusTeam.setTeamId(view.getTeamId());
		focusTeam.setIsValid(STATE_Y);
		
		List focusArr = focusTeamDao.findByCheckUser(focusTeam);
		if(focusArr.size() > 0){
			TbPlayerFocusTeam temp = (TbPlayerFocusTeam) focusArr.get(0);
			
			//未关注状态
			if(temp.getIsValid().equals(STATE_N)){
				temp.setIsValid(STATE_Y);
				focusTeamDao.save(temp);
				return common.success();
			}
			
			return common.focusTeam();
		}

		Date now = new Date();
		focusTeam.setFocusDate(now);
		focusTeam.setTeamName(team.getTeamName());
		
		focusTeamDao.save(focusTeam);
		
		//关注球队数+1
		playerServices.focusTeamCountAdd(view.getNowUserId());
		
		return common.success();
		
	}
	
	/**
	 * 判断关注一个球队的状态
	 * @param view
	 * @return
	 */
	public Map<String, Object> isFocusTeam(FocusTeamView view) {
		
		TbBallTeam team = teamServices.findById(view.getTeamId());
		//判断球队是否存在
		if(team == null){
			return common.teamNotExist();
		}
		//判断球队是否解散
		if(STATE_Y.equals(team.getIsDisband())){
			return common.teamDisband();
		}
		
		TbPlayerFocusTeam focusTeam = new TbPlayerFocusTeam();
		
		focusTeam.setUserId(view.getNowUserId());
		focusTeam.setTeamId(view.getTeamId());
		focusTeam.setIsValid(STATE_Y);
		
		List focusArr = focusTeamDao.findByCheckUser(focusTeam);
		if(focusArr.size() > 0){
			return common.focusTeam();
		}else {
			return common.focusTeamNot();
		}
		
	}

	/**
	 * 关注的球队
	 * @param view
	 * @return
	 */
	public Map<String, Object> findFocusTeams(FocusTeamView view) {
		
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, focusTeamDao.findAll(view, view.getPage(50)));
		return jsonMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
