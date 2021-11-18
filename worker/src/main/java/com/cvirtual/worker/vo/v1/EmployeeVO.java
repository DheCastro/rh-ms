package com.cvirtual.worker.vo.v1;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeVO {

	private String name;
    private Date hireDate;
    private String jobName;
    private Double dailyIncome;
}
