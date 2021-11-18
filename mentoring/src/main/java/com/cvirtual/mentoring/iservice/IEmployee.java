package com.cvirtual.mentoring.iservice;

import com.cvirtual.mentoring.entity.Employee;
import com.cvirtual.mentoring.vo.v1.EmployeeVO;

public interface IEmployee {

	public EmployeeVO save(Employee employee);
}
