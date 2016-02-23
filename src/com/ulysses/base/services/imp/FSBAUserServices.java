package com.ulysses.base.services.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ulysses.base.bean.UserState;
import com.ulysses.base.dao.IUserDao;
import com.ulysses.base.pojo.TbBasketballPlayer;
import com.ulysses.base.pojo.TbFocus;
import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IBasketballPlayerServices;
import com.ulysses.base.services.IFSBAUserServices;
import com.ulysses.base.services.IFocusServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.UserView;
import com.ulysses.util.UtilDate;
import com.ulysses.util.UtilMD5;
import com.ulysses.util.UtilString;
import com.ulysses.util.ec.Des3;

@Transactional
@Service
public class FSBAUserServices implements IFSBAUserServices, ICommonConstant  {

	@Autowired
	ICommonExec common;
	
	@Autowired
	ICommonLoginExec loginExec;

	@Autowired
	IBasketballPlayerServices basketballPlayerServices;

	@Autowired
	IFocusServices focusServices;
	
	@Autowired
	IUserDao userDao;
	

	/**
	 * 查询有效用户
	 */
	public List findByExample(TbUser user) {
		user.setIsValid(STATE_Y);//有效
		user.setDeleteState(STATE_N);//未删除
		return userDao.findByExample(user);
	}
	
	/**
	
		user.setUserPassword(view.getUserPassword());
		try {
			//密码加密保存
			String pwd = Des3.encode(view.getUserPassword());
			user.setUserPassword(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	 */
	
	
	/**
	 * 修改用户信息
	 */
	public Map<String, Object> update(UserView view) {
		
		//判断数据版本
		/*if(!user.getVersion().equals(view.getVersion())){
			return common.version();
		}*/

		
		TbUser user = userDao.findById(view.getNowUserId());

		user.setUserPhoneNumber(view.getUserPhoneNumber());
		//用户头像图片路径
		user.setUserPhotoPath(view.getUserPhotoPath());

		//暂时不支持修改用户名
//		user.setUserName(view.getUserName());
		
		//user.setChineseName(view.getChineseName());
		//user.setEnglishName(view.getEnglishName());
		user.setAliasName(view.getAliasName());//用户昵称
		user.setUserSex(view.getUserSex());
		user.setUserDeclaration(view.getUserDeclaration());
		
		user.setNationality(view.getNationality());
		user.setBirthpace(view.getBirthpace());
		user.setBirthdate(UtilDate.parse(view.getBirthdate()));
		user.setGraduateSchool(view.getGraduateSchool());
		user.setStature(view.getStature());
		user.setWeight(view.getWeight());
		
		user.setUserAddress(view.getUserAddress());
		user.setUserCity(view.getUserCity());
		
		Date now = new Date();
		user.setUpdateDate(now);
		user.setVersion(user.getVersion() + 1);
		
		userDao.update(user);
		
		//修改球员属性信息
		List playerArr = basketballPlayerServices.findByUserId(view.getNowUserId());

		TbBasketballPlayer transientInstance = null;
		if(playerArr.size() > 0){
			Object obj = playerArr.get(0);
			if(obj instanceof TbBasketballPlayer){
				transientInstance = (TbBasketballPlayer)obj;

				transientInstance.setBestMark(view.getBestMark());
				transientInstance.setUniformNumber(view.getUniformNumber());
				transientInstance.setArmLength(view.getArmLength());
				transientInstance.setRelaxHeight(view.getRelaxHeight());
				transientInstance.setJumpHeight(view.getJumpHeight());
				transientInstance.setLungeHeight(view.getLungeHeight());
			}
		}

		if(transientInstance != null){
			basketballPlayerServices.update(transientInstance);
		}
		
		
		return common.success();
	}

	/**
	 * 注册用户
	 */
	public Map<String, Object> save(TbUser userInstance) {
		

		//用户名不能为空
		if(UtilString.isEmptyR(userInstance.getUserName())){
			return common.nameNull();
		}
		
		//密码不能为空
		if(UtilString.isEmptyR(userInstance.getUserPassword())){
			return common.pwdNull();
		}

		//用户名包含空格
		if(StringUtils.containsWhitespace(userInstance.getUserName())){
			return common.nameContainSpace();
		}
		
		//密码包含空格
		if(StringUtils.containsWhitespace(userInstance.getUserPassword())){
			return common.pwdContainSpace();
		}
		
		//用户名是否被注册
		if (isRegeditName(userInstance.getUserName())) {
			return common.nameExist();
		}
		
		//手机号是否被注册
		if (isRegeditPhoneNumber(userInstance.getUserPhoneNumber())) {
			return common.phoneNumberExist();
		}
		
		
		try {
			
			//密码加密保存
			String pwd = Des3.encode(userInstance.getUserPassword());
			userInstance.setUserPassword(pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		userInstance.setChineseName(userInstance.getUserName());//中文名默认用户注册名
		userInstance.setEnglishName(userInstance.getUserName());//英文名默认用户注册名
		
		Date now = new Date();
		userInstance.setCreateDate(now);
		userInstance.setRegeditDate(now);
		userInstance.setUpdateDate(now);
		userInstance.setDeleteState(STATE_N);
		userInstance.setIsValid(STATE_Y);
		userInstance.setVersion(1);
		
		userDao.save(userInstance);
		
		//球员属性表初始化
		TbBasketballPlayer transientInstance = new TbBasketballPlayer();
		transientInstance.setUserId(userInstance.getId());
		transientInstance.setAttackDegree(0);
		transientInstance.setDefendDegree(0);
		transientInstance.setHitDegree(0);
		transientInstance.setTalentDegree(0);
		transientInstance.setPassionDegree(0);
		transientInstance.setLivelyDegree(0);
		transientInstance.setDynamicCount(0);
		transientInstance.setFocusCount(0);
		transientInstance.setGoalFocusCount(0);
		transientInstance.setPlayerIntegrate(0);
		
		transientInstance.setBestMark(0);
		transientInstance.setUniformNumber(0);
		transientInstance.setArmLength(0);
		transientInstance.setRelaxHeight(0);
		transientInstance.setJumpHeight(0);
		transientInstance.setLungeHeight(0);
		
		basketballPlayerServices.save(transientInstance);
		
		//自己关注自己
		TbFocus focus = new TbFocus();
		focus.setUserId(userInstance.getId());
		focus.setUserFocusId(userInstance.getId());
		focus.setIsValid(STATE_Y);
		focusServices.save(focus);
		
		return common.regeditSuccess();
	}
	
	
	/**
	 * 验证登录后， 返回用户信息和球员表信息
	 */
	public Map<String, Object> isLogin(UserView view) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		UserState state = loginExec.login(view);
		
		if (state.getLoginState() == false) {
			return common.loginFail();
		} else {
			TbUser fsbaUser = state.getUser();
			
			Long id = fsbaUser.getId();
			

			//获取登录 用户 的球员卡 信息
			List playerArr = basketballPlayerServices.findByUserId(id);
			TbBasketballPlayer player = new TbBasketballPlayer();
			
			if(playerArr.size() > 0){
				player = (TbBasketballPlayer) playerArr.get(0);
			}
			
			

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userInfo", fsbaUser);
			map.put("playerInfo", player);

			jsonMap = common.success();
			jsonMap.put(DATA, map);
			
			return jsonMap;

		}
	}
	


	/**
	 * 手机号是否被注册
	 * 
	 * @param userPhoneNumber
	 * @return true 已注册
	 */
	private boolean isRegeditPhoneNumber(String userPhoneNumber) {
		List userArrs = this.findByUserPhoneNumber(userPhoneNumber);
		if (userArrs.size() == 0) {
			return false;
		}

		return true;
	}

	/**
	 * 用户名是否被注册
	 * 
	 * @param userName
	 * @return true 已注册
	 */
	private boolean isRegeditName(String userName) {

		List userArrs = this.findByUserName(userName);
		if (userArrs.size() == 0) {
			return false;
		}

		return true;
	}


	
	
	

	private String createUID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * 不包含此用户名的集合数据
	 */
	public List findNotContainUserName(TbUser instance) {
		return userDao.findNotContainUserName(instance);
	}
	
	/**
	 * 不包含此手机号的用户的集合数据
	 * @param user
	 * @return
	 */
	public List findByUserPhoneNumber(TbUser instance) {
		return userDao.findNotContainUserPhoneNumber(instance);
	}
	
	


	public void delete(TbUser persistentInstance) {
		// TODO Auto-generated method stub

	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return userDao.getCount();
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}


	public TbUser findById(Long id) {
		return userDao.findById(id);
	}

	public List findByIsValid(Object isValid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByUserAddress(Object userAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByUserCity(Object userCity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByUserName(Object userName) {
		return userDao.findByUserName(userName);
	}

	public List findByAliasName(Object aliasName) {
		return userDao.findByAliasName(aliasName);
	}

	public List findByAliasNameNotMe(Object aliasName, Long id) {
		return userDao.findByAliasNameNotMe(aliasName, id);
	}

	public List findByUserPhoneNumber(Object userPhoneNumber) {
		return userDao.findByUserPhoneNumber(userPhoneNumber);
	}

	public List findByVersion(Object version) {
		// TODO Auto-generated method stub
		return null;
	}

	public TbUser merge(TbUser detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
