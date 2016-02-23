package com.ulysses.manager.service;

import java.util.List;
import java.util.Map;

import com.ulysses.manager.pojo.TbManagerUser;
import com.ulysses.manager.view.ManagerUserView;

/**
 * 管理员用户Service
 */
public interface IManagerUserService {
	
	public abstract Map<String, Object> findAll(ManagerUserView view);

	public abstract void save(TbManagerUser transientInstance);

	public abstract void update(TbManagerUser persistentInstance);

	public abstract TbManagerUser findById(java.lang.Long id);

	public abstract List findByExample(TbManagerUser instance);

	public abstract List findAllCheck();
	
}