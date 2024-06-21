package com.jcg.examples.viewBean;

import java.util.List;

public class CombinedBean 
{
	private int quantity;
	private int productid;
	private CartBean cartBean;
	private List<CartEntryBean> cartEntryBean;
	
	public CartBean getCartBean() {
		return cartBean;
	}
	public void setCartBean(CartBean cartBean) {
		this.cartBean = cartBean;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public List<CartEntryBean> getCartEntryBean() {
		return cartEntryBean;
	}
	public void setCartEntryBean(List<CartEntryBean> cartEntryBean) {
		this.cartEntryBean = cartEntryBean;
	}
	
}
