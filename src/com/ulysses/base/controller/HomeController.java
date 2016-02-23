package com.ulysses.base.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ulysses.base.bean.ADHomeInfoBean;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.view.HomeView;


@Controller
@RequestMapping(value = "homeController")
public class HomeController  implements ICommonConstant {

	private Map<String, Object> jsonMap;

	@Autowired
	ICommonExec common;
	

	/**
	 * 当前登录用户的球队详细信息
	 * @param view
	 * @return
	 */
	@RequestMapping(value = "info")
	@ResponseBody
	public Map<String, Object> info(HomeView view) {
		
		if (!"homeAD".equals(view.getActionType())) {
			return common.noRational();
		}
		
		List arr = new ArrayList();
		for(int i = 0 ; i < 4 ; i++){
			arr.add(new ADHomeInfoBean("imgs/home/" +
					(i+1) +".jpg", "view/home/at" +
					(i+1) +".html"));
			
			
		}

		jsonMap = common.success();
		jsonMap.put(DATA, arr);
		
		
		return jsonMap;
		
		
	}

}
