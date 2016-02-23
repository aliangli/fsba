package com.ulysses.manager.bean;

import com.ulysses.manager.pojo.TbManagerUser;

public class ManagerUserState {

	private boolean loginState;
	private TbManagerUser managerUser;
	
	public ManagerUserState(){}
	
	public boolean getLoginState() {
		return loginState;
	}
	public void setLoginState(boolean loginState) {
		this.loginState = loginState;
	}
	public TbManagerUser getManagerUser() {
		return managerUser;
	}
	public void setManagerUser(TbManagerUser managerUser) {
		this.managerUser = managerUser;
	}
	
	
}
