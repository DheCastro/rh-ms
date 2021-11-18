package com.cvirtual.worker.iservice;

import com.cvirtual.worker.entity.Employee;
import com.cvirtual.worker.vo.v1.EmployeeVO;

public interface IEmployee {

	public EmployeeVO save(Employee employee);
}
