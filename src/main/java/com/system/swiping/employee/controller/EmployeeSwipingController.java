package com.system.swiping.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.system.swiping.employee.model.EmpSwipeRequest;
import com.system.swiping.employee.model.EmpSwipeResponse;
import com.system.swiping.employee.model.EmployeeSwipeTrackResponse;
import com.system.swiping.employee.service.EmploeeSwipingService;

@RestController
@RequestMapping("/")
public class EmployeeSwipingController {

	@Autowired
	private EmploeeSwipingService swipingService;

	@RequestMapping(value = "/registerSwipe", method = RequestMethod.POST)
	public ResponseEntity<String> registerEmployeeSwiping(@RequestBody EmpSwipeRequest request) {
		return new ResponseEntity<>(swipingService.registerEmployeeSwiping(request), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/viewSwipeDetails", method = RequestMethod.GET)
	public ResponseEntity<EmpSwipeResponse> getEmpTimeInfo(@RequestBody EmpSwipeRequest request) {
		return new ResponseEntity<>(swipingService.getEmpTimeTrackingDetails(request), HttpStatus.OK);
	}

	@RequestMapping(value = "/viewEmployeeSwipeDetails", method = RequestMethod.GET)
	public ResponseEntity<EmployeeSwipeTrackResponse> getEmpTimeTrackingInfo(@RequestBody EmpSwipeRequest request)
			throws Exception {
		return new ResponseEntity<>(swipingService.getEmployeeSwipeTrackReport(request), HttpStatus.OK);
	}

}
