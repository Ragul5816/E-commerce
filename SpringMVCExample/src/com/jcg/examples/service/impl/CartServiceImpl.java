package com.jcg.examples.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.jcg.examples.dao.CartDao;
import com.jcg.examples.service.CartService;
import com.jcg.examples.viewBean.CartBean;
import com.jcg.examples.viewBean.CartEntryBean;
import com.jcg.examples.viewBean.CombinedBean;
import com.jcg.examples.viewBean.ProductBean;

public class CartServiceImpl implements CartService {
	
	private CartDao cartDao;

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	private String email = "kavi123@gmail.com";

	@Override
	public boolean addToCart(CartEntryBean cartEntryBean) throws SQLException {

		int totalquantity = 0;
		double subtotal = 0;

		CartBean bean = getCart("kavi123@gmail.com");
		if (bean != null) {

		} else {
			boolean cart = createCart(email, totalquantity, subtotal);
		}

		CartEntryBean cart = cartExistedEntry(bean.getId(), cartEntryBean.getProductid());
		if (cart != null && cart.getQuantity() > 0 && cart.getPrice() > 0) {
			CartEntryBean entry = new CartEntryBean();
			entry.setCartid(bean.getId());
			entry.setProductid(cartEntryBean.getProductid());
			entry.setQuantity(cartEntryBean.getQuantity() + cart.getQuantity());
			entry.setTotal(cart.getPrice() * entry.getQuantity());
			boolean result = updateCartEntry(entry);
		} else {
			CartEntryBean entry = new CartEntryBean();
			entry.setProductid(cartEntryBean.getProductid());
			entry.setTotal(cartEntryBean.getQuantity() * cartEntryBean.getPrice());
			entry.setQuantity(cartEntryBean.getQuantity());
			entry.setPrice(cartEntryBean.getPrice());
			boolean result = cartDao.createCartEntry(bean, entry);
		}

		List<CartEntryBean> bean1 = cartEntries(bean.getId());
		for (CartEntryBean cart1 : bean1) {
			subtotal += cart1.getTotal();
			totalquantity += cart1.getQuantity();
		}
		boolean result = cartDao.updateCart(totalquantity, subtotal, bean.getId());

		return true;
	}

	@Override
	public boolean createCart(String email, int totalquantity, double subtotal) throws SQLException {

		return cartDao.createCart(email, totalquantity, subtotal);
	}

	@Override
	public CartBean getCart(String email) throws SQLException {

		return cartDao.getCart(email);
	}

	@Override
	public boolean createCartEntry(CartBean cartBean, CartEntryBean cartentrybean) throws SQLException {

		return cartDao.createCartEntry(cartBean, cartentrybean);
	}

	@Override
	public boolean updateCartEntry(CartEntryBean cartentrybean) throws SQLException {

		return cartDao.updateCartEntry(cartentrybean);
	}

	@Override
	public List<CartEntryBean> cartEntries(int cartid) throws SQLException {

		return cartDao.cartEntries(cartid);
	}

	@Override
	public CartEntryBean cartExistedEntry(int cartid, int productid) throws SQLException {

		return cartDao.cartExistedEntry(cartid, productid);
	}

	@Override
	public ProductBean productEntries(int productid) throws SQLException {

		return cartDao.productEntries(productid);
	}

	@Override
	public CombinedBean showCart(CombinedBean combineBean) throws SQLException {
		CartBean cart = getCart(email);
		combineBean.setCartBean(cart);
		List<CartEntryBean> bean1 = cartEntries(cart.getId());
		for (CartEntryBean bean : bean1) {
			int productid = bean.getProductid();
			ProductBean product = productEntries(productid);
			bean.setProductBean(product);
		}
		combineBean.setCartEntryBean(bean1);
		return combineBean;
	}

	@Override
	public boolean updateQuantity(CartEntryBean cartEntryBean) throws SQLException {
		int totalquantity = 0;
		double subtotal = 0;
		CartBean bean = getCart("ragul1442@gmail.com");
		List<CartEntryBean> bean1 = cartEntries(bean.getId());
		for (CartEntryBean cart1 : bean1) {
			subtotal += cart1.getTotal();
			totalquantity += cart1.getQuantity();
		}
		boolean result = cartDao.updateCart(totalquantity, subtotal, bean.getId());
		return cartDao.updateQuantity(cartEntryBean);
	}

	@Override
	public boolean delete(CartEntryBean cartEntryBean) throws SQLException {
		int totalquantity = 0;
		double subtotal = 0;
		CartBean bean = getCart("ragul1442@gmail.com");
		List<CartEntryBean> bean1 = cartEntries(bean.getId());
		for (CartEntryBean cart1 : bean1) {
			subtotal += cart1.getTotal();
			totalquantity += cart1.getQuantity();
			boolean result = cartDao.updateCart(totalquantity, subtotal, bean.getId());
		}
		return cartDao.delete(cartEntryBean);
	}
}
