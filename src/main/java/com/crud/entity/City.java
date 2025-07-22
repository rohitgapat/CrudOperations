package com.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {

	@Id
	@Column(name="cityId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer cityId;
	@Column (name="cityName",unique = true,nullable = false)
	String cityName;
}
