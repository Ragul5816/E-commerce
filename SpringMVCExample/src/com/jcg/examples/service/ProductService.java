package com.jcg.examples.service;

import java.sql.SQLException;
import java.util.List;

import com.jcg.examples.viewBean.ProductBean;

public interface ProductService 
{
	public List<ProductBean> productlist(int categoryid) throws SQLException;

	public ProductBean productdescription(int productid) throws SQLException;
}
