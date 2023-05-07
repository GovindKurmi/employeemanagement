package com.gk.employee.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employeesalary")
public class EmployeeSalary {

	@Id
	@Column(nullable = true)
	private long id;
	private double lta;
	private double hra;
	private double rwa;
	private double ma;
	private double netSalary;
}
