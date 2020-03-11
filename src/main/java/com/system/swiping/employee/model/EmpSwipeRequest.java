package com.system.swiping.employee.model;

import java.util.Date;

public class EmpSwipeRequest {

	private Integer empId;
	private String empName;
	private String swipeIn;
	private String swipeOut;
	private String date;
	private String locationName;
	private String swipingType;
	private Date currDate;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getSwipeIn() {
		return swipeIn;
	}

	public void setSwipeIn(String swipeIn) {
		this.swipeIn = swipeIn;
	}

	public String getSwipeOut() {
		return swipeOut;
	}

	public void setSwipeOut(String swipeOut) {
		this.swipeOut = swipeOut;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getSwipingType() {
		return swipingType;
	}

	public void setSwipingType(String swipingType) {
		this.swipingType = swipingType;
	}

	public Date getCurrDate() {
		return currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

}
