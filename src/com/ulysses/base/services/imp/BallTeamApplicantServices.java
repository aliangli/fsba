package com.ulysses.base.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.dao.IBallTeamApplicantDAO;
import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.pojo.TbBallTeamApplicant;
import com.ulysses.base.services.IBallTeamApplicantServices;
import com.ulysses.base.services.IBallTeamRefServices;
import com.ulysses.base.services.IBallTeamServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.view.BallTeamApplicantView;
import com.ulysses.base.view.BallTeamRefView;
import com.ulysses.base.view.BallTeamView;
import com.ulysses.util.UtilString;

/**
 * 申请信息Service
 * 
 * 球员申请加入球队
 */
@Transactional
@Service
public class BallTeamApplicantServices implements IBallTeamApplicantServices, ICommonConstant {
	private Map<String, Object> jsonMap;
	
	@Autowired
	ICommonExec common;
	
	@Autowired
	IBallTeamServices teamService;

	@Autowired
	IBallTeamRefServices teamRefService;
	
	@Autowired
	IBallTeamApplicantDAO ballTeamApplicantDAO;
	

	/**
	 * 一个球队 所有的申请记录
	 * @param view
	 * @return
	 */
	public Map<String, Object> applicantByTeam(BallTeamView view) {
		
		TbBallTeamApplicant applicant = new TbBallTeamApplicant();
		applicant.setCreateUserId(view.getNowUserId());
		applicant.setApplicantTeamId(view.getTeamId()); //球队ID
		applicant.setAgreeState(STATE_N); //同意状态为N  ,未同意
		applicant.setIsDisband(STATE_N); //未解散状态
		
		List arr = ballTeamApplicantDAO.applicantByTeam(applicant);
		
		jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
		
	}


	/**
	 * 设置球队所有申请信息的解散状态
	 */
	public void editTeamDisband(TbBallTeamApplicant applicant) {
		ballTeamApplicantDAO.editTeamDisband(applicant);
	}
	
	/**
	 * 根据申请的用户ID 来查询球队收到的申请记录
	 * 未同意状态的申请记录
	 * @param applicant
	 * @return
	 */
	public List findTeamApplicant(TbBallTeamApplicant applicant) {
		return ballTeamApplicantDAO.findTeamApplicant(applicant);
	}
	
	


	/**
	 * 球员发出申请
	 */
	public Map<String, Object> send(BallTeamApplicantView view) {
		
		Long teamId = view.getApplicantTeamId();
		if(UtilString.isEmptyL(teamId) ){
			return common.forbid();
		}
		
		//验证球队是否解散
		TbBallTeam team = teamService.findById(teamId);
		if(STATE_Y.equals(team.getIsDisband()) || STATE_N.equals(team.getIsValid()) ){
			return common.teamDisband();
		}
		
		//自己的球队不能对自己发出申请
		if(team.getCreateUserId().equals(view.getNowUserId()) ){
			return common.forbid();
		}
		
		TbBallTeamApplicant applicant = new TbBallTeamApplicant();

		applicant.setAgreeState(STATE_N); //同意状态为N  ,未同意
		applicant.setApplicantFromUserId(view.getNowUserId()); //球员ID
		applicant.setApplicantTeamId(team.getId()); //球队ID
		applicant.setIsDisband(STATE_N); //未解散状态
		
		//验证没有多条未同意状态的申请记录
		List arr = this.findTeamApplicant(applicant);
		if(arr.size() > 0){
			return common.underWay();
		}
		
		//验证不是已经存在球队的队员
		
		
		Date now = new Date();
		applicant.setCreateDate(now);
		applicant.setUpdateDate(now);
		applicant.setDeleteState(STATE_N);
		applicant.setIsValid(STATE_Y);
		applicant.setVersion(1);
		applicant.setOrderBy(100L);
		applicant.setApproveState(STATE_N);
		applicant.setIsOfficialTeam(STATE_N);
		applicant.setCreateUserId(view.getNowUserId());
		applicant.setUpdateUserId(view.getNowUserId());
		
		applicant.setApplicantFromAliasName(view.getAliasName());
		applicant.setApplicantTeamName(view.getApplicantTeamName());
		applicant.setApplicantPlace(view.getApplicantPlace());
		applicant.setApplicantIp(view.getApplicantIp());

		ballTeamApplicantDAO.save(applicant );
		return common.success();
	}
	

	/**
	 * 设置申请加入球队状态为忽略
	 */
	public Map<String, Object> editAgreeIgnore(BallTeamApplicantView view) {
		view.setAgreeState(STATE_G);
		return this.editAgreeState(view);
	}
	
	/**
	 * 设置申请加入球队状态为同意
	 */
	public Map<String, Object> editAgreeYes(BallTeamApplicantView view) {
		view.setAgreeState(STATE_Y);
		return this.editAgreeState(view);
	}
	
	/**
	 * 设置申请加入球队的状态(同意或忽略)
	 */
	private Map<String, Object> editAgreeState(BallTeamApplicantView view) {
		if(view.getApplicantId() == null || view.getApplicantTeamId() == null){
			return common.forbid();
		}
		
		//判断当前用户是否为球队的创建者
		TbBallTeam team = teamService.findById(view.getApplicantTeamId());
		if(!team.getCreateUserId().equals(view.getNowUserId())){
			return common.forbid();
		}
		//球队未解散
		if(team.getIsDisband().equals(STATE_Y)){
			return common.forbid();
		}
		//球队有效
		if(team.getIsValid().equals(STATE_N)){
			return common.forbid();
		}
		
		//获取申请记录
		TbBallTeamApplicant applicant = this.findById(view.getApplicantId());
		
		if(!applicant.getAgreeState().equals(STATE_N)){
			return common.forbid();
		}
		if(applicant.getIsDisband().equals(STATE_Y)){
			return common.forbid();
		}
		
		if(!applicant.getApplicantFromUserId().equals(view.getApplicantFromUserId()) || !applicant.getApplicantTeamId().equals(view.getApplicantTeamId())){
			return common.forbid();
		}
		
		applicant.setAgreeState(view.getAgreeState());
		ballTeamApplicantDAO.update(applicant );
		
		if(view.getAgreeState().equals(STATE_Y)){
			//同意则加入球队
			BallTeamRefView teamRef = new BallTeamRefView();
			teamRef.setTeamId(view.getApplicantTeamId());
			teamRef.setBallPlayerId(view.getApplicantFromUserId());
			teamRef.setNowUserId(view.getNowUserId());
			
			//加入球队
			return teamRefService.addPlayer(teamRef );
		}
		
		return common.success();
	}


	public List findAll() {
		return ballTeamApplicantDAO.findAll();
	}


	public List findByExample(TbBallTeamApplicant instance) {
		return ballTeamApplicantDAO.findByExample(instance);
	}


	public TbBallTeamApplicant findById(Long id) {
		return ballTeamApplicantDAO.findById(id);
	}


	public void save(TbBallTeamApplicant transientInstance) {
		ballTeamApplicantDAO.save(transientInstance);
	}


	public void update(TbBallTeamApplicant transientInstance) {
		ballTeamApplicantDAO.update(transientInstance);
	}




}
