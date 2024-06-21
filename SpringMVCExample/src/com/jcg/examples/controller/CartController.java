package com.jcg.examples.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jcg.examples.service.CartService;
import com.jcg.examples.viewBean.CartEntryBean;
import com.jcg.examples.viewBean.CombinedBean;

@Controller
public class CartController 
{
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String executecart(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("data") CartEntryBean cartEntryBean) throws SQLException  {
		
		boolean result = cartService.addToCart(cartEntryBean);
		if(result) {
			return "redirect:/showCart";
		}else {
			return "redirect:/productdescription";
		}
	}
	
	@RequestMapping(value = "/showCart", method = RequestMethod.GET)
	public String displaycart(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("data") CombinedBean combineBean , Model model) throws SQLException  {
		
		CombinedBean result = cartService.showCart(combineBean);
		if(result != null) {
			model.addAttribute("combineBean" , result);
			return "cart";
		}else {
			return "redirect:/productdescription";
		}
	}
	
	@RequestMapping(value = "/updateQuantity" ,method = RequestMethod.POST)
	public String executeupdate(HttpServletRequest request, HttpServletResponse response, 
		@ModelAttribute("bean")	CartEntryBean cartEntryBean) throws SQLException  {
		
		boolean result = cartService.updateQuantity(cartEntryBean);
		if(result) {
		    return "redirect:/showCart";
	   }else {
		return "redirect:/showCart";
	   }
	}
	
	@RequestMapping(value = "/delete" ,method = RequestMethod.POST)
	public String executedelete(HttpServletRequest request, HttpServletResponse response, 
		@ModelAttribute("form")	CartEntryBean cartEntryBean) throws SQLException  {
		
		boolean result = cartService.delete(cartEntryBean);
		if(result) {
		    return "redirect:/showCart";
	   }else {
		return "redirect:/showCart";
	   }
	}
}
