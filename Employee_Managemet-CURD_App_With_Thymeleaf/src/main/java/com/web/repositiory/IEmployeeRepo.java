package com.web.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Long> {

}
