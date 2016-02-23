package com.ulysses.base.services.common.imp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ulysses.base.bean.UserState;
import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.services.IFSBAUserServices;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.UserView;
import com.ulysses.util.ec.Des3;

@Service
public class CommonLoginExec implements ICommonLoginExec {

	@Autowired
	IFSBAUserServices userServices;
	
	/**
	 * 验证登陆
	 * @return true 登录成功     包含用户信息返回
	 */
	public UserState login(UserView param) {
		
		UserState state = new UserState();
		TbUser userInstance = new TbUser();
		userInstance.setUserName(param.getUserName());
		
		try {
			userInstance.setUserPassword(Des3.encode(param.getUserPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		List userArrs = userServices.findByExample(userInstance);
		if (userArrs.size() == 0) {
			state.setLoginState(false);
		}else if(userArrs.size() == 1 ){
			Object obj = userArrs.get(0);
			TbUser user = null;
			if(obj instanceof TbUser){
				user = (TbUser) obj;
			}
			state.setUser(user);
			state.setLoginState(true);
		}else {
			state.setLoginState(false);
		}
		
		return state;
	}

	/**
	 * 获取当前登录的用户
	 * 未登录或者失效则返回NULL
	 */
	public TbUser nowUser(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Object object = session.getAttribute(session.getId());
		
		TbUser user = null;
		if(object instanceof TbUser){
			user = (TbUser) object;
		}		
		
		return user;
	}

	public String terminalIP(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

}
