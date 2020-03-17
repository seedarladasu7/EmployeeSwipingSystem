package com.system.swiping.employee.service;

import com.system.swiping.employee.model.EmpSwipeRequest;
import com.system.swiping.employee.model.EmpSwipeResponse;
import com.system.swiping.employee.model.EmployeeSwipeTrackResponse;

public interface EmploeeSwipingService {
	
	public String registerEmployeeSwiping(EmpSwipeRequest request);
	
	public EmpSwipeResponse getEmpTimeTrackingDetails(EmpSwipeRequest request);
	 
	public EmployeeSwipeTrackResponse getEmployeeSwipeTrackReport(EmpSwipeRequest request);

}
