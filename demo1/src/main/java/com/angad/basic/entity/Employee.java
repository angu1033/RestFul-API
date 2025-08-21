package com.angad.basic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	private Integer empNo;
	private String empName;
	private Double empSal;
}
