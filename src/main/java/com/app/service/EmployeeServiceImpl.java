package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Employee;
import com.app.exception.EmployeeNotFoundException;
import com.app.repo.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public Employee saveEmployee(Employee e) {

		return repo.save(e);
	}

	@Override
	public Employee getEmpById(Long id) throws EmployeeNotFoundException {

		Optional<Employee> emp=repo.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		}
		
		else {
			throw new EmployeeNotFoundException("Employee Not Found.........!");
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public String deleteEmpById(Long id) throws EmployeeNotFoundException {
		if(repo.existsById(id)) {
		repo.deleteById(id);
		return "Employee removed with the id :" + id +" successfully!!";
		} else {
			throw new EmployeeNotFoundException("Employee Not Found.........!");
		}
	}

	
}
