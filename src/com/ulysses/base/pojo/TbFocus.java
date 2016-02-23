package com.ulysses.base.pojo;

import java.util.Date;


/**
 * 关注Bean
 */

public class TbFocus implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long userId;
	private Long userFocusId;
	private Date focusDate;

	private String isValid;
	private String remark;

	// Constructors

	/** default constructor */
	public TbFocus() {
	}

	// Property accessors

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

	public Long getUserFocusId() {
		return this.userFocusId;
	}

	public void setUserFocusId(Long userFocusId) {
		this.userFocusId = userFocusId;
	}

	public Date getFocusDate() {
		return this.focusDate;
	}

	public void setFocusDate(Date focusDate) {
		this.focusDate = focusDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

}