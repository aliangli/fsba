package com.ulysses.base.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.dao.IBallTeamRefDAO;
import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.pojo.TbBallTeamRef;
import com.ulysses.base.services.IBallTeamApplicantServices;
import com.ulysses.base.services.IBallTeamRefServices;
import com.ulysses.base.services.IBallTeamServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.view.BallTeamRefView;

@Transactional
@Service
public class BallTeamRefServices implements IBallTeamRefServices, ICommonConstant {

	@Autowired
	ICommonExec common;
	
	@Autowired
	IBallTeamApplicantServices applicantService;
	
	@Autowired
	IBallTeamRefDAO ballTeamRefDAO;

	@Autowired
	IBallTeamServices teamService;
	

	/**
	 * 设置队员关系的解散状态
	 */
	public void editTeamRefDisband(TbBallTeamRef teamRef) {
		ballTeamRefDAO.editTeamRefDisband(teamRef);
	}
	
	/**
	 * 设置队员关系的删除状态
	 */
	public void editTeamRefDelete(TbBallTeamRef teamRef) {
		ballTeamRefDAO.editTeamRefDelete(teamRef);
	}


	/**
	 * 加入队员
	 */
	public Map<String, Object> addPlayer(BallTeamRefView view) {

		TbBallTeamRef ballTeamRef = new TbBallTeamRef();
		ballTeamRef.setTeamId(view.getTeamId());
		ballTeamRef.setBallPlayerId(view.getBallPlayerId());
		
		//判断是否为球队成员 
		List arr = ballTeamRefDAO.findByTeamRef(ballTeamRef);
		if(arr.size() == 0){
			
			Date now = new Date();
			ballTeamRef.setApproveState(STATE_N);
			ballTeamRef.setIsDisband(STATE_N);
			ballTeamRef.setCreateDate(now);
			ballTeamRef.setCreateUserId(view.getNowUserId());
			
			ballTeamRef.setUpdateDate(now);
			ballTeamRef.setUpdateUserId(view.getNowUserId());
			ballTeamRef.setIsDetach(STATE_N);
			ballTeamRef.setDeleteState(STATE_N);
			ballTeamRef.setIsValid(STATE_Y);
			ballTeamRef.setVersion(1);
			ballTeamRef.setOrderBy(100L);
			
			
			
			ballTeamRefDAO.save(ballTeamRef);
			
			return common.success();
		}
		
		return common.fail();
	}

	/**
	 * 移除队员
	 * @param view
	 * @return
	 */
	public Map<String, Object> removerPlayer(BallTeamRefView view) {
		
		//创建者移除自己
		if(view.getNowUserId().equals(view.getBallPlayerId())){
			return common.forbid();
		}
		
		TbBallTeam team = new TbBallTeam();
		team.setId(view.getTeamId());
		team.setCreateUserId(view.getNowUserId());
		team.setIsDisband(STATE_N);
		team.setIsValid(STATE_Y);
		
		//当前用户是否为球队的创建者
		List teamArr = teamService.isMyTeam(team);
		if(teamArr.size() == 0){
			return common.forbid();
		}
		
		
		TbBallTeamRef ref = new TbBallTeamRef();
		ref.setTeamId(view.getTeamId()); // 移除发生在哪个球队ID
		ref.setBallPlayerId(view.getBallPlayerId()); //队员ID
		ref.setIsDetach(STATE_N); //不是移除状态
		
		List arr = this.findByExampleCheck(ref);
		if(arr.size() > 0){
			TbBallTeamRef temp = (TbBallTeamRef) arr.get(0);
			temp.setIsDetach(STATE_Y); //设置为移除球队状态
			ballTeamRefDAO.update(temp);
			
			return common.success();
		}
		
		return common.teamRefNotExist();
	}
	
	

	/**
	 * 获取球队关系
	 */
	public List findTeamRef(TbBallTeamRef instance) {
		return ballTeamRefDAO.findTeamRef(instance);
	}

	public List findByTeamId(Object teamId) {
		return ballTeamRefDAO.findByTeamId(teamId);
	}

	public void delete(TbBallTeamRef persistentInstance) {
		// TODO Auto-generated method stub

	}

	public List findAll() {
		return ballTeamRefDAO.findAll();
	}
	

	public List findByBallPlayerId(Object ballPlayerId) {
		return ballTeamRefDAO.findByBallPlayerId(ballPlayerId);
	}

	public List findByExampleCheck(TbBallTeamRef instance) {
		return ballTeamRefDAO.findByExampleCheck(instance);
	}

	public TbBallTeamRef findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByIsValid(Object isValid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}


	public TbBallTeamRef merge(TbBallTeamRef detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
