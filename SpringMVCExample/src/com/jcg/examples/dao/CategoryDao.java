package com.jcg.examples.dao;

import java.sql.SQLException;
import java.util.List;

import com.jcg.examples.viewBean.CategoryBean;

public interface CategoryDao 
{	
	public List<CategoryBean> categorydetail() throws SQLException;

	public List<CategoryBean> subcategorydetail(int categoryid) throws SQLException;

	public List<CategoryBean> branddetail(int categoryid) throws SQLException;
}
