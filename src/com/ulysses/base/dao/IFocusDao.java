package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.pojo.TbFocus;

public interface IFocusDao {

	// property constants
	public static final String USER_ID = "userId";
	public static final String USER_FOCUS_ID = "userFocusId";
	public static final String REMARK = "remark";

	public abstract void save(TbFocus transientInstance);
	
	public abstract void update(TbFocus transientInstance);

	public abstract void delete(TbFocus transientInstance);

	public abstract TbFocus findById(java.lang.Long id);

	/**
	 * 用户ID 和 关注用户ID 查询
	 */
	public abstract List findFocusCheck(TbFocus instance);

	public abstract List findFocusByUser(TbFocus instance);

	public abstract List findByUserId(Object userId);

	public abstract List findByUserFocusId(Object userFocusId);

	public abstract List findAll();

	public abstract TbFocus merge(TbFocus detachedInstance);


}