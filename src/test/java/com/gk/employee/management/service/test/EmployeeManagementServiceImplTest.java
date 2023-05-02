package com.gk.employee.management.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.gk.employee.management.dao.EmployeeManagementDao;
import com.gk.employee.management.model.Employee;
import com.gk.employee.management.service.EmployeeManagementServiceImpl;

@SpringBootTest
class EmployeeManagementServiceImplTest {

	@InjectMocks
	private EmployeeManagementServiceImpl employeeManagementService;

	@Mock
	private EmployeeManagementDao dao;

	@Test
	final void testGetAllEmployees() {
		Employee employee = Employee.builder().id(1L).firstName("raj").lastName("kumar").email("raj@123").build();
		Employee employee1 = Employee.builder().id(2L).firstName("raj").lastName("kumar").email("raj@123").build();
		List<Employee> employees = List.of(employee, employee1);

		when(dao.findAll()).thenReturn(employees);
		List<Employee> emp = employeeManagementService.getAllEmployees();
        
		assertNotNull(emp);
		assertEquals(2, emp.size());
	}

	@Test
	final void testGetEmployeeById() {
		Employee employee = Employee.builder().id(1L).firstName("raj").lastName("kumar").email("raj@123").build();
		when(dao.findById(1L)).thenReturn(Optional.of(employee));
		Optional<Employee> emp = employeeManagementService.getEmployeeById(1L);

		assertNotNull(emp);
		assertEquals(1, emp.get().getId());
	}

	@Test
	final void testSaveEmployee() {
		Employee employee = Employee.builder().id(1L).firstName("raj").lastName("kumar").email("raj@123").build();
		when(dao.save(any())).thenReturn(employee);
		Employee emp = employeeManagementService.saveEmployee(employee);

		assertNotNull(emp);
		assertEquals(employee.getFirstName(), emp.getFirstName());
	}

	@Test
	final void testDeleteEmployeeById() {
		doNothing().when(dao).deleteById(1L);
		employeeManagementService.deleteEmployeeById(1L);

		verify(dao, times(1)).deleteById(1L);
	}

}
