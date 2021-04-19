package com.te.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvc.beans.EmployeeBean;
import com.te.springmvc.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeBean authenticate(int id, String pwd) {
		return dao.authenticate(id, pwd);

	}

	@Override
	public EmployeeBean getEmployee(int id) {

		return dao.getEmployee(id);
	}

	@Override
	public boolean delEmpData(int id) {

		return dao.delEmpData(id);
	}

	@Override
	public List<EmployeeBean> getAllEmp() {

		return dao.getAllEmp();
	}

}
