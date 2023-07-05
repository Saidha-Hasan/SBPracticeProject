package com.app.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findByEmpName(String empName);
		
}
