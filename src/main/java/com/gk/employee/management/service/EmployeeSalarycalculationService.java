package com.gk.employee.management.service;

import com.gk.employee.management.model.EmployeeSalary;

public interface EmployeeSalarycalculationService {

	EmployeeSalary addEmployeeSalary(EmployeeSalary employeeSalary);

	double getNetSalary(Long id);

}
