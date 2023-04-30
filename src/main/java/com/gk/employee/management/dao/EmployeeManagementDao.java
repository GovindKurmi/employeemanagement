package com.gk.employee.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gk.employee.management.model.Employee;

public interface EmployeeManagementDao extends JpaRepository<Employee,Long> {

}
