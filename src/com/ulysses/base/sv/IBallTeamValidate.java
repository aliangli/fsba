package com.ulysses.base.sv;

import java.util.Map;

import com.ulysses.base.view.BallTeamView;

/**
 * 球队数据验证
 *
 */
public interface IBallTeamValidate {
	
	/**
	 * 创建球队数据验证
	 */
	public abstract Map<String, Object> saveValidate(BallTeamView view);


}
