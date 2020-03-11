package com.system.swiping.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.swiping.employee.model.EmployeeEntity;


@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer>{
	
	Optional<EmployeeEntity> findById(Integer empId);
	List<EmployeeEntity> findByEmpName(String empName);
    List<EmployeeEntity> findByEmpIdAndEmpName(Integer empId, String empName);

	/*
	 * @Query("SELECT a FROM EmployeeEntity a WHERE a.title=:title and a.category=:category"
	 * ) List<EmployeeEntity> fetchArticles(@Param("title") String
	 * title, @Param("category") String category);
	 */

}
