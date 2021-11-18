package com.cvirtual.worker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvirtual.worker.entity.Employee;
import com.cvirtual.worker.iservice.IEmployee;
import com.cvirtual.worker.vo.v1.EmployeeVO;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployee employeeService;
    
    /**@GetMapping
    public HttpEntity<List<Employee>> getAll() {
        List<Employee> list = new ArrayList<>();

        employeeRepository.findAll().forEach(list::add);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<Employee> getById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        HttpStatus status = employee == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(employee, status);
    }

    @GetMapping("/name/{name}")
    public HttpEntity<Employee> getByName(@PathVariable String name) {
        Employee employee = employeeRepository.findByName(name);

        HttpStatus status = employee == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;

        return new ResponseEntity<>(employee, status);       
    }**/

    @PostMapping
    public void add(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeVO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}	
    
    /**@DeleteMapping
    public void delete(@RequestBody Employee employee) {
        employeeRepository.delete(employee);
    }**/
}
