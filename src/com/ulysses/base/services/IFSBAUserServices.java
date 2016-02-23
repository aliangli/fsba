package com.ulysses.base.services;

import java.util.List;
import java.util.Map;

import com.ulysses.base.pojo.TbUser;
import com.ulysses.base.view.UserView;

public interface IFSBAUserServices {

	public abstract int getCount();
	
	/**
	 * 不包含此用户名的集合数据
	 * @param instance
	 * @return
	 */
	public abstract List findNotContainUserName(TbUser instance);
	
	/**
	 * 不包含此手机号的用户的集合数据
	 */
	public abstract List findByUserPhoneNumber(TbUser instance);

	public abstract Map<String, Object> isLogin(UserView view);
	
	public abstract Map<String, Object> save(TbUser transientInstance);

	public abstract Map<String, Object> update(UserView user);

	public abstract void delete(TbUser persistentInstance);

	public abstract TbUser findById(java.lang.Long id);

	public abstract List findByExample(TbUser instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserName(Object userName);

	public abstract List findByAliasName(Object aliasName);

	public abstract List findByAliasNameNotMe(Object aliasName, Long id);

	public abstract List findByUserPhoneNumber(Object userPhoneNumber);

	public abstract List findByUserAddress(Object userAddress);

	public abstract List findByUserCity(Object userCity);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);

	public abstract List findAll();

	public abstract TbUser merge(TbUser detachedInstance);
	


}