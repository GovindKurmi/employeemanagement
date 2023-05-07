package com.gk.employee.management.service.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.employee.management.dao.EmployeeSalarycalculationDao;
import com.gk.employee.management.model.EmployeeSalary;
import com.gk.employee.management.service.EmployeeSalarycalculationService;

@Service
public class EmployeeSalarycalculationServiceImpl implements EmployeeSalarycalculationService {

	@Autowired
	private EmployeeSalarycalculationDao employeeSalarycalculationDao;

	@Override
	public EmployeeSalary addEmployeeSalary(EmployeeSalary employeeSalary) {
		employeeSalary.setNetSalary(netSalaryCalculate(employeeSalary));
		return employeeSalarycalculationDao.save(employeeSalary);
	}

	private double netSalaryCalculate(EmployeeSalary emp) {
		return emp.getHra() + emp.getLta() + emp.getMa() + emp.getRwa();
	}

	@Override
	public double getNetSalary(Long id) {
		return employeeSalarycalculationDao.findNetSalaryById(id);
	}

}
