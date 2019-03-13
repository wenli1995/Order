package com.java.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.BaseDao;
import com.java.entity.Manager;
import com.java.service.ManagerService;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService{

	@Resource
	private BaseDao<Manager> baseDao;
	
	
	@Override
	public Manager login(Manager m) {
		// TODO Auto-generated method stub
		Manager resultAdmin=(Manager)baseDao.get("from Manager where username=? and password=?", new Object[]{m.getUsername(),m.getPassword()});
		return resultAdmin;
		
	}

}
