package com.ulysses.base.view;

import java.util.Date;

public class BallTeamView extends BaseView {


	private Long teamId;
	private Long ballPlayerId;

	private String teamName;
	private String teamOccupant;
	private String teamCoach;
	private String teamChineseName;
	private String teamEnglishName;
	private String teamNationality;
	private String teamCity;
	private String teamDeclaration;
	private String teamBirthdate;
	private Integer teamPopulation;
	private String teamPhotoPath;
	private Integer championNumber;
	
	private String teamHonour;
	private String teamRemark;
	private String sportswearColor;
	private Date createDate;
	private Long createUserId;

	private Date updateDate;
	private Long updateUserId;
	
	private Long orderBy;
	private Integer version;
	

	
	public String getTeamDeclaration() {
		return teamDeclaration;
	}
	public void setTeamDeclaration(String teamDeclaration) {
		this.teamDeclaration = teamDeclaration;
	}
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public Long getBallPlayerId() {
		return ballPlayerId;
	}
	public void setBallPlayerId(Long ballPlayerId) {
		this.ballPlayerId = ballPlayerId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamOccupant() {
		return teamOccupant;
	}
	public void setTeamOccupant(String teamOccupant) {
		this.teamOccupant = teamOccupant;
	}
	public String getTeamCoach() {
		return teamCoach;
	}
	public void setTeamCoach(String teamCoach) {
		this.teamCoach = teamCoach;
	}
	public String getTeamChineseName() {
		return teamChineseName;
	}
	public void setTeamChineseName(String teamChineseName) {
		this.teamChineseName = teamChineseName;
	}
	public String getTeamEnglishName() {
		return teamEnglishName;
	}
	public void setTeamEnglishName(String teamEnglishName) {
		this.teamEnglishName = teamEnglishName;
	}
	public String getTeamNationality() {
		return teamNationality;
	}
	public void setTeamNationality(String teamNationality) {
		this.teamNationality = teamNationality;
	}
	public String getTeamCity() {
		return teamCity;
	}
	public void setTeamCity(String teamCity) {
		this.teamCity = teamCity;
	}
	public String getTeamBirthdate() {
		return teamBirthdate;
	}
	public void setTeamBirthdate(String teamBirthdate) {
		this.teamBirthdate = teamBirthdate;
	}
	public Integer getTeamPopulation() {
		return teamPopulation;
	}
	public void setTeamPopulation(Integer teamPopulation) {
		this.teamPopulation = teamPopulation;
	}
	public String getTeamPhotoPath() {
		return teamPhotoPath;
	}
	public void setTeamPhotoPath(String teamPhotoPath) {
		this.teamPhotoPath = teamPhotoPath;
	}
	public Integer getChampionNumber() {
		return championNumber;
	}
	public void setChampionNumber(Integer championNumber) {
		this.championNumber = championNumber;
	}
	public String getTeamHonour() {
		return teamHonour;
	}
	public void setTeamHonour(String teamHonour) {
		this.teamHonour = teamHonour;
	}
	public String getTeamRemark() {
		return teamRemark;
	}
	public void setTeamRemark(String teamRemark) {
		this.teamRemark = teamRemark;
	}
	public String getSportswearColor() {
		return sportswearColor;
	}
	public void setSportswearColor(String sportswearColor) {
		this.sportswearColor = sportswearColor;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Long getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Long getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Long orderBy) {
		this.orderBy = orderBy;
	}
	
}
