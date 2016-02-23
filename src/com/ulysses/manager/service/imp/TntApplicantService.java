package com.ulysses.manager.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.services.IBallTeamServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.manager.dao.ITntApplicantDAO;
import com.ulysses.manager.pojo.TbTntApplicant;
import com.ulysses.manager.pojo.TbTournament;
import com.ulysses.manager.service.ITntApplicantService;
import com.ulysses.manager.service.ITournamentService;
import com.ulysses.manager.view.TntApplicantView;
import com.ulysses.util.UtilString;

/**
 * 球队申请参赛Service
 */
@Transactional
@Service
public class TntApplicantService implements ITntApplicantService, ICommonConstant {

	@Autowired
	ICommonExec common;
	
	@Autowired
	ITntApplicantDAO tntApplicantDao;

	@Autowired
	IBallTeamServices teamService;
	
	@Autowired
	ITournamentService tntService;

	/**
	 * 球队申请参赛
	 */
	public Map<String, Object> save(TntApplicantView view) {

		Long teamId = view.getAltTeamId();
		Long tntId = view.getTntId();
		
		//验证空
		if(UtilString.isEmptyL(teamId) || UtilString.isEmptyL(tntId) || UtilString.isEmptyR(view.getApplicantPlace())){
			return common.forbid();
		}
		
		//验证球队是否解散
		TbBallTeam team = teamService.findById(teamId);
		if(team==null || STATE_Y.equals(team.getIsDisband()) || STATE_N.equals(team.getIsValid())){
			return common.teamDisband();
		}
		
		//只允许球队创建者申请参赛
		if(!team.getCreateUserId().equals(view.getNowUserId()) ){
			return common.forbid();
		}
		
		//验证比赛状态为未开赛
		TbTournament tnt = tntService.findById(tntId);
		if(tnt==null || !STATE_E.equals(tnt.getTournamentState()) || STATE_N.equals(tnt.getIsValid())){
			return common.tntExpireState();
		}
		
		TbTntApplicant applicant = new TbTntApplicant();
		applicant.setAgreeState(STATE_N); //同意状态为N  ,未同意
		applicant.setFromUserId(team.getCreateUserId()); //球员ID
		applicant.setIsValid(STATE_Y);
		applicant.setDeleteState(STATE_N);
		
		//验证没有多条未同意状态的申请记录
		List arr = this.findByExample(applicant);
		if(arr.size() > 0){
			return common.underWay();
		}

		applicant.setAltTeamName(team.getTeamName());
		applicant.setAltTeamId(team.getId());
		applicant.setTntId(tnt.getTournamentId());//比赛ID
		
		Date now = new Date();
		applicant.setCreateDate(now);
		applicant.setUpdateDate(now);
		applicant.setDeleteState(STATE_N);
		applicant.setIsValid(STATE_Y);
		applicant.setVersion(1);
		applicant.setOrderBy(100L);
		applicant.setApproveState(STATE_N);
		applicant.setIsOfficialTeam(STATE_N);
		applicant.setCreateUserId(team.getCreateUserId());
		applicant.setUpdateUserId(team.getCreateUserId());
		
		applicant.setApplicantPlace(view.getApplicantPlace());
		applicant.setApplicantIp(view.getApplicantIp());
		
		this.save(applicant);
		return common.success();
	}

	public Map<String, Object> update(TntApplicantView view) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> delete(TntApplicantView view) {
		return null;
	}
	
	/**
	 * Dao interface
	 */

	public List findByExample(TbTntApplicant instance) {
		return tntApplicantDao.findByExample(instance);
	}

	public TbTntApplicant findById(Long id) {
		return tntApplicantDao.findById(id);
	}

	public void delete(TbTntApplicant persistentInstance) {
		tntApplicantDao.delete(persistentInstance);
	}

	public void save(TbTntApplicant transientInstance) {
		tntApplicantDao.save(transientInstance);
	}

	public void update(TbTntApplicant persistentInstance) {
		tntApplicantDao.update(persistentInstance);
	}

}
