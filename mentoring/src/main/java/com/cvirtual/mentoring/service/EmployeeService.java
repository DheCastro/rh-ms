package com.cvirtual.mentoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvirtual.mentoring.adapter.DozerAdapter;
import com.cvirtual.mentoring.entity.Employee;
import com.cvirtual.mentoring.iservice.IEmployee;
import com.cvirtual.mentoring.persistence.repository.EmployeeRepository;
import com.cvirtual.mentoring.vo.v1.EmployeeVO;

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
