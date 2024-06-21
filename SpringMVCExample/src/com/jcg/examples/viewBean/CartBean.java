package com.jcg.examples.viewBean;

public class CartBean 
{
	private int id;
	private String email;
	private int totalquantity;
	private double subtotal;
	private ProductBean productBean;
	private CartEntryBean cartentrybean;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTotalquantity() {
		return totalquantity;
	}
	public void setTotalquantity(int totalquantity) {
		this.totalquantity = totalquantity;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	public CartEntryBean getCartentrybean() {
		return cartentrybean;
	}
	public void setCartentrybean(CartEntryBean cartentrybean) {
		this.cartentrybean = cartentrybean;
	}
	
}
