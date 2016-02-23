package com.ulysses.base.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.dao.IBallTeamInviteDAO;
import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.pojo.TbBallTeamInvite;
import com.ulysses.base.pojo.TbBallTeamRef;
import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IBallTeamInviteServices;
import com.ulysses.base.services.IBallTeamRefServices;
import com.ulysses.base.services.IBallTeamServices;
import com.ulysses.base.services.IFSBAUserServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.view.BallTeamInviteView;
import com.ulysses.base.view.BallTeamRefView;

/**
 * 
 * 邀请信息DAO
 * 
 * 球队发出信息邀请球员
 *
 */
@Transactional
@Service
public class BallTeamInviteServices implements IBallTeamInviteServices, ICommonConstant {
	private Map<String, Object> jsonMap;
	
	@Autowired
	ICommonExec common;

	@Autowired
	IBallTeamServices teamService;

	@Autowired
	IBallTeamRefServices teamRefService;

	@Autowired
	IFSBAUserServices userService;
	
	@Autowired
	IBallTeamInviteDAO inviteDao;
	
	/**
	 * 球队发出邀请 , 邀请加入球队
	 */
	public Map<String, Object> send(BallTeamInviteView view) {
		if(view.getInviteTeamId() == null){
			return common.forbid();
		}
		
		//1 自己不能邀请自己
		if(view.getNowUserId().equals(view.getInviteUserId())){
			return common.forbid();
		}
		
		TbBallTeamRef teamRef = new TbBallTeamRef();
		teamRef.setTeamId(view.getInviteTeamId());
		teamRef.setBallPlayerId(view.getInviteUserId());
		
		//2 判断是否该球队成员
		List arrRef = teamRefService.findTeamRef(teamRef);
		if(arrRef.size()>0){
			return common.existPlayer();
		}

		TbBallTeam team = teamService.findById(view.getInviteTeamId());
		
		//3 当前用户是否为球队的创建者
		if(!team.getCreateUserId().equals(view.getNowUserId())){
			return common.forbid();
		}
		if(team.getIsDisband().equals(STATE_Y) || team.getIsValid().equals(STATE_N)){
			return common.forbid();
		}
		
		
		TbBallTeamInvite invote = new TbBallTeamInvite();
		invote.setInviteUserId(view.getInviteUserId());//被邀请的用户ID
		invote.setInviteTeamId(view.getInviteTeamId());

		//4 判断是否已经发出邀请
		List arr = inviteDao.inviteByUser(invote);
		if(arr.size() > 0){
			return common.invite();
		}
		
		Date now = new Date();
		invote.setCreateDate(now);
		invote.setCreateUserId(view.getNowUserId());
		invote.setUpdateDate(now);
		invote.setUpdateUserId(view.getNowUserId());
		invote.setDeleteState(STATE_N);
		invote.setIsValid(STATE_Y);
		invote.setVersion(1);
		invote.setOrderBy(100L);
		invote.setApproveState(STATE_N);
		invote.setAgreeState(STATE_N);
		invote.setIsDisband(STATE_N);
		invote.setIsOfficialTeam(STATE_N);
		
		invote.setInviteIp(view.getInviteIp());
		invote.setInviteFromUserId(view.getNowUserId());
		
		TbUser user = userService.findById(view.getInviteUserId());
		invote.setInviteAliasName(user.getAliasName());
		
		invote.setInviteTeamName(team.getTeamName());
		
		inviteDao.save(invote );
		return common.success();
	}
	

	/**
	 * 设置邀请为忽略状态
	 */
	public Map<String, Object> editAgreeIgnore(BallTeamInviteView view) {
		//设置邀请为忽略状态
		view.setAgreeState(STATE_G);
		return this.editAgreeState(view);

	}


	/**
	 * 设置邀请为同意状态
	 * 
	 */
	public Map<String, Object> editAgreeYes(BallTeamInviteView view) {
		//设置为同意接受邀请
		view.setAgreeState(STATE_Y);
		return this.editAgreeState(view);

	}
	

	/**
	 * 设置接受邀请的状态(同意或忽略)
	 * 
	 */
	private Map<String, Object> editAgreeState(BallTeamInviteView view) {
		if(view.getInviteId() == null){
			return common.forbid();
		}
		
		TbBallTeamInvite invite = inviteDao.findById(view.getInviteId());
		// 验证邀请记录状态是否有效
		if(accessCheck(invite)){
			return common.forbid();
		}
		// 验证被邀请的用户ID
		if(!invite.getInviteTeamId().equals(view.getInviteTeamId()) || !invite.getInviteUserId().equals(view.getNowUserId()) ){
			return common.forbid();
		}
		
		// 验证数据版本是否最新
		if(invite.getVersion().equals(view.getVersion())){
			invite.setVersion(invite.getVersion()+1);
			invite.setAgreeState(view.getAgreeState()); //设置同意状态
			
			Date now = new Date();
			invite.setUpdateDate(now);
			invite.setUpdateUserId(view.getNowUserId());
			
			inviteDao.update(invite );
			
			if(view.getAgreeState().equals(STATE_Y)){
				// 加入球队
				BallTeamRefView teamRef = new BallTeamRefView();
				teamRef.setTeamId(view.getInviteTeamId());
				teamRef.setBallPlayerId(view.getNowUserId());
				teamRef.setNowUserId(view.getNowUserId());

				return teamRefService.addPlayer(teamRef );
			}
			
			return common.success();
		}else {
			return common.version();
		}
	}
	

	/**
	 * 一个球队发出的所有邀请
	 */
	public Map<String, Object> inviteByTeam(BallTeamInviteView view) {
		TbBallTeamInvite invite = new TbBallTeamInvite();

		invite.setInviteTeamId(view.getInviteTeamId());
		invite.setInviteFromUserId(view.getNowUserId());
		invite.setInviteUserId(view.getInviteUserId());//被邀请的用户ID
		invite.setDeleteState(STATE_N);
		invite.setIsValid(STATE_Y);
		invite.setApproveState(STATE_N);
		invite.setIsDisband(STATE_N);
		
		List arr = inviteDao.allInvite(invite);
		jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
	}

	/**
	 * 个人收到的所有邀请
	 */
	public List myAllInvite(BallTeamInviteView view) {

		TbBallTeamInvite invite = new TbBallTeamInvite();

		//invite.setInviteTeamId(view.getInviteTeamId());
		invite.setInviteUserId(view.getNowUserId());//被邀请的用户ID
		invite.setDeleteState(STATE_N);
		invite.setIsValid(STATE_Y);
		invite.setApproveState(STATE_N);
		invite.setAgreeState(STATE_N);
		invite.setIsDisband(STATE_N);
		
		return inviteDao.myAllInvite(invite);
	}

	public Map<String, Object> getInviteMe(BallTeamInviteView view) {

		List arr = this.myAllInvite(view);
		jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
	}
	

	private boolean accessCheck(TbBallTeamInvite invite) {
		
		if(invite == null){
			return true;
		}
		if(invite.getDeleteState().equals(STATE_Y)){
			return true;
		}
		if(invite.getIsValid().equals(STATE_N)){
			return true;
		}
		if(!invite.getAgreeState().equals(STATE_N)){ //未同意状态 或者 忽略状态
			return true;
		}
		if(invite.getIsDisband().equals(STATE_Y)){
			return true;
		}

		return false;
	}


}
