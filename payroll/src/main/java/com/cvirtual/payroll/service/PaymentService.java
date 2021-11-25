package com.cvirtual.payroll.service;

import com.cvirtual.payroll.entity.Payment;
import com.cvirtual.payroll.entity.Worker;
import com.cvirtual.payroll.feingclients.WorkerFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {

		Worker worker = workerFeignClient.getById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
