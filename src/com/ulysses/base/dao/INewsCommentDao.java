package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.pojo.TbNewsComment;

/**
 * 评论Dao
 */
public interface INewsCommentDao {

	public static final String NEWS_ID = "newsId";
	public static final String USER_ID = "userId";
	public static final String USER_NAME = "userName";
	public static final String COMMENT_CONTENT = "commentContent";
	public static final String LIKE_STATE = "likeState";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";

	/**
	 * 动态的所有评论
	 * @param comment
	 * @return
	 */
	public abstract List findByNewsIdCheck(TbNewsComment comment,  PageBean page);
	
	public abstract List findByNewsIdCheck(TbNewsComment comment);

	/**
	 * 某个用户点赞的动态
	 * @param newIdArray  ,分割
	 * @return
	 */
	public abstract List findByUserLike(Long userId, String newIdArray);
	
	public abstract List findByUserLike(TbNewsComment comment);
	
	/**
	 * 用户对一个动态的所有评论
	 * @param comment
	 * @return
	 */
	public abstract List findByUserCheck(TbNewsComment comment);

	public abstract void save(TbNewsComment transientInstance);

	public abstract void update(TbNewsComment persistentInstance);

	public abstract TbNewsComment findById(java.lang.Long id);

	public abstract List findByNewsId(Object newsId);

	public abstract List findByUserId(Object userId);

	public abstract List findByCommentContent(Object commentContent);

	public abstract List findAll();

}