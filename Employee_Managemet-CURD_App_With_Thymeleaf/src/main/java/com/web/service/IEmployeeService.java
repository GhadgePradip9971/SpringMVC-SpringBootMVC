package com.web.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.web.model.Employee;


public interface IEmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee (Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<Employee> findPaginated(int pageNo,int pageSize);

}
