package com.jcg.examples.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.jcg.examples.dao.CategoryDao;
import com.jcg.examples.service.CategoryService;
import com.jcg.examples.viewBean.CategoryBean;

public  class CategoryServiceImpl implements CategoryService
{
	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	 
	@Override
	public List<CategoryBean> categorydetail() throws SQLException{
		return categoryDao.categorydetail();
	}


	public List<CategoryBean> subcategorydetail(int categoryid) throws SQLException {
		return categoryDao.subcategorydetail(categoryid);
	}

	public List<CategoryBean> branddetail(int categoryid) throws SQLException {
		return categoryDao.branddetail(categoryid);
	}

	
	

}
