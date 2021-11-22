package com.cvirtual.worker.iservice;

import java.util.List;

import com.cvirtual.worker.entity.Employee;
import com.cvirtual.worker.vo.v1.EmployeeVO;

public interface IEmployee {

	public EmployeeVO save(Employee employee);
	public EmployeeVO findById(Long id);
	public List<EmployeeVO> findAll();
	public EmployeeVO findByName(String name);
	public void delete(Employee employee);
}
