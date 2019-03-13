package com.java.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.BaseDao;
import com.java.entity.User;
import com.java.service.UserService;
import com.java.util.StringUtil;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private BaseDao<User> baseDao;
	private String mainPage;
	
	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		baseDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		baseDao.update(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		User user=this.getUserById(id);
		baseDao.delete(user);
	}

	@Override
	public List<User> queryUser(User user) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from User");
		if(user!=null&&StringUtil.isNotEmpty(user.getUsername())){
			sb.append(" and username='"+user.getUsername()+"'");
		}
		if(user!=null&&StringUtil.isNotEmpty(user.getLevel())){
			sb.append(" and level='"+user.getLevel()+"'");
		}
		if(user!=null&&StringUtil.isNotEmpty(user.getStatus())){
			sb.append(" and status='"+user.getStatus()+"'");
		}
		List<User> userlist=baseDao.query(sb.toString().replaceFirst("and", "where"));
		
		return userlist;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User user=baseDao.get(User.class, id);
		return user;
	}

}
