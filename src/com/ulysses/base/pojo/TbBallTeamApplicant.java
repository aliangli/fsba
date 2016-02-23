package com.ulysses.base.pojo;

import java.util.Date;

/**
 * TbBallTeamApplicant entity. @author MyEclipse Persistence Tools
 */

public class TbBallTeamApplicant implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
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

	// Constructors

	/** default constructor */
	public TbBallTeamApplicant() {
	}

	/** minimal constructor */
	public TbBallTeamApplicant(Long applicantFromUserId, Long applicantTeamId,
			String applicantTeamName, String applicantIp) {
		this.applicantFromUserId = applicantFromUserId;
		this.applicantTeamId = applicantTeamId;
		this.applicantTeamName = applicantTeamName;
		this.applicantIp = applicantIp;
	}

	/** full constructor */
	public TbBallTeamApplicant(Long applicantFromUserId, Long applicantTeamId,
			String applicantTeamName, String applicantPlace,
			String applicantIp, String isOfficialTeam, String approveState,
			String isDisband, Date createDate, Long createUserId,
			Date updateDate, Long updateUserId, Long orderBy,
			String deleteState, Date deleteDate, String isValid,
			Integer version) {
		this.applicantFromUserId = applicantFromUserId;
		this.applicantTeamId = applicantTeamId;
		this.applicantTeamName = applicantTeamName;
		this.applicantPlace = applicantPlace;
		this.applicantIp = applicantIp;
		this.isOfficialTeam = isOfficialTeam;
		this.approveState = approveState;
		this.isDisband = isDisband;
		this.createDate = createDate;
		this.createUserId = createUserId;
		this.updateDate = updateDate;
		this.updateUserId = updateUserId;
		this.orderBy = orderBy;
		this.deleteState = deleteState;
		this.deleteDate = deleteDate;
		this.isValid = isValid;
		this.version = version;
	}

	// Property accessors

	public Long getApplicantId() {
		return this.applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public Long getApplicantFromUserId() {
		return this.applicantFromUserId;
	}

	public void setApplicantFromUserId(Long applicantFromUserId) {
		this.applicantFromUserId = applicantFromUserId;
	}

	public Long getApplicantTeamId() {
		return this.applicantTeamId;
	}

	public void setApplicantTeamId(Long applicantTeamId) {
		this.applicantTeamId = applicantTeamId;
	}

	public String getApplicantTeamName() {
		return this.applicantTeamName;
	}

	public void setApplicantTeamName(String applicantTeamName) {
		this.applicantTeamName = applicantTeamName;
	}

	public String getAgreeState() {
		return agreeState;
	}

	public void setAgreeState(String agreeState) {
		this.agreeState = agreeState;
	}

	public String getApplicantPlace() {
		return this.applicantPlace;
	}

	public void setApplicantPlace(String applicantPlace) {
		this.applicantPlace = applicantPlace;
	}

	public String getApplicantIp() {
		return this.applicantIp;
	}

	public void setApplicantIp(String applicantIp) {
		this.applicantIp = applicantIp;
	}

	public String getIsOfficialTeam() {
		return this.isOfficialTeam;
	}

	public void setIsOfficialTeam(String isOfficialTeam) {
		this.isOfficialTeam = isOfficialTeam;
	}

	public String getApproveState() {
		return this.approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}

	public String getIsDisband() {
		return this.isDisband;
	}

	public void setIsDisband(String isDisband) {
		this.isDisband = isDisband;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Long getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(Long orderBy) {
		this.orderBy = orderBy;
	}

	public String getDeleteState() {
		return this.deleteState;
	}

	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}

	public Date getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Integer getVersion() {
		return this.version;
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