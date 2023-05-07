package com.gk.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.employee.management.model.EmployeeSalary;
import com.gk.employee.management.service.EmployeeSalarycalculationService;

@RestController
@RequestMapping("rest/employee/sal")
public class EmployeeSalaryCalcualtionController {

	@Autowired
	private EmployeeSalarycalculationService employeeSalarycalculationService;

	@PostMapping("addsalary")
	public EmployeeSalary addEmployeeSalary(@RequestBody EmployeeSalary employeeSalary) {
		return employeeSalarycalculationService.addEmployeeSalary(employeeSalary);
	}
}
