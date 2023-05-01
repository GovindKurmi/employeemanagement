package com.gk.employee.management.model;

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
@Table(name = "employeesalary")
public class EmployeeSalary {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  private double lta;
  private double hra;
  private double rwa;
  private double ma;
}
