package com.ulysses.manager.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.manager.dao.ITournamentTeamRefDAO;
import com.ulysses.manager.pojo.TbTournamentTeamRef;
import com.ulysses.manager.service.ITournamentTeamRefService;
import com.ulysses.manager.view.TournamentTeamRefView;
import com.ulysses.util.UtilString;

/**
 * 参赛球队关系Service
 */
@Transactional
@Service
public class TournamentTeamRefService implements ITournamentTeamRefService, ICommonConstant {

	@Autowired
	ICommonExec common;

	@Autowired
	ITournamentTeamRefDAO tmtTeamRefDao;

	/**
	 * 个人参与的赛事
	 * @param view
	 * @return
	 */
	public Map<String, Object> findByUser(TournamentTeamRefView view) {
		//判断有效的参赛球队ID
		if(UtilString.isEmptyR(view.getUserId()) || view.getUserId() == 0 ){
			return common.forbid();
		}
		
		List arr = tmtTeamRefDao.findByUser(view.getUserId(), view.getPage(50));
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
	}

	/**
	 * 查询参赛的球队
	 */
	public Map<String, Object> findAll(TournamentTeamRefView view) {
		//验证比赛ID
		if(view.getTournamentId() == null || view.getTournamentId() == 0){
			return common.forbid();
		}
		
		List arr = this.findAllCheck(view, view.getPage(50));
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
	}
	
	
	public List findAllCheck(TournamentTeamRefView view, PageBean page) {
		return tmtTeamRefDao.findAllCheck(view,page);
	}

	public List findByExample(TbTournamentTeamRef instance) {
		return tmtTeamRefDao.findByExample(instance);
	}

	public TbTournamentTeamRef findById(Long id) {
		return tmtTeamRefDao.findById(id);
	}

	public void save(TbTournamentTeamRef instance) {
		tmtTeamRefDao.save(instance);
	}

	public void update(TbTournamentTeamRef instance) {
		tmtTeamRefDao.update(instance);
	}

}
