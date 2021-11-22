package com.cvirtual.worker.controller;

import java.util.List;

import com.cvirtual.worker.entity.Employee;
import com.cvirtual.worker.iservice.IEmployee;
import com.cvirtual.worker.vo.v1.EmployeeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployee employeeService;
    
    @GetMapping
    public ResponseEntity<List<EmployeeVO>> getAll() {
        List<EmployeeVO> list = employeeService.findAll();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeVO> getById(@PathVariable Long id) {
        EmployeeVO employee = employeeService.findById(id);
        HttpStatus status = employee == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(employee, status);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<EmployeeVO> getByName(@PathVariable String name) {
        EmployeeVO employee = employeeService.findByName(name);
        HttpStatus status = employee == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(employee, status);       
    }

    @PostMapping
    public ResponseEntity<EmployeeVO> add(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }
    
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Employee employee) {
        employeeService.delete(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

