package com.system.swiping.employee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	@Column
	private String empName;
	
	@Column
	private Date currDate;

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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", currDate=" + currDate + "]";
	}

}
