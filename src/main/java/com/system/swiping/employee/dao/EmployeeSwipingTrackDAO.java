package com.system.swiping.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.system.swiping.employee.model.EmpSwipeRequest;
import com.system.swiping.employee.model.EmpSwipeResponse;
import com.system.swiping.employee.model.Employee;
import com.system.swiping.employee.model.EmployeeTimeTracking;

@Repository
public class EmployeeSwipingTrackDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveEmployee(EmpSwipeRequest empRequest, EmployeeTimeTracking timeTracking) {

		List<Employee> emp1 = findEmployeeById(empRequest.getEmpId());

		if (emp1 != null && !emp1.isEmpty()) {
			SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
			insertActor.withTableName("Employee").usingColumns("empId", "empName", "currDate");
			BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(empRequest);
			insertActor.execute(param);
		} else {
			saveEmployee(empRequest);
		}

		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("EmployeeTimeTracking").usingColumns("trackingID", "swipeIn", "swipeOut",
				"locationName", "swipingType", "empID");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(timeTracking);
		insertActor.execute(param);
	}

	public EmpSwipeResponse getEmpTimeTrackingInfo(EmpSwipeRequest request) {
		EmpSwipeResponse resp = new EmpSwipeResponse();

		List<Employee> empList = findEmployeeById(request.getEmpId());
		if (empList != null && !empList.isEmpty()) {
			Employee emp = (Employee) empList.get(0);
			resp.setEmpId(emp.getEmpId());
			resp.setEmpName(emp.getEmpName());
			resp.setCurrDate(emp.getCurrDate());
		} else {
			return resp;
		}
		return resp;
	}

	public List<Employee> findEmployeeById(int empId) {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		return template.query("select empId, empName, currDate  from EMPLOYEE where empId = :EmpId",
				new MapSqlParameterSource("EmpId", empId), new EmployeeMapper());
	}

	private static final class EmployeeMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new Employee();
			emp.setEmpId(rs.getInt("empId"));
			emp.setEmpName(rs.getString("empName"));
			emp.setCurrDate(rs.getDate("currDate"));
			;
			return emp;
		}
	}

	public void saveEmployee(EmpSwipeRequest empRequestd) {

		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		String dateString = empRequestd.getDate();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date myDate;
		try {
			myDate = formatter.parse(dateString);

			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(myDate);
			KeyHolder holder = new GeneratedKeyHolder();
		
			SqlParameterSource parameters = new MapSqlParameterSource()
					.addValue("empId", empRequestd.getEmpId())
					.addValue("empName", empRequestd.getEmpName())
					.addValue("currDate", formatter.format(myDate));
			template.update("INSERT INTO EMPLOYEE (  empId, empName, currDate) VALUES (:empId, :empName, :currDate)", parameters,
					holder);
			System.out.println(" row inserted.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
