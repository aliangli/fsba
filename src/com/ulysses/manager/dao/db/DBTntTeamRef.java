package com.ulysses.manager.dao.db;

public class DBTntTeamRef {

	private Long tmRefId;
	private Long tournamentId;
	private Long tournamentTeamId;

	private String teamName;
	private String teamPhotoPath;
	
	public DBTntTeamRef(){}
	
	public DBTntTeamRef(Long tmRefId, Long tournamentId, Long tournamentTeamId,
			String teamName, String teamPhotoPath) {
		super();
		this.tmRefId = tmRefId;
		this.tournamentId = tournamentId;
		this.tournamentTeamId = tournamentTeamId;
		this.teamName = teamName;
		this.teamPhotoPath = teamPhotoPath;
	}
	
	public Long getTmRefId() {
		return tmRefId;
	}
	public void setTmRefId(Long tmRefId) {
		this.tmRefId = tmRefId;
	}
	public Long getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(Long tournamentId) {
		this.tournamentId = tournamentId;
	}
	public Long getTournamentTeamId() {
		return tournamentTeamId;
	}
	public void setTournamentTeamId(Long tournamentTeamId) {
		this.tournamentTeamId = tournamentTeamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamPhotoPath() {
		return teamPhotoPath;
	}
	public void setTeamPhotoPath(String teamPhotoPath) {
		this.teamPhotoPath = teamPhotoPath;
	}
	
	
	
}
