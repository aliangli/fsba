package com.ulysses.manager.pojo;

import java.util.Date;

/**
 * TbTournamentProcess entity. @author MyEclipse Persistence Tools
 */

public class TbTournamentProcess implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long processId;
	private Long tournamentId;
	private Long tournamentHostTeamId;
	private String tournamentHostTeamName;
	private Long tournamentGuestTeamId;
	private String tournamentGuestTeamName;
	private String hostTeamScore;
	private String guestTeamScore;
	private Date tournamentStartDate;
	private Date tournamentEndDate;
	private String tournamentState;
	private String remark;
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

	// Constructors

	/** default constructor */
	public TbTournamentProcess() {
	}

	/** minimal constructor */
	public TbTournamentProcess(Date tournamentStartDate,
			Date tournamentEndDate, String tournamentState,
			Date createDate, Date updateDate, String deleteState,
			String isValid, Integer version) {
		this.tournamentStartDate = tournamentStartDate;
		this.tournamentEndDate = tournamentEndDate;
		this.tournamentState = tournamentState;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteState = deleteState;
		this.isValid = isValid;
		this.version = version;
	}

	/** full constructor */
	public TbTournamentProcess(Long tournamentId, Long tournamentHostTeamId,
			String tournamentHostTeamName, Long tournamentGuestTeamId,
			String tournamentGuestTeamName, String hostTeamScore,
			String guestTeamScore, Date tournamentStartDate,
			Date tournamentEndDate, String tournamentState, String remark,
			String p1, String p2, String p3, Date createDate,
			Date updateDate, Long orderBy, String deleteState,
			Date deleteDate, String isValid, Integer version) {
		this.tournamentId = tournamentId;
		this.tournamentHostTeamId = tournamentHostTeamId;
		this.tournamentHostTeamName = tournamentHostTeamName;
		this.tournamentGuestTeamId = tournamentGuestTeamId;
		this.tournamentGuestTeamName = tournamentGuestTeamName;
		this.hostTeamScore = hostTeamScore;
		this.guestTeamScore = guestTeamScore;
		this.tournamentStartDate = tournamentStartDate;
		this.tournamentEndDate = tournamentEndDate;
		this.tournamentState = tournamentState;
		this.remark = remark;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.orderBy = orderBy;
		this.deleteState = deleteState;
		this.deleteDate = deleteDate;
		this.isValid = isValid;
		this.version = version;
	}

	// Property accessors

	public Long getProcessId() {
		return this.processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

	public Long getTournamentId() {
		return this.tournamentId;
	}

	public void setTournamentId(Long tournamentId) {
		this.tournamentId = tournamentId;
	}

	public Long getTournamentHostTeamId() {
		return this.tournamentHostTeamId;
	}

	public void setTournamentHostTeamId(Long tournamentHostTeamId) {
		this.tournamentHostTeamId = tournamentHostTeamId;
	}

	public String getTournamentHostTeamName() {
		return this.tournamentHostTeamName;
	}

	public void setTournamentHostTeamName(String tournamentHostTeamName) {
		this.tournamentHostTeamName = tournamentHostTeamName;
	}

	public Long getTournamentGuestTeamId() {
		return this.tournamentGuestTeamId;
	}

	public void setTournamentGuestTeamId(Long tournamentGuestTeamId) {
		this.tournamentGuestTeamId = tournamentGuestTeamId;
	}

	public String getTournamentGuestTeamName() {
		return this.tournamentGuestTeamName;
	}

	public void setTournamentGuestTeamName(String tournamentGuestTeamName) {
		this.tournamentGuestTeamName = tournamentGuestTeamName;
	}

	public String getHostTeamScore() {
		return this.hostTeamScore;
	}

	public void setHostTeamScore(String hostTeamScore) {
		this.hostTeamScore = hostTeamScore;
	}

	public String getGuestTeamScore() {
		return this.guestTeamScore;
	}

	public void setGuestTeamScore(String guestTeamScore) {
		this.guestTeamScore = guestTeamScore;
	}

	public Date getTournamentStartDate() {
		return this.tournamentStartDate;
	}

	public void setTournamentStartDate(Date tournamentStartDate) {
		this.tournamentStartDate = tournamentStartDate;
	}

	public Date getTournamentEndDate() {
		return this.tournamentEndDate;
	}

	public void setTournamentEndDate(Date tournamentEndDate) {
		this.tournamentEndDate = tournamentEndDate;
	}

	public String getTournamentState() {
		return this.tournamentState;
	}

	public void setTournamentState(String tournamentState) {
		this.tournamentState = tournamentState;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

}