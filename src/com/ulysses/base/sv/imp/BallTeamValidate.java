package com.ulysses.base.sv.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.services.query.IBallTeamQuery;
import com.ulysses.base.sv.IBallTeamValidate;
import com.ulysses.base.view.BallTeamView;
import com.ulysses.util.UtilString;

/**
 * 球队数据验证
 *
 */
@Service
public class BallTeamValidate implements IBallTeamValidate, ICommonConstant {

	@Autowired
	ICommonExec common;
	
	@Autowired
	IBallTeamQuery ballTeamQuery;
	
	/**
	 * 验证是否允许创建球队
	 */
	public Map<String, Object> saveValidate(BallTeamView view) {
		//验证是否已超过创建球队数量的限制
		if(ballTeamQuery.findByUser(view.getNowUserId()).size() >= TEAM_SIZE){
			return common.teamSize();
		}

		//1 验证球队名称不能为空
		if(UtilString.isEmpty(view.getTeamName())){
			return common.teamName();
		}
		
		//2 球队名是否被注册
		List arr = ballTeamQuery.findByTeamName(view.getTeamName());
		if(arr.size() > 0){
			return common.teamNameExist();
		}
		
		return null;
	}

}
