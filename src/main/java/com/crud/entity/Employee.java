package com.crud.entity;

import org.springframework.jmx.export.annotation.ManagedAttribute;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="employee_data")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {

	@Id
	@Column(name="employee_id")
	Integer employeeId;
	@Column(name="employee_name")
	String employeeName;
	@Column(name="department_name")
	String departmentName;
	@Column (name="designation")
	String designation;
	@Column (name="email")
	String email;
	@Column (name="salary")
	Double salary;		
	
	@ManyToOne
	@JoinColumn(name="city_id",nullable = false)
	public City city;
	
}
