package com.system.swiping.employee.service;

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
		//Optional<EmployeeEntity> entityOpt = 
		
		return empRepo.findById(new Integer(empId)).orElseThrow(Exception::new);
	}
	
	

}
