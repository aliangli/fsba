package com.ulysses.base.view;


public class BallTeamApplicantView  extends BaseView{

	private Long applicantId;
	private Long applicantFromUserId;
	private String applicantFromAliasName;
	private Long applicantTeamId;
	private String applicantTeamName;
	private String applicantPlace;
	private String applicantIp;
	private String agreeState;
	private Integer version;
	
	
	public String getApplicantFromAliasName() {
		return applicantFromAliasName;
	}
	public void setApplicantFromAliasName(String applicantFromAliasName) {
		this.applicantFromAliasName = applicantFromAliasName;
	}
	public Long getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}
	public Long getApplicantFromUserId() {
		return applicantFromUserId;
	}
	public void setApplicantFromUserId(Long applicantFromUserId) {
		this.applicantFromUserId = applicantFromUserId;
	}
	public Long getApplicantTeamId() {
		return applicantTeamId;
	}
	public void setApplicantTeamId(Long applicantTeamId) {
		this.applicantTeamId = applicantTeamId;
	}
	public String getApplicantTeamName() {
		return applicantTeamName;
	}
	public void setApplicantTeamName(String applicantTeamName) {
		this.applicantTeamName = applicantTeamName;
	}
	public String getApplicantPlace() {
		return applicantPlace;
	}
	public void setApplicantPlace(String applicantPlace) {
		this.applicantPlace = applicantPlace;
	}
	public String getApplicantIp() {
		return applicantIp;
	}
	public void setApplicantIp(String applicantIp) {
		this.applicantIp = applicantIp;
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
