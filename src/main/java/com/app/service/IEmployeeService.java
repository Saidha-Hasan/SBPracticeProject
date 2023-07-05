package com.app.service;

import java.util.List;

import com.app.entity.Employee;
import com.app.exception.EmployeeNotFoundException;

public interface IEmployeeService {

	Employee saveEmployee(Employee e);
	Employee getEmpById(Long id) throws EmployeeNotFoundException;
	List<Employee> getAllEmployees();
	String deleteEmpById(Long id) throws EmployeeNotFoundException;
	
}
