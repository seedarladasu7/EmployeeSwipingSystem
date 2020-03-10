package com.system.swiping.employee.model;

import java.util.Date;

public class Employee {

	private int empId;
	private String empName;
	private Date currDate;

	public Employee() {

	}

	public Employee(int empId) {
		this.empId = empId;
	}

	public Employee(int empId, String empName, Date currDate) {
		this.empId = empId;
		this.empName = empName;
		this.currDate = currDate;
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", currDate=" + currDate + "]";
	}

}
