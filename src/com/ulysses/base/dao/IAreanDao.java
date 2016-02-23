package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.pojo.TbArean;

/**
 * 篮球馆场地Dao
 */
public interface IAreanDao {

	// property constants
	public static final String AREAN_TITLE = "areanTitle";
	public static final String AREAN_TITLE_IMG = "areanTitleImg";
	public static final String AREAN_INTRODUCE = "areanIntroduce";
	public static final String AREAN_LINKMAN = "areanLinkman";
	public static final String AREAN_PHONE_NUMBER = "areanPhoneNumber";
	public static final String AREAN_URL = "areanUrl";
	public static final String AREAN_ADDRESS = "areanAddress";
	public static final String CREATE_USER_ID = "createUserId";
	public static final String UPDATE_USER_ID = "updateUserId";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";

	public abstract List findAllCheck(PageBean page);

	public abstract List findAll();
	

	public abstract void save(TbArean transientInstance);

	public abstract void update(TbArean persistentInstance);

	public abstract TbArean findById(java.lang.Long id);

	public abstract List findByExample(TbArean instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAreanTitle(Object areanTitle);

	public abstract List findByAreanIntroduce(Object areanIntroduce);

	public abstract List findByAreanLinkman(Object areanLinkman);

	public abstract List findByAreanPhoneNumber(Object areanPhoneNumber);

	public abstract List findByAreanUrl(Object areanUrl);

	public abstract List findByAreanAddress(Object areanAddress);

	public abstract List findByCreateUserId(Object createUserId);

	public abstract List findByUpdateUserId(Object updateUserId);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);

	public abstract TbArean merge(TbArean detachedInstance);

	public abstract void attachDirty(TbArean instance);

	public abstract void attachClean(TbArean instance);

}