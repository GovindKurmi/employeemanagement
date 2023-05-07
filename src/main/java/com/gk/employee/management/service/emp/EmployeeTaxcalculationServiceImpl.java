package com.gk.employee.management.service.emp;

import org.springframework.stereotype.Service;

import com.gk.employee.management.service.EmployeeTaxcalculationService;

@Service
public class EmployeeTaxcalculationServiceImpl implements EmployeeTaxcalculationService {

	@Override
	public double inHandSalary(double income) {
		double tax = 0;

		if (income <= 250000) {
			// No tax for income up to 2.5 lakhs
			tax = 0;
		} else if (income <= 500000) {
			// 5% tax for income between 2.5 lakhs and 5 lakhs
			tax = (income - 250000) * 0.05;
		} else if (income <= 750000) {
			// 10% tax for income between 5 lakhs and 7.5 lakhs
			tax = 12500 + (income - 500000) * 0.1;
		} else if (income <= 1000000) {
			// 15% tax for income between 7.5 lakhs and 10 lakhs
			tax = 37500 + (income - 750000) * 0.15;
		} else if (income <= 1250000) {
			// 20% tax for income between 10 lakhs and 12.5 lakhs
			tax = 75000 + (income - 1000000) * 0.2;
		} else if (income <= 1500000) {
			// 25% tax for income between 12.5 lakhs and 15 lakhs
			tax = 125000 + (income - 1250000) * 0.25;
		} else {
			// 30% tax for income above 15 lakhs
			tax = 187500 + (income - 1500000) * 0.3;
		}

		return income - tax;
	}

}
