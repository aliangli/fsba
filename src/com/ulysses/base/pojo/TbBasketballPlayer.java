package com.ulysses.base.pojo;

/**
 * TbBasketballPlayer entity. @author MyEclipse Persistence Tools
 */

public class TbBasketballPlayer implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long userId;
	private String position;
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
	private String playerDeclaration;
	private Integer playerIntegrate;

	private Integer bestMark;
	private Integer uniformNumber;
	private Integer armLength;
	private Integer relaxHeight;
	private Integer jumpHeight;
	private Integer lungeHeight;

	// Constructors

	/** default constructor */
	public TbBasketballPlayer() {
	}

	/** minimal constructor */
	public TbBasketballPlayer(Long userId) {
		this.userId = userId;
	}

	/** full constructor */
	public TbBasketballPlayer(Long userId, String position,
			Integer livelyDegree, Integer passionDegree, Integer attackDegree,
			Integer defendDegree, Integer hitDegree, Integer talentDegree,
			String playerPhotoPath,Integer grade) {
		this.userId = userId;
		this.position = position;
		this.livelyDegree = livelyDegree;
		this.passionDegree = passionDegree;
		this.attackDegree = attackDegree;
		this.defendDegree = defendDegree;
		this.hitDegree = hitDegree;
		this.talentDegree = talentDegree;
		this.playerPhotoPath = playerPhotoPath;
		this.grade = grade;
	}

	public Integer getFocusTeamCount() {
		return focusTeamCount;
	}

	public void setFocusTeamCount(Integer focusTeamCount) {
		this.focusTeamCount = focusTeamCount;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getLivelyDegree() {
		return this.livelyDegree;
	}

	public void setLivelyDegree(Integer livelyDegree) {
		this.livelyDegree = livelyDegree;
	}

	public Integer getPassionDegree() {
		return this.passionDegree;
	}

	public void setPassionDegree(Integer passionDegree) {
		this.passionDegree = passionDegree;
	}

	public Integer getAttackDegree() {
		return this.attackDegree;
	}

	public void setAttackDegree(Integer attackDegree) {
		this.attackDegree = attackDegree;
	}

	public Integer getDefendDegree() {
		return this.defendDegree;
	}

	public void setDefendDegree(Integer defendDegree) {
		this.defendDegree = defendDegree;
	}

	public Integer getHitDegree() {
		return this.hitDegree;
	}

	public void setHitDegree(Integer hitDegree) {
		this.hitDegree = hitDegree;
	}

	public Integer getTalentDegree() {
		return this.talentDegree;
	}

	public void setTalentDegree(Integer talentDegree) {
		this.talentDegree = talentDegree;
	}

	public String getPlayerPhotoPath() {
		return this.playerPhotoPath;
	}

	public void setPlayerPhotoPath(String playerPhotoPath) {
		this.playerPhotoPath = playerPhotoPath;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
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

	public Integer getGoalFocusCount() {
		return goalFocusCount;
	}

	public void setGoalFocusCount(Integer goalFocusCount) {
		this.goalFocusCount = goalFocusCount;
	}

	public String getMedalConfig() {
		return medalConfig;
	}

	public void setMedalConfig(String medalConfig) {
		this.medalConfig = medalConfig;
	}

	public String getPlayerDeclaration() {
		return playerDeclaration;
	}

	public void setPlayerDeclaration(String playerDeclaration) {
		this.playerDeclaration = playerDeclaration;
	}

	public Integer getPlayerIntegrate() {
		return playerIntegrate;
	}

	public void setPlayerIntegrate(Integer playerIntegrate) {
		this.playerIntegrate = playerIntegrate;
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