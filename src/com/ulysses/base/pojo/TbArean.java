package com.ulysses.base.pojo;

import java.util.Date;


/**
 * TbArean entity. @author MyEclipse Persistence Tools
 */

public class TbArean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String areanTitle;
	private String areanTitleImg;
	private String areanIntroduce;
	private String areanLinkman;
	private String areanPhoneNumber;
	private String areanUrl;
	private String areanAddress;
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
	public TbArean() {
	}

	/** full constructor */
	public TbArean(String areanTitle, String areanTitleImg,
			String areanIntroduce, String areanLinkman,
			String areanPhoneNumber, String areanUrl, String areanAddress,
			Date createDate, Long createUserId, Date updateDate,
			Long updateUserId, Long orderBy, String deleteState,
			Date deleteDate, String isValid, Integer version) {
		this.areanTitle = areanTitle;
		this.areanTitleImg = areanTitleImg;
		this.areanIntroduce = areanIntroduce;
		this.areanLinkman = areanLinkman;
		this.areanPhoneNumber = areanPhoneNumber;
		this.areanUrl = areanUrl;
		this.areanAddress = areanAddress;
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

	public String getAreanTitle() {
		return this.areanTitle;
	}

	public void setAreanTitle(String areanTitle) {
		this.areanTitle = areanTitle;
	}

	public String getAreanTitleImg() {
		return this.areanTitleImg;
	}

	public void setAreanTitleImg(String areanTitleImg) {
		this.areanTitleImg = areanTitleImg;
	}

	public String getAreanIntroduce() {
		return this.areanIntroduce;
	}

	public void setAreanIntroduce(String areanIntroduce) {
		this.areanIntroduce = areanIntroduce;
	}

	public String getAreanLinkman() {
		return this.areanLinkman;
	}

	public void setAreanLinkman(String areanLinkman) {
		this.areanLinkman = areanLinkman;
	}

	public String getAreanPhoneNumber() {
		return this.areanPhoneNumber;
	}

	public void setAreanPhoneNumber(String areanPhoneNumber) {
		this.areanPhoneNumber = areanPhoneNumber;
	}

	public String getAreanUrl() {
		return this.areanUrl;
	}

	public void setAreanUrl(String areanUrl) {
		this.areanUrl = areanUrl;
	}

	public String getAreanAddress() {
		return this.areanAddress;
	}

	public void setAreanAddress(String areanAddress) {
		this.areanAddress = areanAddress;
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