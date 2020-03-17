package com.system.swiping.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.swiping.employee.model.EmpSwipeRequest;
import com.system.swiping.employee.model.EmpSwipeResponse;
import com.system.swiping.employee.model.Employee;
import com.system.swiping.employee.model.EmployeeSwipeTrackResponse;
import com.system.swiping.employee.service.EmployeeSwipingService;

@RestController
@RequestMapping("/employees")
public class EmployeeSwipingController {

	@Autowired
	private EmployeeSwipingService swipingService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> registerEmployee(@RequestBody Employee request) {
		return new ResponseEntity<>(swipingService.registerEmployeeSwiping(request), HttpStatus.ACCEPTED);
	}
	
	

	@RequestMapping(value = "/registerSwipe", method = RequestMethod.POST)
	public ResponseEntity<String> registerEmployeeSwiping(@RequestBody EmpSwipeRequest request) {
		return new ResponseEntity<>(swipingService.registerEmployeeSwiping(request), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/viewSwipeDetails/{empId}", method = RequestMethod.GET)
	public ResponseEntity<EmpSwipeResponse> getEmpTimeInfo(@PathVariable("empId") Integer empId) {
		return new ResponseEntity<>(swipingService.getEmpTimeTrackingDetails(empId), HttpStatus.OK);
	}

	@RequestMapping(value = "/viewSwipeDetails/{empId}/{empName}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeSwipeTrackResponse> getEmpTimeTrackingInfo(@PathVariable("empId") Integer empId,
			@PathVariable("empName") String empName, @RequestParam("searchBy") String searchBy) throws Exception {
		return new ResponseEntity<>(swipingService.getEmployeeSwipeTrackReport(empId, empName, searchBy), HttpStatus.OK);
	}

}
