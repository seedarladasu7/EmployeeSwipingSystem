package com.system.swiping.employee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employee_time_tracking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTimeTracking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empId", insertable=false, updatable=false)
	@JsonBackReference
	private Employee employeeEntry;
	

	@Override
	public String toString() {
		return "EmployeeTimeTracking [trackingID=" + trackingID + ", swipeIn=" + swipeIn + ", swipeOut=" + swipeOut
				+ ", locationName=" + locationName + ", swipingType=" + swipingType + ", empId=" + empId + "]";
	}

}
