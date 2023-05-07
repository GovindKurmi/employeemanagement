package com.gk.employee.management.service.emp;

import org.springframework.stereotype.Service;

import com.gk.employee.management.service.EmployeeSalarycalculationService;

@Service
public class EmployeeSalarycalculationServiceImpl implements EmployeeSalarycalculationService{

	public double fixedSalary(double netSalary) {
		String game = "Cricket";
		switch (game) {
		case "Hockey":
			System.out.println("Let's play Hockey");
			break;
		case "Cricket":
			System.out.println("Let's play Cricket");
			break;
		case "Football":
			System.out.println("Let's play Football");
		}
		return 0;
	}

}
