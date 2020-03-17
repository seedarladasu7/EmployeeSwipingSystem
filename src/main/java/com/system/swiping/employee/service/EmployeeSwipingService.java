package com.system.swiping.employee.service;

import com.system.swiping.employee.model.EmpSwipeRequest;
import com.system.swiping.employee.model.EmpSwipeResponse;
import com.system.swiping.employee.model.EmployeeSwipeTrackResponse;

public interface EmployeeSwipingService {
	
	public String registerEmployeeSwiping(EmpSwipeRequest request);
	
	public EmpSwipeResponse getEmpTimeTrackingDetails(int request);
	 
	public EmployeeSwipeTrackResponse getEmployeeSwipeTrackReport(int empId, String empName, String searchBy);

}
