package com.ulysses.base.services;

import java.util.List;
import java.util.Map;

import com.ulysses.base.pojo.TbFocus;
import com.ulysses.base.view.UserView;
import com.ulysses.base.view.FocusUserView;

/**
 * 关注个人
 *
 */
public interface IFocusServices {

	/**
	 * 用户ID 和 被关注用户ID 查询
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> findFocusUser(FocusUserView view);
	
	/**
	 * 当前用户关注的人
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> getNowUserFocus(UserView view);
	
	/**
	 * 关注当前用户的人
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> getNowUserFocusMe(UserView view);
	
	/**
	 * 某个用户关注的人
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> getFocusByUser(UserView view);
	
	/**
	 * 关注某个用户的人
	 * @param view
	 * @return
	 */
	public abstract Map<String, Object> getFocusByPassive(UserView view);

	public abstract Map<String, Object> focus(FocusUserView view);

	public abstract Map<String, Object> focusPlayer(FocusUserView view);

	public abstract Map<String, Object> cancelFocus(FocusUserView view);

	public abstract void save(TbFocus transientInstance);
	
	public abstract void update(TbFocus transientInstance);

	public abstract TbFocus findById(java.lang.Long id);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserId(Object userId);

	public abstract List findByUserFocusId(Object userFocusId);

	public abstract List findAll();

	public abstract TbFocus merge(TbFocus detachedInstance);


	
}
