package com.jcg.examples.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jcg.examples.dao.CategoryDao;
import com.jcg.examples.viewBean.CategoryBean;

public class CategoryDaoImpl implements CategoryDao
{
	DataSource dataSource;
	
    public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
    public List<CategoryBean> categorydetail() throws SQLException {
    	String query = "Select * from category Where parentid=0";
    	PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
    	ResultSet result = pstmt.executeQuery();
    	List<CategoryBean> cate = new ArrayList<>();
    	while(result.next()) {
    		CategoryBean category = new CategoryBean();
    		category.setCategoryid(result.getInt("categoryid"));
    		category.setCategoryName(result.getString("categoryName"));
    		category.setParentid(result.getInt("parentid"));
    		byte[] img=result.getBytes("image");
 
    		cate.add(category);
    	}
    	return cate;
    }

	public List<CategoryBean> subcategorydetail(int categoryid) throws SQLException {
		String query = "Select * from category Where parentid= ?";
    	PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
    	pstmt.setInt(1, categoryid);
    	ResultSet result = pstmt.executeQuery();
    	List<CategoryBean> subcategory = new ArrayList<>();
    	while(result.next()) {
    		CategoryBean category = new CategoryBean();
    		category.setCategoryid(result.getInt("categoryid"));
    		category.setCategoryName(result.getString("categoryName"));
    		category.setParentid(result.getInt("parentid"));
    		byte[] img=result.getBytes("image");
 
    	    subcategory.add(category);
    	}
		return subcategory;
	}
	
	public List<CategoryBean> branddetail(int categoryid) throws SQLException {
		String query = "Select * from category Where parentid= ?";
    	PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
    	pstmt.setInt(1, categoryid);
    	ResultSet result = pstmt.executeQuery();
    	List<CategoryBean> brand = new ArrayList<>();
    	while(result.next()) {
    		CategoryBean category = new CategoryBean();
    		category.setCategoryid(result.getInt("categoryid"));
    		category.setCategoryName(result.getString("categoryName"));
    		category.setParentid(result.getInt("parentid"));
    		byte[] img=result.getBytes("image");
    		
    		brand.add(category);
    	}
		return brand;
	}

	
}
