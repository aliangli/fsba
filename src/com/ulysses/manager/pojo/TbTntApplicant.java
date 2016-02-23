package com.ulysses.manager.pojo;

import java.util.Date;


/**
 * TbTntApplicant entity. @author MyEclipse Persistence Tools
 */

public class TbTntApplicant implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long tntId;
	private Long tntAltId;
	private Long fromUserId;
	private Long altTeamId;
	private String altTeamName;
	private String applicantPlace;
	private String applicantIp;
	private String isOfficialTeam;
	private String agreeState;
	private String approveState;
	private Date createDate;
	private Long createUserId;
	private Date updateDate;
	private Long updateUserId;
	private Long orderBy;
	private String deleteState;
	private Date deleteDate;
	private String isValid;
	private Integer version;

	public TbTntApplicant() {
	}

	public Long getTntId() {
		return this.tntId;
	}

	public void setTntId(Long tntId) {
		this.tntId = tntId;
	}

	public Long getFromUserId() {
		return this.fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public Long getAltTeamId() {
		return this.altTeamId;
	}

	public void setAltTeamId(Long altTeamId) {
		this.altTeamId = altTeamId;
	}

	public String getAltTeamName() {
		return this.altTeamName;
	}

	public void setAltTeamName(String altTeamName) {
		this.altTeamName = altTeamName;
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

	public String getAgreeState() {
		return this.agreeState;
	}

	public void setAgreeState(String agreeState) {
		this.agreeState = agreeState;
	}

	public String getApproveState() {
		return this.approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
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

	public Long getTntAltId() {
		return tntAltId;
	}

	public void setTntAltId(Long tntAltId) {
		this.tntAltId = tntAltId;
	}

}