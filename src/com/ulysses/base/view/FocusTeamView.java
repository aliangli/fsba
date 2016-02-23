package com.ulysses.base.view;

import java.util.Date;

public class FocusTeamView extends BaseView {

	private Long focusId;
	private Long userId;
	private Long teamId;
	private String teamName;
	
	private Date focusDate;
	private String isValid;
	private String remark;

	// Constructors

	/** default constructor */
	public FocusTeamView() {
	}


	public Long getFocusId() {
		return focusId;
	}


	public void setFocusId(Long focusId) {
		this.focusId = focusId;
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
