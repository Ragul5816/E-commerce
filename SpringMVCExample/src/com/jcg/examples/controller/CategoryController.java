package com.jcg.examples.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.examples.service.CategoryService;
import com.jcg.examples.viewBean.CategoryBean;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView displaycategory(HttpServletRequest request, HttpServletResponse response,
			CategoryBean categoryBean) throws SQLException {
		ModelAndView model = null;
		try {
			List<CategoryBean> category = new ArrayList<>();
			category = categoryService.categorydetail();
			model = new ModelAndView("category");
			model.addObject("categoryBean", category);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;
	}

	@RequestMapping(value = "/subcategory/{categoryid}", method = RequestMethod.GET)
	public ModelAndView displaysubcategorypage(HttpServletRequest request, HttpServletResponse response,
			CategoryBean CategoryBean, @PathVariable int categoryid) throws SQLException {
		ModelAndView model = null;
		try {
			List<CategoryBean> category = new ArrayList<>();
			category = categoryService.subcategorydetail(categoryid);
			model = new ModelAndView("subcategory");
			model.addObject("categoryBean", category);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;

	}

	@RequestMapping(value = "/brand/{categoryid}", method = RequestMethod.GET)
	public ModelAndView displaybranddetail(HttpServletRequest request, HttpServletResponse response,
			CategoryBean CategoryBean, @PathVariable int categoryid) throws SQLException {
		ModelAndView model = null;
		try {
			List<CategoryBean> category = new ArrayList<>();
			category = categoryService.branddetail(categoryid);
			model = new ModelAndView("brand");
			model.addObject("categoryBean", category);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;

	}

}
