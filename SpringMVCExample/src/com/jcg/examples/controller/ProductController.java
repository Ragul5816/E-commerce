package com.jcg.examples.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.examples.service.ProductService;
import com.jcg.examples.viewBean.ProductBean;

@Controller
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/productlist/{categoryid}", method = RequestMethod.GET)
	public ModelAndView displayproductlist(HttpServletRequest request, HttpServletResponse response,
			ProductBean ProductBean, @PathVariable int categoryid) throws SQLException {
		ModelAndView model = null;
		List<ProductBean> product = productService.productlist(categoryid);
			model = new ModelAndView("productlist");
			model.addObject("productBean", product);
		
		return model;
	}
	
	@RequestMapping(value = "/productdescription/{productid}", method = RequestMethod.GET)
	public ModelAndView displayproductdescription(HttpServletRequest request, HttpServletResponse response,
			ProductBean ProductBean, @PathVariable int productid) throws SQLException {
		ModelAndView model = null;
		 ProductBean product = productService.productdescription(productid);
			model = new ModelAndView("productdescription");
			model.addObject("productBean", product);
		
		return model;
	}
	
}
