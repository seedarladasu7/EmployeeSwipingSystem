package com.system.swiping.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.swiping.employee.entity.EmployeeTimeTracking;


@Repository
public interface EmployeeTimeTrackingRepository extends JpaRepository<EmployeeTimeTracking, Integer>{

}
