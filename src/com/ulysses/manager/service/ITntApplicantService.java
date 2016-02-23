package com.ulysses.manager.service;

import java.util.List;
import java.util.Map;

import com.ulysses.manager.pojo.TbTntApplicant;
import com.ulysses.manager.view.TntApplicantView;

/**
 * 球队申请参赛Service
 */
public interface ITntApplicantService {

	public abstract Map<String, Object> save(TntApplicantView view);

	public abstract Map<String, Object> delete(TntApplicantView view);

	public abstract Map<String, Object> update(TntApplicantView view);

	public abstract TbTntApplicant findById(java.lang.Long id);

	public abstract List findByExample(TbTntApplicant instance);
	

	public abstract void save(TbTntApplicant transientInstance);

	public abstract void delete(TbTntApplicant persistentInstance);

	public abstract void update(TbTntApplicant persistentInstance);

}
