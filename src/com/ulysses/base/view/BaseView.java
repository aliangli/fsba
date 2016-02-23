package com.ulysses.base.view;

import com.ulysses.base.bean.PageBean;
import com.ulysses.manager.support.Param;

public class BaseView extends PageBean implements Param  {
	private int defaultPageSize = 20;
	
	private String actionType;
	
	private Long nowUserId;
	private String aliasName;

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public Long getNowUserId() {
		return nowUserId;
	}

	public void setNowUserId(Long nowUserId) {
		this.nowUserId = nowUserId;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
	public PageBean getPage(Integer pageSize){
		
		return new PageBean(pageSize==null?defaultPageSize:pageSize , super.getPageNumber());
	}

}
