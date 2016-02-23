package com.ulysses.manager.pojo;

import java.util.Date;


/**
 * TbTournament entity. @author MyEclipse Persistence Tools
 */

public class TbTournament implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long tournamentId;
	private String tournamentCode;
	private String tournamentName;
	private String tournamentChineseName;
	private String tournamentEnglishName;
	private String tournamentAliasName;
	private String tournamentMajorSponsor;
	private String tournamentSponsor;
	private String tournamentPace;
	private String tournamentCity;
	private Date tournamentDate;
	private Date enrollStartDate;
	private Date enrollEndDate;
	private Date tournamentStartDate;
	private Date tournamentEndDate;
	private String tournamentPhoneNumber;
	private String tournamentQqNumber;
	private String tournamentWeixNumber;
	private String tournamentWeibNumber;
	private String tournamentPhotoPath;
	private String tournamentRemark;
	private String p1;
	private String p2;
	private String p3;
	private String tournamentState;
	private String enrollValid;
	private Date createDate;
	private Date updateDate;
	private Long orderBy;
	private String deleteState;
	private Date deleteDate;
	private String isValid;
	private Integer version;

	// Constructors

	/** default constructor */
	public TbTournament() {
	}

	/** minimal constructor */
	public TbTournament(String tournamentName, String tournamentPace,
			String tournamentCity, Date tournamentDate,
			Date enrollStartDate, Date enrollEndDate,
			Date tournamentStartDate, Date tournamentEndDate,
			String tournamentState, String enrollValid, Date createDate,
			Date updateDate, String deleteState, String isValid,
			Integer version) {
		this.tournamentName = tournamentName;
		this.tournamentPace = tournamentPace;
		this.tournamentCity = tournamentCity;
		this.tournamentDate = tournamentDate;
		this.enrollStartDate = enrollStartDate;
		this.enrollEndDate = enrollEndDate;
		this.tournamentStartDate = tournamentStartDate;
		this.tournamentEndDate = tournamentEndDate;
		this.tournamentState = tournamentState;
		this.enrollValid = enrollValid;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.deleteState = deleteState;
		this.isValid = isValid;
		this.version = version;
	}

	/** full constructor */
	public TbTournament(String tournamentCode, String tournamentName,
			String tournamentChineseName, String tournamentEnglishName,
			String tournamentAliasName, String tournamentMajorSponsor,
			String tournamentSponsor, String tournamentPace,
			String tournamentCity, Date tournamentDate,
			Date enrollStartDate, Date enrollEndDate,
			Date tournamentStartDate, Date tournamentEndDate,
			String tournamentPhoneNumber, String tournamentQqNumber,
			String tournamentWeixNumber, String tournamentWeibNumber,
			String tournamentPhotoPath, String tournamentRemark, String p1,
			String p2, String p3, String tournamentState, String enrollValid,
			Date createDate, Date updateDate, Long orderBy,
			String deleteState, Date deleteDate, String isValid,
			Integer version) {
		this.tournamentCode = tournamentCode;
		this.tournamentName = tournamentName;
		this.tournamentChineseName = tournamentChineseName;
		this.tournamentEnglishName = tournamentEnglishName;
		this.tournamentAliasName = tournamentAliasName;
		this.tournamentMajorSponsor = tournamentMajorSponsor;
		this.tournamentSponsor = tournamentSponsor;
		this.tournamentPace = tournamentPace;
		this.tournamentCity = tournamentCity;
		this.tournamentDate = tournamentDate;
		this.enrollStartDate = enrollStartDate;
		this.enrollEndDate = enrollEndDate;
		this.tournamentStartDate = tournamentStartDate;
		this.tournamentEndDate = tournamentEndDate;
		this.tournamentPhoneNumber = tournamentPhoneNumber;
		this.tournamentQqNumber = tournamentQqNumber;
		this.tournamentWeixNumber = tournamentWeixNumber;
		this.tournamentWeibNumber = tournamentWeibNumber;
		this.tournamentPhotoPath = tournamentPhotoPath;
		this.tournamentRemark = tournamentRemark;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.tournamentState = tournamentState;
		this.enrollValid = enrollValid;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.orderBy = orderBy;
		this.deleteState = deleteState;
		this.deleteDate = deleteDate;
		this.isValid = isValid;
		this.version = version;
	}

	// Property accessors

	public Long getTournamentId() {
		return this.tournamentId;
	}

	public void setTournamentId(Long tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getTournamentCode() {
		return this.tournamentCode;
	}

	public void setTournamentCode(String tournamentCode) {
		this.tournamentCode = tournamentCode;
	}

	public String getTournamentName() {
		return this.tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public String getTournamentChineseName() {
		return this.tournamentChineseName;
	}

	public void setTournamentChineseName(String tournamentChineseName) {
		this.tournamentChineseName = tournamentChineseName;
	}

	public String getTournamentEnglishName() {
		return this.tournamentEnglishName;
	}

	public void setTournamentEnglishName(String tournamentEnglishName) {
		this.tournamentEnglishName = tournamentEnglishName;
	}

	public String getTournamentAliasName() {
		return this.tournamentAliasName;
	}

	public void setTournamentAliasName(String tournamentAliasName) {
		this.tournamentAliasName = tournamentAliasName;
	}

	public String getTournamentMajorSponsor() {
		return this.tournamentMajorSponsor;
	}

	public void setTournamentMajorSponsor(String tournamentMajorSponsor) {
		this.tournamentMajorSponsor = tournamentMajorSponsor;
	}

	public String getTournamentSponsor() {
		return this.tournamentSponsor;
	}

	public void setTournamentSponsor(String tournamentSponsor) {
		this.tournamentSponsor = tournamentSponsor;
	}

	public String getTournamentPace() {
		return this.tournamentPace;
	}

	public void setTournamentPace(String tournamentPace) {
		this.tournamentPace = tournamentPace;
	}

	public String getTournamentCity() {
		return this.tournamentCity;
	}

	public void setTournamentCity(String tournamentCity) {
		this.tournamentCity = tournamentCity;
	}

	public Date getTournamentDate() {
		return this.tournamentDate;
	}

	public void setTournamentDate(Date tournamentDate) {
		this.tournamentDate = tournamentDate;
	}

	public Date getEnrollStartDate() {
		return this.enrollStartDate;
	}

	public void setEnrollStartDate(Date enrollStartDate) {
		this.enrollStartDate = enrollStartDate;
	}

	public Date getEnrollEndDate() {
		return this.enrollEndDate;
	}

	public void setEnrollEndDate(Date enrollEndDate) {
		this.enrollEndDate = enrollEndDate;
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

	public String getTournamentPhoneNumber() {
		return this.tournamentPhoneNumber;
	}

	public void setTournamentPhoneNumber(String tournamentPhoneNumber) {
		this.tournamentPhoneNumber = tournamentPhoneNumber;
	}

	public String getTournamentQqNumber() {
		return this.tournamentQqNumber;
	}

	public void setTournamentQqNumber(String tournamentQqNumber) {
		this.tournamentQqNumber = tournamentQqNumber;
	}

	public String getTournamentWeixNumber() {
		return this.tournamentWeixNumber;
	}

	public void setTournamentWeixNumber(String tournamentWeixNumber) {
		this.tournamentWeixNumber = tournamentWeixNumber;
	}

	public String getTournamentWeibNumber() {
		return this.tournamentWeibNumber;
	}

	public void setTournamentWeibNumber(String tournamentWeibNumber) {
		this.tournamentWeibNumber = tournamentWeibNumber;
	}

	public String getTournamentPhotoPath() {
		return this.tournamentPhotoPath;
	}

	public void setTournamentPhotoPath(String tournamentPhotoPath) {
		this.tournamentPhotoPath = tournamentPhotoPath;
	}

	public String getTournamentRemark() {
		return this.tournamentRemark;
	}

	public void setTournamentRemark(String tournamentRemark) {
		this.tournamentRemark = tournamentRemark;
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

	public String getTournamentState() {
		return this.tournamentState;
	}

	public void setTournamentState(String tournamentState) {
		this.tournamentState = tournamentState;
	}

	public String getEnrollValid() {
		return this.enrollValid;
	}

	public void setEnrollValid(String enrollValid) {
		this.enrollValid = enrollValid;
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