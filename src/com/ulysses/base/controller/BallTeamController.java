package com.ulysses.base.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.pojo.TbBallTeam;
import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IBallTeamServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.BallTeamView;
import com.ulysses.base.view.UserView;
import com.ulysses.util.UtilString;

/**
 * 球队
 *
 */
@Controller
@RequestMapping(value = "ballTeamController")
public class BallTeamController   implements ICommonConstant{
	
	@Autowired
	ICommonLoginExec commonLogin;

	@Autowired
	ICommonExec common;
	
	@Autowired
	IBallTeamServices ballTeamServices;

	
	/**
	 * 退出球队
	 */
	@RequestMapping(value = "exitTeam", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> exitTeam(BallTeamView view, HttpServletRequest request) {
		
		if (!"exitTeam".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		} else {
			view.setNowUserId(user.getId());
			return ballTeamServices.exitTeam(view);
		}
		
		
		
	}
	
	
	/**
	 * 解散球队
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "disbandTeam", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> disbandTeam(BallTeamView view, HttpServletRequest request) {
		
		if (!"disbandTeam".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		
		if (user == null) {
			return common.goLogin();
		} else {
			Long id = user.getId();
			view.setNowUserId(id);
			return ballTeamServices.disbandTeam(view);
		}
		
		
		
	}
	
	/**
	 * 创建球队
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "createTeam", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> createTeam(BallTeamView view, HttpServletRequest request) {
		if (!"createTeam".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		Long id = user.getId();
		view.setNowUserId(id);
		return ballTeamServices.save(view, request);
		
		
	}
	
	/**
	 * 修改球队 
	 * @param view 必传球队teamId
	 * @return
	 */
	@RequestMapping(value = "updateTeam", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateTeam(BallTeamView view, HttpServletRequest request) {
		
		if (!"updateTeam".equals(view.getActionType()) || UtilString.isEmptyRC(view.getTeamId())  ) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);

		if (user == null) {
			return common.goLogin();
		} else {
			Long id = user.getId();
			view.setUpdateUserId(id);
			return ballTeamServices.update(view, request);
		}
		
		
	}
	
	
	/**
	 * 用户创建的球队收到的所有申请记录
	 */
	@RequestMapping(value = "applicantAllTeam", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> applicantAllTeam(BallTeamView view, HttpServletRequest request) {
		if (!"applicantAllTeam".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		view.setNowUserId(user.getId());
		Map<String, Object> jsonMap = ballTeamServices.applicantAllTeam(view );
		return jsonMap;
	}

	/**
	 * 搜索球队 By 球队名称
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "findByTeamName", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findByTeamName(BallTeamView view, HttpServletRequest request) {
		if (!"findByTeamName".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		List arr = ballTeamServices.findByTeamNameLike(view );
		
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
	}
	
	/**
	 * 加入的球队
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "teamByUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> teamByUser(UserView view, HttpServletRequest request) {
		
		if (!"teamByUser".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
		
		Long id = user.getId();
		if(UtilString.isEmptyR(view.getUserId() )){
			view.setUserId(id);
		}

		return ballTeamServices.findByUserId(view);
	}
	
	/**
	 * 创建的球队
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "findCreateTeams", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findCreateTeams(UserView view, HttpServletRequest request) {
		
		if (!"createTeams".equals(view.getActionType()) || view.getPageNumber() < 0) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		TbUser user = commonLogin.nowUser(request);
		if (user == null) {
			return common.goLogin();
		}
	
		Long id = user.getId();
		if(UtilString.isEmptyR(view.getUserId() )){
			view.setUserId(id);
		}
		
		return ballTeamServices.findByTeamCreateUserId(view);
	}
	
	/**
	 * 根据球队ID 获取球队详细信息
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "byTeamID", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> byTeamID(BallTeamView view, HttpServletRequest request) {
		if (!"findTeam".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		if (commonLogin.nowUser(request) == null) {
			return common.goLogin();
		}
		
		Long id = view.getTeamId();
		TbBallTeam ballTeam = ballTeamServices.findById(id);
		
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, ballTeam);
		
		return jsonMap;
	}

	/**
	 * 根据球队ID 获取球队的所有队员信息
	 */
	@RequestMapping(value = "allBallPlayer", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> allBallPlayer(BallTeamView view, HttpServletRequest request) {
		if (!"teamBallPlayer".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//未登录或者超时失效则返回NULL
		if (commonLogin.nowUser(request) == null) {
			return common.goLogin();
		}
		
		List arr = ballTeamServices.allBallPlayerByTeam(view.getTeamId());

		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr);
		
		return jsonMap;
	}
	
	
	/**
	 * 获取所有球队
	 * @param view
	 * @return
	 
	@RequestMapping(value = "all", method = RequestMethod.POST)
	@ResponseBody*/
	public Map<String, Object> all(BallTeamView view, HttpServletRequest request) {
		if (!"allTeam".equals(view.getActionType())) {
			return common.noRational();
		}

		//未登录或者超时失效则返回NULL
		if (commonLogin.nowUser(request) == null) {
			return common.goLogin();
		}
		
		List arr = ballTeamServices.findAll();
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr);
		
		return jsonMap;
	}
	
	
}
