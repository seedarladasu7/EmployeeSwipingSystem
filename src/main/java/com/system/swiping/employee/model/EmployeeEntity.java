package com.system.swiping.employee.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer empId;
	
	@Column(name = "empname")
	private String empName;
	
	@Column(name = "currdate")
	private Date currDate;
	
	@OneToMany(mappedBy="employeeentry", cascade = CascadeType.ALL)
	private Set<EmployeeTimeTrackingEntity> trackingentries;

	public EmployeeEntity() {

	}
	
	public EmployeeEntity(Integer empId, String empName, Date currDate) {
		this.empId = empId;
		this.empName = empName;
		this.currDate = currDate;
	}

	public EmployeeEntity(Integer empId) {
		this.empId = empId;
	}

	
	public int getEmpId() {
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

	public Date getCurrDate() {
		return currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}
	
	public Set<EmployeeTimeTrackingEntity> getTrackingentries() {
		return trackingentries;
	}

	public void setTrackingEntries(Set<EmployeeTimeTrackingEntity> trackingentries) {
		this.trackingentries = trackingentries;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", currDate=" + currDate + "]";
	}

}
