package com.system.swiping.employee.model;

import java.util.Date;

public class EmpSwipeResponse {
	
	private int empId;
	private String empName;
	private Date currDate;
	private EmployeeTimeTracking timeTracking;
	
	public EmpSwipeResponse() {}
	
	public EmpSwipeResponse(int empId, String empName, Date currDate, EmployeeTimeTracking timeTracking) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.currDate = currDate;
		this.timeTracking = timeTracking;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getCurrDate() {
		return currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

	public EmployeeTimeTracking getTimeTracking() {
		return timeTracking;
	}

	public void setTimeTracking(EmployeeTimeTracking timeTracking) {
		this.timeTracking = timeTracking;
	}
	
}
