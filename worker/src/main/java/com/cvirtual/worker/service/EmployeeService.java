package com.cvirtual.worker.service;

import java.util.ArrayList;
import java.util.List;

import com.cvirtual.worker.adapter.DozerAdapter;
import com.cvirtual.worker.entity.Employee;
import com.cvirtual.worker.iservice.IEmployee;
import com.cvirtual.worker.persistence.repository.EmployeeRepository;
import com.cvirtual.worker.vo.v1.EmployeeVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployee{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public EmployeeVO save(Employee employee) {
		return DozerAdapter.parseObject(repository.save(employee), EmployeeVO.class);
	}

	@Override
	public EmployeeVO findById(Long id) {

		return DozerAdapter.parseObject(repository.findById(id).get(), EmployeeVO.class);
	}

	@Override
	public List<EmployeeVO> findAll() {
		List<EmployeeVO> listVO = new ArrayList<>();

        repository.findAll().forEach(e -> listVO.add(DozerAdapter.parseObject(e, EmployeeVO.class)));
		return listVO;
	}

	@Override
	public EmployeeVO findByName(String name) {
		return DozerAdapter.parseObject(repository.findByName(name), EmployeeVO.class);
	}

	@Override
	public void delete(Employee employee) {
		repository.delete(employee);
	}


}
