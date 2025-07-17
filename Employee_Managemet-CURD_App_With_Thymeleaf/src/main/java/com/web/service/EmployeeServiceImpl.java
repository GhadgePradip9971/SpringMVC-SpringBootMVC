package com.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.web.model.Employee;
import com.web.repositiory.IEmployeeRepo;


@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	
	@Autowired
	private IEmployeeRepo repo;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.repo.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional=repo.findById(id);
		Employee employee=null;
		if(optional.isPresent()) {
			employee=optional.get();
		}else {
			throw new RuntimeException("Employee not found fo id::"+id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.repo.deleteById(id);
		
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {
		//create object for pageable
		Pageable pageble=PageRequest.of(pageNo -1, pageSize);
		return this.repo.findAll(pageble);
	}

	

}
