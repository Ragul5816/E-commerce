package com.jcg.examples.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.examples.service.UserService;
import com.jcg.examples.viewBean.UserBean;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, UserBean userBean) {
		ModelAndView model = new ModelAndView("login");
		// model.addObject("userBean", userBean);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("userBean") UserBean userBean) {
		ModelAndView model = null;
		UserBean userProfile = new UserBean();
		try {
			boolean isValidUser = userService.isValidUser(userBean.getEmail(), userBean.getPassword());
			if (isValidUser) {
				userProfile = userService.Viewprofile(userBean.getEmail());
				model = new ModelAndView("profile");
				model.addObject("userBean", userProfile);
			} else {
				model = new ModelAndView("login");
				request.setAttribute("message", "Invalid credentials!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView displayRegiter(HttpServletRequest request, HttpServletResponse response, UserBean userBean) {
		ModelAndView model = new ModelAndView("register");
		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView executeRegister(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("userBean") UserBean userBean) {
		ModelAndView model = null;
		try {
			boolean isValidregister = userService.Newregister(userBean);
			if (isValidregister) {
				model = new ModelAndView("welcome");
				model.addObject("userBean", userBean);
			} else {
				model = new ModelAndView("register");
				request.setAttribute("message", "Invalid details!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public ModelAndView displayforgotpassword(HttpServletRequest request, HttpServletResponse response,
			UserBean userBean) {
		ModelAndView model = new ModelAndView("forgotpassword");
		model.addObject("forgotpasswordBean", userBean);
		return model;
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public ModelAndView executeforgotpassword(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("userBean") UserBean userBean) {
		ModelAndView model = null;
		try {
			if (userBean.getNewPassword().equals(userBean.getConfirmPassword())) {
				boolean isValidPassword = userService.ForgotPassword(userBean);
				if (isValidPassword) {
					model = new ModelAndView("login");
					model.addObject("userBean", userBean);
					model.addObject("message", "password changed Successfully");
				} else {
					model = new ModelAndView("forgotpassword");
					model.addObject("userBeann", userBean);
					model.addObject("message", "Invalide password");
				}

			} else {
				model = new ModelAndView("forgotpassword");
				request.setAttribute("message", "password does not match");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;

	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView displayprofile(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("userBean") UserBean userBean, String email) {

		ModelAndView model = new ModelAndView();
		UserBean userdetail;

		try {
			userdetail = userService.Viewprofile(email);
			if (userdetail != null) {
				model = new ModelAndView("profile");
				model.addObject("userBean", userBean);
				// request.setAttribute("email", userBean.getEmail());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.GET)
	public ModelAndView displayeditprofile(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String email) throws SQLException {
		ModelAndView model = new ModelAndView();
		UserBean user = userService.Viewprofile(email);
		if (user != null) {
			model = new ModelAndView("profile");
			model.addObject("userBean", user);
		}
		return model;
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.POST)
	public ModelAndView executeeditprofile(@ModelAttribute("userBean") UserBean userBean, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = null;
		try {
			boolean isValid = userService.isUpdatedregister(userBean);
			if (isValid) {
				model = new ModelAndView("profile");
				model.addObject("userBean", userBean);
				request.setAttribute("email", userBean.getEmail());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}
