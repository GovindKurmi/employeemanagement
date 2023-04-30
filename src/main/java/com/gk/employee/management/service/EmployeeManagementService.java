package com.gk.employee.management.service;

import java.util.List;
import java.util.Optional;

import com.gk.employee.management.model.Employee;

public interface EmployeeManagementService {

	List<Employee> getAllEmployees();

	Optional<Employee> getEmployeeById(Long id);

	Employee saveEmployee(Employee employee);

	void deleteEmployeeById(Long id);

}
