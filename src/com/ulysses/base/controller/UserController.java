package com.ulysses.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.bean.UserState;
import com.ulysses.base.constants.CodeConstants;
import com.ulysses.base.pojo.TbBasketballPlayer;
import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IBasketballPlayerServices;
import com.ulysses.base.services.IFSBAUserServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.services.common.ICommonUploadFile;
import com.ulysses.base.services.common.IConfigItem;
import com.ulysses.base.view.UserView;
import com.ulysses.util.UtilString;

/**
 * 用户信息处理
 *
 */
@Controller
@RequestMapping(value = "fsbaUserController")
public class UserController implements ICommonConstant {


	@Autowired
	IConfigItem config;
	
	@Autowired
	ICommonLoginExec commonLogin;

	@Autowired
	ICommonExec common;

	@Autowired
	IBasketballPlayerServices basketballPlayerServices;

	@Autowired
	IFSBAUserServices userServices;

	@Autowired
	ICommonUploadFile uploadFile;
	
	/**
	 * 所有用户
	 * @param userView
	 * @return
	 
	@RequestMapping(value = "findAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findAll(FSBAUserViewParam userView) {

		jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", fsbaUserServices.getCount());// total键 存放总记录数，必须的
		jsonMap.put("rows", fsbaUserServices.findAll());// rows键 存放每页记录 list
		return jsonMap;
	}*/

	/**
	 * 注册用户
	 * @param userView
	 * @return
	 */
	@RequestMapping(value = "regeditUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> regeditUser(UserView view) {

		if (!"regeditUser".equals(view.getActionType())) {
			return common.noRational();
		}

		TbUser user = new TbUser();
		user.setUserName(view.getUserName());
		user.setAliasName(view.getUserName()); //别名
		user.setUserPassword(view.getUserPassword());
		user.setUserPhoneNumber(view.getUserPhoneNumber());
		user.setUserPhotoPath(config.getUserDefaultPhoto());//用户默认头像文件名

		return userServices.save(user);
	}
	
	/*
	 
			//密码不能为空
			if(UtilString.isEmptyR(view.getUserPassword())){
				return common.pwdNull();
			}

			//密码包含空格
			if(StringUtils.containsWhitespace(view.getUserPassword())){
				return common.pwdContainSpace();
			}
	*/
	
	/**
	 * 修改用户资料
	 * @param userView
	 * @return
	 */
	@RequestMapping(value = "alter", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> alter(UserView view, HttpServletRequest request) {
		
		TbUser user = commonLogin.nowUser(request);

		if (user == null) {
			return common.goLogin();
		} 
		
		if (!"alterUser".equals(view.getActionType()) || UtilString.isEmptyRC(user.getId())) {
			return common.noRational();
		}
	
		view.setNowUserId(user.getId());
		
		//验证不能为空-别名昵称
		if(UtilString.isEmptyR(view.getAliasName())){
			return common.aliasNameNull();
		}
		
		//验证昵称是否存在
		List arr = userServices.findByAliasNameNotMe(view.getAliasName(), user.getId());
		if(arr.size() > 0){
			return common.aliasNameExist();
		}
		
		//验证不能为空-性别
		if(UtilString.isEmptyR(view.getUserSex())){
			return common.userSexNull();
		}
		
		//用户名不能为空
		/*if(UtilString.isEmptyR(view.getUserName())){
			return common.nameNull();
		}*/

		//用户名包含空格
		/*if(StringUtils.containsWhitespace(view.getUserName())){
			return common.nameContainSpace();
		}*/
		
		//用户名是否被注册, 除本用户以外
		/*
		if (findNotContainUserName(view).size() > 0 ) {
			return common.nameExist();
		}*/
		

		TbUser userTemp = new TbUser();
		userTemp.setId(view.getNowUserId());
		userTemp.setUserPhoneNumber(view.getUserPhoneNumber());
		
		//手机号是否被注册, 除本用户以外
		if (userServices.findByUserPhoneNumber(userTemp).size() > 0 ) {
			return common.phoneNumberExist();
		}
		
		try {
			//用户头像路径
			String userPhotoPath = uploadFile.updateFile(request, config.getUserLoginPhotoPath());
			if(userPhotoPath == null){
				userPhotoPath = view.getUserPhotoPath();
			}
			view.setUserPhotoPath(userPhotoPath);
		} catch (Exception e) {
			e.printStackTrace();
			return common.fail();
		}
		

		Map<String, Object> jsonMap = userServices.update(view);
		jsonMap.put(USER_PHOTO_PATH, view.getUserPhotoPath() );
		
		return jsonMap;
		
		
	}

	/**
	 * 登录
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "isLogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> isLogin(UserView view, HttpServletRequest request) {
		
		if (!"userLogin".equals(view.getActionType())) {
			return common.noRational();
		}
		
		//获取用户状态对象，包含用户信息及是否通过验证状态
		UserState state = commonLogin.login(view);
		
		if (state.getLoginState() == false) {
			return common.loginFail();
		}
		
		TbUser fsbaUser = state.getUser();
		Long id = fsbaUser.getId();

		//获取登录 用户 的球员卡 信息
		List playerArr = basketballPlayerServices.findByUserId(id);
		TbBasketballPlayer player = new TbBasketballPlayer();
		
		if(playerArr.size() > 0){
			player = (TbBasketballPlayer) playerArr.get(0);
		}

		//当前用户信息存放到session
		HttpSession session = request.getSession();
		session.setAttribute(session.getId(), fsbaUser);

		//System.out.println(UtilDate.getNow() + "  ID:" +session.getId());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(CodeConstants.SESSION_USER, fsbaUser);// 用户信息
		map.put(CodeConstants.PLAYER, player); //用户球员表属性

		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, map);
		
		return this.loadSysConfig(jsonMap);
	
	}

	private Map<String, Object> loadSysConfig(Map<String, Object> jsonMap) {

		jsonMap.put(USER_LOGIN_PHOTO_PATH, config.getUserLoginPhotoPath() );
		jsonMap.put(PERSONAL_NEWS_PATH, config.getPersonalNewsPath() );
		jsonMap.put(TEAM_PHOTO_FOLDER, config.getTeamPhotoPath() );
		jsonMap.put(MEDAL_PHOTO_FOLDER, config.getMedalPhotoFolder() );
		jsonMap.put(TACTIC_PHOTO_FOLDER, config.getTacticPhotoFolder() );
		jsonMap.put(AREAN_PHOTO_FOLDER, config.getAreanPhotoFolder() );
		jsonMap.put(MEDAL_ALL, MEDAL_ALL_BODY );
		return jsonMap;
	}

}
