package com.ulysses.manager.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.manager.dao.ITournamentProcessDAO;
import com.ulysses.manager.pojo.TbTournamentProcess;
import com.ulysses.manager.service.ITournamentProcessService;
import com.ulysses.manager.view.TournamentProcessView;

/**
 * 赛程Service
 */
@Transactional
@Service
public class TournamentProcessService implements ITournamentProcessService, ICommonConstant {


	@Autowired
	ICommonExec common;
	
	@Autowired
	ITournamentProcessDAO tmtProcessDAO;

	public Map<String, Object> findAll(TournamentProcessView view) {
		//验证比赛ID
		if(view.getTournamentId() == null || view.getTournamentId() == 0){
			return common.forbid();
		}
		
		List arr = this.findAllCheck(view, view.getPage(50));
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
	}

	public List findAllCheck(TournamentProcessView view, PageBean page) {
		return tmtProcessDAO.findAllCheck(view, page);
	}

	public List findByExample(TbTournamentProcess instance) {
		return tmtProcessDAO.findByExample(instance);
	}

	public TbTournamentProcess findById(Long id) {
		return tmtProcessDAO.findById(id);
	}

	public void save(TbTournamentProcess instance) {
		tmtProcessDAO.save(instance);
	}

	public void update(TbTournamentProcess instance) {
		tmtProcessDAO.update(instance);
	}

}
