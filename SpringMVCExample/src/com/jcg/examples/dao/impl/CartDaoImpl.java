package com.jcg.examples.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jcg.examples.dao.CartDao;
import com.jcg.examples.viewBean.CartBean;
import com.jcg.examples.viewBean.CartEntryBean;
import com.jcg.examples.viewBean.ProductBean;

public  class CartDaoImpl implements CartDao
{
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean createCart(String email, int totalquantity, double subtotal) throws SQLException {
		String query = "Insert into cart_table(`email`,`totalquantity`,`subtotal`) values (?,?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		pstmt.setInt(2, totalquantity);
		pstmt.setDouble(3, subtotal);
		int result = pstmt.executeUpdate();
		if (result > 0)
			return true;
		else
			return false;
	}
	
	@Override
	public CartBean getCart(String email) throws SQLException {
		String query = "Select * from cart_table where email=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setString(1, email);
		ResultSet resultSet = pstmt.executeQuery();
		CartBean user = new CartBean();
		if (resultSet.next()) {
			user.setId(resultSet.getInt("id"));
			user.setEmail(resultSet.getString("email"));
			user.setTotalquantity(resultSet.getInt("totalquantity"));
			user.setSubtotal(resultSet.getDouble("subtotal"));
		}
		return user;
	}

	@Override
	public boolean createCartEntry(CartBean cartBean, CartEntryBean cartentrybean) throws SQLException {
		String query = "Insert into cart_entry(`cartid`,`productid`,`price`,`quantity`,`total`) values (?,?,?,?,?)";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartBean.getId());
		pstmt.setInt(2, cartentrybean.getProductid());
		pstmt.setDouble(3, cartentrybean.getPrice());
		pstmt.setInt(4, cartentrybean.getQuantity());
		pstmt.setDouble(5, cartentrybean.getTotal());
		int count = pstmt.executeUpdate();
		if (count > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateCartEntry(CartEntryBean cartentrybean) throws SQLException {
		String query = "Update cart_entry set quantity=?,total=? where cartid=? and productid=? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartentrybean.getQuantity());
		pstmt.setDouble(2, cartentrybean.getTotal());
		pstmt.setInt(3, cartentrybean.getCartid());
		pstmt.setInt(4, cartentrybean.getProductid());
		int result = pstmt.executeUpdate();
		if(result>0) 
			return true;
		else 
			return false;
	
	}
	
	@Override
	public boolean updateCart(int totalquantity,double subtotal,int cartid ) throws SQLException {
		String query = "Update cart_table set totalquantity=?,subtotal=? where id=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, totalquantity);
		pstmt.setDouble(2, subtotal);
		pstmt.setInt(3, cartid);
		int result = pstmt.executeUpdate();
		if(result>0) {
			return true;
			}
			else {
			return false;
			}
	}

	@Override
	public List<CartEntryBean> cartEntries(int cartid) throws SQLException {
		String query = "select * from cart_entry where cartid=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartid);
		ResultSet result = pstmt.executeQuery();
		List<CartEntryBean> entry = new ArrayList<>();
		while (result.next()) {
			CartEntryBean entrybean = new CartEntryBean();
			entrybean.setEntryid(result.getInt("entryid"));
			entrybean.setCartid(result.getInt("cartid"));
			entrybean.setProductid(result.getInt("productid"));
			entrybean.setPrice(result.getDouble("price"));
			entrybean.setQuantity(result.getInt("quantity"));
			entrybean.setTotal(result.getDouble("total"));
			entry.add(entrybean);
		}
		return entry;
	}

	@Override
	public CartEntryBean cartExistedEntry(int cartid, int productid) throws SQLException {
		String query = "select * from cart_entry where cartid=? and productid=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartid);
		pstmt.setInt(2, productid);
		ResultSet result = pstmt.executeQuery();
		CartEntryBean entrybean = new CartEntryBean();
		if (result.next()) {
			entrybean.setCartid(result.getInt("cartid"));
			entrybean.setProductid(result.getInt("productid"));
			entrybean.setPrice(result.getDouble("price"));
			entrybean.setQuantity(result.getInt("quantity"));
			entrybean.setTotal(result.getDouble("total"));
		}
		return entrybean;	}

	@Override
	public ProductBean productEntries(int productid) throws SQLException {
		String query = "select * from productdetail where productid=?";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, productid);
		ResultSet result = pstmt.executeQuery();
		ProductBean user = new ProductBean();
		if(result.next()) {
			
			user.setProductid(result.getInt("productid"));
			user.setProductname(result.getString("productname"));
			byte [] img=result.getBytes("image");
		
			user.setPrice(result.getDouble("price"));
			user.setModel(result.getString("model"));
			user.setColour(result.getString("colour"));
		}
		return user;
	}

	@Override
	public boolean updateQuantity(CartEntryBean cartEntryBean) throws SQLException {
		String query = "Update cart_entry set quantity=? where entryid=? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartEntryBean.getQuantity());

		pstmt.setInt(2, cartEntryBean.getEntryid());
		int result = pstmt.executeUpdate();
		if(result>0) {
			return true;
			}else {
			return false;
			}
	}

	@Override
	public boolean delete(CartEntryBean cartEntryBean) throws SQLException {
		String query = "delete from cart_entry where entryid=? ";
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
		pstmt.setInt(1, cartEntryBean.getEntryid());
		int result = pstmt.executeUpdate();
		if(result>0) {
			return true;
			}else {
			return false;
			}
	}
}
