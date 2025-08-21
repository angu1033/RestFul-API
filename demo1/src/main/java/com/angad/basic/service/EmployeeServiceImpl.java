package com.angad.basic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angad.basic.dao.EmployeeDao;
import com.angad.basic.entity.Employee;
import com.angad.basic.exception.ResourceNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public String addRecord(Employee employee)
	{
		dao.saveAndFlush(employee);
		return "Add Record Succesfully......";
	}

//	@Override
//	public Employee findRecord(Integer empNo)
//	{
//		Optional<Employee> opt =dao.findById(empNo);
//		if(opt.isPresent())
//			return opt.get();
//		else
//			return null;
//	}

	@Override
	public Employee findRecord(Integer empNo) {
		return dao.findById(empNo).orElseThrow(()-> new ResourceNotFoundException("Employee with empNo "+empNo+ "not found"));
	}
	
	
//	@Override
//	public String removeRecord(Integer empNo) {
//		Optional<Employee> opt =dao.findById(empNo);
//		if(opt.isPresent())
//		{
//			dao.deleteById(empNo);
//			return "Object Deleted";
//		}else {
//			return "Object Not Found";
//	}	
//}
	@Override
	public String removeRecord(Integer empNo) {
		if(dao.existsById(empNo)) {
			dao.deleteById(empNo);
			return "object Deleted";
		}else {
			throw new ResourceNotFoundException("Employee with empNo "+empNo + "not found");
		}
	}

	@Override
	public String updateRecord(Employee employee) {
	   
	    Optional<Employee> existing = dao.findById(employee.getEmpNo());
	    
	    if (existing.isPresent()) {
	        dao.saveAndFlush(employee);
	        return "Employee record updated successfully!";
	    } else {
	    	return "Employee with ID " + employee.getEmpNo() + " not found.";
//	    	dao.save(employee);
//	        return "Employee record created with empNo: " + employee.getEmpNo();
	    }
	}

	
	
	
	
	

		
}