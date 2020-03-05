package com.system.swiping.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.system.swiping.employee.model.EmpSwipeRequest;
import com.system.swiping.employee.model.EmpSwipeResponse;
import com.system.swiping.employee.model.Employee;
import com.system.swiping.employee.model.EmployeeTimeTracking;

@Repository
public class EmployeeSwipingTrackDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void saveEmployee(Employee emp, EmployeeTimeTracking timeTracking) {
		if (!findEmployeeById(emp.getEmpId()).isPresent()) {
			SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
			insertActor.withTableName("Employee").usingColumns("EmpId", "EmpName", "CurrDate");
			BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(emp);
			insertActor.execute(param);
		}
		
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("EmployeeTimeTracking").usingColumns("TrackingID", "SwipeIn", "SwipeOut", "LocatioName", "EmpID");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(timeTracking);
		insertActor.execute(param);
	}

	public EmpSwipeResponse getEmpTimeTrackingInfo(EmpSwipeRequest request) {
		EmpSwipeResponse resp = new EmpSwipeResponse();
		
		Optional<Employee> empOptional = findEmployeeById(request.getEmpId());
		if (empOptional.isPresent()) { 
			Employee emp = empOptional.get();
			
			resp.setEmpId(emp.getEmpId());
			resp.setEmpName(emp.getEmpName());
			resp.setCurrDate(emp.getCurrDate());
			
		} else {
			return resp;
		}
		
		
		return resp;
	}
	public Optional<Employee> findEmployeeById(int id) {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		return (Optional<Employee>) template.queryForObject("select * from EMPLOYEE where EmpId = :EmpId",
				new MapSqlParameterSource("EmpId", id), (rs, rowNum) -> Optional.of(new Employee(rs.getInt("EmpId"))));
	}
	
	final Map<Integer, EmployeeTimeTracking> rcptHdr = jdbcTemplate.query(""
			+ "select h.empId, h.empName, d.currDate, "
			+ "d.trackingId, d.swipeIn, d.swipeOut, d.locationName from employee h "
			+ "inner join employeetimetracking on h.empId = d.empId", 
			new ResultSetExtractor<Map<Integer, EmployeeTimeTracking>>() {
         public Map<Integer, EmployeeTimeTracking> extractData(ResultSet rs) throws SQLException, DataAccessException {
             Map<Integer, EmployeeTimeTracking> rcptHdr = new HashMap<Integer, EmployeeTimeTracking>();
             while(rs.next()) {
                 Integer rcptId = rs.getInt("empId");
                 EmployeeTimeTracking rcptHeader = (EmployeeTimeTracking) rcptHdr.get(rcptId);
                 if (rcptHeader == null) {
                     String hdrRemark = rs.getString("empName");
                     rcptHeader = new EmployeeTimeTracking();
                     //rcptHeader.setRcptId(rcptId);
                    // rcptHeader.setHdrRemark(hdrRemark);
                     rcptHdr.put(rcptId, rcptHeader);
                 }
                 EmployeeTimeTracking rcptDet = new EmployeeTimeTracking();
                 
             }
             return rcptHdr;
         }
     });
				

}
