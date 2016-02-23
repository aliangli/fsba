package com.ulysses.base.pojo;

import java.util.Date;


/**
 * 战术pojo
 */

public class TbTeamTactic implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String tacticTitle;
	private String tacticTitleImg;
	private String tacticBody;
	private String tacticVideoPath;
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
	public TbTeamTactic() {
	}

	/** full constructor */
	public TbTeamTactic(String tacticTitle, String tacticTitleImg,
			String tacticBody, String tacticVideoPath, Date createDate,
			Long createUserId, Date updateDate, Long updateUserId,
			Long orderBy, String deleteState, Date deleteDate,
			String isValid, Integer version) {
		this.tacticTitle = tacticTitle;
		this.tacticTitleImg = tacticTitleImg;
		this.tacticBody = tacticBody;
		this.tacticVideoPath = tacticVideoPath;
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

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTacticTitle() {
		return this.tacticTitle;
	}

	public void setTacticTitle(String tacticTitle) {
		this.tacticTitle = tacticTitle;
	}

	public String getTacticTitleImg() {
		return this.tacticTitleImg;
	}

	public void setTacticTitleImg(String tacticTitleImg) {
		this.tacticTitleImg = tacticTitleImg;
	}

	public String getTacticBody() {
		return this.tacticBody;
	}

	public void setTacticBody(String tacticBody) {
		this.tacticBody = tacticBody;
	}

	public String getTacticVideoPath() {
		return this.tacticVideoPath;
	}

	public void setTacticVideoPath(String tacticVideoPath) {
		this.tacticVideoPath = tacticVideoPath;
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

}