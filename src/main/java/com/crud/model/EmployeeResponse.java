package com.crud.model;

import com.crud.entity.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {
	private Integer employeeId;
	private String employeeName;
	private String departmentName;
	private String designation;
	private String email;
	private Double salary;
	private City city;
}
