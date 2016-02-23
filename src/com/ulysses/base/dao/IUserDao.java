package com.ulysses.base.dao;

import java.util.List;

import com.ulysses.base.pojo.TbUser;

public interface IUserDao {

	// property constants
	public static final String USER_NAME = "userName";
	public static final String CHINESE_NAME = "chineseName";
	public static final String ENGLISH_NAME = "englishName";
	public static final String ALIAS_NAME = "aliasName";
	public static final String NATIONALITY = "nationality";
	public static final String BIRTHPACE = "birthpace";
	public static final String GRADUATE_SCHOOL = "graduateSchool";
	public static final String STATURE = "stature";
	public static final String WEIGHT = "weight";
	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_PHONE_NUMBER = "userPhoneNumber";
	public static final String USER_PHOTO_PATH = "userPhotoPath";
	public static final String USER_ADDRESS = "userAddress";
	public static final String USER_CITY = "userCity";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";

	public abstract void save(TbUser transientInstance);
	public abstract void update(TbUser transientInstance);

	public abstract TbUser findById(java.lang.Long id);

	public abstract List findByExample(TbUser instance);
	
	/**
	 * 不包含此用户名的集合数据
	 */
	public abstract List findNotContainUserName(TbUser instance);
	
	/**
	 * 不包含此手机号的用户的集合数据
	 */
	public abstract List findNotContainUserPhoneNumber(TbUser instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserName(Object userName);

	public abstract List findByChineseName(Object chineseName);

	public abstract List findByEnglishName(Object englishName);

	public abstract List findByAliasName(Object aliasName);
	
	public abstract List findByAliasNameNotMe(Object aliasName, Long id);

	public abstract List findByNationality(Object nationality);

	public abstract List findByBirthpace(Object birthpace);

	public abstract List findByStature(Object stature);

	public abstract List findByWeight(Object weight);

	public abstract List findByUserPhoneNumber(Object userPhoneNumber);

	public abstract List findByUserAddress(Object userAddress);

	public abstract List findByUserCity(Object userCity);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findAll();

	public abstract TbUser merge(TbUser detachedInstance);

	public abstract int getCount();

}