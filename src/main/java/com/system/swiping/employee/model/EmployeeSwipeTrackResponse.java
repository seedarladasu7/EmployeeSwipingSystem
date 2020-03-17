package com.system.swiping.employee.model;

public class EmployeeSwipeTrackResponse {
	
	private int empId;
	private String empName;
	private String swipeInTime;
	private String swipeOutTiome;
	
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
	public String getSwipeInTime() {
		return swipeInTime;
	}
	public void setSwipeInTime(String swipeInTime) {
		this.swipeInTime = swipeInTime;
	}
	public String getSwipeOutTiome() {
		return swipeOutTiome;
	}
	public void setSwipeOutTiome(String swipeOutTiome) {
		this.swipeOutTiome = swipeOutTiome;
	}
	
}
