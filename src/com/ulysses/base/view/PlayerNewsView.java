package com.ulysses.base.view;

import java.util.Date;

/**
 * 个人发布动态
 *
 */
public class PlayerNewsView extends BaseView {


	private String[] pathArr;

	private Long newsId;
	private Long playerId;
	private Long fromNewsId;
	private String fromNewsConvey;
	private String newsSource;
	private String machinePlace;
	private String machineIp;
	private String newsContent;
	
	private String newsBmiddleImage;
	private String newsOriginalImage;
	private String newsThumbnailImage;
	private Long transpondCount;
	private Long commentsCount;
	private Long browseCount;
	private Long praiseCount;
	private String publicState;
	private String assignState;
	private Date createDate;
	private Long createUserId;
	private Date updateDate;
	private Long updateUserId;
	private Long orderBy;
	private String deleteState;
	private Date deleteDate;
	private String approveState;
	private String isValid;
	private Integer version;
	

	/** default constructor */
	public PlayerNewsView() {
	}

	
	public Long getNewsId() {
		return newsId;
	}
	
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getNewsSource() {
		return this.newsSource;
	}

	public void setNewsSource(String newsSource) {
		this.newsSource = newsSource;
	}

	public String getMachinePlace() {
		return this.machinePlace;
	}

	public void setMachinePlace(String machinePlace) {
		this.machinePlace = machinePlace;
	}

	public String getMachineIp() {
		return this.machineIp;
	}

	public void setMachineIp(String machineIp) {
		this.machineIp = machineIp;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsBmiddleImage() {
		return this.newsBmiddleImage;
	}

	public void setNewsBmiddleImage(String newsBmiddleImage) {
		this.newsBmiddleImage = newsBmiddleImage;
	}

	public String getNewsOriginalImage() {
		return this.newsOriginalImage;
	}

	public void setNewsOriginalImage(String newsOriginalImage) {
		this.newsOriginalImage = newsOriginalImage;
	}

	public String getNewsThumbnailImage() {
		return this.newsThumbnailImage;
	}

	public void setNewsThumbnailImage(String newsThumbnailImage) {
		this.newsThumbnailImage = newsThumbnailImage;
	}

	public Long getTranspondCount() {
		return this.transpondCount;
	}

	public void setTranspondCount(Long transpondCount) {
		this.transpondCount = transpondCount;
	}

	public Long getCommentsCount() {
		return this.commentsCount;
	}

	public void setCommentsCount(Long commentsCount) {
		this.commentsCount = commentsCount;
	}

	public Long getBrowseCount() {
		return this.browseCount;
	}

	public void setBrowseCount(Long browseCount) {
		this.browseCount = browseCount;
	}

	public Long getPraiseCount() {
		return this.praiseCount;
	}

	public void setPraiseCount(Long praiseCount) {
		this.praiseCount = praiseCount;
	}

	public String getPublicState() {
		return this.publicState;
	}

	public void setPublicState(String publicState) {
		this.publicState = publicState;
	}

	public String getAssignState() {
		return this.assignState;
	}

	public void setAssignState(String assignState) {
		this.assignState = assignState;
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

	public String getApproveState() {
		return this.approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
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


	public String[] getPathArr() {
		return pathArr;
	}


	public void setPathArr(String[] pathArr) {
		this.pathArr = pathArr;
	}
	public Long getFromNewsId() {
		return fromNewsId;
	}


	public void setFromNewsId(Long fromNewsId) {
		this.fromNewsId = fromNewsId;
	}


	public String getFromNewsConvey() {
		return fromNewsConvey;
	}


	public void setFromNewsConvey(String fromNewsConvey) {
		this.fromNewsConvey = fromNewsConvey;
	}
}
