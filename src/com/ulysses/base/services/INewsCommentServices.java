package com.ulysses.base.services;

import java.util.List;
import java.util.Map;

import com.ulysses.base.pojo.TbNewsComment;
import com.ulysses.base.view.news.NewsCommentView;

/**
 * 动态评论Service
 */
public interface INewsCommentServices {
	

	/**
	 * 某个用户点赞的动态
	 * @param newIdArray  ,分割
	 * @return
	 */
	public abstract List findByUserLike(Long userId, String newIdArray);

	/**
	 * 点赞
	 */
	public abstract Map<String, Object> like(NewsCommentView view);

	/**
	 * 评论
	 */
	public abstract Map<String, Object> comment(NewsCommentView view);
	
	/**
	 * 删除一条评论
	 */
	public abstract Map<String, Object> commentDelete(NewsCommentView view);
	

	/**
	 * 动态的所有评论
	 */
	public abstract Map<String, Object> findByNewsIdCheck(NewsCommentView comment);

	/**
	 * 用户对一个动态的所有评论
	 * @param comment
	 * @return
	 */
	public abstract Map<String, Object> findByUserCheck(NewsCommentView comment);


	public abstract TbNewsComment findById(java.lang.Long id);

	public abstract List findByNewsId(Object newsId);

	public abstract List findByUserId(Object userId);

	public abstract List findByCommentContent(Object commentContent);

	public abstract List findAll();
	
}
