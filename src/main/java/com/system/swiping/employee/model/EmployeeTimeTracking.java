package com.system.swiping.employee.model;

import java.util.Date;

public class EmployeeTimeTracking {

	private int trackingID;
	private Date swipeIn;
	private Date swipeOut;
	private String locationName;
	private int empId;

	public EmployeeTimeTracking() {
	}

	public EmployeeTimeTracking(int trackingID, Date swipeIn, Date swipeOut, String locationName, int empId) {
		super();
		this.trackingID = trackingID;
		this.swipeIn = swipeIn;
		this.swipeOut = swipeOut;
		this.locationName = locationName;
		this.empId = empId;
	}

	public int getTrackingID() {
		return trackingID;
	}

	public void setTrackingID(int trackingID) {
		this.trackingID = trackingID;
	}

	public Date getSwipeIn() {
		return swipeIn;
	}

	public void setSwipeIn(Date swipeIn) {
		this.swipeIn = swipeIn;
	}

	public Date getSwipeOut() {
		return swipeOut;
	}

	public void setSwipeOut(Date swipeOut) {
		this.swipeOut = swipeOut;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "EmployeeTimeTracking [trackingID=" + trackingID + ", swipeIn=" + swipeIn + ", swipeOut=" + swipeOut
				+ ", locationName=" + locationName + ", empId=" + empId + "]";
	}

}
