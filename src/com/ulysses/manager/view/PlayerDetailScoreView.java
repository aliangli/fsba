package com.ulysses.manager.view;

import java.util.Date;

import com.ulysses.base.view.BaseView;


/**
 * TbPlayerDetailScore entity. @author MyEclipse Persistence Tools
 */

public class PlayerDetailScoreView extends BaseView {


	private Long scoreId;
	private Long playerId;
	private String playerName;
	private String playerPosition;
	private Long tournamentId;
	
	private Long tntProcessId;
	
	private Long playerTeamId;
	private Short skillEnterTime;
	private Short skillBackboard;
	private Short skillAssist;
	private Short skillFoul;
	private Short skillSteal;
	private Short skillFault;
	private Short skillBlocking;
	private Short skillScore;
	private String ratioShooting;
	private String ratioThird;
	private String ratioPenalty;
	private String p1;
	private String p2;
	private String p3;
	private Date createDate;
	private Date updateDate;
	private Long orderBy;
	private String deleteState;
	private Date deleteDate;
	private String isValid;
	private Integer version;

	public PlayerDetailScoreView() {
	}


	public Long getScoreId() {
		return this.scoreId;
	}

	public void setScoreId(Long scoreId) {
		this.scoreId = scoreId;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerPosition() {
		return this.playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}

	public Long getTournamentId() {
		return this.tournamentId;
	}

	public void setTournamentId(Long tournamentId) {
		this.tournamentId = tournamentId;
	}

	public Long getPlayerTeamId() {
		return this.playerTeamId;
	}

	public void setPlayerTeamId(Long playerTeamId) {
		this.playerTeamId = playerTeamId;
	}

	public Short getSkillEnterTime() {
		return this.skillEnterTime;
	}

	public void setSkillEnterTime(Short skillEnterTime) {
		this.skillEnterTime = skillEnterTime;
	}

	public Short getSkillBackboard() {
		return this.skillBackboard;
	}

	public void setSkillBackboard(Short skillBackboard) {
		this.skillBackboard = skillBackboard;
	}

	public Short getSkillAssist() {
		return this.skillAssist;
	}

	public void setSkillAssist(Short skillAssist) {
		this.skillAssist = skillAssist;
	}

	public Short getSkillFoul() {
		return this.skillFoul;
	}

	public void setSkillFoul(Short skillFoul) {
		this.skillFoul = skillFoul;
	}

	public Short getSkillSteal() {
		return this.skillSteal;
	}

	public void setSkillSteal(Short skillSteal) {
		this.skillSteal = skillSteal;
	}

	public Short getSkillFault() {
		return this.skillFault;
	}

	public void setSkillFault(Short skillFault) {
		this.skillFault = skillFault;
	}

	public Short getSkillBlocking() {
		return this.skillBlocking;
	}

	public void setSkillBlocking(Short skillBlocking) {
		this.skillBlocking = skillBlocking;
	}

	public Short getSkillScore() {
		return this.skillScore;
	}

	public void setSkillScore(Short skillScore) {
		this.skillScore = skillScore;
	}

	public String getRatioShooting() {
		return this.ratioShooting;
	}

	public void setRatioShooting(String ratioShooting) {
		this.ratioShooting = ratioShooting;
	}

	public String getRatioThird() {
		return this.ratioThird;
	}

	public void setRatioThird(String ratioThird) {
		this.ratioThird = ratioThird;
	}

	public String getRatioPenalty() {
		return this.ratioPenalty;
	}

	public void setRatioPenalty(String ratioPenalty) {
		this.ratioPenalty = ratioPenalty;
	}

	public String getP1() {
		return this.p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return this.p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getP3() {
		return this.p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
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


	public Long getTntProcessId() {
		return tntProcessId;
	}


	public void setTntProcessId(Long tntProcessId) {
		this.tntProcessId = tntProcessId;
	}

}