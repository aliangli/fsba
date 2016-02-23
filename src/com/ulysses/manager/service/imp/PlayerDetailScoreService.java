package com.ulysses.manager.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.manager.dao.IPlayerDetailScoreDAO;
import com.ulysses.manager.pojo.TbPlayerDetailScore;
import com.ulysses.manager.service.IPlayerDetailScoreService;
import com.ulysses.manager.view.PlayerDetailScoreView;

/**
 * 球员得分详情Service
 */
@Transactional
@Service
public class PlayerDetailScoreService implements IPlayerDetailScoreService , ICommonConstant{


	@Autowired
	ICommonExec common;
	
	@Autowired
	IPlayerDetailScoreDAO playerDetailScoreDAO;

	
	public Map<String, Object> findAll(PlayerDetailScoreView view) {
		//验证赛程ID
		if(view.getTntProcessId() == null || view.getTntProcessId() == 0){
			return common.forbid();
		}
		
		List arr = this.findAllCheck(view );
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
	}
	
	
	public List findAllCheck(PlayerDetailScoreView view ) {
		return playerDetailScoreDAO.findAllCheck(view);
	}

	public List findByExample(TbPlayerDetailScore instance) {
		return playerDetailScoreDAO.findByExample(instance);
	}

	public TbPlayerDetailScore findById(Long id) {
		return playerDetailScoreDAO.findById(id);
	}

	public void save(TbPlayerDetailScore instance) {
		playerDetailScoreDAO.save(instance);
	}

	public void update(TbPlayerDetailScore instance) {
		playerDetailScoreDAO.update(instance);
	}


}
