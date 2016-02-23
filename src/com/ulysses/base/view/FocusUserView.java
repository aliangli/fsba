package com.ulysses.base.view;


public class FocusUserView  extends BaseView {


	private Long userId;
	private Long userFocusId; //被关注的球员的ID

    private String userName;
    private String userPassword;
    
    
	public Long getUserFocusId() {
		return userFocusId;
	}
	public void setUserFocusId(Long userFocusId) {
		this.userFocusId = userFocusId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
