package com.system.swiping.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.swiping.employee.model.EmployeeEntity;
import com.system.swiping.employee.repository.EmployeeRepository;

@Service
public class EmployeeSwipingTrackEntityService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public EmployeeEntity getEmployeeById(int empId) throws Exception {
		return empRepo.findById(new Integer(empId)).orElseThrow(Exception::new);
	}
	
	
	public EmployeeEntity getEmployeeByName(String name) throws Exception {
		
		List<EmployeeEntity> empList = empRepo.findByEmpName(name); 
		if(empList != null && !empList.isEmpty()) 
			return empList.get(0);
		return null;
		
	}
	
	
	

}
