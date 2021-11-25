package com.cvirtual.worker.persistence.repository;

import com.cvirtual.worker.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    public Employee findByName(String name);
}
