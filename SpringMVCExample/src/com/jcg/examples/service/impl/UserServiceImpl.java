package com.jcg.examples.service.impl;

import java.sql.SQLException;

import com.jcg.examples.dao.UserDao;
import com.jcg.examples.service.UserService;
import com.jcg.examples.viewBean.UserBean;

public class UserServiceImpl implements UserService 
{

	private UserDao userDao;

	public UserDao getUserDao() {
		return this.userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean isValidUser(String username, String password) throws SQLException {
		return userDao.isValidUser(username, password);
	}

	public boolean Newregister(UserBean userBean) throws SQLException {
		return userDao.NewRegister(userBean);
	}

	public boolean ForgotPassword(UserBean userBean) throws SQLException {
		return userDao.ForgotPassword(userBean);
	}

	public UserBean Viewprofile(String email) throws SQLException {
		return userDao.ViewProfile(email);
	
	}

	public boolean isUpdatedregister(UserBean userBean) throws SQLException {
		return userDao.isUpdatedregister(userBean);
	}
}

	