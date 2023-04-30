package com.gk.employee.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.employee.management.model.Employee;
import com.gk.employee.management.service.EmployeeManagementService;

@RestController
@RequestMapping("rest/employee")
public class EmployeeManagementController {

	@Autowired
	private EmployeeManagementService employeeManagementService;

	@GetMapping("/getallemployee")
	public List<Employee> getAllEmployees() {
		return employeeManagementService.getAllEmployees();
	}

	@GetMapping("/getbyid/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Long id) {
		return employeeManagementService.getEmployeeById(id);
	}

	@PostMapping("/addemployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeManagementService.saveEmployee(employee);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable Long id) {
		employeeManagementService.deleteEmployeeById(id);
	}

}
