/**
 * 
 */
package com.ulysses.base.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.dao.INewsCommentDao;
import com.ulysses.base.pojo.TbNewsComment;
import com.ulysses.base.services.INewsCommentServices;
import com.ulysses.base.services.IPlayerNewsServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.IConfigItem;
import com.ulysses.base.view.PlayerNewsView;
import com.ulysses.base.view.news.NewsCommentView;
import com.ulysses.util.UtilString;

/**
 * 动态评论Service
 */
@Transactional
@Service
public class NewsCommentServices implements INewsCommentServices, ICommonConstant  {

	@Autowired
	ICommonExec common;

	@Autowired
	IConfigItem config;
	
	@Autowired
	INewsCommentDao commentDao;
	
	@Autowired
	IPlayerNewsServices newsService;
	
	/**
	 * 删除一条评论
	 */
	public Map<String, Object> commentDelete(NewsCommentView view) {
		
		TbNewsComment temp = commentDao.findById(view.getCommentId());
		if(!(temp.getDeleteState().equals(STATE_Y) || temp.getIsValid().equals(STATE_N) ) && temp.getUserId().equals(view.getNowUserId())){
			temp.setDeleteDate(new Date());
			temp.setDeleteState(STATE_Y);

			commentDao.update(temp);

			PlayerNewsView news = new PlayerNewsView();
			news.setNewsId(temp.getNewsId());
			newsService.commendCountCut(news);
			
			return common.success();
		}
		
		return common.fail();
	}
	
	/**
	 * 发表一条评论
	 */
	public Map<String, Object> comment(NewsCommentView view) {
		if( view.getCommentContent() == null || view.getNewsId() == null || UtilString.isEmptyR(view.getCommentContent().trim()) ){
			return common.forbid();
		}
		
		TbNewsComment comment = new TbNewsComment();
		comment.setUserId(view.getNowUserId());
		comment.setNewsId(view.getNewsId());
		
		comment.setLikeState(STATE_N); //点赞状态
		comment.setCommentContent(view.getCommentContent());//评论内容
		
		if(UtilString.notEmpty(view.getDialogueUserId())){
			comment.setDialogueUserId(view.getDialogueUserId());
		}
		
		this.save(comment);
		

		PlayerNewsView news = new PlayerNewsView();
		news.setNewsId(view.getNewsId());
		newsService.commendCountAdd(news);
		
		return common.success();
	}
	
	/**
	 * 点赞
	 */
	public Map<String, Object> like(NewsCommentView view) {
		TbNewsComment comment = new TbNewsComment();
		comment.setUserId(view.getNowUserId());
		comment.setNewsId(view.getNewsId());
		
		PlayerNewsView news = new PlayerNewsView();
		
		List commentArr = commentDao.findByUserLike(comment);
		if(commentArr.size() > 0 ){
			
			TbNewsComment temp = (TbNewsComment)commentArr.get(0);
			
			temp.setLikeState(STATE_N);//取消赞
			commentDao.update(temp);
			
			news.setNewsId(view.getNewsId());
			newsService.likeCountCut(news );
			
		}else {
			comment.setLikeState(STATE_Y);//点赞
			this.save(comment);
			
			news.setNewsId(view.getNewsId());
			newsService.likeCountAdd(news );
		}
		
		return common.success();
	}
	
	/**
	 * 添加一条评论 或点赞
	 */
	public void save(TbNewsComment comment) {
		Date now = new Date();
		comment.setCreateDate(now);
		comment.setDeleteState(STATE_N);
		comment.setIsValid(STATE_Y);
		commentDao.save(comment);
	}

	public void update(NewsCommentView view) {

		TbNewsComment comment = new TbNewsComment();
		comment.setUserId(view.getNowUserId());
		comment.setNewsId(view.getNewsId());
		commentDao.update(comment);
	}

	/**
	 * 动态的所有评论
	 */
	public Map<String, Object> findByNewsIdCheck(NewsCommentView view) {
		TbNewsComment comment = new TbNewsComment();
		comment.setNewsId(view.getNewsId());
		
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, commentDao.findByNewsIdCheck(comment, view.getPage(null)));
		jsonMap.put(USER_LOGIN_PHOTO_PATH, config.getUserLoginPhotoPath() );
		return jsonMap;
	}

	/**
	 * 用户对一个动态的所有评论
	 */
	public Map<String, Object> findByUserCheck(NewsCommentView view) {
		TbNewsComment comment = new TbNewsComment();
		comment.setUserId(view.getNowUserId());
		comment.setNewsId(view.getNewsId());
		

		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, commentDao.findByUserCheck(comment));
		return jsonMap;
	}


	/**
	 * 某个用户点赞的动态
	 * @param newIdArray  ,分割
	 * @return
	 */
	public List findByUserLike(Long userId, String newIdArray) {
		return commentDao.findByUserLike(userId, newIdArray);
	}


	/* (non-Javadoc)
	 * @see com.ulysses.base.services.INewsCommentServices#findAll()
	 */
	public List findAll() {
		return commentDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.services.INewsCommentServices#findByCommentContent(java.lang.Object)
	 */
	public List findByCommentContent(Object commentContent) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.services.INewsCommentServices#findById(java.lang.Long)
	 */
	public TbNewsComment findById(Long id) {
		return commentDao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.services.INewsCommentServices#findByNewsId(java.lang.Object)
	 */
	public List findByNewsId(Object newsId) {
		return commentDao.findByNewsId(newsId);
	}

	/* (non-Javadoc)
	 * @see com.ulysses.base.services.INewsCommentServices#findByUserId(java.lang.Object)
	 */
	public List findByUserId(Object userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
