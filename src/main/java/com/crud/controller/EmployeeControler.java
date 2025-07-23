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
	public ResponseEntity<EmployeeResponse> getEmployeeName(@PathVariable Integer id) {
		EmployeeResponse emp= empServise.getEmployeeById(id);
		if(emp!=null) {
			return ResponseEntity.ok(emp);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	@PostMapping("/save")
	public ResponseEntity<EmployeeResponse> create(@RequestBody EmployeeResponse emp) {
		EmployeeResponse save= empServise.createEmployee(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<String> delete (@PathVariable Integer id){
		EmployeeResponse del= empServise.deleteEmployee(id);
		if(del!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
	    List<EmployeeResponse> list = empServise.getAllEmployees();
	    return ResponseEntity.ok(list);
	}
	
	@GetMapping("student_details/{id}")
	public ResponseEntity<String> getStudent(@PathVariable Integer id) {
	    String studentDetails = empServise.getStudent(id);
		return ResponseEntity.ok(studentDetails);

	}
	
	@PostMapping("/updatename/{id}")
	public ResponseEntity<EmployeeResponse> updateEmployeeName(@PathVariable Integer id, @RequestBody EmployeeResponse name) {
	    EmployeeResponse emp= empServise.updateEmployee(id, name);
	    if(emp!=null) {
	    	return ResponseEntity.ok(emp);
	    }
	    else {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	@GetMapping ("/cityid/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeByCityId(@PathVariable Integer id) {
		EmployeeResponse emp = empServise.getEmployeeById(id);
		  return ResponseEntity.ok(emp);
	}
}
