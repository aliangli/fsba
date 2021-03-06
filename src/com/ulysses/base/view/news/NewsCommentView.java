package com.ulysses.base.view.news;

import java.util.Date;

import com.ulysses.base.view.BaseView;

/**
 * 评论View
 *
 */
public class NewsCommentView extends BaseView {

	private Long commentId;
	private Long newsId;
	private Long userId;

	private Long dialogueUserId;
	private String commentContent;
	private String likeState;
	private Date createDate;
	private String deleteState;
	private Date deleteDate;
	private String isValid;
	
	
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getNewsId() {
		return newsId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getDialogueUserId() {
		return dialogueUserId;
	}
	public void setDialogueUserId(Long dialogueUserId) {
		this.dialogueUserId = dialogueUserId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getLikeState() {
		return likeState;
	}
	public void setLikeState(String likeState) {
		this.likeState = likeState;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	
	
}
