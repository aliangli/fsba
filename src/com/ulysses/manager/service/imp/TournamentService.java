package com.ulysses.manager.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.manager.dao.ITournamentDAO;
import com.ulysses.manager.pojo.TbTournament;
import com.ulysses.manager.service.ITournamentService;
import com.ulysses.manager.view.TournamentView;

/**
 * 比赛Service
 */
@Transactional
@Service
public class TournamentService implements ITournamentService, ICommonConstant {


	@Autowired
	ICommonExec common;

	@Autowired
	ITournamentDAO tournamentDao;
	

	public Map<String, Object> findAll(TournamentView view) {
		List arr = this.findAllCheck(view.getPage(50));
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
	}
	

	
	public List findAllCheck(PageBean page) {
		return tournamentDao.findAllCheck(page);
	}

	public List findByExample(TbTournament instance) {
		return tournamentDao.findByExample(instance);
	}

	public TbTournament findById(Long id) {
		return tournamentDao.findById(id);
	}

	public void save(TbTournament instance) {
		tournamentDao.save(instance);
	}

	public void update(TbTournament instance) {
		tournamentDao.update(instance);
	}

}
