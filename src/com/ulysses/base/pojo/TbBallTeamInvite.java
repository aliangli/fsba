package com.ulysses.base.pojo;

import java.util.Date;

/**
 * TbBallTeamInvite entity. @author MyEclipse Persistence Tools
 */

public class TbBallTeamInvite implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long inviteId;
	private Long inviteFromUserId;
	private Long inviteUserId;
	private Long inviteTeamId;
	private String inviteAliasName;
	private String inviteTeamName;
	private String invitePlace;
	private String inviteIp;
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
	public TbBallTeamInvite() {
	}

	/** minimal constructor */
	public TbBallTeamInvite(Long inviteFromUserId, Long inviteUserId,
			Long inviteTeamId, String inviteTeamName, String inviteIp) {
		this.inviteFromUserId = inviteFromUserId;
		this.inviteUserId = inviteUserId;
		this.inviteTeamId = inviteTeamId;
		this.inviteTeamName = inviteTeamName;
		this.inviteIp = inviteIp;
	}

	/** full constructor */
	public TbBallTeamInvite(Long inviteFromUserId, Long inviteUserId,
			Long inviteTeamId, String inviteTeamName, String invitePlace,
			String inviteIp, String isOfficialTeam, String approveState,
			String isDisband, Date createDate, Long createUserId,
			Date updateDate, Long updateUserId, Long orderBy,
			String deleteState, Date deleteDate, String isValid,
			Integer version) {
		this.inviteFromUserId = inviteFromUserId;
		this.inviteUserId = inviteUserId;
		this.inviteTeamId = inviteTeamId;
		this.inviteTeamName = inviteTeamName;
		this.invitePlace = invitePlace;
		this.inviteIp = inviteIp;
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

	public Long getInviteId() {
		return this.inviteId;
	}

	public void setInviteId(Long inviteId) {
		this.inviteId = inviteId;
	}

	public Long getInviteFromUserId() {
		return this.inviteFromUserId;
	}

	public void setInviteFromUserId(Long inviteFromUserId) {
		this.inviteFromUserId = inviteFromUserId;
	}

	public Long getInviteUserId() {
		return this.inviteUserId;
	}

	public void setInviteUserId(Long inviteUserId) {
		this.inviteUserId = inviteUserId;
	}

	public String getAgreeState() {
		return agreeState;
	}

	public void setAgreeState(String agreeState) {
		this.agreeState = agreeState;
	}

	public Long getInviteTeamId() {
		return this.inviteTeamId;
	}

	public void setInviteTeamId(Long inviteTeamId) {
		this.inviteTeamId = inviteTeamId;
	}

	public String getInviteTeamName() {
		return this.inviteTeamName;
	}

	public void setInviteTeamName(String inviteTeamName) {
		this.inviteTeamName = inviteTeamName;
	}

	public String getInvitePlace() {
		return this.invitePlace;
	}

	public void setInvitePlace(String invitePlace) {
		this.invitePlace = invitePlace;
	}

	public String getInviteIp() {
		return this.inviteIp;
	}

	public void setInviteIp(String inviteIp) {
		this.inviteIp = inviteIp;
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

	public String getInviteAliasName() {
		return inviteAliasName;
	}

	public void setInviteAliasName(String inviteAliasName) {
		this.inviteAliasName = inviteAliasName;
	}

}