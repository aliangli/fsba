package com.ulysses.base.services;

import java.util.List;
import java.util.Map;

import com.ulysses.base.bean.PageBean;
import com.ulysses.base.pojo.TbArean;
import com.ulysses.base.view.AreanView;

/**
 * 篮球馆场地Service
 */
public interface IAreanServices {

	

	public abstract Map<String, Object> findAllArean(AreanView view);
	
	public abstract List findAll();

	public abstract List findAllCheck(PageBean page);

	public abstract void save(TbArean transientInstance);

	public abstract void update(TbArean persistentInstance);

	public abstract TbArean findById(java.lang.Long id);

	public abstract List findByExample(TbArean instance);
}
