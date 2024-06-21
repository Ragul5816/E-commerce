package com.jcg.examples.dao;

import java.sql.SQLException;
import java.util.List;

import com.jcg.examples.viewBean.CartBean;
import com.jcg.examples.viewBean.CartEntryBean;
import com.jcg.examples.viewBean.CombinedBean;
import com.jcg.examples.viewBean.ProductBean;

public interface CartDao 
{
	
	public boolean createCart(String email, int totalquantity, double subtotal) throws SQLException;
	
	public CartBean getCart(String email) throws SQLException;

	public boolean createCartEntry(CartBean cartBean, CartEntryBean cartentrybean) throws SQLException;

	public boolean updateCartEntry(CartEntryBean cartentrybean) throws SQLException;

	public List<CartEntryBean> cartEntries(int cartid) throws SQLException;

	public CartEntryBean cartExistedEntry(int cartid, int productid) throws SQLException;

	public boolean updateCart(int totalquantity, double subtotal, int cartid) throws SQLException;	
	
	public ProductBean productEntries(int productid) throws SQLException;	
		
	public boolean updateQuantity(CartEntryBean cartEntryBean) throws SQLException;

	public boolean delete(CartEntryBean cartEntryBean)  throws SQLException;
;

}
