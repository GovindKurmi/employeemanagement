package com.gk.springboot;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.gk.employee.management.controller.EmployeeManagementController;
import com.gk.employee.management.model.Employee;
import com.gk.employee.management.service.EmployeeManagementService;

@SpringBootTest
class EmployeeManagementControllerTest {

	@Mock
	private EmployeeManagementService employeeManagementService;

	@InjectMocks
	private EmployeeManagementController employeeManagementController;

	private MockMvc mockMvc;

	@BeforeAll
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(employeeManagementController).build();
	}

	@Test
	void testGetAllEmployees() throws Exception {
		List<Employee> expectedEmployees = new ArrayList<>();
		expectedEmployees.add(new Employee(1L, "John", "Doe", null, null, 0));
		expectedEmployees.add(new Employee(2L, "Jane", "Doe", null, null, 0));
		when(employeeManagementService.getAllEmployees()).thenReturn(expectedEmployees);

		mockMvc.perform(get("/rest/employee/getallemployee")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is(1))).andExpect(jsonPath("$[0].firstName", is("John")))
				.andExpect(jsonPath("$[0].lastName", is("Doe"))).andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].firstName", is("Jane"))).andExpect(jsonPath("$[1].lastName", is("Doe")));
	}

	@Test
	void testGetEmployeeById() throws Exception {
		Employee expectedEmployee = new Employee(1L, "John", "Doe", null, null, 0);
		when(employeeManagementService.getEmployeeById(1L)).thenReturn(Optional.of(expectedEmployee));

		mockMvc.perform(get("/rest/employee/getbyid/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.firstName", is("John"))).andExpect(jsonPath("$.lastName", is("Doe")));
	}

	@Test
	void testSaveEmployee() throws Exception {
		Employee employeeToSave = new Employee(null, "John", "Doe", null, null, 0);
		Employee expectedSavedEmployee = new Employee(1L, "John", "Doe", null, null, 0);
		when(employeeManagementService.saveEmployee(employeeToSave)).thenReturn(expectedSavedEmployee);

		mockMvc.perform(post("/rest/employee/addemployee").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"firstName\": \"John\", \"lastName\": \"Doe\" }")).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.firstName", is("John")))
				.andExpect(jsonPath("$.lastName", is("Doe")));
	}

	@Test
	void testDeleteEmployeeById() throws Exception {
		mockMvc.perform(delete("/rest/employee/delete/1")).andExpect(status().isOk());

		verify(employeeManagementService, times(1)).deleteEmployeeById(1L);
	}

}
