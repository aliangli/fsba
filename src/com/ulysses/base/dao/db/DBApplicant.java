package com.ulysses.base.dao.db;

import java.util.Date;

public class DBApplicant {

	private Long applicantId;
	private Long applicantFromUserId;
	private String applicantFromAliasName;
	private Long applicantTeamId;
	private String applicantTeamName;
	private String applicantPlace;
	private String applicantIp;
	private String isOfficialTeam;
	private String agreeState;
	private String approveState;
	private String isDisband;
	private Date createDate;
	private Long createUserId;
	private Date updateDate;
	private Long updateUserId;
	private Long orderBy;
	private String deleteState;
	private Date deleteDate;
	private String isValid;
	private Integer version;
	
	public DBApplicant(){}
	
	public DBApplicant(Long applicantId, Long applicantFromUserId,String applicantFromAliasName,
			Long applicantTeamId, String applicantTeamName, Integer version) {
		super();
		this.applicantId = applicantId;
		this.applicantFromUserId = applicantFromUserId;
		this.applicantFromAliasName = applicantFromAliasName;
		this.applicantTeamId = applicantTeamId;
		this.applicantTeamName = applicantTeamName;
		this.version = version;
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
	public String getIsDisband() {
		return isDisband;
	}
	public void setIsDisband(String isDisband) {
		this.isDisband = isDisband;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Long getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Long getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Long orderBy) {
		this.orderBy = orderBy;
	}
	public String getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getApplicantFromAliasName() {
		return applicantFromAliasName;
	}

	public void setApplicantFromAliasName(String applicantFromAliasName) {
		this.applicantFromAliasName = applicantFromAliasName;
	}
	
	
}
