package com.system.swiping.employee.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employeetimetracking")
public class EmployeeTimeTrackingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trackingID;
	
	@Column
	private Date swipeIn;
	
	@Column
	private Date swipeOut;
	
	@Column
	private String locationName;
	
	@Column
	private String swipingType;
	
	@Column
	private int empId;

	public EmployeeTimeTrackingEntity() {
	}

	public EmployeeTimeTrackingEntity(Integer trackingID, Date swipeIn, Date swipeOut, String locationName, String swipingType, int empId) {
		super();
		this.trackingID = trackingID;
		this.swipeIn = swipeIn;
		this.swipeOut = swipeOut;
		this.locationName = locationName;
		this.swipingType = swipingType;
		this.empId = empId;
	}

	public Integer getTrackingID() {
		return trackingID;
	}

	public void setTrackingID(Integer trackingID) {
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
	
	public String getSwipingType() {
		return swipingType;
	}

	public void setSwipingType(String swipingType) {
		this.swipingType = swipingType;
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
				+ ", locationName=" + locationName + ", swipingType=" + swipingType + ", empId=" + empId + "]";
	}

}
