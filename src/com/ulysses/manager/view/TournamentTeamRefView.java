package com.ulysses.manager.view;

import java.util.Date;
import com.ulysses.base.view.BaseView;


/**
 * TbTournamentTeamRef entity. @author MyEclipse Persistence Tools
 */

public class TournamentTeamRefView extends BaseView{

	private Long tmRefId;
	private Long userId;
	private Long tournamentId;
	private Long tournamentTeamId;
	private String tournamentLinkman;
	private String linkmanPhoneNumber;
	private String linkmanQqNumber;
	private String linkmanWeixNumber;
	private String linkmanWeibNumber;
	private String remark;
	private String enrollState;
	private String p1;
	private String p2;
	private String p3;
	private String p4;
	private Date createDate;
	private Date updateDate;
	private Long orderBy;
	private String deleteState;
	private Date deleteDate;
	private String isValid;
	private Integer version;

	private String teamIdArr;

	// Constructors

	/** default constructor */
	public TournamentTeamRefView() {
	}


	public Long getTmRefId() {
		return this.tmRefId;
	}

	public void setTmRefId(Long tmRefId) {
		this.tmRefId = tmRefId;
	}

	public Long getTournamentId() {
		return this.tournamentId;
	}

	public void setTournamentId(Long tournamentId) {
		this.tournamentId = tournamentId;
	}

	public Long getTournamentTeamId() {
		return this.tournamentTeamId;
	}

	public void setTournamentTeamId(Long tournamentTeamId) {
		this.tournamentTeamId = tournamentTeamId;
	}

	public String getTournamentLinkman() {
		return this.tournamentLinkman;
	}

	public void setTournamentLinkman(String tournamentLinkman) {
		this.tournamentLinkman = tournamentLinkman;
	}

	public String getLinkmanPhoneNumber() {
		return this.linkmanPhoneNumber;
	}

	public void setLinkmanPhoneNumber(String linkmanPhoneNumber) {
		this.linkmanPhoneNumber = linkmanPhoneNumber;
	}

	public String getLinkmanQqNumber() {
		return this.linkmanQqNumber;
	}

	public void setLinkmanQqNumber(String linkmanQqNumber) {
		this.linkmanQqNumber = linkmanQqNumber;
	}

	public String getLinkmanWeixNumber() {
		return this.linkmanWeixNumber;
	}

	public void setLinkmanWeixNumber(String linkmanWeixNumber) {
		this.linkmanWeixNumber = linkmanWeixNumber;
	}

	public String getLinkmanWeibNumber() {
		return this.linkmanWeibNumber;
	}

	public void setLinkmanWeibNumber(String linkmanWeibNumber) {
		this.linkmanWeibNumber = linkmanWeibNumber;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEnrollState() {
		return this.enrollState;
	}

	public void setEnrollState(String enrollState) {
		this.enrollState = enrollState;
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

	public String getP4() {
		return this.p4;
	}

	public void setP4(String p4) {
		this.p4 = p4;
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


	public String getTeamIdArr() {
		return teamIdArr;
	}


	public void setTeamIdArr(String teamIdArr) {
		this.teamIdArr = teamIdArr;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}

}