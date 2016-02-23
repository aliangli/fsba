package com.ulysses.base.services.common;

import java.util.Map;


/**
 * 状态接口
 *
 */
public interface ICommonExec {
	

	public final String TEAM_NAME = "球队名称不能为空";

	public final String USER_NAME = "注册名为空";

	public final String PWD = "密码为空";
	

	/**
	 * 某不能为空
	 * @return
	 */
	public Map<String, Object> notNULL(String msg);

	/**
	 * 某不能为空
	 * @return
	 */
	public Map<String, Object> stateMap(String code, String msg);

	/**
	 * 非法请求
	 * @return
	 */
	public Map<String, Object> noRational();

	/**
	 * 操作成功
	 * @return
	 */
	public Map<String, Object> success();

	/**
	 * 操作失败
	 * @return
	 */
	public Map<String, Object> fail();
	
	/**
	 * 操作无效
	 * @return
	 */
	public Map<String, Object> nullity();

	/**
	 * 登录失败
	 * @return
	 */
	public Map<String, Object> loginFail();
	
	/**
	 * 请登录
	 * @return
	 */
	public Map<String, Object> goLogin();
	
	
	// S 注册相关
	
	/**
	 * 注册成功
	 * @return
	 */
	public Map<String, Object> regeditSuccess();

	/**
	 * 用户名已被注册
	 * @return
	 */
	public Map<String, Object> nameExist();

	/**
	 * 用户名为空
	 * @return
	 */
	public Map<String, Object> nameNull();

	/**
	 * 用户名包含空格
	 * @return
	 */
	public Map<String, Object> nameContainSpace();

	/**
	 * 密码名包含空格
	 * @return
	 */
	public Map<String, Object> pwdContainSpace();


	/**
	 * 密码为空
	 * @return
	 */
	public Map<String, Object> pwdNull();

	/**
	 * 手机号已被注册
	 * @return
	 */
	public Map<String, Object> phoneNumberExist();

	/**
	 * 注册失败
	 * @return
	 */
	public Map<String, Object> regeditFail();
	
	// E 注册相关
	

	/**
	 * 球队名已被注册
	 * @return
	 */
	public Map<String, Object> teamNameExist();
	


	/**
	 * 球队名字不能为空
	 * @return
	 */
	public Map<String, Object> teamName();

	/**
	 * 已超过创建球队数量的限制
	 * @return
	 */
	public Map<String, Object> teamSize();
	

	/**
	 * 球员已关注
	 * @return
	 */
	public Map<String, Object> focusBallPlayer();
	
	/**
	 * 球员未关注
	 * @return
	 */
	public Map<String, Object> focusPlayerNot();

	/**
	 * 球员关注成功
	 * @return
	 */
	public Map<String, Object> focusSuccess();

	/**
	 * 取消球员关注成功
	 * @return
	 */
	public Map<String, Object> cleanFocusSuccess();

	/**
	 * 取消球员关注失败
	 * @return
	 */
	public Map<String, Object> cleanFocusFail();

	/**
	 * 球员不存在
	 * @return
	 */
	public Map<String, Object> invalidBallPlayer();

	/**
	 * 数据已被其他用户更新
	 * @return
	 */
	public Map<String, Object> newVersion();

	/**
	 * 此球队与球员关系不存在
	 * @return
	 */
	public Map<String, Object> teamRefNotExist();

	/**
	 * 球队不存在
	 * @return
	 */
	public Map<String, Object> teamNotExist();

	/**
	 * 球队已解散
	 * @return
	 */
	public Map<String, Object> teamDisband();
	
	/**
	 * 球队已关注
	 * @return
	 */
	public Map<String, Object> focusTeam();
	
	/**
	 * 球队未关注
	 * @return
	 */
	public Map<String, Object> focusTeamNot();

	/**
	 * 已发出申请
	 * @return
	 */
	public Map<String, Object> underWay();

	/**
	 * 禁止操作
	 * @return
	 */
	public Map<String, Object> forbid();

	/**
	 * 版本已被其他用户更新
	 * @return
	 */
	public Map<String, Object> version();

	/**
	 * 已发出邀请
	 * @return
	 */
	public Map<String, Object> invite();
	
	/**
	 * 已发出申请
	 * @return
	 */
	public Map<String, Object> applicant();

	/**
	 * 已是该球队成员
	 * @return
	 */
	public Map<String, Object> existPlayer();

	/**
	 * 没有更多的结果
	 * @return
	 */
	public Map<String, Object> nothave();

	/**
	 * 比赛非报名阶段
	 * @return
	 */
	public Map<String, Object> tntExpireState();

	/**
	 * 昵称不能为空
	 * @return
	 */
	public Map<String, Object> aliasNameNull();

	/**
	 * 性别不能为空
	 * @return
	 */
	public Map<String, Object> userSexNull();

	/**
	 * 昵称已存在
	 * @return
	 */
	public Map<String, Object> aliasNameExist();

	
	
}
