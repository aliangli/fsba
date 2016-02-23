package com.ulysses.base.dao.db;

import java.util.Date;

public class DBUserFocus {
	

	private String userName;
	private String chineseName;
	private String englishName;
	private String aliasName;
	private String nationality;
	private String birthpace;
	private Date birthdate;
	private String graduateSchool;
	private Integer stature;
	private Integer weight;
	private String userPhoneNumber;
	private String userPhotoPath;
	private String userAddress;
	private String userCity;
	private Date regeditDate;

	private String position;
	private Long id;
	private Long userId;
	private Integer livelyDegree;
	private Integer passionDegree;
	private Integer attackDegree;
	private Integer defendDegree;
	private Integer hitDegree;
	private Integer talentDegree;
	private String playerPhotoPath;
	private Integer grade;
	

	private Integer dynamicCount;
	private Integer focusCount;
	private Integer focusTeamCount;
	private Integer goalFocusCount;
	
	private String medalConfig;
	
	
	public DBUserFocus(Long id,String userName, String chineseName, String englishName,
			String aliasName, String nationality, String birthpace,
			Date birthdate,String graduateSchool, Integer stature,
			Integer weight, String userPhoneNumber,String userPhotoPath, String userAddress, String userCity,
			Date regeditDate,
			
			 String position, Long userId,
			Integer livelyDegree, Integer passionDegree, Integer attackDegree,
			Integer defendDegree, Integer hitDegree, Integer talentDegree,
			String playerPhotoPath, Integer grade,
			Integer dynamicCount, Integer focusCount, Integer focusTeamCount, Integer goalFocusCount, 
			String medalConfig) {
		super();
		this.grade = grade;
		this.birthdate = birthdate;
		this.graduateSchool = graduateSchool;
		this.stature = stature;
		this.weight = weight;
		this.userPhoneNumber = userPhoneNumber;
		this.userPhotoPath = userPhotoPath;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.regeditDate = regeditDate;
		
		this.userName = userName;
		this.chineseName = chineseName;
		this.englishName = englishName;
		this.aliasName = aliasName;
		this.nationality = nationality;
		this.birthpace = birthpace;
		this.position = position;
		this.userId = userId;
		this.id = id;
		this.livelyDegree = livelyDegree;
		this.passionDegree = passionDegree;
		this.attackDegree = attackDegree;
		this.defendDegree = defendDegree;
		this.hitDegree = hitDegree;
		this.talentDegree = talentDegree;
		this.playerPhotoPath = playerPhotoPath;
		
		this.dynamicCount = dynamicCount;
		this.focusCount = focusCount;
		this.focusTeamCount = focusTeamCount;
		this.goalFocusCount = goalFocusCount;
		
		this.medalConfig = medalConfig;
	}

	public DBUserFocus() {
		super();
	}
	
	/*
	public DBUserFocus(String userName, String position,
			Long userId, Integer livelyDegree, Integer passionDegree,
			Integer attackDegree, Integer defendDegree, Integer hitDegree,
			Integer talentDegree, String playerPhotoPath) {
		super();
		this.userName = userName;
		this.position = position;
		this.userId = userId;
		this.livelyDegree = livelyDegree;
		this.passionDegree = passionDegree;
		this.attackDegree = attackDegree;
		this.defendDegree = defendDegree;
		this.hitDegree = hitDegree;
		this.talentDegree = talentDegree;
		this.playerPhotoPath = playerPhotoPath;
	}
	*/
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getLivelyDegree() {
		return livelyDegree;
	}
	public void setLivelyDegree(Integer livelyDegree) {
		this.livelyDegree = livelyDegree;
	}
	public Integer getPassionDegree() {
		return passionDegree;
	}
	public void setPassionDegree(Integer passionDegree) {
		this.passionDegree = passionDegree;
	}
	public Integer getAttackDegree() {
		return attackDegree;
	}
	public void setAttackDegree(Integer attackDegree) {
		this.attackDegree = attackDegree;
	}
	public Integer getDefendDegree() {
		return defendDegree;
	}
	public void setDefendDegree(Integer defendDegree) {
		this.defendDegree = defendDegree;
	}
	public Integer getHitDegree() {
		return hitDegree;
	}
	public void setHitDegree(Integer hitDegree) {
		this.hitDegree = hitDegree;
	}
	public Integer getTalentDegree() {
		return talentDegree;
	}
	public void setTalentDegree(Integer talentDegree) {
		this.talentDegree = talentDegree;
	}
	public String getPlayerPhotoPath() {
		return playerPhotoPath;
	}
	public void setPlayerPhotoPath(String playerPhotoPath) {
		this.playerPhotoPath = playerPhotoPath;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedalConfig() {
		return medalConfig;
	}

	public void setMedalConfig(String medalConfig) {
		this.medalConfig = medalConfig;
	}

	public Integer getDynamicCount() {
		return dynamicCount;
	}

	public void setDynamicCount(Integer dynamicCount) {
		this.dynamicCount = dynamicCount;
	}

	public Integer getFocusCount() {
		return focusCount;
	}

	public void setFocusCount(Integer focusCount) {
		this.focusCount = focusCount;
	}

	public Integer getFocusTeamCount() {
		return focusTeamCount;
	}

	public void setFocusTeamCount(Integer focusTeamCount) {
		this.focusTeamCount = focusTeamCount;
	}

	public Integer getGoalFocusCount() {
		return goalFocusCount;
	}

	public void setGoalFocusCount(Integer goalFocusCount) {
		this.goalFocusCount = goalFocusCount;
	}
	
	
}
