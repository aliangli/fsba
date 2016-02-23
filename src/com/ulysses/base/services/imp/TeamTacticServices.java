package com.ulysses.base.services.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.dao.ITeamTacticDAO;
import com.ulysses.base.pojo.TbTeamTactic;
import com.ulysses.base.services.ITeamTacticServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.common.ICommonLoginExec;

/**
 * 战术service
 *
 */
@Transactional
@Service
public class TeamTacticServices implements ITeamTacticServices, ICommonConstant {
	

	@Autowired
	ICommonExec common;
	
	@Autowired
	ICommonLoginExec loginExec;

	@Autowired
	ITeamTacticDAO tacticDao;

	public Map<String, Object> findAllCheck() {
		List arr = tacticDao.findAllCheck();
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
	}

	public TbTeamTactic findById(Long id) {
		return tacticDao.findById(id);
	}

	public void save(TbTeamTactic tactic) {
		tacticDao.save(tactic);
	}

	public void update(TbTeamTactic tactic) {
		tacticDao.update(tactic);
	}

}
