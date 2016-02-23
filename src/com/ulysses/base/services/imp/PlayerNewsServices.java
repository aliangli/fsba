package com.ulysses.base.services.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.dao.IPlayerNewsDAO;
import com.ulysses.base.dao.db.DBPlayerNewsFocusUsers;
import com.ulysses.base.pojo.TbPlayerNews;
import com.ulysses.base.services.IBasketballPlayerServices;
import com.ulysses.base.services.INewsCommentServices;
import com.ulysses.base.services.IPlayerNewsServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;
import com.ulysses.base.view.PlayerNewsView;
import com.ulysses.util.UtilString;


@Transactional
@Service
public class PlayerNewsServices implements IPlayerNewsServices, ICommonConstant  {

	@Autowired
	ICommonExec common;
	
	@Autowired
	ICommonLoginExec loginExec;
	
	@Autowired
	IPlayerNewsDAO playerNewsDao;
	
	@Autowired
	IBasketballPlayerServices playerServices;
	
	@Autowired
	INewsCommentServices commentService;
	
	
	
	/**
	 * 关注的个人所有有效动态
	 */
	public Map<String, Object> findAllFocusNews(PlayerNewsView view) {
		TbPlayerNews news = new TbPlayerNews();
		news.setPlayerId(view.getNowUserId());
		
		List arr = playerNewsDao.findAllFocusNews(news, view.getPage(null));

		if(arr.size() == 0){
			return common.nothave();
		}
		
		String[] idArr = this.getNewsId(arr);
		
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		jsonMap.put(RELAY_DATA, this.findRelayNews(idArr[0]) );
		jsonMap.put(LIKE_DATA, commentService.findByUserLike(news.getPlayerId(), idArr[1] ) );
		
		return jsonMap;
	}
	
	/**
	 * 某个用户发布的所有有效动态
	 */
	public Map<String, Object> findUserNews(PlayerNewsView view) {
		if(UtilString.isEmptyR(view.getNowUserId())){
			return common.forbid();
		}
		
		TbPlayerNews news = new TbPlayerNews();
		news.setPlayerId(view.getNowUserId());
		
		List arr = playerNewsDao.findByUserAll(news, view.getPage(null));
		if(arr.size() == 0){
			return common.nothave();
		}
		
		String[] idArr = this.getNewsId(arr);
		
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		jsonMap.put(RELAY_DATA, this.findRelayNews(idArr[0]) );
		jsonMap.put(LIKE_DATA, commentService.findByUserLike(news.getPlayerId(), idArr[1] ) );
		
		return jsonMap;
	}
	

	/**
	 * 删除一条动态
	 */
	public Map<String, Object> delete(PlayerNewsView view) {
		
		TbPlayerNews news = playerNewsDao.findById(view.getNewsId());
		
		if(news == null){
			return common.forbid();
		}
		
		news.setId(view.getNewsId());
		news.setPlayerId(view.getNowUserId());
		
		news.setMachinePlace(view.getMachinePlace());
		news.setMachineIp(view.getMachineIp());
		news.setUpdateUserId(view.getNowUserId());
		
		Date now = new Date();
		news.setDeleteDate(now);
		news.setVersion(news.getVersion() + 1);
		news.setDeleteState(STATE_Y);
		
		playerNewsDao.delete(news);
		
		playerServices.dynamicCountCut(view.getNowUserId());
		
		return common.success();
	}

	/**
	 * 发布一条动态
	 */
	public Map<String, Object> save(PlayerNewsView view) {

		TbPlayerNews news = new TbPlayerNews();
		news.setNewsContent(view.getNewsContent());
		
		//用户发表动态上传图片的路径
		news.setNewsOriginalImage(view.getNewsOriginalImage()); //原始图片地址
		news.setNewsBmiddleImage(view.getNewsBmiddleImage());
		news.setNewsThumbnailImage(view.getNewsThumbnailImage());

		this.setNewsView(news, view);
		
		
		playerNewsDao.save(news);
		
		//动态数+1
		playerServices.dynamicCountAdd(view.getNowUserId());
		
		return common.success();
	}
	

	private void setNewsView(TbPlayerNews news, PlayerNewsView view) {

		news.setPlayerId(view.getNowUserId());
		news.setMachinePlace(view.getMachinePlace());
		news.setMachineIp(view.getMachineIp());

		news.setCreateUserId(view.getNowUserId());
		news.setUpdateUserId(view.getNowUserId());
		
		Date now = new Date();
		news.setCreateDate(now);
		news.setUpdateDate(now);
		news.setDeleteState(STATE_N);
		news.setIsValid(STATE_Y);
		news.setAssignState(STATE_N);
		news.setApproveState(STATE_N);
		news.setPublicState(STATE_Y);
		news.setVersion(1);
		news.setOrderBy(100L);
		
		news.setBrowseCount(0L);
		news.setCommentsCount(0L);
		news.setPraiseCount(0L);
		news.setTranspondCount(0L);
	}

	/**
	 * 转发一条动态
	 */
	public Map<String, Object> relayNews(PlayerNewsView view) {
		TbPlayerNews news = new TbPlayerNews();
		
		//转发动态-引用的动态数据ID
		Long fromNewsId = view.getFromNewsId();
		TbPlayerNews tempNews = this.findById(fromNewsId);
		
		if(tempNews!=null){
			//转发
			news.setFromNewsId(fromNewsId);
			news.setFromNewsConvey(view.getFromNewsConvey()); //转发动态-表达文本

			this.setNewsView(news, view);
			
			playerNewsDao.save(news);
			
			//转发数+1
			this.transpondCountAdd(fromNewsId);
			
			return common.success();
		}
		
		return common.forbid();
	}

	
	

	/**
	 * 评论数+1
	 */
	public void commendCountAdd(PlayerNewsView view) {
		TbPlayerNews news = this.findById(view.getNewsId());
		if(news != null){
			news.setCommentsCount(news.getCommentsCount() +1);
			playerNewsDao.update(news);
		}
		
	}

	/**
	 * 评论数-1
	 */
	public void commendCountCut(PlayerNewsView view) {
		TbPlayerNews news = this.findById(view.getNewsId());
		if(news != null){
			news.setCommentsCount(news.getCommentsCount()-1);
			playerNewsDao.update(news);
		}
	}

	/**
	 * 点赞数+1
	 */
	public void likeCountAdd(PlayerNewsView view) {
		TbPlayerNews news = this.findById(view.getNewsId());
		if(news != null){
			news.setPraiseCount(news.getPraiseCount()+1);
			playerNewsDao.update(news);
		}
	}

	/**
	 * 点赞数-1
	 */
	public void likeCountCut(PlayerNewsView view) {
		TbPlayerNews news = this.findById(view.getNewsId());
		if(news != null){
			news.setPraiseCount(news.getPraiseCount()-1);
			playerNewsDao.update(news);
		}
	}
	
	/**
	 * 转发数+1
	 */
	public void transpondCountAdd(Long newsID) {
		TbPlayerNews news = this.findById(newsID);
		if(news != null){
			news.setTranspondCount(news.getTranspondCount()+1);
			playerNewsDao.update(news);
		}
	}
	
	/**
	 * 转发数-1
	 */
	public void transpondCountCut(Long newsID) {
		TbPlayerNews news = this.findById(newsID);
		if(news != null){
			news.setTranspondCount(news.getTranspondCount()-1);
			playerNewsDao.update(news);
		}
	}

	/**
	 * 查询一条动态
	 */
	public TbPlayerNews findById(Long id) {
		if(id == null||id==0) return null;
		
		TbPlayerNews news = playerNewsDao.findById(id);
		if(news.getIsValid().equals(STATE_Y) && news.getDeleteState().equals(STATE_N) ){
			return news;
		}
		return null;
	}

	/**
	 * 通过发布动态的数据ID查询
	 */
	public List findRelayNews(String idArr) {
		return playerNewsDao.findRelayNews(idArr);
	}


	/**
	 * 提前动态中的ID and FromNewsId
	 * @param arr
	 * @return
	 */
	private String[] getNewsId(List arr) {
		String[] idArr = new String[2];

		//提取转发的动态数据ID, 去查询对应的动态
		StringBuffer fromNewsIdArr = new StringBuffer();//转发的动态ID
		StringBuffer newsIdArr = new StringBuffer();//动态ID
		DBPlayerNewsFocusUsers newsBean = null;
		int i = 0;
		for(Object obj : arr){
			if(obj instanceof DBPlayerNewsFocusUsers){
				newsBean = (DBPlayerNewsFocusUsers)obj;
				if(newsBean.getFromNewsId()!=null){
					if(i != 0){
						fromNewsIdArr.append(",");
					}
					fromNewsIdArr.append(newsBean.getFromNewsId());
					
				}
				
				if(newsBean.getId()!=null){
					if(i != 0){
						newsIdArr.append(",");
					}
					newsIdArr.append(newsBean.getId());
				}
			}
			i++;
		}
		
		idArr[0]=fromNewsIdArr.toString();
		idArr[1]=newsIdArr.toString();
		return idArr;
	}

	
}
