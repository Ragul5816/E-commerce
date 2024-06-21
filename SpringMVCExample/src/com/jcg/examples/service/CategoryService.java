package com.jcg.examples.service;

import java.sql.SQLException;
import java.util.List;

import com.jcg.examples.viewBean.CategoryBean;

public interface CategoryService 
{
	public List<CategoryBean> categorydetail() throws SQLException;

	public List<CategoryBean> subcategorydetail(int categoryid) throws SQLException;

	public List<CategoryBean> branddetail(int categoryid) throws SQLException;

	
}
