package com.ulysses.base.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.dao.IBallTeamDAO;
import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.pojo.TbBallTeamApplicant;
import com.ulysses.base.pojo.TbBallTeamRef;
import com.ulysses.base.services.IBallTeamApplicantServices;
import com.ulysses.base.services.IBallTeamRefServices;
import com.ulysses.base.services.IBallTeamServices;
import com.ulysses.base.services.IBasketballPlayerServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonUploadFile;
import com.ulysses.base.services.common.IConfigItem;
import com.ulysses.base.sv.IBallTeamValidate;
import com.ulysses.base.view.BallTeamRefView;
import com.ulysses.base.view.BallTeamView;
import com.ulysses.base.view.UserView;
import com.ulysses.util.UtilString;

/**
 * 球队Service
 */
@Transactional
@Service
public class BallTeamServices implements IBallTeamServices, ICommonConstant {

	@Autowired
	ICommonExec common;

	@Autowired
	ICommonUploadFile uploadFile;
	
	@Autowired
	IConfigItem config;
	
	@Autowired
	IBallTeamDAO ballTeamDAO;
	
	@Autowired
	IBallTeamRefServices ballTeamRefServices;

	@Autowired
	IBallTeamApplicantServices teamApplicantService;
	
	@Autowired
	IBasketballPlayerServices playerServices;
	
	@Autowired
	IBallTeamValidate ballTeamValidate;


	/**
	 * 用户创建的球队收到的所有申请记录
	 */
	public Map<String, Object> applicantAllTeam(BallTeamView view) {
		TbBallTeam team = new TbBallTeam();
		team.setCreateUserId(view.getNowUserId());
		List arr = ballTeamDAO.applicantAllTeam(team);
		
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		return jsonMap;
	}


	/**
	 *   球队ID 和 解散状态  来查询球队信息
	 * 
	 */
	public List findTeamDisband(TbBallTeam team) {
		return ballTeamDAO.findTeamDisband(team);
	}

	
	/**
	 * 退出球队
	 */
	public Map<String, Object> exitTeam(BallTeamView view) {
		if(view.getTeamId() == null || view.getTeamId() == 0){
			return common.forbid();
		}

		TbBallTeamRef teamRef = new TbBallTeamRef();
		teamRef.setTeamId(view.getTeamId());
		teamRef.setBallPlayerId(view.getNowUserId());

		TbBallTeam team = new TbBallTeam();
		team.setId(view.getTeamId());
		team.setCreateUserId(view.getNowUserId());
		
		//1 当前用户是否为球队的创建者
		List teamArr = this.isMyTeam(team);
		if(teamArr.size() > 0){
			return common.forbid();
		}
		
		//球队关系数据
		List teamRefArr = ballTeamRefServices.findTeamRef(teamRef);
		if(teamRefArr.size() > 0){
			Long refId = ((TbBallTeamRef)teamRefArr.get(0)).getId();
			// 设置队员关系的删除状态
			teamRef.setId(refId);
			teamRef.setDeleteState(STATE_Y);
			ballTeamRefServices.editTeamRefDelete(teamRef);
			
			return common.success();
		}
		
		return common.fail();
	}

	/**
	 * 解散球队
	 * @param view
	 * @return
	 */
	public Map<String, Object> disbandTeam(BallTeamView view) {
		

		TbBallTeam team = new TbBallTeam();
		team.setId(view.getTeamId());
		team.setCreateUserId(view.getNowUserId());
		
		//1 当前用户是否为球队的创建者
		List teamArr = this.isMyTeam(team);
		if(teamArr.size() > 0){

			//1.1 设置球队为解散状态
			TbBallTeam tempTeam = (TbBallTeam)teamArr.get(0);
			tempTeam.setIsDisband(STATE_Y);
			tempTeam.setUpdateDate(new Date());
			tempTeam.setUpdateUserId(view.getNowUserId());
			ballTeamDAO.update(tempTeam);

			//1.2 设置球队所有申请信息的解散状态
			TbBallTeamApplicant applicant = new TbBallTeamApplicant();
			applicant.setApplicantTeamId(view.getTeamId());
			applicant.setIsDisband(STATE_Y);
			teamApplicantService.editTeamDisband(applicant);
			
			//1.3 设置队员关系的解散状态
			TbBallTeamRef teamRef = new TbBallTeamRef();
			teamRef.setTeamId(view.getTeamId());
			teamRef.setIsDisband(STATE_Y);
			ballTeamRefServices.editTeamRefDisband(teamRef);
			
			
			return common.success();
		} 
		
		return common.fail();
		
	}


	/**
	 * 加入的球队
	 */
	public Map<String, Object> findByUserId(UserView view) {

		List arr = ballTeamDAO.findByUserId(view, view.getPage(TEAM_SIZE));
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr);
		return jsonMap;
	}
	
	
	/**
	 * 创建的球队
	 */
	public Map<String, Object> findByTeamCreateUserId(UserView view) {
		List arr = ballTeamDAO.findByTeamCreateUserId(view, view.getPage(TEAM_SIZE));
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr);
		return jsonMap;
	}


	/**
	 * 根据球队ID 获取球队的所有队员信息
	 */
	public List allBallPlayerByTeam(Long teamId) {
		return playerServices.allBallPlayerByTeam(teamId);
	}

	/**
	 * 根据球队名称查找球队  , 非like
	 */
	public List findByTeamName(String teamName) {
		return ballTeamDAO.findByTeamNameCheck(teamName);
	}

	public List findByTeamNotContain(TbBallTeam team) {
		return ballTeamDAO.findByTeamNotContain(team);
	}
	
	/**
	 * 搜索球队 By 球队名称
	 */
	public List findByTeamNameLike(BallTeamView view) {
		
		TbBallTeam team = new TbBallTeam();
		team.setTeamName(view.getTeamName());
		
		return ballTeamDAO.findByTeamNameLike(team, view.getPage(50));
	}


	/**
	 * 创建球队
	 */
	public Map<String, Object> save(BallTeamView view, HttpServletRequest request) {

		//创建球队数据验证
		Map<String, Object> validState = ballTeamValidate.saveValidate(view);
		if(validState != null){
			return validState;
		}

		//球队头像文件名
		String imagePath = this.getTeamLogo(request);

		TbBallTeam team = new TbBallTeam();
		team.setCreateUserId(view.getNowUserId());
		team.setUpdateUserId(view.getNowUserId());
		
		this.setTeamView(team, view);
		
		
		team.setTeamPopulation(1);//球队人数
		team.setTeamPhotoPath(imagePath);//球队头像文件名
		
		team.setIsOfficialTeam(STATE_N);
		team.setApproveState(STATE_N);
		team.setIsDisband(STATE_N);
		
		Date now = new Date();
		team.setCreateDate(now);
		team.setUpdateDate(now);
		team.setDeleteState(STATE_N);
		team.setIsValid(STATE_Y);
		team.setVersion(1);
		team.setOrderBy(100L);

		team.setTeamBirthdate(now);//球队创建时间
		
		//保存球队信息创建
		ballTeamDAO.save(team);
		
		BallTeamRefView teamRefView = new BallTeamRefView();
		teamRefView.setNowUserId(view.getNowUserId());
		teamRefView.setTeamId(team.getId());
		teamRefView.setBallPlayerId(team.getCreateUserId());
		
		
		//让创建人和所创建的球队建立关系
		return ballTeamRefServices.addPlayer(teamRefView);
	}
	
	
	private String getTeamLogo(HttpServletRequest request) {
		//球队头像文件名
		String imagePath = null;
		try {
			//上传球队头像
			imagePath = uploadFile.updateFile(request, config.getTeamPhotoPath());
			
			if(imagePath == null){
				imagePath = config.getTeamDefaultPhoto();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return imagePath;
	}


	private void setTeamView(TbBallTeam team, BallTeamView view) {

		team.setTeamName(view.getTeamName());
		team.setTeamOccupant(view.getTeamOccupant());
		team.setTeamCoach(view.getTeamCoach());//教练
		team.setTeamChineseName(view.getTeamChineseName());
		team.setTeamEnglishName(view.getTeamEnglishName());
		team.setTeamNationality(view.getTeamNationality());
		team.setTeamCity(view.getTeamCity());
		team.setTeamDeclaration(view.getTeamDeclaration());//球队宣言
		team.setChampionNumber(view.getChampionNumber());
		team.setTeamHonour(view.getTeamHonour());
		team.setTeamRemark(view.getTeamRemark());
		team.setSportswearColor(view.getSportswearColor());  //球衣颜色
		
	}


	/**
	 * 修改球队
	 */
	public Map<String, Object> update(BallTeamView view, HttpServletRequest request) {
		
		//版本号不能为空
		if(UtilString.isEmptyR(view.getVersion())){
			return common.noRational();
		}
		
		//球队名称不能为空
		if(UtilString.isEmptyR(view.getTeamName())){
			return common.teamName();
		}
		
		TbBallTeam team = this.findById(view.getTeamId());

		//验证版本号是否已更新, 已更新则提示请刷新数据再更新
		if(team.getVersion().equals(view.getVersion())){
			team.setVersion(team.getVersion()+1); //版本更新
		}else {
			return common.newVersion();
		}
		
		//球队有效
		if(team.getIsDisband().equals(STATE_N) || team.getDeleteState().equals(STATE_Y)){
			return common.forbid();
		}
		
		
		team.setTeamName(view.getTeamName());
		

		//球队名是否被注册
		List arr = this.findByTeamNotContain(team );
		if(arr.size() > 0){
			return common.teamNameExist();
		}


		//球队头像文件名
		String imagePath = this.getTeamLogo(request);
		team.setTeamPhotoPath(imagePath);
		
		team.setUpdateUserId(view.getUpdateUserId());
		
		this.setTeamView(team, view);
		
		Date now = new Date();
		team.setUpdateDate(now);

		ballTeamDAO.update(team);
		
		
		return common.success();
	}

	public void delete(TbBallTeam persistentInstance) {
		// TODO Auto-generated method stub

	}

	public List findAll() {
		return ballTeamDAO.findAllCheck();
	}

	public List findByExample(TbBallTeam instance) {
		return ballTeamDAO.findByExample(instance);
	}

	public TbBallTeam findById(Long id) {
		return ballTeamDAO.findById(id);
	}

	public List findByIsValid(Object isValid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByTeamChineseName(Object teamChineseName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByTeamCoach(Object teamCoach) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByTeamEnglishName(Object teamEnglishName) {
		// TODO Auto-generated method stub
		return null;
	}


	public List findByTeamNationality(Object teamNationality) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByTeamOccupant(Object teamOccupant) {
		// TODO Auto-generated method stub
		return null;
	}

	public TbBallTeam merge(TbBallTeam detachedInstance) {
		// TODO Auto-generated method stub
		return ballTeamDAO.merge(detachedInstance);
	}

	
	/**
	 * 某用户创建的球队 By 用户ID and 球队ID
	 */
	public List isMyTeam(TbBallTeam team) {
		return ballTeamDAO.isMyTeam(team);
	}


}
