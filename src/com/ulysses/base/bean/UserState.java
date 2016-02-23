package com.ulysses.base.bean;

import com.ulysses.base.pojo.TbUser;

/**
 * 用户状态
 *
 */
public class UserState {
	
	private boolean loginState;
	
	private TbUser user;


	public TbUser getUser() {
		return user;
	}

	public void setUser(TbUser user) {
		this.user = user;
	}

	public boolean getLoginState() {
		return loginState;
	}

	public void setLoginState(boolean loginState) {
		this.loginState = loginState;
	}
	

}
