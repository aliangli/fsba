package com.ulysses.base.pojo;

import java.util.Date;

/**
 * 关注球队
 */

public class TbPlayerFocusTeam implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private Long userId;
	private Long teamId;
	private String teamName;
	private Date focusDate;
	private String isValid;
	private String remark;

	// Constructors

	/** default constructor */
	public TbPlayerFocusTeam() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public Date getFocusDate() {
		return this.focusDate;
	}

	public void setFocusDate(Date focusDate) {
		this.focusDate = focusDate;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}