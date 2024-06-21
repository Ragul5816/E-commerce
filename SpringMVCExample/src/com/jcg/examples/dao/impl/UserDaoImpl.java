package com.jcg.examples.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.jcg.examples.dao.UserDao;
import com.jcg.examples.viewBean.UserBean;

public class UserDaoImpl implements UserDao {

	DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean isValidUser(String email, String password) throws SQLException {
		String query = "Select * from user where email = ? and password = ?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet resultSet = pstmt.executeQuery();
		if (resultSet.next())
			return true;
		else
			return false;
	}

	public boolean NewRegister(UserBean userBean) throws SQLException {
		/*byte[] figure = null;
		try {
			//figure = userBean.getImage().getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		String query = "INSERT INTO user (`firstName`,`lastName`,`email`,`password`,`contactNo`,`address`,`image`) values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userBean.getFirstName());
		pstmt.setString(2, userBean.getLastName());
		pstmt.setString(3, userBean.getEmail());
		pstmt.setString(4, userBean.getPassword());
		pstmt.setString(5, userBean.getContactNo());
		pstmt.setString(6, userBean.getAddress());
		//pstmt.setBytes(7, figure);
		int count = pstmt.executeUpdate();
		if (count > 0)
			return true;
		else
			return false;
	}

	public boolean ForgotPassword(UserBean UserBean) throws SQLException {
		String query = "UPDATE user set password = ? where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(2, UserBean.getEmail());
		pstmt.setString(1, UserBean.getNewPassword());
		int count = pstmt.executeUpdate();
		if (count > 0)
			return true;
		else
			return false;
	}

	public UserBean ViewProfile(String email) throws SQLException {
		String query = "Select * from user where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);

		ResultSet resultset = pstmt.executeQuery();
		UserBean user = new UserBean();
		if (resultset.next()) {
			user.setFirstName(resultset.getString("firstName"));
			user.setLastName(resultset.getString("lastName"));
			user.setEmail(resultset.getString("email"));
			user.setContactNo(resultset.getString("ContactNo"));
			user.setAddress(resultset.getString("Address"));
			byte[] img = resultset.getBytes("image");

		}
		return user;
	}

	public boolean isUpdatedregister(UserBean userBean) throws SQLException {
		/*
		 * byte[] figure = null; try { figure = userBean.getImage().getBytes(); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
		String query = "UPDATE user set firstName=?,lastName=?,email=?,password=?,contactNo=?,address=?,image=? where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, userBean.getFirstName());
		pstmt.setString(2, userBean.getLastName());
		pstmt.setString(3, userBean.getEmail());
		pstmt.setString(4, userBean.getPassword());
		pstmt.setString(5, userBean.getContactNo());
		pstmt.setString(6, userBean.getAddress());
		pstmt.setString(7, userBean.getEmail());
		// pstmt.setBytes(8, figure);
		int count = pstmt.executeUpdate();
		if (count > 0)
			return true;
		else
			return false;
	}
}