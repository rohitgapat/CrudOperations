package com.crud.service;

import java.util.List;

import org.json.JSONObject;

import com.crud.entity.Employee;
import com.crud.model.EmployeeResponse;

public interface EmployeeService {

	public Employee getEmployeeById(Integer id);
	public String createEmployee(Employee emp);
	public String deleteEmployeeById(Integer id);
	public List<Employee> getAllEmployees();
	public JSONObject getStudent(Integer id);
	void updateEmployeeName(Integer id, String name);
	public List<Employee> getEmployeeByCityId(Integer id);
	public EmployeeResponse getEmployeeDetailsById(Integer id);
}
