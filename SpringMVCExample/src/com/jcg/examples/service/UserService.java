
package com.jcg.examples.service;

import java.sql.SQLException;

import com.jcg.examples.viewBean.UserBean;

public interface UserService 
{
	public boolean isValidUser(String username, String password) throws SQLException;
	
	public boolean Newregister(UserBean userBean) throws SQLException;

	public boolean ForgotPassword(UserBean userBean) throws SQLException;

	public UserBean Viewprofile(String email)throws SQLException;

	public boolean isUpdatedregister(UserBean userBean) throws SQLException;
}

	
	

