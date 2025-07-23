package com.crud.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Employee;
import com.crud.exception.EmployeeNotFoundException;
import com.crud.model.EmployeeResponse;
import com.crud.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public EmployeeResponse createEmployee(EmployeeResponse dto) {
        Employee employee = mapToEntity(dto);
        Employee saved = empRepo.save(employee);
        return mapToResponse(saved);
    }

    @Override
    public EmployeeResponse getEmployeeById(Integer id) {
        Employee emp = empRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        return mapToResponse(emp);
    }

    @Override
    public EmployeeResponse updateEmployee(Integer id, EmployeeResponse dto) {
        Employee existing = empRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        existing.setEmployeeName(dto.getEmployeeName());
        existing.setDepartmentName(dto.getDepartmentName());
        existing.setDesignation(dto.getDesignation());
        existing.setEmail(dto.getEmail());
        existing.setSalary(dto.getSalary());

        return mapToResponse(empRepo.save(existing));
    }

    @Override
    public EmployeeResponse deleteEmployee(Integer id) {
        Employee emp = empRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        empRepo.delete(emp);
        return mapToResponse(emp);
    }
    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return empRepo.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public String getStudent(Integer id) {
        Employee emp = empRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student not found with id: " + id));
        return "Student Name: " + emp.getEmployeeName() + ", Department: " + emp.getDepartmentName();
    }
    private EmployeeResponse mapToResponse(Employee emp) {
        return EmployeeResponse.builder()
                .employeeId(emp.getEmployeeId())
                .employeeName(emp.getEmployeeName())
                .departmentName(emp.getDepartmentName())
                .designation(emp.getDesignation())
                .email(emp.getEmail())
                .salary(emp.getSalary())
                //.city(emp.getCity())
                .build();
    }

    private Employee mapToEntity(EmployeeResponse dto) {
        Employee emp = new Employee();
        emp.setEmployeeId(dto.getEmployeeId());
        emp.setEmployeeName(dto.getEmployeeName());
        emp.setDepartmentName(dto.getDepartmentName());
        emp.setDesignation(dto.getDesignation());
        emp.setEmail(dto.getEmail());
        emp.setSalary(dto.getSalary());
       // emp.setCity(dto.getCity());
        return emp;
    }
}