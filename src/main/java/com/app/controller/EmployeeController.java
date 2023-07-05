package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.exception.EmployeeNotFoundException;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp) {
		
		return service.saveEmployee(emp);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getEmployees() {
		
		return service.getAllEmployees();
	}
	
	@GetMapping("/getOne/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) throws EmployeeNotFoundException {
		return service.getEmpById(id);
	}
	
	@GetMapping("/deleteOne/{id}")
	public String deleteEmployeeById(@PathVariable("{id}") Long id) throws EmployeeNotFoundException {
		
		return service.deleteEmpById(id);
				
	}
}
