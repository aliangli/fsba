package com.ulysses.base.pojo;

import java.util.Date;


/**
 * 球队表
 */

public class TbBallTeam implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String teamName;
	private String teamOccupant;
	private String teamCoach;
	private String teamChineseName;
	private String teamEnglishName;
	private String teamNationality;
	private String teamCity;
	private String teamDeclaration;
	private Date teamBirthdate;
	private Integer teamPopulation;
	private String teamPhotoPath;
	private Integer championNumber;
	
	private String isOfficialTeam;
	private String approveState;
	private String isDisband;
	
	private String teamHonour;
	private String teamRemark;
	private String sportswearColor;
	private Date createDate;
	private Long createUserId;

	private Date updateDate;
	private Long updateUserId;
	
	private Long orderBy;
	private String deleteState;
	private Date deleteDate;
	private String isValid;
	private Integer version;

	// Constructors

	/** default constructor */
	public TbBallTeam() {
	}
	
	public TbBallTeam(String teamName, String teamOccupant, String teamCoach,
			String teamChineseName, String teamEnglishName,
			String teamNationality, String teamCity, Date teamBirthdate,
			Integer teamPopulation, String teamPhotoPath,
			Integer championNumber, String teamHonour, String teamRemark,
			String sportswearColor, Date createDate, Date updateDate,
			Long orderBy, String deleteState, Date deleteDate,
			String isValid, Integer version) {
		this.teamName = teamName;
		this.teamOccupant = teamOccupant;
		this.teamCoach = teamCoach;
		this.teamChineseName = teamChineseName;
		this.teamEnglishName = teamEnglishName;
		this.teamNationality = teamNationality;
		this.teamCity = teamCity;
		this.teamBirthdate = teamBirthdate;
		this.teamPopulation = teamPopulation;
		this.teamPhotoPath = teamPhotoPath;
		this.championNumber = championNumber;
		this.teamHonour = teamHonour;
		this.teamRemark = teamRemark;
		this.sportswearColor = sportswearColor;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.orderBy = orderBy;
		this.deleteState = deleteState;
		this.deleteDate = deleteDate;
		this.isValid = isValid;
		this.version = version;
	}

	public String getTeamDeclaration() {
		return teamDeclaration;
	}

	public void setTeamDeclaration(String teamDeclaration) {
		this.teamDeclaration = teamDeclaration;
	}

	public Long getId() {
		return this.id;
	}

	public String getIsOfficialTeam() {
		return isOfficialTeam;
	}

	public void setIsOfficialTeam(String isOfficialTeam) {
		this.isOfficialTeam = isOfficialTeam;
	}

	public String getApproveState() {
		return approveState;
	}

	public void setApproveState(String approveState) {
		this.approveState = approveState;
	}

	public String getIsDisband() {
		return isDisband;
	}

	public void setIsDisband(String isDisband) {
		this.isDisband = isDisband;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamOccupant() {
		return this.teamOccupant;
	}

	public void setTeamOccupant(String teamOccupant) {
		this.teamOccupant = teamOccupant;
	}

	public String getTeamCoach() {
		return this.teamCoach;
	}

	public void setTeamCoach(String teamCoach) {
		this.teamCoach = teamCoach;
	}

	public String getTeamChineseName() {
		return this.teamChineseName;
	}

	public void setTeamChineseName(String teamChineseName) {
		this.teamChineseName = teamChineseName;
	}

	public String getTeamEnglishName() {
		return this.teamEnglishName;
	}

	public void setTeamEnglishName(String teamEnglishName) {
		this.teamEnglishName = teamEnglishName;
	}

	public String getTeamNationality() {
		return this.teamNationality;
	}

	public void setTeamNationality(String teamNationality) {
		this.teamNationality = teamNationality;
	}

	public String getTeamCity() {
		return this.teamCity;
	}

	public void setTeamCity(String teamCity) {
		this.teamCity = teamCity;
	}

	public Date getTeamBirthdate() {
		
		
		return this.teamBirthdate;
	}

	public void setTeamBirthdate(Date teamBirthdate) {
		this.teamBirthdate = teamBirthdate;
	}

	public Integer getTeamPopulation() {
		return this.teamPopulation;
	}

	public void setTeamPopulation(Integer teamPopulation) {
		this.teamPopulation = teamPopulation;
	}

	public String getTeamPhotoPath() {
		return this.teamPhotoPath;
	}

	public void setTeamPhotoPath(String teamPhotoPath) {
		this.teamPhotoPath = teamPhotoPath;
	}

	public Integer getChampionNumber() {
		return this.championNumber;
	}

	public void setChampionNumber(Integer championNumber) {
		this.championNumber = championNumber;
	}

	public String getTeamHonour() {
		return this.teamHonour;
	}

	public void setTeamHonour(String teamHonour) {
		this.teamHonour = teamHonour;
	}

	public String getTeamRemark() {
		return this.teamRemark;
	}

	public void setTeamRemark(String teamRemark) {
		this.teamRemark = teamRemark;
	}

	public String getSportswearColor() {
		return this.sportswearColor;
	}

	public void setSportswearColor(String sportswearColor) {
		this.sportswearColor = sportswearColor;
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

}