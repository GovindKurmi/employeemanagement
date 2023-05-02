package com.gk.employee.management.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeSalarycalculationServiceImpl {

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
