package com.ulysses.manager.dao;

import java.util.List;

import com.ulysses.manager.pojo.TbManagerUser;

/**
 * 管理员用户Dao
 */
public interface IManagerUserDAO {

	// property constants
	public static final String USER_NAME = "userName";
	public static final String CHINESE_NAME = "chineseName";
	public static final String ENGLISH_NAME = "englishName";
	public static final String ALIAS_NAME = "aliasName";
	public static final String USER_SEX = "userSex";
	public static final String NATIONALITY = "nationality";
	public static final String BIRTHPACE = "birthpace";
	public static final String GRADUATE_SCHOOL = "graduateSchool";
	public static final String STATURE = "stature";
	public static final String WEIGHT = "weight";
	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_PHONE_NUMBER = "userPhoneNumber";
	public static final String USER_IDENTITY_CARD = "userIdentityCard";
	public static final String USER_IDENTITY_CARD_IMG = "userIdentityCardImg";
	public static final String USER_IC_PHOTO = "userIcPhoto";
	public static final String USER_EMAIL = "userEmail";
	public static final String USER_PHOTO_PATH = "userPhotoPath";
	public static final String USER_ADDRESS = "userAddress";
	public static final String USER_CITY = "userCity";
	public static final String DEPT_ID = "deptId";
	public static final String POST_ID = "postId";
	public static final String ORDER_BY = "orderBy";
	public static final String DELETE_STATE = "deleteState";
	public static final String IS_VALID = "isValid";
	public static final String VERSION = "version";

	public abstract void save(TbManagerUser transientInstance);

	public abstract void update(TbManagerUser persistentInstance);

	public abstract TbManagerUser findById(java.lang.Long id);

	public abstract List findByExample(TbManagerUser instance);

	public abstract List findAllCheck();
	

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserName(Object userName);

	public abstract List findByChineseName(Object chineseName);

	public abstract List findByEnglishName(Object englishName);

	public abstract List findByAliasName(Object aliasName);

	public abstract List findByUserSex(Object userSex);

	public abstract List findByNationality(Object nationality);

	public abstract List findByBirthpace(Object birthpace);

	public abstract List findByGraduateSchool(Object graduateSchool);

	public abstract List findByStature(Object stature);

	public abstract List findByWeight(Object weight);

	public abstract List findByUserPassword(Object userPassword);

	public abstract List findByUserPhoneNumber(Object userPhoneNumber);

	public abstract List findByUserIdentityCard(Object userIdentityCard);

	public abstract List findByUserIdentityCardImg(Object userIdentityCardImg);

	public abstract List findByUserIcPhoto(Object userIcPhoto);

	public abstract List findByUserEmail(Object userEmail);

	public abstract List findByUserPhotoPath(Object userPhotoPath);

	public abstract List findByUserAddress(Object userAddress);

	public abstract List findByUserCity(Object userCity);

	public abstract List findByDeptId(Object deptId);

	public abstract List findByPostId(Object postId);

	public abstract List findByOrderBy(Object orderBy);

	public abstract List findByDeleteState(Object deleteState);

	public abstract List findByIsValid(Object isValid);

	public abstract List findByVersion(Object version);

	public abstract List findAll();


}