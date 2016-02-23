package com.ulysses.base.dao.db;

import java.util.Date;

public class DBPlayerNewsFocusUsers {

	private Long id;
	private Long playerId;
	private Long fromNewsId;
	private String fromNewsConvey;
	private String newsContent;
	private String newsBmiddleImage;
	private String newsOriginalImage;
	private String newsThumbnailImage;
	private Long transpondCount;
	private Long commentsCount;
	private Long browseCount;
	private Long praiseCount;

	private String userPhotoPath;
	private Date createDate;
	private String userName;
	private String aliasName;
	private String likeState;
	
	public DBPlayerNewsFocusUsers(){}
	
	public DBPlayerNewsFocusUsers(Long id, Long playerId, String newsContent,
			String newsBmiddleImage, String newsOriginalImage,
			String newsThumbnailImage, Long transpondCount, Long commentsCount,
			Long browseCount, Long praiseCount, Date createDate, String aliasName, String userPhotoPath, String likeState) {
		super();
		this.id = id;
		this.playerId = playerId;
		this.newsContent = newsContent;
		this.newsBmiddleImage = newsBmiddleImage;
		this.newsOriginalImage = newsOriginalImage;
		this.newsThumbnailImage = newsThumbnailImage;
		this.transpondCount = transpondCount;
		this.commentsCount = commentsCount;
		this.browseCount = browseCount;
		this.praiseCount = praiseCount;
		this.createDate = createDate;
		this.aliasName = aliasName;
		this.userPhotoPath = userPhotoPath;
		this.likeState = likeState;
	}
	
	
	public DBPlayerNewsFocusUsers(Long id, Long playerId, String newsContent,
			String newsBmiddleImage, String newsOriginalImage,
			String newsThumbnailImage, Long transpondCount, Long commentsCount,
			Long browseCount, Long praiseCount, Date createDate, String userName) {
		super();
		this.id = id;
		this.playerId = playerId;
		this.newsContent = newsContent;
		this.newsBmiddleImage = newsBmiddleImage;
		this.newsOriginalImage = newsOriginalImage;
		this.newsThumbnailImage = newsThumbnailImage;
		this.transpondCount = transpondCount;
		this.commentsCount = commentsCount;
		this.browseCount = browseCount;
		this.praiseCount = praiseCount;
		this.createDate = createDate;
		this.userName = userName;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLikeState() {
		return likeState;
	}

	public void setLikeState(String likeState) {
		this.likeState = likeState;
	}

	public String getAliasName() {
		return aliasName;
	}


	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}


	public String getUserPhotoPath() {
		return this.userPhotoPath;
	}

	public void setUserPhotoPath(String userPhotoPath) {
		this.userPhotoPath = userPhotoPath;
	}

	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsBmiddleImage() {
		return newsBmiddleImage;
	}
	public void setNewsBmiddleImage(String newsBmiddleImage) {
		this.newsBmiddleImage = newsBmiddleImage;
	}
	public String getNewsOriginalImage() {
		return newsOriginalImage;
	}
	public void setNewsOriginalImage(String newsOriginalImage) {
		this.newsOriginalImage = newsOriginalImage;
	}
	public String getNewsThumbnailImage() {
		return newsThumbnailImage;
	}
	public void setNewsThumbnailImage(String newsThumbnailImage) {
		this.newsThumbnailImage = newsThumbnailImage;
	}
	public Long getTranspondCount() {
		return transpondCount;
	}
	public void setTranspondCount(Long transpondCount) {
		this.transpondCount = transpondCount;
	}
	public Long getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(Long commentsCount) {
		this.commentsCount = commentsCount;
	}
	public Long getBrowseCount() {
		return browseCount;
	}
	public void setBrowseCount(Long browseCount) {
		this.browseCount = browseCount;
	}
	public Long getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(Long praiseCount) {
		this.praiseCount = praiseCount;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
