package com.jcg.examples.dao;

import java.sql.SQLException;

import com.jcg.examples.viewBean.UserBean;

public interface UserDao 
{
	public boolean isValidUser(String username, String password) throws SQLException;

	public boolean NewRegister(UserBean userBean) throws SQLException;

	public boolean ForgotPassword(UserBean userBean) throws SQLException;

	public UserBean ViewProfile(String email) throws SQLException;

	public boolean isUpdatedregister(UserBean userBean) throws SQLException;
}
