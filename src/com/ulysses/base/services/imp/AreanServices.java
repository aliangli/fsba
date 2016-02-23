package com.ulysses.base.services.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.dao.IAreanDao;
import com.ulysses.base.pojo.TbArean;
import com.ulysses.base.services.IAreanServices;
import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.base.view.AreanView;

/**
 * 篮球馆场地Service
 */
@Transactional
@Service
public class AreanServices implements IAreanServices, ICommonConstant  {
	

	@Autowired
	ICommonExec common;
	
	@Autowired
	IAreanDao areanDao;
	

	public Map<String, Object> findAllArean(AreanView view) {
		
		List arr = this.findAllCheck(view.getPage(null));
		Map<String, Object> jsonMap = common.success();
		jsonMap.put(DATA, arr );
		
		return jsonMap;
	}

	

	public List findAll() {
		return areanDao.findAll();
	}
	
	public List findAllCheck(PageBean page) {
		return areanDao.findAllCheck(page);
	}

	public List findByExample(TbArean instance) {
		return areanDao.findByExample(instance);
	}

	public TbArean findById(Long id) {
		return areanDao.findById(id);
	}

	public void save(TbArean arean) {
		areanDao.save(arean);
	}

	public void update(TbArean arean) {
		areanDao.update(arean);
	}

}
