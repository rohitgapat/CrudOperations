package com.crud.service;

import java.util.List;

import com.crud.model.EmployeeResponse;

public interface EmployeeService {

	/*
	 * public Employee getEmployeeById(Integer id); public String
	 * createEmployee(Employee emp); public String deleteEmployeeById(Integer id);
	 * public List<Employee> getAllEmployees(); public JSONObject getStudent(Integer
	 * id); public Employee updateEmployeeName(Integer id, String name); public
	 * List<Employee> getEmployeeByCityId(Integer id); public EmployeeDTO
	 * getEmployeeDetailsById(Integer id);
	 */
	
	EmployeeResponse createEmployee(EmployeeResponse dto);
    EmployeeResponse getEmployeeById(Integer id);
    EmployeeResponse updateEmployee(Integer id, EmployeeResponse dto);
    EmployeeResponse deleteEmployee(Integer id);
    List<EmployeeResponse> getAllEmployees();
    public String getStudent(Integer id);
}
