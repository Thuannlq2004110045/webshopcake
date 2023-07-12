package com.shopwebcake.service.impl;

import java.util.List;

import com.shopwebcake.dao.impl.UserDao;
import com.shopwebcake.model.User;
import com.shopwebcake.service.IUserService;

public class UserService implements IUserService {
	UserDao userDao = new UserDao();
	@Override
	public void insert(User user) {
		userDao.insert(user);
		
	}

	@Override
	public void edit(User user) {
		userDao.edit(user);
		
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
		
	}

	@Override
	public User get(String userName) {
		return userDao.get(userName);
	}

	@Override
	public User get(int id) {
		
		return userDao.get(id);
	}

	@Override
	public User login(String userName, String password) {
		User user = this.get(userName);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;

	}

	@Override
	public void register(String userName, String password, String fullName, int roleId, String gmail) {
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setFullName(fullName);
		user.setRoleId(roleId);
		user.setGmail(gmail);
		userDao.insert(user);
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public List<User> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkExistEmail(String gmail) {
		// TODO Auto-generated method stub
		return userDao.checkExistEmail(gmail);
	}

	@Override
	public boolean checkExistUsername(String userName) {
		// TODO Auto-generated method stub
		return userDao.checkUsername(userName);
	}

}
