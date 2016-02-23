package com.ulysses.base.view;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserView extends BaseView {

	private Long id;
	private Long userId;
	private String userName;
	private String chineseName;
	private String englishName;
	private String aliasName;
	private String nationality;
	private String birthpace;
	
	private String birthdate;
	private String userSex;
	private String userDeclaration;
	
	private String graduateSchool;
	private Integer stature;
	private Integer weight;
	private String userPassword;
	private String userPhoneNumber;
	private String userPhotoPath;
	private String userAddress;
	private String userCity;
	private Date regeditDate;
	private Date createDate;
	private Date updateDate;
	private Long orderBy;
	private String deleteState;
	private Date deleteDate;
	private String isValid;
	private Integer version;
	

	private Integer bestMark;
	private Integer uniformNumber;
	private Integer armLength;
	private Integer relaxHeight;
	private Integer jumpHeight;
	private Integer lungeHeight;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getAliasName() {
		return aliasName;
	}
	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getBirthpace() {
		return birthpace;
	}
	public void setBirthpace(String birthpace) {
		this.birthpace = birthpace;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGraduateSchool() {
		return graduateSchool;
	}
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	public Integer getStature() {
		return stature;
	}
	public void setStature(Integer stature) {
		this.stature = stature;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserPhotoPath() {
		return userPhotoPath;
	}
	public void setUserPhotoPath(String userPhotoPath) {
		this.userPhotoPath = userPhotoPath;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public Date getRegeditDate() {
		return regeditDate;
	}
	public void setRegeditDate(Date regeditDate) {
		this.regeditDate = regeditDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Long getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Long orderBy) {
		this.orderBy = orderBy;
	}
	public String getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
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
	public Integer getBestMark() {
		return bestMark;
	}
	public void setBestMark(Integer bestMark) {
		this.bestMark = bestMark;
	}
	public Integer getUniformNumber() {
		return uniformNumber;
	}
	public void setUniformNumber(Integer uniformNumber) {
		this.uniformNumber = uniformNumber;
	}
	public Integer getArmLength() {
		return armLength;
	}
	public void setArmLength(Integer armLength) {
		this.armLength = armLength;
	}
	public Integer getRelaxHeight() {
		return relaxHeight;
	}
	public void setRelaxHeight(Integer relaxHeight) {
		this.relaxHeight = relaxHeight;
	}
	public Integer getJumpHeight() {
		return jumpHeight;
	}
	public void setJumpHeight(Integer jumpHeight) {
		this.jumpHeight = jumpHeight;
	}
	public Integer getLungeHeight() {
		return lungeHeight;
	}
	public void setLungeHeight(Integer lungeHeight) {
		this.lungeHeight = lungeHeight;
	}
	
}
