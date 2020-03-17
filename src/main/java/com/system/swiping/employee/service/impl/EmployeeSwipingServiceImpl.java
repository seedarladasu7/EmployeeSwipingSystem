package com.system.swiping.employee.service.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.swiping.employee.dao.EmployeeSwipingTrackDAO;
import com.system.swiping.employee.entity.Employee;
import com.system.swiping.employee.model.EmpSwipeRequest;
import com.system.swiping.employee.model.EmpSwipeResponse;
import com.system.swiping.employee.model.EmployeeSwipeTrackResponse;
import com.system.swiping.employee.model.EmployeeTimeTracking;
import com.system.swiping.employee.service.EmployeeSwipingService;

@Service
public class EmployeeSwipingServiceImpl implements EmployeeSwipingService {

	@Autowired
	private EmployeeSwipingTrackDAO dao;

	private static SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

	public String registerEmployeeSwiping(EmpSwipeRequest request) {
		EmployeeTimeTracking timeTracking = new EmployeeTimeTracking();

		try {
			timeTracking.setSwipingType(request.getSwipingType());

			if (request.getSwipingType().equalsIgnoreCase("IN")) {
				timeTracking.setSwipeIn(dateTimeFormatter.parse(request.getSwipeIn()));
			} else if (request.getSwipingType().equalsIgnoreCase("OUT")) {
				timeTracking.setSwipeOut(dateTimeFormatter.parse(request.getSwipeOut()));
			}
			request.setCurrDate(dateTimeFormatter.parse(request.getDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		timeTracking.setLocationName(request.getLocationName());

		dao.saveEmployee(request, timeTracking);
		return "Date Saved Successfully...";
	}

	@Override
	public EmpSwipeResponse getEmpTimeTrackingDetails(int empId) {
		return dao.getEmpTimeTrackingInfo(empId);
	}

	public EmployeeSwipeTrackResponse getEmployeeSwipeTrackReport(int empId, String empName, String searchBy) {
		Employee empEntity = null;

		Date swipeInTime = null;
		Date swipeOutTime = null;

		try {
			if (searchBy.equalsIgnoreCase("ID")) {
				empEntity = dao.getEmployeeById(empId);
			} else if (searchBy.equalsIgnoreCase("NAME")) {
				empEntity = dao.getEmployeeByName(searchBy);
			}

			EmployeeSwipeTrackResponse response = new EmployeeSwipeTrackResponse();
			JSONObject respJson = new JSONObject();
			if (empEntity != null) {
				response.setEmpId(empEntity.getEmpId());
				response.setEmpName(empEntity.getEmpName());

				List<com.system.swiping.employee.entity.EmployeeTimeTracking> trackingentries = empEntity
						.getTrackingEntries();
				String dateStr = "";
				if (trackingentries != null && !trackingentries.isEmpty()) {
					for (com.system.swiping.employee.entity.EmployeeTimeTracking trackingEntry : trackingentries) {

						// dateStr = date.format(trackingEntry.getCurrDate());

						if (trackingEntry.getSwipingType().equalsIgnoreCase("IN")) {

						} else if (trackingEntry.getSwipingType().equalsIgnoreCase("OUT")) {

						}

						// respJson.put(dateStr, value)

					}
				}

			}

			return response;

		} catch (Exception exc) {
			exc.getMessage();
		}

		return null;
	}

}
