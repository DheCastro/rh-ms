package com.cvirtual.worker.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.cvirtual.worker.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
    public Employee findByName(String name);
}
