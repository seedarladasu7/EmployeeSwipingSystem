package com.system.swiping.employee.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.system.swiping.employee.dao.EmployeeSwipingTrackDAO;
import com.system.swiping.employee.model.EmpSwipeRequest;
import com.system.swiping.employee.model.EmpSwipeResponse;
import com.system.swiping.employee.model.EmployeeEntity;
import com.system.swiping.employee.model.EmployeeTimeTracking;
import com.system.swiping.employee.service.EmployeeSwipingTrackEntityService;

@RestController
@RequestMapping("/")
public class EmployeeSwipingController {

	@Autowired
	private EmployeeSwipingTrackDAO dao;
	
	@Autowired
	private EmployeeSwipingTrackEntityService service;
	
	private static SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping(value = "/saveEmpTimeInfo", method = RequestMethod.POST)
	public String save(@RequestBody EmpSwipeRequest request) {

		EmployeeTimeTracking timeTracking = new EmployeeTimeTracking();

		try {
			timeTracking.setSwipingType(request.getSwipingType());
			
			if (request.getSwipingType().equalsIgnoreCase("IN")) {
				timeTracking.setSwipeIn(dateTime.parse(request.getSwipeIn()));
			} else if (request.getSwipingType().equalsIgnoreCase("OUT")) {
				timeTracking.setSwipeOut(dateTime.parse(request.getSwipeOut()));
			}
			request.setCurrDate(dateTime.parse(request.getDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		timeTracking.setLocationName(request.getLocationName());
		
		dao.saveEmployee(request, timeTracking);
		return "Date Saved Successfully...";
	}

	@RequestMapping(value = "/getEmpTimeInfo", method = RequestMethod.GET)
	public EmpSwipeResponse getEmpTimeInfo(@RequestBody EmpSwipeRequest request) {
		EmpSwipeResponse response = dao.getEmpTimeTrackingInfo(request);
		return response;
	}
	
	@RequestMapping(value = "/getEmpTimeTrackingInfo", method = RequestMethod.GET)
	public EmployeeEntity getEmpTimeTrackingInfo(@RequestBody EmpSwipeRequest request) throws Exception {
		EmployeeEntity response = service.getEmployeeById(request.getEmpId());
		return response;
	}

}
