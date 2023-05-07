package com.gk.employee.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gk.employee.management.model.EmployeeSalary;

public interface EmployeeSalarycalculationDao extends JpaRepository<EmployeeSalary, Long>{
    
    @Query("SELECT netSalary FROM EmployeeSalary es WHERE es.id = :id")
    double findNetSalaryById(@Param("id") Long id);

}
