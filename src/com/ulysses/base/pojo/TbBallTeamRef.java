package com.ulysses.base.pojo;

import java.util.Date;

/**
 * 球队与队员关系Bean
 */

public class TbBallTeamRef implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long teamId;
	private Long ballPlayerId;

	private String approveState;
	private String isDisband;
	
	private String remark;
	private Date createDate;
	private Long createUserId;
	private Date updateDate;
	private Long updateUserId;
	private Long orderBy;
	private String isDetach;
	private String deleteState;
	private Date deleteDate;
	private String isValid;
	private Integer version;

	// Constructors

	/** default constructor */
	public TbBallTeamRef() {
	}

	/** minimal constructor */
	public TbBallTeamRef(Long teamId, Long ballPlayerId) {
		this.teamId = teamId;
		this.ballPlayerId = ballPlayerId;
	}

	/** full constructor */
	public TbBallTeamRef(Long teamId, Long ballPlayerId, String remark,
			Date createDate, Date updateDate, Long orderBy,
			String deleteState, Date deleteDate, String isValid,
			Integer version) {
		this.teamId = teamId;
		this.ballPlayerId = ballPlayerId;
		this.remark = remark;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.orderBy = orderBy;
		this.deleteState = deleteState;
		this.deleteDate = deleteDate;
		this.isValid = isValid;
		this.version = version;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public Long getBallPlayerId() {
		return this.ballPlayerId;
	}

	public void setBallPlayerId(Long ballPlayerId) {
		this.ballPlayerId = ballPlayerId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public String getIsDetach() {
		return isDetach;
	}

	public void setIsDetach(String isDetach) {
		this.isDetach = isDetach;
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

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

}