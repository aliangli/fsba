package com.ulysses.base.view;


public class BallTeamInviteView extends BaseView {
	
	private Long inviteId;
	private Long inviteFromUserId;
	private Long inviteUserId;
	private Long inviteTeamId;
	private String inviteTeamName;
	private String agreeState;
	private String invitePlace;
	private String inviteIp;
	private Integer version;
	
	public Long getInviteId() {
		return inviteId;
	}
	public void setInviteId(Long inviteId) {
		this.inviteId = inviteId;
	}
	public Long getInviteFromUserId() {
		return inviteFromUserId;
	}
	public void setInviteFromUserId(Long inviteFromUserId) {
		this.inviteFromUserId = inviteFromUserId;
	}
	public Long getInviteUserId() {
		return inviteUserId;
	}
	public void setInviteUserId(Long inviteUserId) {
		this.inviteUserId = inviteUserId;
	}
	public Long getInviteTeamId() {
		return inviteTeamId;
	}
	public void setInviteTeamId(Long inviteTeamId) {
		this.inviteTeamId = inviteTeamId;
	}
	public String getInviteTeamName() {
		return inviteTeamName;
	}
	public void setInviteTeamName(String inviteTeamName) {
		this.inviteTeamName = inviteTeamName;
	}
	public String getInvitePlace() {
		return invitePlace;
	}
	public void setInvitePlace(String invitePlace) {
		this.invitePlace = invitePlace;
	}
	public String getInviteIp() {
		return inviteIp;
	}
	public void setInviteIp(String inviteIp) {
		this.inviteIp = inviteIp;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getAgreeState() {
		return agreeState;
	}

	public void setAgreeState(String agreeState) {
		this.agreeState = agreeState;
	}
	
	
}
