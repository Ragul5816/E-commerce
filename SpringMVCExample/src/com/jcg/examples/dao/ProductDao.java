package com.jcg.examples.dao;

import java.sql.SQLException;
import java.util.List;

import com.jcg.examples.viewBean.ProductBean;

public interface ProductDao 
{
	public List<ProductBean> productlist(int categoryid) throws SQLException;

	public ProductBean productdescription(int productid) throws SQLException;

}
