package com.te.springmvc.service;

import java.util.List;

import com.te.springmvc.beans.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean authenticate(int id, String pwd);

	public EmployeeBean getEmployee(int id);

	public boolean delEmpData(int id);

	public List<EmployeeBean> getAllEmp();
}
