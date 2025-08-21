package com.angad.basic.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angad.basic.entity.Employee;
import com.angad.basic.service.EmployeeService;

	@RestController
	@RequestMapping("/employee")
	public class EmployeeControler 
	{
		@Autowired
		private EmployeeService employeeService;
		
		@PostMapping
		public String addRecord(@RequestBody  Employee employee) 
		{
			return employeeService.addRecord(employee);
		}
		@GetMapping
		public Employee findRecord(@RequestParam Integer empNo) 
		{
			return employeeService.findRecord(empNo);
		}
		
		@DeleteMapping("/{empNo}")
		public String removeRecord(@PathVariable Integer empNo) 
		{
			return employeeService.removeRecord(empNo);
		}
		@PutMapping
	    public String updateRecord(@RequestParam Integer empNo, @RequestBody Employee employee) {
	        employee.setEmpNo(empNo); 
	        return employeeService.updateRecord(employee);
	    }
	}
