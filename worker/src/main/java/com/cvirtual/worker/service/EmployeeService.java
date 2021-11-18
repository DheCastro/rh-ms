package com.cvirtual.worker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvirtual.worker.adapter.DozerAdapter;
import com.cvirtual.worker.entity.Employee;
import com.cvirtual.worker.iservice.IEmployee;
import com.cvirtual.worker.persistence.repository.EmployeeRepository;
import com.cvirtual.worker.vo.v1.EmployeeVO;

@Service
public class EmployeeService implements IEmployee{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public EmployeeVO save(Employee employee) {
		
		EmployeeVO vo = DozerAdapter.parseObject(repository.save(employee), EmployeeVO.class);
		return vo;
	}

}
