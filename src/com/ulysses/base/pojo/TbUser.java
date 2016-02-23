package com.ulysses.base.pojo;

import java.util.Date;

/**
 * TbUser entity. @author MyEclipse Persistence Tools
 */

public class TbUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String userName;
	private String chineseName;
	private String englishName;
	private String aliasName;
	private String userSex;
	private String nationality;
	private String birthpace;
	private Date birthdate;
	private String graduateSchool;
	private Integer stature;
	private Integer weight;
	private String userPassword;
	private String userPhoneNumber;

	private String userIdentityCard;
	private String userIdentityCardImg;
	private String userIcPhoto;
	private String userEmail;
	
	private String userPhotoPath;
	private String userAddress;
	private String userCity;

	private String userDeclaration;
	
	private Date regeditDate;
	private Date createDate;
	private Date updateDate;
	private Long orderBy;
	private String deleteState;
	private Date deleteDate;
	private String isValid;
	private Integer version;

	// Constructors

	/** default constructor */
	public TbUser() {
	}

	/** full constructor */
	public TbUser(String userName, String chineseName, String englishName,
			String aliasName, String nationality, String birthpace,
			Date birthdate, String graduateSchool, Integer stature,
			Integer weight, String userPassword, String userPhoneNumber,
			String userPhotoPath, String userAddress, String userCity,
			Date regeditDate, Date createDate, Date updateDate,
			Long orderBy, String deleteState, Date deleteDate,
			String isValid, Integer version) {
		this.userName = userName;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.aliasName = aliasName;
		this.nationality = nationality;
		this.birthpace = birthpace;
		this.birthdate = birthdate;
		this.graduateSchool = graduateSchool;
		this.stature = stature;
		this.weight = weight;
		this.userPassword = userPassword;
		this.userPhoneNumber = userPhoneNumber;
		this.userPhotoPath = userPhotoPath;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.regeditDate = regeditDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.orderBy = orderBy;
		this.deleteState = deleteState;
		this.deleteDate = deleteDate;
		this.isValid = isValid;
		this.version = version;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getEnglishName() {
		return this.englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBirthpace() {
		return this.birthpace;
	}

	public void setBirthpace(String birthpace) {
		this.birthpace = birthpace;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGraduateSchool() {
		return this.graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public Integer getStature() {
		return this.stature;
	}

	public void setStature(Integer stature) {
		this.stature = stature;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhoneNumber() {
		return this.userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserPhotoPath() {
		return this.userPhotoPath;
	}

	public void setUserPhotoPath(String userPhotoPath) {
		this.userPhotoPath = userPhotoPath;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public Date getRegeditDate() {
		return this.regeditDate;
	}

	public void setRegeditDate(Date regeditDate) {
		this.regeditDate = regeditDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(Long orderBy) {
		this.orderBy = orderBy;
	}

	public String getDeleteState() {
		return this.deleteState;
	}

	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}

	public Date getDeleteDate() {
		return this.deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getUserIdentityCard() {
		return userIdentityCard;
	}

	public void setUserIdentityCard(String userIdentityCard) {
		this.userIdentityCard = userIdentityCard;
	}

	public String getUserIdentityCardImg() {
		return userIdentityCardImg;
	}

	public void setUserIdentityCardImg(String userIdentityCardImg) {
		this.userIdentityCardImg = userIdentityCardImg;
	}

	public String getUserIcPhoto() {
		return userIcPhoto;
	}

	public void setUserIcPhoto(String userIcPhoto) {
		this.userIcPhoto = userIcPhoto;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserDeclaration() {
		return userDeclaration;
	}

	public void setUserDeclaration(String userDeclaration) {
		this.userDeclaration = userDeclaration;
	}

}