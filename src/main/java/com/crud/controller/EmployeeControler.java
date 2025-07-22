package com.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.model.EmployeeResponse;
import com.crud.service.EmployeeService;

import java.net.ResponseCache;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/employees")


public class EmployeeControler {
	
	@Autowired 
	//@Qualifier("mployeeServiceImpl")
	EmployeeService empServise;
	
	@GetMapping("/{id}")
	public Employee getEmployeeName(@PathVariable Integer id) {
		return empServise.getEmployeeById(id);
	}
	@PostMapping("/save")
	public ResponseEntity<String> create(@RequestBody Employee emp) {
		String save= empServise.createEmployee(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<String> delete (@PathVariable Integer id){
		String del= empServise.deleteEmployeeById(id);
		return ResponseEntity.ok(del);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
	    List<Employee> list = empServise.getAllEmployees();
	    return ResponseEntity.ok(list);
	}
	
	@GetMapping("student_details/{id}")
	public ResponseEntity<String> getStudent(@PathVariable Integer id) {
	    String studentDetails = empServise.getStudent(id).toString();
		return ResponseEntity.ok(studentDetails);

	}
	
	@PostMapping("/updatename/{id}")
	public String updateEmployeeName(@PathVariable Integer id, @RequestBody String name) {
	    empServise.updateEmployeeName(id, name);
	    return "Employee name updated successfully";
	}
	
	@GetMapping ("/cityid/{id}")
	public ResponseEntity< List<Employee>> getEmployeeByCityId(@PathVariable Integer id) {
		List<Employee> emp = empServise.getEmployeeByCityId(id);
		  return ResponseEntity.ok(emp);
	}
	
	  @GetMapping("employees/{id}")
	    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Integer id) {
	        EmployeeResponse employee = empServise.getEmployeeDetailsById(id);
	        return ResponseEntity.ok(employee);
	    }
}
