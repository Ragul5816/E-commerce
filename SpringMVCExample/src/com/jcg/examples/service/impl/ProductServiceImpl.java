package com.jcg.examples.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.jcg.examples.dao.ProductDao;
import com.jcg.examples.service.ProductService;
import com.jcg.examples.viewBean.ProductBean;

public class ProductServiceImpl implements ProductService 
{
	private ProductDao productDao;
	
	public ProductDao getProductDao() {
		return productDao;
	}
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<ProductBean> productlist(int categoryid) throws SQLException {
		return productDao.productlist(categoryid) ;
	}

	public ProductBean productdescription(int productid) throws SQLException {
		return productDao.productdescription(productid);
	}

	
	
}
