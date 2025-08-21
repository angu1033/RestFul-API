package com.angad.basic.service;

import com.angad.basic.entity.Employee;

public interface EmployeeService {

	String addRecord(Employee employee);
	
	Employee findRecord(Integer empNo);
	
	String removeRecord(Integer empNo);
	
	String updateRecord(Employee employee);



}