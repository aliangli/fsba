package com.ulysses.manager.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulysses.base.services.common.ICommonConstant;
import com.ulysses.base.services.common.ICommonExec;
import com.ulysses.manager.dao.IManagerUserDAO;
import com.ulysses.manager.pojo.TbManagerUser;
import com.ulysses.manager.service.IManagerUserService;
import com.ulysses.manager.view.ManagerUserView;

/**
 * 管理员用户Service
 */
@Transactional
@Service
public class ManagerUserService implements IManagerUserService, ICommonConstant {

	@Autowired
	ICommonExec common;
	
	@Autowired
	IManagerUserDAO managerUserDao;
	
	public List findAllCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByExample(TbManagerUser instance) {

		return null;
	}

	public TbManagerUser findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(TbManagerUser transientInstance) {
		managerUserDao.save(transientInstance);
	}

	public void update(TbManagerUser persistentInstance) {
		managerUserDao.update(persistentInstance);
	}

	public Map<String, Object> findAll(ManagerUserView view) {
		List arr = managerUserDao.findAllCheck();
		
		
		return null;
	}

}
