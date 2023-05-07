package com.gk.employee.management.service.emp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.employee.management.dao.EmployeeManagementDao;
import com.gk.employee.management.model.Employee;
import com.gk.employee.management.service.EmployeeManagementService;
import com.gk.employee.management.service.EmployeeSalarycalculationService;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	@Autowired
	private EmployeeManagementDao employeeManagementDao;

	@Autowired
	private EmployeeSalarycalculationService employeeSalarycalculationService;

	public List<Employee> getAllEmployees() {
		return employeeManagementDao.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return employeeManagementDao.findById(id);
	}

	public Employee saveEmployee(Employee employee) {
		double netSalary = employeeSalarycalculationService.getNetSalary(employee.getId());
		employee.setSalary(netSalary);
		return employeeManagementDao.save(employee);
	}

	public void deleteEmployeeById(Long id) {
		employeeManagementDao.deleteById(id);

	}

}
