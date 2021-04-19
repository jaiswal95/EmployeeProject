package com.te.springmvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.beans.EmployeeBean;
import com.te.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/empLogin")
	public String getLogin() {
		return "Login";
	}// end of getLogin

	@PostMapping("/empLogin")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map) {

		EmployeeBean empBean = service.authenticate(id, password);
		System.out.println(empBean);
		if (empBean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", empBean);
			return "HomePage";
		} else {
			map.addAttribute("errmsg", "Invalid Credentials");
			return "Login";
		}

	}// end of authenticate

	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map, HttpSession session) {

		if (session.getAttribute("emp") != null) {
			return "Search";
		} else {
			map.addAttribute("errmsg", "Please Login First");
			return "Login";
		}

	}// end of getSearchForm

	@GetMapping("/search1")
	public String searchEmployee(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean bean) {

		if (bean != null) {

			EmployeeBean bean2 = service.getEmployee(id);
			if (bean2 != null) {
				map.addAttribute("data", bean);
			} else {
				map.addAttribute("errmsg", "Data not Found for id :" + id);
			}
			return "Search";
		} else {
			map.addAttribute("errmsg", "Please Login First");
			return "Login";
		}

	}// end of searchEmployee

	@GetMapping("/ShowDelete")
	public String deleteForm(@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map) {

		if (bean != null) {
			return "delete";
		} else {
			map.addAttribute("errmsg", "Please Login First");
			return "Login";
		}

	}

	@GetMapping("/delete")
	public String deleteDataform(int id, @SessionAttribute(name = "emp", required = false) EmployeeBean bean,
			ModelMap map) {
		if (bean != null) {
			boolean isData = service.delEmpData(id);
			if (isData) {
				map.addAttribute("msg", "Delete Successfully");

			} else {
				map.addAttribute("errmsg", "Data not Found for id :" + id);
			}
			return "delete";

		} else {
			map.addAttribute("errmsg", "Please Login First");
			return "Login";
		}
	}// end of deleteDataForm

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("errmsg", "Logout SuccessFully");
		return "Login";

	}// end of logout

	@GetMapping("/Alldata")
	public String getAllData(@SessionAttribute(name = "emp", required = false) EmployeeBean bean, ModelMap map) {

		if (bean != null) {
			List<EmployeeBean> beans = service.getAllEmp();
			if (beans != null) {
				map.addAttribute("empData", beans);
				
			} else {
				map.addAttribute("msg", " No Records Found ");
			}
			return "AllData";
		} else {
			map.addAttribute("errmsg", "Please Login First");
			return "Login";
		}

	}//end of getAllData

}
