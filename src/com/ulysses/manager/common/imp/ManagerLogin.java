package com.ulysses.manager.common.imp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ulysses.base.bean.UserState;
import com.ulysses.base.pojo.TbUser;
import com.ulysses.manager.bean.ManagerUserState;
import com.ulysses.manager.common.IManagerLogin;
import com.ulysses.manager.pojo.TbManagerUser;
import com.ulysses.manager.service.IManagerUserService;
import com.ulysses.manager.view.ManagerUserView;
import com.ulysses.util.ec.Des3;

@Service
public class ManagerLogin implements IManagerLogin {
	
	@Autowired
	IManagerUserService managerUserService;

	public ManagerUserState login(ManagerUserView view) {
		ManagerUserState state = new ManagerUserState();
		TbManagerUser userInstance = new TbManagerUser();
		userInstance.setUserName(view.getUserName());
		
		try {
			userInstance.setUserPassword(Des3.encode(view.getUserPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		List userArrs = managerUserService.findByExample(userInstance);
		if (userArrs.size() == 0) {
			state.setLoginState(false);
		}else if(userArrs.size() == 1 ){
			
			Object obj = userArrs.get(0);
			TbManagerUser user = null;
			if(obj instanceof TbManagerUser){
				user = (TbManagerUser) obj;
			}
			state.setManagerUser(user);
			state.setLoginState(true);
			
		}else {
			state.setLoginState(false);
		}
		
		return state;
	}

	public TbManagerUser nowUser(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Object object = session.getAttribute(session.getId());
		
		TbManagerUser user = null;
		if(object instanceof TbManagerUser){
			user = (TbManagerUser) object;
		}
		
		return user;
	}

	public String terminalIP(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

}
