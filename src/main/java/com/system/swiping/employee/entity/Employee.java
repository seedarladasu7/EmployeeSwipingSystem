package com.system.swiping.employee.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer empId;
	
	@Column
	private String empName;
	
	@Column
	private Date swipeOn;
	
	@OneToMany(mappedBy="employeeEntry", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<EmployeeTimeTracking> trackingEntries;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", swipeOn=" + swipeOn + "]";
	}

}
