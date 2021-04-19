package com.te.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.te.springmvc.beans.UserBean;

@Controller
public class SpringMVCController {

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView getHomePage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("HomePage");
		return modelAndView;
	}

	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public ModelAndView getData(ModelAndView modelAndView, HttpServletRequest request) {

		String name = request.getParameter("name");
		modelAndView.addObject("username", name);
		modelAndView.setViewName("newHome");
		return modelAndView;
	}

	@GetMapping("/login")
	public String getlogin() {
		return "Login";
	}

	@PostMapping("/login")
	public String getFormData(ModelMap map, HttpServletRequest request) {

		String name = request.getParameter("user");
		String pass = request.getParameter("pass");

		map.addAttribute("user", name);
		map.addAttribute("pass", pass);

		return "UserData";
	}

	@PostMapping("/login1")
	public String getFormData1(ModelMap map, String user, String pass) {
		map.addAttribute("user", user);
		map.addAttribute("pass", pass);

		return "UserData";
	}

	@PostMapping("/login2")
	public String getDataFromBean(ModelMap map, UserBean bean) {
		map.addAttribute("user", bean.getUser());
		map.addAttribute("pass", bean.getPass());

		return "UserData";
	}

	@PostMapping("/login3")
	public String getDataFromRequestParam(ModelMap map, @RequestParam(name = "") String user,
			@RequestParam(name = "") String pass) {

		map.addAttribute("user", user);
		map.addAttribute("pass", pass);

		return "UserData";
	}

}
