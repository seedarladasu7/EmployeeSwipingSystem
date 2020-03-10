package com.system.swiping.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.system.swiping.employee.dao.EmployeeSwipingTrackDAO;
import com.system.swiping.employee.model.EmpSwipeRequest;
import com.system.swiping.employee.model.EmpSwipeResponse;
import com.system.swiping.employee.model.Employee;
import com.system.swiping.employee.model.EmployeeTimeTracking;

@RestController
@RequestMapping("/")
public class EmployeeSwipingController {

	@Autowired
	private EmployeeSwipingTrackDAO dao;
	
	private static SimpleDateFormat dateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@RequestMapping(value = "/saveEmpTimeInfo", method = RequestMethod.POST)
	public String save(@RequestBody EmpSwipeRequest request) {

		EmployeeTimeTracking timeTracking = new EmployeeTimeTracking();

		try {
			if (request.getSwipingType().equalsIgnoreCase("IN")) {
				timeTracking.setSwipeIn(dateTime.parse(request.getSwipeIn()));
			} else if (request.getSwipingType().equalsIgnoreCase("OUT")) {
				timeTracking.setSwipeOut(dateTime.parse(request.getSwipeOut()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		timeTracking.setEmpId(request.getEmpId());
		timeTracking.setLocationName(request.getLocationName());

		dao.saveEmployee(request, timeTracking);
		return "Date Saved Successfully...";
	}

	@RequestMapping(value = "/getEmpTimeInfo", method = RequestMethod.GET)
	public EmpSwipeResponse viewHomePage(@RequestBody EmpSwipeRequest request) {
		EmpSwipeResponse response = dao.getEmpTimeTrackingInfo(request);
		return response;
	}

}
