package com.ulysses.base.dao.db;

import java.util.Date;

import com.ulysses.base.pojo.TbBallTeam;

public class DBTeam extends TbBallTeam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Long id;

	public DBTeam(Long id, String teamName, String teamOccupant, String teamCoach,
			String teamChineseName, String teamEnglishName,
			String teamNationality, String teamCity, Date teamBirthdate,
			Integer teamPopulation, String teamPhotoPath,
			Integer championNumber, String teamHonour, String teamRemark,
			String sportswearColor, Date createDate, Date updateDate,
			Long orderBy, String deleteState, Date deleteDate, String isValid,
			Integer version) {
		super(teamName, teamOccupant, teamCoach, teamChineseName, teamEnglishName,
				teamNationality, teamCity, teamBirthdate, teamPopulation,
				teamPhotoPath, championNumber, teamHonour, teamRemark, sportswearColor,
				createDate, updateDate, orderBy, deleteState, deleteDate, isValid,
				version);
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
