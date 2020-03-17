package com.system.swiping.employee.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.system.swiping.employee.model.EmpSwipeRequest;
import com.system.swiping.employee.model.EmpSwipeResponse;
import com.system.swiping.employee.model.Employee;
import com.system.swiping.employee.model.EmployeeTimeTracking;
import com.system.swiping.employee.repository.EmployeeRepository;

@Repository
public class EmployeeSwipingTrackDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	EmployeeRepository empRepo;

	public void saveEmployee(EmpSwipeRequest empRequest, EmployeeTimeTracking timeTracking) {

		List<Employee> empList = findEmployeeById(empRequest.getEmpId());
		BigInteger employeeId = null;
		if (empList == null || empList.isEmpty()) {
			SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
			insertActor.withTableName("employee").usingGeneratedKeyColumns("id").usingColumns("empname", "currdate");
			BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(empRequest);
			employeeId = (BigInteger) insertActor.executeAndReturnKey(param);
		} else {
			Employee emp = empList.get(0);
			employeeId = BigInteger.valueOf(emp.getEmpId());
		}

		if (employeeId != null) {
			timeTracking.setEmpId(employeeId.intValue());
		}
		
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("employeetimetracking").usingGeneratedKeyColumns("id").usingColumns("swipein",
				"swipeout", "locationname", "swipingtype", "empid");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(timeTracking);
		insertActor.executeAndReturnKey(param);
	}

	public EmpSwipeResponse getEmpTimeTrackingInfo(int empId) {
		EmpSwipeResponse resp = new EmpSwipeResponse();

		List<Employee> empList = findEmployeeById(empId);
		if (empList != null && !empList.isEmpty()) {
			Employee emp = (Employee) empList.get(0);
			resp.setEmpId(emp.getEmpId());
			resp.setEmpName(emp.getEmpName());
			resp.setCurrDate(emp.getCurrDate());
		}

		return resp;
	}

	public List<Employee> findEmployeeById(int empId) {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		return template.query("select id, empname, currdate  from EMPLOYEE where id = :EmpId",
				new MapSqlParameterSource("EmpId", empId), new EmployeeMapper());
	}

	private static final class EmployeeMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new Employee();
			emp.setEmpId(rs.getInt("id"));
			emp.setEmpName(rs.getString("empname"));
			emp.setCurrDate(rs.getDate("currdate"));
			return emp;
		}
	}

	public com.system.swiping.employee.entity.Employee getEmployeeById(int empId) throws Exception {
		return empRepo.findById(new Integer(empId)).orElseThrow(Exception::new);
	}

	public com.system.swiping.employee.entity.Employee getEmployeeByName(String name) throws Exception {

		List<com.system.swiping.employee.entity.Employee> empList = empRepo.findByEmpName(name);

		if (empList != null && !empList.isEmpty())
			return empList.get(0);
		return new com.system.swiping.employee.entity.Employee();

	}

	/*
	 * public void saveEmployee(EmpSwipeRequest empRequestd) {
	 * 
	 * NamedParameterJdbcTemplate template = new
	 * NamedParameterJdbcTemplate(jdbcTemplate); String dateString =
	 * empRequestd.getDate(); DateFormat formatter = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 * 
	 * Date myDate; try { myDate = formatter.parse(dateString);
	 * 
	 * GregorianCalendar calendar = new GregorianCalendar();
	 * calendar.setTime(myDate); KeyHolder holder = new GeneratedKeyHolder();
	 * 
	 * SqlParameterSource parameters = new MapSqlParameterSource()
	 * .addValue("empId", empRequestd.getEmpId()) .addValue("empName",
	 * empRequestd.getEmpName()) .addValue("currDate", formatter.format(myDate));
	 * template.
	 * update("INSERT INTO EMPLOYEE (  id, empname, currdate) VALUES (:empId, :empName, :currDate)"
	 * , parameters, holder); System.out.println(" row inserted."); } catch
	 * (Exception e) { throw new RecordInsertionException(e.getMessage()); }
	 * 
	 * }
	 */}
