package com.jcg.examples.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jcg.examples.dao.ProductDao;
import com.jcg.examples.viewBean.ProductBean;

public class ProductDaoImpl implements ProductDao
{
	private DataSource  dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<ProductBean> productlist(int categoryid) throws SQLException {
		String query = "Select * from productdetail Where categoryid=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, categoryid);
		ResultSet result = pstmt.executeQuery();
		List<ProductBean> productlist = new ArrayList<>();
		while(result.next()) {
		    ProductBean product = new ProductBean();
		    product.setProductid(result.getInt("productid"));
	      	product.setProductname(result.getString("productname"));
	      	byte[] img=result.getBytes("image");
		    product.setPrice(result.getDouble("price"));	
		productlist.add(product);
	}
	return productlist;
		
	}

	@Override
	public ProductBean productdescription(int productid) throws SQLException {
		String query = "Select * from productdetail Where productid=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, productid);
		ResultSet result = pstmt.executeQuery();
		ProductBean product = new ProductBean();
		if(result.next()) {
		    
		    product.setProductid(result.getInt("productid"));
	      	product.setProductname(result.getString("productname"));
	      	product.setPrice(result.getDouble("price"));
	      	product.setColour(result.getString("colour"));
	      	product.setDescription(result.getString("description"));
	      	product.setModel(result.getString("model"));
	      	product.setFeatures(result.getString("features"));
	      	byte[] img=result.getBytes("image");
		    
		    product.setPrice(result.getDouble("price"));	
	}
	return product;
	}
}
