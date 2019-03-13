package com.java.service;

import java.util.List;

import com.java.entity.User;
public interface UserService {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public List<User> queryUser(User user);	
	public User getUserById(int id);
}
