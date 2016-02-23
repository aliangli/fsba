package com.ulysses.base.pojo;

import java.util.Date;


/**
 * 评论pojo
 */

public class TbNewsComment  implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

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

    // Constructors

    /** default constructor */
    public TbNewsComment() {
    }

	/** minimal constructor */
    public TbNewsComment(Long newsId, Long userId, Long dialogueUserId) {
        this.newsId = newsId;
        this.userId = userId;
        this.dialogueUserId = dialogueUserId;
    }
    
    /** full constructor */
    public TbNewsComment(Long newsId, Long userId, Long dialogueUserId, String commentContent, String likeState, Date createDate, String deleteState, Date deleteDate, String isValid) {
        this.newsId = newsId;
        this.userId = userId;
        this.dialogueUserId = dialogueUserId;
        this.commentContent = commentContent;
        this.likeState = likeState;
        this.createDate = createDate;
        this.deleteState = deleteState;
        this.deleteDate = deleteDate;
        this.isValid = isValid;
    }

   
    // Property accessors

    public Long getCommentId() {
        return this.commentId;
    }
    
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getNewsId() {
        return this.newsId;
    }
    
    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Long getUserId() {
        return this.userId;
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
        return this.commentContent;
    }
    
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getLikeState() {
        return this.likeState;
    }
    
    public void setLikeState(String likeState) {
        this.likeState = likeState;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
   








}