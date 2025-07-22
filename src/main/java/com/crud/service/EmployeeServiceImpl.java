package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Employee;
import com.crud.model.EmployeeResponse;
import com.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public Employee getEmployeeById(Integer id) {
		Employee emp=null;
		try {
			 emp =empRepo.findById(id).orElseThrow(()-> new NullPointerException("Employee not found"));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public String createEmployee(Employee emp) {
		return "employee save" + empRepo.save(emp);
	}

	@Override
	public String deleteEmployeeById(Integer id) {
		empRepo.deleteById(id);
		return "Employee deleted";
	}
	
	@Override
	public List<Employee> getAllEmployees() {
	    return empRepo.findAll();
	}
	
	public JSONObject getStudent(Integer id) {
		JSONArray students = new JSONArray();
		JSONObject student = new JSONObject();
		student.put("name", "rohit");
		student.put("education", "BCA");
		student.put("marks",19);
		student.put("id", 1);
		
		JSONObject student1 = new JSONObject();
		student1.put("name", "Abhijit");
		student1.put("education", "BCA");
		student1.put("marks",19);
		student1.put("id", 2);
		
		students.put(student);
		students.put(student1);
		
		for(int i =0; i < students.length(); i++) {
			JSONObject obj = (JSONObject)students.get(i);
			if((Integer)obj.get("id") == id) {
				return obj;
			}
		}
		
		return new JSONObject().put("status", "student not found");
		
	}

	@Override
	public void updateEmployeeName(Integer id, String name) {
		 Employee emp = empRepo.findById(id).get(); 
		    emp.setDepartmentName(name);
		    empRepo.save(emp);
		
	}
	
	public List<Employee> getEmployeeByCityId(Integer id) {
		List<Employee> employee=empRepo.findByCityCityId(id);
		return  employee;
	}

	@Override
	public EmployeeResponse getEmployeeDetailsById(Integer id) {
		Employee emp = empRepo.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
		
		EmployeeResponse res = EmployeeResponse.builder()
	            .employeeId(emp.getEmployeeId())
	            .employeeName(emp.getEmployeeName())
	            .departmentName(emp.getDepartmentName())
	            .designation(emp.getDesignation())
	            .email(emp.getEmail())
	            .salary(emp.getSalary())
	            .build();                                		  
		return res;
	}
	
	
}
