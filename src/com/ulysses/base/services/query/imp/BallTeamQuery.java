package com.ulysses.base.services.query.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ulysses.base.dao.IBallTeamDAO;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.query.IBallTeamQuery;
import com.ulysses.base.view.UserView;

@Service
public class BallTeamQuery implements IBallTeamQuery, ICommonConstant {


	@Autowired
	IBallTeamDAO ballTeamDAO;
	
	/**
	 * By球队名查询
	 */
	public List findByTeamName(String teamName) {
		return ballTeamDAO.findByTeamNameCheck(teamName);
	}

	/**
	 * Find Team By User
	 */
	public List findByUser(Long userId) {
		return ballTeamDAO.findByUserId(userId);
	}

}
