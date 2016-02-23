package com.ulysses.base.services.common.imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;

@Service
public class CommonExecImp implements ICommonExec, ICommonConstant {


	public Map<String, Object> stateMap(String code, String msg) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		jsonMap.put(SUCCESS, true);
		jsonMap.put(INFO, msg);
		jsonMap.put(CODE_TYPE, code);
		
		return jsonMap;
	}

	public Map<String, Object> notNULL(String msg) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();

		jsonMap.put(SUCCESS, true);
		jsonMap.put(INFO, msg);
		jsonMap.put(CODE_TYPE, "300");
		
		return jsonMap;
	}

	
	public Map<String, Object> noRational() {
		return this.stateMap("201", "非法请求");
	}

	public Map<String, Object> success() {
		return this.stateMap("200", "操作成功");
	}

	public Map<String, Object> loginFail() {
		return this.stateMap("205", "登录失败");
	}

	public Map<String, Object> nameExist() {
		return this.stateMap("202", "用户名已被注册");
	}

	public Map<String, Object> teamNameExist() {
		return this.stateMap("202", "球队名已被注册");
	}

	public Map<String, Object> phoneNumberExist() {
		return this.stateMap("203", "手机号已被注册");
	}

	public Map<String, Object> regeditFail() {
		return this.stateMap("209", "注册失败");
	}

	public Map<String, Object> regeditSuccess() {
		return this.stateMap("200", "注册成功");
	}


	public Map<String, Object> teamName() {
		//球队名称不能为空
		return this.notNULL(TEAM_NAME);
	}

	public Map<String, Object> focusBallPlayer() {
		return this.stateMap("220", "球员已关注");
	}

	public Map<String, Object> focusSuccess() {
		return stateMap("200", "关注成功" );
	}

	public Map<String, Object> invalidBallPlayer() {
		return stateMap("204", "球员不存在");
	}

	public Map<String, Object> cleanFocusFail() {
		return stateMap("207", "取消球员关注失败");
	}

	public Map<String, Object> cleanFocusSuccess() {
		return stateMap("208", "取消球员关注成功");
	}

	public Map<String, Object> nameNull() {
		return stateMap("211", USER_NAME);
	}
	
	public Map<String, Object> aliasNameNull() {
		return stateMap("21101", "昵称不能为空");
	}

	public Map<String, Object> aliasNameExist() {
		return stateMap("21105", "昵称已存在");
	}

	public Map<String, Object> userSexNull() {
		return stateMap("21102", "性别不能为空");
	}

	public Map<String, Object> pwdNull() {
		return stateMap("212", PWD);
	}

	public Map<String, Object> nameContainSpace() {
		return stateMap("213", "用户名包含空格");
	}

	public Map<String, Object> pwdContainSpace() {
		return stateMap("219", "密码包含空格");
	}

	public Map<String, Object> goLogin() {
		return stateMap("218", "请登录");
	}

	public Map<String, Object> newVersion() {
		// 数据已被其他用户更新
		return stateMap("223", "数据已被其他用户更新");
	}

	public Map<String, Object> teamRefNotExist() {
		// 此球队与球员关系不存在
		return stateMap("224", "此球队与球员关系不存在");
	}

	public Map<String, Object> underWay() {
		// 已发出申请
		return stateMap("225", "已发出申请");
	}

	public Map<String, Object> fail() {
		// 操作失败
		return stateMap("227", "操作失败");
	}

	public Map<String, Object> forbid() {
		// 禁止操作
		return stateMap("229", "禁止操作");
	}

	public Map<String, Object> teamNotExist() {
		// 球队不存在
		return stateMap("231", "球队不存在");
	}

	public Map<String, Object> teamDisband() {
		// 球队已解散
		return stateMap("233", "球队已解散");
	}

	public Map<String, Object> nullity() {
		// 操作无效
		return stateMap("237", "操作无效");
	}

	public Map<String, Object> version() {
		// 版本已被其他用户更新
		return stateMap("239", "版本已被其他用户更新");
	}

	public Map<String, Object> focusTeam() {
		// 球队已关注
		return stateMap("245", "球队已关注");
	}

	public Map<String, Object> focusPlayerNot() {
		// 球员未关注
		return stateMap("249", "球队未关注");
	}

	public Map<String, Object> focusTeamNot() {
		// 球队未关注
		return stateMap("253", "球队未关注");
	}

	public Map<String, Object> invite() {
		// 已发出邀请
		return stateMap("263", "已发出邀请");
	}
	
	public Map<String, Object> applicant() {
		// 已发出邀请
		return stateMap("273", "已发出申请");
	}

	public Map<String, Object> existPlayer() {
		// 已是该球队成员
		return stateMap("279", "已是该球队成员");
	}

	public Map<String, Object> nothave() {
		// 没有更多的结果
		return stateMap("299", "没有更多的结果");
	}

	public Map<String, Object> tntExpireState() {
		// 比赛非报名阶段
		return stateMap("421", "比赛非报名阶段");
	}

	public Map<String, Object> teamSize() {
		// 已超过创建球队数量的限制
		return stateMap("429", "已超过创建球队数量的限制");
	}
	
	

}
