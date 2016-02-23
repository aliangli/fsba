package com.ulysses.manager.view;

import java.sql.Timestamp;

import com.ulysses.base.view.BaseView;

/**
 * 球队申请参赛
 *
 */
public class TntApplicantView extends BaseView {

	private Long tntId;
	private Long fromUserId;
	private String fromUserAliasName;
	private Long altTeamId;
	private String altTeamName;
	private String applicantPlace;
	private String applicantIp;
	private String isOfficialTeam;
	private String agreeState;
	private String approveState;
	private Timestamp createDate;
	private Long createUserId;
	
	public TntApplicantView(){}

	public Long getTntId() {
		return tntId;
	}

	public void setTntId(Long tntId) {
		this.tntId = tntId;
	}

	public Long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getFromUserAliasName() {
		return fromUserAliasName;
	}

	public void setFromUserAliasName(String fromUserAliasName) {
		this.fromUserAliasName = fromUserAliasName;
	}

	public Long getAltTeamId() {
		return altTeamId;
	}

	public void setAltTeamId(Long altTeamId) {
		this.altTeamId = altTeamId;
	}

	public String getAltTeamName() {
		return altTeamName;
	}

	public void setAltTeamName(String altTeamName) {
		this.altTeamName = altTeamName;
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

	public String getIsOfficialTeam() {
		return isOfficialTeam;
	}

	public void setIsOfficialTeam(String isOfficialTeam) {
		this.isOfficialTeam = isOfficialTeam;
	}

	public String getAgreeState() {
		return agreeState;
	}

	public void setAgreeState(String agreeState) {
		this.agreeState = agreeState;
	}

	public String getApproveState() {
		return approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	
	
}
